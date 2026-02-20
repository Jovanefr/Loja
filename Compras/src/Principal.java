import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import models.Cartao;
import models.Produto;

public class Principal {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String nome;
        Double saldo;

        System.out.println("Qual o seu nome? ");
        //nome = scanner.nextLine();
        nome = "Jovane";
        System.out.println("Qual o seu saldo em conta? ");
        // saldo = scanner.nextDouble();
        saldo = 1000.00;
        Cartao meuCartao = new Cartao(nome, saldo);

        System.out.println(meuCartao.getTitular() + ": R$" + meuCartao.getSaldo());
        

        System.out.println("------------------------------------------\nVamos as compras");
        
        double montante = 0.00;
        int continuar = 1;
        ArrayList<Produto> listaCompras = new ArrayList<>();
        String nomeTemp;
        double valorTemp = 0.00;
        scanner.nextLine();

        while (montante < meuCartao.getSaldo() && continuar == 1) {
            System.out.println("Qual o nome do produto? ");
            nomeTemp = scanner.nextLine();
            
            System.out.println("Qual o valor do produto? ");
            valorTemp = Double.parseDouble(scanner.nextLine());

            //incrementação do montante do pedido
            montante += valorTemp;
            //Só adiciona o produto se o montate for menor que o saldo.
            //Só pergunta se quer continuar se o montante for menor também
            if(montante <= meuCartao.getSaldo()){
                listaCompras.add(new Produto(nomeTemp, valorTemp));
                System.out.println("Caso deseje continuar, digite 1, caso queira parar, digite 0: ");
                continuar = Integer.parseInt(scanner.nextLine());
            } 
            
        }
        
        scanner.close();
        
        //Ordenação da lista por preço
        Collections.sort(listaCompras);

        //Caso o montante do pedido seja maior que o saldo, o montante desconsidera o último valor
        if(montante - meuCartao.getSaldo() > 0){
            montante -= valorTemp;
        }
        meuCartao.saque(montante);

        //Exibição dos produtos comprados(já ordenados)
        System.out.println("---------------------------------------------");
        for (Produto produto : listaCompras) {
            System.out.println(produto.getNome() + "  R$" + produto.getPreco());
        }
        System.out.println("---------------------------------------------");
        //Exibição do saldo final
        System.out.println("Seu saldo ficou: " + meuCartao.getSaldo());

    }
}
