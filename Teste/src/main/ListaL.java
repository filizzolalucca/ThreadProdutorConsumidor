package main;

import java.util.Collections;
import java.util.List;

public class ListaL {
	public static List<Integer> list;
	private boolean disponivel;

	public ListaL(List<Integer> list) {
		this.list = list;
		this.disponivel = false;
	}

	public synchronized List<Integer> consumir(String idThread) {
		while (disponivel == false) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.disponivel = false;
		notifyAll();
		return this.list;

	}

	public synchronized void produzir(String idThread, List<Integer> list) {
		while (disponivel == true) {
			try {
				this.wait();
			} catch (Exception e) {

			}

		}
		Collections.sort(list);
		this.list = list;
		this.disponivel = true;
		notifyAll();

	}

}
