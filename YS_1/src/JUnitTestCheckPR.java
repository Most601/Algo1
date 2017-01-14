import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTestCheckPR {

	@Test
	public void checkRobot1() {
		CircleLinkedList cll = new CircleLinkedList();
		cll.add(9);
		cll.add(8);
		cll.add(7);
		cll.add(6);
		ParkingRobot pr = new ParkingRobot(cll);
		int count = pr.countCars();
		assertEquals(count, 4);
	}
	
	@Test
	public void checkRobot2() {
		CircleLinkedList cll = new CircleLinkedList();
		cll.add(1);
		cll.add(1);
		cll.add(1);
		ParkingRobot pr = new ParkingRobot(cll);
		int count = pr.countCars();
		assertEquals(count, 3);
	}

	@Test
	public void checkRobot3() {
		CircleLinkedList cll = new CircleLinkedList();
		cll.add(1);
		cll.add(1);
		cll.add(0);
		cll.add(0);
		cll.add(1);
		ParkingRobot pr = new ParkingRobot(cll);
		int count = pr.countCars();
		assertEquals(count, 5);
	}
	
	@Test
	public void checkRobot4() {
		CircleLinkedList cll = new CircleLinkedList();
		ParkingRobot pr = new ParkingRobot(cll);
		int count = pr.countCars();
		assertEquals(count, 0);
	}
	
	@Test
	public void checkRobot5() {
		CircleLinkedList cll = new CircleLinkedList();
		ParkingRobot pr = new ParkingRobot(cll);
		cll.add(1);
		cll.add(1);
		cll.add(1);
		cll.add(1);
		pr.countCars();
		
		assertNotEquals(cll.getHead().getData(), 0);
	}

}
