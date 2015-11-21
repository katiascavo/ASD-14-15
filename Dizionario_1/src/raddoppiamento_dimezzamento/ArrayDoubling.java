package raddoppiamento_dimezzamento;

import linked_structure.Dizionario;

//raddoppiamento/dimezzamento
public class ArrayDoubling implements Dizionario {

	private static Coppia[] S = new Coppia[1];
	private int n = 0;

	private class Coppia {
		Object elem;
		Comparable chiave;

		Coppia(Object e, Comparable k) {
			elem = e;
			chiave = k;
		}
	}

	public void insert(Object e, Comparable k) {
		if (n == S.length) {
			Coppia[] temp = new Coppia[2 * S.length];
			for (int i = 0; i < n; i++)
				temp[i] = S[i];
			S = temp;
		}
		S[n] = new Coppia(e, k);
		n++;
	}

	public void delete(Comparable k) {

		if (search(k) != null) {
			int i;
			for (i = 0; i < n; i++) {
				if (k.compareTo(S[i].chiave) == 0) {
					S[i] = S[n-1];
				}
			}			
			n--;
			if ((n > 1) && (n <= S.length / 4)) {
				Coppia[] temp = new Coppia[S.length / 2];
				for (i = 0; i < n; i++) {
					temp[i] = S[i];
				}
				S = temp;
			}
		}
	}

	/**
	 * return null if key not found
	 */
	public Object search(Comparable k) {
		for (int i = 0; i < n; i++)
			if (k.compareTo(S[i].chiave) == 0)
				return S[i].elem;
		return null;
	}
	
	private static void inizializza(Dizionario d) {
		d.insert("katia", "93757");
		d.insert("Pippo","080123456");
		d.insert("Pippo2","080123458");
		d.insert("F", "6204920");
		d.insert("c", "ciao");
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dizionario rubrica = new ArrayDoubling();
		inizializza(rubrica);
		System.out.println(rubrica.search("080123456"));
		System.out.println(rubrica.search("080123458"));

		rubrica.delete("080123458");
		System.out.println(rubrica.search("080123458"));
		
	}
}
