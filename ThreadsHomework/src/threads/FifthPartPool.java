package threads;

import java.util.concurrent.Callable;

public class FifthPartPool implements Callable<Integer>{
	private StringBuilder fifthPart;
	private Integer commas=new Integer(0);
	
	public  FifthPartPool(StringBuilder text) {
		this.fifthPart=text;
	}
	@Override
	public Integer call() throws Exception {
		for (int i = 0; i <fifthPart.length(); i++) {
			if(fifthPart.charAt(i)==','){
				commas++;
			}
		}return commas;
	}

}
