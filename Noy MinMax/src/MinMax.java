public class MinMax {
	/**
	 * Find the minimum and the maximum elements in array
	 * Complexity: O(n) - 3/2(n) comparisons
	 */
	int max,min;
	int size;

	public MinMax(int[] a){
		size =a.length;
		int x,y;
		x=a[0];
		y=a[1];
		if (x>y) {
			max=x;
			min=y;
		}
		else {
			max=y;
			min=x;
		}

		for (int i = 2; i < size-1; i+=2) {//n/2
			x=a[i];
			y=a[i+1];
			if (x>y) {
				if (x>max)  	max=x;
				if (y<min) 		min=y;
			}
			else {
				if (y>max)  	max=y;
				if (x<min)  	min=x;
			}
		}

		if (size%2!=0) {
			if (a[size-1]>max) max = a[size-1];
			else if(a[size-1]<min)  min =a[size-1];
		}

		System.out.println("min="+min+" max="+max);

	}


}
