//Classe croada com o intuito de contabilizar o número de pessoas que já realizaram o ciclo completo do programa.
public class Contador {

	// Uso do "volatile" pelo fato de se tratar de uma variável compartilhada com
	// alto número de modificações
	private volatile int contagem;

	// Método criado para obter o valor do contador
	public synchronized final int getContagem() {
		return contagem;
	}

	// Método criado para incrementar o valor do contador
	public synchronized final void incrementa() {
		this.contagem++;
	}

}
