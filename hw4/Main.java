import java.util.Scanner;

class Main{
	public static void main(String... args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose Type: Chess - 0, Border - 1, SubType - 2");
		int type = scanner.nextInt();
		System.out.println("Value of m");
		int m = scanner.nextInt();
		System.out.println("Value of n");
		int n = scanner.nextInt();
		int offsetValue = 0;
		String fill = " * ";
		String empty = " - ";
		if(type == 2){
			System.out.println("Value of offset");
			offsetValue = scanner.nextInt();
		}
		if(type == 0){
			for(int i = 0; i<=m; i++){
				int offset = 0;
				if(i % 2 != 0){
					offset = 1;
				}
				for(int j = offset; j <= n+offset; j++){
					if( j % 2 != 0){
						System.out.print(empty);
					}else{
						System.out.print(fill);
					}
					if(j==n+offset){
						System.out.println();
					}
				}
			}
		}else if(type == 1 || type == 2){
			for(int i = 0; i<=m; i++){
				for(int j = 0; j<=n; j ++){
					if(i>=0+offsetValue && i<=m-offsetValue){
						if(((j>=0+offsetValue && j<=n-offsetValue) && (i==0+offsetValue || i==m-offsetValue)) || (j==0+offsetValue || j==n-offsetValue)){
							System.out.print(fill);
						}else{
							System.out.print(empty);
						}	
					}else{
						System.out.print(empty);
					}
					if(j==n){
							System.out.println();
					}
				}
			}
		}
	}
}
