package br.com.projeto.edutech.interface_grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal {

	private JFrame frmMenuPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frmMenuPrincipal.setVisible(true);
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
		frmMenuPrincipal = new JFrame();
		frmMenuPrincipal.setTitle("MENU PRINCIPAL");
		frmMenuPrincipal.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmMenuPrincipal.setBounds(100, 100, 640, 402);
		frmMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenuPrincipal.getContentPane().setLayout(null);
		frmMenuPrincipal.setLocation(600, 200);
		
		JLabel lblNewLabel = new JLabel("BEM VINDO!!");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 33, 624, 57);
		frmMenuPrincipal.getContentPane().add(lblNewLabel);
		
		JLabel lblComoDesejaProsseguir = new JLabel("COMO DESEJA PROSSEGUIR?");
		lblComoDesejaProsseguir.setHorizontalAlignment(SwingConstants.CENTER);
		lblComoDesejaProsseguir.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblComoDesejaProsseguir.setBounds(0, 119, 624, 57);
		frmMenuPrincipal.getContentPane().add(lblComoDesejaProsseguir);
		
		JButton btnMenuAdicionar = new JButton("MENU ADICIONAR");
		btnMenuAdicionar.setForeground(Color.BLACK);
		btnMenuAdicionar.setFont(new Font("Arial", Font.BOLD, 20));
		btnMenuAdicionar.setBackground(Color.LIGHT_GRAY);
		btnMenuAdicionar.setBounds(37, 250, 227, 36);
		frmMenuPrincipal.getContentPane().add(btnMenuAdicionar);
		
		JButton btnMenuConsultar = new JButton("MENU CONSULTAR");
		btnMenuConsultar.setForeground(Color.BLACK);
		btnMenuConsultar.setFont(new Font("Arial", Font.BOLD, 20));
		btnMenuConsultar.setBackground(Color.LIGHT_GRAY);
		btnMenuConsultar.setBounds(333, 250, 227, 36);
		frmMenuPrincipal.getContentPane().add(btnMenuConsultar);
		
		btnMenuAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMenuAdicionar.main(null);
				frmMenuPrincipal.setVisible(false);
			}
		});
		
		btnMenuConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMenuConsultar.main(null);
				frmMenuPrincipal.setVisible(false);
			}
		});
		
		
		
		
		
	}
}
