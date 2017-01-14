package LCS;



public class LCSD {
	
	

	public static int[][] B (String a , String b ) {
		int mat[][];
		int x = a.length(), y = b.length() ;
		mat = new int[x+1][y+1];
		for (int i = 0; i < x+1; i++) {
			mat[i][0] = 0 ;
		}
		for (int j = 0; j < y ; j++) {
			mat[0][j] = 0 ;
		}
		
		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= y; j++) {
				if ( a.charAt(i-1) == b.charAt(j-1) ){
					mat[i][j] = mat[i-1][j-1] + 1 ;
				}
				else {
					mat[i][j] = Math.max(mat[i-1][j] , mat[i][j-1] );
				}	
			}
		}
		
		return mat;

		
	}
	public static String LCSM(String a ,String b ) {
		int mat[][] = B(a,b);
		int len = mat[a.length()][b.length()];
		String ans  = "";
		int x  = a.length() , y = b.length();
		while (len > 0 ) {
			if ( a.charAt(x-1) == b.charAt(y-1) ){
				ans = a.charAt(x-1) + ans ; 
				x-- ; 
				y-- ; 
				len-- ; 
				
			}
			else {
				if ( mat[x-1][y] > mat[x][y-1] ) x-- ;
				else y-- ; 
			}
			
			
			
		}
		
		return ans ; 
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		System.out.println(LCSM("ABCDEF" , "RVAEFBCDE"));

	}

}
