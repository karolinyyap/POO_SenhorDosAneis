package projeto_batalha_senhordosaneis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import projeto_batalha_senhordosaneis.anoes.*;
import projeto_batalha_senhordosaneis.elfos.*;
import projeto_batalha_senhordosaneis.goblins.*;
import projeto_batalha_senhordosaneis.orcs.*;

public class LeituraArquivo {

    public static class ListasGuerreiros {
        public LinkedList<Guerreiro> orcs_goblinsList = new LinkedList<>();
        public LinkedList<Guerreiro> elfos_anoesList = new LinkedList<>();
    }

    public static ListasGuerreiros lerArquivos() {
        int contadorReiGoblin = 0;
        int contadorImperadorAnao = 0;
        ListasGuerreiros listas = new ListasGuerreiros();

        try {
            // Orcs e Goblins
            FileInputStream arquivoOrcsGoblins = new FileInputStream(
                    "C:\\Users\\Karoliny\\Documents\\NetBeansProjects\\Projeto_Batalha_SenhorDosAneis\\orcs_goblins.txt");
            Scanner scan = new Scanner(arquivoOrcsGoblins);

            while (scan.hasNext()) {
                int tipo_guerreiro = scan.nextInt();
                String nome = scan.next();
                int idade = scan.nextInt();
                double peso = scan.nextDouble();

                switch (tipo_guerreiro) {
                    case 1 -> {
                        Comum_Goblin goblin = new Comum_Goblin(nome, idade, peso);
                        listas.orcs_goblinsList.add(goblin);
                    }
                    case 2 -> {
                        if (contadorReiGoblin == 1){
                            System.out.println("Já existe um Rei Goblin!");
                        }
                        else { 
                            Rei_Goblin rei = new Rei_Goblin(nome, idade, peso);
                            listas.orcs_goblinsList.add(rei);
                            contadorReiGoblin++;
                        }
                    }
                    case 3 -> {
                        Soldado_Orc soldado = new Soldado_Orc(nome, idade, peso, null);
                        listas.orcs_goblinsList.add(soldado);
                    }
                    case 4 -> {
                        Acougueiro_Orc acougueiro = new Acougueiro_Orc(nome, idade, peso);
                        listas.orcs_goblinsList.add(acougueiro);
                    }
                    case 5 -> {
                        Warg_Orc warg = new Warg_Orc(nome, idade, peso);
                        listas.orcs_goblinsList.add(warg);
                    }
                    case 6 -> {
                        SenhorDasFeras_Orc senhorFeras = new SenhorDasFeras_Orc(nome, idade, peso);
                        listas.orcs_goblinsList.add(senhorFeras);
                    }
                }
            }
            scan.close();

            // Elfos e Anões
            FileInputStream arquivoElfosAnoes = new FileInputStream(
                    "C:\\Users\\Karoliny\\Documents\\NetBeansProjects\\Projeto_Batalha_SenhorDosAneis\\elfos_anoes.txt");
            Scanner scan2 = new Scanner(arquivoElfosAnoes);

            while (scan2.hasNext()) {
                int tipo_guerreiro = scan2.nextInt();
                String nome = scan2.next();
                int idade = scan2.nextInt();
                double peso = scan2.nextDouble();

                switch (tipo_guerreiro) {
                    case 1 -> {
                        Guardiao_Elfo guardiao = new Guardiao_Elfo(nome, idade, peso, null);
                        listas.elfos_anoesList.add(guardiao);
                    }
                    case 2 -> {
                        Arqueiro_Elfo arqueiro = new Arqueiro_Elfo(nome, idade, peso, null);
                        listas.elfos_anoesList.add(arqueiro);
                    }
                    case 3 -> {
                        Superior_Elfo superior = new Superior_Elfo(nome, idade, peso, null);
                        listas.elfos_anoesList.add(superior);
                    }
                    case 4 -> {
                        Glutao_Anao glutao = new Glutao_Anao(nome, idade, peso, null);
                        listas.elfos_anoesList.add(glutao);
                    }
                    case 5 -> {
                        PorcoGuerra_Anao porco = new PorcoGuerra_Anao(nome, idade, peso);
                        listas.elfos_anoesList.add(porco);
                    }
                    case 6 -> {
                        if(contadorImperadorAnao == 1){
                            System.out.println("Já existe um Imperador Anão!");
                        } else {
                            Imperador_Anao imperador = new Imperador_Anao(nome, idade, peso, null);
                            listas.elfos_anoesList.add(imperador);
                        }
                    }
                }
            }
            scan2.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeituraArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listas;
    }
}
