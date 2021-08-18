package br.com.projeto.edutech.interface_grafica;


public class InterfacePrincipal extends javax.swing.JFrame {
	
    /**
	 * serialVersionUID gerado pelo eclipse.
	 */
	private static final long serialVersionUID = -4329638489808617769L;
	
	/**
     * Cria o novo formulário InterfacePrincipal.
     */
	
    public InterfacePrincipal() {
        initComponents();
    }

    /**
     * Esse método é chamado de dentro do construtor para inicializar o formulário.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        BotoesSituacao = new javax.swing.ButtonGroup();
        Gerenciamento = new javax.swing.JPanel();
        Nome = new javax.swing.JLabel();
        NomeCampo = new javax.swing.JTextField();
        TemporadasSagas = new javax.swing.JLabel();
        TemporadasSagasCampo = new javax.swing.JTextField();
        Episodios = new javax.swing.JLabel();
        EpisodiosCampo = new javax.swing.JTextField();
        Situacao = new javax.swing.JLabel();
        Assistirei = new javax.swing.JRadioButton();
        Assistindo = new javax.swing.JRadioButton();
        Retomar = new javax.swing.JRadioButton();
        Terminado = new javax.swing.JRadioButton();
        Adicionar = new javax.swing.JButton();
        PainelTitulo = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Organizador de Séries");
        setLocation(new java.awt.Point(700, 200));
        setResizable(false);

        Nome.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Nome.setText("Nome:");

        TemporadasSagas.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TemporadasSagas.setText("Temporadas:");

        Episodios.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Episodios.setText("Episódios:");

        Situacao.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Situacao.setText("Situação:");

        BotoesSituacao.add(Assistirei);
        Assistirei.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Assistirei.setText("Assistirei");

        BotoesSituacao.add(Assistindo);
        Assistindo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Assistindo.setText("Assistindo");

        BotoesSituacao.add(Retomar);
        Retomar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Retomar.setText("Retomar");

        BotoesSituacao.add(Terminado);
        Terminado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Terminado.setText("Terminado");

        Adicionar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Adicionar.setText("Adicionar");
        Adicionar.setMaximumSize(new java.awt.Dimension(70, 37));
        Adicionar.setMinimumSize(new java.awt.Dimension(70, 37));
        Adicionar.setPreferredSize(new java.awt.Dimension(70, 37));

        javax.swing.GroupLayout GerenciamentoLayout = new javax.swing.GroupLayout(Gerenciamento);
        Gerenciamento.setLayout(GerenciamentoLayout);
        GerenciamentoLayout.setHorizontalGroup(
            GerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GerenciamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Adicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GerenciamentoLayout.createSequentialGroup()
                        .addComponent(Nome)
                        .addGap(18, 18, 18)
                        .addComponent(NomeCampo))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GerenciamentoLayout.createSequentialGroup()
                        .addComponent(TemporadasSagas)
                        .addGap(18, 18, 18)
                        .addComponent(TemporadasSagasCampo))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GerenciamentoLayout.createSequentialGroup()
                        .addComponent(Episodios)
                        .addGap(18, 18, 18)
                        .addComponent(EpisodiosCampo))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GerenciamentoLayout.createSequentialGroup()
                        .addComponent(Situacao)
                        .addGap(18, 18, 18)
                        .addComponent(Assistirei)
                        .addGap(18, 18, 18)
                        .addComponent(Assistindo)
                        .addGap(18, 18, 18)
                        .addComponent(Retomar)
                        .addGap(20, 20, 20)
                        .addComponent(Terminado)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        GerenciamentoLayout.setVerticalGroup(
            GerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GerenciamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nome)
                    .addComponent(NomeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(GerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TemporadasSagas)
                    .addComponent(TemporadasSagasCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(GerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Episodios)
                    .addComponent(EpisodiosCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(GerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Assistirei)
                    .addComponent(Assistindo)
                    .addComponent(Situacao)
                    .addComponent(Retomar)
                    .addComponent(Terminado))
                .addGap(18, 18, 18)
                .addComponent(Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        Titulo.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Gerenciador de Séries");

        javax.swing.GroupLayout PainelTituloLayout = new javax.swing.GroupLayout(PainelTitulo);
        PainelTitulo.setLayout(PainelTituloLayout);
        PainelTituloLayout.setHorizontalGroup(
            PainelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PainelTituloLayout.setVerticalGroup(
            PainelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PainelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Gerenciamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(Gerenciamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }

    // Declaração das variaveis - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Adicionar;
    private javax.swing.JRadioButton Assistindo;
    private javax.swing.JRadioButton Assistirei;
    private javax.swing.ButtonGroup BotoesSituacao;
    private javax.swing.JLabel Episodios;
    private javax.swing.JTextField EpisodiosCampo;
    private javax.swing.JPanel Gerenciamento;
    private javax.swing.JLabel Nome;
    private javax.swing.JTextField NomeCampo;
    private javax.swing.JPanel PainelTitulo;
    private javax.swing.JRadioButton Retomar;
    private javax.swing.JLabel Situacao;
    private javax.swing.JLabel TemporadasSagas;
    private javax.swing.JTextField TemporadasSagasCampo;
    private javax.swing.JRadioButton Terminado;
    private javax.swing.JLabel Titulo;
    // fim da declaração das variaveis//GEN-END:variables
}
