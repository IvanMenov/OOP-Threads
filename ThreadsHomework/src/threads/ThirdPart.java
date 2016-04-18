package threads;
import java.util.concurrent.Callable;

public class ThirdPart extends WholePart {
	
	private Integer countCommasThird= 0;
	
	ThirdPart(ExtractText text) {
		super(text);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		for (int i = 0; i < this.getText().getThirdPart().length()	; i++) {
			if(this.getText().getThirdPart().charAt(i)==','){
				countCommasThird++;
			}
		}
	}
	@Override
	Integer getNumberOfCommas() {
		
		return this.countCommasThird;
	}

}
