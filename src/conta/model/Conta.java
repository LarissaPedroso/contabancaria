package conta.model;

public abstract class Conta {
	
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;
	
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public String getNomeTitular() {
		return titular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.titular = nomeTitular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public boolean sacar(float valor) {
		if(this.getSaldo() < valor) {
			System.out.println("\nSaldo Insuficiente!");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	public void depositar(float valor) {
		this.setSaldo(this.getSaldo() + valor);
	}
	
	
	public void visualizar() {
		String tipo = "";
		
		switch(this.tipo) {
		case 1: 
			tipo = "Conta Corrente";
		break;
		case 2:
			tipo = "Conta Poupança";
		break;
		}
		System.out.println("\n***********************************");
		System.out.println("       Informações da Conta       ");
		System.out.println("***********************************\n");
		System.out.println("Nome do Titular: " + titular);
		System.out.println("Agencia: " + agencia);
		System.out.println("Número: " + numero);
		System.out.println("Tipo: " + tipo);
		System.out.println("Saldo: " + saldo);
	}
}
