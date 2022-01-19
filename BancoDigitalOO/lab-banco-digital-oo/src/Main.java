import java.io.IOException;
import java.util.*;

public class Main {

	public static void tratarOperacoes(Conta objetoTipoConta, String operacao, double valor) {
		if(operacao.compareTo("Saque") == 0) {
			objetoTipoConta.sacar(valor);
		} else if(operacao.compareTo("Depósito") == 0) {
			objetoTipoConta.depositar(valor);
		}
		objetoTipoConta.imprimirExtrato();
	}
	
	public static void tratarTransferencia(Conta contaEnvio, Conta contaDestino, double valor) {
		//transfiro da contaEnvio para a contaDestino
		contaEnvio.transferir(valor, contaDestino);
		contaEnvio.imprimirExtrato();
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Nome: ");
		String nome = scan.next();
		Cliente c = new Cliente();
		c.setNome(nome);
		
		System.out.println("=== Corrente ou Poupança ===");
		System.out.print("Conta: ");
		String conta = scan.next();
		
		System.out.println("=== Saque, Depósito ou Transferência ===");
		System.out.print("Operação: ");
		String operacao = scan.next();
		
		System.out.print("Valor R$");
		double valor = scan.nextInt();
		Conta cc = new ContaCorrente(c);
		Conta poupanca = new ContaCorrente(c);
		if(operacao.compareTo("Transferência") == 0) {
			if(conta.compareTo("Corrente") == 0)
				tratarTransferencia(cc, poupanca, valor);
			else 
				tratarTransferencia(poupanca, cc, valor);
			
		} else if(operacao.compareTo("Transferência") != 0 && conta.compareTo("Poupança") == 0) {
			//metódo que trata da operação e do valor para determinada conta
			tratarOperacoes(poupanca, operacao, valor);
			
		}else if(operacao.compareTo("Transferência") != 0 && conta.compareTo("Corrente") == 0) {
			tratarOperacoes(cc, operacao, valor);
			
		} else {
			System.out.println("Conta e/ou Operação inválida! Tente novamente.");
			String[] m = new String[] {}; 
			Main.main(m);
		}
		
	}

}
