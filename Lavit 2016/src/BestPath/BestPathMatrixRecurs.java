package BestPath;
public class BestPathMatrixRecurs {
		public static void directOverLook(Node[][] mat){
		// n rows, m columns
		int n = mat.length, m = mat[0].length;
		mat[0][0].price = 0;
		for (int i=1; i<n; i++){// first column
			mat[i][0].price = mat[i-1][0].y+  mat[i-1][0].price;
			mat[i][0].numOfPaths = 1;
		}
		
		System.out.println();
		printPrices(mat);
		for (int j=1; j<m; j++){// first row
			mat[0][j].price = mat[0][j-1].price +  mat[0][j-1].x;
			mat[0][j].numOfPaths = 1;
		}
		System.out.println();
		printPrices(mat);
		for (int i=1; i<n; i++){
			for (int j=1; j<m; j++){
				int x = mat[i-1][j].price+mat[i-1][j].y;
				int y = mat[i][j-1].price+mat[i][j-1].x;
				mat[i][j].price = x<=y ? x : y;
				if (x<y){
					mat[i][j].price = x;
					mat[i][j].numOfPaths = mat[i-1][j].numOfPaths;
				}
				else if (x>y) {
					mat[i][j].price = y;
					mat[i][j].numOfPaths = mat[i][j-1].numOfPaths;
				}
				else{//x==y
					mat[i][j].numOfPaths = mat[i][j-1].numOfPaths+mat[i-1][j].numOfPaths;
				}
			}
		}
	}
	//calculate all the cheapest pats
	public  static void reverseOverLook(Node[][] mat){
		int n = mat.length, m = mat[0].length; 
		int len = n + m - 1;//path length
		int numOfPaths = mat[n-1][m-1].numOfPaths;
		StringBuffer[] mp = new StringBuffer[numOfPaths];
		for (int i = 0; i < mp.length; i++) {
			mp[i] = new StringBuffer();
		}
		buildPaths(mat, mp, 0, n-1, m-1);
		System.out.println("the cheepeast path:");
		for (int i = 0; i < mp.length; i++) {
			System.out.println(mp[i]);
		}
	}
	public  static void buildPaths(Node[][] mat,StringBuffer[] mp, int numP, int i, int j){
		if (i<1 || j<1) return;
		int x =mat[i][j-1].price + mat[i][j-1].x;
		int y = mat[i-1][j].price + mat[i-1][j].y;
		if (x<y){
			mp[numP].append('0');
			buildPaths(mat, mp, numP, i, j-1);
		}
		else if(x>y){
			mp[numP].append('1');
			buildPaths(mat, mp, numP, i-1, j);
		}
		else{//x==y
			mp[numP].append('0');
			mp[numP+1] = mp[numP+1].append('1');
			buildPaths(mat, mp, numP+1, i-1, j);
			buildPaths(mat, mp, numP+1, i, j-1);
		}
	}
	
	// Print matrix of prices
	public static void printPrices(Node[][] mat){
		System.out.println("\nmatrix of prices in right direction\n");
		for (int i=0; i<mat.length; i++){
			for (int j=0; j<mat[0].length; j++){
				System.out.print(mat[i][j].price+" ");
			}
			System.out.println();
		}
	}
	public static void printCheepestPaths(Node[][] mat){
		System.out.println("\nmatrix of cheepest paths in right direction\n");
		for (int i=0; i<mat.length; i++){
			for (int j=0; j<mat[0].length; j++){
				System.out.print(mat[i][j].numOfPaths+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Node[][] nd = InitMatrixOfPrices.initMatOfNodes2();
		long start = System.currentTimeMillis();
		directOverLook(nd);
		reverseOverLook(nd);
		long end = System.currentTimeMillis();
		// print time in milliseconds
		System.out.println("\nTime for matrix "+(end-start)+" milliseconds");
		printPrices(nd);
		printCheepestPaths(nd);
	}
}
