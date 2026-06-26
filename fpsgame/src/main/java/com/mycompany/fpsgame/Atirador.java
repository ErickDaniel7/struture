/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fpsgame;

/**
 *
 * @author erick
 */
public class Atirador {
    private String nome;
    private int vida;
    private int colete;
    private int municao;

    // Construtor para inicializar o personagem
    public Atirador(String nome, int vida, int colete, int municao) {
        this.nome = nome;
        this.vida = (vida > 0) ? vida : 100;
        this.colete = colete;
        this.municao = municao;
    }

    // Método para Atirar em um alvo
    public void atirar(Atirador alvo) {
        if (this.vida <= 0) {
            System.out.println(this.nome + " esta morto e não pode atirar!");
            return;
        }
        
        if (this.municao > 0) {
            this.municao--;
            System.out.println(">>> " + this.nome + " disparou contra " + alvo.getNome() + "!");
            alvo.receberDano(25); // Cada tiro causa 25 de dano
        } else {
            System.out.println("CLIC! " + this.nome + " esta sem municao!");
        }
    }

    // Método para Receber Dano (Protegido)
    private void receberDano(int dano) {
        if (this.colete > 0) {
            System.out.println("[SISTEMA] O colete de " + this.nome + " absorveu parte do impacto!");
            this.colete -= dano;
            if (this.colete < 0) { // Se o dano sobrou do colete, vai para a vida
                this.vida += this.colete; 
                this.colete = 0;
            }
        } else {
            this.vida -= dano;
        }

        if (this.vida < 0) this.vida = 0;
        System.out.println("[STATUS] " + this.nome + " agora tem " + this.vida + " de vida.");
    }

    // Getters
    public String getNome() { return nome; }
    public int getVida() { return vida; }
    public int getMunicao() { return municao; }
}
