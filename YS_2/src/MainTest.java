
public class MainTest {
	
	public static void main(String[] args) {
//		ArrayProvider ap = ArrayProvider.getInstance();
//		ap.setAndGetBiggestNumbers(2);
//		ap.setAndGetSmallestNumber();
//		System.out.println(ap);
//		]
//		MinMaxInArray mm = new MinMaxInArray();
//		mm.setAndGetRegularCounter();
//		mm.setAndGetOneAndHalfCounter();
//		System.out.println(mm);
//	
//		System.out.println("we right? "+ mm.checkRightness(2.6));
		
		MinMaxInArray ap = new MinMaxInArray();
		int a = ap.setAndGetRegularCounter();
		System.out.println(a);
		int b = ap.setAndGetOneAndHalfCounter();
		System.out.println(b);
		
		
		
	}
}
