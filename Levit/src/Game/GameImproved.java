package Game;


public class GameImproved {
	public static void printArray(int [] arr, int i, int j){
		System.out.print("The numbers: ");
		for(int t=i; t<=j; t++) System.out.print(arr[t]+", ");
		System.out.println();
	}
	public static int sumEven(int []arr, int left, int right){
		int sum = 0;
		for(int k=left; k<=right; k=k+2)sum = sum + arr[k];
		return sum;
	}
	public static int sumOdd(int []arr, int left, int right){
		int sum = 0;
		for(int k=left+1; k<=right; k=k+2) sum = sum + arr[k];
		return sum;
	}
	public static int game2(int []arr){
		boolean even=true;
		int left=0, right=arr.length-1;
		int sumComputer=0,sumStudent=0, choice, second;
		int se = sumEven(arr, left, right);
		int so = sumOdd(arr, left, right);
		while(left<right){
			even=true;
			if (so > se) even = false;
			else if (se == so){
				if (arr[left] < arr[right]){
					if (right%2==1) even = false;
				}
				else if(arr[left] > arr[right]){
					if (left%2==1) even = false;
				}
			}
			if (left%2==0){
				if (even) {
					sumComputer = sumComputer + arr[left];
					se = se-arr[left++];
				}
				else{
					sumComputer = sumComputer + arr[right];
					so = so - arr[right--];
				}
			}
			else{// left odd
				if (even){
					sumComputer = sumComputer + arr[right];
					se = se - arr[right--];
				}
				else{
					sumComputer = sumComputer + arr[left];
					so = so - arr[left++];
				}
			}
			choice = (int)(Math.random()*2);
			// to choose left enter 0, to choose right enter 1: 
			if (choice==0) second = left++;
			else second = right--;
			sumStudent = sumStudent + arr[second];
			if (second%2 == 0) se = se - arr[second];
			else so = so - arr[second];
			//printArray(arr, left, right);
		}	
		if (sumComputer<=sumStudent){
			System.out.println("Computer="+sumComputer+", Student="+sumStudent);
			MyLibrary.printIntegerArray(arr);
		}
		return sumComputer;
	}
	// assumption: the array length is even
	// the computer chooses the first, the student chooses the second
	public static void main(String[] args) {
		int size = 6, count = 0;
		System.out.println("THIS IS A GAME:");
		//int []arr = {7, 1, 3, 9, 6, 0, 3, 2, 2, 7};
		//int []arr = {1,3,6,1,3,6};
		//int []arr = {6, 0, 2, 7, 4, 4, 1, 3};//g2=14, gop=17
		for (int i=1; i<=10; i++){
			int []arr = MyLibrary.randomIntegerArray(size);
			int g2 = game2(arr);
			//GameOptimal game = new GameOptimal(arr);
			//int gop = game.gameStrategy();
			//if (g2 < gop){
				//System.out.println("g2 = "+g2+", gopt = "+gop);
				//MyLibrary.printIntegerArray(arr);
				//count++;
			//}
		}
		//System.out.println("count = "+count);
	}

}
