package conta;

import java.util.Scanner;

import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		int opcao;
		
		
		//Teste Classe Conta
		Conta c1 = new Conta("Maria Jessica", 456, 2, 2, 3000.0f);
		c1.sacar(300.0f);
		c1.visualizar();
		
		//Teste Classe Conta Corrente
		ContaCorrente cc1 =  new ContaCorrente("Ana Paula", 963, 2, 1, 8000.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(20000.0f);
		
		//Teste da Classe Conta Poupança
		ContaPoupanca cp1 = new ContaPoupanca("Paulo", 123, 1, 2, 1000.f, 3);
		cc1.depositar(400.0f);
		cp1.visualizar();
		
		//Menu
		System.out.println(Cores.TEXT_YELLOW_BOLD);
		System.out.println("***********************************");
		System.out.println("            GRINGOTES            ");
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
		
		Scanner leia = new Scanner(System.in);
		
		
		do {
			System.out.print("Entre com a opção: ");
			opcao = leia.nextInt();
			leia.nextLine();
			
			switch(opcao) {
			case 1:
				System.out.println("Criar Conta\n");
				break;
			case 2:
				System.out.println("Listar todas as Contas\n");
				break;
			case 3:
				System.out.println("Buscar Conta por Número\n");
				break;
			case 4:
				System.out.println("Atualizar dados da conta\n");
				break;
			case 5:
				System.out.println("Apagar Conta\n");
				break;
			case 6:
				System.out.println("Saque\n");
				break;
			case 7:
				System.out.println("Depósito\n");
				break;
			case 8:
				System.out.println("Transferência entre contas\n");
				break;
			default:
				System.out.println("Opção Inválida!\n");
				break;
			}	
		}while(opcao != 9);
		System.out.println("Volte Sempre!\n");
		System.exit(0);
		leia.close();
	}

}
