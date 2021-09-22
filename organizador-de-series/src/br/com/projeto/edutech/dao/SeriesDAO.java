package br.com.projeto.edutech.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.projeto.edutech.modelo.Serie;

/**
 * Classe usada para acessar as informaçõees das séries no arquivo txt.
 * 
 * @author João Gabriel N Silva
 */
public class SeriesDAO {

	private File arquivo = new File("series.csv");

	public boolean adiciona(Serie serie, boolean append) {

		try (FileWriter writer = new FileWriter(arquivo, true)) {
			try (PrintWriter saida = new PrintWriter(writer, true)) {
				
				Integer id;
				if (append) {
					id = Serie.ultimoID;
					Serie.ultimoID++;
				} else {
					id = serie.getId();
				}
				saida.println(id + ";" + serie.getNome() + ";" + serie.getTemporadas() + ";"
						+ serie.getEpisodios() + ";" + serie.getStatus().toUpperCase());
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Serie> listar() {
		List<Serie> lista = new ArrayList<>();

		try {

			Scanner scanner = new Scanner(arquivo, "UTF-8");

			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine();

				Scanner linhaScanner = new Scanner(linha);
				linhaScanner.useDelimiter(";");

				String id = linhaScanner.next();
				String nomeSerie = linhaScanner.next();
				Integer temporadas = linhaScanner.nextInt();
				Integer episodios = linhaScanner.nextInt();
				String status = linhaScanner.next();

				lista.add(new Serie(nomeSerie, status, temporadas, episodios, Integer.parseInt(id)));

				linhaScanner.close();
			}
			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public void alterar(Integer idSerie, String nomeNovo, String statusNovo, Integer temporadasNova,
			Integer episodiosNovo) {
		List<Serie> series = listar();
		try {
			new FileWriter(arquivo);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		for (Serie serie : series) {
			if (idSerie.equals(serie.getId())) {
				serie.setNome(nomeNovo);
				serie.setStatus(statusNovo);
				serie.setTemporadas(temporadasNova);
				serie.setEpisodios(episodiosNovo);
			}
			adiciona(serie, false);

		}
	}
}
