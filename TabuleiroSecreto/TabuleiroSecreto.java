import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TabuleiroSecreto {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int x = 0;
        int tamanhoLinhaEColuna = input.nextInt();
        int quantidadeOperacoes = input.nextInt();
        int[][] matriz = new int[tamanhoLinhaEColuna + 1][tamanhoLinhaEColuna + 1];
        // linha e coluna da matriz inicia em 1
        // for (int i = 1; i <= tamanhoLinhaEColuna; i++) {
        // for (int j = 1; j <= tamanhoLinhaEColuna; j++) {
        // System.out.println("i:" + i + "j:" + j);
        // }
        // }
        for (int i = 0; i < quantidadeOperacoes; i++) {
            int linha = 0;
            int tipoOperacao = input.nextInt();
            if (tipoOperacao == 1) {// atribuir valor à linha
                linha = input.nextInt();
                int valor = input.nextInt();
                // inserido com sucesso!
                for (int k = 1; k < matriz.length; k++) {
                    matriz[linha][k] = valor;
                }
            } else if (tipoOperacao == 2) {
                int coluna = input.nextInt();
                int valor = input.nextInt();
                // inserido com sucesso!
                for (int k = 1; k < matriz.length; k++) {
                    matriz[k][coluna] = valor;
                }

            } else if (tipoOperacao == 3) { // imprimir valor da linha
                for (int l = 0; l < matriz.length; l++) {
                    // inserir valores numa hashmap
                    // OBS: VER VÍDEOS SOBRE HASHMAP
                }
            }
            // if (tipoOperacao == 1 || tipoOperacao == 2) {// 1 atribuir à linha, 2
            // atribuir à coluna
            // int linhaOuColuna = input.nextInt();
            // int valor = input.nextInt();
            // } else {// tipo operacao igual a 3 ou 4
            // int valorMaisFrequenteLinhaOuColuna = input.nextInt();// 3 linha e 4 coluna
            // }
        }
    }
}