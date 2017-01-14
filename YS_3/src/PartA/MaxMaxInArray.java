package PartA;


import UtilsPack.ArrayProvider;

public class MaxMaxInArray {
	// Bone variables for Regular Counter
	private int regularCounter;
	private Integer max1InRegular;
	private Integer max2InRegular;
	
	// Bone variables for One And Half Counter
	private int oneAndHalfCounter;
	private Integer max1InOneAndHalf;
	private Integer max2InOneAndHalf;
	
	private ArrayProvider ap;
	
	/**
	 * Constructor - Init the ArrayProvider
	 */
	public MaxMaxInArray() {
		this.ap = ArrayProvider.getInstance();
	}
	
	//region SetAndGet
	public int setAndGetRegularCounter() {
		int arr[] = ap.getArr();
		int countOfStep = 0;
		int max1 = arr[0];
		int max2 = arr[1];
		countOfStep++;
		if ( max1 > max2 ){
			max1 = arr[1];
			max2 = arr[0];
		}
		for (int i = 2; i < arr.length; i++) {
			countOfStep++;
			if (arr[i] > max1 ){
				max2 = max1;
				max1 = arr[i];
			}
			else {
				countOfStep++;
				if (arr[i]> max2){
					max2 = arr[i];
				}
			}
		}
		//  ==========================
		// === enter your code here ===
		//  ==========================
		
		
		this.max1InRegular = max1;
		this.max2InRegular = max2;
		this.regularCounter = countOfStep;
		return countOfStep;
	}
	
	public int setAndGetOneAndHalfCounter() {
		int arr[] = ap.getArr();
		int countOfStep = 0;
		int max1 = arr[0];
		int max2 = arr[1];
		countOfStep++;
		if ( max1 > max2 ){
			max1 = arr[1];
			max2 = arr[0];
		}
		for (int i = 2; i < arr.length-1; i+=2) {
			countOfStep++;
			if (arr[i] > arr[i+1]){
				countOfStep++;
				if (arr[i] > max1 ){
					countOfStep++;
					if(arr[i+1]> max1 ){
						max1 = arr[i];
						max2 = arr[i+1];
					}
					else {
						max2 = max1;
						max1 = arr[i];
						countOfStep++;
					}
				}
			
				else {
					countOfStep++;
					if( arr[i]> max2)max2 = arr[i];
				}
				
			}
			else {
				countOfStep++;
				if (arr[i+1] > max1 ){
					countOfStep++;
					if ( arr[i] > max1 ){
						max1 = arr[i+1];
						max2 = arr[i];
					}
					else {
						max2 = max1;
						max1 = arr[i+1];
					}
				
				}
				
				else {
					countOfStep++;
					if( arr[i+1]> max2)max2 = arr[i+1];
				}
			}
			
		}
		
		if(arr.length%2 == 1 ){
			countOfStep++;
			if (arr[arr.length-1] > max1 ){max2 = max1 ; max1 = arr[arr.length-1] ; } 
			else {
				countOfStep++;
				if (arr[arr.length-1] > max2 ) max2 = arr[arr.length-1];
			}
		}
		
		//  ==========================
		// === enter your code here ===
		//  ==========================
		
		this.max1InOneAndHalf = max1;
		this.max2InOneAndHalf = max2;
		this.oneAndHalfCounter = countOfStep;
		return countOfStep;
	}
	//end-region SetAndGet
	
	public String toString() {
		String str = "";
		str = str + "\n===========================================================\n";
		
		if (this.max1InRegular != null) {
			str = str + "regular function:    max1 -> " + this.max1InRegular + ", max2 -> " + this.max2InRegular + "\n";
			str = str + "the regular counter is:    " + this.regularCounter + "\n";
			str = str + "\n===========================================================\n";
		}
		if (this.max1InOneAndHalf != null) {
			str = str + "OneAndHalf function: max1 -> " + this.max1InOneAndHalf + ", max2 -> " + this.max2InOneAndHalf + "\n";
			str = str + "the OneAndHalf counter is: " + this.oneAndHalfCounter + "\n";
			str = str + "\n===========================================================\n";
		}
		return str;
	}
	
}
