package Lcs_Lis;

public class LCS_DynamicProgCharArray {

	// build matrix of numbers
	private static int[][] buldMatrix(char[] X, char [] Y) {
		int row = X.length+1,  col = Y.length+1;
		int mat[][] = new int[row][col]; 
		int i=0, j=0;
		// first column
		for (i=0; i<row; i++) mat[i][0]=0;
		// first row
		for (j=0; j<col; j++) mat[0][j]=0;
		// Matrix Interior 
		for (i=1; i<row; i++) {
			for (j=1; j<col; j++) {
				if (X[i-1]==Y[j-1]){
					mat[i][j] = mat[i-1][j-1] + 1;
				}
				else{
					mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
				}
			}
		}
		return mat;
	}
	// the function returns max common sequence length
	public static int maxSeqLength(char[] X, char [] Y){
		int row = X.length+1,  col = Y.length+1;
		int mat[][] = buldMatrix(X, Y); 
		return mat[row-1][col-1];
	}
	// the function returns max common sequence of two integer sequences
	public static char[] maxSequence(char[] X, char [] Y){
		int mat[][] = buldMatrix(X, Y); 
		//MyLibrary.printIntMatrix(mat);
		int row = mat.length;
		int col = mat[0].length;
		int seqLength = mat[row-1][col-1];
		char result[] = new char[seqLength];
		int i=row-1, j=col-1, count=seqLength-1;
		while (count>=0){
			if (X[i-1]==Y[j-1]){
				result[count--]=X[i-1];
				i--;
				j--;
			}
			else if (mat[i][j]==mat[i][j-1]) j--;
			else  i--;
		}
		return result;
	}
	public static void checkMaxSeq1(){
		String X = "bdcaba";
		String Y = "abcbdab";		
		String X1 = "abcd", Y1 = "acd";
		String X2 = "cdbac", Y2 = "abdbb";
		String X3 = "abcabdc", Y3 = "abcbdcbad";
		String X4 = "abcabdc", Y4 = "xyz";
		char XX[] = X.toCharArray();
		char YY[] = Y.toCharArray();
		//MyLibrary.printIntMatrix(buldMatrix(XX, YY));
		System.out.println(maxSeqLength(XX, YY));
		MyLibrary.printCharArray(maxSequence(XX, YY));
	}
	public static void main(String[] args) {
		checkMaxSeq1();
	}

}
