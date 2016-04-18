import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class Biblioteka implements Runnable{
	private Map<TypeOfReadingMaterial,Map<String,List<Chetivo>>> chetiva;
	private List<Chetivo> vzetiChetiva= new ArrayList<Chetivo>();
	private double moneyFromRenting=0;
	
	public Biblioteka() {
		chetiva = new HashMap<>();
		chetiva.put(TypeOfReadingMaterial.BOOK, new   ConcurrentSkipListMap<>());
		chetiva.put(TypeOfReadingMaterial.SPISANIE, new ConcurrentSkipListMap<>());
		chetiva.put(TypeOfReadingMaterial.UCHEBNIK, new ConcurrentSkipListMap<>());

		chetiva.get(TypeOfReadingMaterial.BOOK).put("Istoricheski",
				Arrays.asList(new Book( "Pod igoto","Prosveta","Ivan Vazov"  ),
						new Book("Malkiq Princ", "Nov svqt","Ekziuperi" )));

		chetiva.get(TypeOfReadingMaterial.SPISANIE).put("Modni",
				Arrays.asList(new Spisanie( "Cosmos", "Anubis"),
						new Spisanie("Blqsyk", "Bulvest 2000")));

		chetiva.get(TypeOfReadingMaterial.UCHEBNIK).put("Matematika",
				Arrays.asList(new Uchebnik("Algebra za 5 klas", "Anubis","Ganio Hristev" ),
						new Uchebnik("Integrali za 2-ri klas", "Prosveta","Stamat Stoynov")));
		
	}
	public int countChetiva(){
		int count= 0;
		for (String a : chetiva.get(TypeOfReadingMaterial.BOOK).keySet()) {
			count+=chetiva.get(TypeOfReadingMaterial.BOOK).get(a).size();
		}
		for (String a : chetiva.get(TypeOfReadingMaterial.UCHEBNIK).keySet()) {
			count+=chetiva.get(TypeOfReadingMaterial.UCHEBNIK).get(a).size();
		}
		for (String a : chetiva.get(TypeOfReadingMaterial.SPISANIE).keySet()) {
			count+=chetiva.get(TypeOfReadingMaterial.SPISANIE).get(a).size();
		}
		return count;
	}
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {	
				e.printStackTrace();
			return;
			}
		int difference= this.countChetiva()-this.vzetiChetiva.size();
		System.out.println(difference+ " number of reading books are still available");
		
		Collections.sort(vzetiChetiva, new Comparator<Chetivo>() {
			@Override
			public int compare(Chetivo o1, Chetivo o2) {
				
				return o1.lastDate().getWhenIsItTaken().compareTo(o2.lastDate().getWhenIsItTaken());
			}
		});
		PrintWriter writer = null;
		
		 try {
			writer = new PrintWriter("D:\\the-file-name.txt", "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		for (Chetivo chetivo : vzetiChetiva) {
			writer.println(chetivo);
		}
		writer.close();
		}
	}
	public List<Chetivo> getChetiva(){
		List<Chetivo> list = new ArrayList<Chetivo>();
		for (String key : chetiva.get(TypeOfReadingMaterial.BOOK).keySet()){
			list.addAll(chetiva.get(TypeOfReadingMaterial.BOOK).get(key));
		}
		for (String key : chetiva.get(TypeOfReadingMaterial.SPISANIE).keySet()){
			list.addAll(chetiva.get(TypeOfReadingMaterial.SPISANIE).get(key));
		}
		for (String key : chetiva.get(TypeOfReadingMaterial.UCHEBNIK).keySet()){
			list.addAll(chetiva.get(TypeOfReadingMaterial.UCHEBNIK).get(key));
		}
		return list;
	}
	public void returnChetivo(Chetivo chetivo, LocalDateTime time) throws Exception{
		if(chetivo!=null && time !=null	){
			if(!chetivo.isThischetivoSpisanie()){
				chetivo.putDateOfBringingBackInHistory(time);
				
				chetivo.setTaken(false);
			}
			double price= returnPriceAfterInterest(chetivo);
			moneyFromRenting+=price;
			System.out.println("Giving the fee for the book of "+price+" lv.");
			
				synchronized (vzetiChetiva) {
					vzetiChetiva.remove(chetivo);
				}
			}
			System.out.println("Giving back "+chetivo);		
		
		
	}
	public double returnPriceAfterInterest(Chetivo chetivo) throws Exception{
		if(!chetivo.isThischetivoSpisanie()){
		History taken= chetivo.lastDate();
		Duration difference= Duration.between(taken.getWhenIsItTaken(), taken.getWhenIsItBroughtBack());
		if(difference.getSeconds()>chetivo.getMaxTimeToBeTaken()){
			double sec = (difference.getSeconds()-chetivo.getMaxTimeToBeTaken());
			double money=(((100+sec)/100)+chetivo.getPrice());
			return money;
		}return chetivo.getPrice();
	  }
		return 0;
	}
	public void takeSthToRead(Chetivo chetivo,LocalDateTime time){
		if(chetivo!=null && time!=null){
			if(chetivo.isTaken()==false){
				if(chetivo.isThischetivoSpisanie()==true){
					System.out.println("Spisanieto ne moje da se vzima izvun bibliotekata.Shte si pocheta v bibliotekata.");
					return;
				}
				else{
					chetivo.setTaken(true);	
					chetivo.putDateOfTakingInHistoryOfTakings(time);
					synchronized (vzetiChetiva) {				
						vzetiChetiva.add(chetivo);
						System.out.println("taking: "+chetivo);
					}
					
				}
			}else{
				System.out.println("The"+chetivo +"is already taken.");
			}
		}
		
	}
	public void showCatalog(String whatToShow){
		if(whatToShow!=null){
			Map<String,List<Chetivo>> map= chetiva.get(TypeOfReadingMaterial.valueOf(whatToShow));
			for (String  category : map.keySet()) {
				System.out.println(category);
				List<Chetivo> list =map.get(category);
				for (Chetivo chetivo : list) {
					System.out.println(chetivo);
				}
			}
		}
	}
	
}
