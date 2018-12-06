package rh;

import java.util.*;

public class RH {
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static List<Gerente> gerentes = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();

    public static List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    
    public static List<Gerente> getGerentes() {
        return gerentes;
    }
    
    public static List<Cliente> getClientes() {
        return clientes;
    }
        
    public static void contratar(Funcionario funcionario){
        funcionarios.add(funcionario);
    }    
    
    public static void contratar(Gerente gerente) {
        gerentes.add(gerente);
    }
 
    public static void cadastraCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    
    public static void demitir(String cpf) {
        Funcionario funcionario = recuperarFuncionario(cpf);
        
        if (funcionario != null) {
            funcionarios.remove(funcionario);
            return;
        }
        
        Gerente gerente = recuperarGerente(cpf);
        
        if (gerente != null) 
            gerentes.remove(gerente);                
    }    
    
    
    public static Cliente buscarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        
        return null;
    }
    
    public static Funcionario recuperar(String cpf) {
        Funcionario funcionario = recuperarFuncionario(cpf);
        
        if (funcionario != null) {
            return funcionario;
        }
        
        Gerente gerente = recuperarGerente(cpf);                
        return gerente;
    }
    
    
    private static Funcionario recuperarFuncionario(String cpf) {
        for(Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {     
                return funcionario;                       
            }           
        }
        
        return null;
    }
    
    private static Gerente recuperarGerente(String cpf) {
        for (Gerente gerente : gerentes) {
            if (gerente.getCpf().equals(cpf)) {     
                return gerente;                       
            }           
        }
        
        return null;
    }
 

    
}
