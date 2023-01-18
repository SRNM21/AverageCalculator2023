package project;

import java.util.Scanner;
import java.util.Random;

public class AverageCalculator {
	// last edited 12/05/2022
	
	static String subjects[] = {"Filipino", "English", "Math", "Science"
            ,"A.P.", "E.S.P.", "P.E.", "T.L.E."};
	static double grades[] = new double[8];
	static double average = 0;
	
	public static void main(String[] args) {
		
		getAverage();
		String status = averageStatus();
		
		System.out.println("\nYour average is " + average + ", " + status);
		if (average < 75){
			String qoutes = quotes();
			System.out.print("\n" + qoutes);
		}
	}
	
	public static double getAverage(){
		try (Scanner s = new Scanner(System.in)) {
			for (int i = 0; i < subjects.length; i++){
				System.out.print("Enter " + subjects[i] + " grade:\t\t");
				grades[i] = s.nextDouble();
				if (grades[i] > 100 || grades[i] < 0){
				    do{
				        System.out.print("\nInvalid grade, please your " + subjects[i] +" grade again:\t");
				        grades[i] = s.nextDouble();
				    } while (grades[i] > 100 || grades[i] < 0);
				}
			}
		} catch (Exception e){
			System.out.println("Invalid Input\n");
			System.out.println("END OF THE PROGRAM");
		}
		
		for (int i = 0; i < subjects.length; i++){
			average += grades[i];
		} 
		return average /= 8;
	}
		
	public static String averageStatus(){
		if (average >= 98) return "WITH HIGHEST HONOR";
		else if (average >= 95) return "WITH HIGH HONOR";
		else if (average >= 90) return "WITH HONOR";
		else if (average >= 75) return "PASSED";
		else return "FAILED";
	}
	
	public static String quotes(){
		Random r = new Random();
		String quotes[] = {
			"Failure isn't fatal, but failure to change might be\n\t- John Wooden",
			"Everything you want is on the other side of fear.\n\t- Jack Canfield",
			"Success is most often achieved by those who don't know that failure is inevitable\n\t- Coco Chanel",
			"Only those who dare to fail greatly can ever achieve greatly.\n\t- Robert F. Kennedy",
			"If you're not prepared to be wrong, you'll never come up with anything original.\n\t- Ken Robinson"
		};
	
		int random = r.nextInt(5)+1; 
		String quote = quotes[random];
		return quote;
	}
}
