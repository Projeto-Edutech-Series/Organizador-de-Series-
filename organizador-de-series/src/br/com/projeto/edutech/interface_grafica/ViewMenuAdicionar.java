
package br.com.projeto.edutech.interface_grafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import br.com.projeto.edutech.dao.SeriesDAO;
import br.com.projeto.edutech.modelo.InfoInvalidaException;
import br.com.projeto.edutech.modelo.Serie;
import java.awt.SystemColor;

public class ViewMenuAdicionar {

	private JFrame frmMenuAdicionar;
	private JTextField CampoNome;
	private JTextField CampoTemporadas;
	private JTextField CampoEpisodios;
	private JComboBox<String> statusComboBox;
	private SeriesDAO seriesDAO = new SeriesDAO();
	
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
					ViewMenuAdicionar window = new ViewMenuAdicionar();
					window.frmMenuAdicionar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewMenuAdicionar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenuAdicionar = new JFrame();
		frmMenuAdicionar.setResizable(false);
		frmMenuAdicionar.setBackground(SystemColor.desktop);
		frmMenuAdicionar.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmMenuAdicionar.setTitle("Menu Adicionar");
		frmMenuAdicionar.setBounds(100, 100, 661, 515);
		frmMenuAdicionar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenuAdicionar.getContentPane().setLayout(null);
		frmMenuAdicionar.setLocation(600, 200);
		
		JLabel TextoTitulo = new JLabel("ORGANIZADOR DE SÉRIES");
		TextoTitulo.setForeground(Color.BLACK);
		TextoTitulo.setBackground(Color.LIGHT_GRAY);
		TextoTitulo.setFont(new Font("Arial", Font.BOLD, 30));
		TextoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		TextoTitulo.setBounds(6, 6, 612, 60);
		frmMenuAdicionar.getContentPane().add(TextoTitulo);
		
		JLabel TextoNome = new JLabel("NOME");
		TextoNome.setBackground(Color.LIGHT_GRAY);
		TextoNome.setHorizontalAlignment(SwingConstants.LEFT);
		TextoNome.setFont(new Font("Arial", Font.BOLD, 20));
		TextoNome.setBounds(51, 92, 67, 24);
		frmMenuAdicionar.getContentPane().add(TextoNome);
		
		CampoNome = new JTextField();
		CampoNome.setToolTipText("Digite o nome da série.");
		CampoNome.setFont(new Font("Arial", Font.PLAIN, 20));
		CampoNome.setBounds(51, 128, 454, 28);
		CampoNome.setColumns(10);
		frmMenuAdicionar.getContentPane().add(CampoNome);
		
		JLabel TextoTemporadas = new JLabel("TEMPORADAS");
		TextoTemporadas.setHorizontalAlignment(SwingConstants.LEFT);
		TextoTemporadas.setFont(new Font("Arial", Font.BOLD, 20));
		TextoTemporadas.setBackground(Color.LIGHT_GRAY);
		TextoTemporadas.setBounds(51, 178, 146, 24);
		frmMenuAdicionar.getContentPane().add(TextoTemporadas);
		
		CampoTemporadas = new JTextField();
		CampoTemporadas.setToolTipText("Digite o número de temporadas.");
		CampoTemporadas.setFont(new Font("Arial", Font.PLAIN, 20));
		CampoTemporadas.setBounds(51, 214, 454, 28);
		frmMenuAdicionar.getContentPane().add(CampoTemporadas);
		CampoTemporadas.setColumns(10);
		
		JLabel TextoEpisodios = new JLabel("EPISÓDIOS");
		TextoEpisodios.setHorizontalAlignment(SwingConstants.LEFT);
		TextoEpisodios.setFont(new Font("Arial", Font.BOLD, 20));
		TextoEpisodios.setBackground(Color.LIGHT_GRAY);
		TextoEpisodios.setBounds(51, 254, 115, 24);
		frmMenuAdicionar.getContentPane().add(TextoEpisodios);
		
		CampoEpisodios = new JTextField();
		CampoEpisodios.setToolTipText("Digite o número de episódios.");
		CampoEpisodios.setFont(new Font("Arial", Font.PLAIN, 20));
		CampoEpisodios.setBounds(51, 290, 454, 28);
		frmMenuAdicionar.getContentPane().add(CampoEpisodios);
		CampoEpisodios.setColumns(10);
	
		JButton BotaoAdicionar = new JButton("ADICIONAR SÉRIE");
		BotaoAdicionar.setForeground(Color.BLACK);
		BotaoAdicionar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {	
				try {		
					if(seriesDAO.adiciona(new Serie(CampoNome, statusComboBox, CampoTemporadas, CampoEpisodios), true)) {
						
						JOptionPane.showMessageDialog(null, 
								"A série " + "'" + CampoNome.getText().strip() + "'" + " foi adicionada!", 
								"Série adicionada", JOptionPane.INFORMATION_MESSAGE);		
						
						CampoNome.setText(null);
						CampoTemporadas.setText(null);
						CampoEpisodios.setText(null);
					}
				} catch(InfoInvalidaException iIE) {
					
				}
			}
		});
		BotaoAdicionar.setFont(new Font("Arial", Font.BOLD, 20));
		BotaoAdicionar.setBounds(51, 425, 227, 34);
		frmMenuAdicionar.getContentPane().add(BotaoAdicionar);
		
		statusComboBox = new JComboBox<>();
		statusComboBox.addItem("ASSISTIDO");
		statusComboBox.addItem("ASSISTIREI");
		statusComboBox.addItem("ASSISTINDO");
		statusComboBox.addItem("RETOMAREI");
		statusComboBox.setToolTipText("Selecione o status");
		statusComboBox.setBounds(51, 365, 454, 26);
		frmMenuAdicionar.getContentPane().add(statusComboBox);
		
		JLabel lblStatus = new JLabel("STATUS");
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setFont(new Font("Arial", Font.BOLD, 20));
		lblStatus.setBackground(Color.LIGHT_GRAY);
		lblStatus.setBounds(51, 333, 115, 24);
		frmMenuAdicionar.getContentPane().add(lblStatus);
		
		JButton botaoConsultarSerie = new JButton("CONSULTAR SÉRIE");
		
		botaoConsultarSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMenuConsultar.main(null);
				frmMenuAdicionar.setVisible(false);
			}
		});
		
		botaoConsultarSerie.setForeground(Color.BLACK);
		botaoConsultarSerie.setFont(new Font("Arial", Font.BOLD, 20));
		botaoConsultarSerie.setBounds(376, 425, 227, 34);
		frmMenuAdicionar.getContentPane().add(botaoConsultarSerie);
		
		
	}
}
