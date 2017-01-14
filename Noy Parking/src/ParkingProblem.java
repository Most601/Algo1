public class ParkingProblem {
	public static final int x = 0, v = 1;
	/**
	 * parking problem with double cycle linked list
	 * Complexity: O(n^2)
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
	
	public static void main(String[] args) {
		DoubleCycleLinkedList l = new DoubleCycleLinkedList();
		l.add(1);
		//l.add(1);l.add(1);l.add(1);l.add(1);l.add(1);l.add(1);l.add(1);l.add(1);l.add(1);l.add(1);
		//l.createCircle(10);
		System.out.println(parkingProblem(l));
	}
}
