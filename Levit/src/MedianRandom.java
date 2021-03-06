import java.util.Arrays;
public class MedianRandom {
	// get and print random array 
	public static int[] randArray(int size){
		int [] a = new int[size];
		for(int i=0; i<a.length; i++){
			a[i] = (int)(Math.random()*a.length*10);
		}
		return a;
	}
	public static void printArray(int [] arr){
		for(int t=0; t<arr.length; t++){
			System.out.print(arr[t]+", ");
		}
		System.out.println();
	}
	public static int medianSort(int arr[]){
		Arrays.sort(arr);
		return arr[arr.length/2];
	}
	public static int median64(int arr[], int first){
		int max = arr[0];
		for (int i=0; i<first; i++){
			if (max < arr[i]) max=arr[i];
		}
		return max;
	}
	public static void main(String[] args) {
		int a[], med64, med; 
		int count = 0, size = 100001, first = 15;
		for (int i=0; i<100; i++){
			a = randArray(size);
//			printArray(a);
			med64 = median64(a, first);
			med = medianSort(a);
//			printArray(a);
			if (med64>=med) count++;
//			System.out.println("med64="+med64+", med="+med);
		}	
		System.out.println("count = "+count+"%");
	}
}
