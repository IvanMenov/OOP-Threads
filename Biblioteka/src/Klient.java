import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Klient implements Runnable{
	private Biblioteka biblioteka;
	private List<Chetivo> chetiva= new ArrayList<>();
	
	public Klient(Biblioteka biblioteka) {
		if(biblioteka!=null)
		this.biblioteka=biblioteka;
		chetiva= biblioteka.getChetiva();
	}
	
	@Override
	public void run() {
		while(true){
			Chetivo chet= chetiva.get((int)(Math.random()*chetiva.size()));
			this.takeBook(chet);
			System.out.println("Reading the "+chet);
			try {
				Thread.sleep((int)(Math.random()*4000));
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
			try {
				this.giveBack(chet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	public void takeBook(Chetivo chetivo){
		if(chetivo!=null){
			biblioteka.takeSthToRead(chetivo,LocalDateTime.now());
		}
	}
	public void giveBack(Chetivo chetivo) throws Exception{
		if(chetivo!=null){
		LocalDateTime time= LocalDateTime.now();
		biblioteka.returnChetivo(chetivo, time);
		}
	}
}
