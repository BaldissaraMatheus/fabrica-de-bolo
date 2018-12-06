package venda;

import estoque.Estoque;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import estoque.Produto;
import pcp.Producao;
import pcp.ReceitaGUI;
import rh.ClienteGUI;
import rh.RH;

public class VendaGUI extends javax.swing.JFrame {
    private Venda venda = new Venda();
        
    private float valorTotal;
    private boolean clienteVerificado;
    private int topo;
    private ReceitaGUI receitaGUI = new ReceitaGUI();
    
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
        valorTotal = 0;
    }
    
    private void atualizaValorTotal(float valor) {
        this.valorTotal += valor;
        jTextFieldTotalVenda.setText(String.valueOf(valorTotal));
    }
        
    private void verificaCliente(boolean verificado) {
        if (!verificado) {
            JOptionPane.showMessageDialog(null, "Não há nenhum cliente cadastrado no sistema com esse cpf!");
        
        } else {
            this.confirmarClienteBtn.setEnabled(false);
            this.cadastrarClienteBtn.setEnabled(false);
            this.clienteTextField.setEnabled(false);
        }
        
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
        jLabel1 = new javax.swing.JLabel();
        clienteTextField = new javax.swing.JTextField();
        cadastrarClienteBtn = new javax.swing.JButton();
        confirmarClienteBtn = new javax.swing.JButton();

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

        jLabel1.setText("CPF do cliente:");

        cadastrarClienteBtn.setText("Cadastrar cliente");
        cadastrarClienteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarClienteBtnActionPerformed(evt);
            }
        });

        confirmarClienteBtn.setText("Confirmar cliente");
        confirmarClienteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarClienteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jButtonRemoverProduto)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonAdicionarProduto)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelPreco)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabelQuantidadeProduto)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldQuantidadeProduto))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabelNomeProduto)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(clienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(cadastrarClienteBtn)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(confirmarClienteBtn)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonCancelar)
                                .addGap(331, 331, 331))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTotalVenda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabelValorPago)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTroco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonConfirmarVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeProduto)
                    .addComponent(jTextFieldNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(clienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelQuantidadeProduto)
                    .addComponent(jTextFieldQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastrarClienteBtn)
                    .addComponent(confirmarClienteBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPreco)
                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRemoverProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdicionarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotalVenda)
                    .addComponent(jTextFieldTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelValorPago)
                    .addComponent(jTextFieldValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTroco)
                    .addComponent(jTextFieldTroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonConfirmarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
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
                    JOptionPane.showMessageDialog(null, "Não há essa quantidade disponível no estoque! Sua produção foi solicitada ao PCP, tente adicionar novamente.");
                    Producao.solicitaProducaoBolo(nome, quantidade);
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Não foi encontrado esse produto no estoque!");
                receitaGUI.setVisible(true);
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

            if (this.clienteVerificado) {
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
                    this.setVisible(false);
                    this.dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "Valor pago deve cobrir valor da venda!");
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Não há nenhum cliente cadastrado no sistema com esse cpf!");
            }
            

            
        } catch (NumberFormatException err) {
            JOptionPane.showMessageDialog(null, "Preencha o valor pago!!");
        }
    }//GEN-LAST:event_jButtonConfirmarVendaActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void cadastrarClienteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarClienteBtnActionPerformed
        ClienteGUI clienteGUI = new ClienteGUI();
        clienteGUI.setVisible(true);
    }//GEN-LAST:event_cadastrarClienteBtnActionPerformed

    private void confirmarClienteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarClienteBtnActionPerformed
        this.clienteVerificado = RH.buscarCliente(clienteTextField.getText()) != null;
        this.verificaCliente(this.clienteVerificado);
        
    }//GEN-LAST:event_confirmarClienteBtnActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarClienteBtn;
    private javax.swing.JTextField clienteTextField;
    private javax.swing.JButton confirmarClienteBtn;
    private javax.swing.JButton jButtonAdicionarProduto;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmarVenda;
    private javax.swing.JButton jButtonRemoverProduto;
    private javax.swing.JLabel jLabel1;
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
