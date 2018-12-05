/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import compras.Compras;
import estoque.Estoque;
import estoque.Produto;
import java.awt.Component;
import java.util.Scanner;
import rh.Funcionario;
import rh.FuncionarioGUI;
import rh.RH;

/**
 *
 * @author JP
 */
public class Producao {
    
    private static List<Receita> livroReceitas = new ArrayList<>();;
    private static List<Producao> linhaProducao = new ArrayList<>();
    private static SimpleDateFormat formato;
    private static Scanner scanner = new Scanner(System.in);
    
      
    private Funcionario gerente;
    private List<Funcionario> equipeTecnica;
    private Receita receita;
    
    public static void solicitaProducao(String nomeReceita, int quantidade){
        
        Produto boloProduzido;
        
        System.out.println("Pedido de produção recebido!");
        // Cria pedido de produção
        Producao producaoReceita = new Producao();
        // Adiciona a linha de produção
        linhaProducao.add(producaoReceita);
        // Verifica existencia da receita
        System.out.println("Verificando existência da receita");
        producaoReceita.setReceita(verificaReceita(nomeReceita));
        // Caso não exista a receita, cadastra uma nova e adiciona no pedido de produção (linha 43)
        if (producaoReceita.getReceita() == null){
            System.out.println("Criando receita...");
            producaoReceita.setReceita(criaReceita(nomeReceita));
        }
        System.out.println("Alocando equipe...");
        // Aloca equipe
        alocaEquipe(producaoReceita);
        for (int i = 0; i < quantidade; i++){
            System.out.println("Produzindo bolo...");
            // Produz bolo
            boloProduzido = produzBolo(producaoReceita);
            
            System.out.println("Testando bolo");
            // Testa bolo
            while (!testaProduto()){
                System.out.println("Bolo com defeito. Reproduzindo");
                boloProduzido = produzBolo(producaoReceita);
            }
            System.out.println("Produto aprovado! Atualizando estoque");
            
            // Atualiza estoque
            Estoque.adicionaProduto(boloProduzido);
            // Notifica Venda
            System.out.println("Bolo pronto");
        }
        
    }
    // FEITO
    private static Receita verificaReceita(String nome){
        // recebe a receita que irá ser produzida
        // verifica se ela existe dentro do "banco de dados" da produção
        // se existir, retorna uma receita
        // se não, retorna nulo
        for(Receita r : livroReceitas){
            if((r != null) && (r.getNome().toUpperCase().equals(nome.toUpperCase()))){
                return r;
            }
        }
        return null;
    }
    //[TERMINAL] FEITO
    private static Receita criaReceita(String nomeReceita){
        System.out.println("Criando nova receita: " + nomeReceita.toUpperCase() + "\n");
        
        // Lê equipe mínima
        System.out.print("Entre com a quantidade mínima de funncionários para fazer esas receita: ");
        int inputEqpMin = scanner.nextInt();
        
        System.out.println("Entre com os ingredientes: (para sair, digite <>)");
        // Strings para receber a entrada de dados (para não instanciar a cada iteração do loop
        String inputNome = " ", inputQuantidade, inputUnidade;
        // Lista de ingredientes
        List<Produto> ingredientes = new ArrayList<>();
        // Enquanto o usuário queira acrescentar ingrediente(s)
        while(true){
            // Lê nome
            System.out.print("Entre com o nome do ingrediente: ");
            inputNome = scanner.next();
            if (inputNome.trim().equals("<>"))
                break;
//            inputNome = System.console().readLine("Entre com o nome do ingrediente: ");
            // Lê unidade
            System.out.print("Entre com a unidade de " + inputNome + ": ");
            inputUnidade = scanner.next();
            // Lê quantidade
            System.out.print("Entre com a quantidade de " + inputNome + ": ");
            inputQuantidade = scanner.next();
            // Caso todos campos estejam preenchidos, adiciona o novo produto aos ingredientes
            if (!inputNome.equals("") && !inputUnidade.equals("") && !inputQuantidade.equals("")){
                ingredientes.add(new Produto(Float.parseFloat(inputQuantidade), inputUnidade, inputNome));
            }
        }
        // Lê modo de preparo
        System.out.println("Entre com o modo de preparo (em uma linha só): ");
        String inputModoPreparo = scanner.next();
        
        // Adiciona receita ao livro de receitas
        livroReceitas.add(new Receita(nomeReceita, ingredientes, inputModoPreparo, inputEqpMin));
        
        // Retorna a última receita adicionada (esta)
        return livroReceitas.get(livroReceitas.size()-1);
        
        
    }
    // [TERMINAL] - testar
    private static boolean alocaEquipe(Producao producao){        
        // Aloca gerente
         producao.setGerente(alocaGerente());
         // Atualiza a alocação deste gerente dentro da classe produção, dentro do item a ser produzido
         producao.getGerente().alocaFuncionario();
         
        // Aloca equipe técnica
        producao.setEquipeTecnica(alocaEquipeTecnica(producao));
        
        // Retorna true caso tenha conseguido alocar equipe
        return true;
    }
    // [TERMINAL] - testar
    private static Funcionario alocaGerente(){
        int i = 0;
        // Mostra todos funcionários disponíveis com identificação (posição na lista)
        System.out.println("Lista de funcionários disponíveis:");
        for (Funcionario f : RH.getFuncionarios()){
            System.out.println(i + " - " + f.getNome());
            i++;
        }
        System.out.print("Escolha o gerente: ");
        int indexGerente = scanner.nextInt();
        // Atualiza estado dele na lista de funcionários da classe RH
        RH.alocaFuncionario(RH.recuperar(indexGerente).getCpf());
        // Retorna gerênte escolhido
        return RH.recuperar(indexGerente);
    }
    // [TERMINAL] - testar
    private static List<Funcionario> alocaEquipeTecnica(Producao producao){
        // Se não houver funcionários suficiente
        if (producao.getReceita().getEquipeMinima() > RH.getFuncionarios().size()){
            int dif = producao.getReceita().getEquipeMinima() - RH.getFuncionarios().size();
            System.out.println("Não há funcionários suficiente.\n Contratando " + dif + " novos funcionários...");
            // I inicia com a=o valor da diferença 
            for (int i = dif; i > 0; i--){
                // Lendo dados do novo funcionário
                System.out.print("Entre com o nome do novo funcionário: ");
                String funcNome = scanner.nextLine();
                System.out.print("Entre com o CPF de " + funcNome + ": ");
                String funcCpf = scanner.next();
                System.out.print("Entre com o CEP de " + funcNome + ": ");
                String funcCep = scanner.next();
                
                RH.contratar(new Funcionario(funcNome, funcCpf, funcCep));
            }
            
            return alocaEquipeTecnica(producao);
        }
        // Se houver funcionários suficiente
        else {
            List<Funcionario> funcAlocados = new ArrayList<>();
            // Aloca funcionários
            for(Funcionario f : RH.getFuncionarios()){
                // Caso a ainda tenha menos funcionários alocados e o funcionários está livre
                if(producao.getReceita().getEquipeMinima() > funcAlocados.size() 
                        && !f.isAlocado()){
                    // Adiciona funcionário na lista
                    funcAlocados.add(f);
                    // Aloca funcionário da lista de funcionários da lista do RH
                    RH.alocaFuncionario(f.getCpf());
                    // Informa que funcionários está alocado nesta lista
                    f.alocaFuncionario();
                }
            }
            return funcAlocados;
        }
    }
    // FEITO - verificar
    private static Produto produzBolo(Producao producao){
        
        List<Produto> insumosFaltando = verificaInsumos(producao);            

        /* Faz reposição no estoque dos insumos que faltavam para a produção do bolo*/
        if (!insumosFaltando.isEmpty()) {                                
            Compras.realizaPedido(insumosFaltando);
        }
        
        // Tira ingredientes do estoque
        removeInsumosEstoque(producao);
        
        return new Produto(producao.getReceita().getNome(), 1.0f, "unidade", null);
    }
    // FEITO
    private static boolean testaProduto(){
        return ((float) Math.random()) > 0.25f;
    }
    // FEEITO - verificar
    private static List<Produto> verificaInsumos(Producao producao) {
        List<Produto> insumosFaltando = new ArrayList<>();
        
        for (Produto ingrediente : producao.getReceita().getIngredientes()) {
            if (!verificaInsumo(ingrediente)) {
                System.out.println("Falta " + ingrediente.getNome() + " no estoque, será solicitado reposição ao Compras!");
                insumosFaltando.add(ingrediente);
            }                
        }
        
        return insumosFaltando;
    }
    // FEITO - verificar
    private static boolean verificaInsumo(Produto ingrediente) {
        float quantidadeDisponivel = Estoque.getQuantidadeProduto(ingrediente.getNome());      
        return quantidadeDisponivel >= ingrediente.getQuantidade();        
    }
    // FEITO
    private static void removeInsumosEstoque(Producao producao) {
        for (Produto insumo : producao.getReceita().getIngredientes()) 
            Estoque.removeProduto(insumo.getNome(), insumo.getQuantidade());        
    }
    
    
    
    
    
    

    public Producao() {
        this.equipeTecnica = new ArrayList<>();
    }
    public Producao(Funcionario gerente, Receita receita) {
        this.gerente = gerente;
        this.receita = receita;
        this.equipeTecnica = new ArrayList<>();
    }
    
    public Producao(Funcionario gerente, List<Funcionario> equipeTecnica, Receita receita) {
        this.gerente = gerente;
        this.equipeTecnica = equipeTecnica;
        this.receita = receita;
    }
    public Funcionario getGerente() {
        return gerente;
    }
    public void setGerente(Funcionario gerente) {
        this.gerente = gerente;
    }
    public List<Funcionario> getEquipeTecnica() {
        return equipeTecnica;
    }
    public void setEquipeTecnica(List<Funcionario> equipeTecnica) {
        this.equipeTecnica = equipeTecnica;
    }
    public Receita getReceita() {
        return receita;
    }
    public void setReceita(Receita receita) {
        this.receita = receita;
    }

}