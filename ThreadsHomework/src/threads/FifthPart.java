package threads;

public class FifthPart extends WholePart {
	private Integer numberCommasFifth=0;
	FifthPart(ExtractText text) {
		super(text);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		for (int i = 0; i < this.getText().getFifthPart().length(); i++) {
			if(this.getText().getFifthPart().charAt(i)==','){
				numberCommasFifth++;
			}
		}
	}
	@Override
	Integer getNumberOfCommas() {
		
		return this.numberCommasFifth;
	}
}
