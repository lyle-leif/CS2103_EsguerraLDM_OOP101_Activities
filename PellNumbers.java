import java.util.Scanner;

public class PellNumbers{
	public static Integer getPellNumber(int n){
		if(n < 0){
			return null;
		}
		if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		return 2*getPellNumber(n-1) + getPellNumber(n-2);
	}
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);

		int n;

		System.out.print("Enter n: ");
		n = input.nextInt();

		Integer pellNumber = getPellNumber(n);

		if(pellNumber != null){
			System.out.printf("Pell number at position %d: %d%n", n,  pellNumber);
		} else{
			System.out.println("Invalid input.");
		}

		input.close();


	}	
}