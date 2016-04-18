package threads;

import java.util.concurrent.Callable;

public class FourthPartPool implements Callable<Integer>{
	private StringBuilder fourthPart;
	private Integer commas=new Integer(0);
	
	public  FourthPartPool(StringBuilder text) {
		this.fourthPart=text;
	}
	@Override
	public Integer call() throws Exception {
		for (int i = 0; i < fourthPart.length(); i++) {
			if(fourthPart.charAt(i)==','){
				commas++;
			}
		}return commas;
	}
}
