package hash;

public class HashDivisione implements Hash {

	@Override
	public int h(Comparable k, int n) {
		// TODO Auto-generated method stub
		return Math.abs(k.hashCode()) % n;
	}

}
