
package projeto_batalha_senhordosaneis.goblins;

import java.util.LinkedList;
import projeto_batalha_senhordosaneis.Guerreiro;

public class ComumGoblin extends Goblin{
    //Lista para armazenar os goblins mortos
    public static LinkedList<ComumGoblin> goblinsMortos = new LinkedList<>();

    public ComumGoblin(String nome, int idade, double peso) {
        super(nome, idade, peso);
        this.energia = 50;
    }

    //getAtaque
    @Override
    public int getAtaque(){
        return 10;
    }
    
    //Método atacar
    @Override
    public void atacar(LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2, boolean primeiroAtaque) {
        int ataque = this.getAtaque();
        
        //Se tiver praga dos porcos, retira cinco de energia conforme o nível da praga
        if (pragaDosPorcos){
            this.energia -= nivelPraga * 5;
        }
        
        //Realizando seu ataque
        lado2.getFirst().receberDano(ataque, lado1, lado2);
        if (lado2.getFirst().getEnergia() <= 0){
            lado2.removeFirst();
        }
    }

    //Método receber dano
    @Override
    public void receberDano(int dano, LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2) {
        this.energia -= dano;
        
        //Se energia estiver menor ou igual a 0, adiciona na lista de goblins mortos
        if (this.energia <= 0){
            goblinsMortos.add(this);
            this.energia = 0;
        } 
        
    }
    
    
    
}
