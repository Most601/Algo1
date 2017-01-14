import java.util.ArrayList;
import java.util.Arrays;

public class black {

	public static int numRectangles (int [][]mat)//void
	{

		int count=1;
		int m=mat.length+1;
		int n=mat[0].length+1;
		int mat2[][]=new int[m][n];

		for ( int i=1; i<m; i++)
			for ( int j=1; j<n; j++)
				if (mat[i-1][j-1]==1) {
					if (mat2[i-1][j]==0 && mat2[i][j-1]==0) { mat2[i][j]=count++; }
					else if (mat2[i-1][j]!=0) mat2[i][j]=mat2[i-1][j];
					else mat2[i][j]=mat2[i][j-1];
				}
	
		return count-1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]a={{1,1,1,1},{0,0,0,0},{0,1,1,1},{0,1,1,1},{0,1,1,1},{0,0,0,0},{1,0,1,0}};
		System.out.println(numRectangles(a));
	}



}

