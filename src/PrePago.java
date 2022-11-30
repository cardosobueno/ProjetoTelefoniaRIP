import java.util.GregorianCalendar;

public class PrePago extends Assinante {

	private float creditos;
	private Integer numRecargas;
	private Recarga[] recargas;
	
	public PrePago() {
		
	}
	
	public PrePago(long cpf, String nome, int numero)
	{
		super(cpf, nome, numero);
		this.creditos = creditos;
		this.numRecargas = 30;
		this.recargas = new Recarga[numRecargas];	
	}
	
	
	void fazerChamada(GregorianCalendar data, int duracao)
	{	
		if(this.creditos > 0 && this.numChamadas > 0 && duracao <= this.creditos)
		{ 
			this.chamadas[this.numChamadas -1] = new Chamada(data, duracao);
			this.numChamadas = this.numChamadas -1;
			this.creditos = this.creditos - (duracao * 1.45f);
	    }
	    else 
	        {
	            System.out.println("Não é possível realizar a chamada...");
	        }
	 }
	
	public void recarregar(GregorianCalendar data, float valor) 
	{
		
		if(numRecargas > 0) 
		{	
			this.recargas[numRecargas-1] = new Recarga (data,valor);
			this.numRecargas -=1;
			this.creditos += valor;
		}
		else 
        {
            System.out.println("Não foi possível fazer recarga...");
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
		System.out.println("Quantidade de chamadas disponíveis: " + (10 - c));
	}
	
	public void mostrarRecargas() 
	{
		int c = 0;
		for(int i =0; i < 10; i ++) 
		{
			if (this.recargas[i] != null) 
			{
				System.out.println( this.recargas[i]);
				c = c + 1;
			}
			
		}
		System.out.println("Quantidade de recargas disponíveis: " + (10 - c));
	}

	void imprimirFatura(int mes)
	{
		Assinante ass = new Assinante(); 
		System.out.println(ass);
	
	}



	public static void main(String[] args) {	
		
		

		PrePago prep = new PrePago(1370180764,"Danillo Marcos Alves Viana",996403363);
		prep.recarregar(new GregorianCalendar(2020,03,04),1000);
//		prep.recarregar(new GregorianCalendar(2020,03,04),100);
//		prep.recarregar(new GregorianCalendar(2020,03,04),100);
//		prep.recarregar(new GregorianCalendar(2020,03,04),100);	
//		prep.recarregar(new GregorianCalendar(2020,03,04),100);
//		prep.recarregar(new GregorianCalendar(2020,03,04),100);
//		prep.recarregar(new GregorianCalendar(2020,03,04),100);
//		prep.recarregar(new GregorianCalendar(2020,03,04),100);
//		prep.recarregar(new GregorianCalendar(2020,03,04),100);
//		prep.recarregar(new GregorianCalendar(2020,03,04),7);
//		prep.recarregar(new GregorianCalendar(2020,03,04),7);

//		prep.mostrarRecargas();
		
//		prep.fazerChamada(new GregorianCalendar(2020,07,05),600);
		prep.fazerChamada(new GregorianCalendar(2020,07,05),600);
		prep.mostrarChamadas();
		System.out.println("Créditos: " + prep.creditos);
		
		prep.imprimirFatura(1);
		
		}
	
	

	
}

