public class GlassBall {
	
	public static int numbOfEqualExperiments(int numFloors){
		int number = 0;
		// numFloors - number of floors;
		// equal parts, length of one part sqrt(n)
		int sqrtN = (int)Math.sqrt(numFloors);
		if (sqrtN*sqrtN < numFloors){
			sqrtN = sqrtN + 1;
			if (numFloors%sqrtN == 0){
				number = numFloors/sqrtN + sqrtN - 1;
			}
			else{
				number = numFloors/sqrtN + numFloors%sqrtN;
			}
		}
		else{// numFloors = full square (numFloors = k*k)
			number = 2*sqrtN -1;
		}
		return number;
	}
	public static int numbOfDifferentExperiments(int numFloors){
		int number = 1;
		// the worst case
		// numFloors - number of floors;
		// non-equal parts: 1,2,3,4,5,...number 
		// while (1+2+...< numFloors)
		// 1+2+...+number = number*(number+1)/2
		while (numFloors > number*(number+1)/2){
			number++;
		}
		return number;
	}
	public static void useFloorPotential(int a, int arr[]){
		// if arr[i] < a arr[i+1] the ball is broken, i=1,2,...
		// numFloors - number of floors;
		// non-equal parts: 1,2,3,4,5,...number 
		// while (1+2+...< numFloors)
		// 1+2+...+number = number*(number+1)/2
		// assuption: arr[len-1]>a
		int number = 1;
		int numFloors = arr.length;
		while (numFloors > number*(number+1)/2){
			number++;
		}
		int jump = number;
		int step = number-1;
		
		while(arr[jump]<a){
			jump = jump + step;
			step = step-1;
		}
		int floor = jump - (step + 1);
		while (arr[floor] < a){
			floor++;
		}
		System.out.println("floor = "+(floor+1));
	}
	public static void numbOfEqualExperimentsSQN(int a, int arr[]){
		int numFloors = arr.length;
		int jump = (int)Math.sqrt(numFloors);
		boolean broke = false;
		for (int i=jump-1; !broke && i<numFloors; i=i+jump){
			if (arr[i] >= a){
				System.out.println("the first ball is broken at floor number "+i);
				int j = i-jump+1;
				while(!broke && j<=i){
					if (arr[j]>=a){
						broke = true; 
						System.out.println("the second ball is broken at floor number "+j);
					}
					j++;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int [] arr={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		int a = 7;
		//useFloorPotential(a, arr);
		numbOfEqualExperimentsSQN(a, arr);
	}
}
