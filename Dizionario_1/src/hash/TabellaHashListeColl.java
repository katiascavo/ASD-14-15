package hash;

import linked_structure.Dizionario;
import linked_structure.StrutturaCollegata;

public class TabellaHashListeColl implements Dizionario {

	private StrutturaCollegata S[];
	Hash hFun;

	TabellaHashListeColl(Hash f, int n){
		hFun = f;
		S = new StrutturaCollegata[n];
		
	}
	@Override
	public void insert(Object e, Comparable k) {
		// TODO Auto-generated method stub
		int pos = hFun.h(k, S.length);
		if (S[pos] == null)
			S[pos] = new StrutturaCollegata();
		S[pos].insert(e, k);

	}

	@Override
	public void delete(Comparable k) {
		// TODO Auto-generated method stub
		int pos = hFun.h(k, S.length);
		if (S[pos] == null)
			return;
		S[pos].delete(k);

	}

	@Override
	public Object search(Comparable k) {
		// TODO Auto-generated method stub
		int pos = hFun.h(k, S.length);
		if (S[pos] != null)
			return S[pos].search(k);
		return null;
	}

	private static void inizializza(Dizionario d) {
		d.insert("Kate", "080123456");
		d.insert("Amber", "080654321");
		d.insert("Jhon", "081123456");
		d.insert("Steve", "347112233");
	}

	public static void main(String[] args) {
		Dizionario rubrica = new TabellaHashListeColl(new HashDivisione(), 3);
		inizializza(rubrica);
		System.out.println(rubrica.search("080123456"));
		System.out.println(rubrica.search("081654321"));
		System.out.println(rubrica.search("081123456"));
		System.out.println(rubrica.search("081654321"));
		System.out.println(rubrica.search("347122233"));
		System.out.println(rubrica.search("347112233"));

	}

}
