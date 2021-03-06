public class LCS_Greedy {
	/**
	 * The greedy algorithm 
	 * @param X - the first string,  Y - the second string
	 * @return string which contains the longest common sequence
	 */
	public static String greedy(String X, String Y){//O(m*n),  m=X.length(), n=Y.length()
		String ans = "";
		int start = 0;
		for (int i=0; i<X.length(); i++){
			int index = Y.indexOf(X.charAt(i), start);
			if (index != -1){
				ans = ans + X.charAt(i);
				start = index+1;
			}
		}
		return ans;
	}
	
	public static String greedyWithHelp(String X, String Y){
		//associative memory 
		// O(m + n) + O(min(m,n))
		int help[] = new int[26];
		for (int i=0; i<X.length(); i++){//O(min(m,n))
			int place = (X.charAt(i)-'a');
			help[place]++;
		}
		String ans = "";
		int start = 0;
		for (int i=0; i<Y.length(); i++){//O(m+n)
			int place = (Y.charAt(i)-'a');
			if (help[place] > 0){
				int index = X.indexOf(Y.charAt(i), start);
				if (index != -1){
					ans = ans + Y.charAt(i);
					start = index+1;
					help[place]--;
				}
			}
		}
		return ans;
	}
	public static void checkGreedy(){
		String X = "abcbdab", Y = "bdcaba";
		String X1 = "abcd", Y1 = "acd";
		String X2 = "cdbac", Y2 = "abdbb";
		String X3 = "abcabdc", Y3 = "abcbdcbad";
		System.out.println(greedy(X, Y));
		System.out.println(greedy(Y, X));
		////////
		System.out.println(greedy(X1, Y1));
		System.out.println(greedy(Y1, X1));
		/////////
		System.out.println(greedy(X2, Y2));
		System.out.println(greedy(Y2, X2));
		/////////
		System.out.println(greedy(X3, Y3));
		System.out.println(greedy(Y3, X3));
	}
	public static void checkGreedyWithHelp(){
		String X = "abcbdab", Y = "bdcaba";
		String X1 = "abcd", Y1 = "acd";
		String X2 = "cdbac", Y2 = "abdbb";
		String X3 = "abcabdc", Y3 = "abcbdcbad";
		System.out.println(greedyWithHelp(X, Y));
		System.out.println(greedyWithHelp(Y, X));
		////////
		System.out.println(greedyWithHelp(X1, Y1));
		System.out.println(greedyWithHelp(Y1, X1));
		/////////
		System.out.println(greedyWithHelp(X2, Y2));
		System.out.println(greedyWithHelp(Y2, X2));
		/////////
		System.out.println(greedyWithHelp(X3, Y3));
		System.out.println(greedyWithHelp(Y3, X3));
	}
	public static void main(String[] args) {
		System.out.println("Check Greedy");
		checkGreedy();
		System.out.println("Check Greedy With Help");
		checkGreedyWithHelp();
	}
}
