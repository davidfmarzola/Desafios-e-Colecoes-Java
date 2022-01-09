import java.util.*;

class LinkedListSeries {
    static Scanner ler = new Scanner(System.in);
    Series serie = new Series();
    static LinkedList<String> objetosRemovidos;
    static LinkedList<Series> objetos;
    static int indice;

    LinkedListSeries() {
        this(50);
    }

    LinkedListSeries(int tamanho) {
        // objSeries = new Series[tamanho];
        indice = 0;
        objetosRemovidos = new LinkedList<String>();
        objetos = new LinkedList<Series>();
    }

    public static void inserirInicio(Series series) throws Exception {
        objetos.addFirst(series);
    }

    public static void inserirFim(Series serie) throws Exception {
        objetos.addLast(serie);
    }

    public static void inserir(Series serie, int pos) throws Exception {
        objetos.add(pos, serie);

    }

    public static void removerInicio() throws Exception {
        Series resp = objetos.getFirst();
        objetos.removeFirst();

        adicionaObjetosRemovidos(resp);
    }

    public static void removerFim() throws Exception {
        Series resp = objetos.getLast();
        objetos.removeLast();
        adicionaObjetosRemovidos(resp);
    }

    public static void remover(int pos) throws Exception {
        Series resp = objetos.get(pos);
        objetos.remove(pos);
        adicionaObjetosRemovidos(resp);
    }

    public static void adicionaObjetosRemovidos(Series serie) throws Exception {
        String nome = serie.getNome();
        objetosRemovidos.add(nome);
    }

    public static void imprimirObjetosRemovidos(Series serie) {
        for (int i = 0; i < objetosRemovidos.size(); i++) {
            System.out.println("(R) " + objetosRemovidos.get(i));
        }
    }

    public static void imprimirObjetosSetados() {
        for (int i = 0; i < objetos.size(); i++) {
            objetos.get(i).imprimir(objetos.get(i));
        }
    }

    public static void main(String[] args) throws Exception {
        // Series serie = new Series();
        String entrada = ler.nextLine();
        String endereco = Series.PREFIXO;
        while (!Series.isFim(entrada)) {
            String caminhoDoArquivo = endereco + entrada;
            inserirFim(Series.lerAtributo(caminhoDoArquivo));

            entrada = ler.nextLine();
        }

        int qtdOperacoes = ler.nextInt();
        String[] segundaParte = new String[qtdOperacoes];
        int j = 0;
        // armazenando a segunda parte(entrada) no array
        segundaParte[j] = ler.nextLine();
        while (j < qtdOperacoes) {
            segundaParte[j] = ler.nextLine();
            j++;
        }
        insereLista(segundaParte);
        imprimirObjetosRemovidos(Series.serie);
        imprimirObjetosSetados();
        ler.close();
    }

    public static void insereLista(String[] vetorLido) throws Exception {
        for (int i = 0; i < 30; i++) {
            String[] vetorTratado = vetorLido[i].split(" ");
            if (vetorTratado[0].compareTo("II") == 0) {
                LinkedListSeries.inserirInicio(Series.lerAtributo(Series.PREFIXO + vetorTratado[1]));
            } else if (vetorTratado[0].compareTo("IF") == 0) {
                LinkedListSeries.inserirFim(Series.lerAtributo(Series.PREFIXO + vetorTratado[1]));
            } else if (vetorTratado[0].compareTo("I*") == 0) {
                LinkedListSeries.inserir(Series.lerAtributo(Series.PREFIXO + vetorTratado[2]),
                        Integer.parseInt(vetorTratado[1]));
            } else if (vetorTratado[0].compareTo("RI") == 0) {
                LinkedListSeries.removerInicio();
            } else if (vetorTratado[0].compareTo("RF") == 0) {
                LinkedListSeries.removerFim();
            } else if (vetorTratado[0].compareTo("R*") == 0) {
                LinkedListSeries.remover(Integer.parseInt(vetorTratado[1]));
            }
        }

    }

}
