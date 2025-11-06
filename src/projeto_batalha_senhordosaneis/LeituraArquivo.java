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
    
    //É estático porque ele pertence à classe, e não a um objeto dela, fica
    //mais fácil de acessar
    public static LinkedList<Guerreiro> orcs_goblinsList = new LinkedList<>();
    public static LinkedList<Guerreiro> elfos_anoesList = new LinkedList<>();
    
    //Método para somar os pesos
    public static double somarPeso(LinkedList<Guerreiro> lista) {
        double total = 0;
        for (Guerreiro guerreiro : lista) {
            total += guerreiro.getPeso();
        }
        return total;
    }
    
    //Método para achar o mais velho
    public static Guerreiro GuerreiroMaisVelho(LinkedList<Guerreiro> lista1, LinkedList<Guerreiro> lista2) {
        Guerreiro maisVelho = null;

        for (Guerreiro guerreiro : lista1) {
            if (maisVelho == null || guerreiro.getIdade() > maisVelho.getIdade()) {
                maisVelho = guerreiro;
            }
        }

        for (Guerreiro guerreiro : lista2) {
            if (maisVelho == null || guerreiro.getIdade() > maisVelho.getIdade()) {
                maisVelho = guerreiro;
            }
        }

        return maisVelho;
}

    
    public static LinkedList<Guerreiro> lerGoblinsOrcs() {
        orcs_goblinsList.clear();
        try {
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
                        ComumGoblin goblin = new ComumGoblin(nome, idade, peso);
                        orcs_goblinsList.add(goblin);
                    }
                    case 2 -> {
                        ReiGoblin rei = new ReiGoblin(nome, idade, peso);
                        orcs_goblinsList.add(rei);
                    }
                    case 3 -> {
                        if(scan.hasNext()) {
                            String montaria = scan.next();
                            if (montaria.equalsIgnoreCase("Sim")) {
                                WargOrc wargSoldado = new WargOrc(nome + " montaria", idade, peso);
                                SoldadoOrc soldado = new SoldadoOrc(nome, idade, peso, wargSoldado);
                                orcs_goblinsList.add(soldado);
                            } else {
                                SoldadoOrc soldado = new SoldadoOrc(nome, idade, peso, null);
                                orcs_goblinsList.add(soldado);
                            }
                        }  
                    }
                    case 4 -> {
                        if(scan.hasNext()) {
                            String montaria = scan.next();
                            if (montaria.equalsIgnoreCase("Sim")) {
                                WargOrc wargSoldado = new WargOrc(nome, idade, peso);
                                AcougueiroOrc acougueiro = new AcougueiroOrc(nome, idade, peso, wargSoldado);
                                orcs_goblinsList.add(acougueiro);
                            } else {
                                AcougueiroOrc acougueiro = new AcougueiroOrc(nome, idade, peso, null);
                                orcs_goblinsList.add(acougueiro);
                            }
                            }
                    }
                    case 5 -> {
                        WargOrc warg = new WargOrc(nome, idade, peso);
                        orcs_goblinsList.add(warg);
                    }
                    case 6 -> {
                        SenhorDasFerasOrc senhorFeras = new SenhorDasFerasOrc(nome, idade, peso);
                        orcs_goblinsList.add(senhorFeras);
                    }
                }
            }
            scan.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeituraArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return orcs_goblinsList;
    }

    public static LinkedList<Guerreiro> lerElfosAnoes() {
        elfos_anoesList.clear();
        try {
            FileInputStream arquivoElfosAnoes = new FileInputStream(
                "C:\\Users\\Karoliny\\Documents\\NetBeansProjects\\Projeto_Batalha_SenhorDosAneis\\elfos_anoes.txt");
            Scanner scan = new Scanner(arquivoElfosAnoes);

            while (scan.hasNext()) {
                int tipo_guerreiro = scan.nextInt();
                String nome = scan.next();
                int idade = scan.nextInt();
                double peso = scan.nextDouble();

                switch (tipo_guerreiro) {
                    case 1 -> {
                        if(scan.hasNext()) {
                            String montaria = scan.next();
                            if (montaria.equalsIgnoreCase("Sim")) {
                                Cavalo cavalo = new Cavalo(nome, idade, peso);
                                GuardiaoElfo guardiao = new GuardiaoElfo(nome, idade, peso, cavalo);
                                elfos_anoesList.add(guardiao);
                            } else {
                                GuardiaoElfo guardiao = new GuardiaoElfo(nome, idade, peso, null);
                                elfos_anoesList.add(guardiao);
                            }
                        }
                    }
                    case 2 -> {
                        if(scan.hasNext()) {
                            String montaria = scan.next();
                            if (montaria.equalsIgnoreCase("Sim")) {
                                Cavalo cavalo = new Cavalo(nome, idade, peso);
                                ArqueiroElfo arqueiro = new ArqueiroElfo(nome, idade, peso, cavalo);
                                elfos_anoesList.add(arqueiro);
                            } else {
                                ArqueiroElfo arqueiro = new ArqueiroElfo(nome, idade, peso, null);
                                elfos_anoesList.add(arqueiro);
                            }
                        }
                    }
                    case 3 -> {
                        if(scan.hasNext()) {
                            String montaria = scan.next();
                            if (montaria.equalsIgnoreCase("Sim")) {
                                Cavalo cavalo = new Cavalo(nome, idade, peso);
                                SuperiorElfo superior = new SuperiorElfo(nome, idade, peso, cavalo);
                                elfos_anoesList.add(superior);
                            } else {
                                SuperiorElfo superior = new SuperiorElfo(nome, idade, peso, null);
                                elfos_anoesList.add(superior);
                            }
                        }
                    }
                    case 4 -> {
                        if(scan.hasNext()) {
                            String montaria = scan.next();
                            if (montaria.equalsIgnoreCase("Sim")) {
                                PorcoGuerraAnao porcoAnao = new PorcoGuerraAnao(nome, idade, peso);
                                GlutaoAnao glutao = new GlutaoAnao(nome, idade, peso, porcoAnao);
                                elfos_anoesList.add(glutao);
                            } else {
                                GlutaoAnao glutao = new GlutaoAnao(nome, idade, peso, null);
                                elfos_anoesList.add(glutao);
                            }
                        }
                    }
                    case 5 -> {
                        PorcoGuerraAnao porco = new PorcoGuerraAnao(nome, idade, peso);
                        elfos_anoesList.add(porco);
                    }
                    case 6 -> {
                        if(scan.hasNext()) {
                           String montaria = scan.next();
                           if (montaria.equalsIgnoreCase("Sim")) {
                               PorcoGuerraAnao porcoAnao = new PorcoGuerraAnao(nome, idade, peso);
                               ImperadorAnao imperador = new ImperadorAnao(nome, idade, peso, porcoAnao);
                               elfos_anoesList.add(imperador);
                           } else {
                               ImperadorAnao imperador = new ImperadorAnao(nome, idade, peso, null);
                               elfos_anoesList.add(imperador);
                            }
                        }
                    }
                }
            }
            scan.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeituraArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return elfos_anoesList;
    }
}
