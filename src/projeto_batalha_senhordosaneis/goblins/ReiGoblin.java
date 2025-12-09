
package projeto_batalha_senhordosaneis.goblins;

import java.util.Iterator;
import java.util.LinkedList;
import projeto_batalha_senhordosaneis.Guerreiro;
import static projeto_batalha_senhordosaneis.goblins.ComumGoblin.goblinsMortos;

public class ReiGoblin extends Goblin{
    private static boolean reiExiste = false;
    
    public ReiGoblin(String nome, int idade, double peso) {
        super(nome, idade, peso);
                
        //Verifica se o reiGoblin já existe no arquivo
        if (reiExiste) {
            throw new IllegalArgumentException("Erro: só pode existir um Rei Goblin na batalha!");
        }
        
        this.reiExiste = true;
        this.energia = 300;
    }
    
    //getAtaque
    @Override
    public int getAtaque(){
        return 100;
    }

    //Método atacar
    @Override
    public void atacar(LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2, boolean primeiroAtaque) {
        int ataque = this.getAtaque();
        
        //Se tiver praga dos porcos, retira cinco de energia conforme o nível da praga
        if (pragaDosPorcos){
            ataque -= nivelPraga * 5;
        }
        
        //Realizando seu ataque
        lado2.getFirst().receberDano(ataque, lado1, lado2);
        if (lado2.getFirst().getEnergia() <= 0){
            lado2.removeFirst();
        }
    }

    //Método receber dano
    @Override
    public void receberDano(int dano,LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2) {
        this.energia -= dano;
        
        if (this.energia <= 0){
            //Habilidade especial do rei goblin
            Iterator <ComumGoblin> it = goblinsMortos.iterator();
            while(it.hasNext()){
                ComumGoblin goblin = it.next();
                //Mudando a energia de 50 para 50
                goblin.setEnergia(50);
                lado1.addLast(goblin);
                goblin.pragaDosPorcos(false);
                it.remove();
            }
        }
        
    }
    
}
