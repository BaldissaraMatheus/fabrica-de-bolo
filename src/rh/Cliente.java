package rh;

public class Cliente {
    
    private final String cpf;
    private final String nome;
    
    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }    
    
    public String getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }     
}
