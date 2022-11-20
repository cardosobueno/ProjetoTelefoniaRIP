import java.util.Date;

public class PosPago extends Assinante{
	
	private float assinatura;
	
	public PosPago(int numero, float assinatura) {
		super(numero);
		this.assinatura = assinatura;
	}
	
	public void fazerChamada(Date data, int duracao) {
		this.assinatura =  duracao * 1.04f; 
		//this.chamadas.add(new Chamada(data, duracao));
		
		//if numChamadas > 0
		this.chamadas[this.numChamadas -1] = new Chamada(data, duracao);
		this.numChamadas = this.numChamadas - 1;
		
		System.out.println(this.numChamadas);
	}
	
	public void mostrarChamadas() {
		for(int i =0; i < 2; i ++) {
			System.out.println(this.chamadas[i]);
		}
	}
	
	
	public static void main(String[] args) {
		PosPago p = new PosPago(2, 10f);
		
		p.fazerChamada(new Date(),10);
		p.fazerChamada(new Date(),100);
		p.fazerChamada(new Date(),100);
		
		p.mostrarChamadas();
		
	}
	
}
