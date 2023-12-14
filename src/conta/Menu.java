package conta;

import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		//Menu
		System.out.println(Cores.TEXT_YELLOW_BOLD);
		System.out.println("***********************************");
		System.out.println("            BANCO DA GEN           ");
		System.out.println("***********************************\n");
		System.out.println("1 - Criar Conta");
		System.out.println("2 - Listar todas as Contas");
		System.out.println("3 - Buscar Conta por Número");
		System.out.println("4 - Atualizar Dados da conta");
		System.out.println("5 - Apagar Conta");
		System.out.println("6 - Sacar");
		System.out.println("7 - Depositar");
		System.out.println("8 - Transferir valores entre Contas");
		System.out.println("9 - Sair");
		System.out.println("\n***********************************");
		System.out.println(Cores.TEXT_RESET);
	}

}
