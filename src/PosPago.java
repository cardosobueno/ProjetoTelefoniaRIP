import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PosPago extends Assinante {

	private float assinatura;

	public PosPago() {

	}

	public PosPago(long cpf, String nome, int numero, float assinatura) {
		super(cpf, nome, numero);
		this.assinatura = assinatura;
	}

	public void fazerChamada(GregorianCalendar data, int duracao) {
		this.assinatura = duracao * 1.05f;
		if (numChamadas > 0) {
			this.chamadas[this.numChamadas - 1] = new Chamada(data, duracao);
			this.numChamadas = this.numChamadas - 1;
		} else {
			System.out.println("Não pode realizar a chamada...");
		}
	}

	public void mostrarChamadas() {
		int c = 0;
		for (int i = 0; i < 25; i++) {
			if (this.chamadas[i] != null) {
				System.out.println(this.chamadas[i]);
				c = c + 1;
			}
		}
		System.out.println("Quantidade de chamadas disponíveis: " + (10 - c));
	}

	void imprimirFatura(Integer mes)

	{
		Telefonia tel = new Telefonia();

		for (int i = 0; i < tel.prePagos.length; i++) {
			if (tel.prePagos[i] != null) {
				System.out.println(" top " + tel.prePagos[i]);
			}
		}

		for (int i = 0; i < 30; i++) {
			if (this.chamadas[i] != null) {
				System.out.println(this.chamadas[i].getData());
			}

		}

//		GregorianCalendar c = chamadas[numChamadas].getData();
//		for (int i = 0; i < chamadas.length; i++) {

//			if (chamadas[numChamadas].getData().get(GregorianCalendar.MONTH) == mes) {
//				numChamadas -= 1;
//				System.out.println(chamadas[i]);
//				System.out.println(chamadas[numChamadas].getData().get(GregorianCalendar.MONTH));

//			} else {
//				System.out.println("Não to funcionando!!!!!!");
//			}

//		}

	}

	public static void main(String[] args) throws ParseException {

		PosPago p = new PosPago(123, "dfds", 5020, 232);

		p.fazerChamada(new GregorianCalendar(2011, 05, 06), 10);
		p.fazerChamada(new GregorianCalendar(2011, 03, 06), 13);
		p.fazerChamada(new GregorianCalendar(2011, 01, 05), 11);
		p.fazerChamada(new GregorianCalendar(2011, 05, 06), 18);
		p.fazerChamada(new GregorianCalendar(2011, 05, 02), 13);
		p.fazerChamada(new GregorianCalendar(2011, 05, 07), 199);
		p.fazerChamada(new GregorianCalendar(2011, 05, 06), 10);
		p.fazerChamada(new GregorianCalendar(2011, 03, 06), 14);
		p.fazerChamada(new GregorianCalendar(2011, 07, 06), 12);

		GregorianCalendar gc = new GregorianCalendar();

//		int mes1 = gc.get(Calendar.JANUARY);
//		int mes2 = gc.get(Calendar.FEBRUARY);
//		int mes3 = gc.get(Calendar.MARCH);
//		int mes4 = gc.get(Calendar.APRIL);
//		int mes5 = gc.get(Calendar.MAY);
//		int mes6 = gc.get(Calendar.JUNE);
//		int mes7 = gc.get(Calendar.JANUARY);
//		int mes8 = gc.get(Calendar.JANUARY);
//		int mes9 = gc.get(Calendar.JANUARY);
//		int mes10 = gc.get(Calendar.JANUARY);
//		int mes11 = gc.get(Calendar.JANUARY);
//		int mes12 = gc.get(Calendar.JANUARY);

//		p.imprimirFatura(1);
//		p.imprimirFatura(2);
//		p.imprimirFatura(3);
//		p.imprimirFatura(4);
//		p.imprimirFatura(5);
//		p.imprimirFatura(6);
//		p.imprimirFatura(7);
//		p.imprimirFatura(8);
//		p.imprimirFatura(9);
//		p.imprimirFatura(10);
//		p.imprimirFatura(11);
		p.imprimirFatura(3);

//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		Scanner sc = new Scanner(System.in);
//		GregorianCalendar gc = new GregorianCalendar();
//		System.out.println("Digite a Duração da Chamada (minutos): ");
//		int min = sc.nextInt();
//		System.out.print("Insira a Data da Chamada (DD/MM/AAAA): ");
//		Date data = sdf.parse(sc.next());
//		gc.setTime(data);

//		p.fazerChamada(gc, min);
//		p.mostrarChamadas();
//		this.posPagos[numPosPago - 1].fazerChamada(gc, min);

	}

}