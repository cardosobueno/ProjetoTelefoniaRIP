public class Assinante {

    private long cpf;
    private String nome;
    private int numero;
    protected Chamada[] chamadas;
    protected Integer numChamadas;

    public Assinante(long cpf, String nome, int numero, Integer numChamadas) {
    	this.numChamadas = numChamadas;
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
        return "Nome: " + this.nome + "; Cpf: " + this.cpf + "; Numero: " + this.numero + "; Chamadas: " + this.chamadas + "; Número de chamadas: " + this.numChamadas;
    }
}