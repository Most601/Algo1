import java.util.Arrays;
import java.util.Vector;


public class LISA {
	
	
	public static Vector<Integer> LISH1 ( int arr[] ){
		Vector<Integer> vec = new Vector<Integer>();
		int max = 0 ; 
		for (int i = 0; i < arr.length; i++) {
			if (max  < arr[i]){
				max = arr[i];
				vec.add(arr[i]);
			}
		}
		return vec;
		
		
	}
	//------------------------------------------
	
	public static Vector<Integer> LISH1 ( int arr[] , int start  ){
		Vector<Integer> vec = new Vector<Integer>();
		int max = 0 ; 
		for (int i = start; i < arr.length; i++) {
			if (max  < arr[i]){
				max = arr[i];
				vec.add(arr[i]);
			}
		}
		return vec;
		
		
	}
	
	public static Vector<Integer> LISH2 ( int arr[] ){
		Vector<Integer> ans = new Vector<Integer>();
		for (int i = 0; i < arr.length; i++) {
			Vector<Integer> temp = LISH1(arr , i );
			if  ( ans.size()  < temp.size())
				ans = temp ;
		}
		
		return ans ;
	}
	
	//========================================
	
	public static int[][] bildmat(int[] arr , int[] brr){
		
		
		int x  = arr.length+1 ;
		int y = brr.length+1 ; 
		int mat[][] = new int[x][y];
		for (int i = 0; i < mat.length; i++) {
			mat[i][0] = 0 ;
		}
		for (int i = 0; i < mat[0].length; i++) {
			mat[0][i] = 0 ; 
		}
		for (int i = 1; i < x ; i++) {
			for (int j = 1; j < y ; j++) {
				if ( arr[i-1] == brr[j-1] ){
					mat[i][j] = mat[i-1][j-1] + 1;
				}
				else{ 
					mat[i][j] = Math.max(mat[i-1][j] , mat[i][j-1]);
				}
			}
		
		}
		return mat ; 
			
	}
		
		
	
	
	public static int [] LIS_LCS(int arr[]) {
		int brr[] = new int [arr.length];
		for (int i = 0; i < brr.length; i++) {
			brr[i] = arr[i];
		}
		Arrays.sort(brr);
		int mat[][] = bildmat(arr , brr);
		int x = arr.length ,y = arr.length;
		int len = mat[x][y];
		int ans [] = new int [len] ;
		while ( len > 0 ) {
			if (arr[x-1] == brr[y-1]){
				ans[len-1] = arr[x-1];
				x--;
				y--;
				len--;
			}
			else {
				if ( mat[x-1][y] > mat[x][y-1] )x--;
				else y--;	
			}

		}
		
		return ans;
		
	}

//===================================================
	public static Vector<int[]> Serch (int[] arr ){
		Vector<int []> ans = new Vector<int []>();
		for (int i = 0; i < Math.pow(2,arr.length); i++) {
			Vector<Integer> temp = new Vector<Integer>();
			int b = i , j = 0 ;
			while ( b != 0 ){
				if ( b %2 ==1 )temp.add(arr[j]); 
				j++;
				b /=2;
			}
			int arrtemp[] = new int [temp.size()];
			for (int k = 0; k < temp.size() ;k++) {
				arrtemp[k] = temp.get(k);
			}
			ans.add(arrtemp);
		}
		
		return ans ;
		
		
	}
	public static int[] LISFULL( int arr[] ){
		Vector<int[]> vec =  Serch(arr);
		int max = 0 ;
		int ans [] = null;
		for (int i = 0; i < vec.size(); i++) {
			int temp[] = vec.get(i);
			boolean seq = true ; 
			for (int j = 1; j < temp.length; j++) {
				if (temp[j-1] > temp[j] ) seq = false ;
			}
			if (seq) {
				max = temp.length;
				ans = temp;
			}
		}
		return ans ; 
		
		
	}
	// =======================================
	
	public static int binSerch ( int mat [][] , int val , int len  ) {
		
		if ( val < mat[0][0] )return 0 ;
		if ( val > mat[len-1][len-1] ) return len;
		int low = 0 ;
		int mid ; 
		while ( low <= len ){
			if ( low == len ) return low ;
			mid = (low + len)/2 ;  
			if ( val  > mat[mid][mid])low = mid+1
					;
			else len = mid ;
			
		}
		return -1;
		
	
		
		
	}

	public static void copy ( int mat [][] , int index ){
		for (int i = 0; i < index ; i++) {
			mat[index][i]  = mat[index-1][i]; 
		}
		
		
	}
	public static int[] LISD (int arr[] ){
		int size  = arr.length;
		int mat[][] = new int [size][size];
		mat[0][0] = arr[0] ;
		int len  = 1 ; 
		for (int i = 1; i < mat.length; i++) {
			int index = binSerch(mat ,arr[i] , len );
			mat[index][index] = arr[i]; 
			if(index == len) len++;
			copy(mat , index );
			
		}
		int ans [] = new int [len];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = mat[len-1][i]; 
		}
		
		return ans ; 
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("fdgdg");

		int arr[] = {2,12,3,8,110,4,5,7,10};
		Vector<Integer> d = LISH1(arr);
		for (int i = 0; i < d.size(); i++) {
			System.out.print(" ,"+ d.get(i));
		}
		System.out.println();
		Vector<Integer> b = new Vector<Integer>();
		b = LISH2(arr);
		for (int i = 0; i < b.size(); i++) {
			System.out.print(" ," + b.get(i));
		}
		System.out.println();
		int [] ans  = LIS_LCS(arr);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(" , "+ans[i]);
		}
		System.out.println();
		int [] ans2 = LISFULL(arr);
		for (int i = 0; i < ans2.length; i++) {
			System.out.print(" . "+ans2[i]);
		}
		
		System.out.println();
		int [] ans3 = LISD(arr);
		for (int i = 0; i < ans3.length; i++) {
			System.out.print(" . "+ans3[i]);
		}
		
		
		
		

	}

}
