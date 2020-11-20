package realization;

import interfaces.PaymentMethod;

public class PaymentSingle implements PaymentMethod {

	private int price = 3;

	@Override
	public boolean payRequired() {
		return true;
	}

	@Override
	public void pay() {
		Nachrichtenkanal.receivePayment(price);
	}

	@Override
	public boolean paymentComplete() {
		return true;
	}
}