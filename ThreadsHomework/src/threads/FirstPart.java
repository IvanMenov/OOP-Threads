package threads;

import java.util.concurrent.Callable;

public class FirstPart extends WholePart {
	private Integer numberCommasFirst=0;
	
	public FirstPart(ExtractText text) {
		super(text);
	}
	
	
	@Override
	public void run() {
		for (int i = 0; i < this.getText().getFirstPart().length(); i++) {
			if(this.getText().getFirstPart().charAt(i)==','){
				numberCommasFirst++;
			}
		}
	}
	@Override
	Integer getNumberOfCommas() {
		
		return this.numberCommasFirst;
	}

	
}
