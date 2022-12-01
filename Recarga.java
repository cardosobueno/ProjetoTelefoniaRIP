import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Recarga {
	
	private float valor;
	private GregorianCalendar data;
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public Recarga() {
	
	}
	
	public Recarga(GregorianCalendar data, float valor) {
		
		this.data = data;
		this.valor = valor;
	
	}	
	 	
	public GregorianCalendar getData(){
		
		return data;
		
	}
	
	public float getValor(){
		return valor;
	}


	@Override
	public String toString() {
		return "Data da Recarga: " + sdf.format(data.getTime())
			 + " Valor da Recarga: "+ valor;
	}	
	
	public static void main(String[] args) {	
	
	GregorianCalendar gc = new GregorianCalendar(2020,02,02);

	Recarga rc = new Recarga(gc, 23);
	System.out.println(rc);
	
	
	//System.out.println(gc.getTime());
	
	//System.out.println(sdf.format(gc.getTime()));
	//imprimirDadosRecarga(gc,123);
	}

}