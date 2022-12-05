import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Telefonia {
	// Aqui utilizamos do try/catch para tratar erros grotescos

	// Atributos privatados telefonia
	private PrePago[] prePagos;
	private Integer numPrePago;
	private PosPago[] posPagos;
	private Integer numPosPago;

	// Construtor telefonia
	public Telefonia() {

		this.prePagos = new PrePago[350];
		this.posPagos = new PosPago[350];
	}

	// Formatacao da data para atender normas ABNT/Instanciarção de scanner
	static SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
	static Scanner sc = new Scanner(System.in);

	// Metodo Cadastrar assinante
	// Pergunta a quantidade de assinantes totais para cadastrar
	// Caso o usuário ultrapasse o número de assinantes máximo, o programa exibe uma mensagem de erro
	
	// Quando o vetor de numeros de assinantes estiver preenchido com um valor correto, o programa
	// pergunta o tipo de assinante (prepago/pospago) e coleta seus dados
	// (nome,cpf,numero).
	// Em seguida instancia os dados recebidos em seu respectivo vetor.
	public void cadastrarAssinante() throws ParseException {
		
		try {
			if (this.numPosPago == null || this.numPrePago == null) {
				System.out.println("Digite a quantidade de assinantes (Pré-Pago/Pós-Pago) que deseja cadastrar: ");
				System.out.print("Pré-Pago: ");
				this.numPrePago = sc.nextInt();
				System.out.print("Pós-Pago: ");
				this.numPosPago = sc.nextInt();

				if (this.numPrePago > this.prePagos.length || this.numPrePago <= 0) {
					System.out.println("Limite de cadastros Pré-Pagos é de 1 a "+ this.prePagos.length +" tente novamente!!!\n ");
					this.numPrePago= null;
				}

				if (this.numPosPago > this.posPagos.length || this.numPosPago <= 0) {
					System.out.println("Limite de cadastros Pós-Pagos é de 1 a "+ this.posPagos.length +" tente novamente!!!\n ");
					this.numPrePago= null;
				}
				cadastrarAssinante();
			} else if (this.numPosPago != null && this.numPrePago != null) {
				int option = 0;
				System.out.println("\nDigite o tipo de assinante:\n1- Prepago\n2- Pospago");
				System.out.print("Digite uma opção: ");
				option = sc.nextInt();
				if (option == 1) {
					if (numPrePago > 0) {
						System.out.print("\nDigite o Nome do Assinante: ");
						sc.nextLine();
						String nm = sc.nextLine();
						System.out.print("Digite o CPF do Assinante: ");
						long c = sc.nextLong();
						System.out.print("Digite o Número de Celular do Assinante: ");
						int num = sc.nextInt();
						this.prePagos[numPrePago - 1] = new PrePago(c, nm, num);
						this.numPrePago = this.numPrePago - 1;
						System.out.println("\nNovo Assinante Pré-Pago cadastrado!!!\n");
					} else {
						System.out.println("Não é possível realizar novo cadastro!!\n");
					}

				}
				if (option == 2) {
					if (this.numPosPago > 0) {
						System.out.print("\nDigite o Nome do Assinante: ");
						sc.nextLine();
						String nm = sc.nextLine();
						System.out.print("Digite o CPF do Assinante: ");
						long c = sc.nextLong();
						System.out.print("Digite o Número de Celular do Assinante: ");
						int num = sc.nextInt();
						System.out.print("Digite o valor da Assinatura: ");
						float vlAssinatura = sc.nextInt();
						this.posPagos[numPosPago - 1] = new PosPago(c, nm, num, vlAssinatura);
						this.numPosPago = this.numPosPago - 1;
						System.out.println("Novo Assinante Pós-Pago cadastrado!!!\n");
						System.out.println();
					} else {
						System.out.println("Não é possível realizar novo cadastro!!\n");
					}
				}
			}
		} catch (java.lang.NullPointerException ex) {
			System.out.println("insira um dado válido e tente novamente!!!\n");
			
		} catch (java.util.InputMismatchException ex) {
			//this.numPosPago = null;
			//this.numPrePago= null;
			System.out.println("insira um dado válido e tente novamente!!!\n");
			
		}
	}

	// Metodo ListarAssinante
	// Percorre os vetores dos assinantes pre-pago/pos-pago
	// e printa os dados diferentes de nulo.
	public void listarAssinante() {

		System.out.println("\nDados dos Assinantes Pré-Pagos: ");
		int cont = 0;

		for (int i = 0; i < prePagos.length; i++) {
			if (this.prePagos[i] != null) {
				System.out.println(this.prePagos[i]);
			} else {
				cont += 1;
			}
		}
		if (cont == this.prePagos.length) {
			System.out.println("Ainda não existem dados de usuários Pré-Pagos Cadastrados!!!\n");
		}
		System.out.println("\nDados dos Assinantes Pós-Pagos:");
		cont = 0;
		for (int j = 0; j < posPagos.length; j++) {
			if (this.posPagos[j] != null) {
				System.out.println(this.posPagos[j]);
			} else {
				cont += 1;
			}
		}
		if (cont == this.posPagos.length) {
			System.out.println("Ainda não existem dados de usuários Pós-Pagos Cadastrados!!!\n");
			System.out.println();
		}
	}

	// Metodo LocalizarPrepago
	// Recebe CPF, percorre o vetor prePago
	// Descarta posições nulas no vetor
	// compara CPF recebido é o mesmo CPF dentro do vetor
	// retorna dados do Assinante prepago com o cpf digitado
	private PrePago localizarPrePago(long cpf) {
		for (int i = 0; i < this.prePagos.length; i++) {
			if (prePagos[i] != null) {
				if (this.prePagos[i].getCpf() == cpf) {
					return prePagos[i];
				}
			}
		}
		return null;
	}

	// Metodo LocalizarPosPago
	// Recebe CPF, percorre o vetor posPagos
	// Descarta posições nulas no vetor
	// compara CPF recebido é o mesmo CPF dentro do vetor
	// retorna dados do Assinante prepago com o cpf digitado
	private PosPago localizarPosPago(long cpf) {

		for (int i = 0; i < this.posPagos.length; i++) {
			if (posPagos[i] != null) {
				if (this.posPagos[i].getCpf() == cpf) {
					return posPagos[i];
				}
			}
		}
		return null;
	}
	// Metodo fazerChamada
	// pergunta o cpf e o tipo de assinatura do cliente

	public void fazerChamada() throws ParseException {
		// ParseException serve para não ocorrer erros na formatacao da data

		System.out.print("Digite o CPF para fazer chamada: ");
		long id = sc.nextLong();
		System.out.print("\nInforme o tipo da assinatura:\n1-Pré-pago\n2-Pós-pago\nDigite uma opção: ");
		int escolha = sc.nextInt();
		// Caso seja prepago, invoca o método LocalizarPrePago recebendo o CPF de
		// atributo
		// Recebe a duracao e data da chamada
		// formata a data
		// Joga a data formatada para o Gregorian Calendar
		// Variavel "prep" do tipo prepago recebe o valor do localizarPrepago (dados do
		// assinante com o cpf digitado)
		// Depois invoca o metodo fazerChamada com os dados da variavel "prep" (esse
		// recebe a data e minutos da chamada)
		if (escolha == 1) {
			localizarPrePago(id);
			GregorianCalendar gc = new GregorianCalendar();
			System.out.print("Digite a Duração da Chamada (minutos): ");
			int min = sc.nextInt();
			System.out.print("Insira a Data da Chamada (DD/MM/AAAA): ");
			Date data = formatador.parse(sc.next());
			gc.setTime(data);
			PrePago prep = localizarPrePago(id);
			prep.fazerChamada(gc, min);
			// Caso seja pospago, procede com o mesmo caminho do prepago, utilizando os
			// dados do pospago.
		} else if (escolha == 2) {
			localizarPosPago(id);
			GregorianCalendar gc = new GregorianCalendar();
			System.out.print("Digite a Duração da Chamada (minutos): ");
			int min = sc.nextInt();
			System.out.print("Insira a Data da Chamada (DD/MM/AAAA): ");
			Date data = formatador.parse(sc.next());
			gc.setTime(data);
			PosPago posp = localizarPosPago(id);
			posp.fazerChamada(gc, min);
		}
	}

	// Metodo fazerRecarga
	// Recebe CPF, localiza o assinante com o CPF correspondente
	// Descarta posições nulas no vetor
	// Instancia um GregorianCalendar
	// Usuario digita o valor e data da recarga
	// Data é formatada e inserida no GregorianCalendar
	// Variavel "prep" do tipo prepago recebe o valor do localizarPrepago (dados do
	// assinante com o cpf digitado)
	// Depois invoca o metodo recarregar com os dados da variavel "prep"
	public void fazerRecarga() throws ParseException {
		try {
			System.out.print("Digite o CPF para fazer Recarga: ");
			long id = sc.nextLong();
			if (localizarPrePago(id) != null) {
				GregorianCalendar gt = new GregorianCalendar();
				System.out.print("Insira o Valor da Recarga: ");
				float rc = sc.nextFloat();
				System.out.print("Insira a Data da Recarga (DD/MM/AAAA): ");
				Date data = formatador.parse(sc.next());
				gt.setTime(data);
				PrePago prep = localizarPrePago(id);
				prep.recarregar(gt, rc);
			} else {
				System.out.println("Seu CPF não localizado no sistema... Tente novamente!");
			}
		} catch (java.lang.NullPointerException ex) {
			System.out.println("Nenhum Assinante cadastrado... Tente novamente!");
		} catch (java.text.ParseException ex) {
			System.out.println("Insira um dado válido e tente novamente!\n");
			fazerRecarga();
		}
	}

	// Metodo ImprimirFatura
	// Usuario digita o mes que deseja verificar as faturas
	// Programa exibe dados completos dos assinantes prePago/posPago e os valores totais de chamadas,
	// recargas e assinaturas
	// Caso não tenha nenhum assinante, programa exibe uma mensagem de erro.
	public void imprimirFaturas() throws ParseException {
		try {
			System.out.print("Digite um mês para verificação do histórico (1 a 12):  ");
			int m = sc.nextInt();
			int cont = 0;
			for (int i = 0; i < this.prePagos.length; i++) {
				if (this.prePagos[i] != null) {
					System.out.println("\nPRÉ-PAGO: \n" + this.prePagos[i]);
					this.prePagos[i].imprimirFatura(m - 1);
				} else {
					cont += 1;
				}
			}
			if (cont == this.prePagos.length) {
				System.out.println("Não existem dados de usuários Pré-Pagos para o mês selecionado!!!\n");
			}
			cont = 0;
			for (int i = 0; i < this.posPagos.length; i++) {
				if (this.posPagos[i] != null) {
					System.out.println("\nPÓS-PAGO: \n" + this.posPagos[i]);
					this.posPagos[i].imprimirFatura(m - 1);
				} else {
					cont += 1;
				}
			}
			if (cont == this.posPagos.length) {
				System.out.println("Não existem dados de usuários Pós-Pagos para o mês selecionado!!!\n");
			}
		} catch (java.lang.NullPointerException ex) {
			System.out.println("insira um dado válido e tente novamente!!!");
		}
	}


	public static void main(String[] args) throws ParseException {

		
		Scanner sc = new Scanner(System.in);
		Telefonia tel = new Telefonia();

		try {
			System.out.println("Digite a quantidade de assinantes (Pré-Pago/Pós-Pago) que deseja cadastrar: ");
			System.out.print("Pré-Pago: ");
			tel.numPrePago = sc.nextInt();
			if (tel.numPrePago > 30 || tel.numPrePago <= 0) {
				System.out.println("Limite de cadastros é de 0 a 30 , tente novamente!!!\n ");
				Telefonia.main(args);
			}
			System.out.print("Pós-Pago: ");
			tel.numPosPago = sc.nextInt();
			if (tel.numPosPago > 30 || tel.numPosPago < 0) {
				System.out.println("Limite de cadastros é de 0 a 30 , tente novamente!!!\n ");
				Telefonia.main(args);
			}
		} catch (java.util.InputMismatchException ex) {
			System.out.println("Insira um dado válido e tente novamente!!!\n");
			Telefonia.main(args);
			
		} catch (java.lang.ArrayIndexOutOfBoundsException el) {
			System.out.println("Insira um dado válido e tente novamente!!!\n");
			Telefonia.main(args);
		} 
		
		int op = 0;
		do {
			try {
				// menu de interação que invoca os métodos.
				System.out.println("\nBem-vindo! O que você deseja?\n");
				System.out.println("1- Cadastrar assinante\n2- Listar assinante\n3- Fazer chamada");
				System.out.println("4- Fazer recarga\n5- Imprimir faturas\n6- Sair\n");
				System.out.print("Digite uma opção: ");
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
					System.out.println("Desenvolvido por \n");
					System.out.println("André Cardoso Bueno\n");
					System.out.println("Daniel de Oliveira Silva\n");
					System.out.println("Danillo Marcos Alves\n");
					System.out.println("Tarcísio Leite Teissiere");
					break;
				default:
					System.out.println("Comando não definido no menu! Por favor, confira novamente...\n");
					break;
				}
			} catch (java.util.InputMismatchException ex) {
				System.out.println("Erro. Programa reiniciando...");
				main(null);
				
			} catch (java.lang.ArrayIndexOutOfBoundsException el) {
				System.out.println("Insira um dado válido e tente novamente!!!");
				
			}

		} while (op != 6);
		sc.close();

	}
}

//Nesse trecho de código exibimos a fatura filtrada pelo tipo de assinatura e
	// CPF de usuário(mas optamos por não utilizar).
	/* a
	 * Scanner sc = new Scanner(System.in); System.out.
	 * print("Digite o CPF do assinante que deseja visualizar a fatura:  "); long id
	 * = sc.nextLong();
	 * 
	 * if (localizarPrePago(id)!= null) { PrePago prep = localizarPrePago(id);
	 * System.out.print("Digite um mês para verificação do histórico:  "); int m =
	 * sc.nextInt(); System.out.println(prep); prep.imprimirFatura(m-1); } else
	 * if(localizarPosPago(id)!=null) { PosPago posp = localizarPosPago(id);
	 * System.out.print("Digite um mês para verificação do histórico:  "); int m =
	 * sc.nextInt(); posp.imprimirFatura(m-1); } else {
	 * System.out.println("CPF não encontrado no sistema!!!\n"); } /*System.out.
	 * println("Informe o tipo da assinatura:\n1-Pré-pago\n2-Pós-pago\nSua escolha: "
	 * ); int escolha = sc.nextInt();
	 * 
	 * if (escolha == 1) { localizarPrePago(id); PrePago prep =
	 * localizarPrePago(id);	
	 * System.out.print("Digite um mês para verificação do histórico:  "); int m =
	 * sc.nextInt(); System.out.println(prep); prep.imprimirFatura(m-1);
	 * 
	 * }else if (escolha == 2) { localizarPosPago(id); PosPago posp =
	 * localizarPosPago(id);
	 * System.out.print("Digite um mês para verificação do histórico:  "); int m =
	 * sc.nextInt(); posp.imprimirFatura(m-1); }
	 */