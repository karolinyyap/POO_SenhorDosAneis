
package projeto_batalha_senhordosaneis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import projeto_batalha_senhordosaneis.anoes.Glutao_Anao;
import projeto_batalha_senhordosaneis.anoes.Imperador_Anao;
import projeto_batalha_senhordosaneis.anoes.PorcoGuerra_Anao;
import projeto_batalha_senhordosaneis.elfos.Arqueiro_Elfo;
import projeto_batalha_senhordosaneis.elfos.Guardiao_Elfo;
import projeto_batalha_senhordosaneis.elfos.Superior_Elfo;
import projeto_batalha_senhordosaneis.goblins.Comum_Goblin;
import projeto_batalha_senhordosaneis.goblins.Rei_Goblin;
import projeto_batalha_senhordosaneis.orcs.Acougueiro_Orc;
import projeto_batalha_senhordosaneis.orcs.SenhorDasFeras_Orc;
import projeto_batalha_senhordosaneis.orcs.Soldado_Orc;
import projeto_batalha_senhordosaneis.orcs.Warg_Orc;

public class LeituraArquivo {
           try {
            int contador = 0;
            
            //classe leitora
            System.out.println("================= INICIANDO SISTEMA DE BATALHA =================");
            
            //Criando LinkedLists para armazenar as objetos
            LinkedList <Guerreiro> orcs_goblinsList = new LinkedList<>();
            
            System.out.println("\n...Criando Orcs e Goblins...");
            //Lendo e pegando as informações do arquivo de Orcs e Goblins
            FileInputStream arquivoOrcsGoblins = new FileInputStream("C:\\Users\\Karoliny\\Documents\\NetBeansProjects\\Projeto_Batalha_SenhorDosAneis\\orcs_goblins.txt");
            Scanner scan = new Scanner(arquivoOrcsGoblins);
            
            
            while (scan.hasNext()) {
                //tipo_guerreiro para saber qual objeto criar
                int tipo_guerreiro = scan.nextInt();
                String nome = scan.next();
                int idade = scan.nextInt();
                double peso = scan.nextDouble();
                
                switch (tipo_guerreiro){
                    case 1 -> {
                        //Criar goblin comum
                        Comum_Goblin goblin = new Comum_Goblin(nome, idade, peso);
                        //Adicionando na lista
                        orcs_goblinsList.add(goblin);
                    }
                    case 2 -> {
                        //Criar rei goblin
                        Rei_Goblin ReiGoblin = new Rei_Goblin(nome, idade, peso);
                        //Adicionando na lista
                        orcs_goblinsList.add(ReiGoblin);
                    }
                    case 3 -> {
                        //Criar soldado orc
                        Soldado_Orc soldado = new Soldado_Orc(nome, idade, peso);
                        //Adicionando na lista
                        orcs_goblinsList.add(soldado);
                    }
                    case 4 -> {
                        //Criar açougueiro orc
                        Acougueiro_Orc acougueiro = new Acougueiro_Orc(nome, idade, peso);
                        //Adicionando na lista
                        orcs_goblinsList.add(acougueiro);
                    }
                    case 5 -> {
                        //Criar warg
                        Warg_Orc warg = new Warg_Orc(nome, idade, peso);
                        //Adicionando na lista
                        orcs_goblinsList.add(warg);
                    }
                    case 6 -> {
                        //Criar senhor das feras
                        SenhorDasFeras_Orc senhorFeras = new SenhorDasFeras_Orc(nome, idade, peso);
                        //Adicionando na lista
                        orcs_goblinsList.add(senhorFeras);
                    }
                    
                }
                
                contador++;
                
            }

            scan.close();
            //**************************************************************************************
            
            int contador2 = 0;
            System.out.println("\n...Criando Elfos e Anões...\n");
            LinkedList <Guerreiro> elfos_anoesList = new LinkedList<>();
            //Lendo e pegando as informações do arquivo de Elfos e Anões
            FileInputStream arquivoElfosAnoes = new FileInputStream("C:\\Users\\Karoliny\\Documents\\NetBeansProjects\\Projeto_Batalha_SenhorDosAneis\\elfos_anoes.txt");
            Scanner scan2 = new Scanner(arquivoElfosAnoes);
            
            
            while (scan2.hasNext()) {
                //tipo_guerreiro para saber qual objeto criar
                int tipo_guerreiro = scan2.nextInt();
                String nome = scan2.next();
                int idade = scan2.nextInt();
                double peso = scan2.nextDouble();
                
                switch (tipo_guerreiro){
                    case 1 -> {
                        //Criar guardião elfo
                        Guardiao_Elfo guardiao = new Guardiao_Elfo(nome, idade, peso);
                        //Adicionando na lista
                        elfos_anoesList.add(guardiao);
                    }
                    case 2 -> {
                        //Criar arqueiro elfo
                        Arqueiro_Elfo arqueiro = new Arqueiro_Elfo(nome, idade, peso);
                        //Adicionando na lista
                        elfos_anoesList.add(arqueiro);
                    }
                    case 3 -> {
                        //Criar soldado orc
                        Superior_Elfo superior = new Superior_Elfo(nome, idade, peso);
                        //Adicionando na lista
                        elfos_anoesList.add(superior);
                    }
                    case 4 -> {
                        //Criar açougueiro orc
                        Glutao_Anao glutao = new Glutao_Anao(nome, idade, peso);
                        //Adicionando na lista
                        elfos_anoesList.add(glutao);
                    }
                    case 5 -> {
                        //Criar porco de guerra
                        PorcoGuerra_Anao porco = new PorcoGuerra_Anao(nome, idade, peso);
                        //Adicionando na lista
                        elfos_anoesList.add(porco);
                    }
                    case 6 -> {
                        //Criar imperador
                        Imperador_Anao imperador = new Imperador_Anao(nome, idade, peso);
                        //Adicionando na lista
                        elfos_anoesList.add(imperador);
                    }
                    
                }
                
                contador2++;
                
            }

            scan2.close();
            
            System.out.println("\n================================== ORCS E GOBLINS ==================================");
            for (Guerreiro guerreiro : orcs_goblinsList) {
                guerreiro.exibirInfo();
            }
            
            System.out.println("\nQuantidade de orcs e goblins lidos: " + contador);
            
            
            System.out.println("\n================================== ELFOS E ANÕES ==================================");

            for (Guerreiro guerreiro : elfos_anoesList) {
                guerreiro.exibirInfo();
            }
            
            System.out.println("Quantidade de elfoes e anoes lidos: " + contador2);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Projeto_Batalha_SenhorDosAneis.class.getName()).log(Level.SEVERE, null, ex);
        }
}
