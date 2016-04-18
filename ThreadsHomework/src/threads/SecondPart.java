package threads;
import java.util.concurrent.Callable;

public class SecondPart extends WholePart {
	private Integer numberCommaSecond=0;
	
	SecondPart(ExtractText text) {
		super(text);
	}

	@Override
	public void run() {
		for (int i = 0; i < this.getText().getSecondPart().length(); i++) {
			if(this.getText().getSecondPart().charAt(i)==','){
				numberCommaSecond++;
			}
		}
	}
	@Override
	Integer getNumberOfCommas() {
		// TODO Auto-generated method stub
		return this.numberCommaSecond;
	}

	
}
