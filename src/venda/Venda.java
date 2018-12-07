package venda;

import java.util.*;
import estoque.Estoque;
import estoque.Produto;

public class Venda {
    private List<Produto> carrinho = new ArrayList();
    
    //mostra itens do carrinho
    public void listaItens() {
        for (int i = 0; i < this.carrinho.size(); i++) {
            System.out.println(this.carrinho.get(i));
        }
    }
    //adiciona item ao carrinho
    protected void adicionaItem(Produto produto) {
        this.carrinho.add(produto);
    }
    //retira item do carrinho
    protected void removeItens(String nomeProduto) {        
        for (int i = 0; i < this.carrinho.size(); i++) {
            Produto p = this.carrinho.get(i);
            
            if (p.getNome().equals(nomeProduto)) {
                this.carrinho.remove(p);
                return;
            }
        }
    }
    //vende todos os produtos do carrinho
    protected void vendeProdutos() {
        for (Produto item : this.carrinho) {
            Estoque.removeProduto(item.getNome(), item.getQuantidade());
        }
        this.carrinho.clear();
    }
}
