import compras.Compras;
import estoque.Produto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rh.Funcionario;
import rh.RH;
import venda.VendaGUI;

public class Bolo {
    
    public static void main(String[] args) {   
        
        List<Produto> produtos = new ArrayList<>();
        
        Produto batatas = new Produto("Batata", 4, "Kg", new Date());                  
        Produto ovos = new Produto("Ovos", 200, "Unidades", new Date());
        Produto acucar = new Produto("Açucar", 5, "Kg", new Date());
        Produto margarina = new Produto("Margarina", 2, "Kg", new Date());
        Produto manteiga = new Produto("manteiga", 2, "Kg", new Date());
        Produto leite = new Produto("Leite", 20, "L", new Date());
        
        RH.contratar(new Funcionario("Artur", "111", "111"));
        RH.contratar(new Funcionario("Bárbara", "222", "222"));
        RH.contratar(new Funcionario("Catherine", "333", "333"));
        RH.contratar(new Funcionario("Davi", "444", "444"));
        RH.contratar(new Funcionario("Edgar", "555", "555"));
        RH.contratar(new Funcionario("Flávia", "666", "666"));
        RH.contratar(new Funcionario("Giovane", "777", "777"));
        RH.contratar(new Funcionario("Heliana", "888", "888"));
        
        Produto bolo = new Produto("Bolo", 1, "Unidades", new Date());
        produtos.add(bolo);
        
        produtos.add(batatas);
        produtos.add(ovos);
        produtos.add(acucar);
        produtos.add(margarina);
        produtos.add(manteiga);
        produtos.add(leite);
        
        Compras.realizaPedido(produtos);
        
        BoloGUI boloGUI = new BoloGUI();
        boloGUI.setVisible(true);
        
        
    }
}
