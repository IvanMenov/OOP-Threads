import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Uchebnik extends Chetivo implements Comparable<Uchebnik>{
	private String autor;
	public static final int PRICE= 3;
	
	public Uchebnik(String name, String izdatelstvo,String autor) {
		super(name, izdatelstvo);
		this.setAutor(autor);
	}
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		if(autor!=null)
		this.autor = autor;
	}
	
	
	@Override
	public int compareTo(Uchebnik o) {
		
		return this.getName().compareTo(o.getName());
	}
	@Override
	public double getMaxTimeToBeTaken() {		
		return 1.5;
	}

	@Override
	public boolean isThischetivoSpisanie() {
		return false;
	}

	@Override
	public String toString() {
		return "Uchebnik [autor=" + autor + ", getName()=" + getName() + ", getIzdatelstvo()=" + getIzdatelstvo() + "]";
	}

	@Override
	public int getPrice() {
		
		return 3;
	}	
}	
