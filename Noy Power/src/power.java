/**
	 * 
	 * Complexity: O(log n) 
	 */

public class power {

	public static double power_indu (double x, int power){
		double ans=1;
		while (power>0){
			if (power%2==1) ans=ans*x;
			x=x*x;
			power=power/2;
		}
		return ans;
	}

	public static double power_recurse (double x, int power) {
		if (power==0) return 1;
		if (power%2==1) return x* power_recurse (x*x,power/2);
		else return power_recurse (x*x,power/2);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		System.out.println(power_indu(3,10));
		System.out.println(power_recurse(3,10));
		System.out.println(Math.pow(3,10));

	}
}
