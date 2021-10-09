
package br.com.projeto.edutech.interface_grafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
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

public class MenuAdicionar {

	private JFrame telaMenuAdicionar;
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
					MenuAdicionar window = new MenuAdicionar();
					window.telaMenuAdicionar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuAdicionar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// cria o Jframe
		telaMenuAdicionar = new JFrame();
		telaMenuAdicionar.setResizable(false);
		telaMenuAdicionar.setBackground(SystemColor.desktop);
		telaMenuAdicionar.getContentPane().setBackground(SystemColor.inactiveCaption);
		telaMenuAdicionar.setTitle("ORGANIZADOR DE SÉRIES");
		telaMenuAdicionar.setBounds(100, 100, 640, 480);
		telaMenuAdicionar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaMenuAdicionar.getContentPane().setLayout(null);
		telaMenuAdicionar.setLocation(600, 200);
		//

		// texto adicionar séries
		JLabel textoTitulo = new JLabel("ADICIONAR SÉRIES");
		textoTitulo.setForeground(Color.BLACK);
		textoTitulo.setBackground(Color.LIGHT_GRAY);
		textoTitulo.setFont(new Font("Arial", Font.BOLD, 30));
		textoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		textoTitulo.setBounds(168, 10, 287, 36);
		telaMenuAdicionar.getContentPane().add(textoTitulo);
		//

		// texto nome
		JLabel textoNome = new JLabel("NOME");
		textoNome.setBackground(Color.LIGHT_GRAY);
		textoNome.setHorizontalAlignment(SwingConstants.LEFT);
		textoNome.setFont(new Font("Arial", Font.BOLD, 20));
		textoNome.setBounds(36, 70, 60, 24);
		telaMenuAdicionar.getContentPane().add(textoNome);
		//

		// campo de texto do nome
		campoNome = new JTextField();
		campoNome.setBackground(Color.WHITE);
		campoNome.setToolTipText("Digite o nome da série");
		campoNome.setFont(new Font("Arial", Font.PLAIN, 18));
		campoNome.setBounds(36, 90, 552, 36);
		campoNome.setColumns(10);
		telaMenuAdicionar.getContentPane().add(campoNome);
		//
		
		// texto temporadas
		JLabel textoTemporadas = new JLabel("TEMPORADAS");
		textoTemporadas.setHorizontalAlignment(SwingConstants.LEFT);
		textoTemporadas.setFont(new Font("Arial", Font.BOLD, 20));
		textoTemporadas.setBackground(Color.LIGHT_GRAY);
		textoTemporadas.setBounds(36, 150, 139, 24);
		telaMenuAdicionar.getContentPane().add(textoTemporadas);
		//

		// campo de texto das temporadas
		campoTemporadas = new JTextField();
		campoTemporadas.setBackground(Color.WHITE);
		campoTemporadas.setToolTipText("Digite o número de temporadas");
		campoTemporadas.setFont(new Font("Arial", Font.PLAIN, 18));
		campoTemporadas.setBounds(36, 170, 552, 36);
		telaMenuAdicionar.getContentPane().add(campoTemporadas);
		campoTemporadas.setColumns(10);
		//

		// texto episódios
		JLabel textoEpisodios = new JLabel("EPISÓDIOS");
		textoEpisodios.setHorizontalAlignment(SwingConstants.LEFT);
		textoEpisodios.setFont(new Font("Arial", Font.BOLD, 20));
		textoEpisodios.setBackground(Color.LIGHT_GRAY);
		textoEpisodios.setBounds(36, 230, 108, 24);
		telaMenuAdicionar.getContentPane().add(textoEpisodios);
		//

		// campo de texto dos episodios
		campoEpisodios = new JTextField();
		campoEpisodios.setBackground(Color.WHITE);
		campoEpisodios.setToolTipText("Digite o número de episódios");
		campoEpisodios.setFont(new Font("Arial", Font.PLAIN, 18));
		campoEpisodios.setBounds(36, 250, 552, 36);
		telaMenuAdicionar.getContentPane().add(campoEpisodios);
		campoEpisodios.setColumns(10);
		//

		// combo box do status
		comboBoxStatus = new JComboBox<>();
		comboBoxStatus.setBackground(Color.GRAY);
		comboBoxStatus.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBoxStatus.addItem("ASSISTIDO");
		comboBoxStatus.addItem("ASSISTIREI");
		comboBoxStatus.addItem("ASSISTINDO");
		comboBoxStatus.addItem("RETOMAREI");
		comboBoxStatus.setToolTipText("Selecione o status");
		comboBoxStatus.setBounds(36, 330, 552, 36);
		telaMenuAdicionar.getContentPane().add(comboBoxStatus);
		//

		// texto status
		JLabel textoStatus = new JLabel("STATUS");
		textoStatus.setHorizontalAlignment(SwingConstants.LEFT);
		textoStatus.setFont(new Font("Arial", Font.BOLD, 20));
		textoStatus.setBackground(Color.LIGHT_GRAY);
		textoStatus.setBounds(36, 310, 79, 24);
		telaMenuAdicionar.getContentPane().add(textoStatus);
		//
		
		// botão adicionar
		JButton botaoAdicionar = new JButton("ADICIONAR");
		botaoAdicionar.setBackground(Color.LIGHT_GRAY);
		botaoAdicionar.setForeground(Color.BLACK);
		botaoAdicionar.setFont(new Font("Arial", Font.BOLD, 20));
		botaoAdicionar.setBounds(361, 400, 227, 36);
		telaMenuAdicionar.getContentPane().add(botaoAdicionar);
		//

		// botão voltar
		JButton botaoVoltar = new JButton("VOLTAR");
		botaoVoltar.setForeground(Color.BLACK);
		botaoVoltar.setFont(new Font("Arial", Font.BOLD, 20));
		botaoVoltar.setBackground(Color.LIGHT_GRAY);
		botaoVoltar.setBounds(36, 400, 227, 36);
		telaMenuAdicionar.getContentPane().add(botaoVoltar);
		//
		
		// ação executada pelo botão voltar
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal.main(null);
				telaMenuAdicionar.setVisible(false);
			}
		});
		//
		
		// ação executada pelo botão adicionar
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
		//
		
	}
}
