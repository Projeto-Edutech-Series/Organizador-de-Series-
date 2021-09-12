package br.com.projeto.edutech.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.projeto.edutech.modelo.Serie;


/**
 * Classe usada para acessar as informaçõees das séries no arquivo txt.
 * @author João Gabriel N Silva
 */
public class SeriesDAO {
	
	private String arquivo;
	
	public SeriesDAO(String nomeArquivo) {
		this.arquivo = nomeArquivo;
	}

	public boolean adiciona(Serie serie) {
	
        try(FileWriter writer = new FileWriter(arquivo, true)) {
        	try(PrintWriter saida = new PrintWriter(writer, true)) {
        		saida.println(serie.getNome() + ";" + serie.getTemporadas() + ";" + serie.getEpisodios() + ";" + serie.getStatus());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

		return true;
	}
	


}

