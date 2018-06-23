
import java.util.Arrays;
import java.util.Scanner;
class Main{

	public static void main(String[] args){

		Scanner scanner = new Scanner(System.in);
		int eid = scanner.nextInt();

		int[] arr = new int[eid];

		for(int i=0; i < eid; i++){
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
