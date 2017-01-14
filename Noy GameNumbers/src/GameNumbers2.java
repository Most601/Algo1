/**
	 * The algorithm of the game
	 * Complexity: O(n^2)
 */
public class GameNumbers2 {

	int arrGame[];
	int start,finish;
	int a,b;

	public GameNumbers2(int[] arr) {
		arrGame = new int[arr.length];
		start=0;
		finish=arr.length;
		for (int i = 0; i < arr.length; i++) {
			arrGame[i]=arr[i];
		}
		a=b=0;
	}

	//a start;
	private void start() {
		while(start<finish){
			if (checkBest()==1) {
				a+=arrGame[finish-1];
				finish--;
				setB();
			}
			else {
				a+=arrGame[start];
				start++;
				setB();
			}
		}

		System.out.println("player 1 - "+a+"\nplayer 2 -"+b );
		System.out.println("winPrice "+(a-b));

	}

	private void setB() {
		if (arrGame[finish-1]>arrGame[start]) {
			b+=arrGame[finish-1];
			finish--;
		}
		else {
			b+=arrGame[start];
			start++;
		}

	}

	//return 0 if sum of even is big than sum of odd 
	private int checkBest() {
		int even =0;
		int odd=0;
		for (int i = start; i < finish-1; i+=2) {
			even += arrGame[i];
			odd += arrGame[i+1];
		}
		if (even>odd) 
			return 0;

		else if (odd>even)
			return 1;
		else{//tie
			if (arrGame[start]>arrGame[finish-1]) 
				return 0;

			else
				return 1;
		}

	}

	public static void main(String[] args) {
		int arr[] = {54, 16, 78, 0, 40, 76, 80, 87};
		GameNumbers2 g= new GameNumbers2(arr);
		g.start();
	}

}
