
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Recarga {

	private Date data;
	private float valor;

	public Recarga(Date data, float valor) {
		super();
		this.data = data;
		this.valor = valor;
	}

	public Date getData() {

		return this.data;
	}

	public float getValor() {
		return this.valor;
	}

	public String toString() {
		// Teste do SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar dt = new GregorianCalendar();
		return sdf.format(dt.getTime()) + this.valor + this.data;
	}
}