package deque;

/**
 * implementazione della coda doppia collegata; rivedere!!!!!!!!
 * @author katia
 *
 */
public class CodaDoppiaCollegata implements CodaDoppia {
	
	private Record inizio = null;
	private Record fine = null;

	private class Record {
		Object elem;
		Record next;
		Record prev;

		Record(Object e) {
			elem = e;
			next = null;
			prev = null;
		}

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return inizio == null;
	}

/**
 * aggiunge un elemento in coda
 */
	@Override
	public void enDeque(Object e) {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			inizio = fine = new Record(e);
		} else {
			fine.next = new Record(e);
			fine.next.prev = fine;
			fine = fine.next;
		}
	}

	/**
	 * aggiunge un elemeno in testa
	 */
	@Override
	public void enHead(Object e) {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			inizio = fine = new Record(e);
		} else {
			inizio.prev = new Record(e);
			//inizio.prev.next = inizio;
			inizio = inizio.prev;
		}
	}

	/**
	 * restituisce il primo elemento in coda
	 */
	@Override
	public Object firstDeque() {
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Empty deque");
		return fine.elem;
	}

	/**
	 * restituisce il primo elemnto in testa
	 */
	@Override
	public Object firstHead() {
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Empty deque");
		return inizio.elem;
	}

	@Override
	public void deDeque() {
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Empty queue");
		fine = fine.prev;

	}

	@Override
	public void deHead() {
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Empty queue");
		inizio = inizio.prev;

	}
	
	private static void inizializza(CodaDoppia c){
		c.enHead("alfa");
		c.enHead("beta");
		c.enHead("gamma");
		c.enHead("delta");
		c.enHead("epsilon");
		c.enHead("tau");
		
	}
	

	public static void main(String[]args){
		CodaDoppia alfabeto = new CodaDoppiaCollegata();
		inizializza(alfabeto);
		try {
			System.out.println(alfabeto.firstHead());
			alfabeto.deHead();
			alfabeto.deHead();
			alfabeto.deHead();
			System.out.println(alfabeto.firstHead());

		} catch (EccezioneStrutturaVuota e) {
			System.out.println(e.getMessage());
		}
	
}

}
