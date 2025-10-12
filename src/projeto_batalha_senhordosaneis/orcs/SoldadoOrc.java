
package projeto_batalha_senhordosaneis.orcs;


public class SoldadoOrc extends Orc implements Montado {
    private final WargOrc warg; 

    public SoldadoOrc(String nome, int idade, double peso, WargOrc warg) {
        super(nome, idade, peso);
        this.warg = warg;
    }

    @Override
    public WargOrc getMontaria(){
        return this.warg;
    }

    @Override
    public int atacar() {
        int ataque = 20;
        
        if (this.warg != null){
            ataque += this.warg.atacar();
        }
        
        return ataque;
    };

    @Override
    public void receberDano(int dano) {
        this.energia -= dano;
        
        if (dano >= energia){
            //morreu
        }
    }
}
