package interfaces;

public interface Observer {


	void update(String msg);

	void subscribe(Observable observable);

	void unsubscribe( Observable observable);

	void choosePayment(PaymentMethod paymentMethod);

}