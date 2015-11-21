package linked_structure;

//struttura circolare doppiamente collegata
public class StrutturaCollegata implements Dizionario {

	private Record list = null;

	private final class Record {
		public Object elem;
		public Comparable chiave;
		public Record next;
		public Record prev;

		public Record(Object e, Comparable k) {
			elem = e;
			chiave = k;
			next = prev = null;
		}
	}

	@Override
	public void insert(Object e, Comparable k) {
		// TODO Auto-generated method stub
		Record p = new Record(e, k);
		if (list == null)
			list = p.prev = p.next = p;
		else {
			p.next = list.next;
			list.next.prev = p;
			list.next = p;
			p.prev = list;
		}

	}

	@Override
	public void delete(Comparable k) {
		// TODO Auto-generated method stub
		if (list == null)
			throw new EmptyList("lista vuota");
		if ((search(k) != null)) {
			if (list.next.chiave == list.chiave)// se è unico punta a se stesso
				list = null;
			else if (list.chiave.equals(k)) {//se è il primo elemento
				list.prev.next = list.next;
				list.next.prev = list.prev;
				list = list.next;
			} else {
				for (Record p = list;; p = p.next) {
					if (p.chiave.equals(k)) {
						p.prev.next = p.next;
						p.next.prev = p.prev;
						break;
					}
				}
			}
		} else
			throw new EmptyKey("chiave non presente");
	}

	@Override
	public Object search(Comparable k) {
		if (list == null)
			return null;
		for (Record p = list;; p = p.next) {
			if (p.chiave.equals(k))
				return p.elem;
			if (p == list.prev)
				return null;
		}
	}

	private static void inizializza(Dizionario d) {

//		d.insert("Pippo", "080123456");
//		d.insert("Giò", "080654321");
//		d.insert("Lisa", "081123456");
		d.insert("Gennarino", "081654321");
		d.insert("Emy", "347112233");
	}

	public static void main(String[] args) {
		Dizionario rubrica = new StrutturaCollegata();
		inizializza(rubrica);

		System.out.println(rubrica.search("081654321"));
		System.out.println(rubrica.search("347112233"));

		rubrica.delete("081654321");
		System.out.println(rubrica.search("081654321"));
//		System.out.println(rubrica.search("347112233"));
//		System.out.println(rubrica.search("081123456"));
//
//		rubrica.delete("081123456");
//		System.out.println(rubrica.search("081123456"));
//
//		System.out.println(rubrica.search("080123456"));
//
//		// rubrica.delete("080123456");
//		System.out.println(rubrica.search("080123456"));

	}

}
