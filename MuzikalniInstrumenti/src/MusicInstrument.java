

public abstract class MusicInstrument {
	private String name;
	private int price;
	private String type;
	
	public MusicInstrument(String name, int price, String type) throws IllegalNameException,IllegalPriceException{
		this.setName(name);
		this.setPrice(price);
		this.setType(type);
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		if(type!=null)
		this.type = type;
	}
	@Override
	public String toString() {
		return "name=" + name + ", price=" + price + ", type=" + type + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) throws IllegalNameException {
		if(name!=null ){
			this.name = name;
		}else{
			throw new IllegalNameException("Not a valid name.");
		}
				
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) throws IllegalPriceException{
		if(price>0){
			this.price = price;
		}else{
			throw new IllegalPriceException("Not a valid price.");
		}
	}
	@Override
	public boolean equals(Object obj) {
		MusicInstrument instr= null;
		if(obj instanceof MusicInstrument){
			instr=(MusicInstrument)obj;
		}
		return this.getName().equals(instr.getName());
	}
	@Override
	public int hashCode() {
	
		return	this.getName().hashCode();
	}
}	
