package raddoppiamento_dimezzamento;

public interface Dizionario {

	public void insert(Object e, Comparable k);
	
	public void delete(Comparable k);
	
	public Object search(Comparable k);
}
