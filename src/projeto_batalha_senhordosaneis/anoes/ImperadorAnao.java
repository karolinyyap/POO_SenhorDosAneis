package projeto_batalha_senhordosaneis.anoes;

import java.util.LinkedList;
import projeto_batalha_senhordosaneis.Guerreiro;
import projeto_batalha_senhordosaneis.Montado;

public class ImperadorAnao extends Anao implements Montado {
    //Montaria
    private PorcoGuerraAnao porco;
    private static boolean imperadorExiste = false;
    //pertence à classe ImperadorAnao e não a um objeto específico

    public ImperadorAnao(String nome, int idade, double peso, PorcoGuerraAnao porco) {
        super(nome, idade, peso);

        //Verifica se o imperador já existe na lista
        if (imperadorExiste) {
            throw new IllegalArgumentException("Erro: só pode existir um Imperador na batalha!");
        }

        this.imperadorExiste = true;
        this.energia = 250;
        this.porco = porco;
    }

    //Montaria
    @Override
    public Guerreiro getMontaria() {
        return this.porco;
    }

    //getAtaque
    @Override
    public int getAtaque() {
        return 50;
    }

    //Método atacar
    @Override
    public void atacar(LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2, boolean primeiroAtaque) {
        int ataque = this.getAtaque();

        //Ataque primeiro, tonteia o inimigo
        if (primeiroAtaque) {
            lado1.getFirst().receberDano(ataque, lado1, lado2);
            lado1.getFirst().setTonto(true);
        } else {
            //Se não só faz seu ataque normal
            lado1.getFirst().receberDano(ataque, lado1, lado2);
        }

        if (lado1.getFirst().getEnergia() <= 0) {
            lado1.removeFirst();
        }
    }

        //Método receber dano
    @Override
    public void receberDano(int dano, LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2) {
        this.energia -= dano;
        
        //Libera a montaria quando esse morre
        if (this.energia <= 0 && this.porco != null) {
            lado1.addLast(this.porco);
            this.porco = null;
        }

    }

}
