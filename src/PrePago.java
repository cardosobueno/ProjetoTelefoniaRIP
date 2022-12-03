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
		if(this.creditos > 0 && this.numChamadas > 0 && duracao < this.creditos)
		{ 
			this.chamadas[this.numChamadas -1] = new Chamada(data, duracao);
			this.numChamadas -= 1;
			this.creditos -= (duracao * 1.45f);
            System.out.println("Chamada realizada com sucesso!!!");
	    }
	    else 
	        {
	            System.out.println("Não é possível realizar a chamada!!!");
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
	void imprimirFatura(int mes) {
		
	
		try {
				for(int i =0; i < recargas.length; i ++) 
			
			{
				if (this.recargas[i] != null) 
				{
					System.out.println( this.recargas[i]);
				}
			}
	
			for(int i =0; i <chamadas.length; i ++) 
			{
				if (this.chamadas[i] != null) 
				{
					System.out.println( this.chamadas[i]);
				}
				
			}
		}
		 catch ( java.lang.ArrayIndexOutOfBoundsException ex) {
		System.out.println("Você não pode fazer isso AMIGO!!!!");
	}
	}
	


	public static void main(String[] args) {	
			
		PrePago prep = new PrePago(123,"dan",123412);

		prep.recarregar(new GregorianCalendar(2020,03,04),1000);	
		prep.fazerChamada(new GregorianCalendar(2020,07-1,05),6);
		prep.fazerChamada(new GregorianCalendar(2020,07-1,05),6);
		prep.recarregar(new GregorianCalendar(2020,03,04),1000);	
		prep.fazerChamada(new GregorianCalendar(2020,07-1,05),6);
		prep.fazerChamada(new GregorianCalendar(2020,07-1,05),6);	
		prep.recarregar(new GregorianCalendar(2020,03,04),1000);	
		prep.fazerChamada(new GregorianCalendar(2020,07-1,05),6);
		prep.fazerChamada(new GregorianCalendar(2020,07-1,05),6);
		prep.recarregar(new GregorianCalendar(2020,03,04),1000);	
		
//		prep.imprimirFatura(1);
		
		Assinante ass = new Assinante(123,"nnn",23432);
		System.out.println(ass);

		
		}

}

