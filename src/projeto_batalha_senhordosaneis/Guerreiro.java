
package projeto_batalha_senhordosaneis;

public abstract class Guerreiro {
    private String nome;
    private int idade;
    private double peso;
    protected int energia;

    public Guerreiro(String nome, int idade, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.energia = 100;
    }

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
    
    public abstract int atacar();
    
    public abstract void receberDano(int dano);
    
    public void exibirInfo() {
    System.out.println(
        "| Nome: " + nome +
        ", Idade: " + idade +
        ", Peso: " + peso +
        ", Energia: " + energia +
        ", Ataque: " + "\n-------------------------------------------------------------------------------------"
    );
}


    
    
}
