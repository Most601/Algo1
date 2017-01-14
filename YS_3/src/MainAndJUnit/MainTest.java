package MainAndJUnit;

import PartA.MaxMaxInArray;
import PartB.CircleLinkedList;
import PartC.ArrayMaxAndStack;
import UtilsPack.ArrayProvider;

public class MainTest {
	
	public static void main(String[] args) {
		ArrayProvider ap = ArrayProvider.getInstance();
		ap.setAndGetBiggestNumbers(2);
		System.out.println(ap);
		
		System.out.println("\n-------->>>>>>>> your check start here: <<<<<<<<--------\n");
		
		MaxMaxInArray maxmax = new MaxMaxInArray();
		maxmax.setAndGetRegularCounter();
		maxmax.setAndGetOneAndHalfCounter();
		System.out.println(maxmax);
		
		System.out.println("------------------- checking sort Array -------------------");
		ap.setArraySort();
		maxmax.setAndGetRegularCounter();
		maxmax.setAndGetOneAndHalfCounter();
		System.out.println(maxmax);
		ap.removeArraySort();
		System.out.println("--------------- end of checking sort Array! ---------------");
		
		CircleLinkedList cll = new CircleLinkedList();
		cll.addArrayProvider();
		cll.setAndGetMax1();
		cll.setAndGetMax2();
		System.out.println(cll);
		
		ArrayMaxAndStack amas = new ArrayMaxAndStack();
		amas.setAndGetMax1();
		amas.setAndGetMax2();
		System.out.println(amas);
		
	}
}
