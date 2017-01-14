package Donuts;

public class DonutsProblem {
	private static final int time = 2;
	
	/**
	 * returns the total time for the daunts
	 * Complexity: O(1)
	 */
	public static int getTime(int numOfDonuts,int capacity) {
		if(capacity >= numOfDonuts) return time*numOfDonuts;
		if((time*numOfDonuts)%capacity == 0) return time*numOfDonuts;
		return time*numOfDonuts + 1;
	}
}
