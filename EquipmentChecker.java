import java.util.Scanner;
import java.util.InputMismatchException;

class InvalidBorrowingHoursException extends Exception{
	public InvalidBorrowingHoursException(String message){
		super(message);
	}
}


public class EquipmentChecker{



	public static String getEquipmentName(int code){
		return switch(code){
			case 101 -> "Camera";
			case 102 -> "Tripod";
			case 103 -> "Microphone";
			case 104 -> "Projector";
			default -> throw new IllegalArgumentException("Invalid equipment code.");
		};
	}

	public static void validateHours(int hours)
		throws InvalidBorrowingHoursException{

			if(hours < 1 || hours > 8){
				throw new InvalidBorrowingHoursException ("borrowing hours must be between 1 and 8.");
			}
		}
	

	public static void displayResult(String name, int hour){
		System.out.printf("Equipment: %s%n", name);
		System.out.printf("Borrowing Hours: %d%n", hour);
		System.out.println("Status: Borrowing request accepted.");
	}

	public static void main(String[]args){
		Scanner input = new Scanner(System.in);

		int equipmentCode, borrowingHour;

		try{
			System.out.print("Enter equipment code: ");
			equipmentCode = input.nextInt();

			System.out.print("Enter borrowing hours: ");
			borrowingHour = input.nextInt();


		String equipment = getEquipmentName(equipmentCode);
		validateHours(borrowingHour);	

		displayResult(equipment, borrowingHour);
		} catch(InputMismatchException e){
			System.out.println("Error: Please enter an integer.");
		} catch(IllegalArgumentException e){
			System.out.printf("Error: %s%n", e.getMessage());
		} catch(InvalidBorrowingHoursException e){
			System.out.printf("Error: %s%n", e.getMessage());
		}

		input.close();


		
	}
}