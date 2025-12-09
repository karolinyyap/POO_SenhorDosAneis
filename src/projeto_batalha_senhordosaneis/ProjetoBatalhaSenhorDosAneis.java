package projeto_batalha_senhordosaneis;

import java.util.LinkedList;
import java.util.Random;

public class ProjetoBatalhaSenhorDosAneis {

    public static void main(String[] args) {
        LinkedList<Guerreiro> lado1 = LeituraArquivo.lerGoblinsOrcs();
        LinkedList<Guerreiro> lado2 = LeituraArquivo.lerElfosAnoes();

        System.out.println("a)");
        System.out.println("\n==== ORCS E GOBLINS ====");
        for (Guerreiro g : lado1) {
            g.exibirInfo();
        }

        System.out.println("\n==== ELFOS E ANOES ====");
        for (Guerreiro g : lado2) {
            g.exibirInfo();
        }

        System.out.println("\nb) Peso total dos Orcs e Goblins eh de " + LeituraArquivo.somarPeso(lado1) + " kilos");
        System.out.println("b) Peso total dos Elfos e Anoes eh de " + LeituraArquivo.somarPeso(lado2) + " kilos");

        Guerreiro maisVelho = LeituraArquivo.GuerreiroMaisVelho(lado1, lado2);
        System.out.println("\nc) O guerreiro mais velho eh " + maisVelho.getNome() + " com " + maisVelho.getIdade() + " anos de idade!");

        batalhar(lado1, lado2);
    }

    public static void batalhar(LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2) {
        Random random = new Random();
        int rodada = 1;

        Guerreiro ultimoAtacante = null;
        Guerreiro ultimoMorto = null;

        while (!lado1.isEmpty() && !lado2.isEmpty()) {
            //System.out.println("\n--- Rodada " + rodada + " ---");
            rodada++;

            //Sorteia aleatoriamente o lado que vai atacar
            int ladoAtacar = random.nextInt(2);
            Guerreiro ataque, defesa;

            if (ladoAtacar == 0) {
                ataque = lado1.getFirst();
                defesa = lado2.getFirst();
            } else {
                ataque = lado2.getFirst();
                defesa = lado1.getFirst();
            }

            //Ataque

            //Se estiver vivo, ataca
            if (ataque.estaVivo()) {
                ataque.atacar(lado1, lado2, true);
                ultimoAtacante = ataque;

                //Se a defesa não estiver viva, toma ela como
                //último morto
                if (!defesa.estaVivo()) {
                    ultimoMorto = defesa;
                }
            //Se por acaso estiver morto
            } else {
                //Vai retirar o primeiro da lista
                if (ladoAtacar == 0) {
                    lado1.removeFirst();
                } else {
                    lado2.removeFirst();
                }
                //E continua
                continue;
            }

            //Se a defesa não estiver viva, printa
            if (!defesa.estaVivo()) {
                //System.out.println(defesa.getNome() + " foi derrotado!");
            
            //Se estiver faz o contra-ataque
            } else {
                // Contra-ataque

                //Se defesa estiver viva
                if (defesa.estaVivo()) {
                    //E a defesa não estiver tonta
                    if (!defesa.isTonto()) {
                        defesa.atacar(lado1, lado2, false);
                        ultimoAtacante = defesa;
                        if (!ataque.estaVivo()) {
                            ultimoMorto = ataque;
                        }
                    //Se não estiver tonta
                    } else {
                        defesa.setTonto(false);
                    }
                //Ele não está vivo
                } else {
                    if (ladoAtacar == 0) {
                        lado1.removeFirst();
                    } else {
                        lado2.removeFirst();
                    }
                    continue;
                }

            }
            
            //Caso os dois fiquem vivos
            if (ladoAtacar == 0) {
                if (ataque.estaVivo()) {
                    lado1.removeFirst();
                    lado1.addLast(ataque);
                }
                if (defesa.estaVivo()) {
                    lado2.removeFirst();
                    lado2.addLast(defesa);
                }
            } else {
                if (ataque.estaVivo()) {
                    lado2.removeFirst();
                    lado2.addLast(ataque);
                }
                if (defesa.estaVivo()) {
                    lado1.removeFirst();
                    lado1.addLast(defesa);
                }
            }

        }

        // Determina vencedor e perdedor
        String vencedor, perdedor;
        if (lado1.isEmpty()) {
            vencedor = "Elfos e Anoes";
            perdedor = "Orcs e Goblins";
        } else {
            vencedor = "Orcs e Goblins";
            perdedor = "Elfos e Anoes";
        }

        System.out.println("\nd) O lado vencedor foi " + vencedor + "!");
        System.out.println("e) O lado perdedor foi " + perdedor + "!");
        if (ultimoMorto != null) {
            System.out.println("f) O " + ultimoMorto.getClass().getSimpleName() + " "
                    + ultimoMorto.getNome() + " de " + ultimoMorto.getPeso()
                    + " kilos foi o ultimo a ser derrotado no lado " + perdedor + ".");
        }
        if (ultimoAtacante != null) {
            System.out.println("g) O " + ultimoAtacante.getClass().getSimpleName() + " "
                    + ultimoAtacante.getNome() + " de " + ultimoAtacante.getPeso()
                    + " kilos foi o ultimo a atacar no lado " + vencedor + ".");
        }

    }

}
