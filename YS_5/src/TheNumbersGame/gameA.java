package TheNumbersGame;

import Utils.MyConsole;

public class gameA {
	
	private int arr[] ; 
	private MyConsole a ; 
	private static int size = 10 ; 
	private static final int mr = 10  ; 
	private static final int maxNumber = 90 ;
	private boolean isHuman ; 
	
	
	public gameA (){
		arr = new int[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i]= (int)(Math.random()*80) + 10 ;
		}
		a = new MyConsole();
	}
	public gameA (int arr1[]){
		size = arr.length;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr1[i] ; 
		}
		a = new MyConsole();
	}
	public String toString(int l,int r){
		String s = "[ " ; 
		if ( l < 0 || r > arr.length-1  ) return " " ; 
		for (int i = l; i < r ; i++) {
			s = s + arr[i] + " " ; 
		}
		return s + arr[r] + " ]"; 
	}
	public int sum(boolean is, int l, int r){ 
		int sum =  0 , i = l ;
		if ( l < 0 || r > arr.length-1  ) return 0 ;
		if (is){
			if ( l%2 == 0) i = l ; 
			else i = l+1  ; 
			}
		else {
			if ( l%2 == 0) i = l+1 ; 
			else i = l  ; }
		
		for ( int j = i ; j < r+1 ; j+=2) {
			sum+=arr[j];
			
		}
		return sum;
		
		
	}
	public void theGamePart01() {
		int  start = 0 , end = this.arr.length-1 , sum1 = 0 , sum2 = 0 ;	
		int sumz = sum(true ,start , end );
		int sume = sum(false ,start , end );
		boolean is = false; 
		System.out.println(toString(start, end));

		while (start < end ){
			System.out.println(toString(start, end));
			is = false ;
			if ( sumz > sume ) is = true ;
			else if ( sumz == sume ){
				if( arr[start] > arr[end] ){
					if (start%2 == 0 )is = true ; 
					else is = false ; 
				}
				else {
					if (start%2 == 0 )is = false ; 
					else is = true ; 
				}
			}
					
			if (is){
				if ( start%2 == 0 ){
					//sumz -= arr[start] ;
					sum1 += arr[start];
					start++;
				}
				else {
					//sumz -= arr[end];
					sum1 += arr[end];
					end--;
				}
			}
			else {
				if ( start%2 == 0 ){
					//sume -= arr[end] ;
					sum1 += arr[end];
					end--;
				}
				else {
					//sume -= arr[start];
					sum1 += arr[start];
					start++;
				}
			}
			System.out.println(toString(start, end));
			//int c = a.getInt(" user : ");
			int c = (int)(Math.random()*2);
			if (c == 0 ){
				sum2 += arr[start] ;
//				if ( start%2 ==0 ) sumz -= arr[start];
//				else sume -= arr[start];
				start++;
			}
			else {
				sum2 += arr[end];
//				if ( start%2 == 0 ) sume -= arr[end];
//				else sume -= arr[end];
				end--;
			}
			
				
				
				
					
				
				
		}
		System.out.println(" sum1 :"+sum1+" , sume2 : "+sum2 );
			
			
			
			
			
			
			
			
			
			
			
			
	
	}
	public static void main(String[] args) {
		gameA a = new gameA();
		a.theGamePart01();
		
	}
		
		
		
}


