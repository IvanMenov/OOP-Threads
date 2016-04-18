
public class IllegalNameException extends Exception {

	private static final long serialVersionUID = -1809953551578092404L;
	
	public IllegalNameException(){
		
	}
	public IllegalNameException(String message, Throwable cause) {
		super(message, cause);
	}
	public IllegalNameException(String message) {
		super(message);
	}
	public IllegalNameException( Throwable cause) {
		super(cause);
	}
}
