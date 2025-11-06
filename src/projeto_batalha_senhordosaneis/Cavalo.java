
package projeto_batalha_senhordosaneis;

import java.util.LinkedList;

public class Cavalo extends Guerreiro{

    public Cavalo(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }
    
    @Override
    public int getAtaque(){
        return 0;
    }

    @Override
    public void atacar(LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2, boolean primeiroAtaque) {
    }

    @Override
    public void receberDano(int dano, LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2) {
        this.energia -= dano;
        
    }

    
    
}
