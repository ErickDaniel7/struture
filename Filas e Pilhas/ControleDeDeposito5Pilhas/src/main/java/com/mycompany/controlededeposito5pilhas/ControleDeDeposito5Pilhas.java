/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.controlededeposito5pilhas;

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

public class ControleDeDeposito5Pilhas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Produto>[] pilhas = new Stack[5];
        for (int i = 0; i < 5; i++) {
            pilhas[i] = new Stack<>();
        }
        
        int capacidade = 10;

        while (true) {
            System.out.println("\n1 - Adicionar produto a pilha");
            System.out.println("2 - Retirar produto da pilha");
            System.out.println("3 - Ver produtos nas pilhas");
            System.out.print("Escolha a opcao: ");
            int opcao = sc.nextInt();
            System.out.print("Selecione a pilha (1 a 5): ");
            int pilhaEscolhida = sc.nextInt() - 1; 
            sc.nextLine();  

            if (pilhaEscolhida < 0 || pilhaEscolhida >= 5) {
                System.out.println("Pilha invalida! Escolha uma pilha entre 1 e 5.");
                continue;
            }

            if (opcao == 1) {
                if (pilhas[pilhaEscolhida].size() < capacidade) {
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
                    pilhas[pilhaEscolhida].push(produto);
                    System.out.println("Produto adicionado a pilha " + (pilhaEscolhida + 1) + ".");
                } else {
                    System.out.println("Capacidade maxima atingida! Nao e possivel adicionar mais caixas nesta pilha.");
                }
            } else if (opcao == 2) {
                if (!pilhas[pilhaEscolhida].isEmpty()) {
                    Produto produtoRemovido = pilhas[pilhaEscolhida].pop();
                    System.out.println("Produto retirado da pilha " + (pilhaEscolhida + 1) + ": " + produtoRemovido);
                } else {
                    System.out.println("Nao ha produtos na pilha " + (pilhaEscolhida + 1) + ".");
                }
            } else if (opcao == 3) {
                if (pilhas[pilhaEscolhida].isEmpty()) {
                    System.out.println("A pilha " + (pilhaEscolhida + 1) + " esta vazia.");
                } else {
                    System.out.println("Produtos na pilha " + (pilhaEscolhida + 1) + ": ");
                    for (Produto produto : pilhas[pilhaEscolhida]) {
                        System.out.println(produto);
                    }
                }
            } else {
                System.out.println("Opcao invalida!");
            }

            System.out.println("\nEstado atual das pilhas: ");
            for (int i = 0; i < 5; i++) {
                System.out.println("\nPilha " + (i + 1) + ": ");
                if (pilhas[i].isEmpty()) {
                    System.out.println("A pilha esta vazia.");
                } else {
                    for (Produto produto : pilhas[i]) {
                        System.out.println(produto);
                    }
                }
            }
        }
    }
}
