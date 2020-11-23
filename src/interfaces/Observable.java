package interfaces;

public interface Observable {


	void addObserver(Observer observer, PaymentMethod method);

	void removeObserver(Observer observer);

	void notifyObservers(String msg);

	void receivePayment(int money);

}