package br.com.projeto.edutech.interface_grafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import br.com.projeto.edutech.modelo.Escritor;

public class MenuPrincipal {

	private JFrame frmMenuAdicionar;
	private JTextField CampoNome;
	private JTextField CampoTemporadas;
	private JTextField CampoEpisodios;
	private final ButtonGroup GrupoAlternativas = new ButtonGroup();
	private Escritor escritor = new Escritor();
	
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
					MenuPrincipal window = new MenuPrincipal();
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
	public MenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenuAdicionar = new JFrame();
		frmMenuAdicionar.setTitle("Menu principal");
		frmMenuAdicionar.setResizable(false);
		frmMenuAdicionar.setBounds(100, 100, 640, 480);
		frmMenuAdicionar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenuAdicionar.getContentPane().setLayout(null);
		frmMenuAdicionar.setLocation(600, 200);
		
		JLabel TextoTitulo = new JLabel(escritor.mudaEncode("organizador de séries").toUpperCase());
		TextoTitulo.setForeground(Color.BLACK);
		TextoTitulo.setBackground(Color.LIGHT_GRAY);
		TextoTitulo.setFont(new Font("Arial", Font.BOLD, 30));
		TextoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		TextoTitulo.setBounds(6, 6, 612, 60);
		frmMenuAdicionar.getContentPane().add(TextoTitulo);
		
		JLabel TextoNome = new JLabel("nome".toUpperCase());
		TextoNome.setBackground(Color.LIGHT_GRAY);
		TextoNome.setHorizontalAlignment(SwingConstants.CENTER);
		TextoNome.setFont(new Font("Arial", Font.BOLD, 20));
		TextoNome.setBounds(6, 100, 67, 24);
		frmMenuAdicionar.getContentPane().add(TextoNome);
		
		CampoNome = new JTextField();
		CampoNome.setFont(new Font("Arial", Font.PLAIN, 20));
		CampoNome.setBounds(164, 100, 454, 28);
		frmMenuAdicionar.getContentPane().add(CampoNome);
		CampoNome.setColumns(10);
		
		JLabel TextoTemporadas = new JLabel("temporadas".toUpperCase());
		TextoTemporadas.setHorizontalAlignment(SwingConstants.CENTER);
		TextoTemporadas.setFont(new Font("Arial", Font.BOLD, 20));
		TextoTemporadas.setBackground(Color.LIGHT_GRAY);
		TextoTemporadas.setBounds(6, 150, 146, 24);
		frmMenuAdicionar.getContentPane().add(TextoTemporadas);
		
		CampoTemporadas = new JTextField();
		CampoTemporadas.setFont(new Font("Arial", Font.PLAIN, 20));
		CampoTemporadas.setBounds(164, 150, 454, 28);
		frmMenuAdicionar.getContentPane().add(CampoTemporadas);
		CampoTemporadas.setColumns(10);
		
		JLabel TextoEpisodios = new JLabel(escritor.mudaEncode("episódios").toUpperCase());
		TextoEpisodios.setHorizontalAlignment(SwingConstants.CENTER);
		TextoEpisodios.setFont(new Font("Arial", Font.BOLD, 20));
		TextoEpisodios.setBackground(Color.LIGHT_GRAY);
		TextoEpisodios.setBounds(6, 200, 115, 24);
		frmMenuAdicionar.getContentPane().add(TextoEpisodios);
		
		CampoEpisodios = new JTextField();
		CampoEpisodios.setFont(new Font("Arial", Font.PLAIN, 20));
		CampoEpisodios.setBounds(164, 200, 454, 28);
		frmMenuAdicionar.getContentPane().add(CampoEpisodios);
		CampoEpisodios.setColumns(10);
		
		JRadioButton AlternativaAssistirei = new JRadioButton("assistirei".toUpperCase());
		GrupoAlternativas.add(AlternativaAssistirei);
		AlternativaAssistirei.setFont(new Font("Arial", Font.BOLD, 16));
		AlternativaAssistirei.setBounds(37, 250, 115, 31);
		frmMenuAdicionar.getContentPane().add(AlternativaAssistirei);
		
		JRadioButton AlternativaRetomarei = new JRadioButton("retomarei".toUpperCase());
		GrupoAlternativas.add(AlternativaRetomarei);
		AlternativaRetomarei.setFont(new Font("Arial", Font.BOLD, 16));
		AlternativaRetomarei.setBounds(174, 250, 122, 31);
		frmMenuAdicionar.getContentPane().add(AlternativaRetomarei);
		
		JRadioButton AlternativaAssistindo = new JRadioButton("assistido".toUpperCase());
		GrupoAlternativas.add(AlternativaAssistindo);
		AlternativaAssistindo.setFont(new Font("Arial", Font.BOLD, 16));
		AlternativaAssistindo.setBounds(308, 250, 124, 31);
		frmMenuAdicionar.getContentPane().add(AlternativaAssistindo);
		
		JRadioButton AlternativaTerminado = new JRadioButton("terminado".toUpperCase());
		GrupoAlternativas.add(AlternativaTerminado);
		AlternativaTerminado.setFont(new Font("Arial", Font.BOLD, 16));
		AlternativaTerminado.setBounds(432, 250, 123, 31);
		frmMenuAdicionar.getContentPane().add(AlternativaTerminado);
		
		JButton BotaoAdicionar = new JButton(escritor.mudaEncode("adicionar série".toUpperCase()));
		BotaoAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				if(escritor.adiciona(CampoNome, CampoTemporadas, CampoEpisodios, GrupoAlternativas)) {
					JOptionPane.showMessageDialog(null, escritor.mudaEncode(
							"A série " + "'" + CampoNome.getText().strip() + "'" + " foi adicionada!"), escritor.mudaEncode("Série adicionada"), 1);		
					CampoNome.setText(null);
					CampoTemporadas.setText(null);
					CampoEpisodios.setText(null);
					GrupoAlternativas.clearSelection();
				}
			}
		});
		BotaoAdicionar.setFont(new Font("Arial", Font.BOLD, 20));
		BotaoAdicionar.setBounds(209, 350, 206, 34);
		frmMenuAdicionar.getContentPane().add(BotaoAdicionar);
	}
}
