
package projeto_batalha_senhordosaneis.orcs;

import java.util.LinkedList;
import projeto_batalha_senhordosaneis.Guerreiro;

public class SenhorDasFerasOrc extends Orc{
    
    public SenhorDasFerasOrc(String nome, int idade, double peso) {
        super(nome, idade, peso);
        this.energia = 400;
    }
    
    //getAtaque
    @Override
    public int getAtaque(){
        return 50;
    }

    //Método atacar
    @Override
    public void atacar(LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2, boolean primeiroAtaque) {
        int ataque = this.getAtaque();
        
        //Se tiver praga dos porcos, retira cinco de energia conforme o nível da praga
        if (pragaDosPorcos){
            this.energia -= nivelPraga * 5;
        }
        
        lado2.getFirst().receberDano(ataque, lado1, lado2);
        if(lado2.getFirst().getEnergia() <= 0){
            //Se matar um inimigo, adiciona um warg na fila do seu lado
            criarLegiaoWargs(lado1);
            lado2.removeFirst();
        }
        
    }

    //Método receber dano
    @Override
    public void receberDano(int dano, LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2) {
        this.energia -= dano;
        
    }
    
    //Criar a legião de wargs
    public void criarLegiaoWargs(LinkedList<Guerreiro> lado1){
        WargOrc warg = new WargOrc("Warg Legiao", this.getIdade(), this.getPeso());
        lado1.addLast(warg);
        
    }
}
