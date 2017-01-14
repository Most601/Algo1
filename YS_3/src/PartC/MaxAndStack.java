package PartC;

import java.util.Stack;

public class MaxAndStack {
	
	private int max1;
	private Stack<Integer> stackOfSmaller;
	
	//region Constructors
		/**
		 * Constructor 
		 * @param data data of the Node
		 */
		public MaxAndStack(int max1) {
			this.max1 = max1;
			this.stackOfSmaller = new Stack<Integer>();
		}
		/**
		 * Copy Constructor 
		 * @param n the Node We want to copy
		 */
		public MaxAndStack(MaxAndStack mas) {
			this.max1 = mas.max1;
			// Look at: http://stackoverflow.com/questions/7919836/how-do-i-copy-a-stack-in-java
			//this.stackOfSmaller = (Stack<Integer>) mas.stackOfSmaller.clone();
			this.stackOfSmaller = new Stack<Integer>();
			if (!mas.stackOfSmaller.isEmpty()) this.stackOfSmaller.addAll(mas.stackOfSmaller);
		}
		//end-region Constructors
		
		//region GETTERS
		/**
		 * @return the Data of the Node
		 */
		public int getMax1() {
			return this.max1;
		}
		/**
		 * @return the Stack of the Node
		 */
		public Stack<Integer> getStack(){
			return this.stackOfSmaller;
		}
		//end-region GETTERS
		
		//region SETTERS
		/**
		 * @param data set the Node Data with 'data'
		 */
		public void setMax1(int max1) {
			this.max1 = max1;
		}
		//end-region SETTERS
		
		/**
		 * @param item push the item to the Stack
		 */
		public void addToStack(int item) {
			this.stackOfSmaller.push(item);
		}
}
