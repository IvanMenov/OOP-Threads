import java.util.ArrayList;
import java.util.List;

public class Store extends WareHouse implements Runnable{
	private static final int NUMBER_OF_GOOD_TO_TAKE_FROM_THE_WAREHOUSE = 10;
	private WareHouse sklad;
	
	@Override
	public void run() {
		while(true){
			while(sklad.isQuantityLow()){
				synchronized(sklad){
					try {
						sklad.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
						return;
					}
				}
			}
			sklad.takeAwayGoods(this.productQuantityLow(), NUMBER_OF_GOOD_TO_TAKE_FROM_THE_WAREHOUSE);
			
		}
	}
}
