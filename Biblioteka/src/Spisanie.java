import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;

public class Spisanie extends Chetivo implements Comparable<Spisanie>{
	
	private int editionNumber;
	private LocalDate publishingDate;
	
	public Spisanie(String name, String izdatelstvo) {
		super(name, izdatelstvo);
		
	}
	
	public int getEditionNumber() {
		return editionNumber;
	}

	public void setEditionNumber(int editionNumber) {
		if(editionNumber>0)
		this.editionNumber = editionNumber;
	}

	public LocalDate getPublishingDate() {
		return publishingDate;
	}

	public void setPublishingDate(LocalDate publishingDate) {
		if(publishingDate!=null)
		this.publishingDate = publishingDate;
	}

	@Override
	public int compareTo(Spisanie o) {
		if((this.getName().compareTo(o.getName()))==0){
			return this.getEditionNumber()-o.getEditionNumber();
		}
		return this.getName().compareTo(o.getName());
	}
	@Override
	public double getMaxTimeToBeTaken(){
		return 0;
	}

	@Override
	public boolean isThischetivoSpisanie() {
		
		return true;
	}

	@Override
	public String toString() {
		return "Spisanie [editionNumber=" + editionNumber + ", publishingDate=" + publishingDate + ", getName()="
				+ getName() + ", getIzdatelstvo()=" + getIzdatelstvo() + "]";
	}

	@Override
	public int getPrice() throws Exception {
		
		 throw new Exception("Loshoo");
	}
}
