
public class DeliveryGuy implements Runnable{
	private WareHouse sklad;
	private static final int DELIVERY_FROM_DELIVERYGUY = 25;
	public DeliveryGuy(WareHouse sklad) {
		if(sklad!=null){
			this.sklad=sklad;
			
		}
	}

	@Override
	public void run() {
		while(true){
		while(!sklad.isQuantityLow()){
			synchronized (sklad) {
				try {
					sklad.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				}
			}
		}sklad.deliveryOfGoods(DELIVERY_FROM_DELIVERYGUY);
		synchronized(sklad){
			sklad.notifyAll();
		}
	   }	
	}
}	
