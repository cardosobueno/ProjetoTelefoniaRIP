public class Assinante {

	private long cpf;
	private String nome;
	private int numero;
	protected Chamada[] chamadas;
	protected Integer numChamadas;

	public Assinante(Integer numero) 
	{
		this.chamadas = new Chamada[numero];
		this.numChamadas = numero;
	}
	
	public long getCpf() 
	{
		return this.cpf;
	}
	
	public String toString()
	{
		return "Nome: " + this.nome + "; Cpf: " + this.cpf + "; Numero: " + this.numero + "; Chamadas: " + this.chamadas + "; Número de chamadas: " + this.numChamadas;
	}
}