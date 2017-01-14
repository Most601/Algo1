package ParkingProblem;

public class ParkingProblem {
	public static final int x = 0, v = 1;
	
	/**
	 * parking problem with array (cycle array)
	 * Complexity: O(n)
	 * מערך עם מקום רנדומלי להתחלה 
	 */
	public static int parkingProblem(int[] arr) {
		int count = 0;
		int start = (int)(Math.random()*arr.length);
		arr[start] = v;
		boolean finnish = false;
		while(!finnish){
			count++;
			if(arr[(start+count)%arr.length] == v) {
				arr[(start+count)%arr.length] = x;
				if(arr[start%arr.length] == x) finnish = true;
			}
		}
		return count;
	}
	
	/**
	 * parking problem with double cycle linked list
	 * Complexity: O(n^2)
	 * רשימה רגילה 
	 */
	public static int parkingProblem(DoubleCycleLinkedList list) {
		if(list.getHead() == null) return 0;
		int count = 0;
		NodeDouble n = list.getHead();
		n.setData(v);
		n = n.getNext();
		boolean finnish = false;
		while(!finnish){
			count = 1;
			while(n.getData() != v) {
				count++;
				n = n.getNext();
			}
			n.setData(x);
			int steps = count;
			while(steps > 0) {
				steps--;
				n = n.getPrev();
			}
			if(n.getData() == x) finnish = true;
			n = n.getNext();
		}
		return count;
	}
	
	/**
	 * 2(x+y) = x + 2y + z ==> x = z 
	 * parking problem with linear part and cycle part - double linked list
	 * Complexity: O(n^2)
	 * 2 אפשרויות :
	 * 1. אם בחיבור חוזר לקו אז עושים את מספר הצעדים עד סיבוב שלם בחזרה יחזור מהר יותר לראשון לפני סיום מספר הצעדים ואז יהיה שונה 
	 * 2. החיבור חוזר לסיבוב אז בהתחלה הוא סופר את הקו ואז בהמשך הקוד סופר את העיגול 
	 */
	public static int parkingProblemWithLinearPart(DoubleLinkedList list) {
		if(list == null || list.getHead() == null) return 0;
		if(list.getHead().getNext() == null) return 1;
		NodeDouble n = list.getHead(), m = list.getHead();
		int steps = 0;
		while(m == n) { // check weather there is a cycle and count the linear part
			steps++;
			for(int i = 0; i < steps; i++) 
				if(m!=null) m = m.getNext();
			for(int i = steps; i > 0; i--) 
				if(m!=null) m = m.getPrev();
		}
		if(m == null) return steps;
		
		// חלק שני במקרה של חזרה לעיגול ולא לקו 
		while(m != n) n = n.getNext();
		while(m != n) { // count the length of cycle
			m = m.getNext();
			steps++;
		}
		return steps;
	}
	
	/**
	 * parking problem with linear part and cycle part - not double list
	 * Complexity: O(n)
	 *  
	 */
	public static int parkingProblemWithLinearPart(LinkedList list) {
		if(list == null || list.getHead() == null) return 0;
		if(list.getHead().getNext() == null) return 1;
		Node n = list.getHead().getNext(), m = list.getHead().getNext().getNext();
	/**
	 * בודק שאכן זה רשימה מעגלית עם חזרה לסיבוב 
	 * n מתחיל מהבא 
	 * m מתחיל מהבא הבא 
	 * m הולך כפול n הולך רגיל 
	 * 
	 */
		while(m != null && m != n) { // check weather there is a cycle
			m = m.getNext();
			if(m != null) m = m.getNext();
			n = n.getNext();
		}
		if(m == null) return sizeOfList(list);
		int count = 0;
		/**
		 * n מתחיל מהתחלה ומתקדם אחד אחד יחד עם m
		 * זה יעצר בדיוק על החיבור מכוון ש 
		 *  2(x+y) = x + 2y + z ==> x = z 
		 *  אז זה סופר את הקו 
		 */
		m = list.getHead();
		while(m != n) { // count the length of linear part
			m = m.getNext();
			n = n.getNext();
			count++;
		}
		/**
		 * סופר את העיגול 
		 */
		m = m.getNext();
		count++;
		while(m != n) { // count the length of cycle
			m = m.getNext();
			count++;
		}
		return count;
	}

	private static int sizeOfList(LinkedList list) {
		int count = 0;
		Node n = list.getHead();
		while(n != null) {
			n = n.getNext();
			count++;
		}
		return count;
	}
	public static void main(String[] args) {
		DoubleLinkedList l = new DoubleLinkedList();
		l.add(2);
		l.add(3);
		l.add(5);
		l.add(3);

		l.createCircle(1);
		System.out.println(l.toString());
		System.out.println(parkingProblemWithLinearPart(l));
		
	}
	
}
