
package projeto_batalha_senhordosaneis.anoes;

import java.util.LinkedList;
import projeto_batalha_senhordosaneis.Guerreiro;

public class PorcoGuerraAnao extends Anao {
    
    public PorcoGuerraAnao(String nome, int idade, double peso) {
        super(nome, idade, peso);
        this.energia = 250;
    }
    
    //getAtaque
    @Override
    public int getAtaque(){
        //Não possui ataque, é apenas montado
        return 0;
    }

    //Método atacar
    @Override
    public void atacar(LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2, boolean primeiroAtaque) {

    }

    //Método receber dano
    @Override
    public void receberDano(int dano, LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2) {
        this.energia -= dano;
        
        //Praga dos porcos quando recebe dano
        lado1.getFirst().pragaDosPorcos(true);
        
    }
    
}
