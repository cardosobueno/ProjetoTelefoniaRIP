import java.util.GregorianCalendar;

public class PosPago extends Assinante{
	
	private float assinatura;
	
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
		for(int i =0; i < 10; i ++)
		{
			if (this.chamadas[i] != null)
			{
				System.out.println( this.chamadas[i]);
				c = c + 1;
			}			
		}
		System.out.println("Quantidade de recargas disponíveis: " + (10 - c));
	}
	
	
	public static void main(String[] args) {
		PosPago p = new PosPago(1370180764,"Danillo Marcos Alves Viana",996403363,3f);
		
		p.fazerChamada(new GregorianCalendar(2011,05,06),10);
		p.fazerChamada(new GregorianCalendar(2011,05,06),14);
		p.fazerChamada(new GregorianCalendar(2011,05,06),13);
		p.fazerChamada(new GregorianCalendar(2011,05,06),11);
		p.fazerChamada(new GregorianCalendar(2011,05,06),18);
		p.fazerChamada(new GregorianCalendar(2011,05,06),13);
		p.fazerChamada(new GregorianCalendar(2011,05,06),199);
		
		p.mostrarChamadas();
		
	}
	
}