
package projeto_batalha_senhordosaneis.orcs;

public class WargOrc extends Orc{
    
    public WargOrc(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    @Override
    public int atacar() {
        int ataque = 15;
        
//        if (){
//            wargs em fileira
//        }
        
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
