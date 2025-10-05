
package projeto_batalha_senhordosaneis;

import java.util.LinkedList;
import java.util.Random;


public class Projeto_Batalha_SenhorDosAneis {

    public static void main(String[] args) {
        LeituraArquivo.ListasGuerreiros listas = LeituraArquivo.lerArquivos();
        LinkedList lado1 = listas.orcs_goblinsList;
        LinkedList lado2 = listas.elfos_anoesList;

//        System.out.println("==== ORCS E GOBLINS ====");
//        for (Guerreiro g : listas.orcs_goblinsList) {
//            g.exibirInfo();
//        }
//
//        System.out.println("==== ELFOS E ANÕES ====");
//        for (Guerreiro g : listas.elfos_anoesList) {
//            g.exibirInfo();
//        }  
        Random random = new Random();
        
        while(!lado1.isEmpty() || !lado2.isEmpty()){
            int n = 0;
            System.out.println("\n--- Rodada " + (n + 1) + " ---");
            
            int ladoAtacar = random.nextInt(2);
            
            if(ladoAtacar == 0){
               //lado1 ataca
            } else {
                //lado2 ataca
            }
        }
    }
    
}
