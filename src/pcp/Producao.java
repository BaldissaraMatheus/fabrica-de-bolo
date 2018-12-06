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

// Construtor da classe producao que chama o livro de receitas e verifica 
public class Producao {
    private static final List<Receita> livroReceitas = new ArrayList<>();
    static FuncionarioGUI funcionariogui;
    
    static boolean verificacao;
    
    //  Solicita a producao de bolo(s) até que seja produzida a quantidade de bolo(s) encomenada pelo(a) cliente
    public static void solicitaProducaoBolo(String nomeReceita, float quantidade) {
        for (int i = 0; i < quantidade; i++) {
            if(solicitaProducaoBolo(nomeReceita) == false){
                break;
            }
        }
    }
    
    // método que verifica se é possível a produção do Bolo
    public static boolean solicitaProducaoBolo(String nomeReceita) {
        Receita receita = buscaReceita(nomeReceita);
 
        if (receita != null) {
            
            // caso a receita seja encontrada no livro, é verificado se existe equipe disponível para realizá-la
            
            if (alocaEquipe(receita.getEquipeMinima())) {
                // se houver a equipe mínima, verifica se há o número de ingredientes necessários no estoque 
                List<Produto> insumosFaltando = verificaInsumos(receita.getIngredientes());            

                /* Faz reposição no estoque dos insumos que faltavam para a produção do bolo */
                if (!insumosFaltando.isEmpty()) {                                
                    Compras.realizaPedido(insumosFaltando);
                }
                
                // na preparação do Bolo, se retiram do estoque os ingredientes utilizados na receita
                removeInsumosEstoque(receita.getIngredientes());
                // ao fim da produção, é necessário que a equipe alocada seja liberada, tornando-se assim disponível
                desalocaEquipe(receita.getEquipeMinima());
                // cria-se um novo produto (Bolo) e o adiciona no estoque da loja.
                Produto bolo = produzBolo(nomeReceita);
                Estoque.adicionaProduto(bolo);                
                return true; 
            } else {                
                // caso não haja equipe para a produção, é solicitada a contratação
                System.out.println("Não há pessoal disponível suficiente para trabalhar nisso agora!");
                 funcionariogui = new FuncionarioGUI();
                 funcionariogui.setVisible(true);
            }
            
        } else {
            // caso não haja a receita
            System.out.println("Receita não encontrada!"); 
        }
        return false;
    }
 
    // método parar adicionar uma nova receita ao livro de receitas da loja
    public static void cadastraReceita(Receita receita) {
        livroReceitas.add(receita);
    }   
    
    // método para criar a equipe mínima formada para produzir o Bolo 
    private static boolean alocaEquipe(int pessoalNecessario) {
        if (verificaDisponibilidadeEquipe(pessoalNecessario)) {
            alocaGerente();
            alocaFuncionarios(pessoalNecessario);
            return true;
            
        }          
        
        return false;        
    }
    
    // método para selecionar o gerente para a produção da Receita e o torna indisponível para outras produções
    private static void alocaGerente() {
        for (Gerente gerente : RH.getGerentes()) {
            if (!gerente.isAlocado()) {
                gerente.alocaFuncionario();
                return;
            }
        }
    }
    
    // método para selecionar os funcionários para a produção da Receita e os torna indisponíveis para outras produções
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
    
    // método para verificar se existe gerente e funcionários suficientes para formar a equipe mínima da receita
    private static boolean verificaDisponibilidadeEquipe(int pessoalNecessario) {
        if (verificaLocacaoGerentes() && verificaLocacaoFuncionarios(pessoalNecessario)) {
            return true;
        }
        return false;
    }
    
    // método para verificar se existem funcionários disponíveis suficientes para a produção
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
    
    // método para verificar se há pelo menos um gerente disponível para a produção
    private static boolean verificaLocacaoGerentes() {
        for (Gerente gerente : RH.getGerentes()) {
            if (!gerente.isAlocado()) {
                return true;
            }
        }
        return false;
    }
    
    // método que dispensa a equipe de produção do Bolo
    private static void desalocaEquipe(int equipeAlocada) {
        desalocaGerente();
        desalocaFuncionarios(equipeAlocada);
    }
    
    // método para dispensar gerente da produção, ou seja, torná-los disponíveis para uma nova produção
    private static void desalocaGerente() {
        for (Funcionario gerente : RH.getGerentes()) {
            if (gerente.isAlocado()) {
                gerente.desalocaFuncionario();
                return;
            }
        }
    }
    
    // método para dispensar funcionários da produção, ou seja, torná-los disponíveis para uma nova produção
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
    
    //  método para verificar quais os ingredientes da receita que não estão no estoque
    private static List<Produto> verificaInsumos(List<Produto> insumos) {
        List<Produto> insumosFaltando = new ArrayList<>();
        
        for (Produto ingrediente : insumos) {
            // se não houver o insumo no estoque, adiciona o ingrediente a lista de insumosFaltando
            if (!verificaInsumo(ingrediente)) { 
                System.out.println("Falta " + ingrediente.getNome() + " no estoque, será solicitado reposição ao Compras!");
                insumosFaltando.add(ingrediente);
            }                
        }
        
        // retornar a lista com os insumos faltando
        return insumosFaltando; 
    }
    
    
    // método que retorna a receita escolhida pelo cliente caso ela exista no livro de receitas da loja
    public static Receita buscaReceita(String nomeReceita) {
        for (Receita receita : livroReceitas) {
            if (receita.getNome().toUpperCase().equals(nomeReceita.toUpperCase()))
                return receita;             
        }
        
        return null;
    }
    
    // meótdo que produz o produto final, ou seja, o Bolo
    private static Produto produzBolo(String nome) {
        return new Produto(nome, 1, "Unidade", new Date());
    }
    
    // método para verificar se existe quantidade suficiente do ingrediente passado como parâmetro para a produção da receita.
    private static boolean verificaInsumo(Produto ingrediente) {
        //  em quantidadeDisponível é armazenada a quantidade do produto do estoque a partir do seu nome 
        float quantidadeDisponivel = Estoque.getQuantidadeProduto(ingrediente.getNome());      
        // caso a quantidadeDisponível seja suficiente para a produção, retorna true. Caso contrário, false.
        return quantidadeDisponivel >= ingrediente.getQuantidade();        
    }
    
    // retira do estoque a quantidade do produto utilizado na receita de acordo com o seu nome 
    private static void removeInsumosEstoque(List<Produto> insumos) {
        for (Produto insumo : insumos) 
            Estoque.removeProduto(insumo.getNome(), insumo.getQuantidade());        
    }
    
}
