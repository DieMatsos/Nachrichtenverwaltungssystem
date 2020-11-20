package interfaces;

public interface Observer {


	void update();

	void subscribe(Observable observable);

	void unsubscribe( Observable observable);

	void choosePayment(PaymentMethod paymentMethod);

}