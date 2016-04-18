import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Chetivo {
	private String name;
	private String izdatelstvo;
	private List<History> historyOfTakings= new ArrayList<History>();
	private boolean isTaken;

	public Chetivo(String name, String izdatelstvo) {
		this.setName(name);
		this.setIzdatelstvo(izdatelstvo);
		
	}
	
	public History lastDate(){
		if(!historyOfTakings.isEmpty()){
		return historyOfTakings.get(historyOfTakings.size()-1);
		}
		else {
			return null;
		}
	}
	public void putDateOfTakingInHistoryOfTakings(LocalDateTime time){
		if(time!=null)	{
			History history= new History(time);
			historyOfTakings.add(history);
		}
	}
	public void putDateOfBringingBackInHistory(LocalDateTime time){
		if(time!=null){
			History lastHistory=null;
			
			 lastHistory= historyOfTakings.get(historyOfTakings.size()-1);
			
			lastHistory.addTimeWhenItISBroughtBack(time);
		}
	}
	public abstract int getPrice() throws Exception;
	
	public abstract boolean isThischetivoSpisanie();
	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name!=null && !name.equals(""))
		this.name = name;
	}

	public String getIzdatelstvo() {
		return izdatelstvo;
	}

	public void setIzdatelstvo(String izdatelstvo) {
		if(izdatelstvo!=null && !izdatelstvo.equals(""))
		this.izdatelstvo = izdatelstvo;
	}

	public abstract double getMaxTimeToBeTaken() ;
	
	
	public boolean isTaken() {
		return isTaken;
	}
	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}

	
		
}
