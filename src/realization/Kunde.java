package realization;

import interfaces.Observable;
import interfaces.Observer;
import interfaces.PaymentMethod;

public class Kunde implements Observer {

	private PaymentMethod paymentMethod;
	private String lastMsg;
	public String name;

	public Kunde(String name) {
		this.name = name;
		paymentMethod = null;
	}

	@Override
	public void update(String msg) {
		this.lastMsg = msg;
	}

	@Override
	public void subscribe(Observable observable) {
		if(paymentMethod == null) {
			throw new IllegalStateException("Kunde "+ this + " muss zuerst eine Paymentmethod festlegen!");
		}
		observable.addObserver(this, paymentMethod);
	}

	@Override
	public void unsubscribe(Observable observable) {
		observable.removeObserver(this);
	}

	@Override
	public void choosePayment(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getLastMsg() {
		return lastMsg;
	}
}