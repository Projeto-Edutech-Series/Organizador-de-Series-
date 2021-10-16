package br.com.projeto.edutech.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import br.com.projeto.edutech.modelo.InfoInvalidaException;
import br.com.projeto.edutech.modelo.Serie;

/**
 * Classe usada para acessar as informaçõees das séries no arquivo txt.
 * 
 * @author João Gabriel N Silva
 */
public class SeriesDAO {

	private File arquivo = new File("C://ATDB//series.csv");

	public boolean adiciona(Serie serie, boolean append) {
		pathBuilder();
		try (FileWriter writer = new FileWriter(arquivo, true)) {
			try (PrintWriter saida = new PrintWriter(writer, true)) {
				saida.println(serie.getNome() + ";" + serie.getTemporadas() + ";" + serie.getEpisodios() + ";"
						+ serie.getStatus().toUpperCase());
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Serie> listar() {
		pathBuilder();
		List<Serie> lista = new ArrayList<>();

		try {

			Scanner scanner = new Scanner(arquivo, "UTF-8");

			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine();

				Scanner linhaScanner = new Scanner(linha);
				linhaScanner.useDelimiter(";");

				String nomeSerie = linhaScanner.next();
				Integer temporadas = linhaScanner.nextInt();
				Integer episodios = linhaScanner.nextInt();
				String status = linhaScanner.next();

				lista.add(new Serie(nomeSerie, status, temporadas, episodios));

				linhaScanner.close();
			}
			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public void alterar(String nomeNovo, String statusNovo, Integer temporadasNova,
			Integer episodiosNovo) {
		List<Serie> series = listar();
		try {
			new FileWriter(arquivo).close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		for (Serie serie : series) {
//			if (idSerie.equals(serie.getId())) {
				try {
//					serie = new Serie(nomeNovo, statusNovo, temporadasNova, episodiosNovo, idSerie);
					adiciona(serie, false);

				} catch (InfoInvalidaException e) {

					try {
						new FileWriter(arquivo).close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					for (Serie serie2 : series) {
						adiciona(serie2, false);
					}

					throw new RuntimeException(e);
				}
//			} else {
				adiciona(serie, false);
			}

		}
//	}

	public void deletar(String nome) {
		List<Serie> series = listar();
		try {
			new FileWriter(arquivo).close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		for (Serie serie : series) {
			if (serie.getNome().equals(nome)) {
			} else {
				adiciona(serie, true);
			}
		}
	}

	public void pathBuilder() {
		try {
			if (!arquivo.exists()) {
				Files.createDirectories(Paths.get("C:\\ATDB"));
				try (FileWriter writer = new FileWriter(arquivo, true)) {}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public boolean jaExiste(Serie serie) {
		return new HashSet<Serie>(listar()).contains(serie);
	}

}
