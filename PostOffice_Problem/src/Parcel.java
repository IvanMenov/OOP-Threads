
public class Parcel extends MailObject{
	
	private static final int TIME_TO_DELIVER = 1500;
	private static final int REGULAR_FEE = 2;
	private static final double FEE_IF_FRAGILE_AND_BIGGER = 4.5;
	private static final int FEE_IF_FRAGILE_OR_BIGGER = 3;
	private int height;
	private int length;
	private int width;
	private boolean isFragile;
	
	Parcel(Citizen giver, Citizen taker,int height, int width, int length, boolean isFragile){
		this.setFragile(isFragile);
		this.setGiver(giver);
		this.setTaker(taker);
		this.setHeight(height);
		this.setLength(length);
		this.setWidth(width);
	}
	
	
	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		if(height>0)
		this.height = height;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		if(length>0)
		this.length = length;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		if(width>0)
		this.width = width;
	}


	public boolean isFragile() {
		return isFragile;
	}


	public void setFragile(boolean isFragile) {
		this.isFragile = isFragile;
	}


	@Override
	public double fee() {
		if(this.isFragile==true){
		return FEE_IF_FRAGILE_OR_BIGGER;
		}
		if(this.getHeight()>60 || this.getLength()>60 || this.getWidth()>60){
			return FEE_IF_FRAGILE_OR_BIGGER;
		}
		if((this.isFragile==true) && (this.getHeight()>60 || this.getLength()>60 || this.getWidth()>60)){
			return FEE_IF_FRAGILE_AND_BIGGER;
		}
		return REGULAR_FEE;
	}

	@Override
	public int timeItTakesToDeliver() {
		return TIME_TO_DELIVER;
	}


	@Override
	public boolean isLetter() {
		
		return false;
	}

}
