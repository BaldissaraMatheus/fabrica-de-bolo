package compras;

import estoque.Produto;
import java.util.ArrayList;
import java.util.List;

import estoque.Estoque; 
import financeiro.Financeiro;

public class Compras {   
    
    private static boolean capital;
    
    private Compras() {
        setCapital(false);
    }
    
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

    private static boolean solicitaCapital() {
        boolean obtainedCapital = Financeiro.concedeCapital();
        
        if(!obtainedCapital)
            System.out.println("Recursos não autorizados para a realização do pedido");                    
        
        return obtainedCapital;
    }    
    
    private static boolean isCapital() {
        return capital;
    }
    
    private static void setCapital(boolean value) {
        capital = value;
    }
    
    private static Pedido criaPedido(){
        return new Pedido();
    }
    
    private static Pedido adicionaItens(Pedido pedido, List<Produto> produtos){
        produtos.forEach((produtoAtual) -> {
            pedido.adicionaItem(produtoAtual);
        });
        return pedido;       
    }    

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
    
    private static void atualizaEstoque(List<Produto> produtos){
        System.out.println("Produtos inseridos no estoque: ");
        produtos.forEach((produto) -> {
            System.out.println(produto);
            Estoque.adicionaProduto(produto);            
        });
    }
    
    private static void notificaPCP(){
        System.out.println("Se essa mensagem foi exibida significa que o programa compilou e que você é uma pessoa incrível.");
    }        
}
