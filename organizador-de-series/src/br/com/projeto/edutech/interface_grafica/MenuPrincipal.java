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
			UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
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
		this.serieDAO.setUltimoId();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//cria o Jframe
		telaMenuPrincipal = new JFrame();
		telaMenuPrincipal.setResizable(false);
		telaMenuPrincipal.setTitle("ORGANIZADOR DE SÉRIES");
		telaMenuPrincipal.getContentPane().setBackground(new Color(220, 220, 220));
		telaMenuPrincipal.setBounds(100, 100, 640, 320);
		telaMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaMenuPrincipal.getContentPane().setLayout(null);
		telaMenuPrincipal.setLocation(600, 200);
		//
		
		// texto de bem vindo
		JLabel textoBemVindo = new JLabel("BEM VINDO");
		textoBemVindo.setFont(new Font("Arial", Font.BOLD, 30));
		textoBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		textoBemVindo.setBounds(232, 10, 169, 36);
		telaMenuPrincipal.getContentPane().add(textoBemVindo);
		//
		
		// texto como deseja prosseguir
		JLabel textoComoDesejaProsseguir = new JLabel("COMO DESEJA PROSSEGUIR ?");
		textoComoDesejaProsseguir.setHorizontalAlignment(SwingConstants.CENTER);
		textoComoDesejaProsseguir.setFont(new Font("Arial", Font.PLAIN, 30));
		textoComoDesejaProsseguir.setBounds(87, 122, 449, 36);
		telaMenuPrincipal.getContentPane().add(textoComoDesejaProsseguir);
		//
		
		// botão menu adicionar série
		JButton botaoMenuAdicionar = new JButton("ADICIONAR SÉRIE");
		botaoMenuAdicionar.setForeground(Color.BLACK);
		botaoMenuAdicionar.setFont(new Font("Arial", Font.BOLD, 20));
		botaoMenuAdicionar.setBackground(Color.LIGHT_GRAY);
		botaoMenuAdicionar.setBounds(186, 185, 261, 36);
		telaMenuPrincipal.getContentPane().add(botaoMenuAdicionar);
		//
		
		// botão menu consultar
		JButton botaoMenuConsultar = new JButton("REGISTRO");
		botaoMenuConsultar.setForeground(Color.BLACK);
		botaoMenuConsultar.setFont(new Font("Arial", Font.BOLD, 20));
		botaoMenuConsultar.setBackground(Color.LIGHT_GRAY);
		botaoMenuConsultar.setBounds(186, 235, 261, 36);
		telaMenuPrincipal.getContentPane().add(botaoMenuConsultar);
		//
		
		// ação executada pelo botão adicionar série
		botaoMenuAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAdicionar.main(null);
				telaMenuPrincipal.setVisible(false);
			}
		});
		//
		
		// ação executada pelo botão registro
		botaoMenuConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuConsultar.main(null);
				telaMenuPrincipal.setVisible(false);
			}
		});
		//
		
		
		
		
		
	}
}
