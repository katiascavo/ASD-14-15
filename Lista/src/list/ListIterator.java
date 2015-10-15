package list;

import java.util.Iterator;

public class ListIterator<T> implements Iterator<T> {

	private Lista<T> list;
	private Posizione p;

	ListIterator(Lista<T> l) {
		list = l;
		p = l.firstList();
	}

	public boolean hasNext() {
		return !list.endList(p);
	}

	public T next() {
		Posizione q = p;
		p = list.succ(p);
		return list.readList(q);
	}

	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

}
