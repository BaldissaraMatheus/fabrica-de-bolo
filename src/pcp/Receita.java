package pcp;

import estoque.Produto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Receita {

    private String nome; // nome da receita
    private List<Produto> ingredientes; // lista dos ingredientes da receita
    private int equipeMinima; // número de funcionários mínimo para fazer a receita
    
    // construtor da classe Receita que cria uma lista vazia de ingredientes
     public Receita() {
        this.ingredientes = new ArrayList<>();
    }

    // construtor da classe Receita que, ao instanciar o Bolo (produto), insere o seu Nome, sua lista de ingredientes e a sua equipe mínima para realização
    public Receita(String nome, List<Produto> ingredientes, int equipeMinima) {
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.equipeMinima = equipeMinima;
    }

    // getters e setters dos atributos
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
    
    // método que adiciona produtos (manteiga, leite, ovo...) na lista de ingredientes
    protected void adicionaIngrediente(Produto produto) {
        this.ingredientes.add(produto);
    }

    
    // método que remove ingredientes conforme eles são utilizados durante a produção do Bolo
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
