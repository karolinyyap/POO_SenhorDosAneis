
package projeto_batalha_senhordosaneis.anoes;

import java.util.LinkedList;
import projeto_batalha_senhordosaneis.Guerreiro;
import projeto_batalha_senhordosaneis.Montado;

public class GlutaoAnao extends Anao implements Montado{
    //Montaria
    private PorcoGuerraAnao porco;

    public GlutaoAnao(String nome, int idade, double peso, PorcoGuerraAnao porco) {
        super(nome, idade, peso);
        this.porco = porco;
    }
    
    //Montaria
    @Override
    public Guerreiro getMontaria(){
        return this.porco;
    }
    
    //getAtaque
    @Override
    public int getAtaque(){
        return 30;
    }

    //Método atacar
    @Override
    public void atacar(LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2, boolean primeiroAtaque) {
        int ataque = this.getAtaque();
       
        //Realiza seu ataque
        lado1.getFirst().receberDano(ataque, lado1, lado2);
        if (lado1.getFirst().getEnergia() <= 0){
            lado1.removeFirst();
        }
    }

    //Método receber dano
    @Override
    public void receberDano(int dano, LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2) {
        this.energia -= dano;
                   
        //Libera a montaria quando esse morre
        if (this.energia <= 0 && this.porco != null) {
            System.out.println(this.getNome() + " morreu! Montaria " + porco.getNome() + " liberada.");
            lado1.addLast(this.porco);
            this.porco = null;
        }
        
    }
 
}
