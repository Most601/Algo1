package PartC;

import java.util.Stack;

import UtilsPack.ArrayProvider;

public class ArrayMaxAndStack {
	
	MaxAndStack[] mas;
	
	private Stack<Integer> stackOfMax1;
	private Integer max1;
	private Integer max2;
	private Integer recursiveCounter;
	
	//region Constructors
	/**
	 * Constructor 
	 */
	public ArrayMaxAndStack() {
		ArrayProvider ap = ArrayProvider.getInstance();
		
		this.mas = new MaxAndStack[ap.getArrSize()];
		for (int i = 0; i < ap.getArrSize(); i++) {
			this.mas[i] = new MaxAndStack(ap.getArr()[i]);
		}
		this.recursiveCounter = 0;
		this.stackOfMax1 = new Stack<Integer>();
	}
	//end-region Constructors
	
	
	public int setAndGetMax1() {

		//  ==========================
		// === enter your code here ===
		//  ==========================
		
		this.max1 = /*replace this*/ -1;
		this.stackOfMax1.addAll(/*replace this*/ null);
		return this.max1;
	}
	
	public int setAndGetMax2() {
		int max2 = /*replace this*/ -1;
		
		//  ==========================
		// === enter your code here ===
		//  ==========================
		
		this.max2 = max2;
		return this.max2;
	}
	
	public String toString() {
		String str = "";
		
		if (this.max1 != null) {
			str = str + "the max1 is: " + this.max1 + "\n";
		}
		if (this.max2 != null) {
			str = str + "the max2 is: " + this.max2 + "\n";
		}
		
		if (this.recursiveCounter != null) {
			str = str + "the Recursive counter is: " + this.recursiveCounter + "\n";
		}
		
		if (this.max1 != null || this.max2 != null) {
			str =	"\n===========================================================\n"
					+ str +
					"\n===========================================================\n";
		}
		
		return str;
	}
	
}
