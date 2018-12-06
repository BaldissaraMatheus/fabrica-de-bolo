package pcp;

import estoque.Produto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Receita {

    private String nome;
    private List<Produto> ingredientes;
    private int equipeMinima;
    
     public Receita() {
        this.ingredientes = new ArrayList<>();
    }

    public Receita(String nome, List<Produto> ingredientes, int equipeMinima) {
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.equipeMinima = equipeMinima;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getIngredientes() {
        return ingredientes;
    }

    public int getEquipeMinima() {
        return equipeMinima;
    }

    public void setEquipeMinima(int equipeMinima) {
        this.equipeMinima = equipeMinima;
    }
    
    protected void adicionaIngrediente(Produto produto) {
        this.ingredientes.add(produto);
    }

    protected void removeIngrediente(String nomeProduto) {        
        for (int i = 0; i < this.ingredientes.size(); i++) {
            Produto ingrediente = this.ingredientes.get(i);
            
            if (ingrediente.getNome().equals(nomeProduto)) {
                this.ingredientes.remove(ingrediente);
                return;
            }
        }
    }
    
}
