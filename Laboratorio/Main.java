import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int quantiaTotal = 0, numeroCobaias = 0, numeroCoelhos = 0, numeroRatos = 0, numeroSapos = 0;
        // char rato, sapo, coelho;
        String tipoCobaia = "";
        int casosDeTeste = input.nextInt();

        for (int i = 0; i < casosDeTeste; i++) {
            numeroCobaias = input.nextInt();
            quantiaTotal += numeroCobaias;
            tipoCobaia = input.nextLine();
            if (tipoCobaia.compareTo(" C") == 0)
                numeroCoelhos += numeroCobaias;
            else if (tipoCobaia.compareTo(" R") == 0)
                numeroRatos += numeroCobaias;
            else
                numeroSapos += numeroCobaias;
        }
        double mediaCoelhos = ((double) numeroCoelhos * 100.0 / (double) quantiaTotal);
        double mediaRatos = ((double) numeroRatos * 100.0 / (double) quantiaTotal);
        double mediaSapos = ((double) numeroSapos * 100.0 / (double) quantiaTotal);
        System.out.println("Total: " + quantiaTotal + " cobaias");
        System.out.println("Total de coelhos: " + numeroCoelhos);
        System.out.println("Total de ratos: " + numeroRatos);
        System.out.println("Total de sapos: " + numeroSapos);
        System.out.printf("Percentual de coelhos: %.2f %%\n", mediaCoelhos);
        System.out.printf("Percentual de ratos: %.2f %%\n", mediaRatos);
        System.out.printf("Percentual de sapos: %.2f %%\n", mediaSapos);

    }
}