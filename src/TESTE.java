import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class TESTE {

	public static void main(String[] args) {
		
		Date data = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar gc = new GregorianCalendar(); 
		gc.set(11,11,1111);
		System.out.println(sdf.format(gc));
		
		
	}

}
