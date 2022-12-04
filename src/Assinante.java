import java.util.Arrays;

public class Assinante {

	//Dados de assinante
	private long cpf;
	private String nome;
	private int numero;
	protected Chamada[] chamadas;
	protected Integer numChamadas;

	public Assinante() {
	}

	//Construtor assinante (cpf, nome e numero)
	public Assinante(long cpf, String nome, int numero) 
	{
		this.numChamadas = 12;
		this.chamadas = new Chamada[numChamadas];
		this.nome = nome;
		this.cpf = cpf;
		this.numero = numero;

	}

	//Retorna CPF do assinante para o método localizarPrePago/localizarPosPago
	public long getCpf() 
	{
		return this.cpf;
	}

	
	//Retorno toString padrao. Dados do assinante
	@Override
	public String toString() 
	{
		return "Assinante: CPF=" + cpf + ", Nome=" + nome + ", Numero=" + numero + ", Numeros de Chamadas Restantes="
				+ numChamadas;
	}

}