package main;

import java.io.IOException;
import java.util.*;

public class Main {
	private static List<List<Integer>> listas;

	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\lucca\\Desktop\\data.in.txt";
		ManipuladorArquivos man = new ManipuladorArquivos();

		// Ate aqui ta certo
		listas = man.leitor(path);

		ListaL l = new ListaL(listas.get(0));
		Produto p = new Produto(l, listas);
		Consumidor c = new Consumidor(l, listas);
		Consumidor c2 = new Consumidor(l, listas);
		p.start();
		c.start();
		c2.start();

	}
}
