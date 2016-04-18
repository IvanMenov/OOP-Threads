package threads;

import java.util.concurrent.Callable;

public class FourthPart extends WholePart {
	private Integer numberCommasFourth=0;
	
	FourthPart(ExtractText text) {
		super(text);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		for (int i = 0; i < this.getText().getFourthPart().length(); i++) {
			if(this.getText().getFourthPart().charAt(i)==','){
				numberCommasFourth++;
			}
		}
	}
	@Override
	Integer getNumberOfCommas() {
		// TODO Auto-generated method stub
		return this.numberCommasFourth;
	}

}
