package conta.model;

public class ContaCorrente extends Conta{
	private float limite;

	public ContaCorrente(String nomeTitular, int agencia, int numero, int tipo, float saldo, float limite) {
		super(nomeTitular, agencia, numero, tipo, saldo);
		this.limite = limite;
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	@Override
	public boolean sacar(float valor) {
		if((this.getSaldo() + this.getLimite()) < valor) {
			System.out.println("\nSaldo Insuficiente!");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Limite: " + limite);
	}
}
