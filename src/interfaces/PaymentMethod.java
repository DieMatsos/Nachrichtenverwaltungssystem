package interfaces;

import realization.Nachrichtenkanal;

public interface PaymentMethod {

	void checkIfPayRequired(Observable observable);

	void pay(Observable observable);

}