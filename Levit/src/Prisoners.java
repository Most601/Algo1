
public class Prisoners {
	// first the lamp is on
	public static int prisonersLampOn(int n){
		boolean enter[] = new boolean[n];
		for (int i = 0; i < enter.length; i++) {
			enter[i] = false;
		}
		boolean lamp = true;
		// the fist is the counter
		int count = 0, steps = 0;
		while (count < n){
			steps++;
			int p = (int)(Math.random()*n);
			//System.out.print(p+" ");
			if (p==0){// the counter enters
				if (!enter[p]){// the counter enters for the first time 
					enter[p] = true;
					count++;
				}
				if (!lamp){
					lamp = true;
					count++;
				}
			}
			else{
				if (!enter[p] && lamp){// p>=1, prisoner enters for the first time && the lamp is on 
					lamp = false;
					enter[p] = true;
				}
			}
		}
		boolean ans = true;
		for (int i = 0; ans && i < enter.length; i++) {
			if (!enter[i]) ans = false;
		}
		//System.out.println(Arrays.toString(enter));
		return steps;
	}
	// first state of the lamp is unknown
	public static boolean prisonersLampUnknow(int n){
		int enter[] = new int[n];
		for (int i = 0; i < enter.length; i++) {
			enter[i] = 0;
		}
		// the fist is the counter
		int count = 0, steps = 0;
		boolean lamp = ((int)(Math.random()*2)==0) ? false : true; 
		while (count < 2*n){
			steps++;
			int p = (int)(Math.random()*n);
			if (p==0 && !lamp){// counter enters
				lamp = true;
				count++;
				if (enter[0] == 0){
					enter[0]++;
					count++;
				}
			}
			else{//p>=1, prisoner enters for the first and second time && the lamp is on 
				if (enter[p]<2 && lamp){
					enter[p]++;
					lamp = false;
				}
			}
		}
		boolean ans = true;
		for (int  i = 0; ans && i < enter.length; i++) {
			if (enter[i]==0) ans = false;
		}
		//System.out.println("number of steps = "+steps);
		return ans;
	}
	public static void checkPrisonersLampOn(){
		int n = 20, count = 0, nTry = 1000;
		for (int i=1; i<nTry; i++){
			count = prisonersLampOn(n) + count;
		}
		System.out.println("average number of steps = " + (double)count/nTry);
	}
	public static void checkPrisonersLampUnknown(){
		int n = 10, count = 0, nTry = 100000;
		for (int i=1; i<nTry; i++){
			if(!prisonersLampUnknow(n)) count++;
		}
		System.out.println("count = "+count); 
		//System.out.println("average number of steps = " + (double)count/nTry);
	}
	public static void main(String[] args) {
		///checkPrisonersLampOn();
		checkPrisonersLampUnknown();
	}
}
