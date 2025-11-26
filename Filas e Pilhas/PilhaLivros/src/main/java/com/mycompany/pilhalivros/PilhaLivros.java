/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pilhalivros;

import java.util.Stack;
import java.util.Scanner;

/**
 *
 * @author erixk
 */

public class PilhaLivros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> pilha = new Stack<>();
        
        while (true) {
            System.out.println("\n1 - Adicionar livro");
            System.out.println("2 - Retirar livro");
            System.out.println("3 - Listar livros");
            System.out.print("Escolha a opcao: ");
            int opcao = sc.nextInt();
            sc.nextLine();  // Consumir a quebra de linha

            if (opcao == 1) {
                System.out.print("Informe o nome do livro: ");
                String livro = sc.nextLine();
                pilha.push(livro);
                System.out.println("Livro adicionado a pilha.");
            } else if (opcao == 2) {
                if (!pilha.isEmpty()) {
                    System.out.println("Livros na pilha: ");
                    for (int i = 0; i < pilha.size(); i++) {
                        System.out.println((i + 1) + ". " + pilha.get(i));
                    }
                    System.out.print("Escolha o numero do livro a ser removido: ");
                    int escolha = sc.nextInt();
                    sc.nextLine(); 

                    if (escolha > 0 && escolha <= pilha.size()) {
                        String livroRemovido = pilha.remove(escolha - 1);
                        System.out.println("Livro retirado: " + livroRemovido);
                    } else {
                        System.out.println("Opcao invalida! O numero do livro nao existe.");
                    }
                } else {
                    System.out.println("Nao ha livros na pilha.");
                }
            } else if (opcao == 3) {
                if (pilha.isEmpty()) {
                    System.out.println("A pilha esta vazia.");
                } else {
                    System.out.println("Livros na pilha: ");
                    for (int i = 0; i < pilha.size(); i++) {
                        System.out.println((i + 1) + ". " + pilha.get(i));
                    }
                }
            } else {
                System.out.println("Opcao invalida!");
            }
        }
    }
}
