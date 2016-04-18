import java.util.ArrayList;
import java.util.List;

public class Klient implements Runnable{
	
	private Store magazin;
	private List<Product> list= new ArrayList<Product>();
	
	public Klient(Store store) {
		this.setStore(store);
		list= store.getListOfProducts();
	}
	public void setStore(Store magazin){
		if(magazin!=null){
			this.magazin=magazin;
		}
	}
	@Override
	public void run() {
		while(true){
			while(magazin.isQuantityLow()){
				synchronized(magazin){
					try {
						magazin.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
						return;
					}
				}
			}
			magazin.takeAwayGoods(list.get((int)(Math.random()*list.size())), (int)(Math.random()*(4)+1));
			synchronized(magazin){
				magazin.notifyAll();
			}
		}
	}
}
