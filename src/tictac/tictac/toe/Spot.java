package tictac.tictac.toe;

public class Spot {
	public enum Status{
		EMPTY,
		X,
		O
	 };
	 
	 Status status;
	 
	 public Spot(){
		 status = Status.EMPTY;
	 }
}
