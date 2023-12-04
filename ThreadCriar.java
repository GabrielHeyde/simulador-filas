
//Thread criada para realizar a criação das pessoas que estarão indo entrar nas filas para serem atendidas pelos servidores
import java.util.ArrayList;

public class ThreadCriar implements Runnable {

    // Esta Thread recebe uma lista de nomes para criar pessoas com variados nomes e
    // trazer uma personalização maior ao código, além de receber uma fila oculta
    // para deixar as pessoas criadas em uma espécie de "stage" até serem
    // direcionadas a uma das filas existentes
    private ArrayList<String> nomesDePessoas;
    private Fila filaEspera;

    public ThreadCriar(ArrayList<String> nomesDePessoas, Fila filaEspera) {
        this.nomesDePessoas = nomesDePessoas;
        this.filaEspera = filaEspera;

    }

    public ArrayList<String> getNomesDePessoas() {
        return nomesDePessoas;
    }

    public Fila getFilaEspera() {
        return filaEspera;
    }

    // Método criado para realizar a criação das pessoas que entrarão no nosso
    // programa.
    public Pessoa criaPessoa() {
        boolean preferencial = false;
        // O Método busca aleatoriamente uma das Strings existentes na lista de nomes
        // para atribuir ao novo objeto
        String nome = nomesDePessoas.remove((int) (Math.random() * nomesDePessoas.size()));
        // O método aleatoriza uma idade para a pessoa que entrará na fila entre 18 e 85
        // anos.
        int idade = (int) (Math.random() * 68) + 18;
        // Caso a pessoa tenha 65 anos ou mais a mesma já é considerada um cliente
        // preferencial
        if (idade >= 65) {
            preferencial = true;
            // Caso a pessoa tenha menos de 65 anos, é feito um aleatorizador de
            // probabilidade, havendo uma chance em dez da pessoa receber atendimento
            // preferencial.
        } else {
            int probabilidade = (int) (Math.random() * 10);
            if (probabilidade == 0) {
                preferencial = true;
            } else {
                preferencial = false;
            }
        }
        Pessoa p = new Pessoa(nome, idade, preferencial);
        // Após a criação do novo objeto da classe Pessoa é informado na tela os
        // atributos do mesmo e indicando que o mesmo está se direcionando ao local de
        // atendimento.
        if (preferencial == true) {
            System.out.println(p.getNome() + " (" + p.getIdade()
                    + " anos) - PREFERENCIAL, está se deslocando até o local para retirar o seu kit do Junte e Ganhe do Diário Gaúcho.\n");
        } else {
            System.out.println(p.getNome() + " (" + p.getIdade()
                    + " anos), está se deslocando até o local para retirar o seu kit do Junte e Ganhe do Diário Gaúcho.\n");
        }
        return p;
    }

    // Método run da Thread que chama o método de criar pessoas, adiciona a mesma na
    // fila que tem a função de servir como "stage" e põem a mesma em repousa por um
    // intervalo de tempo aleatório de até 12 segundos.
    public void run() {
        while (nomesDePessoas.size() != 0) {
            Pessoa novaPessoa = criaPessoa();
            filaEspera.inserir(novaPessoa);
            try {
                Thread.sleep((int) (Math.random() * 12000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
