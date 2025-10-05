
package projeto_batalha_senhordosaneis.elfos;

import projeto_batalha_senhordosaneis.Cavalo;

public class Arqueiro_Elfo extends Elfo implements Montado{
    private final Cavalo cavalo;
    
    public Arqueiro_Elfo(String nome, int idade, double peso, Cavalo cavalo) {
        super(nome, idade, peso);
        this.cavalo = cavalo;
    }
    
    @Override
    public Cavalo getMontaria(){
        return this.cavalo;
    }

    @Override
    public int atacar() {
        //acerta toda a fileira
        int ataque = 5;
        
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
