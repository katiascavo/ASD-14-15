package pila;
//raddoppiamento/dimezzamento
public class PilaArray<T> implements Pila<T> {

	private Object S[] = new Object[1];
	// numero di elementi nella pila
	private int n = 0;

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return n == 0;
	}

	@Override
	public void push(T e) {
		// TODO Auto-generated method stub
		S[n] = e;
		n++;
		if (n == S.length) {
			Object[] temp = new Object[S.length * 2];
			System.arraycopy(S, 0, temp, 0, n);
			S = temp;
		}
	}

	@Override
	public T top() {
		// TODO Auto-generated method stub
		if (n == 0)
			throw new EccezioneStrutturaVuota("Struttura vuota");
		return (T)S[n - 1];
	}

	@Override
	public void pop() {
		// TODO Auto-generated method stub
		if (n == 0)
			throw new EccezioneStrutturaVuota("Struttura vuota");
		S[n - 1] = null;
		n--;
		if (n == S.length / 4 && n >= 1) {
			Object[] temp = new Object[S.length / 2];
			for (int i = 0; i < n; i++) {
				temp[i] = S[i];
			}
			S = temp;
		}

	}

	public static void inizializza(Pila<String> p) {
		p.push("alfa");
		p.push("beta");
		p.push("gamma");
		p.push("delta");
		p.push("epsilon");
		p.push("eta");
	}

	public static void main(String[] args) {
		Pila<String> alfabeto = new PilaArray<String>();
		inizializza(alfabeto);
		try {
			System.out.println(alfabeto.top());
			alfabeto.pop();
			alfabeto.pop();
			alfabeto.pop();
			System.out.println(alfabeto.top());

		} catch (EccezioneStrutturaVuota e) {
			System.out.println(e.getMessage());
		}

	}
}
