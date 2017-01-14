
public class LCS_Hamdany {
	
	
	public static String LCSA(String a , String b ){
		String ans = "" ;
		int start = 0 ; 
		for (int i = 0; i < a.length(); i++) {
			int index  = b.indexOf(a.charAt(i), start);
			if (index != -1 ){
				ans = ans  + a.charAt(i);
				start = index+1;
			}
		}
		return ans ; 
	}
	
	public static String LCSB(String a , String b ){
		int arr[] = new int [26]; 
		for (int i = 0; i < a.length(); i++) {
			int place = a.charAt(i) - 'a' ; 
			arr[place]++;
		}
		String ans  = "";
 		int start = 0 ; 
 		for (int i = 0; i < b.length(); i++) {
			int place  = b.charAt(i) - 'a' ; 
			if ( arr[place] > 0 ){
				int index  = a.indexOf(b.charAt(i), start );
				if(index != -1){
				start = index + 1 ;
				ans = ans + b.charAt(i);
				arr[place]--;
				}
				
			}
		}
		return ans;
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(LCSA("bxxxa" , "axxxb"));
		System.out.println(LCSB("bxxxa" , "axxxb"));

	}

}
