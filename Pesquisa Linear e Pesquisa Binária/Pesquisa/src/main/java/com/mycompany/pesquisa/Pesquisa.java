/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pesquisa;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author erixk
 */
public class Pesquisa {

    public static int pesquisaLinear(int[] vetor, int chave) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == chave) {
                return i;
            }
        }
        return -1;
    }

    public static int pesquisaBinaria(int[] vetor, int chave) {
        int esquerda = 0;
        int direita = vetor.length - 1;
        
        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            if (vetor[meio] == chave) {
                return meio;
            }
            if (vetor[meio] < chave) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Informe a quantidade de numeros: ");
        int quantidade = sc.nextInt();
        
        int[] numeros = new int[quantidade];
        
        for (int i = 0; i < quantidade; i++) {
            System.out.print("Informe o numero " + (i + 1) + ": ");
            numeros[i] = sc.nextInt();
        }
        
        Arrays.sort(numeros);
        
        System.out.println("\nMenu:");
        System.out.println("1. Pesquisa Linear");
        System.out.println("2. Pesquisa Binaria");
        System.out.print("Escolha o tipo de pesquisa (1 ou 2): ");
        int escolha = sc.nextInt();
        
        System.out.print("Informe o numero a ser pesquisado: ");
        int chave = sc.nextInt();
        
        int resultado = -1;
        
        if (escolha == 1) {
            resultado = pesquisaLinear(numeros, chave);
        } else if (escolha == 2) {
            resultado = pesquisaBinaria(numeros, chave);
        } else {
            System.out.println("Opcao invalida!");
        }
        
        if (resultado != -1) {
            System.out.println("Numero encontrado na posicao: " + resultado);
        } else {
            System.out.println("Numero nao encontrado!");
        }
        
        sc.close();
    }
}
