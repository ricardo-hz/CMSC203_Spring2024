/*
 * Class: CMSC203 CRN 30339
 * Instructor: Grigoriy Grinberg
 * Description: This class manipulates two dimensional ragged arrays to complete actions such as
 * reading from and writing to a file, calculating the totals of rows/columns and the entirety of a ragged
 * array, getting the average of the array, and finding maximums and minimums of rows/columns and the
 * entirety of a ragged array.
 * Due: 04/15/2024
 * Platform/compiler: Windows 10 Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ricardo Hernandez
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public final class TwoDimRaggedArrayUtility {
	
	/**
	 * Returns the average of the elements in the two dimensional array
	 * @param data the array to be searched
	 * @return The avg of the elements in the two dimensional array
	 */
	public static double getAverage(double[][] data) {
		int numElements = 0;
		double total = 0;
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				total += data[row][col];
				numElements++;
			}
		}
		return total/numElements;
	}
	

	/**
	 * Returns the total of all elements of the two dimensional array
	 * @param data the two dimensional array getting total of
	 * @return the sum of all elements in the two dimensional array
	 */
	public static double getTotal(double[][] data) {
		//Accumulator
		double total = 0;
		//Add value of each element to accumulator
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				total+=data[row][col];
			}
		}
		return total;
	}
	
	/**
	 * Returns the total of the selected row in the two dimensional array index 0 refers to the first row.
	 * @param data the two dimensional array
	 * @param row the row index to take the total of (0 refers to the first row)
	 * @return the total of the row
	 */
	public static double getRowTotal(double[][] data, int row) {
		//Accumulator
		double total = 0;
		//Add each element from the specified row to accumulator
		for(int col = 0; col < data[row].length; col++) {
			total += data[row][col];
		}
		return total;
	}
	
	/**
	 * Returns the total of the selected column in the two dimensional array index 0 refers to the first column. If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * @param data the two dimensional array
	 * @param col the column index to take the total of (0 refers to the first column)
	 * @return the total of the column
	 */
	public static double getColumnTotal(double[][] data, int col) {
		//Accumulator
		double total = 0;
		//Add each element from the specified column to accumulator
		for(int row = 0; row < data.length; row++) {
			//Do not attempt to add a row of the column that doesn't exist to the total
			if(col < data[row].length) {
				total += data[row][col];
			}
		}
		return total;
	}
	
	/**
	 * Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row.
	 * @param data the two dimensional array
	 * @param row the index of the row to be searched
	 * @return the highest column value in the index given
	 */
	public static double getHighestInRow(double[][] data, int row) {
		/*
		 * Assume the highest number is the smallest possible double value instead of 0. This variable is
		 * the smallest possible double value instead of 0 because if there is a row of only negative numbers
		 * this method would not work.
		 */
		double highestInRow = Double.MIN_VALUE;
		//Iterate over the row, changing the value of highestInRow to the highest value seen
		for(int col = 0; col < data[row].length; col++) {
			//Do not attempt to check a column of the row if it doesn't exist
			if(data[row][col] > highestInRow) {
				highestInRow = data[row][col];
			}
		}
		return highestInRow;
	}
	
	/**
	 * Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row.
	 * @param data the array to be searched
	 * @param row the index of the row to be searched
	 * @return the index of the highest column within the specified row
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		//Assume that the index of the highest col in row is the first index (column 0)
		int highestInRowIndex = 0;
		/*
		 * Iterate over each column of the row given. If any iteration gives a higher value than 
		 * array[row][current highest index], change current highest index to the iteration number
		 */
		for(int col = 0; col < data[row].length; col++) {
			if(data[row][col] > data[row][highestInRowIndex]) {
				highestInRowIndex = col;
			}
		}
		return highestInRowIndex;
	}
	
	/**
	 * Returns the smallest element of the selected row in the two dimensional array index 0 refers to the first 
	 * row.
	 * @param data the array to be searched
	 * @param row the row of the array to be searched
	 * @return the lowest value in the specified row
	 */
	public static double getLowestInRow(double[][] data, int row) {
		/*
		 * Assume the lowest number is the biggest possible double value instead of some obscure value like 9999999. 
		 * This variable is the biggest possible double value instead of 9999999 because on the off chance that the 
		 * smallest number is still bigger than that abnormally high number, this method would not work.
		 */
		double lowestInRow = Double.MAX_VALUE;
		/*
		 * Iterate through each column of given row. If any value found is lower than current lowest value, change current
		 * lowest value to value found.
		 */
		for(int col = 0; col < data[row].length; col++) {
			if(data[row][col] < lowestInRow) {
				lowestInRow = data[row][col];
			}
		}
		return lowestInRow;
	}
	
	/**
	 * Returns the index of the smallest element of the selected row in the two dimensional array index 0 
	 * refers to the first row.
	 * @param data the array to be searched
	 * @param row the row index to be searched
	 * @return the index of the lowest value in the specified row index
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		//Assume that the index of the lowest col in row is the first index (column 0)
		int lowestInRowIndex = 0;
		/*
		 * Iterate over each column of the row given. If any iteration gives a lower value than 
		 * array[row][current lowest index], change current lowest index to the iteration number
		 */
		for(int col = 0; col < data[row].length; col++) {
			if(data[row][col] < data[row][lowestInRowIndex]) {
				lowestInRowIndex = col;
			}
		}
		return lowestInRowIndex;
	}
	
	/**
	 * Returns the largest element of the selected column in the two dimensional array index 0 refers to the 
	 * first column. If a row in the two dimensional array doesn't have this column index, it is not an error, 
	 * it doesn't participate in this method.
	 * @param data the array to be searched
	 * @param col the column index of the array to be searched
	 * @return the highest value in the specified column
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		/*
		 * Assume the highest number is the smallest possible double value instead of 0. This variable is
		 * the smallest possible double value instead of 0 because if there is a column of only negative numbers
		 * this method would not work.
		 */
		double highestInColumn = Double.MIN_VALUE;
		/*
		 * Iterate through each column of given row. If any value found is higher than current highest value, change current
		 * highest value to value found.
		 */
		for(int row = 0; row < data.length; row++) {
			if(col < data[row].length) {
				if(data[row][col] > highestInColumn) {
					highestInColumn = data[row][col];
				}
			}
		}
		return highestInColumn;
	}

	/**
	 * Returns index of the largest element of the selected column in the two dimensional array index 0 refers 
	 * to the first column. If a row in the two dimensional array doesn't have this column index, it is 
	 * not an error, it doesn't participate in this method.
	 * @param data the array to be searched
	 * @param col the column of the array to be searched
	 * @return the index of the highest value in the column
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		//Assume that the index of the highest row in col is the first index (row 0)
		int highestInColumnIndex = 0;
		/*
		 * Iterate over each row of the column given. If any iteration gives a higher value than 
		 * array[col][current highest index], change current highest index to the iteration number
		 */
		for(int row = 0; row < data.length; row++) {
			if(col < data[row].length) { 
				if(data[row][col] > data[highestInColumnIndex][col]) {
					highestInColumnIndex = row;
				}
			}
		}
		return highestInColumnIndex;
	}
	
	/**
	 * Returns the smallest element of the selected column in the two dimensional array index 0 refers to the 
	 * first column. If a row in the two dimensional array doesn't have this column index, it is not an error, 
	 * it doesn't participate in this method.
	 * @param data the array to search
	 * @param col the column to search
	 * @return the lowest value in the specified column
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		/*
		 * Assume the lowest number is the biggest possible double value instead of some obscure value like 9999999. 
		 * This variable is the biggest possible double value instead of 9999999 because on the off chance that the 
		 * smallest number is still bigger than that abnormally high number, this method would not work.
		 */
		double lowestInColumn = Double.MAX_VALUE;
		/*
		 * Iterate through each row of given column. If any value found is lower than current lowest value, change current
		 * lowest value to value found.
		 */
		for(int row = 0; row < data.length; row++) {
			if(col < data[row].length) {
				if(data[row][col] < lowestInColumn) {
					lowestInColumn = data[row][col];
				}
			}
		}
		return lowestInColumn;
	}
	
	/**
	 * Returns the index of the smallest element of the selected column in the two dimensional array index 0 
	 * refers to the first column. If a row in the two dimensional array doesn't have this column index, 
	 * it is not an error, it doesn't participate in this method.
	 * @param data the array to be searched
	 * @param col the column index to be searched
	 * @return the index of the lowest value in the specified column index
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		//Assume that the index of the lowest row in col is the first index (row 0)
		int lowestInColumnIndex = 0;
		/*
		 * Iterate over each row of the column given. If any iteration gives a lower value than 
		 * array[col][current lowest index], change current lowest index to the iteration number
		 */
		for(int row = 0; row < data.length; row++) {
			if(col < data[row].length) {
				if(data[row][col] < data[lowestInColumnIndex][col]) {
					lowestInColumnIndex = row;
				}
			}
		}
		return lowestInColumnIndex;
	}
	
	/**
	 * Returns the largest element in the two dimensional array
	 * @param data the array to be search
	 * @return the largest element in the data array
	 */
	public static double getHighestInArray(double[][] data) {
		/*
		 * Assume the highest number is the smallest possible double value instead of 0. This variable is
		 * the smallest possible double value instead of 0 because if there is a column of only negative numbers
		 * this method would not work.
		 */
		double highestInArray = Double.MIN_VALUE;
		/*
		 * Iterate through each element of the array, replacing highestInArray every time a new highest value
		 * has been found.
		 */
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				if(data[row][col] > highestInArray) {
					highestInArray = data[row][col];
				}
			}
		}
		return highestInArray;
	}
	
	/**
	 * Returns the smallest element in the two dimensional array
	 * @param data the array to be search
	 * @return the smallest element in the data array
	 */
	public static double getLowestInArray(double[][] data) {
		/*
		 * Assume the lowest number is the biggest possible double value instead of some obscure value like 9999999. 
		 * This variable is the biggest possible double value instead of 9999999 because on the off chance that the 
		 * smallest number is still bigger than that abnormally high number, this method would not work.
		 */
		double lowestInArray = Double.MAX_VALUE;
		/*
		 * Iterate through each element of the array, replacing lowestInArray every time a new lowest value
		 * has been found.
		 */
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				if(data[row][col] < lowestInArray) {
					lowestInArray = data[row][col];
				}
			}
		}
		return lowestInArray;
	}
	
	/**
	 * Reads from a file and returns a ragged array of doubles The maximum rows is 10 and the maximum columns for each row
	 *  is 10 Each row in the file is separated by a new line Each element in the row is separated by a space
	 * @param file the file to read from
	 * @return a two dimensional ragged (depending on data) array of doubles if the file is not empty.
	 * @throws FileNotFoundException
	 */
	public static double[][] readFile(File file) throws FileNotFoundException{
		double[][] array = new double[10][10];
		try(Scanner scan1 = new Scanner(file);
				Scanner scan2 = new Scanner(file)){
		String[] tokenizedLine;
		
		
		int numLines = 0;
		while(scan1.hasNextLine()){
			numLines++;
			scan1.nextLine();
		}
		array = new double[numLines][];
		
		while(scan2.hasNextLine()) {
			for(int row = 0; row < numLines; row++) {
				tokenizedLine = scan2.nextLine().split(" ");
				array[row] = new double[tokenizedLine.length];
				
				for(int col = 0; col < array[row].length; col++) {
					array[row][col] = Double.parseDouble(tokenizedLine[col]);
				}
				
				
			}
			
		}
		
		}catch(FileNotFoundException fnfe) {
			System.out.println("The file does not exist!");
		}
		return array;
	}
		
	/**
	 * Writes the ragged array of doubles into the file. Each row is on a separate line within the file and each double is separated by a space.
	 * @param data the two dimensional ragged array of doubles
	 * @param outputFile the file to write to
	 * @throws IOException if outputFile is not valid
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		//Write data in each row. Once finished with row, move to next
		try(PrintWriter pw = new PrintWriter(outputFile)){
			for(int row = 0; row < data.length; row++) {
				for(int col = 0; col < data[row].length; col++) {
					pw.append(data[row][col] + " ");
				}
				pw.append('\n');
			}
		}
		catch(FileNotFoundException fnfe) {
			System.out.println("The file could not be found.");
		}
	}
}
