import java.util.Vector;


public class Mat1 {
	
	public static Vector<int [][]> BILD ( int mat[][]){
		Vector<int[][]> ans = new Vector<int [][]>();
		for (int i = 1; i < Math.min(mat.length, mat[0].length)+1 ; i++) {
			for (int j = 0; j < mat.length+1-i; j++) {
				for (int k = 0; k < mat[0].length+1-i; k++) {
					int [][]temp = new int[i][i] ;
					for (int j1 = j; j1 < i+j; j1++) {
						for (int k1 = k; k1 < i+k; k1++) {
							temp[j1-j][k1-k] = mat[j1][k1] ; 
						}
						
					}
					ans.add(temp);
				}
				
			}	
		}
		return ans;
		
		
		
	}
	
	public static int MAT1 (int mat[][]){
		Vector<int[][]> ans  = BILD(mat);
		int max = 0 ; 
		for (int[][] is : ans) {
			boolean zero = true;
			for (int i = 0; i < is.length && zero; i++) {
				for (int j = 0; j < is.length && zero ; j++) {
					if (is[i][j] == 0 )zero = false ;
				}
				
			}if(zero) if (max < is.length ) max = is.length;
		}
		return max ;		
		
	}
	public static int min(int i, int j, int k) {
		if(i <= j && i <= k) return i;
		if(j <= i && j <= k) return j;
		if(k <= i && k <= j) return k;
		else return -1;
	}
	public static void main(String[] args) {
		int mat1[][] = {{0,0,0,1,0},
						{0,1,1,1,0},
						{0,1,1,1,0},
						{0,1,1,1,0},
						{0,1,1,1,0},
						{0,1,0,1,1}};
		System.out.println(MAT1(mat1));

	}

}
