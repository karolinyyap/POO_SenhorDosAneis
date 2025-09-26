
package projeto_batalha_senhordosaneis;

public class Orc extends Guerreiro{
    protected int ataque;
    
    public Orc(String nome, int idade, double peso, boolean montaria, int energia, int ataque) {
        super(nome, idade, peso, montaria, energia);
        this.ataque = ataque;
    }
    
}
