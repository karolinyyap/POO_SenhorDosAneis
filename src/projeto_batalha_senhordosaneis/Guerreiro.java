
package projeto_batalha_senhordosaneis;

import java.util.LinkedList;

public abstract class Guerreiro {
    private String nome;
    private int idade;
    private double peso;
    protected int energia;
    protected boolean pragaDosPorcos = false;
    protected int nivelPraga = 0;
    protected boolean tonto = false;

    public Guerreiro(String nome, int idade, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.energia = 100;
    }
    
    public abstract void atacar(LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2, boolean primeiroAtaque);
    
    public abstract void receberDano(int dano, LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2);
    
    public abstract int getAtaque();

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }
    
    
    public void pragaDosPorcos(boolean praga) {
        pragaDosPorcos = praga;
        if(pragaDosPorcos){
                if(nivelPraga < 3){
                nivelPraga++;
            }
        }
    }
    
    public boolean isTonto() {
        return tonto;
    }

    public void setTonto(boolean tonto) {
        this.tonto = tonto;
    }

    public boolean estaVivo() {
        return energia > 0;
    }
    
    public void exibirInfo() {
    System.out.println(
        "| Nome: " + nome +
        ", Idade: " + idade +
        ", Peso: " + peso +
        ", Classe: " + this.getClass().getSimpleName() +
        ", Energia: " + energia +
        "\n-------------------------------------------------------------------------------------"
    );
}


    
    
}
