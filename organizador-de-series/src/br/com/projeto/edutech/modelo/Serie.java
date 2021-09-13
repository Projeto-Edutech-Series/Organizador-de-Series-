package br.com.projeto.edutech.modelo;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Classe usada para representar uma série.
 * 
 * @author João Gabriel N Silva
 */
public class Serie {

	private String nome;
	private String status;
	private Integer temporadas;
	private Integer episodios;

	public Serie(JTextField nome, List<JRadioButton> status, JTextField temporadas, JTextField episodios) {

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

	private void verificaInformacoes(JTextField campoNome, List<JRadioButton> campoStatus, JTextField campoTemporadas,
			JTextField campoEpisodios) {
		if (!campoNome.getText().strip().isEmpty()) {
			this.nome = campoNome.getText().strip();

		} else {
			campoNome.setText(null);
			mostraMsgDeErro("Nenhum nome informado", "Informação não fornecida");
		}

		if (!campoTemporadas.getText().strip().isEmpty()) {
			try {
				this.temporadas = Integer.parseInt(campoTemporadas.getText().strip());
			} catch (Exception e) {
				campoTemporadas.setText(null);
				mostraMsgDeErro("O campo 'temporadas' deve conter um número", "Informação incorreta");
			}
		} else {
			campoTemporadas.setText(null);
			mostraMsgDeErro("Número de temporadas não informado", "Informação não fornecida");
		}

		if (!campoEpisodios.getText().strip().isEmpty()) {
			try {
				this.episodios = Integer.parseInt(campoEpisodios.getText().strip());
			} catch (Exception e) {
				campoEpisodios.setText(null);
				mostraMsgDeErro("O campo 'episódios' deve conter um número", "Informação incorreta");
			}
		} else {
			campoEpisodios.setText(null);
			mostraMsgDeErro("Número de episódios não informado", "Informacão não fornecida");
		}

		for (JRadioButton botao : campoStatus) {
			if (botao.isSelected()) {
				this.status = botao.getText();
			}
		}
		if(this.status == null) {
			mostraMsgDeErro("Status não informado", "Informação não fornecida");
		}

	}

	private void mostraMsgDeErro(String msg, String titulo) {
		JOptionPane.showMessageDialog(null, msg, titulo, 1);
		throw new InfoInvalidaException();
	}
}
