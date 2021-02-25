package main;

import java.util.*;

public class Produto extends Thread {
	private ListaL l;
	private List<List<Integer>> listaDeListas;

	public Produto(ListaL l, List<List<Integer>> listadeListas) {
		this.l = l;
		this.listaDeListas = listadeListas;
	}

	@Override
	public void run() {
		for (int i = 0; i < listaDeListas.size(); i++) {
			System.out.println(i);
			l.produzir(getName(), listaDeListas.get(i));
		}
		try {

			sleep(50);
		} catch (Exception e) {

		}
	}

}
