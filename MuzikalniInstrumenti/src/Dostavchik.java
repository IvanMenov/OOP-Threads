import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Dostavchik implements Runnable{
	private MuzikalenMagazin magazin;
	private static final Integer MIN_DELIVERY_ITEMS	= 5;
	private HashMap<MusicInstrument, Integer> vremeZaDostavka= new HashMap<MusicInstrument, Integer>();
	
	public Dostavchik(MuzikalenMagazin magazin) throws IllegalNameException, IllegalPriceException {
		if(magazin!=null){
			this.magazin=magazin;
		}
		vremeZaDostavka.put(new Strunen("cigulka", 200,"strunen"), 20);
		vremeZaDostavka.put(new Strunen("viola", 120,"strunen"), 30);
		vremeZaDostavka.put(new Strunen("kontrabas", 300,"strunen"), 30);
		vremeZaDostavka.put(new Strunen("arfa", 250,"strunen"),45 );
		vremeZaDostavka.put(new Strunen("kitara", 600,"strunen"), 5);
		vremeZaDostavka.put(new Strunen("gudulka", 100,"strunen"), 15);
		vremeZaDostavka.put(new Udaren("baraban", 80,"udaren"), 7);
		vremeZaDostavka.put(new Udaren("tarambuka", 70,"udaren"), 9);
		vremeZaDostavka.put(new Udaren("daire", 70,"udaren"), 10);
		vremeZaDostavka.put(new Udaren("tupan", 50,"udaren"), 4);
		vremeZaDostavka.put(new Klavishen("piano", 2000,"klavishen"), 60);
		vremeZaDostavka.put(new Klavishen("akordeon", 175,"klavishen"), 12);
		vremeZaDostavka.put(new Klavishen("organ", 3000,"klavishen"), 60);
		vremeZaDostavka.put(new Duhov("trompet", 130,"duhov"), 8);
		vremeZaDostavka.put(new Duhov("trombon", 150,"duhov"), 8);
		vremeZaDostavka.put(new Duhov("tuba", 160,"duhov"), 8);
		vremeZaDostavka.put(new Electronen("sintezator", 1500,"electronen"), 30);
		vremeZaDostavka.put(new Electronen("bas-kitara", 700,"electronen"), 5);
	}
	@Override
	public void run() {	
		while(true){
		sellInstrumentsToTheStore();
		}
		
	}
	public void  sellInstrumentsToTheStore(){
		while(magazin.isStoreLowOnItems()==false){
			synchronized (magazin) {
				try {
					magazin.wait(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				}
			}
		}
		MusicInstrument instrument= magazin.lowInQuantity();
			magazin.addMusicInstrument(instrument, MIN_DELIVERY_ITEMS);
			System.out.println("The missing instruments were added.");
			synchronized (magazin) {
				magazin.notifyAll();
			}
		
		
	}
	
}
