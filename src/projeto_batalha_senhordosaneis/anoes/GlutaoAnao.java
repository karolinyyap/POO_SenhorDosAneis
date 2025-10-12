
package projeto_batalha_senhordosaneis.anoes;

public class GlutaoAnao extends Anao implements Montado{
    private final PorcoGuerraAnao porco;

    public GlutaoAnao(String nome, int idade, double peso, PorcoGuerraAnao porco) {
        super(nome, idade, peso);
        this.porco = porco;
    }
    
    @Override
    public PorcoGuerraAnao getMontaria(){
        return this.porco;
    }

    @Override
    public int atacar() {
        int ataque = 30;

        return ataque;
    }

    @Override
    //libera o porco
    public void receberDano(int dano) {
        this.energia -= dano;
        if (energia <= 0){
            //morreu
        }
    }

    
    
    
}
