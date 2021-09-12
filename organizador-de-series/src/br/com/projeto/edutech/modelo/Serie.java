package br.com.projeto.edutech.modelo;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Serie {
	
	private String nome;
	private String status;
	private Integer temporadas;
	private Integer episodios;

	public Serie(JTextField nome, ButtonGroup status, JTextField temporadas, JTextField episodios) {
		
		verificaInformacoes(nome, status, temporadas, episodios);
		
	}

	public String getNome() {
		return nome;
	}

	public String getStatus() {
		return status;
	}

	public Integer getTemporadas() {
		return temporadas;
	}

	public Integer getEpisodios() {
		return episodios;
	}
	

	private boolean verificaInformacoes(JTextField campoNome, ButtonGroup campoStatus, JTextField campoTemporadas, JTextField campoEpisodios) {		
		if(!campoNome.getText().strip().isEmpty()) {
			this.nome = campoNome.getText().strip();
			
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum nome informado", "Informação não fornecida", 1);
			campoNome.setText(null);
			return false;
		}
//				 a verificação do status precisa ser refeita
//		grupoAlternativas.getElements().asIterator().forEachRemaining(botao -> {
//			System.out.println(botao.getClass());
//			if(botao.isSelected()) {
//				status = botao.getText();
//			} else {
//				
//				JOptionPane.showMessageDialog(null, "Nenhum status selecionado", "Informação não fornecida", 1);
//				return;
//			}		
//		});

		
		if(!campoTemporadas.getText().strip().isEmpty()) {
			try {
				this.temporadas = Integer.parseInt(campoTemporadas.getText().strip());							
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "O campo 'temporadas' deve conter um número", "Informação incorreta", 1);
				campoTemporadas.setText(null);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Número de temporadas não informado", "Informação não fornecida", 1);
			campoTemporadas.setText(null);
			return false;
		}
		
		if(!campoEpisodios.getText().strip().isEmpty()) {
			try {
				this.episodios = Integer.parseInt(campoEpisodios.getText().strip());							
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "O campo 'episódios' deve conter um número", "Informação incorreta", 1);
				campoEpisodios.setText(null);
			}
		} else {		
			JOptionPane.showMessageDialog(null, "Número de episódios não informado", "Informacão não fornecida", 1);
			campoEpisodios.setText(null);
			return false;
		}
		
		return true;
	}
	

}
