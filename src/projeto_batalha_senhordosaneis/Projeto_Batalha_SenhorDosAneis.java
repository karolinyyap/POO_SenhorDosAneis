
package projeto_batalha_senhordosaneis;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Projeto_Batalha_SenhorDosAneis {
//CONFIRMAR COM PROF SOBRE MONTARIA
    public static void main(String[] args) {
        LinkedList<Guerreiro> lado1 = LeituraArquivo.lerGoblinsOrcs();
        LinkedList<Guerreiro> lado2 = LeituraArquivo.lerElfosAnoes();

        System.out.println("==== ORCS E GOBLINS ====");
        for (Guerreiro g : lado1) {
            g.exibirInfo();
        }

        System.out.println("==== ELFOS E ANÕES ====");
        for (Guerreiro g : lado2) {
            g.exibirInfo();
        }  
        Random random = new Random();
        
        while(!lado1.isEmpty() && !lado2.isEmpty()){
            int n = 0;
            System.out.println("\n--- Rodada " + (n + 1) + " ---");
            
            int ladoAtacar = random.nextInt(2);
            
            if(ladoAtacar == 0){
               Guerreiro ataque = lado1.get(0);
               Guerreiro defesa = lado2.get(0);
            } else {
                //lado2 ataca
            }
        }

    }
    
}
