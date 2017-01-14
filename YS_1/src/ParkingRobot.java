
public class ParkingRobot {
	
	int v = 1 , x = 0 ;
	int size  = 0 ; 
	CircleLinkedList l ;
	/**
	 * Constructor 
	 * @param cll the Circle LinkedList we want to check
	 */
	public ParkingRobot(CircleLinkedList cll) {
		// your code... 
		if ( cll != null){
			l = new CircleLinkedList(cll);
		}
		else l = null ;
		
	}
	
	/**
	 * @return the numbers of cars in parking
	 */
	public int countCars(){
		// your code... 
		boolean ans  = false ; 
		if ( l.h == null )return 0 ;
		l.h.setData(v); 
		Node n = l.h.next ; 
		int len = 0 ;
		while (!ans) {
			size = 1 ;
			while (n.data != 1 ) {
				size++; 
				n = n.next;
			}
			n.data = x ; 
			len = size ; 
			while (size > 0 ) {
				n = n.perv;
				size-- ; 
			}
			if ( n.data == 0 ){
				ans = true ; 
			}
			else n = n.next;
			
			
		}
		return len ; 
	}
	
	public String toString() {
		// your code... 
		return l.toString();
		
	}
}
