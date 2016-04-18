import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class Book extends Chetivo implements Comparable<Book>{
	private String autor;
	private LocalDate publishingDate;
	
	
	public Book(String name, String izdatelstvo,String autor) {
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
	public LocalDate getPublishingDate() {
		return publishingDate;
	}
	public void setPublishingDate(LocalDate publishingDate) {
		if(publishingDate!=null)
		this.publishingDate = publishingDate;
	}
	
	@Override
	public int compareTo(Book o) {
		
		return this.getPublishingDate().compareTo(o.getPublishingDate());
	}
	@Override
	public double getMaxTimeToBeTaken() {
		return 3;
	}

	@Override
	public boolean isThischetivoSpisanie() {
		return false;
	}

	@Override
	public String toString() {
		return "Book [autor=" + autor + ", publishingDate=" + publishingDate + ", getName()=" + getName()
				+ ", getIzdatelstvo()=" + getIzdatelstvo() + "]";
	}
	@Override
	public int getPrice() {
	
		return 2;
	}

	

	
}
