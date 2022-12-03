import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Telefonia {

	protected PrePago[] prePagos;
	protected Integer numPrePago;
	protected PosPago[] posPagos;
	protected Integer numPosPago;
	static SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

	public Telefonia() {
		
		this.numPrePago = 25;
		this.numPosPago = 25;
		this.prePagos = new PrePago[numPrePago];
		this.posPagos = new PosPago[numPosPago];

	}

	public void cadastrarAssinante() {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		System.out.println("Digite o tipo de assinante:\n1- Prepago\n2- Pospago");
		System.out.println("Opção selecionada: ");
		option = sc.nextInt();
		if (option == 1) {
			if (this.numPrePago > 0) {
				System.out.println("Digite seu Nome: ");
				sc.nextLine();
				String nm = sc.nextLine();
				System.out.println("Digite seu CPF: ");
				long c = sc.nextLong();
				System.out.println("Digite seu número de celular: ");
				int num = sc.nextInt();
				this.prePagos[numPrePago - 1] = new PrePago(c, nm, num);
				this.numPrePago = this.numPrePago - 1;
				System.out.println("Novo Assinante Pré-Pago cadastrado!!!");
				System.out.println();
			} else {
				System.out.println("Não é possível realizar novo cadastro!!");
			}

		}
		if (option == 2) {
			if (this.numPosPago > 0) {
				System.out.println("Digite seu Nome: ");
				sc.nextLine();
				String nm = sc.nextLine();
				System.out.println("Digite seu CPF: ");
				long c = sc.nextLong();
				System.out.println("Digite seu número de celular: ");
				int num = sc.nextInt();
				System.out.println("Digite o valor da assinatura: ");
				float vlAssinatura = sc.nextInt();
				this.posPagos[numPosPago - 1] = new PosPago(c, nm, num, vlAssinatura);
				this.numPosPago = this.numPosPago - 1;
				System.out.println("Novo Assinante Pós-Pago cadastrado!!!");
				System.out.println();
			}
		}

	}

	public void listarAssinante() {
		System.out.println("Dados dos assinantes pré-pagos: ");
		for (int i = 0; i < prePagos.length; i++) {
			if (this.prePagos[i] != null) {
				System.out.println(this.prePagos[i]);
			}
		}
		System.out.println("\nDados dos assinantes pós-pago: ");
		for (int j = 0; j < posPagos.length; j++) {
			if (this.posPagos[j] != null) {
				System.out.println(this.posPagos[j]);
			}
		}
		System.out.println("\n");
	}

	public void fazerChamada() throws ParseException {
		Scanner s2 = new Scanner(System.in);
		System.out.println("Digite o seu CPF: ");
		long id = s2.nextLong();
		System.out.println("Informe o tipo da assinatura:\n1-Pré-pago\n2-Pós-pago\nSua escolha: ");
		int escolha = s2.nextInt();
		if (escolha == 1) {
			localizarPrePago(id);
			GregorianCalendar gc = new GregorianCalendar();
			System.out.println("Digite a Duração da Chamada (minutos): ");
			int min = s2.nextInt();
			System.out.print("Insira a Data da Chamada (DD/MM/AAAA): ");
			Date data = formatador.parse(s2.next());
			gc.setTime(data);
			PrePago prep = localizarPrePago(id);
			prep.fazerChamada(gc,min);
		
		

		} else if (escolha == 2) {
			localizarPosPago(id);
			GregorianCalendar gc = new GregorianCalendar();
			System.out.println("Digite a Duração da Chamada (minutos): ");
			int min = s2.nextInt();
			System.out.print("Insira a Data da Chamada (DD/MM/AAAA): ");
			Date data = formatador.parse(s2.next());
			gc.setTime(data);
			PosPago posp = localizarPosPago(id);
			posp.fazerChamada(gc,min);
			

		}

	}

	public void fazerRecarga() throws ParseException {
		try {
			Scanner s3 = new Scanner(System.in);
			System.out.println("Insira seu CPF: ");
			long id = s3.nextLong();
			if (localizarPrePago(id) != null) {

				GregorianCalendar gt = new GregorianCalendar();
				System.out.println("Insira o Valor da Recarga: ");
				float rc = s3.nextFloat();
				System.out.print("Insira a Data da Recarga (DD/MM/AAAA): ");
				Date data = formatador.parse(s3.next());
				gt.setTime(data);
				PrePago prep = localizarPrePago(id);
				prep.recarregar(gt, rc);
				System.out.println("Recarga realizada com sucesso!!!");

			} else {
				System.out.println("Seu CPF não localizado no sistema... Tente novamente!");
			}
		} catch (java.lang.NullPointerException ex) {
			System.out.println("Nenhum Assinante cadastrado... Tente novamente!");
		}

	}

	private PrePago localizarPrePago(long cpf) {
		for (int i = 0; i < this.prePagos.length; i++) {
			if (this.prePagos[numPrePago].getCpf() == cpf) {
				if (prePagos[i] != null) {

				}
			} else {
				System.out.println("O CPF cadastrado não pertence a este tipo de assinatura.");
				return null;
			}
		}
		return prePagos[numPrePago];
	}

	private PosPago localizarPosPago(long cpf) {

		for (int i = 0; i < this.posPagos.length; i++) {
			if (this.posPagos[numPosPago].getCpf() == cpf) {
				if (posPagos[i] != null) {

				}
			} else {
				System.out.println("O CPF cadastrado não pertence a este tipo de assinatura.");
				return null;
			}
		}
		return posPagos[numPosPago];
	}

	public void imprimirFaturas() throws ParseException {
		Scanner sc = new Scanner(System.in);
		GregorianCalendar c = new GregorianCalendar();
		System.out.print("Digite um mês para verificação do histórico:  ");
		int m = sc.nextInt();
		PrePago pr = new PrePago();
		pr.imprimirFatura(m);
		PosPago pp = new PosPago();
		pp.imprimirFatura(m);
	}

	public static void main(String[] args) throws ParseException {
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
				tel.fazerRecarga();
				break;
			case 5:
				tel.imprimirFaturas();
				break;
			case 6:
				System.out.println("Obrigado por utilizar nosso serviço!\n");
				break;
			default:
				System.out.println("Comando não definido no menu! Por favor, confira novamente...\n");
				break;
			}
		} while (op != 6);

	}
}