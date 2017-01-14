/**
	 * Find the 2 maximum elements in array - Recursive
	 * Complexity: O(n) - (n + log n) comparisons
*/

import java.util.Stack;

class NodeRec{                              
	int num;
	Stack<Integer> st;
	public NodeRec(int num){
		this.num = num;
		st = new Stack<Integer>();
	}
}

public class MaxMaxRecursion {  // Recursive function
	static int comparisons = 0;
	private static int  maxMaxM2Recursive(NodeRec arr[], int low, int high){
		if (low < high){
			int index = 0;
			int middle = (low + high)/2;
			int i =  maxMaxM2Recursive(arr, low, middle);
			int j =  maxMaxM2Recursive(arr, middle+1, high);
			comparisons++;
			if (arr[i].num>arr[j].num){
				arr[i].st.push(arr[j].num);
				index = i;
			}
			else{
				arr[j].st.push(arr[i].num);
				index = j;
			}
			return index;
		}
		else return low;		   
	}
	public static void  maxMaxM2Recursive(int []a){  // External function
		int size = a.length;
		NodeRec []arr = new NodeRec[size];
		for (int i=0; i<size; i++) arr[i] = new NodeRec(a[i]);
		int index =  maxMaxM2Recursive(arr, 0, size-1);
		System.out.println("max1 = "+arr[index].num);
		int max2 = arr[index].st.pop();
		while(!arr[index].st.empty()){
			int temp = arr[index].st.pop();
			if (temp>max2) max2=temp;
		}
		System.out.println("max2 = "+max2);
		System.out.println("comparisons = "+comparisons);
	}
	
	
	public static void main(String[] args) {
		int a[] = {1,10,8,9,5,20,11,18,19};
		 maxMaxM2Recursive(a);
	}
}