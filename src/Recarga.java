
/*
 Recarga  
A classe Recarga possui 2 atributos:
a) data: data da realização da recarga (objeto da classe GregorianCalendar);
b) valor: valor em reais da recarga.
O construtor desta classe inicializa seus atributos com os argumentos do construtor. 
A seguir são descritos os métodos da classe Recarga:
a) GregorianCalendargetData(): devolve o atributo data;
b) floatgetValor(): devolve o atributo valor;
c) String toString(): devolve uma representação textual dos atributos da classe. 
Recomenda-se usar a classe SimpleDateFormat para formatar a data no formato 
dd/MM/yyyy
*/

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

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
	public int hashCode() {
		return Objects.hash(data, valor);
	}
	
	public static void imprimirDadosRecarga( GregorianCalendar data, float valor) {
	
		int ano = data.get(Calendar.YEAR);
		int mes = data.get(Calendar.MONTH);
		int dia = data.get(Calendar.DAY_OF_MONTH);
		System.out.println("Data da recarga " + dia +"/"+mes+"/"+ ano);
		System.out.println("Valor da recarga "+ valor);
	}

	@Override
	public String toString() {
		return "Data da Recarga: " + sdf.format(data.getTime())
			 + " Valor da Recarga: "+ valor;
	}	
	
	public static void main(String[] args) {	
	
	GregorianCalendar gc = new GregorianCalendar();
	Recarga rc = new Recarga(gc, 23);
	//System.out.println(rc);
	
	System.out.println(gc.getTime());
	
	//System.out.println(sdf.format(gc.getTime()));
	//imprimirDadosRecarga(gc,123);
	}

}