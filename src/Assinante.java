public class Assinante {

    private long cpf;
    private String nome;
    private int numero;
    protected Chamada[] chamadas;
    protected Integer numChamadas;
    
    public Assinante() {	
    }
    public Assinante(long cpf, String nome, int numero) {
    	this.numChamadas = 30;
        this.chamadas = new Chamada[numChamadas];
        this.nome = nome;
        this.cpf = cpf;
        this.numero = numero;
        
    }

    public long getCpf() 
    {
        return this.cpf;
    }

    public String toString()
    {
        return "Nome: " + this.nome + "; Cpf: " + this.cpf + "; Numero: " + this.numero + "; Chamadas: " + chamadas[numChamadas-1] + "; Número de chamadas: " + this.numChamadas;
    }
}