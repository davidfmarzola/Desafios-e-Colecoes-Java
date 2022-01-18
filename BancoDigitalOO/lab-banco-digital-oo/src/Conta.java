import java.time.*;
import java.util.*;
public abstract class Conta implements IConta {
	
	private Data data = new Data();
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected String dataMov;
	protected double valor;
	protected String operacao;
	protected List<String> extrato;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.dataMov = data.getDataAtualFormatada();//herdando variável da classe Data
		this.extrato = new LinkedList<>();//inserção e remoção com maior frequencia
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
		setValor(-valor);
		setOperacao("saque");
		extrato.add(dataMov + "   " +getOperacao()+ "     " + getValor());
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		setValor(valor);
		setOperacao("deposito");
		extrato.add(dataMov + "  " +getOperacao()+ "    " + getValor());
		
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
		setValor(-valor);
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public String getDataAtual() {
		return dataMov;
	}
	
	
	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}
	

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		int i = 0;
		for(String expressao : extrato) {
			System.out.println("DATA MOV    OPERACAO    VALOR");
			System.out.println(extrato.get(i++));
		}
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}






















