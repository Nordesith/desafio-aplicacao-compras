package br.com.alura.desafiocompras.principal;

import br.com.alura.desafiocompras.produtos.Produto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        int opcao = 1;
        double limiteCartao = 0;
        List<Produto> listaDeCompras = new ArrayList<>();

        System.out.println("Digite o limite do cartão: ");
        limiteCartao = leitura.nextDouble();

        while (opcao != 0 && limiteCartao > 0){
            Produto novoProduto = new Produto();
            System.out.println("Digite a descrição da compra: ");
            novoProduto.setNome(leitura.next());

            System.out.println("Digite o valor da compra: ");
            novoProduto.setPreco(leitura.nextDouble());

            if (novoProduto.getPreco() > limiteCartao){
                System.out.println("Limite insuficiente!");
            } else {
                listaDeCompras.add(novoProduto);

                System.out.println("Compra realizada!\n");

                limiteCartao -= novoProduto.getPreco();
            }

            System.out.println("Digite 0 para sair ou 1 para continuar");
            opcao = leitura.nextInt();
        }
        Collections.sort(listaDeCompras);
        System.out.println("COMPRAS REALIZADAS: \n");
        for (Produto item: listaDeCompras){
            System.out.println(item + "\n");
        }
        System.out.println("Saldo do cartão: " + limiteCartao);


    }
}