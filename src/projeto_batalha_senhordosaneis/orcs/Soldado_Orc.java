
package projeto_batalha_senhordosaneis.orcs;


public class Soldado_Orc extends Orc implements Montado {
    private final Warg_Orc warg; 

    public Soldado_Orc(String nome, int idade, double peso, Warg_Orc warg) {
        super(nome, idade, peso);
        this.warg = warg;
    }

    @Override
    public Warg_Orc getMontaria(){
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
