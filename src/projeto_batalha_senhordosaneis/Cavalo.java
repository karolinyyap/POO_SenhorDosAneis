
package projeto_batalha_senhordosaneis;

public class Cavalo extends Guerreiro{

    public Cavalo(String nome, int idade, double peso) {
        super(nome, idade, peso);
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
