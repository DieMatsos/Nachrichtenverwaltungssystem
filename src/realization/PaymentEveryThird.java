package realization;

import interfaces.Observable;
import interfaces.PaymentMethod;

public class PaymentEveryThird implements PaymentMethod {

    private final int price = 9;
    private int count;

    @Override
    public void checkIfPayRequired(Observable observable) {
        if( ++count % 3 == 0) {
            pay(observable);
        }
    }

    @Override
    public void pay(Observable observable) {
        observable.receivePayment(price);
    }

}