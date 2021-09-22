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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.projeto.edutech.dao.SeriesDAO;
import br.com.projeto.edutech.modelo.Serie;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


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
		
		JLabel labelId = new JLabel("ID");
		labelId.setFont(new Font("SansSerif", Font.BOLD, 13));
		labelId.setHorizontalAlignment(SwingConstants.LEFT);
		labelId.setBounds(37, 60, 43, 14);
		frmMenuConsultar.getContentPane().add(labelId);
		
		JLabel labelNome = new JLabel("NOME");
		labelNome.setHorizontalAlignment(SwingConstants.CENTER);
		labelNome.setFont(new Font("SansSerif", Font.BOLD, 13));
		labelNome.setBounds(140, 60, 63, 14);
		frmMenuConsultar.getContentPane().add(labelNome);
		
		JLabel labelStatus = new JLabel("STATUS");
		labelStatus.setHorizontalAlignment(SwingConstants.CENTER);
		labelStatus.setFont(new Font("SansSerif", Font.BOLD, 13));
		labelStatus.setBounds(256, 59, 63, 14);
		frmMenuConsultar.getContentPane().add(labelStatus);
		
		JLabel labelTemporadas = new JLabel("TEMPORADAS");
		labelTemporadas.setHorizontalAlignment(SwingConstants.CENTER);
		labelTemporadas.setFont(new Font("SansSerif", Font.BOLD, 13));
		labelTemporadas.setBounds(376, 59, 91, 14);
		frmMenuConsultar.getContentPane().add(labelTemporadas);
		
		JLabel labelEpisodios = new JLabel("EPISÓDIOS");
		labelEpisodios.setHorizontalAlignment(SwingConstants.CENTER);
		labelEpisodios.setFont(new Font("SansSerif", Font.BOLD, 13));
		labelEpisodios.setBounds(488, 61, 78, 13);
		frmMenuConsultar.getContentPane().add(labelEpisodios);
		
		JButton botaoVoltar = new JButton("VOLTAR");
		botaoVoltar.setForeground(Color.BLACK);
		botaoVoltar.setFont(new Font("Arial", Font.BOLD, 20));
		botaoVoltar.setBounds(0, 0, 121, 34);
		frmMenuConsultar.getContentPane().add(botaoVoltar);
		
		botaoAlterar = new JButton("ALTERAR");
		botaoAlterar.setForeground(Color.BLACK);
		botaoAlterar.setFont(new Font("Arial", Font.BOLD, 20));
		botaoAlterar.setBounds(367, 429, 227, 34);
		frmMenuConsultar.getContentPane().add(botaoAlterar);
		
		botaoDeletar = new JButton("DELETAR");
		botaoDeletar.setForeground(Color.BLACK);
		botaoDeletar.setFont(new Font("Arial", Font.BOLD, 20));
		botaoDeletar.setBounds(33, 429, 227, 34);
		frmMenuConsultar.getContentPane().add(botaoDeletar);
		
		tabela = new JTable();
		tabela.setFont(new Font("SansSerif", Font.PLAIN, 13));
		tabela.setBackground(Color.WHITE);
		modelo = (DefaultTableModel) tabela.getModel();

		modelo.addColumn("ID");
		modelo.addColumn("Nome da Série");
		modelo.addColumn("Status");
		modelo.addColumn("Temporadas");
		modelo.addColumn("Episódios");

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
			
	}
	
	private void preencherTabela() {
		List<Serie> series = serieDAO.listar();
		
		try {
			for (Serie serie : series) {
				modelo.addRow(new Object[] {serie.getId(), serie.getNome(), serie.getStatus(), serie.getTemporadas(), serie.getEpisodios()});
			}
		} catch (Exception e) {
			throw e;
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
				
				this.serieDAO.alterar(id, nome, status, temporadas, episodios);
				
			} else {
				JOptionPane.showMessageDialog(null, "Por favor, selecionar o ID");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
				
	}
	
	private void limparTabela() {
		modelo.getDataVector().clear();
	}
}
