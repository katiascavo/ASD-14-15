package linked_structure;
public class ArrayDoubling implements Dizionario {

	private Coppia[] S = new Coppia[1];
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
			int i = 0;
			int j = 0;
			for (i = 0; i < n; i++) {
				if (k.compareTo(S[i].chiave) == 0) {
					break;
				}
			}
			for (j = i; j < n - 1; j++) {
				S[j] = S[j + 1];
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
}
