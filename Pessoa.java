//Classe Pessoa criada para servir como usuário
public class Pessoa {

    private String nome;
    private int idade;
    private boolean preferencial;

    public Pessoa(String nome, int idade, boolean preferencial) {
        this.nome = nome;
        this.idade = idade;
        this.preferencial = preferencial;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public boolean isPreferencial() {
        return preferencial;
    }

}