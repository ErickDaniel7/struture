/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.filabanco;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author erixk
 */

public class FilaBanco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Queue<String> filaPrioritaria = new LinkedList<>();
        Queue<String> filaNormal = new LinkedList<>();
        int contagemPrioritaria = 0;
        
        while (true) {
            System.out.println("\n1 - Adicionar cliente");
            System.out.println("2 - Chamar cliente");
            System.out.print("Escolha a opcao: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.print("Informe a senha do cliente: ");
                int senha = sc.nextInt();
                sc.nextLine();
                System.out.print("Informe o nome do cliente: ");
                String nome = sc.nextLine();
                System.out.print("Informe o ano de nascimento do cliente: ");
                int anoNascimento = sc.nextInt();
                sc.nextLine();

                int idade = 2025 - anoNascimento;
                if (idade > 65) {
                    filaPrioritaria.add(nome);
                    System.out.println("Cliente " + nome + " adicionado a fila prioritaria.");
                } else {
                    filaNormal.add(nome);
                    System.out.println("Cliente " + nome + " adicionado a fila normal.");
                }
            } else if (opcao == 2) {
                if (contagemPrioritaria == 2) {
                    if (!filaNormal.isEmpty()) {
                        String clienteNormal = filaNormal.poll();
                        System.out.println("Atendendo cliente normal: " + clienteNormal);
                        contagemPrioritaria = 0;
                    } else {
                        System.out.println("Nao ha clientes normais na fila.");
                    }
                } else {
                    if (!filaPrioritaria.isEmpty()) {
                        String clientePrioritario = filaPrioritaria.poll();
                        System.out.println("Atendendo cliente prioritario: " + clientePrioritario);
                        contagemPrioritaria++;
                    } else {
                        System.out.println("Nao ha clientes prioritarios na fila.");
                    }
                }
            } else {
                System.out.println("Opcao invalida!");
            }
        }
    }
}
