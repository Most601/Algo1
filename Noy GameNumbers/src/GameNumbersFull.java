/**
	 * the maximum difference for the first player using the game tree
	 * Complexity: O(2^n)
*/

public class GameNumbersFull {
	private int[] arr;

	public GameNumbersFull(int[] arr) {
		this.arr = arr;
	}
	
	public int fullSearch() {
		return fullSearch(0,arr.length-1,true);
	}

	private int fullSearch(int s,int e,boolean turn) {
		if(s == e) {
			if(turn)return arr[s];
			else return -arr[s];
		}
		
		int left;
		int right;
		if(turn) {
			     left = arr[s] + fullSearch(s+1,e,!turn);
			     right = arr[e] + fullSearch(s,e-1,!turn);
		         }
		else {
			left = -arr[s] + fullSearch(s+1,e,!turn);
			right = -arr[e] + fullSearch(s,e-1,!turn);
		    }
		if(left > right) return left;
		return right;
	}
	public static void main(String[] args) { 
		int arr[] = {54, 16, 78, 0, 40, 76, 80, 87};
		GameNumbersFull g= new GameNumbersFull(arr);
		System.out.println(g.fullSearch());
	}
}
