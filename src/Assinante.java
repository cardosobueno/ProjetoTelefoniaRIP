import java.util.Arrays;

public class Assinante {

    private long cpf;
    private String nome;
    private int numero;
    protected Chamada[] chamadas;
    protected Integer numChamadas;
    
    public Assinante() {	
    }
    public Assinante(long cpf, String nome, int numero) {
    	this.numChamadas = 12;
        this.chamadas = new Chamada[numChamadas];
        this.nome = nome;
        this.cpf = cpf;
        this.numero = numero;
        
    }

    public long getCpf() 
    {
        return this.cpf;
    }
	@Override
	public String toString() {
		return "Assinante [cpf=" + cpf + ", nome=" + nome + ", numero=" + numero +"\n" + ", chamadas="+
				 Arrays.toString(chamadas)+"\n" + ", numChamadas=" + numChamadas + "]";
	}

    
}