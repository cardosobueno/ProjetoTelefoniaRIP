import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Chamada {
	
	private GregorianCalendar data;
	private Integer duracao;
	//Formatacao da data para atender normas ABNT
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	//Sobrecarga. Boa pratica 
	public Chamada() {

	}

	//Construtor chamada
	public Chamada(GregorianCalendar data, Integer duracao) 
	{
		super();
		this.data = data;
		this.duracao = duracao;
	}
	
	//retorna a data.Usamos nas classes Prepago e Pospago
	//Metodo Imprimirfaturas
	public GregorianCalendar getData() 
	{
		return data;
	}
	//Retorna duracao
	public Integer getDuracao() 
	{
		return duracao;
	}

	//Retorna dados da chamada na formatacao adequada
	@Override
	public String toString() 
	{

		return "Data da Chamada: " + sdf.format(data.getTime()) + " Duração da chamada: " + duracao + " minutos";
	}

	/* codigo alienigena do felipe (NAO LER)
	 * 
	 * @Override public int hashCode() { return Objects.hash(data, duracao); }
	 * 
	 * @Override public boolean equals(Object obj) {
	 * if (this == obj) return true;
	 * if (obj == null) return false;
	 * if (getClass() != obj.getClass()) return false; 
	 * Chamada other = (Chamada) obj; return Objects.equals(data, other.data)&& Objects.equals(duracao, other.duracao); }
	
	public static void main(String[] args) {
		GregorianCalendar ca = new GregorianCalendar();
		ca.set(1998, 10, 21);
		// ca.getTime();
		Chamada c = new Chamada(ca, 50);
		Chamada c2 = new Chamada(ca, 50);
		List<Chamada> chamadas = new ArrayList<>();
		chamadas.add(c);
		chamadas.add(c2);
		Set cm = new HashSet();
		cm.add(c);
		cm.add(c);
		System.out.println(cm);
		System.out.println();
		System.out.println(chamadas);
		System.out.println(c);
	}
 */
}