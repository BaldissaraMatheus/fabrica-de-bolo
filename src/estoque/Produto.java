package estoque;

import java.util.Date;

public class Produto {
    private String nome;
    private float quantidade;
    private String unidade;
    private Date validade;
    
    // Construtor de Produto, adicionando todos os dados de um produto
    public Produto(String nome, float quantidade, String unidade, Date validade) {
        setNome(nome);
        setQuantidade(quantidade);
        setUnidade(unidade);
        setValidade(validade);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    
    public float getQuantidade() {
        return quantidade;
    }
        
    public String getUnidade() {
        return unidade;
    }
       
    public Date getValidade() {
        return validade;
    }
    
    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    
    private void setNome(String nome) {
        this.nome = nome;
    }

    private void setValidade(Date validade) {
        this.validade = validade;
    }

    // Retorna uma representação string do objeto
    @Override
    public String toString() {
        return "[" +
               this.getNome() + ", " +
               this.getQuantidade() + " " +
               this.getUnidade() + ", válido até " +
               this.getValidade() +
               "]";                
    }    
}
