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

public class MenuConsultar {

	private JFrame telaMenuConsultar;
	private DefaultTableModel modelo;
	private JTable tabelaSeries;
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
					MenuConsultar window = new MenuConsultar();
					window.telaMenuConsultar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuConsultar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		telaMenuConsultar = new JFrame();
		telaMenuConsultar.setFont(new Font("Arial", Font.BOLD, 12));
		telaMenuConsultar.setTitle("ORGANIZADOR DE SÉRIES");
		telaMenuConsultar.setResizable(false);
		telaMenuConsultar.getContentPane().setFont(new Font("SansSerif", Font.PLAIN, 12));
		telaMenuConsultar.getContentPane().setBackground(SystemColor.inactiveCaption);
		telaMenuConsultar.setBounds(100, 100, 640, 480);
		telaMenuConsultar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaMenuConsultar.setLocation(600, 200);
		telaMenuConsultar.getContentPane().setLayout(null);

		JLabel textoId = new JLabel("ID");
		textoId.setFont(new Font("Arial", Font.BOLD, 15));
		textoId.setHorizontalAlignment(SwingConstants.LEFT);
		textoId.setBounds(18, 70, 15, 18);
		telaMenuConsultar.getContentPane().add(textoId);

		JLabel textoNome = new JLabel("NOME");
		textoNome.setHorizontalAlignment(SwingConstants.CENTER);
		textoNome.setFont(new Font("Arial", Font.BOLD, 15));
		textoNome.setBounds(136, 70, 46, 18);
		telaMenuConsultar.getContentPane().add(textoNome);

		JLabel textoStatus = new JLabel("STATUS");
		textoStatus.setHorizontalAlignment(SwingConstants.CENTER);
		textoStatus.setFont(new Font("Arial", Font.BOLD, 15));
		textoStatus.setBounds(256, 70, 60, 18);
		telaMenuConsultar.getContentPane().add(textoStatus);

		JLabel textoTemporadas = new JLabel("TEMPORADAS");
		textoTemporadas.setHorizontalAlignment(SwingConstants.CENTER);
		textoTemporadas.setFont(new Font("Arial", Font.BOLD, 15));
		textoTemporadas.setBounds(374, 70, 105, 18);
		telaMenuConsultar.getContentPane().add(textoTemporadas);

		JLabel textoEpisodios = new JLabel("EPISÓDIOS");
		textoEpisodios.setHorizontalAlignment(SwingConstants.CENTER);
		textoEpisodios.setFont(new Font("Arial", Font.BOLD, 15));
		textoEpisodios.setBounds(496, 70, 83, 18);
		telaMenuConsultar.getContentPane().add(textoEpisodios);

		JButton botaoVoltar = new JButton("VOLTAR");
		botaoVoltar.setBackground(Color.LIGHT_GRAY);
		botaoVoltar.setForeground(Color.BLACK);
		botaoVoltar.setFont(new Font("Arial", Font.BOLD, 20));
		botaoVoltar.setBounds(12, 400, 175, 36);
		telaMenuConsultar.getContentPane().add(botaoVoltar);

		botaoAlterar = new JButton("ALTERAR");
		botaoAlterar.setBackground(Color.LIGHT_GRAY);
		botaoAlterar.setForeground(Color.BLACK);
		botaoAlterar.setFont(new Font("Arial", Font.BOLD, 20));
		botaoAlterar.setBounds(437, 400, 175, 36);
		telaMenuConsultar.getContentPane().add(botaoAlterar);

		botaoDeletar = new JButton("DELETAR");
		botaoDeletar.setBackground(Color.LIGHT_GRAY);
		botaoDeletar.setForeground(Color.BLACK);
		botaoDeletar.setFont(new Font("Arial", Font.BOLD, 20));
		botaoDeletar.setBounds(224, 400, 175, 36);
		telaMenuConsultar.getContentPane().add(botaoDeletar);

		tabelaSeries = new JTable();
		tabelaSeries.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		tabelaSeries.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 255, 255), new Color(0, 0, 0)));
		tabelaSeries.setFont(new Font("SansSerif", Font.PLAIN, 13));
		tabelaSeries.setBackground(SystemColor.inactiveCaptionBorder);
		modelo = (DefaultTableModel) tabelaSeries.getModel();

		modelo.addColumn("ID");
		modelo.addColumn("NOME");
		modelo.addColumn("STATUS");
		modelo.addColumn("TEMPORADAS");
		modelo.addColumn("EPISODIOS");

		preencherTabela();

		tabelaSeries.setBounds(12, 88, 600, 300);
		telaMenuConsultar.getContentPane().add(tabelaSeries);
		
		JLabel textoConsultarSries = new JLabel("CONSULTAR SÉRIES");
		textoConsultarSries.setHorizontalAlignment(SwingConstants.CENTER);
		textoConsultarSries.setForeground(Color.BLACK);
		textoConsultarSries.setFont(new Font("Arial", Font.BOLD, 30));
		textoConsultarSries.setBackground(Color.LIGHT_GRAY);
		textoConsultarSries.setBounds(159, 10, 306, 36);
		telaMenuConsultar.getContentPane().add(textoConsultarSries);

		botaoAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
				limparTabela();
				preencherTabela();
			}
		});

		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal.main(null);
				telaMenuConsultar.setVisible(false);
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
			Object objetoDaLinha = modelo.getValueAt(tabelaSeries.getSelectedRow(), tabelaSeries.getSelectedColumn());
			String nomeColuna = tabelaSeries.getColumnName(tabelaSeries.getSelectedColumn());
			
			if (objetoDaLinha instanceof String && nomeColuna.equals("NOME")) {
				Integer id = (Integer) modelo.getValueAt(tabelaSeries.getSelectedRow(), 0);
				String nome = (String) modelo.getValueAt(tabelaSeries.getSelectedRow(), 1);
				
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
			Object objetoDaLinha = modelo.getValueAt(tabelaSeries.getSelectedRow(), tabelaSeries.getSelectedColumn());
			String nomeColuna = tabelaSeries.getColumnName(tabelaSeries.getSelectedColumn());

			if (objetoDaLinha instanceof Integer && nomeColuna.equals("ID")) {

				Integer id = (Integer) objetoDaLinha;
				String nome = (String) modelo.getValueAt(tabelaSeries.getSelectedRow(), 1);
				String status = (String) modelo.getValueAt(tabelaSeries.getSelectedRow(), 2);
				Integer temporadas;
				Integer episodios;

				try {
					try {
						temporadas = (Integer) modelo.getValueAt(tabelaSeries.getSelectedRow(), 3);
						try {
							episodios = (Integer) modelo.getValueAt(tabelaSeries.getSelectedRow(), 4);
						} catch (ClassCastException ex1) {
							episodios = Integer.parseInt((String) modelo.getValueAt(tabelaSeries.getSelectedRow(), 4));
						}
					} catch (ClassCastException ex2) {
						temporadas = Integer.parseInt((String) modelo.getValueAt(tabelaSeries.getSelectedRow(), 3));
						try {
							episodios = (Integer) modelo.getValueAt(tabelaSeries.getSelectedRow(), 4);
						} catch (ClassCastException ex1) {
							episodios = Integer.parseInt((String) modelo.getValueAt(tabelaSeries.getSelectedRow(), 4));
						}
					}
					try {
						this.serieDAO.alterar(id, nome, status, temporadas, episodios);
						JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Alteração bem sucedida",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (RuntimeException exx) {
						tabelaSeries.clearSelection();
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
