
public class MinMaxInArray {
	// Bone variables for Regular Counter
	private int regularCounter;
	private Integer minInRegular;
	private Integer maxInRegular;
	
	// Bone variables for One And Half Counter
	private int oneAndHalfCounter;
	private Integer minInOneAndHalf;
	private Integer maxInOneAndHalf;
	
	private ArrayProvider ap;
	
	/**
	 * Constructor - Init the ArrayProvider
	 */
	public MinMaxInArray() {
		this.ap = ArrayProvider.getInstance(); 
	}
	
	//region SetAndGet
	public int setAndGetRegularCounter() {
		int arr[] = ap.getArr();
		int countOfStep = 0;
		int max = arr[0];
		int min = arr[1];
		if ( arr[1] > arr[0]){
			countOfStep++;
			max = arr[1];
			min = arr[0];
		}
		for (int i = 2; i < arr.length; i++) {
			countOfStep++;
			if ( arr[i] > max){
				max = arr[i];
			}
			else {
				countOfStep++;
				if ( arr[i] < min ){
				min = arr[i];
				}
			}
			
		}
		
		
		this.maxInRegular = max;
		this.minInRegular = min;
		this.regularCounter = countOfStep;
		return countOfStep;
	}
	
	public int setAndGetOneAndHalfCounter() {
		int arr[] = ap.getArr();
		int countOfStep = 0;
		int max = arr[0];
		int min = arr[0];
	
		for (int i = 1; i < arr.length-1; i=i+2) {
			countOfStep++;
			if ( arr[i] > arr[i+1] ) {
				countOfStep++;
				if ( arr[i] > max ) {
					max = arr[i];
				}
				countOfStep++;
				if ( arr[i+1] < min ) {
					min = arr[i+1];
				
				}
			}
			else {
				countOfStep++;
				if ( arr[i+1] > max ) {
					max = arr[i+1];
				}
				countOfStep++;
				if ( arr[i] < min ) {
					min = arr[i];
				}
				
			}
			
		}
		if (arr.length%2 == 1 ){
			countOfStep++;
			  
			if (arr[arr.length-1] > max )max = arr[arr.length-1];
			else 
				countOfStep++;
				if (arr[arr.length-1] < min )min = arr[arr.length-1];
		}
		
		
		this.maxInOneAndHalf = max;
		this.minInOneAndHalf = min;
		this.oneAndHalfCounter = countOfStep;
		return countOfStep;
	}
	//end-region SetAndGet
	
	/**
	 * @param epsilon the size of unmistakable
	 * @return if the lecture's theory is correct
	 */
	public boolean checkRightness(double epsilon) {
		// your code...
		return true;
	}
	
	public String toString() {
		String str = this.ap.toString();
		str = str + "\n===========================================================\n";
		
		if (this.maxInRegular != null) {
			str = str + "regular function:    max -> " + this.maxInRegular + ", min -> " + this.minInRegular + "\n";
			str = str + "the regular counter is:    " + this.regularCounter + "\n";
			str = str + "\n===========================================================\n";
		}
		if (this.maxInOneAndHalf != null) {
			str = str + "OneAndHalf function: max -> " + this.maxInOneAndHalf + ", min -> " + this.minInOneAndHalf + "\n";
			str = str + "the OneAndHalf counter is: " + this.oneAndHalfCounter + "\n";
			str = str + "\n===========================================================\n";
		}
		return str;
	}
	
}
