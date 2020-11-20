package realization;

import interfaces.Observable;
import interfaces.PaymentMethod;

public class PaymentSingle implements PaymentMethod {

	private int price = 3;

	@Override
	public boolean payRequired(Nachrichtenkanal nachrichtenkanal) {
		pay(nachrichtenkanal);
		return true;
	}

	@Override
	public void pay(Observable kanal) {
		kanal.receivePayment(price);

	}

	@Override
	public boolean paymentComplete() {
		return true;
	}
}