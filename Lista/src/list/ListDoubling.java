package list;

import java.util.Iterator;

public class ListDoubling<T> implements Lista<T> {

	private Object[] L = new Object[1];
	private int n = 0;

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return n == 0;
	}

	@Override
	public T readList(Posizione p) {
		// TODO Auto-generated method stub
		if (!checkPosition(p))
			throw new IndexOutOfBoundsException("posizione non valida");
		return (T)L[((Indice) p).indice];
	}

	@Override
	public void writeList(T e, Posizione p) {
		// TODO Auto-generated method stub
		if (!checkPosition(p))
			throw new IndexOutOfBoundsException(
					"Posizione di inserimento non valida");
		L[((Indice) p).indice] = e;
	}

	@Override
	public Posizione firstList() {
		// TODO Auto-generated method stub
		return new Indice();
	}

	@Override
	public boolean endList(Posizione p) {
		// TODO Auto-generated method stub
		return ((Indice) p).indice == n;
	}

	@Override
	public Posizione succ(Posizione p) {
		// TODO Auto-generated method stub
		if (endList(p))
			throw new IndexOutOfBoundsException(((Indice) p).indice
					+ " e' ultima posizione della lista");
		Indice pos = new Indice();
		pos.indice = ((Indice) p).indice + 1;
		return pos;
	}

	@Override
	public Posizione pred(Posizione p) {
		// TODO Auto-generated method stub
		if (n == 0)
			throw new IndexOutOfBoundsException(((Indice) p).indice
					+ " e' ultima posizione della lista");

		Posizione pos = new Indice();
		((Indice) pos).indice = ((Indice) p).indice - 1;
		return pos;

	}

	@Override
	public void insert(T e, Posizione p) {
		// TODO Auto-generated method stub
		if (!checkPosition(p))
			throw new IndexOutOfBoundsException(
					"Posizione di inserimento non valida");
		for (int i = n; i > ((Indice) p).indice; i--)
			L[i] = L[i - 1];
		L[((Indice) p).indice] = e;
		n++;
		if (n == L.length) {
			Object[] temp = new Object[2 * L.length];
			for (Indice pos = (Indice) firstList(); !endList(pos); pos = (Indice) succ(pos))
				temp[pos.indice] = L[pos.indice];
			L = temp;
		}

	}

	@Override
	public void remove(Posizione p) {
		// TODO Auto-generated method stub
		if (!checkPosition(p))
			throw new IndexOutOfBoundsException(
					"Posizione di rimozione non valida");
		for (int i = ((Indice) p).indice; i < n - 1; i++)
			L[i] = L[i + 1];
		n--;
		if (n == L.length / 4 && n > 1) {
			Object[] temp = new Object[L.length / 2];
			for (Indice pos = (Indice) firstList(); !endList(pos); pos = (Indice) succ(pos))
				temp[pos.indice] = L[pos.indice];
			L = temp;
		}

	}

	protected boolean checkPosition(Posizione p) {
		if (((Indice) p).indice < 0 || ((Indice) p).indice > n)
			return false;
		else
			return true;
	}
	
	public Iterator<T> iterator() {
		return new ListIterator(this);
		}
}
