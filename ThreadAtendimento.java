//Thread criada para simular o atendimento das pessoas nas filas.
public class ThreadAtendimento implements Runnable {

    // Cada Thread desta classe representa um balcão de atendimento, desta forma,
    // cada Thread receberá apenas uma das filas para realizar o atendimento, além
    // do contador, que este sim será compartilhado entre todas as Threads.
    private Fila fila;
    private Contador contador;

    public ThreadAtendimento(Fila fila, Contador contador) {
        this.fila = fila;
        this.contador = contador;
    }

    // Array com as opções dos kits de retirada do Junte e Ganhe do Diário Gaúcho.
    String[] kits = { "churraso", "panelas", "facas" };

    public synchronized void run() {
        // Cada Thread trabalhará até que 30 pessoas sejam atendidas no total
        while (contador.getContagem() < 30) {
            // O programa então puxa o primeiro elemento de sua respectiva fila caso a mesma
            // não esteja vazia e simula o atendimento.
            if (!fila.isEmpty()) {
                Pessoa pessoaEmAtendimento = fila.remove();
                System.out.println(pessoaEmAtendimento.getNome() + " (" + pessoaEmAtendimento.getIdade()
                        + " anos) passou no balcão de retirada da fila " + fila.getNome() + " para ser atendido.");
                System.out.print("FILA " + fila.getNome() + " ");
                fila.imprimirFilaEspelho(fila.getFilaEspelho());
                // O programa então pode levar até 20 segundos para concluir a simulação do
                // atendimento do cliente.
                try {
                    Thread.sleep((int) (Math.random() * 19001) + 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // O programa então informa quando o atendimento é encerrado e imprime o número
                // que corresponde a este atendimento.
                System.out.println(pessoaEmAtendimento.getNome() + " (" + pessoaEmAtendimento.getIdade()
                        + " anos) retirou seu kit de " + kits[(int) (Math.random() * 3)]
                        + " e está indo embora do local de retirada.");
                contador.incrementa();
                System.out.println("Este foi o kit de número " + contador.getContagem() + " a ser retirado no dia!\n");
            }
            // A Thread então entra em repouso de forma aleatória por um intervalo máximo de
            // 12 segundos.
            try {
                Thread.sleep((int) (Math.random() * 12000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
