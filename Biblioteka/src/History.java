import java.time.LocalDateTime;

public class History {
	private LocalDateTime whenIsItTaken;
	private LocalDateTime whenIsItBroughtBack;
	
	public History(LocalDateTime time) {
		if(time!=null)
		this.whenIsItTaken= time;
	}
	public void addTimeWhenItISBroughtBack(LocalDateTime time){
		if(time!=null ){
			this.whenIsItBroughtBack=time;
		}
	}
	public LocalDateTime getWhenIsItTaken() {
		return whenIsItTaken;
	}
	public LocalDateTime getWhenIsItBroughtBack() {
		return whenIsItBroughtBack;
	}
	
}
