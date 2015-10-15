package pila;
public class EccezioneStrutturaVuota extends RuntimeException {

	public EccezioneStrutturaVuota() {

	}

	public EccezioneStrutturaVuota(String messaggio) {
		super(messaggio);
	}
}
