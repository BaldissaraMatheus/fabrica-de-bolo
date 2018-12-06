package compras;

import estoque.Produto;
import java.util.ArrayList;
import java.util.List;

import estoque.Estoque; 
import financeiro.Financeiro;

public class Compras {   
    
    private static boolean capital;
    
    // Construtor da classe compras que inicia o capital como false, ou seja, sem capital. 
    private Compras() {
        setCapital(false);
    }
    
    // Solicita o capital para o financeiro, faz a compra de todos os produtos solicitados através de um pedido, notifica o PCP que os produtos foram comprados e modifica o capital para false.
    // Este método é solitado pelo PCP caso precise de algum produto para fabricar um bolo.
    public static void realizaPedido(List<Produto> produtosSolicitados) {
        boolean obtainedCapital = solicitaCapital();
        setCapital(obtainedCapital);
        
        if (!isCapital()) return;  
        
        atualizaEstoque(
          obtemProdutos(
            adicionaItens(
              criaPedido(),
              produtosSolicitados
        )));
        
        notificaPCP();
        setCapital(false);
    }
    
    // Solicita ao financeiro o capital.
    private static boolean solicitaCapital() {
        boolean obtainedCapital = Financeiro.concedeCapital();
        
        if(!obtainedCapital)
            System.out.println("Recursos não autorizados para a realização do pedido");                    
        
        return obtainedCapital;
    }    
    
    // getter e setter do atributo capital
    private static boolean isCapital() {
        return capital;
    }
    
    private static void setCapital(boolean value) {
        capital = value;
    }
    
    // Cria um pedido.
    private static Pedido criaPedido(){
        return new Pedido();
    }
    
    // Adiciona um item a um pedido.
    private static Pedido adicionaItens(Pedido pedido, List<Produto> produtos){
        produtos.forEach((produtoAtual) -> {
            pedido.adicionaItem(produtoAtual);
        });
        return pedido;       
    }    
    
    // Preenche um item com os dados 
    private static List<Produto> obtemProdutos(Pedido pedido){
        List<Produto> produtos = new ArrayList<>();
        List<ItemPedido> itensPedido = pedido.getItens();
        
        itensPedido.forEach((item) -> {
            Produto produto = new Produto(
                    item.getNome(),
                    item.getQuantidade(),
                    item.getUnidade(),
                    item.getValidade());
            
            produtos.add(produto);
        });

        return produtos;
    }
    
    // Adiciona os produtos no Estoque
    private static void atualizaEstoque(List<Produto> produtos){
        System.out.println("Produtos inseridos no estoque: ");
        produtos.forEach((produto) -> {
            System.out.println(produto);
            Estoque.adicionaProduto(produto);            
        });
    }
    
    // Notifica o PCP que os produtos foram adicionados ao estoque
    private static void notificaPCP(){
        
    }        
}
