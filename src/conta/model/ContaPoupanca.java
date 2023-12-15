package conta.model;

public class ContaPoupanca extends Conta{
	private int aniversario;

	public ContaPoupanca(String nomeTitular, int agencia, int numero, int tipo, float saldo, int aniversario) {
		super(nomeTitular, agencia, numero, tipo, saldo);
		this.aniversario = aniversario;
	}

	public int getAniversario() {
		return aniversario;
	}

	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Aniversário: " + aniversario);
	}
	
}
