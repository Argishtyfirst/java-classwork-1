import java.util.Arrays;
import java.util.Scanner;

class Main{

	public static void main(String[] args){

		Scanner scanner = new Scanner(System.in);
		int arraySize = scanner.nextInt();

		int[] arr = new int[arraySize];

		for(int i=0; i < arraySize; i++){
			arr[i]=scanner.nextInt();
		}

                int max = arr[0];

		for(int i=1; i<arr.length; i++){
			max = compare(max, arr[i]);
		}

		System.out.println(max);

	}


       private static int compare(int a,int b){
		int c = a - b;
		int sign = c>>>31;
		int max = a - sign*c;

		return max;
        }
}
