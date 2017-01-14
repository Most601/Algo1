import static org.junit.Assert.*;

import org.junit.Test;


public class JUnitTestCheckCLL {

	@Test
	public void checkSizeCll1() {
		CircleLinkedList cll = new CircleLinkedList();
		cll.add(5);
		cll.add(6);
		cll.add(7);
		cll.add(8);
		assertEquals(cll.getSize(),4);
	}
	
	@Test
	public void checkSizeCll2() {
		CircleLinkedList cll = new CircleLinkedList();
		assertEquals(cll.getSize(),0);
	}
	
	@Test
	public void checkCopyConstructorCll() {
		CircleLinkedList cll = new CircleLinkedList();
		cll.add(5);
		cll.add(6);
		cll.add(7);
		cll.add(8);
		CircleLinkedList cll2 = new CircleLinkedList(cll);
		cll2.add(9);
		assertNotEquals(cll.getSize(), cll2.getSize());
	}
	
	@Test
	public void checkToStringCll() {
		CircleLinkedList cll = new CircleLinkedList();
		cll.toString();
	}
	
	@Test
	public void checkInsertToCll() {
		CircleLinkedList cll = new CircleLinkedList();
		cll.add(1);
		cll.add(2);
		cll.add(3);
		cll.add(4);
		Node n = new Node(cll.getHead());
		int count = 1;
		while (n != cll.getTail()) {
			count++;
			n = n.getNext();
		}
		assertEquals(count, 4);
	}
	
}
