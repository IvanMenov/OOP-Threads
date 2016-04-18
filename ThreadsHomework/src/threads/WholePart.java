package threads;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class WholePart implements Runnable {
	private ExtractText text;
	private Integer numberCommasInTheWholeText=0;
	WholePart(ExtractText text){
		if(text!=null){
		this.text= text;
		}
	}
	ExtractText getText(){
		return this.text;
	}
	
	@Override
	public void run() {
		LocalDateTime start = LocalDateTime.now();
		for (int i = 0; i < text.getWholeText().length(); i++) {
			if(text.getWholeText().charAt(i)==','){
				numberCommasInTheWholeText++;
			}
		}
		System.out.println("Commas in the whole text:"+numberCommasInTheWholeText);
		LocalDateTime end = LocalDateTime.now();
		long difference=  Duration.between(start, end).toMillis();
		System.out.println("Duration in milisecond for 1 thread: "+ difference);
	}
	Integer getNumberOfCommas(){
		return this.numberCommasInTheWholeText;
	}
	}
