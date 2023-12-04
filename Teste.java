//Classe criada para testar a execução do programa;
import java.util.ArrayList;

public class Teste {

    public static void main(String[] args) {

        // Lista criada para inserir os nomes que farão parte do programa;
        ArrayList<String> nomes = new ArrayList<>();

        // Criação das filas que serão utilizadas pelo sistema e do contador
        // compartilhado.
        Fila filaEspera = new Fila("Espera");
        Fila filaA = new Fila("A");
        Fila filaB = new Fila("B");
        Fila filaPreferencial = new Fila("Preferencial");
        Contador contador = new Contador();

        // Adição das Strings com os nomes dos usuários.
        nomes.add("Miguel");
        nomes.add("Arthur");
        nomes.add("Heitor");
        nomes.add("Bernardo");
        nomes.add("Theo");
        nomes.add("Gabriel");
        nomes.add("Gael");
        nomes.add("Davi");
        nomes.add("Joaquim");
        nomes.add("Vicente");
        nomes.add("Helena");
        nomes.add("Alice");
        nomes.add("Laura");
        nomes.add("Cecília");
        nomes.add("Valentina");
        nomes.add("Lívia");
        nomes.add("Antonella");
        nomes.add("Aurora");
        nomes.add("Maria");
        nomes.add("Sophia");
        nomes.add("Clara");
        nomes.add("João");
        nomes.add("José");
        nomes.add("Eduardo");
        nomes.add("Jardel");
        nomes.add("Nathália");
        nomes.add("Isabela");
        nomes.add("Pedro");
        nomes.add("Alex");
        nomes.add("Sofia");

        // Criação das Threads responsáveis pelo funcionamento do programa.
        Thread cria = new Thread(new ThreadCriar(nomes, filaEspera));
        Thread distribui = new Thread(new ThreadDistribui(filaEspera, filaA, filaB, filaPreferencial));
        Thread atendimentoA = new Thread(new ThreadAtendimento(filaA, contador));
        Thread atendimentoB = new Thread(new ThreadAtendimento(filaB, contador));
        Thread atendimentoPreferencial = new Thread(new ThreadAtendimento(filaPreferencial, contador));

        // Mensagem inicial de inicialização do Porgrama
        System.out.println(
                "\nHoje será o dia da entraga dos kits do Junte e Ganhe, projeto do grupo Diário Gaúcho, que consiste na troca de selos que podem ser pegos diariamente em suas edições e trocadas por um prêmio no final da temporada.\nNeste oportunidade teremos a distribuição de três kits diferentes aos leitores, sendo eles os seguintes:\n\n1 - Jogo de Churrasco;\n2 - Jogo de Panelas;\n3 - Jogo de Facas.\n\nVamos acompanhando através de nosso helicóptero a rotina dos participantes da promoção para vermos como ocorrerá a entrega no dia de hoje.\nNeste primeiro momento, todas as filas se encontram vazias.\n\nO programa foi feito com base no *Sistema de Múltiplas Filas*, tendo então três servidores, um para cada fila existente.\n=========================================================================================================================================================================================================================");
        // Informação do Status inicial das filas de atendimento
        System.out.print("FILA A ");
        filaA.imprimirFilaEspelho(filaA.getFilaEspelho());
        System.out.print("FILA B ");
        filaA.imprimirFilaEspelho(filaB.getFilaEspelho());
        System.out.print("FILA Preferencial ");
        filaA.imprimirFilaEspelho(filaPreferencial.getFilaEspelho());

        // Inicialização das Threads
        cria.start();
        distribui.start();
        atendimentoA.start();
        atendimentoB.start();
        atendimentoPreferencial.start();

        // Método join para fazer com que o programa só execute o restante após o
        // término de todas as Threads
        try {
            cria.join();
            distribui.join();
            atendimentoA.join();
            atendimentoB.join();
            atendimentoPreferencial.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Mensagem de encerramento do programa com o status final das filas utilizadas.
        System.out.println(
                "\n=========================================================================================================================================================================================================================\nEsta foi então a nossa cobertura do dia de entregas pela equipe do Diário Gaúcho no dia de hoje.\nAgradecemos por todos que acompanharam conosco este momento. Nos vemos na próxima, pessoal!");
        System.out.print("FILA A ");
        filaA.imprimirFilaEspelho(filaA.getFilaEspelho());
        System.out.print("FILA B ");
        filaA.imprimirFilaEspelho(filaB.getFilaEspelho());
        System.out.print("FILA Preferencial ");
        filaA.imprimirFilaEspelho(filaPreferencial.getFilaEspelho());
    }
}
