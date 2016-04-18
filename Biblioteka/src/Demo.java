import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Demo {
	public static void main(String[] args) {
		Biblioteka b = new Biblioteka();
		Klient cklient= new Klient(b);
		Thread threadBib= new Thread(b);
		
		Thread threadKlient= new Thread(cklient);
		Thread klient2= new Thread(new Klient(b));
		Thread klient3= new Thread(new Klient(b));
		threadKlient.setDaemon(true);
		threadBib.start();
		threadKlient.start();
		klient2.start();
		klient3.start();
	}
}
