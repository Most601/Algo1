/**
	 * The full algorithm 
	 * @param X - the first string,  Y - the second string
	 * @return string which contains the longest common sequence
	 */
public class LCS_FULL{		// O(2^(m + n)*(min(m,n))

	public static String LCS (String s1,String s2){
		String str1[]=LCS_GROUP_matrix(s1);
		String str2[]=LCS_GROUP_matrix(s2);
		String max_lcs="";
		for (int i=0; i<str1.length; i++)
			for (int j=0; j<str2.length; j++)
				if (str1[i].equals(str2[j])) if (str1[i].length()>max_lcs.length()) max_lcs=str1[i];
		return max_lcs;
	}

	public static String[] LCS_GROUP_matrix (String s){
		String []groups =new String [(int) Math.pow(2,s.length())];
		for (int i=0; i<Math.pow(2,s.length()); i++)
		{
			int []temp=IntToBinnary(i,s.length());
			String str="";
			for (int j=0; j<temp.length; j++){
				if (temp[j]==1) str+=s.charAt(j);
			}
			groups[i]=str;
		}
		return groups;
	}


	public static void LCS_GROUP (String s){
		for (int i=0; i<Math.pow(2,s.length()); i++)
		{
			int []temp=IntToBinnary(i,s.length());
			for (int j=0; j<temp.length; j++)
				if (temp[j]==1) System.out.print(s.charAt(j));
			System.out.println();
		}
	}

	public static int [] IntToBinnary(int num,int s_length)
	{
		int array[]=new int[s_length];
		int index=0;
		while (num>0){
			if (num%2==1) array[index]=1;
			else  array[index]=0;
			index++;
			num=num/2;
		}
		return array;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//LCS_GROUP_matrix("abcd");
		//System.out.println();
		//LCS_GROUP_matrix("acc");
		//System.out.println(LCS("abcd","abcd"));

		String X = "abcbdab", Y = "bdcaba";
		String X1 = "abcd", Y1 = "acd";
		String X2 = "cdbac", Y2 = "abdbb";
		String X3 = "abcabdc", Y3 = "abcbdcbad";
		System.out.println(LCS(X, Y));
		System.out.println(LCS(Y, X));
		System.out.println(LCS(X1, Y1));
		System.out.println(LCS(Y1, X1));
		System.out.println(LCS(X2, Y2));
		System.out.println(LCS(Y2, X2));
		System.out.println(LCS(X3, Y3));
		System.out.println(LCS(Y3, X3));
	}}
