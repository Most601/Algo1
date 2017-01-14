package Lcs_Lis;

public class LCS_Greedy {
	/**
	 * The greedy algorithm 
	 * @param X - the first string,  Y - the second string
	 * @return string which contains the longest common sequence
	 */
	public static String greedy(String X, String Y){//O(m*n),  m=X.length(), n=Y.length()
		String ans = "";
		int start = 0, index = 0;
		for (int i=0; i<X.length()&&index<Y.length(); i++){
			index = Y.indexOf(X.charAt(i), start);
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
		int start = 0, index = 0;
		for (int i=0; i<Y.length() && index<X.length(); i++){//O(m+n)
			int place = (Y.charAt(i)-'a');
			if (help[place] > 0){
				index = X.indexOf(Y.charAt(i), start);
				if (index != -1){
					ans = ans + Y.charAt(i);
					start = index+1;
					help[place]--;
				}
				else help[place] = 0;
			}
		}
		return ans;
	}
	public static String greedyAll(String X, String Y){//O(m*n),  m=X.length(), n=Y.length()
		String ans = "", max = "";
		for (int k = 0; k < X.length(); k++) {
			String sX = X.substring(k);
			ans = LCS_Greedy.greedy(sX, Y);
			if (ans.length() > max.length()){
				max = new String(ans);
			}
		}
		return max;
	}
	public static String greedyWithHelp2(String XX, String YY){
		//associative memory 
		// O(m + n) + O(min(m,n))
		String X = XX, Y = YY; // X - small, Y - big
		if (XX.length() > YY.length()){
			X = YY;
			Y = XX;
		}
		int help[] = new int[26];
		for (int i=0; i<X.length(); i++){//O(min(m,n))
			int place = (X.charAt(i)-'a');
			help[place]++;
		}
		String ans = "";
		int start = 0;
		for (int i=0; i<Y.length() && start<X.length(); i++){//O(m+n)
			int place = (Y.charAt(i)-'a');
			if (help[place] > 0){
				for (int j=start; j<X.length(); j++){
					help[X.charAt(j) - 'a']--;
					if (X.charAt(j) == Y.charAt(i)){
						start = j+1;
						ans = ans + X.charAt(j);
						break;
					}
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
		String X4 = "abcabdc", Y4 = "xyz";
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
		/////////
		String s = greedyWithHelp(X4, Y4);
		System.out.println(s.equals("") ? "empty" : s);
		s = greedyWithHelp(Y4, X4);
		System.out.println(s.equals("") ? "empty" : s);
	}
	public static void checkGreedyWithHelp2(){
		String X = "abcbdab", Y = "bdcaba";
		System.out.println(greedyWithHelp2(X, Y));
		System.out.println(greedyWithHelp2(Y, X));
		String X1 = "abcd", Y1 = "acd";
		System.out.println(greedyWithHelp2(X1, Y1));
		System.out.println(greedyWithHelp2(Y1, X1));
		String X2 = "cdbac", Y2 = "abdbb";
		System.out.println(greedyWithHelp2(X2, Y2));
		System.out.println(greedyWithHelp2(Y2, X2));
		String X3 = "abcabdc", Y3 = "abcbdcbad";
		System.out.println(greedyWithHelp2(X3, Y3));
		System.out.println(greedyWithHelp2(Y3, X3));
		
		String X4 = "abcabdc", Y4 = "xyz";
		System.out.println(greedyWithHelp2(X4, Y4));
		System.out.println(greedyWithHelp2(Y4, X4));
	}
	public static void main(String[] args) {
/*		System.out.println("Check Greedy");
		checkGreedy();
		System.out.println("Check Greedy With Help");
		checkGreedyWithHelp();
*/	
		checkGreedyWithHelp2();
	}
}
/**
Check Greedy
	aba
	bdab
	acd
	acd
	db
	a
	abcad
	abcbdc
Check Greedy With Help
	bdab
	aba
	acd
	acd
	a
	db
	abcbdc
	abcad
	empty
	empty

*/