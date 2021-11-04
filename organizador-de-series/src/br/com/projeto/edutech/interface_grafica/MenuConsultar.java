package br.com.projeto.edutech.interface_grafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.List;
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
import br.com.projeto.edutech.modelo.Serie;
import javax.swing.ListSelectionModel;

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
			UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
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
		// cria o JFrame
		telaMenuConsultar = new JFrame();
		telaMenuConsultar.setFont(new Font("Arial", Font.BOLD, 12));
		telaMenuConsultar.setTitle("ORGANIZADOR DE SÉRIES");
		telaMenuConsultar.setResizable(false);
		telaMenuConsultar.getContentPane().setFont(new Font("SansSerif", Font.PLAIN, 12));
		telaMenuConsultar.getContentPane().setBackground(new Color(220, 220, 220));
		telaMenuConsultar.setBounds(100, 100, 640, 480);
		telaMenuConsultar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaMenuConsultar.setLocation(600, 200);
		telaMenuConsultar.getContentPane().setLayout(null);
		//

		// texto registro de séries
		JLabel textoConsultarSries = new JLabel("REGISTRO DE SÉRIES");
		textoConsultarSries.setHorizontalAlignment(SwingConstants.CENTER);
		textoConsultarSries.setForeground(Color.BLACK);
		textoConsultarSries.setFont(new Font("Arial", Font.BOLD, 30));
		textoConsultarSries.setBackground(Color.LIGHT_GRAY);
		textoConsultarSries.setBounds(118, 6, 393, 36);
		telaMenuConsultar.getContentPane().add(textoConsultarSries);
		//

		// botão voltar
		JButton botaoVoltar = new JButton("VOLTAR");
		botaoVoltar.setBackground(Color.LIGHT_GRAY);
		botaoVoltar.setForeground(Color.BLACK);
		botaoVoltar.setFont(new Font("Arial", Font.BOLD, 20));
		botaoVoltar.setBounds(12, 400, 175, 36);
		telaMenuConsultar.getContentPane().add(botaoVoltar);
		//

		// botão alterar
		botaoAlterar = new JButton("ALTERAR");
		botaoAlterar.setBackground(Color.LIGHT_GRAY);
		botaoAlterar.setForeground(Color.BLACK);
		botaoAlterar.setFont(new Font("Arial", Font.BOLD, 20));
		botaoAlterar.setBounds(437, 400, 175, 36);
		telaMenuConsultar.getContentPane().add(botaoAlterar);
		//

		// botão deletar
		botaoDeletar = new JButton("DELETAR");
		botaoDeletar.setBackground(Color.LIGHT_GRAY);
		botaoDeletar.setForeground(Color.BLACK);
		botaoDeletar.setFont(new Font("Arial", Font.BOLD, 20));
		botaoDeletar.setBounds(224, 400, 175, 36);
		telaMenuConsultar.getContentPane().add(botaoDeletar);
		//

		// Scroll pane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 88, 600, 300);
		telaMenuConsultar.getContentPane().add(scrollPane);
		//

		// tabela
		tabelaSeries = new JTable();
		tabelaSeries.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tabelaSeries);
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

		botaoAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = (String) modelo.getValueAt(tabelaSeries.getSelectedRow(), 0);
				String status = (String) modelo.getValueAt(tabelaSeries.getSelectedRow(), 1);
				Integer temporadas;
				Integer episodios;

				try {
					temporadas = (Integer) modelo.getValueAt(tabelaSeries.getSelectedRow(), 2);
					try {
						episodios = (Integer) modelo.getValueAt(tabelaSeries.getSelectedRow(), 3);
					} catch (ClassCastException ex1) {
						episodios = Integer.parseInt((String) modelo.getValueAt(tabelaSeries.getSelectedRow(), 3));
					}
				} catch (ClassCastException ex2) {
					temporadas = Integer.parseInt((String) modelo.getValueAt(tabelaSeries.getSelectedRow(), 2));
					try {
						episodios = (Integer) modelo.getValueAt(tabelaSeries.getSelectedRow(), 3);
					} catch (ClassCastException ex1) {
						episodios = Integer.parseInt((String) modelo.getValueAt(tabelaSeries.getSelectedRow(), 3));
					}
				}
				new MenuAlterar(nome, status, "" + temporadas, "" + episodios);
				telaMenuConsultar.setVisible(false);
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
		Collection<Serie> series = new TreeSet<Serie>(serieDAO.listar());
		try {
			for (Serie serie : series) {
				modelo.addRow(new Object[] { serie.getNome(), serie.getStatus(), serie.getTemporadas(), serie.getEpisodios() });
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void deletar() {
		try {
			String nome = (String) modelo.getValueAt(tabelaSeries.getSelectedRow(), 0);
			this.serieDAO.deletar(nome);
			JOptionPane.showMessageDialog(null, "Deletado com sucesso", "Alteração bem sucedida",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void limparTabela() {
		List<Serie> series = serieDAO.listar();
		try {
			modelo.addRow(new Object[] { "", "", "", "", "" });
			for (Serie serie : series) {
				modelo.addRow(new Object[] { "", "", "", "", "" });
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		modelo.getDataVector().clear();
	}
}
