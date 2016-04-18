import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public abstract class TurgovskiObekt {
	private Map<TypeOfProduct,Map<Product,Integer>> producti= new ConcurrentHashMap<TypeOfProduct,Map<Product,Integer>>();
	private static final int TAKEAWAY_GOODS = 5;	
	private static final int MIN_QUNATITY=5;
	
	public TurgovskiObekt() {
		Map<Product,Integer> fruits= new HashMap<Product,Integer>();
		Map<Product,Integer> vegetables= new HashMap<Product,Integer>();
		Map<Product,Integer> meats= new HashMap<Product,Integer>();
		
		String[] array= {"Banana","Orange","Apple","Potato","Eggplant","Cucumber","Pork","Beef","Chicken"};
		for (int i = 0; i < array.length; i++) {
			if(i<3){
			fruits.put(new Product(array[i]), 15);
			}
			if(i==2){
			producti.put(TypeOfProduct.Fruits, fruits);
			}
			if(i<6){
				vegetables.put(new Product(array[i]), 15);
			}
			if(i==5){
				producti.put(TypeOfProduct.Vegetables, vegetables);
			}
			if(i<9){
				meats.put(new Product(array[i]), 15);
			}
			if(i==array.length-1){
				producti.put(TypeOfProduct.Meats, meats);
			}
		}
	}
	public List<Product> getListOfProducts(){
		List<Product> list= new ArrayList<Product>();
		for (Entry<TypeOfProduct, Map<Product, Integer>> entry : producti.entrySet()) { 
			for (Entry<Product,Integer> entry2 : entry.getValue().entrySet()) {
				list.add(entry2.getKey());
			}
		}
		return Collections.unmodifiableList(list);
	}
	
	public void takeAwayGoods(Product prod, int quantity){
		if(prod!=null && quantity>0){
			for (Entry<TypeOfProduct, Map<Product, Integer>> entry : producti.entrySet()) {
				for (Entry<Product,Integer> product : entry.getValue().entrySet()) {
					if(prod.equals(product.getKey())){
						product.setValue(product.getValue()-quantity);
					}
				}
			}
		}
	}
	public void deliveryOfGoods(int quantity){
		if(quantity>0){
		Product p = productQuantityLow();
		for (Entry<TypeOfProduct, Map<Product, Integer>> entry : producti.entrySet()) {
			for (Entry<Product,Integer> product : entry.getValue().entrySet()) {
				if(p.equals(product.getKey())){
					product.setValue(product.getValue()+quantity);
				}
			}
		}
		}
	}
	
	public Product productQuantityLow(){
		
		for (Entry<TypeOfProduct, Map<Product, Integer>> entry : producti.entrySet()) {
			for (Entry<Product,Integer> product : entry.getValue().entrySet()) {
				if(product.getValue()<MIN_QUNATITY){
					return product.getKey();
				}
			}
		}return null;
	}
	public boolean isQuantityLow(){
		for (Entry<TypeOfProduct, Map<Product, Integer>> entry : producti.entrySet()) {
			for (Entry<Product,Integer> product : entry.getValue().entrySet()) {
				if(product.getValue()<MIN_QUNATITY){
					return true;
				}
			}
		}return false;
	}
}
