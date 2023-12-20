package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {
	public static Scanner leia = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ContaController contas = new ContaController();
		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;
		
		//Teste da Classe Conta Corrente
		/*
		 * ContaCorrente cc1 = new ContaCorrente(2, 123, 1, "Mariana", 15000.0f,
		 * 1000.0f); cc1.visualizar(); cc1.sacar(12000.0f); cc1.visualizar();
		 * cc1.depositar(5000.0f); cc1.visualizar();
		 * 
		 * //Teste da Classe Conta Poupança ContaPoupanca cp1 = new ContaPoupanca(3,
		 * 123, 2, "Victor", 10000.0f, 15); cp1.visualizar(); cp1.sacar(1000.0f);
		 * cp1.visualizar(); cp1.depositar(5000.0f); cp1.visualizar();
		 */
		
		
		//Menu
		while(true) {
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
			System.out.print(Cores.TEXT_WHITE_BOLD + "Entre com a opçcao desejada: " + Cores.TEXT_RESET);
			
			
			ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Cedrico Diggory", 1000f, 100.0f);
			//contas.cadastrar(cc1);
			
			ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 456, 1, "Hermione Granger", 20000f, 100.0f);
			//contas.cadastrar(cc2);
			
			ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 789, 2, "Albus Percival Wulfric Brian Dumbledore", 50000.0f, 21);
			//contas.cadastrar(cp1);
			
			ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 789, 2, "Newt Scamander", 2000.0f, 24);
			//contas.cadastrar(cp2);
			
			try {
				opcao = leia.nextInt();
			
			}catch(InputMismatchException e) { 
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}
			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "Volte Sempre!" + Cores.TEXT_RESET);
				sobre();
				leia.close();
				System.exit(0);
			}
				
			switch (opcao) {
			case 1:
				System.out.print("\nCriar Conta\n\n");
				System.out.print("Digite o Número da Agência: ");
				agencia = leia.nextInt();
				//leia.next();
				System.out.print("Digite o Nome do Titular: \n");
				leia.skip("\\R?");
				titular = leia.nextLine();
				
				do {
					System.out.print("Digite o Tipo da Conta (1 - Conta Corrente | 2 - Conta Poupança): ");
					tipo = leia.nextInt();
				}while(tipo < 1 && tipo > 2);
				
				System.out.print("Digite o saldo da conta R$");
				saldo = leia.nextFloat();
				
				switch(opcao) {
					case 1 -> {
						System.out.print("Digite o limite de crédito R$");
						limite = leia.nextFloat();
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					} 
				case 2 ->{
					System.out.print("Digite o dia do Aniversário da Conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
				}
				keyPress();
				break;
			case 2:
				System.out.print("Listar todas as Contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.print("Consultar dados da Conta - por número\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				contas.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.print("Atualizar dados da Conta\n\n");
				keyPress();
				break;
			case 5:
				System.out.print("Apagar a Conta\n\n");
				keyPress();
				break;
			case 6:
				System.out.print("Saque\n\n");
				keyPress();
				break;
			case 7:
				System.out.print("Depósito\n\n");
				keyPress();
				break;
			case 8:
				System.out.print("Transferência entre Contas\n\n");
				keyPress();
				break;
			default:
				System.out.print("\nOpção Inválida!\n");
				break;
			}
		}
	}
	public static void sobre() {
		System.out.println("\n***********************************");
		System.out.println("Projeto Desenvolvido por: Larissa Pedroso");
		System.out.println("Email: larissapedroso3@outlook.com");
		System.out.println("Github: https://github.com/LarissaPedroso");
		System.out.println("\n***********************************");
	}

	private static void keyPress() {
		try {
			System.out.println("\n\nPressione Enter para Continuar...");
			System.in.read();
		}catch(IOException e) {
			System.out.println("Você pressiounou uma tecla diferente de enter!");
		}
		
	}

}
