package BestPath;

import java.util.Vector;

public class BestPathWholeSearch {
	
	/**
	 * find the best path by checking all the path and choose the minimal
	 * Complexity: O((n+m)choose(n)*(m+n))
	 */
	public static int wholeSearch(Node[][] mat) {
		Vector<String> allPaths = getAllPermotstions(mat);
		int min = Integer.MAX_VALUE;
		for(String path : allPaths) {
			int sum = 0,i=0,j=0;
			for (int k = 0; k < path.length(); k++) {
				if(path.charAt(k) == '0') {
					sum += mat[i][j].x;
					j++;
				}
				else {
					sum += mat[i][j].y;
					i++;
				}
			}
			if(sum < min) min =sum;
		}
		return min;
	}
	
	public static Vector<String> getAllPermotstions(Node[][] mat) {
		Vector<String> ans = new Vector<String>();
		getAllPaths(ans,mat,mat.length,mat[0].length,"");
		return ans;
	}

	private static void getAllPaths(Vector<String> ans, Node[][] mat,int i, int j, String temp) {
		if(i == 0 && j == 0) {
			ans.add(temp);
			return;
		}
		else if(i == 0) {
			getAllPaths(ans,mat,0,j-1,temp + "0");
		}
		else if(j == 0) {
			getAllPaths(ans,mat,i-1,0,temp + "1");
		}
		else {
 			getAllPaths(ans,mat,i,j-1,temp + "0");
			getAllPaths(ans,mat,i-1,j,temp + "1");
		}
	}
	
	public static void main ( String []args ){
		Node[][] mat = new Node[4][4];
		mat[0][0] = new Node(1, 2);
		mat[0][1] = new Node(1, 1);
		mat[0][2] = new Node(1, 3);
		mat[0][3] = new Node(0, 1);
		mat[1][0] = new Node(2, 3);
		mat[1][1] = new Node(5, 1);
		mat[1][2] = new Node(6, 3);
		mat[1][3] = new Node(0, 1);
		mat[2][0] = new Node(2, 4);
		mat[2][1] = new Node(7, 1);
		mat[2][2] = new Node(2, 3);
		mat[2][3] = new Node(0, 1);
		mat[3][0] = new Node(2, 0);
		mat[3][1] = new Node(1, 0);
		mat[3][2] = new Node(1, 0);
		mat[3][3] = new Node(0, 0);
		
		System.out.println(wholeSearch(mat));
		
		
		
	
		
	}
}
