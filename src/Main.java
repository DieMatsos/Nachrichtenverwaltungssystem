import realization.Kunde;
import realization.Nachrichtenkanal;
import realization.PaymentSingle;
import realization.PaymentTriple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    private List<Kunde> kunden = new ArrayList<>();
    private List<Nachrichtenkanal> kanaele = new ArrayList<>();

    public void dialog() {
        int eingabe = -1;
        while (eingabe != 0) {
            System.out.println("Was wollen Sie?\n"
                    + " (0) Programm beenden\n"
                    + " (1) neuen Kunden erstellen\n"
                    + " (2) neuen Nachrichtenkanal erstellen\n"
                    + " (3) Kunde abonniert Nachrichtenkanal\n"
                    + " (4) Nachrichtenkanalstatistik\n"
                    + " (5) Nachricht eines Nachrichtenkanals verändern");
            eingabe = new Scanner(System.in).nextInt();
            switch (eingabe) {
                case 1:
                    neuerKunde();
                    break;
                case 2:
                    neuerNachrichtenkanal();
                    break;
                case 3:
                    neuesAbonnement();
                    break;
                case 4:
                    nachrichtenkanalstatistik();
                    break;
                case 5:
                    nachrichtVeraendern();
                    break;
            }
        }
    }

    private String textEingeben(String aufforderung) {
        Scanner sc = new Scanner(System.in);
        System.out.print(aufforderung);
        String text = sc.nextLine();
        return text;
    }

    private int nummerwaehlen(int size) {
        int eingabe = -1;
        while (eingabe < 1 || eingabe > size)
            eingabe = new Scanner(System.in).nextInt();
        return eingabe;
    }

    private Nachrichtenkanal nachrichtenkanalWaehlen() {
        int i = 1;
        System.out.println("Welcher Nachrichtenkanal? ");
        for (Nachrichtenkanal n : kanaele)
            System.out.println(" (" + (i++) + ") " + n);
        return kanaele.get(nummerwaehlen(kanaele.size()) - 1);
    }

    private void nachrichtVeraendern() {
        Nachrichtenkanal nk = nachrichtenkanalWaehlen();
        nk.notifyObservers(textEingeben("Bitte eine Nachricht eingeben\n"));
    }

    private void nachrichtenkanalstatistik() {
        kanaele.forEach(k -> System.out.println(k.getStatistics()));
    }

    private void neuesAbonnement() {
        if (kunden.isEmpty()) {
            throw new IllegalStateException("Kundenliste ist leer");
        }
        int i = 1;
        System.out.println("Welcher Kunde? ");
        for (Kunde k : kunden)
            System.out.println(" (" + (i++) + ") " + k);
        Kunde kunde = kunden.get(nummerwaehlen(kunden.size()) - 1);
        Nachrichtenkanal nk = nachrichtenkanalWaehlen();
        kunde.subscribe(nk);
    }

    private void neuerNachrichtenkanal() {
        String name = textEingeben("Namen für Kanal eingeben\n");
        kanaele.add(new Nachrichtenkanal(name));
    }

    private void neuerKunde() {
        String name = textEingeben("Name für Kunden eingeben\n");
        Kunde k = new Kunde(name);
        System.out.println("Payment-Methode wählen\n"
                + " (0) Pro Nachricht 3€\n"
                + " (1) Alle 3 Nachrichten 9€");
        int eingabe = new Scanner(System.in).nextInt();
        switch (eingabe) {
            case 0:
                k.choosePayment(new PaymentSingle());
                break;
            case 1:
                k.choosePayment(new PaymentTriple());
                break;
            default:
                throw new IllegalArgumentException("Nummer " + eingabe + " ist nicht definiert");
        }
        kunden.add(k);
        System.out.println("Kunde \"" + name + "\" wurde angelegt");
        dialog();
    }

    public static void main(String[] args) {
        new Main().dialog();
    }

}