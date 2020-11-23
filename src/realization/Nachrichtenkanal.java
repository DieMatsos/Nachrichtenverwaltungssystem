package realization;

import interfaces.Observable;
import interfaces.Observer;
import interfaces.PaymentMethod;

import java.util.LinkedHashMap;

public class Nachrichtenkanal implements Observable {

    LinkedHashMap<Observer, PaymentMethod> kundenliste;
    int konto;
    private String name;

    public Nachrichtenkanal(String name) {
        this.kundenliste = new LinkedHashMap<>();
        this.name = name;
    }

    @Override
    public void addObserver(Observer observer, PaymentMethod method) {
        kundenliste.put(observer, method);
    }

    @Override
    public void removeObserver(Observer observer) {
        kundenliste.remove(observer);
    }

    @Override
    public void notifyObservers(String msg) {
        kundenliste.keySet().forEach(k -> k.update("[" + name + "] " + msg));
        askForMoney();
    }

    @Override
    public void receivePayment(int price) {
        konto += price;
    }

    private void askForMoney() {
        kundenliste.values().forEach(p -> {
            p.checkIfPayRequired(this);
        });
    }

    public String getStatistics() {
        return toString() + ": Kunden: " + kundenliste.size() + ", Geld: " + konto + "€";
    }

    public String toString() {
        return name;
    }

    public LinkedHashMap<Observer, PaymentMethod> getKundenliste() {
        return kundenliste;
    }
}