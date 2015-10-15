package hash;

import linked_structure.Dizionario;

public class TabellaHashApertaBis implements Dizionario {

	private Coppia S[];
	private Hash hFun;
	private Scansione cFun;
	Object canc = new Object();

	private class Coppia {
		Object elem;
		Comparable chiave;

		Coppia(Object e, Comparable k) {
			elem = e;
			chiave = k;
		}

		public String toString() {
			return chiave.toString() + ":" + elem.toString();
		}
	}

	TabellaHashApertaBis(Hash h, Scansione c, int m) {
		S = new Coppia[m];
		hFun = h;
		cFun = c;
	}

	@Override
	public void insert(Object e, Comparable k) {
		// TODO Auto-generated method stub
		int hk=hFun.h(k, S.length);
		for(int i=0;i<S.length;i++){
			int pos=cFun.c(hk, i, S.length);
			if(S[pos]==null || S[pos]==canc){
				S[pos]=new Coppia(e,k);
				return;
			}
		}
		System.out.println("Array Pieno");
		//System.exit(1);
	}

	@Override
	public void delete(Comparable k) {
		// TODO Auto-generated method stub
		int hk = hFun.h(k, S.length);
		for (int i = 0; i < S.length; i++) {
			int pos = cFun.c(hk, i, S.length);
			if (S[pos] == null)
				break;
			if (S[pos].chiave.compareTo(k) == 0 && S[pos].elem != canc) {
				S[pos].elem = canc;
				return;
			}
		}

	}

	@Override
	public Object search(Comparable k) {
		// TODO Auto-generated method stub
		int hk=hFun.h(k, S.length);
		for(int i=0;i<S.length;i++){
			int pos=cFun.c(hk, i, S.length);
			if (S[pos]==null){
				break;
			}
			if (S[pos].elem==canc) {
				System.out.print("Elemento cancellato");
			}
			if(S[pos].chiave.compareTo(k)==0 ){
				return S[pos].elem;
			}
		}
		return null;
		
	}

	private static void inizializza(Dizionario d) {
		d.insert("Pippo", "080123456");
		d.insert("Gi�", "080654321");
		d.insert("Lisa", "081123456");
		d.insert("Gennarino", "081654321");
		d.insert("Emy", "347112233");
	}

	public static void main(String[] args) {
		Dizionario rubrica = new TabellaHashApertaBis(new HashDivisione(),
				new ScansioneLineare(), 4);

		inizializza(rubrica);

		System.out.println(rubrica.search("081654321"));
		System.out.println(rubrica.search("081654323"));
		System.out.println(rubrica.search("081123456"));
		rubrica.delete("081123456");
		System.out.println(rubrica.search("081123456"));
	}

}
