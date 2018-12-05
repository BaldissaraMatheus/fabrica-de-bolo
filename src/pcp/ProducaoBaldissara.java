package pcp;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import estoque.Estoque;
import estoque.Produto;
import compras.Compras;
import rh.Funcionario;
import rh.Gerente;
import rh.RH;

public class ProducaoBaldissara {
    private static final List<Receita> livroReceitas = new ArrayList<>();

    public static void solicitaProducaoBolo(String nomeReceita, int quantidade) {
        for (int i = 0; i <= quantidade; i++) {
            solicitaProducaoBolo(nomeReceita);
        }
    }
    
    public static void solicitaProducaoBolo(String nomeReceita) {
        Receita receita = buscaReceita(nomeReceita);
        
        if (receita != null) {
            
            if (alocaEquipe(receita.getEquipeMinima())) {
                
                List<Produto> insumosFaltando = verificaInsumos(receita.getIngredientes());            

                /* Faz reposição no estoque dos insumos que faltavam para a produção do bolo*/
                if (!insumosFaltando.isEmpty()) {                                
                    Compras.realizaPedido(insumosFaltando);
                }

                removeInsumosEstoque(receita.getIngredientes());
                desalocaEquipe(receita.getEquipeMinima());
                Produto bolo = produzBolo(nomeReceita);
                Estoque.adicionaProduto(bolo);
                
            } else
                System.out.println("Não há pessoal disponível suficiente para trabalhar nisso agora!");
                        
        } else 
            System.out.println("Receita não encontrada!");        
    }
    // NÃO USADA - por hora
    public static void registraReceita(Receita receita) {
        livroReceitas.add(receita);
    }   
    // ADAPTADO
    private static boolean alocaEquipe(int pessoalNecessario) {
        if (verificaDisponibilidadeEquipe(pessoalNecessario)) {
            alocaGerente();
            alocaFuncionarios(pessoalNecessario);
            return true;
            
        }          
        
        return false;        
    }
    // NÃO USADO
    private static void alocaGerente() {
        for (Gerente gerente : RH.getGerentes()) {
            if (!gerente.isAlocado()) {
                gerente.alocaFuncionario();
                return;
            }
        }
    }
    // NÃO USADO
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
    // NÃO USADO
    private static boolean verificaDisponibilidadeEquipe(int pessoalNecessario) {
        if (verificaLocacaoGerentes() && verificaLocacaoFuncionarios(pessoalNecessario)) {
            return true;
        }
        return false;
    }
    // NÃO USADO
    private static boolean verificaLocacaoFuncionarios(int equipeNecessaria) {
        int pessoalDisponivel = 0;
        
        for (Funcionario funcionario : RH.getFuncionarios()) {
            if(!funcionario.isAlocado()) {
                pessoalDisponivel++;
            }
        }
        
        if (pessoalDisponivel >= equipeNecessaria) {
            return true;
        }
        return false;
    }
    // NÃO USADO
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
    // NÃO USADO
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
    // UTILIZADA - adaptada
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
    // UTILIZADA - adaptada
    private static Receita buscaReceita(String nomeReceita) {
        for (Receita receita : livroReceitas) {
            if (receita.getNome().toUpperCase().equals(nomeReceita.toUpperCase()))
                return receita;             
        }
        
        return null;
    }
    // NÃO UTILIZADA - código utilizado, mas não como função específica
    private static Produto produzBolo(String nome) {
        return new Produto(nome, 1, "Unidade", new Date());
    }
    // UTILIZADA - adaptada
    private static boolean verificaInsumo(Produto ingrediente) {
        float quantidadeDisponivel = Estoque.getQuantidadeProduto(ingrediente.getNome());      
        return quantidadeDisponivel >= ingrediente.getQuantidade();        
    }
    // UTILIZADA - adaptada
    private static void removeInsumosEstoque(List<Produto> insumos) {
        for (Produto insumo : insumos) 
            Estoque.removeProduto(insumo.getNome(), insumo.getQuantidade());        
    }
    
}
