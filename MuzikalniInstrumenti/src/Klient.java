import java.util.ArrayList;

//Има проблем, който не мога да оправя- когато свършат стоките от магазина 
//клиента започва да чака, но изглежда, че доставчика не се събужда, за да достави
// липсващите стоки.

public class Klient implements Runnable{
	private String name;
	private MuzikalenMagazin magazin;
	private ArrayList<MusicInstrument> instrumentiList= new ArrayList<MusicInstrument>();
	
	Klient(String name,MuzikalenMagazin magazin) throws IllegalNameException, IllegalPriceException {
		if(name!=null){
			this.name=name;
		}
		if(magazin !=null){
			this.magazin=magazin;
		}
		instrumentiList.add(new Strunen("cigulka", 200,"strunen"));
		instrumentiList.add(new Strunen("viola", 120,"strunen"));
		instrumentiList.add(new Strunen("kontrabas", 300,"strunen"));
		instrumentiList.add(new Strunen("arfa", 250,"strunen"));
		instrumentiList.add(new Strunen("kitara", 600,"strunen"));
		instrumentiList.add(new Strunen("gudulka", 100,"strunen"));
		instrumentiList.add(new Udaren("baraban", 80,"udaren"));
		instrumentiList.add(new Udaren("tarambuka", 70,"udaren"));
		instrumentiList.add(new Udaren("daire", 70,"udaren"));
		instrumentiList.add(new Udaren("tupan", 50,"udaren"));
		instrumentiList.add(new Klavishen("piano", 2000,"klavishen"));
		instrumentiList.add(new Klavishen("akordeon", 175,"klavishen"));
		instrumentiList.add(new Klavishen("organ", 3000,"klavishen"));
		instrumentiList.add(new Duhov("trompet", 130,"duhov"));
		instrumentiList.add(new Duhov("trombon", 150,"duhov"));
		instrumentiList.add(new Duhov("tuba", 160,"duhov"));
		instrumentiList.add(new Electronen("sintezator", 1500,"electronen"));
		instrumentiList.add(new Electronen("bas-kitara", 700,"electronen"));
	}

	@Override
	public void run(){
	while(true){
		try {
			this.buyInstrument();
		} catch (IllegalNameException | IllegalPriceException e) {
			e.printStackTrace();
		}			
		
	}
	}	
	public void buyInstrument() throws IllegalNameException, IllegalPriceException{

				
		int random = (int)(Math.random()*instrumentiList.size());	
		while(magazin.isStoreLowOnItems()==true){
			System.out.println(this.name+" will have to wait for the instrument to be delivered.");
			synchronized (magazin) {
				try {
					magazin.wait(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				}
			}
		}System.out.println(this.name+" wants to buy 1 of "+instrumentiList.get(random).getName());
			magazin.sellInstrument(instrumentiList.get(random), 1);
			
			synchronized (magazin) {
				magazin.notify();
			}
			
		
	}
}
