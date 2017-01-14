
public class Node {
	Node next ;
	Node perv;
	int data ; 

	// your code... Bone variables
	
	//region Constructors
	/**
	 * Constructor 
	 * @param data data of the Node
	 */
	public Node(int data) {
		this.data = data ; 
		next = null ;
		perv = null ; 
		
	}
	/**
	 * Copy Constructor 
	 * @param n the Node We want to copy
	 */
	public Node(Node n) {
		data = n.data ; 
		next = n.next ; 
		perv = n.perv ; 
	}
	//end-region Constructors
	
	//region GETTERS
	public Node getNext() {
		return next;
	}
	public Node getPrev() {
		// your code... 
		return perv ; 
	}
	public int getData() {
		// your code... 
		return data ;
	}
	//end-region GETTERS
	
	//region SETTERS
	public void setNext(Node n) {
		// your code... 
		next = n;
	}
	public void setPrev(Node n) {
		// your code... 
		perv = n;
	}
	public void setData(int data) {
		// your code... 
		this.data = data; 
	}
	//end-region SETTERS
}
