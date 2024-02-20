import java.io.IOException;
import java.util.Scanner;
public class MovieDriver {

	public static void main(String[] args) throws IOException {
		//Used to allow looping of program
		char addMovie;
		//Create a new object of type Scanner that reads from the keyboard
		Scanner scan = new Scanner(System.in);
		//Create a new movie object
		Movie movie = new Movie();
		
		//Loop program to allow the input of multiple movies
		do {
		//Prompt the user to enter the title of a movie
		System.out.println("Enter the title of a movie");
		//Read in the line that the user types
		//Set the title in the movie object
		movie.setTitle(scan.nextLine());
		
		//Prompt the user to enter the movie's rating
		System.out.println("Enter the movie's rating");
		//Read in the line that the user types
		//Set the rating in the movie object
		movie.setRating(scan.nextLine());
		
		//Prompt the user to enter the number of tickets sold at an unnamed theater
		System.out.println("Enter the number of tickets sold for this movie");
		//Read in the integer that the user types
		//Set the number of tickets sold in the movie object
		movie.setSoldTickets(scan.nextInt());
		
		//Read previous line fed
		scan.nextLine();
		
		//Print out the information using the movie's toString method
		System.out.println(movie.toString());
		System.out.println("Do you want to enter another movie? (y or n)");
		addMovie = scan.nextLine().charAt(0);
		}while(addMovie == 'y' || addMovie == 'Y');
		System.out.println("Goodbye");
		scan.close();
	}
}