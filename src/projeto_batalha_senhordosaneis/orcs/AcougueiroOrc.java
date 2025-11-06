package projeto_batalha_senhordosaneis.orcs;

import java.util.LinkedList;
import projeto_batalha_senhordosaneis.Guerreiro;
import projeto_batalha_senhordosaneis.Montado;

public class AcougueiroOrc extends Orc implements Montado {
    private int ataque;
    //Montaria
    private WargOrc warg;

    public AcougueiroOrc(String nome, int idade, double peso, WargOrc warg) {
        super(nome, idade, peso);
        this.energia = 200;
        if (warg != null) {
            this.warg = warg;
        }
        
        this.ataque = 20;
    }

    //Montaria
    @Override
    public Guerreiro getMontaria() {
        return this.warg;
    }
    
    //getAtaque
    @Override
    public int getAtaque(){
        return ataque;
    }
    
    //Método atacar
    @Override
    public void atacar(LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2, boolean primeiroAtaque) {

        //Se tiver praga dos porcos, retira cinco de energia conforme o nível da praga
        if (pragaDosPorcos) {
            this.energia -= nivelPraga * 5;
            System.out.println("Praga de " + this.getNome() + " nível: " + nivelPraga);
        }
        
        //Realiza seu ataque
        lado2.getFirst().receberDano(this.getAtaque(), lado1, lado2);
        if (lado2.getFirst().getEnergia() <= 0){
            //Se o inimigo morrer com seu ataque, devora ele e pega o ataque do inimigo e adiciona ao seu
            System.out.println(this.getNome() + " devorou " + lado2.getFirst().getNome() + " e ficou mais forte!");
            this.ataque += lado2.getFirst().getAtaque();
            lado2.removeFirst();
        }
        
    }

    //Método receber dano
    @Override
    public void receberDano(int dano, LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2) {
        this.energia -= dano;
        
        //Se estiver com a energia menor que 40 e o warg estiver vivo, o devora
        if (this.energia <= 40) {
            if (this.warg != null && this.warg.getEnergia() > 0) {
                System.out.println(this.getNome() + " está ferido e sacrifica seu Warg para recuperar energia!");
                this.warg.receberDano(this.warg.getEnergia(), lado1, lado2);
                this.energia += 100; 
                this.warg = null; 
            }
        }
         
        if (this.energia <= 0 && this.warg != null && this.warg.getEnergia() > 0) {
            System.out.println(this.getNome() + " morreu! Montaria " + warg.getNome() + " liberada.");
            lado1.addLast(this.warg);
            this.warg = null;
        }

    }

}
