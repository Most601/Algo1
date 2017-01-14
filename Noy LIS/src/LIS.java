
import java.util.Arrays;
import java.util.Vector;

public class LIS {
	/**
	 * The greedy algorithm of LIS - doesn't work for any array
	 * Complexity: O(n)
	 */
	public static Vector<Integer> greedyLIS(int[] arr) {
		return greedyLIS(arr,0);
	}
	
	//--------------------------------------------------------------

	private static Vector<Integer> greedyLIS(int[] arr,int start) {
		Vector<Integer> ans = new Vector<Integer>();
		ans.add(arr[start]);
		int max = arr[start];
		for (int i = start+1; i < arr.length; i++) {
			if(arr[i] > max) {
				ans.add(arr[i]);
				max = arr[i];
			}
		}
		return ans;
	}

	//--------------------------------------------------------------

	/**
	 * The improved greedy algorithm of LIS - check from any index - doesn't work for any array
	 * Complexity: O(n^2)
	 */
	public static Vector<Integer> greedyLISImproved(int[] arr) {
		Vector<Integer> ans = new Vector<Integer>();
		int maxLen = 0;
		for (int i = 0; i < arr.length; i++) {
			Vector<Integer> temp = greedyLIS(arr,i);
			if(temp.size() > maxLen) {
				maxLen = temp.size();
				ans = temp;
			}
		}
		return ans;
	}
	
	//--------------------------------------------------------------

	public static int[] LIS_usingLCS(int[] arr) {
		int[] s_arr = new int[arr.length];
		for (int i = 0; i < s_arr.length; i++) {
			s_arr[i] = arr[i]; 
		}
		Arrays.sort(s_arr);
		return maxSequence(arr,s_arr);
	}
	
	public static int[][] buldMatrix(int[] X,int[] Y) {
		int row=X.length+1;
		int col=Y.length+1;
		int mat[][] = new int[row][col]; 
		for (int i=1; i<row; i++) {
			for (int j=1; j<col; j++) {
				if (X[i-1]==Y[j-1]) mat[i][j] = mat[i-1][j-1] + 1;
				else mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
			}
		}
		return mat;
	}

	public static int[] maxSequence(int[] X,int[] Y){
		int mat[][] = buldMatrix(X,Y); 
		int i = mat.length-1;
		int j = mat[0].length-1;
		int end = mat[i][j];
		int[] ans = new int[end];
		int start=0;
		while (start<end) {
			if (X[i-1]==Y[j-1]) { ans[end-start-1] = X[i-1];
			i--; j--; start++; }
			else if (mat[i-1][j]>=mat[i][j-1]) i--;
			else j--;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(LIS_usingLCS(new int[] {2})));
	}
}
