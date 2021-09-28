
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
	private JTextField campoNome;
	private JTextField campoTemporadas;
	private JTextField campoEpisodios;
	private JComboBox<String> comboBoxStatus;
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

		JLabel textoTitulo = new JLabel("ORGANIZADOR DE SÉRIES");
		textoTitulo.setForeground(Color.BLACK);
		textoTitulo.setBackground(Color.LIGHT_GRAY);
		textoTitulo.setFont(new Font("Arial", Font.BOLD, 30));
		textoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		textoTitulo.setBounds(126, 10, 393, 36);
		frmMenuAdicionar.getContentPane().add(textoTitulo);

		JLabel textoNome = new JLabel("NOME");
		textoNome.setBackground(Color.LIGHT_GRAY);
		textoNome.setHorizontalAlignment(SwingConstants.LEFT);
		textoNome.setFont(new Font("Arial", Font.BOLD, 20));
		textoNome.setBounds(51, 80, 60, 24);
		frmMenuAdicionar.getContentPane().add(textoNome);

		campoNome = new JTextField();
		campoNome.setBackground(Color.WHITE);
		campoNome.setToolTipText("Digite o nome da série");
		campoNome.setFont(new Font("Arial", Font.PLAIN, 18));
		campoNome.setBounds(46, 110, 552, 36);
		campoNome.setColumns(10);
		frmMenuAdicionar.getContentPane().add(campoNome);

		JLabel textoTemporadas = new JLabel("TEMPORADAS");
		textoTemporadas.setHorizontalAlignment(SwingConstants.LEFT);
		textoTemporadas.setFont(new Font("Arial", Font.BOLD, 20));
		textoTemporadas.setBackground(Color.LIGHT_GRAY);
		textoTemporadas.setBounds(51, 160, 139, 24);
		frmMenuAdicionar.getContentPane().add(textoTemporadas);

		campoTemporadas = new JTextField();
		campoTemporadas.setBackground(Color.WHITE);
		campoTemporadas.setToolTipText("Digite o número de temporadas");
		campoTemporadas.setFont(new Font("Arial", Font.PLAIN, 18));
		campoTemporadas.setBounds(46, 190, 552, 36);
		frmMenuAdicionar.getContentPane().add(campoTemporadas);
		campoTemporadas.setColumns(10);

		JLabel textoEpisodios = new JLabel("EPISÓDIOS");
		textoEpisodios.setHorizontalAlignment(SwingConstants.LEFT);
		textoEpisodios.setFont(new Font("Arial", Font.BOLD, 20));
		textoEpisodios.setBackground(Color.LIGHT_GRAY);
		textoEpisodios.setBounds(51, 240, 108, 24);
		frmMenuAdicionar.getContentPane().add(textoEpisodios);

		campoEpisodios = new JTextField();
		campoEpisodios.setBackground(Color.WHITE);
		campoEpisodios.setToolTipText("Digite o número de episódios");
		campoEpisodios.setFont(new Font("Arial", Font.PLAIN, 18));
		campoEpisodios.setBounds(46, 270, 552, 36);
		frmMenuAdicionar.getContentPane().add(campoEpisodios);
		campoEpisodios.setColumns(10);

		comboBoxStatus = new JComboBox<>();
		comboBoxStatus.setBackground(Color.GRAY);
		comboBoxStatus.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBoxStatus.addItem("ASSISTIDO");
		comboBoxStatus.addItem("ASSISTIREI");
		comboBoxStatus.addItem("ASSISTINDO");
		comboBoxStatus.addItem("RETOMAREI");
		
				JLabel textoStatus = new JLabel("STATUS");
				textoStatus.setHorizontalAlignment(SwingConstants.LEFT);
				textoStatus.setFont(new Font("Arial", Font.BOLD, 20));
				textoStatus.setBackground(Color.LIGHT_GRAY);
				textoStatus.setBounds(51, 320, 79, 24);
				frmMenuAdicionar.getContentPane().add(textoStatus);
		comboBoxStatus.setToolTipText("Selecione o status");
		comboBoxStatus.setBounds(46, 350, 552, 36);
		frmMenuAdicionar.getContentPane().add(comboBoxStatus);
		
				JButton botaoAdicionar = new JButton("ADICIONAR SÉRIE");
				botaoAdicionar.setBackground(Color.LIGHT_GRAY);
				botaoAdicionar.setForeground(Color.BLACK);
				botaoAdicionar.setFont(new Font("Arial", Font.BOLD, 20));
				botaoAdicionar.setBounds(46, 420, 227, 36);
				frmMenuAdicionar.getContentPane().add(botaoAdicionar);
				
						botaoAdicionar.addActionListener(new ActionListener() {
				
							public void actionPerformed(ActionEvent e) {
								try {
									if (seriesDAO.adiciona(new Serie(campoNome, comboBoxStatus, campoTemporadas, campoEpisodios),
											true)) {
				
										JOptionPane.showMessageDialog(null,
												"A série " + "'" + campoNome.getText().strip() + "'" + " foi adicionada!",
												"Série adicionada", JOptionPane.INFORMATION_MESSAGE);
				
										campoNome.setText(null);
										campoTemporadas.setText(null);
										campoEpisodios.setText(null);
									}
								} catch (InfoInvalidaException iIE) {
				
								}
							}
						});

		JButton botaoConsultar = new JButton("CONSULTAR SÉRIE");
		botaoConsultar.setBackground(Color.LIGHT_GRAY);
		botaoConsultar.setForeground(Color.BLACK);
		botaoConsultar.setFont(new Font("Arial", Font.BOLD, 20));
		botaoConsultar.setBounds(371, 420, 227, 36);
		frmMenuAdicionar.getContentPane().add(botaoConsultar);

		botaoConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMenuConsultar.main(null);
				frmMenuAdicionar.setVisible(false);
			}
		});

	}
}
