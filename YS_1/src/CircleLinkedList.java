
public class CircleLinkedList {
	
	Node h ; 
	Node t ; 
	public int size = 0 ;
	// your code... Bone variables
	
	//region Constructors
	/**
	 * Constructor 
	 */
	public CircleLinkedList() {
		// your code... 
		h = null;
		t = null;
	}
	/**
	 * Copy Constructor 
	 * @param n the Node We want to copy
	 */
	public CircleLinkedList(CircleLinkedList cll) {
		// your code... 
		if ( cll != null ){
			h = null;
			t = null;
			Node n = cll.h ; 
			for (int i = 0; i < cll.size ; i++) {
				add(n.data);
				n = n.next;
			}
			
			
			
//			if (n != null && n == t ){
//				add(n.data);
//			}
//			else {
//				while (n != null && n != cll.t ) {
//				add(n.data);
//				n = n.next ; 
//				}
//				add(n.data);
//		}
//		
		}
		
		
	}
	//end-region Constructors
	
	//region GETTERS
	public Node getHead() {
		// your code... 
		return h ; 
	}
	public Node getTail() {
		// your code... 
		return t ;
	}
	//end-region GETTERS
	
	//region SETTERS
	public void setHead(int data) {
		// your code... 
		h.data = data ; 
	}
	public void setTail(int data) {
		// your code... 
		t.data = data ; 
	}
	//end-region SETTERS
	
	/**
	 * add new Node to the CircleLinkedList
	 * @param data the data of the new Node
	 */
	public void add(int data) {
		Node n = new Node(data);
		if ( h == null ){
			h = n ;  
			h.next = h;
			h.perv = h; 
			t = h ; 
			
		}
		else {
			n.next = h; 
			n.perv = t; 
			h.perv = n;
			t.next = n;
			t = t.next ;
		}
		size++; 
	}
	
	/**
	 * override the method toString
	 */
	public String toString() {
		// your code... 
		String s = " [ "; 
		Node n = h; 
		while ( n != null && n != t ){
			s = s + n.data+" ,";
			n = n.next ;
		}
		if(n == null) return s + "]";
		return s + t.data + "]";
		
		
	}
	
	/**
	 * @return the Real Size of the Circle LinkedList
	 */
	public int getSize() {
		// your code... 
		int size = 0 ;
		Node n = h ;
		if ( n == null )return 0;
		if ( h == n && n == t)return 1 ;
		while ( n != null && n != t ){
			size++ ; 
			n = n.next;
		}
		size++;
		
		return size++ ; 
	}
}
