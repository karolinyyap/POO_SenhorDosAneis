
package projeto_batalha_senhordosaneis.elfos;

import java.util.Iterator;
import java.util.LinkedList;
import projeto_batalha_senhordosaneis.Cavalo;
import projeto_batalha_senhordosaneis.Guerreiro;
import projeto_batalha_senhordosaneis.Montado;

public class ArqueiroElfo extends Elfo implements Montado{
    //Montaria
    private Cavalo cavalo;
    
    public ArqueiroElfo(String nome, int idade, double peso, Cavalo cavalo) {
        super(nome, idade, peso);
        this.cavalo = cavalo;
    }
    
    //Montaria
    @Override
    public Guerreiro getMontaria(){
        return this.cavalo;
    }
    
    //getAtaque
    @Override
    public int getAtaque(){
        return 5;
    }

    //Método atacar
    @Override
    public void atacar(LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2, boolean primeiroAtaque) {
        Iterator it = lado1.iterator();
        //Ataque em fileira do arqueiro
        while (it.hasNext()) {
            Guerreiro g = (Guerreiro) it.next();
            g.receberDano(this.getAtaque(), lado1, lado2);

            if (g.getEnergia() <= 0) {
                it.remove();
            }
        }
    }

    //Método receber dano
    @Override
    public void receberDano(int dano, LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2) {
        //Passa o dano sempre para o cavalo enquanto ele estiver vivo
        if (this.cavalo != null && this.cavalo.getEnergia() > 0) {
            this.cavalo.receberDano(dano, lado1, lado2);
            if (this.cavalo != null && this.cavalo.getEnergia() <= 0) {
                this.cavalo = null;
            }
        } else {
            //Depois que o cavalo morrer, o elfo recebe o dano
            this.energia -= dano;
        }
        
    }
}
