package br.com.projeto.edutech.modelo;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Classe usada para representar uma série.
 * 
 * @author João Gabriel N Silva
 */
public class Serie implements Comparable<Serie> {

	private String nome;
	private String status;
	private Integer temporadas;
	private Integer episodios;

	public Serie(JTextField nome, JComboBox<String> status, JTextField temporadas, JTextField episodios) {
		verificaInformacoes(nome, status, temporadas, episodios);
	}

	public Serie(String nome, String status, Integer temporadas, Integer episodios) {
		verificaInformacoes(nome, status, temporadas, episodios);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serie other = (Serie) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
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

	private void verificaInformacoes(JTextField campoNome, JComboBox<String> campoStatus, JTextField campoTemporadas,
			JTextField campoEpisodios) {
		if (!campoNome.getText().strip().isEmpty()) {
			this.nome = campoNome.getText().strip();

		} else {
			campoNome.setText("");
			mostraMsg("Nenhum nome informado", "Informação não fornecida", JOptionPane.WARNING_MESSAGE);
		}

		if (!campoTemporadas.getText().strip().isEmpty()) {
			try {
				this.temporadas = Integer.parseInt(campoTemporadas.getText().strip());
			} catch (Exception e) {
				campoTemporadas.setText("");
				mostraMsg("O campo 'temporadas' deve conter um número", "Informação incorreta",
						JOptionPane.WARNING_MESSAGE);
			}
		} else {
			campoTemporadas.setText("");
			mostraMsg("Número de temporadas não informado", "Informação não fornecida", JOptionPane.WARNING_MESSAGE);
		}

		if (!campoEpisodios.getText().strip().isEmpty()) {
			try {
				this.episodios = Integer.parseInt(campoEpisodios.getText().strip());
			} catch (Exception e) {
				campoEpisodios.setText("");
				mostraMsg("O campo 'episódios' deve conter um número", "Informação incorreta",
						JOptionPane.WARNING_MESSAGE);
			}
		} else {
			campoEpisodios.setText(null);
			mostraMsg("Número de episódios não informado", "Informacão não fornecida", JOptionPane.WARNING_MESSAGE);
		}

		this.status = campoStatus.getSelectedItem().toString();
	}

	private void verificaInformacoes(String campoNome, String campoStatus, Integer campoTemporadas,
			Integer campoEpisodios) {
		if (!campoNome.strip().isEmpty()) {
			this.nome = campoNome.strip();

		} else {
			mostraMsg("Nenhum nome informado", "Informação não fornecida", JOptionPane.WARNING_MESSAGE);
		}

		if (!campoTemporadas.toString().strip().isEmpty()) {
			try {
				this.temporadas = Integer.parseInt(campoTemporadas.toString().strip());
			} catch (Exception e) {
				mostraMsg("A coluna 'temporadas' deve conter um número", "Informação incorreta",
						JOptionPane.WARNING_MESSAGE);
			}
		} else {
			mostraMsg("Número de temporadas não informado", "Informação não fornecida", JOptionPane.WARNING_MESSAGE);
		}

		if (!campoEpisodios.toString().strip().isEmpty()) {
			try {
				this.episodios = Integer.parseInt(campoEpisodios.toString().strip());
			} catch (Exception e) {
				mostraMsg("A coluna 'episódios' deve conter um número", "Informação incorreta",
						JOptionPane.WARNING_MESSAGE);
			}
		} else {
			mostraMsg("Número de episódios não informado", "Informacão não fornecida", JOptionPane.WARNING_MESSAGE);
		}

		if (!campoStatus.strip().isEmpty()) {
			this.status = campoStatus.strip();
		} else {
			mostraMsg("Nenhum status informado", "Informação não fornecida", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void mostraMsg(String msg, String titulo, Integer msgTipo) {
		JOptionPane.showMessageDialog(null, msg, titulo, msgTipo);
		throw new InfoInvalidaException();
	}

	@Override
	public int compareTo(Serie serie) {
		return this.nome.compareTo(serie.nome);
	}
	

}
