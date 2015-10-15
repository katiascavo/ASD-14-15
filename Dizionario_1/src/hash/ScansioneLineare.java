package hash;

public class ScansioneLineare implements Scansione{

	@Override
	public int c(int hk, int i, int n) {
		// TODO Auto-generated method stub
		return ((hk+i) % n);
	}

}
