package realization;

import interfaces.Observable;
import interfaces.Observer;

import java.util.ArrayList;
import java.util.List;
public class Nachrichtenkanal implements Observable {

	List<Observer> kunden;
	static int konto;

	public Nachrichtenkanal(List<Observer> kunden) {
		this.kunden = kunden;
	}

	public Nachrichtenkanal()
	{
		this.kunden = new ArrayList<>();
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
	public void notifyObservers() {
		kunden.forEach( k -> {
				k.update("News ALERT!");
		});
	}

	static void receivePayment(int amount) {
		konto += amount;
	}
}