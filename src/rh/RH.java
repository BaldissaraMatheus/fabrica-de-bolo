package rh;

import java.util.*;

public class RH {
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static List<Gerente> gerentes = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    
    //recupera funcionarios
    public static List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    //recupera gerentes
    public static List<Gerente> getGerentes() {
        return gerentes;
    }
    //recupera clientes
    public static List<Cliente> getClientes() {
        return clientes;
    }
    //adiciona funcionario à list    
    public static void contratar(Funcionario funcionario){
        funcionarios.add(funcionario);
    }    
    //adiciona gerente à list
    public static void contratar(Gerente gerente) {
        gerentes.add(gerente);
    }
    //adiciona cliente à list
    public static void cadastraCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    //retira funcionario ou gerente da list
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
    
    //recupera cliente
    public static Cliente buscarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        
        return null;
    }
    //recupera funcionarios ou gerentes
    public static Funcionario recuperar(String cpf) {
        Funcionario funcionario = recuperarFuncionario(cpf);
        
        if (funcionario != null) {
            return funcionario;
        }
        
        Gerente gerente = recuperarGerente(cpf);                
        return gerente;
    }
    
    //recupera funcionario
    private static Funcionario recuperarFuncionario(String cpf) {
        for(Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {     
                return funcionario;                       
            }           
        }
        
        return null;
    }
    //recupera gerente
    private static Gerente recuperarGerente(String cpf) {
        for (Gerente gerente : gerentes) {
            if (gerente.getCpf().equals(cpf)) {     
                return gerente;                       
            }           
        }
        
        return null;
    }
 

    
}
