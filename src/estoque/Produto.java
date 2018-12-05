package estoque;

import java.util.Date;

public class Produto {
    private String nome;
    private float quantidade;
    private String unidade;
    private Date validade;
    
    public Produto(String nome, float quantidade, String unidade, Date validade) {
        setNome(nome);
        setQuantidade(quantidade);
        setUnidade(unidade);
        setValidade(validade);
    }

    public Produto(float quantidade, String unidade, String nome) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.unidade = unidade;
        this.validade = new Date();
    }    

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
