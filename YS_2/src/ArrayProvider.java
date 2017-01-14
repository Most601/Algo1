
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class ArrayProvider {

	// the Singleton Object
	private static ArrayProvider arrayProvider;
	
	private int[] arr; 
	
	private Map<Integer, Integer> mapOfBiggest; 
	private Map<Integer, Integer> mapOfSmallest;
	
	// this is hard-coded, Be careful: size must to be bigger than (max - min)
	private final int size = 100;
	private final int minValue = 100;
	private final int maxValue = 1000;
	
	/**
	 * Private Default Constructor
	 * ==== Singleton Pattern ==== 
	 */
	private ArrayProvider() {
		//this.arr = new Random().ints(minValue, maxValue).distinct().limit(size).toArray();
		
		
		final Random random = new Random();
		final Set<Integer> intSet = new HashSet<>();
		while (intSet.size() < size) {
			intSet.add((random.nextInt(maxValue - minValue) + minValue));
		}
		this.arr = new int[intSet.size()];
		final Iterator<Integer> iter = intSet.iterator();
		for (int i = 0; iter.hasNext(); ++i) {
			this.arr[i] = iter.next();
		}
		
	}
	
	//region GETTERS
	public int[] getArr(){
		return this.arr;
	}
	public int getArrSize(){
		return size;
	}
	//end-region GETTERS
	
	/**
	 * @return a Singleton Object 
	 */
	public static ArrayProvider getInstance() {
		if (arrayProvider == null) {
			arrayProvider = new ArrayProvider();
		}
		return arrayProvider;
	}
	
	/**
	 * @param numOfBiggest the quantity of the biggest numbers in the Array 
	 * @return Map with the N biggest number in the Array (key = index)
	 */
	public Map<Integer, Integer> setAndGetBiggestNumbers(int numOfBiggest) {
		
		// copy to Object-Array (with nulls)
		Integer[] arrayWithNulls = new Integer[size];
		for (int i=0; i<size; i++) {
			arrayWithNulls[i] = this.arr[i];
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i=0; i<numOfBiggest; i++) {
			int startIndex = 0;
			while (arrayWithNulls[startIndex] == null) {
				startIndex++;
			}
			int innerMaxIndex = startIndex;
			int innerMax = arrayWithNulls[startIndex];
			for (int j=startIndex + 1; j<size; j++) {
				if (arrayWithNulls[j] != null && arrayWithNulls[j] > innerMax) {
					innerMax = arrayWithNulls[j];
					innerMaxIndex = j;
				}
			}
			map.put(innerMaxIndex, innerMax);
			arrayWithNulls[innerMaxIndex] = null; // when you find the biggest - null it!
		}
		
		this.mapOfBiggest = map;
		return map;
	}
	
	/**
	 * @return Map with the Smallest number in the Array (key = index)
	 */
	public Map<Integer, Integer> setAndGetSmallestNumber() {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int min = this.arr[0];
		int minIndex = 0;
		for (int i=0; i<size; i++) {
			if (this.arr[i] < min) {
				min = this.arr[i];
				minIndex = i;
			}
		}
		map.put(minIndex, min);
		
		this.mapOfSmallest = map;
		return map;
	}
	
	public String toString() {
		String str = "";
		if (size <= 8000) { // print Only 'small' Arrays
			for (int i=0; i<size; i++) {
				str =  str + "["+ Utils.getDigitPlusOne(i) + "]->" + this.arr[i] + "\t";
				if ((i+1) % 8 == 0) str = str +"\n"; 
			}
		}
		str = str + "\n===========================================================\n";
		if (this.mapOfSmallest == null) {
			str = str + "the Map Of Smallest is empty\n";
		} else {
			for (Map.Entry<Integer,Integer> entry : this.mapOfSmallest.entrySet()) {
				  int key = entry.getKey();
				  int value = entry.getValue();
				  str = str + "the index of minimum is:   ["+ key + "], and the value is: " + value + "\n";
			}
		}
		
		if (this.mapOfBiggest == null) {
			str = str + "the Map Of Biggest is empty\n";
		} else {
			int index = 1;
			this.mapOfBiggest = Utils.sortByValue(this.mapOfBiggest);
			
			for (Map.Entry<Integer,Integer> entry : this.mapOfBiggest.entrySet()) {
				  int key = entry.getKey();
				  int value = entry.getValue();
				  str = str + "the index of max No' "+ index +" is: ["+ key + "], and the value is: " + value + "\n";
				  index++;
			}
		}
		return str;
	}
}
