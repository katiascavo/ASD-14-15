package coda;

public class CodaCollegata<T> implements Coda<T> {

	private Record inizio = null;
	private Record fine = null;

	private class Record {
		T elem;
		Record next;

		Record(T e) {
			elem = e;
			next = null;
		}

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return inizio == null;
	}

	@Override
	public void enqueue(T e) {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			inizio = fine = new Record(e);
		} else {
			fine.next = new Record(e);
			fine = fine.next;
		}

	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Empty queue");
		return inizio.elem;
	}

	@Override
	public void dequeue() {
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Empty queue");
		inizio = inizio.next;

	}
	
	private static void inizializza(Coda<String> c){
		c.enqueue("alfa");
		c.enqueue("beta");
		c.enqueue("gamma");
		c.enqueue("delta");
		c.enqueue("epsilon");
		c.enqueue("tau");
		
	}
	

	public static void main(String[]args){
		Coda<String> alfabeto = new CodaCollegata<String>();
		inizializza(alfabeto);
		try {
			System.out.println(alfabeto.first());
			alfabeto.dequeue();
			alfabeto.dequeue();
			alfabeto.dequeue();
			System.out.println(alfabeto.first());

		} catch (EccezioneStrutturaVuota e) {
			System.out.println(e.getMessage());
		}
	
}

}
