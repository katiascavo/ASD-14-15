package deque;

public class EccezioneStrutturaVuota extends RuntimeException {

	public EccezioneStrutturaVuota() {

	}

	public EccezioneStrutturaVuota(String message) {
		super(message);
	}
}
