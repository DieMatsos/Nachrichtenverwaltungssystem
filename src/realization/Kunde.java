package realization;

import interfaces.Observable;
import interfaces.Observer;
import interfaces.PaymentMethod;

public class Kunde implements Observer {

	private PaymentMethod paymentMethod;

	public Kunde() {
		paymentMethod = null;
	}

	public Kunde(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public void update(String msg) {
		System.out.println("Wow I like these news: " + msg);
		paymentMethod.payRequired();
	}

	@Override
	public void subscribe(Observable observable) {
		if(paymentMethod == null) {
			throw new IllegalStateException("Kunde "+ this + " muss zuerst eine Paymentmethod festlegen!");
		}
		observable.addObserver(this);
	}

	@Override
	public void unsubscribe(Observable observable) {
		observable.removeObserver(this);
	}

	@Override
	public void choosePayment(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
}