import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class PosPago extends Assinante{
	
	private float assinatura;
	
	public PosPago() {
		
	}
	
	public PosPago(long cpf, String nome, int numero, float assinatura)
	{
		super(cpf, nome, numero);
		this.assinatura = assinatura;
	}

	public void fazerChamada(GregorianCalendar data, int duracao)
	{
		 this.assinatura = duracao * 1.05f;
	        if (numChamadas > 0)
	        {
	            this.chamadas[this.numChamadas -1] = new Chamada(data, duracao);
	            this.numChamadas = this.numChamadas -1;
	        }
	        else 
	        {
	            System.out.println("Não pode realizar a chamada...");
	        }
	}
	
	public void mostrarChamadas()
	{
		int c = 0;
		for(int i =0; i < 25; i ++)
		{
			if (this.chamadas[i] != null)
			{
				System.out.println( this.chamadas[i]);
				c = c + 1;
			}			
		}
		System.out.println("Quantidade de chamadas disponíveis: " + (10 - c));
	}
	
	void imprimirFatura(int mes)
	{
		
		Telefonia tel = new Telefonia();
		
		for(int i =0; i < 25; i ++)
		{
			if (this.chamadas[i] != null)
			{
				System.out.println( this.chamadas[i]);
			
			}			
		}
		for(int i =0; i < tel.posPagos.length; i ++)
		{
			if (tel.posPagos[i] != null)
			{
				System.out.println(" top "+ tel.posPagos[i]);
			
			}			
		}
	}
	
	public static void main(String[] args) throws ParseException {
		PosPago p = new PosPago(123,"dfds",5020,232);
		
//		p.fazerChamada(new GregorianCalendar(2011,05,06),10);
//		p.fazerChamada(new GregorianCalendar(2011,05,06),14);
//		p.fazerChamada(new GregorianCalendar(2011,05,06),13);
//		p.fazerChamada(new GregorianCalendar(2011,05,06),11);
//		p.fazerChamada(new GregorianCalendar(2011,05,06),18);
//		p.fazerChamada(new GregorianCalendar(2011,05,06),13);
		p.fazerChamada(new GregorianCalendar(2011,05,06),199);
		
	
		p.imprimirFatura(1);
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