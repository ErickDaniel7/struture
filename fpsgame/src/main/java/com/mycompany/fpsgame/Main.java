/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fpsgame;

/**
 *
 * @author erick
 */
public class Main {
    public static void main(String[] args) {
        // Criando os jogadores (Nome, Vida, Colete, Munição)
        Atirador player1 = new Atirador("Ghost", 100, 50, 2);
        Atirador player2 = new Atirador("Shadow", 100, 0, 10);

        System.out.println("--- INICIO DA RODADA ---");
        
        // Rodada 1: Ghost ataca
        player1.atirar(player2);
        
        // Rodada 2: Shadow revida
        player2.atirar(player1);
        player2.atirar(player1);

        // Rodada 3: Ghost tenta atirar mas a munição acaba
        player1.atirar(player2);
        player1.atirar(player2);

        System.out.println("\n--- FIM DO COMBATE ---");
        System.out.println(player1.getNome() + " HP: " + player1.getVida());
        System.out.println(player2.getNome() + " HP: " + player2.getVida());
        
        String vencedor = (player1.getVida() > player2.getVida()) ? player1.getNome() : player2.getNome();
        System.out.println("VENCEDOR: " + vencedor);
    }
}
