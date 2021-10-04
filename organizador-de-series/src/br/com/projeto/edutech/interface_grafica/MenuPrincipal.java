package br.com.projeto.edutech.interface_grafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import br.com.projeto.edutech.dao.SeriesDAO;

public class MenuPrincipal {

	private JFrame telaMenuPrincipal;
	private SeriesDAO serieDAO = new SeriesDAO(); 

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
					window.telaMenuPrincipal.setVisible(true);
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
		this.serieDAO.setaUltimoId();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		telaMenuPrincipal = new JFrame();
		telaMenuPrincipal.setTitle("ORGANIZADOR DE SÉRIES");
		telaMenuPrincipal.getContentPane().setBackground(SystemColor.inactiveCaption);
		telaMenuPrincipal.setBounds(100, 100, 640, 320);
		telaMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaMenuPrincipal.getContentPane().setLayout(null);
		telaMenuPrincipal.setLocation(600, 200);
		
		JLabel textoBemVindo = new JLabel("BEM VINDO");
		textoBemVindo.setFont(new Font("Arial", Font.BOLD, 30));
		textoBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		textoBemVindo.setBounds(227, 10, 169, 36);
		telaMenuPrincipal.getContentPane().add(textoBemVindo);
		
		JLabel textoComoDesejaProsseguir = new JLabel("COMO DESEJA PROSSEGUIR ?");
		textoComoDesejaProsseguir.setHorizontalAlignment(SwingConstants.CENTER);
		textoComoDesejaProsseguir.setFont(new Font("Arial", Font.PLAIN, 30));
		textoComoDesejaProsseguir.setBounds(87, 122, 449, 36);
		telaMenuPrincipal.getContentPane().add(textoComoDesejaProsseguir);
		
		JButton botaoMenuAdicionar = new JButton("MENU ADICIONAR");
		botaoMenuAdicionar.setForeground(Color.BLACK);
		botaoMenuAdicionar.setFont(new Font("Arial", Font.BOLD, 20));
		botaoMenuAdicionar.setBackground(Color.LIGHT_GRAY);
		botaoMenuAdicionar.setBounds(36, 240, 227, 36);
		telaMenuPrincipal.getContentPane().add(botaoMenuAdicionar);
		
		JButton botaoMenuConsultar = new JButton("MENU CONSULTAR");
		botaoMenuConsultar.setForeground(Color.BLACK);
		botaoMenuConsultar.setFont(new Font("Arial", Font.BOLD, 20));
		botaoMenuConsultar.setBackground(Color.LIGHT_GRAY);
		botaoMenuConsultar.setBounds(361, 240, 227, 36);
		telaMenuPrincipal.getContentPane().add(botaoMenuConsultar);
		
		botaoMenuAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAdicionar.main(null);
				telaMenuPrincipal.setVisible(false);
			}
		});
		
		botaoMenuConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuConsultar.main(null);
				telaMenuPrincipal.setVisible(false);
			}
		});
		
		
		
		
		
	}
}
