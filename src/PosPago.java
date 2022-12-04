import java.util.GregorianCalendar;

public class PosPago extends Assinante {

	private float assinatura;

	public PosPago() {

	}

	// Construtor da classe
	public PosPago(long cpf, String nome, int numero, float assinatura) {
		super(cpf, nome, numero);
		this.assinatura = assinatura;
	}

	// Método fazer chamada, recebe data (gregorian calendar) e duracao da chamada.
	// Faz uma condição de pré-existencia da chamada, instancia e aloca os dados no
	// vetor chamada
	// Conforme as chamadas são feitas, a quantidade de chamadas possiveis é
	// decrementada
	public void fazerChamada(GregorianCalendar data, int duracao) {

		if (numChamadas > 0) {
			this.chamadas[this.numChamadas - 1] = new Chamada(data, duracao);
			this.numChamadas = this.numChamadas - 1;
			System.out.println("Chamada realizada com sucesso!!!\n");
		} else {
			System.out.println("Não pode realizar a chamada...\n");
		}
	}

	// Recebe um mes para exibir fatura
	// Percorre o vetore chamadas e compara o mes recebido como parametro
	// com o mes referente a data da chamada
	// No final, atualiza o valor das chamadas e soma a assinatura com o total de
	// chamadas
	void imprimirFatura(int mes) {
		float c = 0;
		for (int i = 0; i < chamadas.length; i++) {
			if (this.chamadas[i] != null) {
				if (this.chamadas[i].getData().get(GregorianCalendar.MONTH) == mes) {
					System.out.println(this.chamadas[i]);
					c = c + this.chamadas[i].getDuracao() * 1.04f;
				}
			}
		}
		System.out.printf("Valor gasto nas chamadas: %.2f %n", c);
		System.out.printf("Valor total assinatura + chamadas: %.2f %n", c + this.assinatura);
	}

}

/*
 * Teste para percorrer vetor e realizar chamada public void mostrarChamadas() {
 * int c = 0; for (int i = 0; i < 25; i++) { if (this.chamadas[i] != null) {
 * System.out.println(this.chamadas[i]); c = c + 1; } }
 * System.out.println("Quantidade de chamadas disponíveis: " + (10 - c)); }
 * GregorianCalendar c = chamadas[numChamadas].getData(); for (int i = 0; i <
 * chamadas.length; i++) {
 * 
 * if (chamadas[numChamadas].getData().get(GregorianCalendar.MONTH) == mes) {
 * numChamadas -= 1; System.out.println(chamadas[i]);
 * System.out.println(chamadas[numChamadas].getData().get(GregorianCalendar.
 * MONTH));
 * 
 * } else { System.out.println("Não funcionando!!!!!!"); } 
 * }* 
 * public static void main(String[] args) throws ParseException {
 * 
 * PosPago p = new PosPago(123, "dfds", 5020, 232);
 * 
 * p.fazerChamada(new GregorianCalendar(2011, 05, 06), 10); p.fazerChamada(new
 * GregorianCalendar(2011, 03, 06), 13); p.fazerChamada(new
 * GregorianCalendar(2011, 01, 05), 11); p.fazerChamada(new
 * GregorianCalendar(2011, 05, 06), 18); p.fazerChamada(new
 * GregorianCalendar(2011, 05, 02), 13); p.fazerChamada(new
 * GregorianCalendar(2011, 05, 07), 199); p.fazerChamada(new
 * GregorianCalendar(2011, 05, 06), 10); p.fazerChamada(new
 * GregorianCalendar(2011, 03, 06), 14); p.fazerChamada(new
 * GregorianCalendar(2011, 07, 06), 12);
 * 
 * GregorianCalendar gc = new GregorianCalendar();
 * 
 * // int mes1 = gc.get(Calendar.JANUARY); // int mes2 =
 * gc.get(Calendar.FEBRUARY); // int mes3 = gc.get(Calendar.MARCH); // int mes4
 * = gc.get(Calendar.APRIL); // int mes5 = gc.get(Calendar.MAY); // int mes6 =
 * gc.get(Calendar.JUNE); // int mes7 = gc.get(Calendar.JANUARY); // int mes8 =
 * gc.get(Calendar.JANUARY); // int mes9 = gc.get(Calendar.JANUARY); // int
 * mes10 = gc.get(Calendar.JANUARY); // int mes11 = gc.get(Calendar.JANUARY); //
 * int mes12 = gc.get(Calendar.JANUARY);
 * 
 * // p.imprimirFatura(1); // p.imprimirFatura(2); // p.imprimirFatura(3); //
 * p.imprimirFatura(4); // p.imprimirFatura(5); // p.imprimirFatura(6); //
 * p.imprimirFatura(7); // p.imprimirFatura(8); // p.imprimirFatura(9); //
 * p.imprimirFatura(10); // p.imprimirFatura(11); p.imprimirFatura(3);
 * 
 * // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Scanner sc =
 * new Scanner(System.in); // GregorianCalendar gc = new GregorianCalendar(); //
 * System.out.println("Digite a Duração da Chamada (minutos): "); // int min =
 * sc.nextInt(); // System.out.print("Insira a Data da Chamada (DD/MM/AAAA): ");
 * // Date data = sdf.parse(sc.next()); // gc.setTime(data);
 * 
 * // p.fazerChamada(gc, min); // p.mostrarChamadas(); //
 * this.posPagos[numPosPago - 1].fazerChamada(gc, min);
 */