package interfaces;

public interface PaymentMethod {

	boolean payRequired();

	void pay();

	boolean paymentComplete();

}