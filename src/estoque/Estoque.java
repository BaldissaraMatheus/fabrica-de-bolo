package estoque;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private static final List<Produto> produtos = new ArrayList<>();    
    
    public static List<Produto> getProdutos() {
        return produtos;
    }    
    
    public static void adicionaProduto(Produto produto) {
        int index = buscaProduto(produto.getNome());        
        
        if (index == -1) 
            produtos.add(produto);
        
        else 
            atualizaQuantidadeProduto(produtos.get(index), produto.getQuantidade()) ;                                          
    }

    public static void removeProduto(String nome, float quantidadeRemovida) {
        int index = buscaProduto(nome);
        
        if (index != -1) {
            float quantidadeAtual = getQuantidadeProduto(index);
            
            if(quantidadeAtual - quantidadeRemovida >= 0) {
                atualizaQuantidadeProduto(produtos.get(index), -quantidadeRemovida);
                removeProdutoVazio(index);
                
            } else 
                System.out.println("Não há toda essa quantidade para ser removida");
            
        } else 
            System.out.println("Não foi encontrado este produto!");          
    }

    public static float getQuantidadeProduto(String nome) {
        int index = buscaProduto(nome);
        
        if(index > -1)
            return getQuantidadeProduto(index);
        
        return -1;        
    }
    
    private static int buscaProduto(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().toUpperCase().equals(nome.toUpperCase()))
                return produtos.indexOf(produto);             
        }
        
        return -1;                    
    }
    
    private static float getQuantidadeProduto(int index) {       
        if(index > -1)
            return produtos.get(index).getQuantidade();
        
        return -1;        
    }
    
    private static void atualizaQuantidadeProduto(Produto produto, float quantidade) {
        produto.setQuantidade(produto.getQuantidade() + quantidade);
    }        
    
    private static void removeProdutoVazio(int index) {
        if (produtos.get(index).getQuantidade() == 0) produtos.remove(index);
    }
}
