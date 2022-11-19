
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


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Recarga {
	
	private Date data;
	private float valor;
	
	private GregorianCalendar gc;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Recarga() {
	
	}
	
	
	public Recarga(Date data, float valor) {
		super();
		this.data = data;
		this.valor = valor;
	
	}
	
	 	
	public Date getData()
	{
		return data;
	}
	
	public float getValor()
	{
		return valor;
	}

	@Override
	public String toString() {
		return "Data da Recarga: " + sdf.format(data)
			 + "valor da Recarga:"+ valor;
	}
	
	
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Insira data da recarga no formato (DD/MM/AAAA): ");
			//Date data = sdf.parse(sc.next());
			Date data = new Date();
			

			GregorianCalendar gc = new GregorianCalendar(); 
			gc.setTime(data);
			Recarga rc = new Recarga(data,123);
			
			System.out.println(sdf.format(data));
			System.out.println(rc);
		}
		
		
		
	}


	

}