package realization;

import interfaces.Observable;
import interfaces.PaymentMethod;

public class PaymentSingle implements PaymentMethod {

    private final int price = 3;

    @Override
    public void checkIfPayRequired(Observable observable) {
        pay(observable);
    }

    @Override
    public void pay(Observable observable) {
        observable.receivePayment(price);
    }

}