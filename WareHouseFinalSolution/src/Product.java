
public class Product {
	private String name;
	
	Product(String name){
		if(name!=null && !name.equals("")){
			this.name=name;
		}
	}
	public String getName(){
		return this.name;
	}
	
	@Override
	public boolean equals(Object obj) {
			Product p= null;
			if(obj instanceof Product) {
				p  = (Product) obj;
				
			}
		return this.name.equals(p.name);
	}
	
	@Override
	public int hashCode() {
	
		return this.name.hashCode();
	}
}
