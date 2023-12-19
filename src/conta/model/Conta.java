package conta.model;

public abstract class Conta {
	
	private String nomeTitular;
	private int agencia;
	private int numero;
	private int tipo;
	private float saldo;
	
	public Conta(String nomeTitular, int agencia, int numero, int tipo, float saldo) {
		this.nomeTitular = nomeTitular;
		this.agencia = agencia;
		this.numero = numero;
		this.tipo = tipo;
		this.saldo = saldo;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
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
		System.out.println("Nome do Titular: " + nomeTitular);
		System.out.println("Agencia: " + agencia);
		System.out.println("Número: " + numero);
		System.out.println("Tipo: " + tipo);
		System.out.println("Saldo: " + saldo);
	}
}
