
package projeto_batalha_senhordosaneis.elfos;

import projeto_batalha_senhordosaneis.Cavalo;

public class Superior_Elfo extends Elfo implements Montado{
    private final Cavalo cavalo;
    
    public Superior_Elfo(String nome, int idade, double peso, Cavalo cavalo) {
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
        int ataque;
        
        return ataque;
    }

    @Override
    public int receberDano() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
