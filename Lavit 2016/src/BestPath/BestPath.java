package BestPath;

public class BestPath {

	int cheapestPrice, numOfPaths;
	private Node [][]mat;
	
	public BestPath(int example){
		cheapestPrice = 0;
		numOfPaths = 0;
		if (example==1) mat = InitMatrixOfPrices.initMatOfNodes1();
		else if (example==2) mat = InitMatrixOfPrices.initMatOfNodes2();
		else if (example==3) mat = InitMatrixOfPrices.initMatOfNodes3(6,6);
		getBestPrice();
	}
	// build matrix
	private void getBestPrice(){
		// n rows, m columns
		int n = mat.length, m = mat[0].length;
		mat[0][0].price = 0;
		for (int i=1; i<n; i++){// first column
			mat[i][0].price = mat[i-1][0].y+  mat[i-1][0].price;
			mat[i][0].numOfPaths = 1;
		}
		for (int j=1; j<m; j++){// first row
			mat[0][j].price = mat[0][j-1].price +  mat[0][j-1].x;
			mat[0][j].numOfPaths = 1;
		}
		for (int i=1; i<n; i++){
			for (int j=1; j<m; j++){
				int x = mat[i-1][j].price+mat[i-1][j].y;
				int y = mat[i][j-1].price+mat[i][j-1].x;
				mat[i][j].price = x<=y ? x : y;
				if (x<y){
					//mat[i][j].price = x;
					mat[i][j].numOfPaths = mat[i-1][j].numOfPaths;
				}
				else if (x>y) {
					//mat[i][j].price = y;
					mat[i][j].numOfPaths = mat[i][j-1].numOfPaths;
				}
				else{//x==y
					mat[i][j].numOfPaths = mat[i][j-1].numOfPaths+mat[i-1][j].numOfPaths;
				}
			}
		}
		numOfPaths = mat[n-1][m-1].numOfPaths;
		cheapestPrice = mat[n-1][m-1].price;
	}
	// Print matrix of prices
	public void printPrices(){
		System.out.println("\nmatrix of prices in right direction\n");
		for (int i=0; i<mat.length; i++){
			for (int j=0; j<mat[0].length; j++){
				System.out.print(mat[i][j].price+" ");
			}
			System.out.println();
		}
	}
	// Print matrix of paths number
	public void printNumberOfPaths(){
		System.out.println("\nthe matrix of numbers of the cheapest paths \n");
		for (int i=0; i<mat.length; i++){
			for (int j=0; j<mat[0].length; j++){
				System.out.print(mat[i][j].numOfPaths+" ");
			}
			System.out.println();
		}
	}

	String getOneCheapestPath(){
		String ans = "";
		int i = mat.length-1, j = mat[0].length-1;
		while(i>0 && j>0){
			int a = mat[i-1][j].price+mat[i-1][j].y;
			int b = mat[i][j-1].price+mat[i][j-1].x;
			if (a < b){
				ans = "1" + ans;
				i--;
			}
			else{//a>b
				ans = "0" + ans;
				j--;
			}
		}
		while (j>0){
			ans = "0" + ans;
			j--;
		}
		while (i>0){
			ans = "1" + ans;
			i--;
		}
		return ans;
	}
	public void printBestPrice(){
		System.out.println("best price = "+cheapestPrice);
	}
	public void printNumOfBestPaths(){
		System.out.println("number of paths = "+numOfPaths);
	}
	//////
	public static void main(String[] args) {
		int example = 3;
		BestPath bp = new BestPath(example);
		bp.printBestPrice();
		bp.printNumOfBestPaths();
		bp.printPrices();
		System.out.println();
		bp.printNumberOfPaths();
		System.out.println(bp.getOneCheapestPath());
	}
}
