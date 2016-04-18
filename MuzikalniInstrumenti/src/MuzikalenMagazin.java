import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class MuzikalenMagazin implements IMusicStore{
	private Kasa kasa;
	private Map<MusicInstrument, Integer> instrumenti= new HashMap<MusicInstrument, Integer>();
	private List<Entry<MusicInstrument, Integer>> result= new ArrayList<Entry<MusicInstrument, Integer>>(); 
	private Map<MusicInstrument, Integer> resultMap= new HashMap<MusicInstrument, Integer>();
	
	public MuzikalenMagazin(Kasa kasa) throws IllegalNameException, IllegalPriceException {
		if(kasa!=null){
			this.kasa= kasa;
		}
		initialSupply();
	}
	
	private void initialSupply() throws IllegalNameException, IllegalPriceException {
		instrumenti.put(new Strunen("cigulka", 200,"strunen"), 5);
		instrumenti.put(new Strunen("viola", 120,"strunen"), 5);
		instrumenti.put(new Strunen("kontrabas", 300,"strunen"), 5);
		instrumenti.put(new Strunen("arfa", 250,"strunen"), 5);
		instrumenti.put(new Strunen("kitara", 600,"strunen"), 5);
		instrumenti.put(new Strunen("gudulka", 100,"strunen"), 5);
		instrumenti.put(new Udaren("baraban", 80,"udaren"), 5);
		instrumenti.put(new Udaren("tarambuka", 70,"udaren"), 5);
		instrumenti.put(new Udaren("daire", 70,"udaren"), 5);
		instrumenti.put(new Udaren("tupan", 50,"udaren"), 5);
		instrumenti.put(new Klavishen("piano", 2000,"klavishen"), 5);
		instrumenti.put(new Klavishen("akordeon", 175,"klavishen"), 5);
		instrumenti.put(new Klavishen("organ", 3000,"klavishen"), 5);
		instrumenti.put(new Duhov("trompet", 130,"duhov"), 5);
		instrumenti.put(new Duhov("trombon", 150,"duhov"), 5);
		instrumenti.put(new Duhov("tuba", 160,"duhov"), 5);
		instrumenti.put(new Electronen("sintezator", 1500,"electronen"), 5);
		instrumenti.put(new Electronen("bas-kitara", 700,"electronen"), 5);
	}
	public boolean isStoreLowOnItems(){
		for (Entry<MusicInstrument, Integer> entry : instrumenti.entrySet()) {
			if(entry.getValue()<=1){
				return true;
			}
		}
		return false;
	}
	public MusicInstrument lowInQuantity(){
		
		for (Entry<MusicInstrument, Integer> entry : instrumenti.entrySet()) {
			if(entry.getValue()<=1){
				return entry.getKey();
			}
		}return null;
	}
	public void showBiggestIncomeFromProduct(){
		Integer incomeBiggest= result.get(0).getKey().getPrice()*result.get(0).getValue();
		
		int indexBiggestIncome=0;
		for (int i = 0; i < result.size(); i++) {	
			Integer incomeCurrent=  result.get(i).getKey().getPrice()*result.get(i).getValue();
			if(incomeCurrent>incomeBiggest){
				incomeBiggest=incomeCurrent;
				indexBiggestIncome=i;
			}
		}
		System.out.println("Most profitable item is "+result.get(indexBiggestIncome)+" with profit of:"+incomeBiggest);
	}
	public void showMostSoldItem(String mostLeastSold){
		int mostSoldIndex= 0;
		int leastSoldIndex=0;
		Integer mostSold= result.get(0).getValue();
		Integer leastSold= result.get(0).getValue();
		
		for (int i = 0; i <result.size(); i++) {
			Integer currentMostSold= result.get(i).getValue();
			if(currentMostSold>mostSold){
				mostSoldIndex=i;
			}
			if(currentMostSold<leastSold){
				leastSold=i;
			}	
		}
		if(mostLeastSold.equals("most")){
			System.out.println("The most sold :");
			System.out.println(result.get(mostSoldIndex).getKey()+" - "+result.get(mostSoldIndex).getValue()+" items sold.");
		}
		if(mostLeastSold.equals("least")){
			System.out.println("Least sold :");
			System.out.println(result.get(leastSoldIndex).getKey()+" - "+result.get(leastSoldIndex).getValue()+" items sold.");
		}
		
	}
	public void sortItemsByNumbersSold(){
		System.out.println("Items sorted by numbers sold:");
		Collections.sort(result, new Comparator<Entry<MusicInstrument, Integer>>() {

			@Override
			public int compare(Entry<MusicInstrument, Integer> o1, Entry<MusicInstrument, Integer> o2) {
				
				return o1.getValue()-o2.getValue();
			}
		});
		
		for (Entry<MusicInstrument, Integer> entry : result) {
			System.out.println(entry.getKey()+" - "+entry.getValue());
		}
		
		
	}
	private void addSoldItemsToList(MusicInstrument instrument, Integer count){
		if(instrument!=null && count!=null){
			for (Entry<MusicInstrument, Integer> entry : instrumenti.entrySet()) {
					if(entry.getKey().equals(instrument)){					
						resultMap.put(entry.getKey(), count);
						break;
					}
				}		
			for (Entry<MusicInstrument, Integer> entry : resultMap.entrySet()) {
				if(entry.getKey().equals(instrument)){
					result.add(entry);
				}
			}
		}
	}
	
	
	public void sellInstrument(MusicInstrument instrument, Integer count){
		if(instrument!=null && count!=null){
		for (Entry<MusicInstrument, Integer> entry : instrumenti.entrySet()) {
			if(entry.getKey().equals(instrument)){		
					Integer newQuantity= entry.getValue()-count;
					instrumenti.put(entry.getKey(), newQuantity);
					this.addSoldItemsToList(instrument, count);
					kasa.addMoney(entry.getKey().getPrice()*count);
					System.out.println("After selling "+count+" of "+instrument.getName()+" we have "+newQuantity+" items left. ");
					
					System.out.println("We have "+kasa.getMoney()+" lv. in the kasa.");
					
					return ;
				
			 }
		  }
		}
	}
	public void addMusicInstrument(MusicInstrument instrument, Integer count){
		
		if(instrument!=null && count!=null && count>0){
			if(!instrumenti.containsKey(instrument) ){
				instrumenti.put(instrument, count);
				System.out.println("The instrument was added to the collection.");
				return;
			}else{
					for (Entry<MusicInstrument, Integer> entry : instrumenti.entrySet()) {
						
						if(entry.getKey().equals(instrument))
							instrumenti.put(entry.getKey(),entry.getValue()+count);
							Integer quantity= entry.getValue()+count;
							System.out.println("Deliverying the missing items.");
							System.out.println(entry.getKey()+"now has "+ quantity+" items.");
							
						{
					}
				}
			}
				
		}
	}
	public void listAvailableItems(){
		for (Entry<MusicInstrument, Integer> entry : instrumenti.entrySet()) {
			if(entry.getValue()>0){
				System.out.println(entry.getKey()+"-"+entry.getValue()+" items left");
			}
		}
	}
	public void listItemsByPrice(String orderBy){
		List<Entry<MusicInstrument, Integer>> sortByPrice = new LinkedList<Entry<MusicInstrument, Integer>>(instrumenti.entrySet());
		
		Collections.sort(sortByPrice, new Comparator<Entry<MusicInstrument, Integer>>() {

			@Override
			public int compare(Entry<MusicInstrument, Integer> o1, Entry<MusicInstrument, Integer> o2) {
				if(orderBy.equals("ascending")){
				return o1.getKey().getPrice()-o2.getKey().getPrice();
				}
				return  o2.getKey().getPrice()-o1.getKey().getPrice();
			}
			
		});
		for (Entry<MusicInstrument, Integer> entry : sortByPrice) {
			System.out.println(entry.getKey());
		}
	}
	public void listIntemsByType(){
		List<Entry<MusicInstrument, Integer>> sortByType = new LinkedList<Entry<MusicInstrument, Integer>>(instrumenti.entrySet());
		
		Collections.sort(sortByType,new Comparator<Entry<MusicInstrument, Integer>>() {

			@Override
			public int compare(Entry<MusicInstrument, Integer> o1, Entry<MusicInstrument, Integer> o2) {
				return o1.getKey().getType().compareTo(o2.getKey().getType());
			}
			
		});

		for (Entry<MusicInstrument, Integer> entry : sortByType) {
			System.out.println(entry.getKey().getType()+" - "+entry.getKey());
		}
	}
	public void listItemsByName(){
		List<Entry<MusicInstrument, Integer>> sortByName = new LinkedList<Entry<MusicInstrument, Integer>>(instrumenti.entrySet());
		
		Collections.sort(sortByName,new Comparator<Entry<MusicInstrument, Integer>>() {

			@Override
			public int compare(Entry<MusicInstrument, Integer> o1, Entry<MusicInstrument, Integer> o2) {
				// TODO Auto-generated method stub
				return o1.getKey().getName().compareTo(o2.getKey().getName());
			}
			
		});

		for (Entry<MusicInstrument, Integer> entry : sortByName) {
			System.out.println(entry.getKey()+"- "+entry.getValue());
		}
	}
}
