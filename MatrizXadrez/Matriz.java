import java.io.IOException;
import java.net.SocketImplFactory;
import java.util.Scanner;

public class Matriz {

    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        double soma = 0;
        char O = leitor.next().toUpperCase().charAt(0);
        double[][] M = new double[12][12];
        // leitura
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                M[i][j] = leitor.nextDouble();
            }
        }

        int constante = 11;
        for (int i = 1; i < 11; i++) {// linha
            for (int j = 11; ((i < 6 && j > constante - i) || (i == 6 && j > 6) || (i > 6 && j > i)); j--) {// coluna
                // System.out.println("[" + i + "][" + j + "]");
                // if (O == 'S' || O == 'M')
                soma += M[i][j];
            }
        }
        if (O == 'M')
            soma /= 30;
        System.out.println(String.format("%.1f", soma));
    }

}