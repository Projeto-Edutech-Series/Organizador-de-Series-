package br.com.projeto.edutech.interface_grafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import br.com.projeto.edutech.dao.SeriesDAO;
import br.com.projeto.edutech.modelo.InfoInvalidaException;
import br.com.projeto.edutech.modelo.Serie;

public class MenuAlterar {

	private JFrame telaMenuAlterar;
	private DefaultTableModel modelo;
	private JTable tabelaSeries;
	private SeriesDAO seriesDAO = new SeriesDAO();
	private JButton botaoAlterar;
	private JButton botaoVoltar;
	public static String nomeAntigo;
	public static String statusAntigo;
	public static Integer temporadaAntiga;
	public static Integer episodiosAntigos;

	/**
	 * Launch the application.
	 * 
	 * @return
	 */

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAlterar window = new MenuAlterar();
					window.telaMenuAlterar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuAlterar() {
		initialize();
	}

	public MenuAlterar(String nome, String status, String temporadas, String episodios) {
		this.nomeAntigo = nome;
		this.statusAntigo = status;
		this.temporadaAntiga = Integer.parseInt(temporadas);
		this.episodiosAntigos = Integer.parseInt(episodios);
	}

	/**
	 * Create the application.
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// cria o JFrame
		telaMenuAlterar = new JFrame();
		telaMenuAlterar.setFont(new Font("Arial", Font.BOLD, 12));
		telaMenuAlterar.setTitle("ORGANIZADOR DE SÉRIES");
		telaMenuAlterar.setResizable(false);
		telaMenuAlterar.getContentPane().setFont(new Font("SansSerif", Font.PLAIN, 12));
		telaMenuAlterar.getContentPane().setBackground(new Color(220, 220, 220));
		telaMenuAlterar.setBounds(100, 100, 640, 600);
		telaMenuAlterar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaMenuAlterar.setLocation(600, 200);
		telaMenuAlterar.getContentPane().setLayout(null);
		//

		// texto registro de séries
		JLabel textoConsultarSries = new JLabel("Série: ");
		textoConsultarSries.setHorizontalAlignment(SwingConstants.CENTER);
		textoConsultarSries.setForeground(Color.BLACK);
		textoConsultarSries.setFont(new Font("Arial", Font.BOLD, 30));
		textoConsultarSries.setBackground(Color.LIGHT_GRAY);
		textoConsultarSries.setBounds(118, 6, 393, 36);
		telaMenuAlterar.getContentPane().add(textoConsultarSries);
		//

		// botão voltar
		botaoVoltar = new JButton("VOLTAR");
		botaoVoltar.setBackground(Color.LIGHT_GRAY);
		botaoVoltar.setForeground(Color.BLACK);
		botaoVoltar.setFont(new Font("Arial", Font.BOLD, 20));
		botaoVoltar.setBounds(12, 400, 175, 36);
		telaMenuAlterar.getContentPane().add(botaoVoltar);
		//

		// botão alterar
		botaoAlterar = new JButton("ALTERAR");
		botaoAlterar.setBackground(Color.LIGHT_GRAY);
		botaoAlterar.setForeground(Color.BLACK);
		botaoAlterar.setFont(new Font("Arial", Font.BOLD, 20));
		botaoAlterar.setBounds(437, 400, 175, 36);
		telaMenuAlterar.getContentPane().add(botaoAlterar);
		//

		// Scroll pane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 88, 600, 300);
		telaMenuAlterar.getContentPane().add(scrollPane);
		//

		// tabela
		tabelaSeries = new JTable();
		scrollPane.setViewportView(tabelaSeries);
		tabelaSeries.setCellSelectionEnabled(true);
		tabelaSeries.setShowVerticalLines(true);
		tabelaSeries.setShowHorizontalLines(true);
		tabelaSeries.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 255, 255), new Color(0, 0, 0)));
		tabelaSeries.setFont(new Font("SansSerif", Font.PLAIN, 13));
		tabelaSeries.setBackground(SystemColor.inactiveCaptionBorder);
		//

		// modelo tabela
		modelo = (DefaultTableModel) tabelaSeries.getModel();
		modelo.addColumn("NOME");
		modelo.addColumn("STATUS");
		modelo.addColumn("TEMPORADAS");
		modelo.addColumn("EPISODIOS");
		//

		preencherTabela();
	}

	private void preencherTabela() {
		Collection<Serie> series = new TreeSet<Serie>(seriesDAO.listar());
		try {
			modelo.addRow(new Object[] { nomeAntigo, statusAntigo, temporadaAntiga, episodiosAntigos });
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		botaoAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = (String) modelo.getValueAt(0, 0);
				String status = (String) modelo.getValueAt(0, 1);
				Integer temporadas;
				Integer episodios;

				try {
					temporadas = (Integer) modelo.getValueAt(0, 2);
					try {
						episodios = (Integer) modelo.getValueAt(0, 3);
					} catch (ClassCastException ex1) {
						episodios = Integer.parseInt((String) modelo.getValueAt(0, 3));
					}
				} catch (ClassCastException ex2) {
					temporadas = Integer.parseInt((String) modelo.getValueAt(0, 2));
					try {
						episodios = (Integer) modelo.getValueAt(0, 3);
					} catch (ClassCastException ex1) {
						episodios = Integer.parseInt((String) modelo.getValueAt(0, 3));
					}
				}
				
				try {
					if (!seriesDAO.jaExiste(new Serie(nome, status, temporadas, episodios))) {

						if (seriesDAO.adiciona(new Serie(nome, status, temporadas, episodios),
								true)) {
							
							seriesDAO.deletar(nomeAntigo);

							JOptionPane.showMessageDialog(null,
									"A série " + "'" + nome.strip() + "'" + " foi adicionada!",
									"Série adicionada", JOptionPane.INFORMATION_MESSAGE);
							
							MenuConsultar.main(null);
							telaMenuAlterar.setVisible(false);
							
						}

					} else {
						JOptionPane.showMessageDialog(null,
								"A série " + "'" + nome.strip() + "'" + " já esta no registro!");
					}

				} catch (InfoInvalidaException iIE) {

				}
				
			}
		});

		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuConsultar.main(null);
				telaMenuAlterar.setVisible(false);
			}
		});
	}
}