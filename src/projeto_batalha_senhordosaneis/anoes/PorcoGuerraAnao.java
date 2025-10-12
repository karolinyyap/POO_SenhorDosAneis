
package projeto_batalha_senhordosaneis.anoes;

public class PorcoGuerraAnao extends Anao {
    
    public PorcoGuerraAnao(String nome, int idade, double peso) {
        super(nome, idade, peso);
        this.energia = 250;
    }

    @Override
    public int atacar() {
        int ataque = 15;
        
        return ataque;
    }

    @Override
    public void receberDano(int dano) {
        
    }
    
}
