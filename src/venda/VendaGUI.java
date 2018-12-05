package venda;

import estoque.Estoque;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import estoque.Produto;
import pcp.CadastraRceitaGUI;
import pcp.Producao;

public class VendaGUI extends javax.swing.JFrame {
    private Venda venda = new Venda();
        
    private float valorTotal;
    private int topo;
    
    public VendaGUI() {
        initComponents();
    }
    
    private void atualizaTabela(String nome, String quantidade, String valorUnitario, String subtotal) {
        jTableVenda.setValueAt(nome, topo, 0);
        jTableVenda.setValueAt(quantidade, topo, 1);
        jTableVenda.setValueAt(valorUnitario, topo, 2);
        jTableVenda.setValueAt(subtotal, topo, 3);        
    }
    
    private void limpaCampos() {
        jTextFieldNomeProduto.setText("");
        jTextFieldQuantidadeProduto.setText("");
        jTextFieldPreco.setText("0.00"); 
    }
    
    private void atualizaValorTotal(float valor) {
        this.valorTotal += valor;
        jTextFieldTotalVenda.setText(String.valueOf(valorTotal));
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNomeProduto = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
        jLabelQuantidadeProduto = new javax.swing.JLabel();
        jTextFieldQuantidadeProduto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVenda = new javax.swing.JTable();
        jLabelTotalVenda = new javax.swing.JLabel();
        jTextFieldTotalVenda = new javax.swing.JTextField();
        jButtonAdicionarProduto = new javax.swing.JButton();
        jButtonConfirmarVenda = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelPreco = new javax.swing.JLabel();
        jTextFieldNomeProduto = new javax.swing.JTextField();
        jLabelTroco = new javax.swing.JLabel();
        jTextFieldTroco = new javax.swing.JTextField();
        jLabelValorPago = new javax.swing.JLabel();
        jTextFieldValorPago = new javax.swing.JTextField();
        jButtonRemoverProduto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelNomeProduto.setText("Nome:");

        jTextFieldPreco.setEditable(false);

        jLabelQuantidadeProduto.setText("Quantidade:");

        jTableVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome do produto", "Quantidade", "Valor unitário", "Sub-total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableVenda);
        if (jTableVenda.getColumnModel().getColumnCount() > 0) {
            jTableVenda.getColumnModel().getColumn(0).setResizable(false);
            jTableVenda.getColumnModel().getColumn(1).setResizable(false);
            jTableVenda.getColumnModel().getColumn(2).setResizable(false);
            jTableVenda.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabelTotalVenda.setText("Total da venda: R$");

        jTextFieldTotalVenda.setEditable(false);

        jButtonAdicionarProduto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonAdicionarProduto.setText("Adicionar produto");
        jButtonAdicionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarProdutoActionPerformed(evt);
            }
        });

        jButtonConfirmarVenda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonConfirmarVenda.setText("Confirmar venda");
        jButtonConfirmarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarVendaActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Voltar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabelPreco.setText("Preço: R$");

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

        jLabelTroco.setText("Troco: R$");

        jTextFieldTroco.setEditable(false);

        jLabelValorPago.setText("Valor pago: R$");

        jTextFieldValorPago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldValorPagoFocusLost(evt);
            }
        });

        jButtonRemoverProduto.setText("Remover produto");
        jButtonRemoverProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonCancelar)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelTotalVenda)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabelValorPago)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 66, Short.MAX_VALUE)
                                    .addComponent(jButtonConfirmarVenda))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelTroco)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelQuantidadeProduto)
                                .addComponent(jLabelNomeProduto))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldQuantidadeProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                .addComponent(jTextFieldNomeProduto))
                            .addGap(68, 68, 68)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelPreco)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButtonAdicionarProduto))
                            .addGap(119, 119, 119))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButtonRemoverProduto)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeProduto)
                    .addComponent(jLabelPreco)
                    .addComponent(jTextFieldNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelQuantidadeProduto)
                    .addComponent(jTextFieldQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdicionarProduto))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRemoverProduto)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTroco)
                    .addComponent(jTextFieldTroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTotalVenda)
                    .addComponent(jTextFieldTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelValorPago)
                    .addComponent(jTextFieldValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonConfirmarVenda))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNomeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeProdutoActionPerformed
        jTextFieldNomeProduto.setText("");
    }//GEN-LAST:event_jTextFieldNomeProdutoActionPerformed

    private void jButtonRemoverProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverProdutoActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) this.jTableVenda.getModel();
            int[] rows = jTableVenda.getSelectedRows();

            float quantidade = Float.parseFloat(jTableVenda.getModel().getValueAt(jTableVenda.getSelectedRow(), 1).toString());
            float valorUnitario = Float.parseFloat(jTableVenda.getModel().getValueAt(jTableVenda.getSelectedRow(), 2).toString());

            this.atualizaValorTotal(-(valorUnitario * quantidade));

            this.venda.removeItens(jTableVenda.getModel().getValueAt(jTableVenda.getSelectedRow(), 0).toString());
            this.venda.listaItens();

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
        jTextFieldPreco.setText("21.12");
    }//GEN-LAST:event_jTextFieldNomeProdutoFocusLost
    
    private void jButtonAdicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarProdutoActionPerformed
        try {
            String nome = jTextFieldNomeProduto.getText();
            float quantidade = Float.parseFloat(jTextFieldQuantidadeProduto.getText());
            float valorUnitario = Float.parseFloat(jTextFieldPreco.getText());
            float subTotal = valorUnitario * quantidade;                
        
            float quantidadeDisponivel = Estoque.getQuantidadeProduto(nome);
            
            if (quantidadeDisponivel > -1) {
                
                if (quantidadeDisponivel >= quantidade) {  
                    
                    Produto itemCarrinho = new Produto(
                            nome,
                            quantidade,
                            "Unidades",
                            new Date()
                    );

                    this.venda.adicionaItem(itemCarrinho);
                    
                    this.atualizaValorTotal(subTotal);
                    this.atualizaTabela(
                            nome, 
                            String.valueOf(quantidade),
                            String.valueOf(valorUnitario),
                            String.valueOf(subTotal)
                    );
                    this.limpaCampos();        
                    this.topo++;  
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Não há toda quantidade disponível no estoque!");
                    if (!jTextFieldNomeProduto.getText().equals("") && Float.parseFloat(jTextFieldQuantidadeProduto.getText()) > 0){
                        Producao.solicitaProducao(jTextFieldNomeProduto.getText(), Integer.parseInt(jTextFieldQuantidadeProduto.getText()));
                    }
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Não foi encontrado esse produto no estoque!");
                Producao.solicitaProducao(jTextFieldNomeProduto.getText(), Integer.parseInt(jTextFieldQuantidadeProduto.getText()));
            }
            
        } catch (NumberFormatException err) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!!");
            
        }
    }//GEN-LAST:event_jButtonAdicionarProdutoActionPerformed
     
    private void jTextFieldValorPagoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldValorPagoFocusLost
        float troco = Float.parseFloat(jTextFieldValorPago.getText()) - this.valorTotal; 
        jTextFieldTroco.setText(String.valueOf(troco));       
    }//GEN-LAST:event_jTextFieldValorPagoFocusLost

    private void jButtonConfirmarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarVendaActionPerformed
        try {
            DefaultTableModel tabela = (DefaultTableModel) this.jTableVenda.getModel();
            int[] rows = jTableVenda.getSelectedRows();

            float valorPago = Float.parseFloat(jTextFieldValorPago.getText());
            float valorVenda = Float.parseFloat(jTextFieldTotalVenda.getText());

            if (valorPago >= valorVenda) {
                for (int i = 0; i < rows.length; i++) {
                    tabela.removeRow(rows[i] - i);
                }

                for (int row = 0; row < tabela.getRowCount(); row++) {
                    for (int i = 0; i < 4; i++) {
                        jTableVenda.setValueAt("", row, i);
                    }                
                }        

                this.venda.vendeProdutos();
                this.topo = 0;
                this.limpaCampos();                

                JOptionPane.showMessageDialog(null, "Venda realizada com sucesso! Nota fiscal emitida :3");

            } else {
                JOptionPane.showMessageDialog(null, "Valor pago deve cobrir valor da venda!");
            }
            
        } catch (NumberFormatException err) {
            JOptionPane.showMessageDialog(null, "Preencha o valor pago!!");
        }
    }//GEN-LAST:event_jButtonConfirmarVendaActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarProduto;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmarVenda;
    private javax.swing.JButton jButtonRemoverProduto;
    private javax.swing.JLabel jLabelNomeProduto;
    private javax.swing.JLabel jLabelPreco;
    private javax.swing.JLabel jLabelQuantidadeProduto;
    private javax.swing.JLabel jLabelTotalVenda;
    private javax.swing.JLabel jLabelTroco;
    private javax.swing.JLabel jLabelValorPago;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVenda;
    private javax.swing.JTextField jTextFieldNomeProduto;
    private javax.swing.JTextField jTextFieldPreco;
    private javax.swing.JTextField jTextFieldQuantidadeProduto;
    private javax.swing.JTextField jTextFieldTotalVenda;
    private javax.swing.JTextField jTextFieldTroco;
    private javax.swing.JTextField jTextFieldValorPago;
    // End of variables declaration//GEN-END:variables
}
