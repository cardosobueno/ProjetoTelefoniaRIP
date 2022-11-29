import java.util.Scanner;

public class Telefonia {

	private PrePago[] prePagos;
	private Integer numPrePago;
	private PosPago[] posPagos;
	private Integer numPosPago;
	
	
	public Telefonia() {
		super();
	
		this.prePagos = new PrePago[numPrePago];
		this.numPrePago = 20;
		this.posPagos = new PosPago[numPospago];
		this.numPospago = 20;
	}

	private int numPospago;
	

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
				int option = 0;
				System.out.println("Digite o tipo de assinante:\n1- Prepago\n2- Pospago");
				System.out.println("Opção selecionada: ");
				option = s.nextInt();
				if (option == 1)
				{
					System.out.println("Digite seu nome: ");
					String nm = s.next();
					System.out.println("Digite seu cpf: ");
					long c = s.nextLong();
					System.out.println("Digite seu número de celular: ");
					int num = s.nextInt();
					Assinante assi = new Assinante(c, nm, num);
					this.prePagos[-1] = new PrePago(c, nm, num);
				}
				if (option == 2)
				{
					System.out.println("Digite seu nome: ");
					String nm = s.next();
					System.out.println("Digite seu cpf: ");
					long c = s.nextLong();
					System.out.println("Digite seu número de celular: ");
					int num = s.nextInt();
					Assinante assi = new Assinante(c, nm, num);
				}
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
