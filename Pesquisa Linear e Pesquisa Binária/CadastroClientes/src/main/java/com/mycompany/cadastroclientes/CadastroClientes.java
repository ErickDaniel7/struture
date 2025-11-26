/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cadastroclientes;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author erixk
 */

class Cliente {
    int codigo;
    String nome;
    String dataNascimento;
    String cpf;

    public Cliente(int codigo, String nome, String dataNascimento, String cpf) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + ", Nome: " + nome + ", Data de Nascimento: " + dataNascimento + ", CPF: " + cpf;
    }
}

public class CadastroClientes {

    public static int pesquisaBinaria(Cliente[] clientes, int codigo) {
        int esquerda = 0;
        int direita = clientes.length - 1;
        
        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            if (clientes[meio].codigo == codigo) {
                return meio;
            }
            if (clientes[meio].codigo < codigo) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Informe a quantidade de clientes: ");
        int quantidade = sc.nextInt();
        sc.nextLine();
        
        Cliente[] clientes = new Cliente[quantidade];
        
        for (int i = 0; i < quantidade; i++) {
            System.out.println("Cadastro do cliente " + (i + 1));
            System.out.print("Codigo: ");
            int codigo = sc.nextInt();
            sc.nextLine();
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Data de Nascimento: ");
            String dataNascimento = sc.nextLine();
            System.out.print("CPF: ");
            String cpf = sc.nextLine();
            
            clientes[i] = new Cliente(codigo, nome, dataNascimento, cpf);
        }
        
        Arrays.sort(clientes, (c1, c2) -> Integer.compare(c1.codigo, c2.codigo));
        
        System.out.print("\nInforme o codigo do cliente para pesquisa: ");
        int codigoPesquisado = sc.nextInt();
        
        int resultado = pesquisaBinaria(clientes, codigoPesquisado);
        
        if (resultado != -1) {
            System.out.println("Cliente encontrado: " + clientes[resultado]);
        } else {
            System.out.println("Cliente nao encontrado!");
        }
        
        sc.close();
    }
}

