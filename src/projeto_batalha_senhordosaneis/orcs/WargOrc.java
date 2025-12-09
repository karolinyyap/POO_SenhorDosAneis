
package projeto_batalha_senhordosaneis.orcs;

import java.util.LinkedList;
import projeto_batalha_senhordosaneis.Guerreiro;

public class WargOrc extends Orc{
    
    public WargOrc(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }
    
    //getAtaque
    @Override
    public int getAtaque(){
        return 15;
    }

    //Método atacar
    @Override
    public void atacar(LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2, boolean primeiroAtaque) {
        int ataque = 15;
        
        //Se tiver praga dos porcos, retira cinco de energia conforme o nível da praga
        if (pragaDosPorcos){
            this.energia -= nivelPraga * 5;
        }
        
        int meuIndice = lado1.indexOf(this);
        int bonus = 0;
        
        //Ataque enfileirado do warg
        for (int i = meuIndice + 1; i < lado1.size(); i++) {
            Guerreiro guerreiro = lado1.get(i);
            if (guerreiro instanceof WargOrc) {
                bonus += 5;
            } else {
                break; 
            }
        }

        ataque += bonus;
        
        lado2.getFirst().receberDano(ataque, lado1, lado2);
        if(lado2.getFirst().getEnergia() <= 0){
            lado2.removeFirst();
        }
    }

    //Método receber dano
    @Override
    public void receberDano(int dano, LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2) {
        this.energia -= dano;
    }
    
}
