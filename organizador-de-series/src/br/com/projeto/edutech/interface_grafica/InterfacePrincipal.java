package br.com.projeto.edutech.interface_grafica;

/**
 *
 * @author João Gabriel Nascimento
 */
public class InterfacePrincipal extends javax.swing.JFrame {
    
    private String nomeNovaSerie;
    private int nEpisodiosNovaSerie;
    /**
     * Creates new form InterfacePrincipal
     */
    public InterfacePrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupStatus = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        LabelNome = new javax.swing.JLabel();
        TextFieldNome = new javax.swing.JTextField();
        LabelStatus = new javax.swing.JLabel();
        RarioButtonAssistido = new javax.swing.JRadioButton();
        RadioButtonAssistindo = new javax.swing.JRadioButton();
        RadioButtonAssistirei = new javax.swing.JRadioButton();
        LabelNome1 = new javax.swing.JLabel();
        TextFieldEpisodios = new javax.swing.JTextField();
        ButtonAdicionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Organizador de Séries");
        setLocation(new java.awt.Point(800, 400));
        setResizable(false);

        LabelNome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        LabelNome.setText("Nome:");
        LabelNome.setToolTipText("Nome da série");
        LabelNome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        TextFieldNome.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                TextFieldNomeInputMethodTextChanged(evt);
            }
        });
        TextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldNomeActionPerformed(evt);
            }
        });

        LabelStatus.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        LabelStatus.setText("Status:");
        LabelStatus.setToolTipText("Status da série");

        buttonGroupStatus.add(RarioButtonAssistido);
        RarioButtonAssistido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RarioButtonAssistido.setText("Assistido");
        RarioButtonAssistido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RarioButtonAssistidoActionPerformed(evt);
            }
        });

        buttonGroupStatus.add(RadioButtonAssistindo);
        RadioButtonAssistindo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RadioButtonAssistindo.setText("Assistindo");
        RadioButtonAssistindo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonAssistindoActionPerformed(evt);
            }
        });

        buttonGroupStatus.add(RadioButtonAssistirei);
        RadioButtonAssistirei.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RadioButtonAssistirei.setText("Assistirei");
        RadioButtonAssistirei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonAssistireiActionPerformed(evt);
            }
        });

        LabelNome1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        LabelNome1.setText("Episódios:");
        LabelNome1.setToolTipText("Nome da série");
        LabelNome1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        TextFieldEpisodios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldEpisodiosActionPerformed(evt);
            }
        });

        ButtonAdicionar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ButtonAdicionar.setText("Adicionar");
        ButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(RarioButtonAssistido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(RadioButtonAssistindo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(RadioButtonAssistirei))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LabelNome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldEpisodios, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(ButtonAdicionar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RarioButtonAssistido)
                    .addComponent(RadioButtonAssistindo)
                    .addComponent(RadioButtonAssistirei))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldEpisodios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(ButtonAdicionar)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldNomeActionPerformed
        
    }//GEN-LAST:event_TextFieldNomeActionPerformed

    private void RarioButtonAssistidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RarioButtonAssistidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RarioButtonAssistidoActionPerformed

    private void RadioButtonAssistindoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonAssistindoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioButtonAssistindoActionPerformed

    private void RadioButtonAssistireiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonAssistireiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioButtonAssistireiActionPerformed

    private void TextFieldEpisodiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldEpisodiosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldEpisodiosActionPerformed

    private void ButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAdicionarActionPerformed
        System.out.println(this.nomeNovaSerie);
    }//GEN-LAST:event_ButtonAdicionarActionPerformed

    private void TextFieldNomeInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_TextFieldNomeInputMethodTextChanged
        this.nomeNovaSerie = evt.getText().toString();
    }//GEN-LAST:event_TextFieldNomeInputMethodTextChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfacePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfacePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfacePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfacePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfacePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAdicionar;
    private javax.swing.JLabel LabelNome;
    private javax.swing.JLabel LabelNome1;
    private javax.swing.JLabel LabelStatus;
    private javax.swing.JRadioButton RadioButtonAssistindo;
    private javax.swing.JRadioButton RadioButtonAssistirei;
    private javax.swing.JRadioButton RarioButtonAssistido;
    private javax.swing.JTextField TextFieldEpisodios;
    private javax.swing.JTextField TextFieldNome;
    private javax.swing.ButtonGroup buttonGroupStatus;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
