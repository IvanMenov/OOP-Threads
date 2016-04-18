import java.util.List;

import javax.swing.text.Position;

public class PostMan extends Citizen{
	private int yearsOfExperience;
	private int howManyMailCanICarry=5;
	
	PostMan(String name, String surname, int years,PostÎffice post)  {
		super(name, surname);
		this.setPost(post);
		this.setYears(years);
	}
	public void setYears(int years){
		if(years>0){
			this.yearsOfExperience=years;
		}
	}
	public int getYears(){
		return this.yearsOfExperience;
	}
	
	@Override
	public void run() {
		while(true){
		while(this.getPost().areMailNumberLessThanFifty()){
			System.out.println("V hranilishteto ima po-malko ot 50 kuleta/pisma.Shte pochakam da se nasuberat.");
			synchronized (this.getPost()) {
				try {
					this.getPost().wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				}
			}
		}
		for (int i = 0; i <= this.howManyMailCanICarry; i++) {
			try {
				this.getPost().takeMailToFromStorage();
				System.out.println("Vzeh nqkolko pisma/kuleta.Sega shte gi razpratq nalqvo-nadqsno.");
				synchronized (this.getPost()) {
					this.getPost().notifyAll();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		}
	}
}
