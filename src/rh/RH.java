package rh;

import java.util.*;

public class RH {
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static List<Gerente> gerentes = new ArrayList<>();

    public static List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    
    public static List<Gerente> getGerentes() {
        return gerentes;
    }
    
    public static void contratar(Funcionario funcionario){
        funcionarios.add(funcionario);
    }    
    
    public static void contratar(Gerente gerente) {
        gerentes.add(gerente);
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
    
    public static Funcionario recuperar (int index){
        return funcionarios.get(index);
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
            if(funcionario.getCpf().equals(cpf)) {     
                return funcionario;                       
            }           
        }
        
        return null;
    }
    
    private static Gerente recuperarGerente(String cpf) {
        for(Gerente gerente : gerentes) {
            if(gerente.getCpf().equals(cpf)) {     
                return gerente;                       
            }           
        }
        
        return null;
    }
    // JP
    public static void alocaFuncionario(String cpf){
        for (Funcionario f: funcionarios){
            if ((f != null) && (f.getCpf().equals(cpf.toUpperCase()))){
                f.alocaFuncionario();
            }
        }
    }
    // JP
    public static void desalocaFuncionario(String cpf){
        for (Funcionario f: funcionarios){
            if ((f != null) && (f.getCpf().equals(cpf.toUpperCase()))){
                f.desalocaFuncionario();
            }
        }
    }
 
}
