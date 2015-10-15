package uniba;

public class TestDizionario {

	private static void inizializza(Dizionario d) {
		d.insert("katia", "93757");
		d.insert("Pippo","080123456");
		d.insert("Pippo2","080123458");
		d.insert("F", "6204920");
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dizionario rubrica = new Dizionario();
		inizializza(rubrica);
		rubrica.delete("ciao");
		rubrica.print();
	}

}
