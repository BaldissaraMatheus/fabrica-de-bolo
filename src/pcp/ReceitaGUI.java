package pcp;

import venda.*;
import estoque.Estoque;
import estoque.Produto;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pcp.Producao;
import rh.RH;

public class ReceitaGUI extends javax.swing.JFrame {
    private Receita receita = new Receita();
    
    private int topo;
    
    public ReceitaGUI() {
        initComponents();
    }
    
    private void atualizaTabela(Produto ingrediente) {
        jTableReceita.setValueAt(ingrediente.getNome(), topo, 0);
        jTableReceita.setValueAt(String.valueOf(ingrediente.getQuantidade()), topo, 1);
        jTableReceita.setValueAt(ingrediente.getUnidade(), topo, 2);       
    }
    
    private void limpaCampos() {
        jTextFieldNomeProduto.setText("");
        quantidadeTextField.setText("");
        receitaTextField.setText("");
        unidadeTextField.setText("");
        equipeMinimaTextField.setText("");
    }
    
    private void limpaIngredientes() {
        jTextFieldNomeProduto.setText("");
        quantidadeTextField.setText("");
        unidadeTextField.setText("");
        equipeMinimaTextField.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNomeProduto = new javax.swing.JLabel();
        jLabelQuantidadeProduto = new javax.swing.JLabel();
        quantidadeTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableReceita = new javax.swing.JTable();
        jButtonAdicionarProduto = new javax.swing.JButton();
        cadastrarReceitaBtn = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jTextFieldNomeProduto = new javax.swing.JTextField();
        jButtonRemoverProduto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        equipeMinimaTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        unidadeTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        receitaTextField = new javax.swing.JTextField();
        jLabelIngrediente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelNomeProduto.setText("Nome:");

        jLabelQuantidadeProduto.setText("Quantidade:");

        jTableReceita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome do produto", "Quantidade", "Unidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableReceita);
        if (jTableReceita.getColumnModel().getColumnCount() > 0) {
            jTableReceita.getColumnModel().getColumn(0).setResizable(false);
            jTableReceita.getColumnModel().getColumn(1).setResizable(false);
            jTableReceita.getColumnModel().getColumn(2).setResizable(false);
        }

        jButtonAdicionarProduto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonAdicionarProduto.setText("Adicionar ingrediente");
        jButtonAdicionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarProdutoActionPerformed(evt);
            }
        });

        cadastrarReceitaBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cadastrarReceitaBtn.setText("Cadastrar receita");
        cadastrarReceitaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarReceitaBtnActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Voltar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jTextFieldNomeProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNomeProdutoFocusLost(evt);
            }
        });
        jTextFieldNomeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeProdutoActionPerformed(evt);
            }
        });

        jButtonRemoverProduto.setText("Remover ingrediente");
        jButtonRemoverProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverProdutoActionPerformed(evt);
            }
        });

        jLabel1.setText("Equipe mínima:");

        jLabel2.setText("Unidade:");

        jLabel3.setText("Nome da receita:");

        jLabelIngrediente.setText("Ingrediente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(equipeMinimaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(receitaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cadastrarReceitaBtn)))
                        .addContainerGap(48, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAdicionarProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRemoverProduto))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabelQuantidadeProduto)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(quantidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(unidadeTextField))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabelNomeProduto)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabelIngrediente))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(receitaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jLabelIngrediente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeProduto)
                    .addComponent(jTextFieldNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelQuantidadeProduto)
                    .addComponent(quantidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(unidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdicionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRemoverProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(equipeMinimaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastrarReceitaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNomeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeProdutoActionPerformed
        jTextFieldNomeProduto.setText("");
    }//GEN-LAST:event_jTextFieldNomeProdutoActionPerformed

    private void jButtonRemoverProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverProdutoActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) this.jTableReceita.getModel();
            int[] rows = jTableReceita.getSelectedRows();

            this.receita.removeIngrediente(jTableReceita.getModel().getValueAt(jTableReceita.getSelectedRow(), 0).toString());

            for (int i = 0; i < rows.length; i++) {
                model.removeRow(rows[i] - i);
            }

            this.limpaCampos();
            this.topo--;  
            
        } catch (ArrayIndexOutOfBoundsException err) {
           JOptionPane.showMessageDialog(null, "Selecione o item a ser removido!");
        }
    }//GEN-LAST:event_jButtonRemoverProdutoActionPerformed

    private void jTextFieldNomeProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNomeProdutoFocusLost

    }//GEN-LAST:event_jTextFieldNomeProdutoFocusLost
    
    private void jButtonAdicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarProdutoActionPerformed
        try {
            String nome = jTextFieldNomeProduto.getText();
            float quantidade = Float.parseFloat(quantidadeTextField.getText());            
            String unidade = unidadeTextField.getText();                                                                  
                    
                    Produto ingrediente = new Produto(
                            nome,
                            quantidade,
                            unidade,
                            new Date()
                    );

                    this.atualizaTabela(ingrediente);                                        
                    this.receita.adicionaIngrediente(ingrediente);                                 
                    this.topo++;
                    limpaIngredientes();

        } catch (NumberFormatException err) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!!");
            
        }
    }//GEN-LAST:event_jButtonAdicionarProdutoActionPerformed
     
    private void cadastrarReceitaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarReceitaBtnActionPerformed
        try {
            int equipeNecessaria = Integer.parseInt(equipeMinimaTextField.getText());
            String nomeReceita = receitaTextField.getText();
            DefaultTableModel tabela = (DefaultTableModel) this.jTableReceita.getModel();
            
            if (nomeReceita.equals("")) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                return;
            }
            
            if (Producao.buscaReceita(nomeReceita) != null) {
                 JOptionPane.showMessageDialog(null, "Receita já cadastrada!");
                return;
            }
            
            this.receita.setNome(nomeReceita);
            this.receita.setEquipeMinima(equipeNecessaria);
            Producao.cadastraReceita(this.receita);
            Produto produto = new Produto(receita.getNome(), 0, "Unidades", new Date());
            Estoque.adicionaProduto(produto);
            JOptionPane.showMessageDialog(null, "Receita cadastrada com sucesso!");  
            limpaCampos();
            
            for (int row = 0; row < tabela.getRowCount(); row++) {
                        for (int i = 0; i < 3; i++) {
                            jTableReceita.setValueAt("", row, i);
                        }                
                    }      
        } catch (NumberFormatException err) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }
    }//GEN-LAST:event_cadastrarReceitaBtnActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceitaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarReceitaBtn;
    private javax.swing.JTextField equipeMinimaTextField;
    private javax.swing.JButton jButtonAdicionarProduto;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonRemoverProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelIngrediente;
    private javax.swing.JLabel jLabelNomeProduto;
    private javax.swing.JLabel jLabelQuantidadeProduto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableReceita;
    private javax.swing.JTextField jTextFieldNomeProduto;
    private javax.swing.JTextField quantidadeTextField;
    private javax.swing.JTextField receitaTextField;
    private javax.swing.JTextField unidadeTextField;
    // End of variables declaration//GEN-END:variables
}
