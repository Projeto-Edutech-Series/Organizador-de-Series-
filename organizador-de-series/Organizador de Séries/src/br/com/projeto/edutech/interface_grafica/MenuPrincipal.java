package br.com.projeto.edutech.interface_grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.UIManager;

public class MenuPrincipal {

	private JFrame frame;
	private JTextField CampoNome;
	private JTextField CampoTemporadas;
	private JTextField CampoEpisodios;
	private final ButtonGroup GrupoAlternativas = new ButtonGroup();

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
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel TextoTitulo = new JLabel("ORGANIZADOR DE S\u00C9RIES");
		TextoTitulo.setForeground(Color.BLACK);
		TextoTitulo.setBackground(Color.LIGHT_GRAY);
		TextoTitulo.setFont(new Font("Arial", Font.BOLD, 30));
		TextoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		TextoTitulo.setBounds(6, 10, 612, 60);
		frame.getContentPane().add(TextoTitulo);
		
		JLabel TextoNome = new JLabel("NOME:");
		TextoNome.setBackground(Color.LIGHT_GRAY);
		TextoNome.setHorizontalAlignment(SwingConstants.CENTER);
		TextoNome.setFont(new Font("Arial", Font.BOLD, 20));
		TextoNome.setBounds(6, 100, 67, 24);
		frame.getContentPane().add(TextoNome);
		
		CampoNome = new JTextField();
		CampoNome.setFont(new Font("Arial", Font.PLAIN, 20));
		CampoNome.setBounds(85, 100, 533, 28);
		frame.getContentPane().add(CampoNome);
		CampoNome.setColumns(10);
		
		JLabel TextoTemporadas = new JLabel("TEMPORADAS:");
		TextoTemporadas.setHorizontalAlignment(SwingConstants.CENTER);
		TextoTemporadas.setFont(new Font("Arial", Font.BOLD, 20));
		TextoTemporadas.setBackground(Color.LIGHT_GRAY);
		TextoTemporadas.setBounds(6, 150, 146, 24);
		frame.getContentPane().add(TextoTemporadas);
		
		CampoTemporadas = new JTextField();
		CampoTemporadas.setFont(new Font("Arial", Font.PLAIN, 20));
		CampoTemporadas.setBounds(164, 150, 454, 28);
		frame.getContentPane().add(CampoTemporadas);
		CampoTemporadas.setColumns(10);
		
		JLabel TextoEpisodios = new JLabel("EPIS\u00D3DIOS:");
		TextoEpisodios.setHorizontalAlignment(SwingConstants.CENTER);
		TextoEpisodios.setFont(new Font("Arial", Font.BOLD, 20));
		TextoEpisodios.setBackground(Color.LIGHT_GRAY);
		TextoEpisodios.setBounds(6, 200, 115, 24);
		frame.getContentPane().add(TextoEpisodios);
		
		CampoEpisodios = new JTextField();
		CampoEpisodios.setFont(new Font("Arial", Font.PLAIN, 20));
		CampoEpisodios.setBounds(133, 200, 485, 28);
		frame.getContentPane().add(CampoEpisodios);
		CampoEpisodios.setColumns(10);
		
		JRadioButton AlternativaAssistirei = new JRadioButton("ASSISTIREI");
		GrupoAlternativas.add(AlternativaAssistirei);
		AlternativaAssistirei.setFont(new Font("Arial", Font.BOLD, 16));
		AlternativaAssistirei.setBounds(6, 250, 115, 31);
		frame.getContentPane().add(AlternativaAssistirei);
		
		JRadioButton AlternativaRetomarei = new JRadioButton("RETOMAREI");
		GrupoAlternativas.add(AlternativaRetomarei);
		AlternativaRetomarei.setFont(new Font("Arial", Font.BOLD, 16));
		AlternativaRetomarei.setBounds(133, 250, 122, 31);
		frame.getContentPane().add(AlternativaRetomarei);
		
		JRadioButton AlternativaAssistindo = new JRadioButton("ASSISTINDO");
		GrupoAlternativas.add(AlternativaAssistindo);
		AlternativaAssistindo.setFont(new Font("Arial", Font.BOLD, 16));
		AlternativaAssistindo.setBounds(359, 250, 124, 31);
		frame.getContentPane().add(AlternativaAssistindo);
		
		JRadioButton AlternativaTerminado = new JRadioButton("TERMINADO");
		GrupoAlternativas.add(AlternativaTerminado);
		AlternativaTerminado.setFont(new Font("Arial", Font.BOLD, 16));
		AlternativaTerminado.setBounds(495, 250, 123, 31);
		frame.getContentPane().add(AlternativaTerminado);
		
		JButton BotaoAdicionar = new JButton("ADICIONAR S\u00C9RIE");
		BotaoAdicionar.setFont(new Font("Arial", Font.BOLD, 20));
		BotaoAdicionar.setBounds(209, 350, 206, 34);
		frame.getContentPane().add(BotaoAdicionar);
	}
}
