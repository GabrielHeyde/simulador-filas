
//Classe criada com o intuito de facilitar a criação das filas, já dispondo de alguns métodos da classe para facilitar o uso do objeto
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class Fila {

	// Cada fila recebe um nome, uma queue e uma lista para facilitar a impressão
	// dos elementos da fila
	private String nome;
	private Queue<Pessoa> fila;
	private ArrayList<Pessoa> filaEspelho;

	public Fila(String nome) {
		this.nome = nome;
		this.fila = new LinkedBlockingDeque<Pessoa>();
		this.filaEspelho = new ArrayList<Pessoa>();
	}

	public ArrayList<Pessoa> getFilaEspelho() {
		return filaEspelho;
	}

	public String getNome() {
		return nome;
	}

	// Método criado para facilitar a inserção de pessoas na fila
	public void inserir(Pessoa pessoa) {
		fila.add(pessoa);
		filaEspelho.add(pessoa);
	}

	// Método criado para facilitar a remoção de pessoas na fila
	public Pessoa remove() {
		Pessoa retorno = fila.remove();
		filaEspelho.remove(retorno);
		return retorno;
	}

	// Método criado para facilitar a observação do tamanho da fila
	public int size() {
		return fila.size();
	}

	// Método criado para verificar se a fila está vazia
	public boolean isEmpty() {
		return (size() == 0);
	}

	// Método criado para imprimir os elementos das filas existentes
	public void imprimirFilaEspelho(ArrayList<Pessoa> filaImprimida) {
		System.out.print("[");
		for (int index = 0; index < fila.size(); index++) {
			if (index == 0) {
				System.out.print(filaImprimida.get(index).getNome());
			} else {
				System.out.print(" / " + filaImprimida.get(index).getNome());
			}
		}
		System.out.print("]\n\n");
	}

}
