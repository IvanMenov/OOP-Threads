import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Citizen implements Runnable{
	public static final int NUMBER_POSTBOXES = 25;
	private final String name;
	private final String surname;
	private  String address;
	private List<PostBox> boxes=new ArrayList<>();
	private PostÎffice post;
	
	
	Citizen( String name,  String surname) {
		if(name!=null && surname!=null ){
		this.name=name;
		this.surname=surname;
		}	
		else{
			this.name="Ivan";
			this.surname="Petkov";
		}
		
	}
	public void setBoxes(List<PostBox> boxes){
		if(boxes!=null){
			this.boxes=boxes;
		}
	}
	public PostBox getABox(int index){
		for (int i = 0; i < this.boxes.size(); i++) {
			if(index==i){
				return this.boxes.get(index);
			}
		}
		return null;
	}
	@Override
	public void run() {
		MailObject mail=null;
		while(true){
			double random= Math.random();
			if(random>0.5){
				System.out.println("Shte izpratq pismo v poshtenskata kuiq");
				mail= new Letter(this,new Citizen("Iliq", "Stamatov"));
				try {
					this.addLetterToPostBox(mail);
				} catch (NotLetterException e) {
					e.printStackTrace();
				}
			}else{
				double randomSec=Math.random();
				if(randomSec>0.5){
					System.out.println("Shte izpratq kulet v poshtata.");
				mail= new Parcel(new Citizen("Iliq", "Petkov"), new Citizen("Goshko","Georgiev"), 20, 30, 50, true);
				}
				else{
					System.out.println("Shte izpratq pismo napravo v poshtata.");
					mail= new Letter(new Citizen("Ivan", "Petkov"),new Citizen("Iliq", "Stamatov"));
				}
				this.addMailToPost(mail);
			}
		}	 
		
	}
	
	
	public void addLetterToPostBox(MailObject mail) throws NotLetterException{
		if(mail!=null){
			if(mail.isLetter()==true){			
			int randomBox= (int)(Math.random()*NUMBER_POSTBOXES);
			System.out.println("Izprashtam pismoto v poshtenska kutiq # "+randomBox);
			this.boxes.get(randomBox).addLetter(mail);
			}else{
				throw new NotLetterException("This is not a letter.");
			}
		}
	}
	
	public void addMailToPost(MailObject object){
		if(object!=null){
			post.addToStorageAndArchive(object);
		}
	}
	public void setPost(PostÎffice post){
		if(post!=null){
			this.post=post;
		}
	}
	public PostÎffice getPost(){
		return this.post;
	}
	
	public String getName() {
		return name;
	}


	public String getSurname() {
		return surname;
	}


	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		if(address!=null)
		this.address = address;
	}

	
}

