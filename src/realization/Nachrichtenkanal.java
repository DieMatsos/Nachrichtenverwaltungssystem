package realization;

import interfaces.Observable;
import interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class Nachrichtenkanal implements Observable {

    List<Observer> kunden;
    int konto;
    private String name;

    public Nachrichtenkanal(List<Observer> kunden) {
        this.kunden = kunden;
    }

    public Nachrichtenkanal(String name) {
        this.kunden = new ArrayList<>();
        this.name = name;
    }

    @Override
    public void addObserver(Observer observer) {
        kunden.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        kunden.remove(observer);
    }

    @Override
    public void notifyObservers(String msg) {
        kunden.forEach(k -> {
            k.update(msg);
        });
    }
    public void receivePayment(int amount) {
        konto += amount;
    }

    public String getStatistics() {
        return toString() + ": Kunden: " + kunden.size() + ", Geld: " + konto + "€";
    }

    public String toString() {
        return name;
    }
}