package main;

import java.io.IOException;
import java.util.List;

public class Consumidor extends Thread {
	ListaL l;
	private List<List<Integer>> listaDeListas;
	ManipuladorArquivos manA = new ManipuladorArquivos();

	public Consumidor(ListaL l, List<List<Integer>> listadeListas) {
		this.l = l;
		this.listaDeListas = listadeListas;
	}

	@Override
	public void run() {
		List<Integer> listaOrdenada;
		for (int i = 0; i < listaDeListas.size(); i++) {
			listaOrdenada = l.consumir(this.getName());
			try {
				manA.escritor("C:\\Users\\lucca\\Desktop\\ordenado.txt", listaOrdenada);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				sleep(100);
			} catch (Exception e) {
				// fodas
			}
		}

	}
}
