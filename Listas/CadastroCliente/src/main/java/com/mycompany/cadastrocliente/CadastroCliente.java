/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cadastrocliente;

import java.util.Scanner;

/**
 *
 * @author erixk
 */

class Node{
    int codigo;
    String nome;
    String dataNascimento;
    String telefone;
    Node next;
    Node prev;
    
    public Node(int codigo, String nome, String dataNascimento, String telefone){
        this.codigo = codigo;
        this.nome = nome;;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.next = null;
        this.prev = null;
    }
}

public class CadastroCliente {
    private Node head; 
    private Node tail; 

    public CadastroCliente() {
        this.head = null;
        this.tail = null;
    }

    public void adicionarCadastro(int codigo, String nome, String dataNascimento, String telefone) {
        Node novoNode = new Node(codigo, nome, dataNascimento, telefone);

        if (head == null) { 
            head = novoNode;
            tail = novoNode;
        } else { 
            tail.next = novoNode;
            novoNode.prev = tail;
            tail = novoNode;
        }
    }

    public void excluirCadastro(int codigo) {
        Node atual = head;

        while (atual != null) {
            if (atual.codigo == codigo) {
                if (atual == head) {
                    head = atual.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else if (atual == tail) { 
                    tail = atual.prev;
                    if (tail != null) {
                        tail.next = null;
                    }
                } else { 
                    atual.prev.next = atual.next;
                    if (atual.next != null) {
                        atual.next.prev = atual.prev;
                    }
                }
                System.out.println("Cadastro excluido: " + atual.nome);
                return;
            }
            atual = atual.next;
        }
        System.out.println("Erro: Cliente nao encontrado.");
    }

    public void alterarCadastro(int codigo) {
        Node atual = head;

        while (atual != null) {
            if (atual.codigo == codigo) {
                Scanner sc = new Scanner(System.in);

                System.out.print("Informe o novo nome: ");
                atual.nome = sc.nextLine();
                System.out.print("Informe a nova data de nascimento: ");
                atual.dataNascimento = sc.nextLine();
                System.out.print("Informe o novo telefone: ");
                atual.telefone = sc.nextLine();

                System.out.println("Cadastro atualizado com sucesso.");
                return;
            }
            atual = atual.next;
        }
        System.out.println("Erro: Cliente nao encontrado.");
    }

    public void localizarCadastro(int codigo) {
        Node atual = head;

        while (atual != null) {
            if (atual.codigo == codigo) {
                System.out.println("Cliente encontrado: ");
                System.out.println("Codigo: " + atual.codigo);
                System.out.println("Nome: " + atual.nome);
                System.out.println("Data de Nascimento: " + atual.dataNascimento);
                System.out.println("Telefone: " + atual.telefone);
                return;
            }
            atual = atual.next;
        }
        System.out.println("Erro: Cliente nao encontrado.");
    }

    public void exibirTodosCadastros() {
        if (head == null) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        Node atual = head;
        while (atual != null) {
            System.out.println("Codigo: " + atual.codigo);
            System.out.println("Nome: " + atual.nome);
            System.out.println("Data de Nascimento: " + atual.dataNascimento);
            System.out.println("Telefone: " + atual.telefone);
            System.out.println("-----------------------------");
            atual = atual.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CadastroCliente lista = new CadastroCliente();

        while (true) {
            System.out.println("\n1 - Adicionar cadastro");
            System.out.println("2 - Excluir cadastro");
            System.out.println("3 - Alterar cadastro");
            System.out.println("4 - Localizar cadastro");
            System.out.println("5 - Exibir todos os cadastros");
            System.out.print("Escolha uma opcao: ");
            int opcao = sc.nextInt();
            sc.nextLine(); 

            if (opcao == 1) {
                System.out.print("Informe o codigo do cliente: ");
                int codigo = sc.nextInt();
                sc.nextLine(); 
                System.out.print("Informe o nome do cliente: ");
                String nome = sc.nextLine();
                System.out.print("Informe a data de nascimento: ");
                String dataNascimento = sc.nextLine();
                System.out.print("Informe o telefone: ");
                String telefone = sc.nextLine();

                lista.adicionarCadastro(codigo, nome, dataNascimento, telefone);
                System.out.println("Cadastro adicionado com sucesso!");
            } else if (opcao == 2) {
                System.out.print("Informe o codigo do cliente a ser excluido: ");
                int codigo = sc.nextInt();
                lista.excluirCadastro(codigo);
            } else if (opcao == 3) {
                System.out.print("Informe o codigo do cliente a ser alterado: ");
                int codigo = sc.nextInt();
                lista.alterarCadastro(codigo);
            } else if (opcao == 4) {
                System.out.print("Informe o codigo do cliente a ser localizado: ");
                int codigo = sc.nextInt();
                lista.localizarCadastro(codigo);
            } else if (opcao == 5) {
                lista.exibirTodosCadastros();
            } else {
                System.out.println("Opcao invalida!");
            }
        }
    }
}
