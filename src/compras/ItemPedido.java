package compras;

import estoque.Produto;
import java.util.Date;

public final class ItemPedido extends Produto {    
    private float preco;

    // Construtor do ItemPedido, utiliza a classe produto e adiciona o preço para ser adicionado a lista de itens de um pedido
    public ItemPedido(String nome, float quantidade, String unidade, Date validade, float preco) {
        super(nome, quantidade, unidade, validade);
        this.setPreco(preco);
    }

    // Getter e Setter do atributo preço
    public float getPreco() {
        return preco;
    }

    private void setPreco(Float preco) {
        this.preco = preco;
    }
    
}
