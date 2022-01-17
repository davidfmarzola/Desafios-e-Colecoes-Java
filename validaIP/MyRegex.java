import java.util.*;

class MyRegex {
    public static void verificaIP(String entrada) {
        int numeroDePontos = 0, quantidadeCaracteres = 0, numero = 0, j = 0;
        String caractere = "";
        String[] m = new String[] {};
        do {
            quantidadeCaracteres = 0;
            caractere = "";
            // tratamento de dados
            for (; j < entrada.length() && entrada.charAt(j) != '.'; j++) {
                if ((int) entrada.charAt(j) < 48 || (int) entrada.charAt(j) > 57) {
                    System.out.println("false");
                    MyRegex.main(m); // invocando o metodo main - senão vai lançar exceção ao incrementar o j
                }
                quantidadeCaracteres++;// minimo dois, máximo três
                caractere += entrada.charAt(j);// concatenando os numeros para verificar se está entre 0 e 255
            }
            if (j < entrada.length() && entrada.charAt(j) == '.')
                numeroDePontos++;
            j++;// pegando o indice após o '.'
        } while (entrada.length() > j);

        try {
            numero = Integer.parseInt(caractere);
        } catch (NumberFormatException e) { // for input string: "" - vazio
            System.out.println("false");
            MyRegex.main(m); // invocando o metodo main - senão vai imprimir false ou true a seguir
        }
        if (numero < 0 || numero > 255)
            System.out.println("false");
        else if (quantidadeCaracteres < 2 || quantidadeCaracteres > 3) {
            System.out.println("false");
            MyRegex.main(m); // invocando o metodo main - senão vai lançar exceção ao incrementar o j
        } else if (numeroDePontos != 3)
            System.out.println("false");
        else
            System.out.println("true");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String entrada = scan.nextLine();
        while (entrada != "") {
            try {
                verificaIP(entrada);
                entrada = scan.nextLine();
            } catch (NoSuchElementException e) {
                System.exit(0);
            }
        }
        scan.close();
    }
}