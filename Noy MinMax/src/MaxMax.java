public class MaxMax {
	/**
	 * Find the minimum and the maximum elements in array
	 * Complexity: O(n) - 3/2*n comparisons
	 */

	public static void MaxMax(int[] array) {
		int max1,max2;

		if (array[0]>array[1]) { max1=array[0]; 
		max2=array[1]; 
		}
		else { max1=array[1]; 
		max2=array[0]; 
		}

		for (int i=2; i<array.length-1; i+=2)
		{
			int x=array[i];
			int y=array[i+1];
			if (x>y) {
				if (x>max1) { max2=max1; 
				              max1=x; 
				              if (y>max2) max2=y; 
			               	}
				else if (x>max2) max2=x;
			}
			else { 
				  if (y>max1) { max2=max1; 
				                max1=y; 
			                 	if (x>max2) max2=x; 
			                	}
				else if (y>max2) max2=y;
			}
		}

		int end=array[array.length-1];
		if (array.length%2!=0) if (end>max1) {max2=max1; 
		                                      max1=end; 
	                                        }
	                          	else if (end>max2) max2=end;


		System.out.println("max1="+max1+" max2="+max2);
	}

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int[]array={-5,2,3,4,5,3,100,45};
	MaxMax(array);
    }
}



