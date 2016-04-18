package threads;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExtractText{
	
	private StringBuilder firstPart;
	private StringBuilder secondPart;
	private StringBuilder thirdPart;
	private StringBuilder fourthPart;
	private StringBuilder fifthPart;
	private StringBuilder wholeText;
	
	public ExtractText(StringBuilder firstPart, StringBuilder secondPart, StringBuilder thirdPart,
			StringBuilder fourthPart, StringBuilder fifthPart,StringBuilder wholeText) {
		this.firstPart = firstPart;
		this.secondPart = secondPart;
		this.thirdPart = thirdPart;
		this.fourthPart = fourthPart;
		this.fifthPart = fifthPart;
		this.wholeText=wholeText;
	}

	public StringBuilder getWholeText() {
		return wholeText;
	}

	public StringBuilder getFirstPart() {
		return firstPart;
	}

	public StringBuilder getSecondPart() {
		return secondPart;
	}

	public StringBuilder getThirdPart() {
		return thirdPart;
	}

	public StringBuilder getFourthPart() {
		return fourthPart;
	}

	public StringBuilder getFifthPart() {
		return fifthPart;
	}
}
