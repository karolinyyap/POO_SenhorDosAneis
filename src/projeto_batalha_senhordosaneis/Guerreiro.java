
package projeto_batalha_senhordosaneis;

public class Guerreiro {
    protected String nome;
    protected int idade;
    protected double peso;
    protected int energia;
    protected boolean montaria;  
    protected int ataque;

    public Guerreiro(String nome, int idade, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
//        this.montaria = montaria;
        this.energia = 100;
        this.ataque = 100;
    }

    public String getNome() {
        return nome;
    }

    public int getAtaque() {
        return ataque;
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
    
    
    
}
