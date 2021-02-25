package main;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class ManipuladorArquivos {

	public static List<List<Integer>> listadeListas;

	public ManipuladorArquivos() {
		listadeListas = new ArrayList<>();
	}

	public static List<List<Integer>> leitor(String path) throws IOException {

		// Ta certo Ate o momento
		List<Integer> listaInteiros = new ArrayList<>();
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = buffRead.readLine();
		while (true) {
			if (linha != null) {
				try {

					int x = Integer.parseInt(linha);
					listaInteiros.add(x);

					// System.out.println(x);
				} catch (Exception e) {
					// teve quebra de linha
				}

				if (linha.isEmpty()) {

					listadeListas.add(listaInteiros);
					listaInteiros = new ArrayList<>();

				}

			} else {
				break;
			}
			// Verifica se a proxima linha não for vazia ele passa para a proxima
			linha = buffRead.readLine();
		}
		buffRead.close();
		return listadeListas;
	}

	public static void escritor(String path, List<Integer> list) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true));
		buffWrite.append("\n");
		for (int i = 0; i < list.size(); i++) {
			int linha = list.get(i);
			buffWrite.append(linha + "\n");
		}
		buffWrite.close();
	}

}
