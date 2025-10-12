
package projeto_batalha_senhordosaneis.goblins;

public class ReiGoblin extends Goblin{
    
    public ReiGoblin(String nome, int idade, double peso) {
        super(nome, idade, peso);
        this.energia = 300;
    }

    @Override
    public int atacar() {
        int ataque = 100;
        
        return ataque;
    }

    @Override
    public void receberDano(int dano) {
        this.energia -= dano;
        
        if (dano >= energia){
            //morreu
            //ressucitar goblins mortos
        }    
    }
    
}
