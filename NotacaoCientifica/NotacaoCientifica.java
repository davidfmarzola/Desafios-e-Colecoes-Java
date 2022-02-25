import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class NotacaoCientifica {

	public static void main(String[] args) throws IOException {
		Scanner leitor = new Scanner(System.in);
		String numero = leitor.nextLine();
		int numeroCasasDecimais = 0;
		int i = 0;

		for (; i < numero.length(); i++) {
			if (numero.charAt(i) == '.') {
				// contando o numero de casas decimais
				while (++i < numero.length()) {
					numeroCasasDecimais++;
				}
			}

		}

		// convertendo para double no padrão decimal americano(.)
		double numeroDouble = Double.valueOf(numero);
		DecimalFormat f = new DecimalFormat("#.####", new DecimalFormatSymbols(new Locale("en", "US")));
		if (numeroCasasDecimais <= 6 && numeroCasasDecimais != 0) {
			System.out.printf("+" + f.format(numeroDouble) + "E+00\n");
		} else if (numeroCasasDecimais == 0) {
			// Obs: formatar corretamente um inteiro
			System.out.printf("+" + numeroDouble + "E+23\n");
		}
	}

}
