
import java.util.Arrays;

public class LCS_Dynamic {
	// build matrix of numbers
	public static int[][] buldMatrix(String s1,String s2) {
		int row=s1.length()+1;
		int col=s2.length()+1;
		int mat[][] = new int[row][col]; 
		int i=0, j=0;
		// first column
		for (i=0; i<row; i++) mat[i][0]=0;
		// first row
		for (j=0; j<col; j++) mat[0][j]=0;
		// Matrix Interior 
		for (i=1; i<row; i++) {
			for (j=1; j<col; j++) {
				if (s1.charAt(i-1)==s2.charAt(j-1)) mat[i][j] = mat[i-1][j-1] + 1;

				else mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
			}
		}
		return mat;
	}

	// the function returns max common sequence length
	public static int maxSeqLength(String s1,String s2){
		int row=s1.length()+1;
		int col=s2.length()+1;
		int mat[][] = buldMatrix(s1, s2); 
		return mat[row-1][col-1];
	}
	// the function returns max common sequence of two integer sequences
	public static String maxSequence(String s1,String s2){
		String s="";
		int mat[][] = buldMatrix(s1, s2); 
		int i = mat.length-1;
		int j = mat[0].length-1;
		int end = mat[i][j];
		int start=0;

		while (start<end)
		{
			if (s1.charAt(i-1)==s2.charAt(j-1)) { s=s1.charAt(i-1)+s;
			i--; j--; start++; }
			else if (mat[i-1][j]>=mat[i][j-1]) i--;
			else j--;
		}
		return s;
	}

	// the function returns all max common sequence of two integer sequences
	public  static void LCS_ALL(String s1, String s2)  {	
		int [][] arr=buldMatrix(s1, s2); 
		SubLCS(s1,s2,arr,arr.length-1,arr[0].length-1,"");
	}

	public  static void SubLCS(String s1,String s2,int [][]arr,int i, int j, String result){
		if(arr[i][j]!=0){
			if(s1.charAt(i-1)==s2.charAt(j-1)){
				SubLCS(s1,s2,arr,i-1,j-1,s1.charAt(i-1)+result);
			}
			else{
				if(arr[i][j-1]>arr[i-1][j]){
					SubLCS(s1,s2,arr,i,j-1,result);

				}
				else if(arr[i][j-1]<arr[i-1][j]){
					SubLCS(s1,s2,arr,i-1,j,result);
				}
				else{
					SubLCS(s1,s2,arr,i-1,j,result);
					SubLCS(s1,s2,arr,i,j-1,result);
				}
			}

		}
		else{
			System.out.println(result);
		}
	}


	public static void main(String[] args) {
		String s1 ="bdcaba";
		String s2= "abcbdab";
		int[][]m = buldMatrix(s1, s2);
		for (int i=1; i<m.length; i++) {
			for (int j=1; j<m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("max seq len = "+maxSeqLength(s1, s2));
		System.out.println((maxSequence(s1, s2)));
		System.out.println();
		LCS_ALL(s1,s2);

	}

}
