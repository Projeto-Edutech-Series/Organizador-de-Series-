package br.com.projeto.edutech.interface_grafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import br.com.projeto.edutech.dao.SeriesDAO;
import br.com.projeto.edutech.modelo.Serie;
import javax.swing.UIManager;

public class ViewMenuConsultar {

	private JFrame frmMenuConsultar;
	private DefaultTableModel modelo;
	private JTable tabela;
	private SeriesDAO serieDAO = new SeriesDAO();
	private JButton botaoAlterar;
	private JButton botaoDeletar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMenuConsultar window = new ViewMenuConsultar();
					window.frmMenuConsultar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewMenuConsultar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenuConsultar = new JFrame();
		frmMenuConsultar.setFont(new Font("Arial", Font.BOLD, 12));
		frmMenuConsultar.setTitle("Menu consultar");
		frmMenuConsultar.setResizable(false);
		frmMenuConsultar.getContentPane().setFont(new Font("SansSerif", Font.PLAIN, 12));
		frmMenuConsultar.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmMenuConsultar.setBounds(100, 100, 661, 515);
		frmMenuConsultar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenuConsultar.setLocation(600, 200);
		frmMenuConsultar.getContentPane().setLayout(null);

		JLabel textoId = new JLabel("ID");
		textoId.setFont(new Font("SansSerif", Font.BOLD, 13));
		textoId.setHorizontalAlignment(SwingConstants.LEFT);
		textoId.setBounds(37, 60, 43, 14);
		frmMenuConsultar.getContentPane().add(textoId);

		JLabel textoNome = new JLabel("NOME");
		textoNome.setHorizontalAlignment(SwingConstants.CENTER);
		textoNome.setFont(new Font("SansSerif", Font.BOLD, 13));
		textoNome.setBounds(140, 60, 63, 14);
		frmMenuConsultar.getContentPane().add(textoNome);

		JLabel textoStatus = new JLabel("STATUS");
		textoStatus.setHorizontalAlignment(SwingConstants.CENTER);
		textoStatus.setFont(new Font("SansSerif", Font.BOLD, 13));
		textoStatus.setBounds(256, 59, 63, 14);
		frmMenuConsultar.getContentPane().add(textoStatus);

		JLabel textoTemporadas = new JLabel("TEMPORADAS");
		textoTemporadas.setHorizontalAlignment(SwingConstants.CENTER);
		textoTemporadas.setFont(new Font("SansSerif", Font.BOLD, 13));
		textoTemporadas.setBounds(376, 59, 91, 14);
		frmMenuConsultar.getContentPane().add(textoTemporadas);

		JLabel textoEpisodios = new JLabel("EPISÓDIOS");
		textoEpisodios.setHorizontalAlignment(SwingConstants.CENTER);
		textoEpisodios.setFont(new Font("SansSerif", Font.BOLD, 13));
		textoEpisodios.setBounds(488, 61, 78, 13);
		frmMenuConsultar.getContentPane().add(textoEpisodios);

		JButton botaoVoltar = new JButton("VOLTAR");
		botaoVoltar.setBackground(Color.LIGHT_GRAY);
		botaoVoltar.setForeground(Color.BLACK);
		botaoVoltar.setFont(new Font("Arial", Font.BOLD, 20));
		botaoVoltar.setBounds(209, 12, 227, 36);
		frmMenuConsultar.getContentPane().add(botaoVoltar);

		botaoAlterar = new JButton("ALTERAR");
		botaoAlterar.setBackground(Color.LIGHT_GRAY);
		botaoAlterar.setForeground(Color.BLACK);
		botaoAlterar.setFont(new Font("Arial", Font.BOLD, 20));
		botaoAlterar.setBounds(378, 429, 227, 36);
		frmMenuConsultar.getContentPane().add(botaoAlterar);

		botaoDeletar = new JButton("DELETAR");
		botaoDeletar.setBackground(Color.LIGHT_GRAY);
		botaoDeletar.setForeground(Color.BLACK);
		botaoDeletar.setFont(new Font("Arial", Font.BOLD, 20));
		botaoDeletar.setBounds(37, 429, 227, 36);
		frmMenuConsultar.getContentPane().add(botaoDeletar);

		tabela = new JTable();
		tabela.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 255, 255), new Color(0, 0, 0)));
		tabela.setFont(new Font("SansSerif", Font.PLAIN, 13));
		tabela.setBackground(SystemColor.inactiveCaptionBorder);
		modelo = (DefaultTableModel) tabela.getModel();

		modelo.addColumn("ID");
		modelo.addColumn("NOME");
		modelo.addColumn("STATUS");
		modelo.addColumn("TEMPORADAS");
		modelo.addColumn("EPISODIOS");

		preencherTabela();

		tabela.setBounds(37, 84, 568, 328);
		frmMenuConsultar.getContentPane().add(tabela);

		botaoAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
				limparTabela();
				preencherTabela();
			}
		});

		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMenuAdicionar.main(null);
				frmMenuConsultar.setVisible(false);
			}
		});

		botaoDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletar();
				limparTabela();
				preencherTabela();
			}
		});

	}

	private void preencherTabela() {
		List<Serie> series = serieDAO.listar();

		try {
			for (Serie serie : series) {
				modelo.addRow(new Object[] { serie.getId(), serie.getNome(), serie.getStatus(), serie.getTemporadas(),
						serie.getEpisodios() });
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void deletar() {
		try {
			Object objetoDaLinha = modelo.getValueAt(tabela.getSelectedRow(), tabela.getSelectedColumn());
			String nomeColuna = tabela.getColumnName(tabela.getSelectedColumn());
			
			if (objetoDaLinha instanceof String && nomeColuna.equals("NOME")) {
				Integer id = (Integer) modelo.getValueAt(tabela.getSelectedRow(), 0);
				String nome = (String) modelo.getValueAt(tabela.getSelectedRow(), 1);
				
				this.serieDAO.deletar(nome, id);
				JOptionPane.showMessageDialog(null, "Deletado com sucesso", "Alteração bem sucedida",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Por favor, selecione o nome da série a ser deletada",
						"Nome não selecionado", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void alterar() {

		try {
			Object objetoDaLinha = modelo.getValueAt(tabela.getSelectedRow(), tabela.getSelectedColumn());
			String nomeColuna = tabela.getColumnName(tabela.getSelectedColumn());

			if (objetoDaLinha instanceof Integer && nomeColuna.equals("ID")) {

				Integer id = (Integer) objetoDaLinha;
				String nome = (String) modelo.getValueAt(tabela.getSelectedRow(), 1);
				String status = (String) modelo.getValueAt(tabela.getSelectedRow(), 2);
				Integer temporadas;
				Integer episodios;

				try {
					try {
						temporadas = (Integer) modelo.getValueAt(tabela.getSelectedRow(), 3);
						try {
							episodios = (Integer) modelo.getValueAt(tabela.getSelectedRow(), 4);
						} catch (ClassCastException ex1) {
							episodios = Integer.parseInt((String) modelo.getValueAt(tabela.getSelectedRow(), 4));
						}
					} catch (ClassCastException ex2) {
						temporadas = Integer.parseInt((String) modelo.getValueAt(tabela.getSelectedRow(), 3));
						try {
							episodios = (Integer) modelo.getValueAt(tabela.getSelectedRow(), 4);
						} catch (ClassCastException ex1) {
							episodios = Integer.parseInt((String) modelo.getValueAt(tabela.getSelectedRow(), 4));
						}
					}
					try {
						this.serieDAO.alterar(id, nome, status, temporadas, episodios);
						JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Alteração bem sucedida",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (RuntimeException exx) {
						tabela.clearSelection();
					}
				} catch (NumberFormatException exc) {
					JOptionPane.showMessageDialog(null, "Informe apenas números", "Informação incorreta",
							JOptionPane.WARNING_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "Por favor, selecionar o ID", "ID não selecionado",
						JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void limparTabela() {
		modelo.getDataVector().clear();
	}
}
