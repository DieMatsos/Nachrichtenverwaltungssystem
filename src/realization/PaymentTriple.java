package realization;

import interfaces.PaymentMethod;

public class PaymentTriple implements PaymentMethod {

	private int price = 9;
	private int count;
	private boolean paid;

	@Override
	public boolean payRequired() {
		if(count % 3 == 0) {
			pay();
			return true;
		}
		paid = false;
		return false;
	}

	@Override
	public void pay() {
		Nachrichtenkanal.receivePayment(price);
		paid = true;
	}

	@Override
	public boolean paymentComplete() {
		return paid;
	}
}