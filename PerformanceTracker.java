import java.util.Scanner;

public class PerformanceTracker{

		public static void displayScores(int[] scores){
		System.out.print("\nScores: ");
		for(int score : scores){
			System.out.printf("%d ", score);
		}
	}

	public static double getAverage(int[] scores){
		int sum = 0;

		for(int i=0; i<scores.length; i++){
			sum+=scores[i];
		}

		return (double) sum/scores.length;

	}

	public static int getHighestScore(int[] scores){
		int highestScore = scores[0];

		for(int score : scores){
			if(score > highestScore){
				highestScore = score;
			}
		}

		return highestScore;

	}

	public static int getPassScore(int[] scores){
		int passed = 0;

		for(int i=0; i<scores.length; i++){
			if(scores[i] >=60){
				passed++;
			}
		}

		return passed;
	}
	public static void displayResult(int highestScore, double average, int passed){
		System.out.printf("%nAverage: %.2f%n", average);
		System.out.printf("Highest Score: %d%n", highestScore);
		System.out.printf("Passed: %d%n", passed);

	}
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);

		int[] scores = new int[8];

		System.out.printf("Enter %d scores: %n", scores.length);
		for(int i = 0; i<scores.length; i++){
			System.out.printf("[%d] - ", i+1);
			scores[i] = input.nextInt();
		}

		displayScores(scores);

		double average = getAverage(scores);
		int highestScore= getHighestScore(scores);
		int passed = getPassScore(scores);

		displayResult(highestScore, average, passed);
	}
}	