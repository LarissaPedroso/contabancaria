package conta.model;

public class Conta {
	
	private String nomeTitular;
	private int agencia;
	private int numero;
	private String tipo;
	private float saldo;
	
	public Conta(String nomeTitular, int agencia, int numero, String tipo, float saldo) {
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
}
