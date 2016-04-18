import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PostBox {
	private List<MailObject> objects= new CopyOnWriteArrayList<MailObject>() ;
	
	public void addLetter(MailObject object){
		if(object!=null){
			if(object.isLetter()==true)
			objects.add(object);
			System.out.println("Pismoto beshe dobaveno.");
		}
	}
	
	public List<MailObject> takeLetters(){
		List<MailObject> list= objects;
		System.out.println("Vzimam pismata ot tazi poshtenskata kutiq.");
		return list;
	}
}
