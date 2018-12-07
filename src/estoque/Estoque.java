package estoque;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private static final List<Produto> produtos = new ArrayList<>();    
    
    // Getter de produtos
    public static List<Produto> getProdutos() {
        return produtos;
    }    
    
    // Verifica se o produto já está em estoque, caso não esteja, o produto é adicionado ao estoque e atualiza o número de produtos no estoque
    public static void adicionaProduto(Produto produto) {
        int index = buscaProduto(produto.getNome());        
        
        if (index == -1) 
            produtos.add(produto);
        
        else 
            atualizaQuantidadeProduto(produtos.get(index), produto.getQuantidade()) ; 
        
    }

    // Verifica se o produto está em estoque, caso esteja e o estoque tem a quantidade de produto solitada para a remoção, a quantidade do produto é atualizada,
    // caso o estoque não tenha a quantidade de produto solitada para a remoção, é retornada uma mensagem de que nao é possível remover a quantidade solicitada,
    // caso o index for -1, o produto não foi encontrado.
    public static void removeProduto(String nome, float quantidadeRemovida) {
        int index = buscaProduto(nome);
        
        if (index != -1) {
            float quantidadeAtual = getQuantidadeProduto(index);
            
            if(quantidadeAtual - quantidadeRemovida >= 0) {
                atualizaQuantidadeProduto(produtos.get(index), -quantidadeRemovida);
                
            } else 
                System.out.println("Não há toda essa quantidade para ser removida");
            
        } else 
            System.out.println("Não foi encontrado este produto!");          
    }

    // Retorna a quantidade de um produto através do nome dele, caso ele esteja em estoque
    public static float getQuantidadeProduto(String nome) {
        int index = buscaProduto(nome);
        
        if(index > -1)
            return getQuantidadeProduto(index);
        
        return -1;        
    }
    
    // Produto um produto em uma lista de produtos e retorna a posição do produto, caso nao encontre, retorna -1
    private static int buscaProduto(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().toUpperCase().equals(nome.toUpperCase()))
                return produtos.indexOf(produto);             
        }
        
        return -1;                    
    }
    
    // Retorna a quantidade de um produto através do index dele, caso ele esteja em estoque
    private static float getQuantidadeProduto(int index) {       
        if(index > -1)
            return produtos.get(index).getQuantidade();
        
        return -1;        
    }
    
    // Atualiza a quantidade de um produto em estoque
    private static void atualizaQuantidadeProduto(Produto produto, float quantidade) {
        produto.setQuantidade(produto.getQuantidade() + quantidade);
    }        
    
    // remove um produto caso o produto tenha acabado 
    private static void removeProdutoVazio(int index) {
        if (produtos.get(index).getQuantidade() == 0) produtos.remove(index);
    }
}
