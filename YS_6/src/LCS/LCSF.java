package LCS;

import java.util.Vector;

public class LCSF {
	
	public static void P (int arr[]){
		int i = arr.length-1;
		while(i >= 0 && arr[i] == 1)
			arr[i--] = 0 ;
		if ( i>= 0 )arr[i] = 1;
		
		}
	public static String[] SUBA ( String a ){
		int count = (int)Math.pow(2, a.length());
		String arr[] = new String[count];
		int srr[] = new int [a.length()];
		for (int i = 0; i < count; i++) {
			String temp = "";
			P(srr);
			for (int j = 0; j < srr.length; j++) {
				 
				if(srr[j] == 1 ){
					temp = temp + a.charAt(j);
				}
			}
			arr[i] = temp;
		}
		
		
		return arr;

	}
	
	public static String LCSA ( String a , String b){
		String x[] = SUBA(a);
		String y[] = SUBA(b);
		String ans = "";
		for (String string1 : y) {
			for (String string2 : x) {
				if ( string1.equals(string2)){
					if (string1.length() > ans.length() ){
						ans = string1;
					}
				}
			}
		}
		return ans;
		
	}
	//---------------------------------------------
	
	
	public static Vector<String> SUBB ( String a ){
		String temp = "";
		Vector<String> ans = new Vector<String>();
		SUBBB ( a , ans , 0 , temp );
		
		
		
		
		return ans;
	}
	public static void SUBBB ( String a , Vector<String> ans , int i , String temp ){
		if(i == a.length() ){
			ans.addElement(temp);
			return;
		}
		SUBBB ( a , ans , i+1 , temp );
		SUBBB ( a , ans , i+1 , temp = temp + a.charAt(i));
		
		
		
	}
	
	public static String LCSB ( String a , String b){
		Vector<String> x = SUBB(a);
		Vector<String> y = SUBB(b);
		String ans = "";
		for (String string1 : y) {
			for (String string2 : x) {
				if ( string1.equals(string2)){
					if (string1.length() > ans.length() ){
						ans = string1;
					}
				}
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		String[] arr = SUBA("abcd");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println(LCSA("abcd" , "dwafcfed" ));
		System.out.println(LCSB("abcd" , "dwafcfed" ));

	}

}
