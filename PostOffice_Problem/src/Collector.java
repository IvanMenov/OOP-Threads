import java.util.List;

public class Collector extends Citizen implements Runnable{
	
	Collector(String name, String surname, PostÎffice post, List<PostBox> box) {
		super(name, surname);
		this.setPost(post);
		this.setBoxes(box);
	}
	
	@Override
	public void run() {
		while(true){
		while(!this.getPost().areMailNumberLessThanFifty()){
			System.out.println("Pismata v hranilishteto sa poveche ot 50. Shte izchakam.");
			synchronized (this.getPost()) {
				try {
					this.getPost().wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				}
			}
		}
		List<MailObject> list= this.getABox((int)(Math.random()*Citizen.NUMBER_POSTBOXES)).takeLetters();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return;
		}
			for (int i = 0; i < list.size(); i++) {
				this.getPost().addToStorageAndArchive(list.get(i));
				System.out.println("Dobavqm vzetite pisma v hranilishteto.");
				synchronized (this.getPost()) {
					this.getPost().notifyAll();
				}
			}
		
		}
	}
}
