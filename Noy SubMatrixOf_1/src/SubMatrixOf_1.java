
public class SubMatrixOf_1 {

	/**
	 * Finds the biggest k*k matrix of '1'.
	 * Complexity O(m*n)
	 * @param mat
	 * 		matrix filled with 0,1
	 */
	public static void subMatrixOf1(int [][] mat){

		int n = mat.length;
		int m = mat[0].length;
		int[][] s = new int[n][m];
		int max=0, imax=0, jmax=0;

		for (int i=0; i<n; i++) s[i][0] = mat[i][0];
		for (int j=0; j<m; j++) s[0][j] = mat[0][j];

		for (int i=1; i<n; i++) {
			for (int j=1; j<m; j++) {

				if (mat[i][j]==1)
					s[i][j] = min(s[i-1][j], s[i][j-1], s[i-1][j-1]) + 1;

				if (s[i][j] > max) {
					max = s[i][j];
					imax = i;
					jmax = j;
				}
			}
		}
		System.out.println("max size of ones = "+max);
		System.out.println("index of i max = "+imax);
		System.out.println("index of j max = "+jmax);
	}

	/**
	 *  returns min(a, b, c)
	 */
	public static int min(int a, int b, int c){
		int min = a;
		if (min > b) min = b;
		if (min > c) min = c;
		return min;
	}


	public static void main(String[] args) {
		int [][] mat = {{1,1,0,0,0},{1,1,1,1,0},{0,1,1,1,1},{1,1,1,1,0},{0,0,1,0,0}};
		subMatrixOf1(mat);
	}
}