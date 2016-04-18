
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class WareHouse extends TurgovskiObekt implements Runnable{
	
	private static final int DELIVERY_OF_GOODS_TO_THE_STORE = 10;
	private Store magazin;
	
	@Override
	public void run() {
		while(true){
			while(!magazin.isQuantityLow()){
				synchronized(magazin){
					try {
						magazin.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
						return;
					}
				}
			}
			magazin.deliveryOfGoods(DELIVERY_OF_GOODS_TO_THE_STORE);
			synchronized(magazin){
				magazin.notifyAll();
			}
		}
		
	}

	public Store getMagazin() {
		return magazin;
	}

	public void setMagazin(Store magazin) {
		if(magazin!=null)
		this.magazin = magazin;
	}
	
	
}
