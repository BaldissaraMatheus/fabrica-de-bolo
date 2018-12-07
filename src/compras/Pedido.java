package compras;

import estoque.Produto;
import java.util.ArrayList;
import java.util.List;

public final class Pedido {
    private List<ItemPedido> itens;
    private float precoTotal;

    // Construtor do Pedido
    public Pedido() {
        this.itens = new ArrayList<>();
        setPrecoTotal(0.0f);
    }

    // Adiciona um item a uma lista de ItemPedido e atualiza o valor total do pedido
    protected void adicionaItem(Produto produto){
        ItemPedido item = new ItemPedido(
                produto.getNome(), 
                produto.getQuantidade(), 
                produto.getUnidade(), 
                produto.getValidade(), 
                10); 
        this.itens.add(item);         
        this.updatePrecoTotal(item.getPreco());
    }    
    
    //Getters e Setters
    public List<ItemPedido> getItens() {
        return itens;
    }

    public float getPrecoTotal() {
        return precoTotal;
    }
    
    private void setPrecoTotal(Float precoTotal) {
        this.precoTotal = precoTotal;
    }   
    
    // Atualiza o valor total do pedido
    private void updatePrecoTotal(float valor) {
        this.precoTotal += valor;
    }  
}
