/*
 * Class: CMSC203 CRN 30339
 * Instructor: Grigoriy Grinberg
 * Description: This program tests the user's extrasensory perception by generating a random color,
 * asking the user to enter their guess of what the color is, and comparing the two against each other.
 * Due: 02/12/2024
 * Platform/compiler: Windows 10 Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Ricardo Hernandez
*/

import java.util.Scanner;
import java.util.Random;

public class ESPGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		final int MAX_ROUNDS = 11;
		int round = 1;
		int score = 0;
		//Used for generating a random color
		Random rand = new Random();
		int randInt;
		String colorGenerated;
		final String COLOR_RED = "Red";
		final String COLOR_ORANGE = "Orange";
		final String COLOR_YELLOW = "Yellow";
		final String COLOR_GREEN = "Green";
		final String COLOR_BLUE = "Blue";
		final String COLOR_INDIGO = "Indigo";
		final String COLOR_VIOLET = "Violet";
		//User entered information
		String name;
		String userDescription;
		String colorGuessed;
		//Programmer/Project info
		final String PROGRAMMER_NAME = "Ricardo Hernandez";
		final String DUE_DATE = "02/12/2024";
		//Get info about user & display due date
		System.out.print("Enter your name: ");
		name = scan.nextLine();
		System.out.print("Describe yourself: " );
		userDescription = scan.nextLine();
		System.out.printf("Due Date: %s\n",DUE_DATE);
		System.out.println("CMSC203 Assignment 1: Test your ESP skills!\n");
		//Begin game
		for (int i = 0; i < MAX_ROUNDS; i++) {
			System.out.printf("Round %d\n",round);
			//Prompt for color
			System.out.print("I am thinking of a color.\nIs it Red, Orange, Yellow, Green, Blue, "
					+ "Indigo, or Violet?\n");
			System.out.println("Enter your guess: ");
			colorGuessed = scan.nextLine();
			//Validate color entered
			while (!colorGuessed.equalsIgnoreCase(COLOR_RED) &&
					!colorGuessed.equalsIgnoreCase(COLOR_ORANGE) &&
					!colorGuessed.equalsIgnoreCase(COLOR_YELLOW) &&
					!colorGuessed.equalsIgnoreCase(COLOR_GREEN) &&
					!colorGuessed.equalsIgnoreCase(COLOR_BLUE) &&
					!colorGuessed.equalsIgnoreCase(COLOR_INDIGO) &&
					!colorGuessed.equalsIgnoreCase(COLOR_VIOLET)){
				System.out.println(colorGuessed + " is not a valid color. Please try again.");
				System.out.print("I am thinking of a color.\nIs it Red, Orange, Yellow, Green, Blue, "
						+ "Indigo, or Violet?\n");
				System.out.println("Enter your guess: ");
				colorGuessed = scan.nextLine();
			}
			randInt = rand.nextInt(7);
			//Generate color
			switch(randInt) {
			case 0:
				colorGenerated = COLOR_RED;
				break;
			case 1:
				colorGenerated = COLOR_ORANGE;
				break;
			case 2:
				colorGenerated = COLOR_YELLOW;
				break;
			case 3:
				colorGenerated = COLOR_GREEN;
				break;
			case 4:
				colorGenerated = COLOR_BLUE;
				break;
			case 5:
				colorGenerated = COLOR_INDIGO;
				break;
			default:
				colorGenerated = COLOR_VIOLET;
			}
			//Display correct color
			System.out.printf("I was thinking of: %s.\n\n", colorGenerated);
			//Check prompted color against generated color
			if(colorGuessed.equalsIgnoreCase(colorGenerated)) {
				++score;
			}
			++round;
		}
		scan.close();
		//Closing info
		System.out.print("\nGame Over\n\n");
		System.out.printf("You guessed %d out of %d colors correctly.\n", score, MAX_ROUNDS);
		System.out.printf("Student Name: %s\n", name);
		System.out.printf("User Description: %s\n", userDescription);
		System.out.printf("Due Date: %s\n", DUE_DATE);
		System.out.printf("\nProgrammer name: %s\n", PROGRAMMER_NAME);
	}
}