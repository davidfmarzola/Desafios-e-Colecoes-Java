import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Data {
	protected String dataAtualFormatada;
	
	public Data() {
		LocalDate dataAtual = java.time.LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/y");
		this.dataAtualFormatada = dataAtual.format(formatter);
	}


	public String getDataAtualFormatada() {
		return dataAtualFormatada;
	}


	public static void main(String[] args) {
		Data data = new Data();
		System.out.println(data.getDataAtualFormatada());
	}

}
