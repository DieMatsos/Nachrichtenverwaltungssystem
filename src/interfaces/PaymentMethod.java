package interfaces;

import realization.Nachrichtenkanal;

public interface PaymentMethod {

	boolean payRequired(Nachrichtenkanal nachrichtenkanal);

	void pay(Observable observable);

	boolean paymentComplete();

}