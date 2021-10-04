package br.com.projeto.edutech.modelo;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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
	private Integer id;
	public static Integer ultimoID;

	public Serie(JTextField nome, JComboBox<String> status, JTextField temporadas, JTextField episodios) {
		verificaInformacoes(nome, status, temporadas, episodios);
	}
	
	public Serie(String nome, String status, Integer temporadas, Integer episodios, Integer id) {
		verificaInformacoes(nome, status, temporadas, episodios, id);
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
	
	public Integer getId() {
		return id;
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
				mostraMsg("O campo 'temporadas' deve conter um número", "Informação incorreta", JOptionPane.WARNING_MESSAGE);
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
				mostraMsg("O campo 'episódios' deve conter um número", "Informação incorreta", JOptionPane.WARNING_MESSAGE);
			}
		} else {
			campoEpisodios.setText(null);
			mostraMsg("Número de episódios não informado", "Informacão não fornecida", JOptionPane.WARNING_MESSAGE);
		}

		this.status = campoStatus.getSelectedItem().toString();
		campoStatus.setSelectedIndex(0);
	}
	
	private void verificaInformacoes(String campoNome, String campoStatus, Integer campoTemporadas, 
			Integer campoEpisodios, Integer id) {
		if (!campoNome.strip().isEmpty()) {
			this.nome = campoNome.strip();

		} else {
			mostraMsg("Nenhum nome informado", "Informação não fornecida", JOptionPane.WARNING_MESSAGE);
		}

		if (!campoTemporadas.toString().strip().isEmpty()) {
			try {
				this.temporadas = Integer.parseInt(campoTemporadas.toString().strip());
			} catch (Exception e) {
				mostraMsg("A coluna 'temporadas' deve conter um número", "Informação incorreta", JOptionPane.WARNING_MESSAGE);
			}
		} else {
			mostraMsg("Número de temporadas não informado", "Informação não fornecida", JOptionPane.WARNING_MESSAGE);
		}

		if (!campoEpisodios.toString().strip().isEmpty()) {
			try {
				this.episodios = Integer.parseInt(campoEpisodios.toString().strip());
			} catch (Exception e) {
				mostraMsg("A coluna 'episódios' deve conter um número", "Informação incorreta", JOptionPane.WARNING_MESSAGE);
			}
		} else {
			mostraMsg("Número de episódios não informado", "Informacão não fornecida", JOptionPane.WARNING_MESSAGE);
		}

		if (!campoStatus.strip().isEmpty()) {
			this.status = campoStatus.strip();
		} else {
			mostraMsg("Nenhum status informado", "Informação não fornecida",  JOptionPane.WARNING_MESSAGE);
		}
		
		this.id = id;
	}

	private void mostraMsg(String msg, String titulo, Integer msgTipo) {
		JOptionPane.showMessageDialog(null, msg, titulo, msgTipo);
		throw new InfoInvalidaException();
	}
}
