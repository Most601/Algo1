package Lcs_Lis;

import java.util.Arrays;
public class Lis_nLogN {
	
	public static void lisNumSeq(int []arr){
		return;
	}
	/** one longest increasing subsequence O(nlogn)
	 * mPos[j] -stores the position k of the smallest value arr[k]
	 * such that there is an increasing  subsequence of length j ending at arr[k]
	 * in the range k<=i.
	 * pred[k] stores the position of the predecessor of arr[k] in the longest
	 * increasing  subsequence ending at arr[k]
	*/
	public static int[] lis_nLogn(int []arr){
		int pred[] = new int[arr.length];
		int mPos[] = new int[arr.length];
		int []t = new int[arr.length];
		int len = 1;
		t[0] = arr[0];
		mPos[0] = 0;
		pred[0] = -1;
		for (int i=1; i<arr.length; i++){
			//int index = search(t, len, arr[i]);
			int index = LIS.binarySearchBetween(t, len-1, arr[i]);
			if (index == 0) pred[i] = -1;
			else  pred[i] = mPos[index-1];
			t[index] = arr[i];
			mPos[index] = i;
			if (index==len){
				len++;
			}
		}
		System.out.println("T: " + Arrays.toString(t));
		System.out.println("M: " + Arrays.toString(mPos));
		System.out.println("P: " + Arrays.toString(pred));

		int []ans = new int[len];		
		ans[len-1] = arr[mPos[len-1]];
		int j = mPos[len-1];
		for (int i=len-2; i>=0; i--){
			ans[i] = arr[pred[j]];
			j = pred[j];
		}
		return ans;
	}
	public static int search(int[]arr, int end, int val){
		int ans = 0;
		if (val < arr[0]) ans = 0;
		if (val > arr[end-1]) ans = end;
		for (int i=0; i<end-1; i++) {
			if (arr[i]<val && val < arr[i+1])
				ans = i+1;
		}
		return ans;
	}
	public static void main(String[] args) {
		int []arr = {2, 4, 90, 9, -3,-2,-1, 10,  99};
		//int []arr = {10, 2, 4, -1, 0};
		int[] ans = lis_nLogn(arr);
		System.out.println("ans: " + Arrays.toString(ans));
		lisNumSeq(arr);
	}
}
