
package projeto_batalha_senhordosaneis.orcs;

public class AcougueiroOrc extends Orc implements Montado {
    private WargOrc warg; 
    
    public AcougueiroOrc(String nome, int idade, double peso) {
        super(nome, idade, peso);
        this.energia = 200;
        this.warg = warg;
    }
    
    @Override
    public WargOrc getMontaria(){
        return this.warg;
    }

    @Override
    public int atacar() {
        int ataque = 20;
        
        return ataque;
    }
    
    @Override
    public void receberDano(int dano) {
        this.energia -= dano;
        
        if (this.energia <= 40){
            if (this.warg != null){
                this.energia += 100;
            }
        }
        
        if (dano >= energia){
            //morreu
            //flag warg morre junto
        }
    }
}
