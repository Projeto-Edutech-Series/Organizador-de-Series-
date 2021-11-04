package br.com.projeto.edutech.interface_grafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import br.com.projeto.edutech.dao.SeriesDAO;
import br.com.projeto.edutech.modelo.InfoInvalidaException;
import br.com.projeto.edutech.modelo.Serie;

public class MenuAlterar {

	private JFrame telaMenuAlterar;
	private DefaultTableModel modelo;
	private JTable tabelaSeries;
	private SeriesDAO seriesDAO = new SeriesDAO();
	private JButton botaoAlterar;
	private JButton botaoVoltar;
	public static String nomeAntigo;
	public static String statusAntigo;
	public static String temporadaAntiga;
	public static String episodiosAntigos;
	

	/**
	 * Launch the application.
	 * 
	 * @return
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
					MenuAlterar window = new MenuAlterar();
					window.telaMenuAlterar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuAlterar() {
		initialize();
	}

	public MenuAlterar(String nome, String status, String temporadas, String episodios) {
		this.nomeAntigo = nome;
		this.statusAntigo = status;
		this.temporadaAntiga = temporadas;
		this.episodiosAntigos = episodios;
	}

	/**
	 * Create the application.
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// cria o JFrame
		telaMenuAlterar = new JFrame();
		telaMenuAlterar.setFont(new Font("Arial", Font.BOLD, 12));
		telaMenuAlterar.setTitle("ORGANIZADOR DE SÉRIES");
		telaMenuAlterar.setResizable(false);
		telaMenuAlterar.getContentPane().setFont(new Font("SansSerif", Font.PLAIN, 12));
		telaMenuAlterar.getContentPane().setBackground(new Color(220, 220, 220));
		telaMenuAlterar.setBounds(100, 100, 640, 600);
		telaMenuAlterar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaMenuAlterar.setLocation(600, 200);
		telaMenuAlterar.getContentPane().setLayout(null);

		// titulo
		JLabel textoTitulo = new JLabel("Atualizar");
		textoTitulo.setForeground(Color.BLACK);
		textoTitulo.setBackground(Color.LIGHT_GRAY);
		textoTitulo.setFont(new Font("Arial", Font.BOLD, 30));
		textoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		textoTitulo.setBounds(168, 10, 287, 36);
		telaMenuAlterar.getContentPane().add(textoTitulo);

		// nome
		JLabel textoNome = new JLabel("NOME:");
		textoNome.setBackground(Color.LIGHT_GRAY);
		textoNome.setHorizontalAlignment(SwingConstants.LEFT);
		textoNome.setFont(new Font("Arial", Font.BOLD, 20));
		textoNome.setBounds(36, 70, 70, 24);
		telaMenuAlterar.getContentPane().add(textoNome);

		// texto nome antigo
		JLabel textoNomeAntigo = new JLabel(nomeAntigo);
		textoNomeAntigo.setHorizontalAlignment(SwingConstants.LEFT);
		textoNomeAntigo.setFont(new Font("Arial", Font.PLAIN, 20));
		textoNomeAntigo.setBackground(Color.LIGHT_GRAY);
		textoNomeAntigo.setBounds(106, 70, 100, 24);
		telaMenuAlterar.getContentPane().add(textoNomeAntigo);

		// digita texto
		JTextField campoNome = new JTextField();
		campoNome.setBackground(Color.WHITE);
		campoNome.setToolTipText("Digite o nome da série");
		campoNome.setFont(new Font("Arial", Font.PLAIN, 18));
		campoNome.setBounds(36, 90, 552, 36);
		campoNome.setColumns(10);
		telaMenuAlterar.getContentPane().add(campoNome);
		//

		//

		// texto temporadas
		JLabel textoTemporadas = new JLabel("TEMPORADAS:");
		textoTemporadas.setHorizontalAlignment(SwingConstants.LEFT);
		textoTemporadas.setFont(new Font("Arial", Font.BOLD, 20));
		textoTemporadas.setBackground(Color.LIGHT_GRAY);
		textoTemporadas.setBounds(36, 150, 150, 24);
		telaMenuAlterar.getContentPane().add(textoTemporadas);

		// temporadas antiga
		JLabel textoTemporadaAntiga = new JLabel(temporadaAntiga);
		textoTemporadaAntiga.setHorizontalAlignment(SwingConstants.LEFT);
		textoTemporadaAntiga.setFont(new Font("Arial", Font.BOLD, 20));
		textoTemporadaAntiga.setBackground(Color.LIGHT_GRAY);
		textoTemporadaAntiga.setBounds(190, 150, 139, 24);
		telaMenuAlterar.getContentPane().add(textoTemporadaAntiga);

		// campo de texto das temporadas
		JTextField campoTemporadas = new JTextField();
		campoTemporadas.setBackground(Color.WHITE);
		campoTemporadas.setToolTipText("Digite o número de temporadas");
		campoTemporadas.setFont(new Font("Arial", Font.PLAIN, 18));
		campoTemporadas.setBounds(36, 170, 552, 36);
		telaMenuAlterar.getContentPane().add(campoTemporadas);
		campoTemporadas.setColumns(10);
		//

		// texto episódios
		JLabel textoEpisodios = new JLabel("EPISÓDIOS:");
		textoEpisodios.setHorizontalAlignment(SwingConstants.LEFT);
		textoEpisodios.setFont(new Font("Arial", Font.BOLD, 20));
		textoEpisodios.setBackground(Color.LIGHT_GRAY);
		textoEpisodios.setBounds(36, 230, 120, 24);
		telaMenuAlterar.getContentPane().add(textoEpisodios);

		JLabel textoEpisodiosAntigos = new JLabel(episodiosAntigos);
		textoEpisodiosAntigos.setHorizontalAlignment(SwingConstants.LEFT);
		textoEpisodiosAntigos.setFont(new Font("Arial", Font.BOLD, 20));
		textoEpisodiosAntigos.setBackground(Color.LIGHT_GRAY);
		textoEpisodiosAntigos.setBounds(160, 230, 108, 24);
		telaMenuAlterar.getContentPane().add(textoEpisodiosAntigos);

		// campo de texto dos episodios
		JTextField campoEpisodios = new JTextField();
		campoEpisodios.setBackground(Color.WHITE);
		campoEpisodios.setToolTipText("Digite o número de episódios");
		campoEpisodios.setFont(new Font("Arial", Font.PLAIN, 18));
		campoEpisodios.setBounds(36, 250, 552, 36);
		telaMenuAlterar.getContentPane().add(campoEpisodios);
		campoEpisodios.setColumns(10);
		//
		// texto status
		JLabel textoStatus = new JLabel("STATUS:");
		textoStatus.setHorizontalAlignment(SwingConstants.LEFT);
		textoStatus.setFont(new Font("Arial", Font.BOLD, 20));
		textoStatus.setBackground(Color.LIGHT_GRAY);
		textoStatus.setBounds(36, 310, 90, 24);
		telaMenuAlterar.getContentPane().add(textoStatus);

		JLabel textoStatusAntigo = new JLabel(statusAntigo);
		textoStatusAntigo.setHorizontalAlignment(SwingConstants.LEFT);
		textoStatusAntigo.setFont(new Font("Arial", Font.BOLD, 20));
		textoStatusAntigo.setBackground(Color.LIGHT_GRAY);
		textoStatusAntigo.setBounds(130, 310, 550, 24);
		telaMenuAlterar.getContentPane().add(textoStatusAntigo);

		// combo box do status
		JComboBox<String> comboBoxStatus = new JComboBox<>();
		comboBoxStatus.setBackground(Color.GRAY);
		comboBoxStatus.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBoxStatus.addItem("ASSISTIDO");
		comboBoxStatus.addItem("ASSISTIREI");
		comboBoxStatus.addItem("ASSISTINDO");
		comboBoxStatus.addItem("RETOMAREI");
		comboBoxStatus.setToolTipText("Selecione o status");
		comboBoxStatus.setBounds(36, 330, 552, 36);
		telaMenuAlterar.getContentPane().add(comboBoxStatus);
		//

		// botão voltar
		botaoVoltar = new JButton("VOLTAR");
		botaoVoltar.setBackground(Color.LIGHT_GRAY);
		botaoVoltar.setForeground(Color.BLACK);
		botaoVoltar.setFont(new Font("Arial", Font.BOLD, 20));
		botaoVoltar.setBounds(12, 400, 175, 36);
		telaMenuAlterar.getContentPane().add(botaoVoltar);
		//

		// botão alterar
		botaoAlterar = new JButton("SALVAR");
		botaoAlterar.setBackground(Color.LIGHT_GRAY);
		botaoAlterar.setForeground(Color.BLACK);
		botaoAlterar.setFont(new Font("Arial", Font.BOLD, 20));
		botaoAlterar.setBounds(437, 400, 175, 36);
		telaMenuAlterar.getContentPane().add(botaoAlterar);

		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuConsultar.main(null);
				telaMenuAlterar.setVisible(false);
			}
		});

		botaoAlterar.addActionListener(new ActionListener() {
			public String novoNome;
			public String novoStatus;
			public Integer novaTemporada;
			public Integer novosEpisodios;
			public void actionPerformed(ActionEvent e) {
					seriesDAO.deletar(nomeAntigo);
					if (!campoNome.getText().strip().isEmpty()) {
						this.novoNome = campoNome.getText().strip();
					} else {
						this.novoNome = nomeAntigo;
					}
					if (!campoTemporadas.getText().strip().isEmpty()) {
						this.novaTemporada = Integer.parseInt(campoTemporadas.getText().strip());
					} else {
						this.novaTemporada = Integer.parseInt(temporadaAntiga);
					}
					if (!campoEpisodios.getText().strip().isEmpty()) {
						this.novosEpisodios = Integer.parseInt(campoEpisodios.getText().strip());
					} else {
						this.novosEpisodios = Integer.parseInt(episodiosAntigos);
					}
					this.novoStatus = comboBoxStatus.getSelectedItem().toString();
					comboBoxStatus.setSelectedIndex(0);
					if (!seriesDAO.jaExiste(new Serie(novoNome, novoStatus, novaTemporada, novosEpisodios))) {
						
						if (seriesDAO.adiciona(new Serie(novoNome, novoStatus, novaTemporada, novosEpisodios), true)) {
							JOptionPane.showMessageDialog(null,
									"A série " + "'" + novoNome + "'" + " foi Atualizada!", "Série Atualizada!",
									JOptionPane.INFORMATION_MESSAGE);
							campoNome.setText(null);
							campoTemporadas.setText(null);
							campoEpisodios.setText(null);
						}
						MenuConsultar.main(null);
						telaMenuAlterar.setVisible(false);
					} else {
						seriesDAO.adiciona(new Serie(nomeAntigo, statusAntigo, Integer.parseInt(episodiosAntigos), Integer.parseInt(episodiosAntigos)), true);
						JOptionPane.showMessageDialog(null,
								"A série " + "'" + campoNome.getText().strip() + "'" + " já esta no registro!");
					}
			};
		});
	}
}
