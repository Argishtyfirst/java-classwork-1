import java.util.Scanner;

class Main{
	static int factorial(int n){
		if(n==1){
			return 1;
		}else{
			return n * factorial(n-1);
		}
	}
	public static void main(String[] args){
		Scanner number = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n = number.nextInt();
		int fact = factorial(n);
		System.out.println(fact);
	}
}
