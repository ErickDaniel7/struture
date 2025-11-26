/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.controlededeposito;

import java.util.Stack;
import java.util.Scanner;

/**
 *
 * @author erixk
 */

class Produto {
    int codProduto;
    String descricao;
    String dataEntrada;
    String ufOrigem;
    String ufDestino;

    public Produto(int codProduto, String descricao, String dataEntrada, String ufOrigem, String ufDestino) {
        this.codProduto = codProduto;
        this.descricao = descricao;
        this.dataEntrada = dataEntrada;
        this.ufOrigem = ufOrigem;
        this.ufDestino = ufDestino;
    }

    @Override
    public String toString() {
        return "Produto [Codigo: " + codProduto + ", Descricao: " + descricao + ", Data de Entrada: " + dataEntrada
                + ", UF Origem: " + ufOrigem + ", UF Destino: " + ufDestino + "]";
    }
}

public class ControleDeDeposito {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Produto> pilhaProdutos = new Stack<>();
        int capacidade = 10; 
        int contador = 0;

        while (true) {
            System.out.println("\n1 - Adicionar produto a pilha");
            System.out.println("2 - Retirar produto da pilha");
            System.out.println("3 - Ver produtos na pilha");
            System.out.print("Escolha a opcao: ");
            int opcao = sc.nextInt();
            sc.nextLine(); 

            if (opcao == 1) {
                if (pilhaProdutos.size() < capacidade) {
                    System.out.print("Informe o codigo do produto: ");
                    int codProduto = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Informe a descricao do produto: ");
                    String descricao = sc.nextLine();
                    System.out.print("Informe a data de entrada (dd/MM/yyyy): ");
                    String dataEntrada = sc.nextLine();
                    System.out.print("Informe o estado de origem: ");
                    String ufOrigem = sc.nextLine();
                    System.out.print("Informe o estado de destino: ");
                    String ufDestino = sc.nextLine();

                    Produto produto = new Produto(codProduto, descricao, dataEntrada, ufOrigem, ufDestino);
                    pilhaProdutos.push(produto);
                    System.out.println("Produto adicionado a pilha.");
                } else {
                    System.out.println("Capacidade maxima atingida! Nao e possível adicionar mais caixas.");
                }
            } else if (opcao == 2) {
                if (!pilhaProdutos.isEmpty()) {
                    Produto produtoRemovido = pilhaProdutos.pop();
                    System.out.println("Produto retirado: " + produtoRemovido);
                } else {
                    System.out.println("Nao ha produtos na pilha.");
                }
            } else if (opcao == 3) {
                if (pilhaProdutos.isEmpty()) {
                    System.out.println("A pilha esta vazia.");
                } else {
                    System.out.println("Produtos na pilha: ");
                    for (Produto produto : pilhaProdutos) {
                        System.out.println(produto);
                    }
                }
            } else {
                System.out.println("Opcao invalida!");
            }

            System.out.println("\nEstado atual da pilha: ");
            for (int i = pilhaProdutos.size() - 1; i >= 0; i--) {
                System.out.println("Pilha posicao " + (i + 1) + ": " + pilhaProdutos.get(i));
            }
        }
    }
}

