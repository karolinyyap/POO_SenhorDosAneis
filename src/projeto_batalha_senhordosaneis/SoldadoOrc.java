
package projeto_batalha_senhordosaneis;

public class SoldadoOrc extends Orc{

    public SoldadoOrc(int ataque, String nome, int idade, double peso, boolean montaria, int energia) {
        super(nome, idade, peso, montaria, energia, ataque);
    }

    @Override
    public void setMontaria(boolean montaria) {
        this.montaria = true;
    }

    public boolean getMontaria() {
        return montaria;
    }
    
    public void setAtaque(int ataque) {
        this.ataque = 20;
    }
}
