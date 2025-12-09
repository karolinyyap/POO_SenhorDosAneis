
package projeto_batalha_senhordosaneis.orcs;

import java.util.LinkedList;
import projeto_batalha_senhordosaneis.Guerreiro;
import projeto_batalha_senhordosaneis.Montado;


public class SoldadoOrc extends Orc implements Montado {
    //Montaria
    private WargOrc warg; 

    public SoldadoOrc(String nome, int idade, double peso, WargOrc warg) {
        super(nome, idade, peso);
        this.warg = warg;
    }

    //Montaria
    @Override
    public Guerreiro getMontaria(){
        return this.warg;
    }
    
    //getAtaque
    @Override
    public int getAtaque(){
        return 20;
    }
    
    //Método atacar
    @Override
    public void atacar(LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2, boolean primeiroAtaque) {
        int ataque = this.getAtaque();
        
        if (pragaDosPorcos){
            this.energia -= nivelPraga * 5;
        }
        
        lado2.getFirst().receberDano(ataque, lado1, lado2);
        if (lado2.getFirst().getEnergia() > 0){
            if (this.warg != null){
                lado2.getFirst().receberDano(this.warg.getAtaque(), lado1, lado2);
                if (lado2.getFirst().getEnergia() <=0){
                    lado2.removeFirst();
                }
            }
        } else {
                lado2.removeFirst();
        }
        
    }

    //Método receber dano
    @Override
    public void receberDano(int dano, LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2) {
        this.energia -= dano;
           
        if (this.energia <= 0 && this.warg != null && this.warg.getEnergia() > 0) {
            lado1.addLast(this.warg);
            this.warg = null;
        }
               
    }
    
}
