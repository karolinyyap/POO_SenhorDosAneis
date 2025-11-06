
package projeto_batalha_senhordosaneis.elfos;

import java.util.LinkedList;
import projeto_batalha_senhordosaneis.Cavalo;
import projeto_batalha_senhordosaneis.Guerreiro;
import projeto_batalha_senhordosaneis.Montado;


public class SuperiorElfo extends Elfo implements Montado{
    //Montaria
    private Cavalo cavalo;
    
    public SuperiorElfo(String nome, int idade, double peso, Cavalo cavalo) {
        super(nome, idade, peso);
        this.energia = 500;
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
        //Hit kill
        return Integer.MAX_VALUE;
    }

    //Método atacar
    @Override
    public void atacar(LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2, boolean primeiroAtaque) {
        int ataque = this.getAtaque();
        
        lado1.getFirst().receberDano(ataque, lado1, lado2);
        if (lado1.getFirst().getEnergia() <= 0){
            lado1.removeFirst();
        }
    }

    //Método receber dano
    @Override
    public void receberDano(int dano, LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2) {
        //Passa o dano sempre para o cavalo enquanto ele estiver vivo
        if (this.cavalo != null && this.cavalo.getEnergia() > 0) {
            this.cavalo.receberDano(dano, lado1, lado2);
            if (this.cavalo.getEnergia() <= 0) {
                System.out.println(cavalo.getNome() + " cavalo montaria morreu");
                this.cavalo = null;
            }
        } else {
            //Depois que o cavalo morrer, o elfo recebe o dano
            this.energia -= dano;
        }   
    }
    
}
