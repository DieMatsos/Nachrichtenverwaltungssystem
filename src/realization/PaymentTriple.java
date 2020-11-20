package realization;

import interfaces.PaymentMethod;

public class PaymentTriple implements PaymentMethod {

	private double price = 9;
	private int count;

	@Override
	public boolean payRequired() {
		return count % 3 == 0;
	}

	@Override
	public void pay() {
		//TODO
	}

	@Override
	public boolean paymentComplete() {
		return false;
	}
}