package pcp;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import estoque.Estoque;
import estoque.Produto;
import compras.Compras;
import rh.Funcionario;
import rh.FuncionarioGUI;
import rh.Gerente;
import rh.RH;

public class Producao {
    private static final List<Receita> livroReceitas = new ArrayList<>();
    static FuncionarioGUI funcionariogui;
    
    static boolean verificacao;
    
    public static void solicitaProducaoBolo(String nomeReceita, float quantidade) {
        for (int i = 0; i < quantidade; i++) {
            if(solicitaProducaoBolo(nomeReceita) == false){
                break;
            }
        }
    }
    
    public static boolean solicitaProducaoBolo(String nomeReceita) {
        Receita receita = buscaReceita(nomeReceita);
        
        if (receita != null) {
            
            if (alocaEquipe(receita.getEquipeMinima())) {
                
                List<Produto> insumosFaltando = verificaInsumos(receita.getIngredientes());            

                /* Faz reposição no estoque dos insumos que faltavam para a produção do bolo */
                if (!insumosFaltando.isEmpty()) {                                
                    Compras.realizaPedido(insumosFaltando);
                }

                removeInsumosEstoque(receita.getIngredientes());
                desalocaEquipe(receita.getEquipeMinima());
                Produto bolo = produzBolo(nomeReceita);
                Estoque.adicionaProduto(bolo);                
                return true;
            } else {                
                System.out.println("Não há pessoal disponível suficiente para trabalhar nisso agora!");
                 funcionariogui = new FuncionarioGUI();
                 funcionariogui.setVisible(true);
            }
            
        } else {
            System.out.println("Receita não encontrada!"); 
        }
        return false;
    }
 
    public static void cadastraReceita(Receita receita) {
        livroReceitas.add(receita);
    }   
    
    private static boolean alocaEquipe(int pessoalNecessario) {
        if (verificaDisponibilidadeEquipe(pessoalNecessario)) {
            alocaGerente();
            alocaFuncionarios(pessoalNecessario);
            return true;
            
        }          
        
        return false;        
    }
    
    private static void alocaGerente() {
        for (Gerente gerente : RH.getGerentes()) {
            if (!gerente.isAlocado()) {
                gerente.alocaFuncionario();
                return;
            }
        }
    }
    
    private static void alocaFuncionarios(int equipeNecessaria) {
        int funcionariosAlocados = 0;
        int i = 0;
        
        while (funcionariosAlocados < equipeNecessaria) {
            Funcionario funcionario = RH.getFuncionarios().get(i);
            
            if(!funcionario.isAlocado()) {
                funcionario.alocaFuncionario();
                funcionariosAlocados++;
            }
            
            i++;
        }
    }
    
    private static boolean verificaDisponibilidadeEquipe(int pessoalNecessario) {
        if (verificaLocacaoGerentes() && verificaLocacaoFuncionarios(pessoalNecessario)) {
            return true;
        }
        return false;
    }
    
    private static boolean verificaLocacaoFuncionarios(int equipeNecessaria) {
        int pessoalDisponivel = 0;
        
        for (Funcionario funcionario : RH.getFuncionarios()) {
            if(!funcionario.isAlocado()) {
                pessoalDisponivel++;
            }
        }
        System.out.println("Funcionarios disponiveis: " + pessoalDisponivel);
        if (pessoalDisponivel >= equipeNecessaria) {
            return true;
        }
        return false;
    }
    
    private static boolean verificaLocacaoGerentes() {
        for (Gerente gerente : RH.getGerentes()) {
            if (!gerente.isAlocado()) {
                return true;
            }
        }
        return false;
    }
    
    private static void desalocaEquipe(int equipeAlocada) {
        desalocaGerente();
        desalocaFuncionarios(equipeAlocada);
    }
    
    private static void desalocaGerente() {
        for (Funcionario gerente : RH.getGerentes()) {
            if (gerente.isAlocado()) {
                gerente.desalocaFuncionario();
                return;
            }
        }
    }
    
    private static void desalocaFuncionarios(int equipeAlocada) {
        int funcionariosDesalocados = 0;
        int i = 0;
        
        while (funcionariosDesalocados < equipeAlocada) {
            Funcionario funcionario = RH.getFuncionarios().get(i);
            
            if(funcionario.isAlocado()) {
                funcionario.desalocaFuncionario();
                funcionariosDesalocados++;
            }
            
            i++;
        }
    }
    
    private static List<Produto> verificaInsumos(List<Produto> insumos) {
        List<Produto> insumosFaltando = new ArrayList<>();
        
        for (Produto ingrediente : insumos) {
            if (!verificaInsumo(ingrediente)) {
                System.out.println("Falta " + ingrediente.getNome() + " no estoque, será solicitado reposição ao Compras!");
                insumosFaltando.add(ingrediente);
            }                
        }
        
        return insumosFaltando;
    }
    
    public static Receita buscaReceita(String nomeReceita) {
        for (Receita receita : livroReceitas) {
            if (receita.getNome().toUpperCase().equals(nomeReceita.toUpperCase()))
                return receita;             
        }
        
        return null;
    }
    
    private static Produto produzBolo(String nome) {
        return new Produto(nome, 1, "Unidade", new Date());
    }
    
    private static boolean verificaInsumo(Produto ingrediente) {
        float quantidadeDisponivel = Estoque.getQuantidadeProduto(ingrediente.getNome());      
        return quantidadeDisponivel >= ingrediente.getQuantidade();        
    }
    
    private static void removeInsumosEstoque(List<Produto> insumos) {
        for (Produto insumo : insumos) 
            Estoque.removeProduto(insumo.getNome(), insumo.getQuantidade());        
    }
    
}
