package hash;

import linked_structure.Dizionario;

public class TabellaHash implements Dizionario {

	private Object S[];
	private Hash fHash;

	public TabellaHash(Hash f, int n) {
		S = new Object[n];
		fHash = f;
	}

	@Override
	public void insert(Object e, Comparable k) {
		// TODO Auto-generated method stub
		S[fHash.h(k,S.length)]=e;

	}

	@Override
	public void delete(Comparable k) {
		// TODO Auto-generated method stub
		S[fHash.h(k,S.length)]=null;

	}

	@Override
	public Object search(Comparable k) {
		// TODO Auto-generated method stub
		return S[fHash.h(k,S.length)];
	}

}
