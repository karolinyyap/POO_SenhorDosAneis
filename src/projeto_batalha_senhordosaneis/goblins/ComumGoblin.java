
package projeto_batalha_senhordosaneis.goblins;

public class ComumGoblin extends Goblin{

    public ComumGoblin(String nome, int idade, double peso) {
        super(nome, idade, peso);
        this.energia = 50;
    }

    @Override
    public int atacar() {
        int ataque = 10;
        
        return ataque;
    }

    @Override
    public void receberDano(int dano) {
        this.energia -= dano;
        
        if (dano >= energia){
            //morreu
        }    
    }
    
    
    
}
