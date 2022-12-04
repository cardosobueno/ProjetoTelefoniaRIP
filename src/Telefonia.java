import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Telefonia {

	//Aqui utilizamos do try/catch para tratar erros grotescos
	
	//Atributos privatados telefonia
	private PrePago[] prePagos;
	private Integer numPrePago;
	private PosPago[] posPagos;
	private Integer numPosPago;
	//Formatacao da data para atender normas ABNT
	static SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

	//Construtor telefonia
	public Telefonia() 
	{
		this.numPrePago = 25;
		this.numPosPago = 25;
		this.prePagos = new PrePago[numPrePago];
		this.posPagos = new PosPago[numPosPago];
	}

	//Metodo Cadastrar assinante
	//Pergunta o tipo de assinante (prepago/pospago) e coleta seus dados (nome,cpf,numero).
	//Em seguida instancia os dados recebidos em seu respectivo vetor.
	public void cadastrarAssinante() 
	{
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

	//Metodo ListarAssinante
	//Percorre os vetores dos assinantes pre-pago/pos-pago
	//e printa os dados diferentes de nulo.
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
	
	//Metodo LocalizarPrepago
	//Recebe CPF, percorre o vetor prePago
	//Descarta posições nulas no vetor
	//compara CPF recebido é o mesmo CPF dentro do vetor
	//retorna dados do Assinante prepago com o cpf digitado
	private PrePago localizarPrePago(long cpf) {
		for (int i = 0; i < this.prePagos.length; i++) 
		{
			if (prePagos[i] != null)  
			{
				if(this.prePagos[i].getCpf() == cpf) 
				{
					return prePagos[i];
				}
			}
		}
		return null;
	}
	//Metodo LocalizarPosPago
	//Recebe CPF, percorre o vetor posPagos
	//Descarta posições nulas no vetor
	//compara CPF recebido é o mesmo CPF dentro do vetor
	//retorna dados do Assinante prepago com o cpf digitado
	private PosPago localizarPosPago(long cpf) {

		for (int i = 0; i < this.posPagos.length; i++) 
		{
			if (posPagos[i] != null)  
			{
				if(this.posPagos[i].getCpf() == cpf) 
				{
					return posPagos[i];
				}
			}
		}
		return null;
	}
	
	//Metodo fazerChamada
	//pergunta o cpf e o tipo de assinatura do cliente
	
	public void fazerChamada() throws ParseException {
			//ParseException serve para não ocorrer erros na formatacao da data
		try {
			Scanner s2 = new Scanner(System.in);
			System.out.println("Digite o seu CPF: ");
			long id = s2.nextLong();
			System.out.println("Informe o tipo da assinatura:\n1-Pré-pago\n2-Pós-pago\nSua escolha: ");
			int escolha = s2.nextInt();
			
			//Caso seja prepago, invoca o método LocalizarPrePago recebendo o CPF de atributo
			//Recebe a duracao e data da chamada 
			//formata a data
			//Joga a data formatada para o Gregorian Calendar
			//Variavel "prep" do tipo prepago recebe o valor do localizarPrepago (dados do assinante com o cpf digitado)
			//Depois invoca o metodo fazerChamada com os dados da variavel "prep" (esse recebe a data e minutos da chamada)
			if (escolha == 1) {
				localizarPrePago(id);
				GregorianCalendar gc = new GregorianCalendar();
				System.out.println("Digite a Duração da Chamada (minutos): ");
				int min = s2.nextInt();
				System.out.print("Insira a Data da Chamada (DD/MM/AAAA): ");
				Date data = formatador.parse(s2.next());
				gc.setTime(data);
				PrePago prep = localizarPrePago(id);
				prep.fazerChamada(gc, min);
				
			//Caso seja pospago, procede com o mesmo caminho do prepago, utilizando os dados do pospago.
			} else if (escolha == 2) {
				localizarPosPago(id);
				GregorianCalendar gc = new GregorianCalendar();
				System.out.println("Digite a Duração da Chamada (minutos): ");
				int min = s2.nextInt();
				System.out.println("Insira a Data da Chamada (DD/MM/AAAA): ");
				Date data = formatador.parse(s2.next());
				gc.setTime(data);
				PosPago posp = localizarPosPago(id);
				posp.fazerChamada(gc, min);

			}
		} catch (java.lang.NullPointerException ex) {
			System.out.println("insira um dado válido e tente novamente!!!");
			fazerChamada();
		}
	}

	//Metodo fazerRecarga
	//Recebe CPF, localiza o assinante com o CPF correspondente
	//Descarta posições nulas no vetor
	//Instancia um GregorianCalendar
	//Usuario digita o valor e data da recarga
	//Data é formatada e inserida no GregorianCalendar
	//Variavel "prep" do tipo prepago recebe o valor do localizarPrepago (dados do assinante com o cpf digitado)
	//Depois invoca o metodo recarregar com os dados da variavel "prep" 
	public void fazerRecarga() throws ParseException {
		try {
			Scanner s3 = new Scanner(System.in);
			System.out.println("Insira seu CPF: ");
			long id = s3.nextLong();
			if (localizarPrePago(id) != null) {

				GregorianCalendar gt = new GregorianCalendar();
				System.out.println("Insira o Valor da Recarga: ");
				float rc = s3.nextFloat();
				System.out.println("Insira a Data da Recarga (DD/MM/AAAA): ");
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

	
	//Metodo ImprimirFatura
	//Usuario digita o CPF do Assinante
	//Usuario informa o tipo de assinatura
	//Usuario digita o mes que deseja verificar a fatura
	//Programa exibe dados completos do assinante e valores totais de chamadas, recargas e assinaturas
	public void imprimirFaturas() throws ParseException {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite o CPF do assinante que deseja visualizar a fatura:  ");
			long id = sc.nextLong();
			System.out.println("Informe o tipo da assinatura:\n1-Pré-pago\n2-Pós-pago\nSua escolha: ");
			int escolha = sc.nextInt();
			
			if (escolha == 1) {
				localizarPrePago(id);
				PrePago prep = localizarPrePago(id);
				System.out.print("Digite um mês para verificação do histórico:  ");
				int m = sc.nextInt();
				System.out.println(prep);
				prep.imprimirFatura(m-1);
				
			}else if (escolha == 2) {
				localizarPosPago(id);
				PosPago posp = localizarPosPago(id);
				System.out.print("Digite um mês para verificação do histórico:  ");
				int m = sc.nextInt();
				posp.imprimirFatura(m-1);
			}
		} catch (java.lang.NullPointerException ex) {
			System.out.println("insira um dado válido e tente novamente!!!");
		}
	}

	public static void main(String[] args) throws ParseException {

        Telefonia tel = new Telefonia();
        int op = 0;
        do {
            try {
        		//menu de interação que invoca os métodos.
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
            }    catch (java.util.InputMismatchException ex) 
                {
                    System.out.println("Insira um dado válido e tente novamente!!!");
                } 
                catch (java.lang.ArrayIndexOutOfBoundsException el) 
                    {
                    System.out.println("Insira um dado válido e tente novamente!!!");
                    } 
    }while (op != 6);

}
}



