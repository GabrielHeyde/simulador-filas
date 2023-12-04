//Thread criada para realizar a distribuição das pessoas nas filas existentes para o atendimento
public class ThreadDistribui implements Runnable {

    // Ela recebe então por parâmetro a mesma fila que será compartilhada com a
    // Thread que cria as Pessoas para poder distribuir os elementos entre as três
    // filas existentes.
    private Fila filaEspera;
    private Fila filaA;
    private Fila filaB;
    private Fila filaPreferencial;

    public ThreadDistribui(Fila filaEspera, Fila filaA, Fila filaB, Fila filaPreferencial) {
        this.filaEspera = filaEspera;
        this.filaA = filaA;
        this.filaB = filaB;
        this.filaPreferencial = filaPreferencial;
    }

    public void run() {
        // A Thread começa em repouso aleatório de até 12 segundos para que o programa
        // tenha tempo de realizar a criação de algum(ns) usuário(S)
        try {
            Thread.sleep((int) (Math.random() * 12000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // A Thread conta que deverá realizar a distribuição de trinta pessoas.
        int pessoasAtendidas = 0;
        while (pessoasAtendidas < 30) {
            if (!filaEspera.isEmpty()) {
                Pessoa proximaPessoa = filaEspera.remove();
                // A Thread então busca o primeiro elemento adicionada na fila de "stage" e
                // verifica se o atributo preferencial é verdadeiro, caso seja, o mesmo
                // direciona a pessoa à fila preferencial
                if (proximaPessoa.isPreferencial() == true) {
                    filaPreferencial.inserir(proximaPessoa);
                    System.out.println(proximaPessoa.getNome() + " (" + proximaPessoa.getIdade()
                            + " anos) - PREFERENCIAL, chegou no local de retirada e foi direcinado(a) para a fila preferencial.");
                    System.out.print("FILA " + filaPreferencial.getNome() + " ");
                    filaPreferencial.imprimirFilaEspelho(filaPreferencial.getFilaEspelho());
                } else {
                    // Caso o atributo preferencial seja falso porém a fila preferencial esteja
                    // vazia, o mesmo é direcionado para esta fila.
                    if (filaPreferencial.size() == 0) {
                        filaPreferencial.inserir(proximaPessoa);
                        System.out.println("Como a fila preferencial estava vazia, " + proximaPessoa.getNome() + " ("
                                + proximaPessoa.getIdade()
                                + " anos) foi direcinado(a) para esta fila.");
                        System.out.print("FILA " + filaPreferencial.getNome() + " ");
                        filaPreferencial.imprimirFilaEspelho(filaPreferencial.getFilaEspelho());
                        // Agora, caso a pessoa em questão não tenha atendimento preferencial e a fila
                        // preferencial não esteja vazia, é sorteado de forma aleatória para direcionar
                        // a pessoa para a fila A ou para a fila B
                    } else {
                        int qualFila = (int) (Math.random() * 2);
                        if (qualFila == 0) {
                            filaA.inserir(proximaPessoa);
                            System.out.println(proximaPessoa.getNome() + " (" + proximaPessoa.getIdade()
                                    + " anos), chegou no local de retirada e foi direcinado(a) para a fila "
                                    + filaA.getNome() + ".");
                            System.out.print("FILA " + filaA.getNome() + " ");
                            filaA.imprimirFilaEspelho(filaA.getFilaEspelho());
                        } else if (qualFila == 1) {
                            filaB.inserir(proximaPessoa);
                            System.out.println(proximaPessoa.getNome() + " (" + proximaPessoa.getIdade()
                                    + " anos), chegou no local de retirada e foi direcinado(a) para a fila "
                                    + filaB.getNome() + ".");
                            System.out.print("FILA " + filaB.getNome() + " ");
                            filaB.imprimirFilaEspelho(filaB.getFilaEspelho());
                        }
                    }
                }
                // O acumulador é incrementado e a Thread entra em repouso aleatório de até 12
                // segundos.
                pessoasAtendidas++;
                try {
                    Thread.sleep((int) (Math.random() * 12000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
