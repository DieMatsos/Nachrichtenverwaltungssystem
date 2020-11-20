package realization;

import interfaces.PaymentMethod;

public class PaymentSingle implements PaymentMethod {

	private double price = 3;

	@Override
	public boolean payRequired() {
		return true;
	}

	@Override
	public void pay() {
		//sendMoney
	}

	@Override
	public boolean paymentComplete() {
		return false;
	}
}