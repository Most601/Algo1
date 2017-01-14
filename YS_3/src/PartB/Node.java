package PartB;

import java.util.Stack;

public class Node {
	private Node next;
	private Node prev;
	private int max1;
	private Stack<Integer> stackOfSmaller;
	
	//region Constructors
	/**
	 * Constructor 
	 * @param data data of the Node
	 */
	public Node(int max1) {
		this.next = null;
		this.prev = null;
		this.max1 = max1;
		this.stackOfSmaller = new Stack<Integer>();
	}
	/**
	 * Copy Constructor 
	 * @param n the Node We want to copy
	 */
	public Node(Node n) {
		this.next = n.next;
		this.prev = n.prev;
		this.max1 = n.max1;
		// Look at: http://stackoverflow.com/questions/7919836/how-do-i-copy-a-stack-in-java
		//this.stackOfSmaller = (Stack<Integer>) n.stackOfSmaller.clone();
		this.stackOfSmaller = new Stack<Integer>();
		if (!n.stackOfSmaller.isEmpty()) this.stackOfSmaller.addAll(n.stackOfSmaller);
	}
	//end-region Constructors
	
	//region GETTERS
	/**
	 * @return the next node
	 */
	public Node getNext() {
		return this.next;
	}
	/**
	 * @return the prev node
	 */
	public Node getPrev() {
		return this.prev;
	}
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
	 * @param n the Node we want to set it next
	 */
	public void setNext(Node n) {
		this.next = n;
	}
	/**
	 * @param n the Node we want to set it prev
	 */
	public void setPrev(Node n) {
		this.prev = n;
	}
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
