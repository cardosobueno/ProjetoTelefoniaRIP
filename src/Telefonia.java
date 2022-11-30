import java.util.GregorianCalendar;
import java.util.Scanner;

public class Telefonia {

	protected PrePago[] prePagos;
	protected Integer numPrePago;
	protected PosPago[] posPagos;
	protected Integer numPosPago;
	
	
	public Telefonia() {
		super();
		this.numPrePago = 1;
		this.numPosPago = 1;
		this.prePagos = new PrePago[numPrePago];
		this.posPagos = new PosPago[numPosPago];
		
	}

	public void cadastrarAssinante() 
	{
		
		Scanner sc = new Scanner(System.in);
		int option = 0;
		System.out.println("Digite o tipo de assinante:\n1- Prepago\n2- Pospago");
		System.out.println("Opção selecionada: ");
		option = sc.nextInt();
		if (option == 1)
		{
			if (this.numPrePago > 0) {
				System.out.println("Digite seu nome: ");
				String nm = sc.next();
				System.out.println("Digite seu cpf: ");
				long c = sc.nextLong();
				System.out.println("Digite seu número de celular: ");
				int num = sc.nextInt();
				this.prePagos[numPrePago-1] = new PrePago (c,nm,num);
				this.numPrePago = this.numPrePago -1;
				System.out.println("Novo Assinante Pré-Pago cadastrado!!!");
				System.out.println();
			}
			else {
				System.out.println("Não é possível realizar novo cadastro!!");
			}
			
		}
		if (option == 2)
		{
			if (this.numPosPago > 0) {
				System.out.println("Digite seu nome: ");
				String nm = sc.next();
				System.out.println("Digite seu cpf: ");
				long c = sc.nextLong();
				System.out.println("Digite seu número de celular: ");
				int num = sc.nextInt();
				System.out.println("Digite o valor da assinatura: ");
				float vlAssinatura = sc.nextInt();
				this.posPagos[numPosPago-1] = new PosPago (c,nm,num,vlAssinatura);
				this.numPosPago = this.numPosPago -1;
				System.out.println("Novo Assinante Pós-Pago cadastrado!!!");
				System.out.println();
			}
			else {
				System.out.println("Não é possível realizar novo cadastro!!");
			}

		}
		

	}

	public void listarAssinante() {
		System.out.println("Dados dos assinantes pré-pagos: ");
		for(int i = 0; i < prePagos.length; i ++) 
		{	
			if (this.prePagos[i] != null)
			{
				System.out.println(this.prePagos[i]);
			}
		}
		System.out.println("\nDados dos assinantes pós-pago: ");
		for(int j = 0; j < posPagos.length; j ++) 
		{	
			if (this.posPagos[j] != null)
			{
				System.out.println(this.posPagos[j]);
			}			
		}
		System.out.println("\n");
	}

	public void fazerChamada() {
		Scanner s2 = new Scanner(System.in);
		System.out.println("Digite o seu CPF: ");
		long newCp = s2.nextLong();
		System.out.println("Informe o tipo da assinatura:\n1-Pré-pago\n2-Pós-pago\nSua escolha: ");
		int escolha = s2.nextInt();
		if (escolha == 1) {
			for (int i = 0; i < this.numPosPago; i ++)
			{
				if (this.prePagos[i].getCpf() == newCp)
				{
				System.out.println(prePagos[i].getCpf() + " é um assinante pré-pago.");
				//this.prePagos = new PrePago[numPrePago];
				}
			}
		}
		else if (escolha == 2)
		{
			for (int i = 0; i < this.numPosPago; i ++)
			{
				if (this.posPagos[i].getCpf() == newCp)
				{
				System.out.println(posPagos[i].getCpf() + " é umassinante pós-pago.");
				//this.prePagos = new PrePago[numPrePago];
				}
				else 
				{
					System.out.println("O CPF cadastrado não pertence a este tipo de assinatura.");
				}
			}
		}
		
		//PrePago prep = new PrePago();
		//prep.fazerChamada(new GregorianCalendar(2020,07,05),35);
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
		Telefonia tel = new Telefonia();
		int op = 0;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Bem-vindo! O que você deseja?\n");
			System.out.println("1- Cadastrar assinante\n2- Listar assinante\n3- Fazer chamada");
			System.out.println("4- Fazer recarga\n5- Imprimir faturas\n6- Sair\n");
			System.out.println("Digite uma opção: ");
			op = sc.nextInt();
			switch (op) {
			case 1:
				tel.cadastrarAssinante();
				break;
			case 2:
				tel.listarAssinante();
				break;
			case 3:
				tel.fazerChamada();
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
