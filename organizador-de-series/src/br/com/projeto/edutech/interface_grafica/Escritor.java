package br.com.projeto.edutech.interface_grafica;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 * Classe usada para escrever as informações fornecidas pelo usuário em um arquivo txt.
 * @author Joao Gabriel N Silva
 */
public class Escritor {
	
	private String status;
	private String nome;
	private int temporadas;
	private int episodios;
	
	
	/**
	 * Adiciona a série com as informações fornecidas nos campos de texto e RadioButton a um arquivo txt.
	 * 
	 * @param campoNome Campo de texto do nome da série.
	 * @param campoTemporadas Campo de texto do número de temporadas.
	 * @param campoEpisodios Campo de texto do número de episódios.
	 * @param grupoAlternativas Grupo de botões com os botões de status.
	 * 
	 * @return Retorna true se passar pelo verificação e a série for adicionada sem problemas.
	 */
	public boolean adiciona(JTextField campoNome, JTextField campoTemporadas, JTextField campoEpisodios, ButtonGroup grupoAlternativas) {
		try {
			if(verificaInformacoes(campoNome, campoTemporadas, campoEpisodios, grupoAlternativas)) {
				return false;
			}
			
	        FileWriter writer;

	        try {
	            writer = new FileWriter("series.txt", true);
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }

	        PrintWriter saida = new PrintWriter(writer, true);
	        saida.println(nome + ";" + temporadas + ";" + episodios + ";" + status);	        
	        saida.close();
	        writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * Faz a verificação das informações recebidas dos campos de texto e RadioButton.
	 * 
	 * @param campoNome Campo de texto do nome da série.
	 * @param campoTemporadas Campo de texto do número de temporadas.
	 * @param campoEpisodios Campo de texto do número de episódios.
	 * @param grupoAlternativas Grupo de botões com os botões de status.
	 * 
	 * @return Retorna true se houver algo de errado com os dados fornecidos. Por exemplo nome em branco, ou uma letra 
	 * onde deveria ser um número.
	 */
	private boolean verificaInformacoes(JTextField campoNome, JTextField campoTemporadas, JTextField campoEpisodios, ButtonGroup grupoAlternativas) {		
		if(!campoNome.getText().strip().isEmpty()) {
			nome = campoNome.getText().strip();
			
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum nome informado", mudaEncode("Informação não fornecida"), 1);
			campoNome.setText(null);
			return true;
		}
				// a verificação do status precisa ser refeita
//		grupoAlternativas.getElements().asIterator().forEachRemaining(botao -> {
//			System.out.println(botao.getClass());
//			if(botao.isSelected()) {
//				status = botao.getText();
//			} else {
//				
//				JOptionPane.showMessageDialog(null, "Nenhum status selecionado", mudaEncode("Informação não fornecida"), 1);
//				return;
//			}		
//		});

		
		if(!campoTemporadas.getText().strip().isEmpty()) {
			try {
				temporadas = Integer.parseInt(campoTemporadas.getText().strip());							
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, mudaEncode("O campo 'temporadas' deve conter um número"), mudaEncode("Informação incorreta"), 1);
				campoTemporadas.setText(null);
			}
		} else {
			JOptionPane.showMessageDialog(null, mudaEncode("Número de temporadas não informado"), mudaEncode("Informação não fornecida"), 1);
			campoTemporadas.setText(null);
			return true;
		}
		
		if(!campoEpisodios.getText().strip().isEmpty()) {
			try {
				episodios = Integer.parseInt(campoEpisodios.getText().strip());							
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, mudaEncode("O campo 'episódios' deve conter um número"), mudaEncode("Informação incorreta"), 1);
				campoEpisodios.setText(null);
			}
		} else {		
			JOptionPane.showMessageDialog(null, mudaEncode("Número de episódios não informado"), mudaEncode("Informação não fornecida"), 1);
			campoEpisodios.setText(null);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Muda o encode da String recebida para UTF-8.
	 * 
	 * @param str String que tera seu encode alterado.
	 */
	public String mudaEncode(String str) {
		return new String(str.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
	}
}
