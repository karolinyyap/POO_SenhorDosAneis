
package projeto_batalha_senhordosaneis.elfos;

import projeto_batalha_senhordosaneis.Cavalo;

public class SuperiorElfo extends Elfo implements Montado{
    private final Cavalo cavalo;
    
    public SuperiorElfo(String nome, int idade, double peso, Cavalo cavalo) {
        super(nome, idade, peso);
        this.energia = 500;
        this.cavalo = cavalo;
    }
    
    @Override
    public Cavalo getMontaria(){
        return this.cavalo;
    }

    @Override
    public int atacar() {
        int ataque = 500;
        
        return ataque;
    }

    @Override
    public void receberDano(int dano) {
        if (this.cavalo != null){
                this.cavalo.receberDano(dano);
            } else {
                this.energia -= dano;
            }

            if (energia <= 0){
                //morreu
            }    
    }
    
}
