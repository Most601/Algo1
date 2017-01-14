package TheNumbersGame;

import Utils.MyConsole;

public class TheNumbersGameA {
	
	private int[] arr;
	private static final int finalSize = 10;
	private static final int minNumber = 10;
	private static final int maxNumber = 99;
	private static boolean isHuman = true;
	private MyConsole mc;
	
	public TheNumbersGameA() {
		arr = new int[finalSize];
		for (int i=0; i<finalSize; i++) {
			arr[i] = (int) (Math.random() * (maxNumber - minNumber)) + minNumber;
		}
		mc = new MyConsole();
	}
	public TheNumbersGameA(int[] arr) {
		this.arr = new int[arr.length];
		for (int i = 0; i < this.arr.length; i++) {
			this.arr[i] = arr[i];
		}
		mc = new MyConsole();
	}
	
	public String toString(int left, int right) {
		String str = "[ ";
		for (int i = left; i <= right; i++) {
			str += this.arr[i] + " ";
		}
		str += "]";
		return str;
	}
	
	public int sumSubArrayInClosedArea(boolean isEven, int left, int right) {
		int sum = 0;
		if (right >= this.arr.length || left < 0) return 0;
		int start = isEven ? (left % 2 == 0 ? left : left+1) : (left%2 == 0 ? left+1 : left);
		for (int i = start; i<=right; i+=2) {
			sum += this.arr[i];
		}
		return sum;
	}
	
	public void theGamePart01() {
		int sumCom = 0, sumHum = 0;
		int left = 0, right = this.arr.length-1;
		int sumOfEven = this.sumSubArrayInClosedArea(true, left, right);
		int sumOfOdd = this.sumSubArrayInClosedArea(false, left, right);
		System.out.println("sumOfEven = " + sumOfEven);
		System.out.println("sumOfOdd = " + sumOfOdd);
		
		boolean even;
		
		while (left < right) {
			
			even = true;
			
			if (isHuman) System.out.println("the Array is: " + this.toString(left, right));
			int comTemp = 0;
			if (sumOfOdd > sumOfEven) even = false;
			else if (sumOfOdd == sumOfEven) {
				if (this.arr[left] < this.arr[right]) {
					if (right % 2 == 1) even = false;
				}
				else if (this.arr[left] > this.arr[right]) {
					if (left % 2 == 1) even = false;
				}
			}
			
			if (left % 2 == 0){
				if (even) {
					comTemp = this.arr[left];
					sumCom += this.arr[left];
					sumOfEven -= this.arr[left];
					left++;
				}
				else{
					comTemp = this.arr[right];
					sumCom += this.arr[right];
					sumOfOdd -= arr[right];
					right--;
				}
			}
			else{
				if (even){
					comTemp = this.arr[right];
					sumCom += this.arr[right];
					sumOfEven -= arr[right];
					right--;
				}
				else{
					comTemp = this.arr[left];
					sumCom += this.arr[left];
					sumOfOdd -= this.arr[left];
					left++;
				}
			}
			int choice = 0;
			if (isHuman) {
				System.out.println("===============================================");
				System.out.println("the computer take " + comTemp);
				System.out.println("the Array is: " + this.toString(left,right));
				System.out.println("the sum of Computer is: " + sumCom);
				System.out.println("the sum of Human is: " +sumHum);
				choice = mc.getInt("for left number press 0, for right number press 1: ");
			}
			else {
				choice = (int) (Math.random() * 2);
			}
			
			if (choice==0) {
				sumHum += this.arr[left];
				if (left % 2 == 0) sumOfEven -= this.arr[left];
				else sumOfOdd -= this.arr[left];
				left++;
			}
			else {
				sumHum += this.arr[right];
				if (right % 2 == 0) sumOfEven -= this.arr[right];
				else sumOfOdd -= this.arr[right];
				right--;
			}
			
		}
		
		System.out.println("===============================================");
		System.out.println("==================   FINAL:  ==================");
		System.out.println("the sum of Computer is: " + sumCom);
		System.out.println("the sum of Human is: " +sumHum);
		System.out.println("===============================================");
	}
	
}
