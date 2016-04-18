import java.util.ArrayList;
import java.util.List;

public class Demo {
	public static void main(String[] args) {
		PostÎffice post= PostÎffice.setUpAPost();
		List<PostBox> boxes = new ArrayList<PostBox>();
		for (int i = 1; i <= 25; i++) {
			boxes.add(new PostBox());
		}
		Citizen chovek= new Citizen("Teodor", "Petrov");
		chovek.setPost(post);
		chovek.setBoxes(boxes);
		
		PostMan poshtadjiq= new PostMan("Gosho", "Ot pochivka", 5,post);
		Collector subirach = new Collector("Subirachko"	, "Subranichkov", post, boxes);
		
		Thread threadChovek= new Thread(chovek);
		Thread threadPoshtadjiq= new Thread(poshtadjiq);
		Thread threadSubirach= new Thread(subirach);
		
		threadChovek.start();
		threadSubirach.start();
		threadPoshtadjiq.start();
		
		
	}
}
