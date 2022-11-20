import java.util.Scanner;

public class Telefonia {

	private int numPrePago;
	private int numPospago;

	public Telefonia() {
	}

	public void cadastrarAssinante() {

	}

	public void listarAssinante() {

	}

	public void fazerChamada() {

	}

	public void fazerRecarga() {

	}

	/*
	 * private PrePago localizarPrePago(long cpf) {
	 * }
	 * 
	 * 
	 * private PosPago localizarPosPago(long cpf) {
	 * }
	 */
	public void imprimirFaturas() {

	}

	public static void main(String [] args) {
		int op = 0;
		do {
			Scanner s = new Scanner(System.in);
			System.out.println("Bem-vindo! O que você deseja?\n");
			System.out.println("1- Cadastrar assinante\n2- Listar assinante\n3- Fazer chamada");
			System.out.println("4- Fazer recarga\n5- Imprimir faturas\n6- Sair\n");
			System.out.println("Digite uma opção: ");
			op = s.nextInt();
			switch (op) {
			case 1:
				System.out.println("Teste\n");
				break;
			case 2:
				System.out.println("Teste\n");
				break;
			case 3:
				System.out.println("Teste\n");
				break;
			case 4:
				System.out.println("Teste\n");
				break;
			case 5:
				System.out.println("Teste\n");
				break;
			case 6:
				System.out.println("Obrigado por utilizar nosso serviço!\n");
				break;
			default:
				System.out.println("Comando não definido no menu!\n");
				break;
			}
		} while (op != 6);
	}
}
