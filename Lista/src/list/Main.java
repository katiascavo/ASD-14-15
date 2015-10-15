package list;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		
		Lista<String> list = new ListDoubling<String>();
		System.out.println("la lista è vuota: " + list.isEmpty() + "\n");
		list.insert("a", list.firstList());
		list.insert("b", list.firstList());
		list.insert("c", list.firstList());
		list.insert("d", list.firstList());
		list.insert("e", list.firstList());
		System.out.println("inserisco f in seconda posizione \n");
		list.insert("f", list.succ(list.firstList()));
		System.out.println("Si stampa la lista");
		Posizione p = list.firstList();
		while (!list.endList(p)) {
			System.out.println(list.readList(p));
			p = list.succ(p);
		}
		System.out.println("\n rimoz. Elem. in prima posizione");
		list.remove(list.firstList());
		p = list.firstList();
		while (!list.endList(p)) {
			System.out.println(list.readList(p));
			p = list.succ(p);
		}

		Iterator<String> it = list.iterator();
		while (it.hasNext()){
			String obj = (String)it.next();
			System.out.println(obj);
		}
			for(String nome : list) {
					System.out.println(nome);
			}

	}
}
