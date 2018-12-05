package pcp;

import estoque.Produto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ReceitaBaldissara {

    private String nome;
    private List<Produto> ingredientes;
    private Date tempoPreparo;
    private String modoPreparo;
    private int equipeMinima;
    
     public ReceitaBaldissara() {
        this.ingredientes = new ArrayList<>();
    }

    public ReceitaBaldissara(String nome, List<Produto> ingredientes, int equipeMinima) {
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

    public void setIngredientes(List<Produto> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public int getEquipeMinima() {
        return equipeMinima;
    }

    public void setEquipeMinima(int equipeMinima) {
        this.equipeMinima = equipeMinima;
    }
}
