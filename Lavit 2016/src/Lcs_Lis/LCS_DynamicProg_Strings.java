package Lcs_Lis;

import java.util.HashSet;
import java.util.Set;

class Node{
	int _seqLen, _numOfSeq;
	public Node(){
		_seqLen = 0;
		_numOfSeq = 0;
	}
}// end Node

public class LCS_DynamicProg_Strings {
	// build matrix of numbers
	public static int[][] buldMatrix(String X, String Y) {
		int row = X.length()+1,  col = Y.length()+1;
		int mat[][] = new int[row][col]; 
		int i=0, j=0;
		// first column
		for (i=0; i<row; i++) mat[i][0]=0;
		// first row
		for (j=0; j<col; j++) mat[0][j]=0;
		// Matrix Interior 
		for (i=1; i<row; i++) {
			for (j=1; j<col; j++) {
				if (X.charAt(i-1)==Y.charAt(j-1)){
					mat[i][j] = mat[i-1][j-1] + 1;
				}
				else{
					mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
				}
			}
		}
		return mat;
	}

	// the function returns max common sequence of two integer sequences
	public static String maxSequence(String X, String Y){
		int mat[][] = buldMatrix(X, Y); 
		//MyLibrary.printIntMatrix(mat);
		int row = mat.length;
		int col = mat[0].length;
		int seqLength = mat[row-1][col-1];
		String result = new String();
		int i=row-1, j=col-1, count=seqLength-1;
		while (count>=0){
			if (X.charAt(i-1)==Y.charAt(j-1)){
				result = X.charAt(i-1) + result;
				i--;
				j--;
				count--;
			}
			else if (mat[i][j]==mat[i][j-1]) j--;
			else  i--;
		}
		return result;
	}
	public static HashSet<String> lcsAll(String X, String Y){
		int[][]mat = buldMatrix(X, Y);
		HashSet<String> set = lcsAll(mat, X, Y, X.length(), Y.length());
		return set;
	}
	public static HashSet<String> lcsAll(int[][]m, String s1, String s2, int len1, int len2) {
		if (len1 == 0 || len2 == 0) {
			HashSet<String> set = new HashSet<String>();
			set.add("");
			return set;
		}
		if (s1.charAt(len1 - 1) == s2.charAt(len2 - 1)) {
			HashSet<String> set = lcsAll(m, s1, s2, len1 - 1, len2 - 1);
			HashSet<String> set1 = new HashSet<>();
			for (String temp : set) {
				temp = temp + s1.charAt(len1 - 1);
				set1.add(temp);
			}
			return set1;
		} else {
			HashSet<String> set = new HashSet<>();
			HashSet<String> set1 = new HashSet<>();
			if (m[len1 - 1][len2] >= m[len1][len2 - 1]) {
				set = lcsAll(m, s1, s2, len1 - 1, len2);
			}
			if (m[len1][len2 - 1] >= m[len1 - 1][len2]) {
				set1 = lcsAll(m, s1, s2, len1, len2 - 1);
			}
			for (String temp : set) {
				set1.add(temp);
			}
			return set1;
		}

	}	public static void main(String[] args) {
		String Y = "bdcaba";
		String X = "abcbdab";
		HashSet<String> R = lcsAll(X, Y);
		System.out.println(R);
	}

}
