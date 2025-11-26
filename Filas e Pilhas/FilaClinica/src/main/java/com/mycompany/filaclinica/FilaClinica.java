/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.filaclinica;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author erixk
 */

public class FilaClinica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> fila = new LinkedList<>();
        int capacidade = 20;
        
        while (true) {
            System.out.println("\n1 - Adicionar paciente");
            System.out.println("2 - Chamar proximo paciente");
            System.out.print("Escolha a opcao: ");
            int opcao = sc.nextInt();
            sc.nextLine();  

            if (opcao == 1) {
                if (fila.size() < capacidade) {
                    System.out.print("Informe o nome do paciente: ");
                    String nome = sc.nextLine();
                    fila.add(nome);
                    System.out.println("Paciente " + nome + " adicionado a fila.");
                } else {
                    System.out.println("Fila cheia! Nao e possivel adicionar mais pacientes.");
                }
            } else if (opcao == 2) {
                if (!fila.isEmpty()) {
                    String paciente = fila.poll();
                    System.out.println("Chamando o proximo paciente: " + paciente);
                } else {
                    System.out.println("Nao há pacientes na fila.");
                }
            } else {
                System.out.println("Opcao invalida!");
            }
        }
    }
}
