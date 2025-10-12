
package projeto_batalha_senhordosaneis.anoes;

public class ImperadorAnao extends Anao implements Montado{
    private final PorcoGuerraAnao porco;
    
    public ImperadorAnao(String nome, int idade, double peso, PorcoGuerraAnao porco) {
        super(nome, idade, peso);
        this.energia = 250;
        this.porco = porco;
    }
    
    @Override
    public PorcoGuerraAnao getMontaria(){
        return this.porco;
    }

    @Override
    public int atacar() {
        int ataque = 0;
        
        return ataque;
    }

    @Override
    public void receberDano(int dano) {
        this.energia -= dano;
        if (energia <= 0){
            //morreu
        }
    }
    
}
