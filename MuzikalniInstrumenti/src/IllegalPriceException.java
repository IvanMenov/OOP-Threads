
public class IllegalPriceException extends Exception {

	private static final long serialVersionUID = -6551969978468464142L;
	
	public IllegalPriceException(){
		
	}
	public IllegalPriceException(String text,Throwable cause){
		super(text,cause);
	}
	public IllegalPriceException(Throwable cause){
		super(cause);
	}
	public IllegalPriceException(String text){
		super(text);
	}
}
