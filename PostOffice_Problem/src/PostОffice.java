import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.text.html.MinimalHTMLWriter;

import org.omg.CORBA.LocalObject;

public class PostÎffice {
	
	private static final int CRITICAL_NUMBER_OF_MAIL_IN_STORAGE = 50;
	private static PostÎffice onlyPost;
	private BlockingQueue<MailObject> storage;
	private Map<LocalDate, List<MailObject>> archive;
	
	
	private PostÎffice(){
		
		storage =new LinkedBlockingQueue<MailObject>();
		archive = new ConcurrentSkipListMap<LocalDate, List<MailObject>>();
		
	}
	
	public static PostÎffice setUpAPost(){
		if(onlyPost==null){
			onlyPost = new PostÎffice();
		}
		return onlyPost;
	}
	public void addToStorageAndArchive(MailObject obj){
		if(obj!=null){
			storage.add(obj);
			if(!archive.containsKey(LocalDate.now())){
				archive.put(LocalDate.now(), new ArrayList<MailObject>());
			}
			else{
				archive.get(LocalDate.now()).add(obj);
			}
			System.out.println(obj.getClass()+" beshe dobaven v hranilishteto i v arhiva.");
		}
	}
	public void takeMailToFromStorage() throws InterruptedException{
		MailObject mail= storage.take();
		System.out.println(mail.timeItTakesToDeliver()+" sec. will take to deliver.");
		
	}
	public boolean areMailNumberLessThanFifty(){
		synchronized (storage) {
			if(storage.size()<CRITICAL_NUMBER_OF_MAIL_IN_STORAGE){
				return true;
			}
			return false;
		}		
	}
	public List<MailObject> getAllMailByDate(LocalDate date){
		List<MailObject> list= new ArrayList<MailObject>();
		for (LocalDate datelocal : archive.keySet()) {
			if(datelocal.isEqual(date)){
				list.addAll(archive.get(datelocal));
			}
		}
		return list;
	}
	public double findPercentageOfLettersInAllMailForTheDay(){
		int counter =0;
		List<MailObject> list= new ArrayList<>();
		LocalDate date= LocalDate.now();
		for (LocalDate data : archive.keySet()) {
			if(data.equals(date)){
				list.addAll(archive.get(data));
			}
		}
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) instanceof Letter){
				counter++;
			}
		}
		return (counter/list.size())/100;
	}
	public int countFragileParcels(){
		List<MailObject>list= new ArrayList<>();
		int count=0;
		list.addAll(storage);
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) instanceof Parcel){
				Parcel p= (Parcel)list.get(i);
				if(p.isFragile()){
					count++;
				}
			}
		}
		return count;
	}
}
