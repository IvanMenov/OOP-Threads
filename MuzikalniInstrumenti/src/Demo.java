
public class Demo {
	public static void main(String[] args) throws IllegalNameException, IllegalPriceException, InterruptedException {
		Kasa kasa= new Kasa();
		MuzikalenMagazin magazin= new MuzikalenMagazin(kasa);
		
		//magazin.listIntems();
		magazin.listItemsByName();
		System.out.println();
		magazin.listIntemsByType();
		
//		MusicInstrument fleita= new Duhov("fleita", 300, "duhov");
//		MusicInstrument tupan = new Udaren("tupan", 50, "udaren");
//		MusicInstrument tuba= new Duhov("tuba", 160,"duhov");
//		MusicInstrument trompet= new Duhov("trompet", 130,"duhov");
//		magazin.addMusicInstrument(fleita, 5);
//	//	magazin.addMusicInstrument(new Udaren("tupan", 200, "udaren"), 10);
//		
//		System.out.println();
//		magazin.listItemsByPrice("descending");`
//		magazin.listAvailableItems();
//		magazin.sellInstrument(fleita, 4);
//		magazin.sellInstrument(tupan, 3);
//		magazin.sellInstrument(tuba, 2);
//		magazin.sellInstrument(trompet, 9);
//		
//		
//	//	magazin.listAvailableItems();
//		magazin.sortItemsByNumbersSold();
//		magazin.showMostSoldItem("most");
//		magazin.showBiggestIncomeFromProduct();
		
		System.out.println("Threads starting:");
		Thread dostavchik = new Thread(new Dostavchik(magazin));
		Thread klient =  new Thread(new Klient("Ivan",magazin));
		Thread klient2 = new Thread(new Klient("Gosho",magazin));
		klient2.start();
		klient.start();
		dostavchik.start();
		dostavchik.setPriority(10);
		klient.setPriority(5);
		klient2.setPriority(5);
		
		
//		while(dostavchik.isAlive() || klient.isAlive()){
//			
//		}
//		magazin.listAvailableItems();
//		magazin.showBiggestIncomeFromProduct();
//		magazin.showMostSoldItem("most");
	}
}
