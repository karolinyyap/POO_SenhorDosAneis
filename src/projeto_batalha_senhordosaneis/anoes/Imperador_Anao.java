
package projeto_batalha_senhordosaneis.anoes;

public class Imperador_Anao extends Anao implements Montado{
    private final PorcoGuerra_Anao porco;
    
    public Imperador_Anao(String nome, int idade, double peso, PorcoGuerra_Anao porco) {
        super(nome, idade, peso);
        this.energia = 250;
        this.porco = porco;
    }
    
    @Override
    public PorcoGuerra_Anao getMontaria(){
        return this.porco;
    }

    @Override
    public int atacar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int receberDano() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
