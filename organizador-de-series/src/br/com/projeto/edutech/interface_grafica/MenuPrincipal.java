package br.com.projeto.edutech.interface_grafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class MenuPrincipal {

	private JFrame frmMenuAdicionar;
	private JTextField CampoNome;
	private JTextField CampoTemporadas;
	private JTextField CampoEpisodios;
	private final ButtonGroup GrupoAlternativas = new ButtonGroup();
	private String status;
	private String nome;
	private int temporadas;
	private int episodios;
	
	
	/**
	 * Adiciona a série com as informações fornecidas nos campos de texto e RadioButton a um arquivo txt.
	 */
	private void adiciona() {
		try {
//			if(verificaInformacoes()) {
//				return;
//			}
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("series.txt"));
			
			bw.write(CampoNome.getText() + ";");
			bw.write(CampoTemporadas.getText() + ";");
			bw.write(CampoEpisodios.getText() + ";");
			bw.write(status + ";");
			bw.newLine();
			
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private boolean verificaInformacoes() {
		if(CampoNome.getText() != null | CampoNome.getText() != "") {
			nome = CampoNome.getText();
			
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum nome informado", "Informação não fornecida", 1);
			return true;
		}
				// a verificação do status precisa ser refeita
//		GrupoAlternativas.getElements().asIterator().forEachRemaining(botao -> {
//			System.out.println(botao.getClass());
//			if(botao.isSelected()) {
//				status = botao.getText();
//			} else {
//				
//				JOptionPane.showMessageDialog(null, "Nenhum status selecionado", "Informação não fornecida", 1);
//				return;
//			}		
//		});

		
		if(CampoTemporadas.getText() != null | CampoTemporadas.getText() != "") {
			temporadas = Integer.parseInt(CampoTemporadas.getText());
			
		} else {
			JOptionPane.showMessageDialog(null, "Número de temporadas não informado", "Informação não fornecida", 1);
			return true;
		}
		
		if(CampoEpisodios.getText() != null | CampoEpisodios.getText() != "") {
			episodios = Integer.parseInt(CampoEpisodios.getText());
			
		} else {		
			JOptionPane.showMessageDialog(null, "Número de temporadas não informado", "Informação não fornecida", 1);
			return true;
		}
		
		return false;
	}

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
		frmMenuAdicionar.setTitle("Menu adicionar");
		frmMenuAdicionar.setResizable(false);
		frmMenuAdicionar.setBounds(100, 100, 640, 480);
		frmMenuAdicionar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenuAdicionar.getContentPane().setLayout(null);
		frmMenuAdicionar.setLocation(600, 200);
		
		JLabel TextoTitulo = new JLabel("ORGANIZADOR DE S\u00C9RIES");
		TextoTitulo.setForeground(Color.BLACK);
		TextoTitulo.setBackground(Color.LIGHT_GRAY);
		TextoTitulo.setFont(new Font("Arial", Font.BOLD, 30));
		TextoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		TextoTitulo.setBounds(6, 10, 612, 60);
		frmMenuAdicionar.getContentPane().add(TextoTitulo);
		
		JLabel TextoNome = new JLabel("NOME:");
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
		
		JLabel TextoTemporadas = new JLabel("TEMPORADAS:");
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
		
		JLabel TextoEpisodios = new JLabel("EPIS\u00D3DIOS:");
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
		
		JRadioButton AlternativaAssistirei = new JRadioButton("ASSISTIREI");
		GrupoAlternativas.add(AlternativaAssistirei);
		AlternativaAssistirei.setFont(new Font("Arial", Font.BOLD, 16));
		AlternativaAssistirei.setBounds(6, 250, 115, 31);
		frmMenuAdicionar.getContentPane().add(AlternativaAssistirei);
		
		JRadioButton AlternativaRetomarei = new JRadioButton("RETOMAREI");
		GrupoAlternativas.add(AlternativaRetomarei);
		AlternativaRetomarei.setFont(new Font("Arial", Font.BOLD, 16));
		AlternativaRetomarei.setBounds(133, 250, 122, 31);
		frmMenuAdicionar.getContentPane().add(AlternativaRetomarei);
		
		JRadioButton AlternativaAssistindo = new JRadioButton("ASSISTINDO");
		GrupoAlternativas.add(AlternativaAssistindo);
		AlternativaAssistindo.setFont(new Font("Arial", Font.BOLD, 16));
		AlternativaAssistindo.setBounds(267, 250, 124, 31);
		frmMenuAdicionar.getContentPane().add(AlternativaAssistindo);
		
		JRadioButton AlternativaTerminado = new JRadioButton("TERMINADO");
		GrupoAlternativas.add(AlternativaTerminado);
		AlternativaTerminado.setFont(new Font("Arial", Font.BOLD, 16));
		AlternativaTerminado.setBounds(403, 250, 123, 31);
		frmMenuAdicionar.getContentPane().add(AlternativaTerminado);
		
		JButton BotaoAdicionar = new JButton("ADICIONAR S\u00C9RIE");
		BotaoAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String msg = "Nome: " + CampoNome.getText() + System.lineSeparator() +
//				"Temporadas: " + CampoTemporadas.getText() + System.lineSeparator() +
//				"Episódios: " + CampoEpisodios.getText() + System.lineSeparator() +
				
				adiciona();
				JOptionPane.showMessageDialog(null, "Série adicionada");
			}
		});
		BotaoAdicionar.setFont(new Font("Arial", Font.BOLD, 20));
		BotaoAdicionar.setBounds(209, 350, 206, 34);
		frmMenuAdicionar.getContentPane().add(BotaoAdicionar);
	}
}
