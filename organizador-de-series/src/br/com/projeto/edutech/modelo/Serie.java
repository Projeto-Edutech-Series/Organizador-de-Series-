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
	public static Integer ultimoID = 0;

	public Serie(JTextField nome, JComboBox<String> status, JTextField temporadas, JTextField episodios) {

		verificaInformacoes(nome, status, temporadas, episodios);

	}
	
	public Serie(String nome, String status, Integer temporadas, Integer episodios, Integer id) {
		this.nome = nome;
		this.status = status;
		this.temporadas = temporadas;
		this.episodios = episodios;
		this.id = id;
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTemporadas(Integer temporadas) {
		this.temporadas = temporadas;
	}

	public void setEpisodios(Integer episodios) {
		this.episodios = episodios;
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

	private void mostraMsg(String msg, String titulo, Integer msgTipo) {
		JOptionPane.showMessageDialog(null, msg, titulo, msgTipo);
		throw new InfoInvalidaException();
	}
}
