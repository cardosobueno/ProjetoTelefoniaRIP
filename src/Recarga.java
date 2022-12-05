import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Recarga {

	private float valor;
	private GregorianCalendar data;
	//Formatacao da data para atender normas ABNT
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public Recarga() {
	}
	//constructor recarga
	public Recarga(GregorianCalendar data, float valor) 
	{
		this.data = data;
		this.valor = valor;
	}
	//Retorna data 
	public GregorianCalendar getData() 
	{
		return data;
	}
	//Retorna valor, usado para somar valor total de recargas
	public float getValor() 
	{
		return valor;
	}
	//Retorna dados da recarga na formatacao adequada
	@Override
	public String toString() {
		return "Data da Recarga: " + sdf.format(data.getTime()) + " Valor da Recarga: " + valor;
	}
}
/*
________$$$$
_______$$__$
_______$___$$
_______$___$$
_______$$___$$
________$____$$
________$$____$$$
_________$$_____$$
_________$$______$$
__________$_______$$
____$$$$$$$________$$
__$$$_______________$$$$$$
_$$____$$$$____________$$$
_$___$$$__$$$____________$$
_$$________$$$____________$
__$$____$$$$$$____________$
__$$$$$$$____$$___________$
__$$_______$$$$___________$
___$$$$$$$$$__$$_________$$
____$________$$$$_____$$$$
____$$____$$$$$$____$$$$$$
_____$$$$$$____$$__$$
_______$_____$$$_$$$
________$$$$$$$$$$
*/