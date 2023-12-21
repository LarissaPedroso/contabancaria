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
		
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Cedrico Diggory", 1000f, 100.0f);
		contas.cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 456, 1, "Hermione Granger", 20000f, 100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 789, 2, "Albus Percival Wulfric Brian Dumbledore", 50000.0f, 21);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 789, 2, "Newt Scamander", 2000.0f, 24);
		contas.cadastrar(cp2);
		
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
			System.out.print(Cores.TEXT_WHITE_BOLD + "Entre com a opção desejada: " + Cores.TEXT_RESET);
			
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
				System.out.print(Cores.TEXT_GREEN_BOLD + "\nCriar Conta\n\n" + Cores.TEXT_RESET);
				System.out.print("Digite o Número da Agência: ");
				agencia = leia.nextInt();
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
				System.out.print(Cores.TEXT_GREEN_BOLD + "\nListar todas as Contas\n\n" + Cores.TEXT_RESET);
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.print(Cores.TEXT_GREEN_BOLD + "\nConsultar dados da Conta - por número\n\n" + Cores.TEXT_RESET);
				System.out.print("Digite o número da conta: ");
				numero = leia.nextInt();
				contas.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.print(Cores.TEXT_GREEN_BOLD + "\nAtualizar dados da Conta\n\n" + Cores.TEXT_RESET);
				
				System.out.print("Digite o número da conta: ");
				numero = leia.nextInt();
				
				var buscaConta = contas.buscarNaCollection(numero);
				if(buscaConta != null) {
					tipo = buscaConta.getTipo();
					
					System.out.print("Digite o Número da Agência: ");
					agencia = leia.nextInt();
					
					System.out.print("Digite o Nome do Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
				
					System.out.print("Digite o Saldo da Conta R$");
					saldo = leia.nextFloat();
					
					switch(tipo) {
						case 1 -> {
							System.out.print("Digite o Limite de Crédito R$");
							limite = leia.nextFloat();
							contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
						}
						case 2 -> {
							System.out.print("Digite o dia do Aniversário da Conta: ");
							aniversario = leia.nextInt();
							contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
						}
						default -> {
							System.out.println("Tipo de conta inválida!");
						}
					}
				}else {
					System.out.println("A conta não foi encontrada!");
				}
				keyPress();
				break;
			case 5:
				System.out.print(Cores.TEXT_GREEN_BOLD + "\nApagar a Conta\n\n" + Cores.TEXT_RESET);
				System.out.print("Digite o número da conta: ");
				numero = leia.nextInt();
				contas.deletar(numero);
				keyPress();
				break;
			case 6:
				System.out.print(Cores.TEXT_GREEN_BOLD + "\nSaque\n\n" + Cores.TEXT_RESET);
				System.out.print("Digite o número da conta: ");
				numero = leia.nextInt();
				do {
					System.out.print("Digite o valor do Saque R$");
					valor = leia.nextFloat();
				}while(valor <= 0);
				contas.sacar(numero, valor);
				keyPress();
				break;
			case 7:
				System.out.print(Cores.TEXT_GREEN_BOLD + "\nDepósito\n\n" + Cores.TEXT_RESET);
				System.out.print("Digite o número da conta: ");
				numero = leia.nextInt();
				do {
					System.out.print("Digite o valor do depósito R$");
					valor = leia.nextFloat();
				}while(valor <= 0);
				contas.depositar(numero, valor);
				keyPress();
				break;
			case 8:
				System.out.print(Cores.TEXT_GREEN_BOLD + "\nTransferência entre Contas\n\n" + Cores.TEXT_RESET);
				System.out.print("Digite o número da conta de origem: ");
				numero = leia.nextInt();
				System.out.print("Digite o número da conta de destino: ");
				numeroDestino = leia.nextInt();
				
				do {
					System.out.print("Digite o valor da transferência R$");
					valor = leia.nextFloat();
				}while(valor <= 0);
				contas.transferir(numero, numeroDestino, valor);
				keyPress();
				break;
			default:
				System.out.print(Cores.TEXT_GREEN_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
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
