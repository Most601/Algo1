import java.util.Iterator;
import java.util.Vector;




public class plane {
	
	public static void BMAT(Node mat[][]){

		for (int i = 1; i < mat.length; i++) {
			mat[i][0].price = mat[i-1][0].price + mat[i-1][0].y ;
			mat[i][0].numOfPaths = 1;
		}
		for (int i = 1; i < mat[0].length; i++) {
			mat[0][i].price = mat[0][i-1].price + mat[0][i-1].x ; 
			mat[0][i].numOfPaths = 1 ;
		}
		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {
				int a = mat[i-1][j].price + mat[i-1][j].y ;
				int b = mat[i][j-1].price + mat[i][j-1].x ; 
				if ( a > b ){
					mat[i][j].price = mat[i][j-1].price + mat[i][j-1].x ; 
					mat[i][j].numOfPaths = mat[i][j-1].numOfPaths ;
				}
				else if ( a < b ){
					mat[i][j].price = mat[i-1][j].price + mat[i-1][j].y ; 
					mat[i][j].numOfPaths = mat[i-1][j].numOfPaths ;
				}
				else {
					mat[i][j].price = mat[i][j-1].price + mat[i][j-1].x; 
					mat[i][j].numOfPaths = mat[i-1][j].numOfPaths + mat[i][j-1].numOfPaths ;
				}
				
			}
		}
		

		
		
		
	}
	public static String AR ( Node mat[][] ){
		BMAT(mat);
		Vector<String> ans = new Vector<String>();
		printPrices(mat);
		printCheepestPaths(mat);
		ARRr(mat , ans , mat.length-1 , mat[0].length-1 , new String());
		for (String string : ans) {
			System.out.println(string);
			
		}
		return ans.get(0);
	}
	public static void ARRr ( Node mat[][] , Vector<String> ans ,
			int x , int y , String temp  ){
		if ( x >0 && y > 0 ){
			int a = mat[x-1][y].price + mat[x-1][y].y ;
			int b = mat[x][y-1].price + mat[x][y-1].x ; 
			if ( a>b){
				ARRr(mat , ans , x , y-1 , "0"+temp);
			}
			else if ( a<b){
				ARRr(mat , ans , x-1 , y , "1"+temp);
			}
			else {
				ARRr(mat , ans , x , y-1 , "0"+temp);
				ARRr(mat , ans , x-1 , y , "1"+new String(temp));
			}
		
			
		}
		
		else if ( x == 0 ){
			for (int i = y;  i > 0; i--) {
				temp = "0"+temp;
				y--;
				
			}
		}
		else if ( y == 0 ){
			for (int i = x;  i > 0; i--) {
				temp = "1"+temp;
				x--;
				
			}
		}
		if ( x == 0 && y == 0 ){
			ans.addElement(temp);	
		}
	}
	
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
		Node mat[][] = InitMatrixOfPrices.initMatOfNodes3(6 , 6);
		String ans = AR(mat);
		
	}

}
