package uniba;

public class Dizionario {

	private Coppia[] S = new Coppia[0];

	private class Coppia {
		Object elem;
		Comparable chiave;

		Coppia(Object e, Comparable k) {
			elem = e;
			chiave = k;
		}
	}

	public void insert(Object e, Comparable k) {
		int i, j;
		Coppia[] temp = new Coppia[S.length + 1];
		for (i = 0; i < S.length; i++)
			temp[i] = S[i];
		S = temp;
		for (i = 0; i < S.length - 1; i++)
			if (k.compareTo(S[i].chiave) <= 0)
				break;
		for (j = S.length - 1; j > i; j--)
			S[j] = S[j - 1];
		S[i] = new Coppia(e, k);
	}

	public void delete(Comparable k) {

		if (search(k) != null) {
			int i = 0;
			Coppia[] temp = new Coppia[S.length - 1];
			for (i = 0; i < S.length - 2; i++) {
				if (!(S[i].chiave.equals(k))) {
					temp[i] = S[i];
				} else {
					break;
				}
			}
			for (int j = i; j < S.length - 1; j++) {
				temp[j] = S[j + 1];
			}

			S = temp;
		}
	}

	/**
	 * it allows you to print all pairs key-value
	 */
	public void print() {
		for (int i = 0; i < S.length; i++) {
			System.out.println(" KEY: " + S[i].chiave + " ITEM: " + S[i].elem);
		}
	}

	public Object search(Comparable k) {
		int i = 0;
		int j = S.length;
		while (i < j) {
			int m = (i + j) / 2;
			if (k.compareTo(S[m].chiave) == 0)
				return S[m].elem;
			else if (k.compareTo(S[m].chiave) < 0)
				j = m;
			else
				i = m + 1;
		}
		return null;
	}
}
