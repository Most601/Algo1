package PartB;

import java.util.Stack;

import UtilsPack.ArrayProvider;

public class CircleLinkedList {

	private Node head;
	private Node tail;
	
	private Stack<Integer> stackOfMax1;
	private Integer max1;
	private Integer max2;
	private Integer inductiveCounter;
	
	//region Constructors
	/**
	 * Constructor 
	 */
	public CircleLinkedList() {
		this.head = null;
		this.tail = null;
		this.inductiveCounter = 0;
		this.stackOfMax1 = new Stack<Integer>();
	}
	/**
	 * Copy Constructor 
	 * @param n the Node We want to copy
	 */
	public CircleLinkedList(CircleLinkedList cll) {
		if (cll.getHead() != null){
			Node n = new Node(cll.head);
			while (n != cll.tail.getNext()) {
				int max1 = n.getMax1();
				this.add(max1);
				n = n.getNext();
			}
			this.inductiveCounter = cll.inductiveCounter;
			this.stackOfMax1 = new Stack<Integer>();
			if (cll.stackOfMax1 != null) this.stackOfMax1.addAll(cll.stackOfMax1);
		}
	}
	//end-region Constructors
	
	//region GETTERS
	public Node getHead() {
		return this.head;
	}
	public Node getTail() {
		return this.tail;
	}
	public int getCountOfSetp() {
		return this.inductiveCounter;
	}
	//end-region GETTERS
	
	//region SETTERS
	public void setHead(int max1) {
		this.head.setMax1(max1);
	}
	public void setTail(int max1) {
		this.tail.setMax1(max1);
	}
	//end-region SETTERS
	
	/**
	 * add new Node to the CircleLinkedList
	 * @param data the data of the new Node
	 */
	public void add(int data) {
		Node n = new Node(data);
		if (this.head == null) {
			this.head = n;
			this.head.setNext(head);
			this.head.setPrev(head);
			this.tail = head;
		}
		else {
			n.setNext(this.head);
			n.setPrev(this.tail);
			this.head.setPrev(n);
			this.tail.setNext(n);
			tail = tail.getNext();
		}
	}
	
	/**
	 * fill the Cll from the ArrayProvider
	 */
	public void addArrayProvider() {
		ArrayProvider ap = ArrayProvider.getInstance();
		for (int i = 0; i < ap.getArrSize(); i++) {
			this.add(ap.getArr()[i]);
		}
	}
	
	/**
	 * override the method toString
	 */
	public String toString() {
		String str = "";
		
		if (this.max1 != null) {
			str = str + "the max1 is: " + this.max1 + "\n";
		}
		if (this.max2 != null) {
			str = str + "the max2 is: " + this.max2 + "\n";
		}
		
		if (this.inductiveCounter != null) {
			str = str + "the Inductive counter is: " + this.inductiveCounter + "\n";
		}
		
		if (this.max1 != null || this.max2 != null) {
			str =	"\n===========================================================\n"
					+ str +
					"\n===========================================================\n";
		}
		return str;
	}
	
	public int getSize() {
		int count = 0;
		if (this.head == null) return count;
		Node n = new Node(this.head);
	
		while (n != this.tail.getNext()) {
			count++;
			n = n.getNext();
		}
		return count;
	}
	
	public int setAndGetMax1() {
		inductiveCounter=0;
		Node t1 = head ;
		int size = getSize() , i = 0 ;
		Node t2 = t1.getNext();
		while (1 < size ){
			inductiveCounter++;
			if (t1.getMax1() > t2.getMax1() ){
				t1.getStack().push(t2.getMax1());
				t1.setNext(t2.getNext());
				t2.getNext().setPrev(t1);
				t1 = t1.getNext();
				size--;
			}
			else {
				t2.getStack().push(t1.getMax1());
				t2.setPrev(t1.getPrev());
				t1.getPrev().setNext(t2);
				t1 = t2.getNext();
				size--;
			}
			
			t2 = t1.getNext();
			
			

		}
		
		i--;
		
		this.stackOfMax1.addAll(t1.getStack());
		this.max1 = t1.getMax1();	
		return this.max1;		
	}
	
	public int setAndGetMax2() {
	
		int max2 = stackOfMax1.pop();
		while(!stackOfMax1.isEmpty()){
			int temp = stackOfMax1.pop();
			inductiveCounter++;
			if ( temp > max2 ){
				max2 = temp;
			}
			
		}
		
		
		
		this.max2 = max2;
		return this.max2;
	}
}
