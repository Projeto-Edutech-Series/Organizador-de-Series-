package br.com.projeto.edutech.interface_grafica;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Escritor {

	private String status;
	private String nome;
	private int temporadas;
	private int episodios;
	
	
	/**
	 * Adiciona a série com as informações fornecidas nos campos de texto e RadioButton a um arquivo txt.
	 */
	public boolean adiciona(JTextField campoNome, JTextField campoTemporadas, JTextField campoEpisodios, ButtonGroup grupoAlternativas) {
		try {
			if(verificaInformacoes(campoNome, campoTemporadas, campoEpisodios, grupoAlternativas)) {
				return false;
			}
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("series.txt"));
			
			bw.write(nome + ";");
			bw.write(temporadas + ";");
			bw.write(episodios + ";");
			bw.write(status + ";");
			bw.newLine();
			
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	private boolean verificaInformacoes(JTextField campoNome, JTextField campoTemporadas, JTextField campoEpisodios, ButtonGroup grupoAlternativas) {		
		if(!campoNome.getText().isEmpty()) {
			nome = campoNome.getText();
			
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum nome informado", mudaEncode("Informação não fornecida"), 1);
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

		
		if(!campoTemporadas.getText().isEmpty()) {
			try {
				temporadas = Integer.parseInt(campoTemporadas.getText());							
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, mudaEncode("O campo 'temporadas' deve conter um número"), mudaEncode("Informação incorreta"), 1);
			}
		} else {
			JOptionPane.showMessageDialog(null, mudaEncode("Número de temporadas não informado"), mudaEncode("Informação não fornecida"), 1);
			return true;
		}
		
		if(!campoEpisodios.getText().isEmpty()) {
			try {
				episodios = Integer.parseInt(campoEpisodios.getText());							
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, mudaEncode("O campo 'episódios' deve conter um número"), mudaEncode("Informação incorreta"), 1);
			}
		} else {		
			JOptionPane.showMessageDialog(null, mudaEncode("Número de episódios não informado"), mudaEncode("Informação não fornecida"), 1);
			return true;
		}
		
		return false;
	}
	
	public String mudaEncode(String str) {
		return new String(str.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
	}
}
