/*
 * Class: CMSC203 CRN 30339
 * Instructor: Grigoriy Grinberg
 * Description: This class tests the methods found in the TwoDimRaggedArrayUtility.java file
 * Due: 04/15/2024
 * Platform/compiler: Windows 10 Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ricardo Hernandez
*/
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoDimRaggedArrayUtilityTestStudent {

	private double[][] array = 
		{
				{732.35,336.9,1172.46,1070.49,725.9,2.77},
				{-37.37,868.43,186.27,985.61},
				{175.4,361.63,468.65,961.35,1092.59,821.14},
				{1169.72,289.18,327.97,-416.54}
		};
	
	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	//Test readFile
	@Test
	void testReadFile() throws FileNotFoundException {
		//LESSON LEARNED: Getting the current directory
		String testFilePath = (System.getProperty("user.dir") + "\\src\\dataSet1.txt");
		File newFile = new File(testFilePath);
		double[][] array1 = TwoDimRaggedArrayUtility.readFile(newFile);
		double[][] array2 = 
			{
					{1,2,3},
					{4,5},
					{6,7,8}
			};
		boolean equal = true;
		
		for(int row = 0; row < array1.length; row++) {
			for(int col = 0; col < array1[row].length; col++) {
				if(array1[row].length != array2[row].length) {
					equal = false;
				}
				else if(array1[row][col] != array2[row][col]) {
					equal = false;
				}
			}
		}
		
		assertTrue(equal);
		array1 = array2 = null;
	}
	
	
	//Test writeToFile
	@Test
	void testWriteToFile() throws IOException {
		File file = new File(System.getProperty("user.dir") + "\\src\\testdocwriteto.txt");
		TwoDimRaggedArrayUtility.writeToFile(array, file);
		double[][] array2 = TwoDimRaggedArrayUtility.readFile(file);
		
		boolean equal = true;
		
		for(int row = 0; row < array.length; row++) {
			for(int col = 0; col < array[row].length; col++) {
				if(array[row].length != array2[row].length) {
					equal = false;
				}
				else if(array[row][col] != array2[row][col]) {
					equal = false;
				}
			}
		}
		assertTrue(equal);
		array2 = null;
	}
	
	//Test getTotal
	@Test
	void testGetTotal() {
		assertEquals(11294.90, TwoDimRaggedArrayUtility.getTotal(array), 0.01);
	}
	
	//Test getAverage
	@Test
	void testGetAverage() {
		assertEquals(564.75, TwoDimRaggedArrayUtility.getAverage(array), 0.01);
	}
	
	//Test getRowTotal
	@Test
	void testGetRowTotal() {
		assertEquals(4040.87, TwoDimRaggedArrayUtility.getRowTotal(array,0), 0.01);
		assertEquals(2002.94, TwoDimRaggedArrayUtility.getRowTotal(array,1), 0.01);
		assertEquals(3880.76, TwoDimRaggedArrayUtility.getRowTotal(array,2), 0.01);
		assertEquals(1370.33, TwoDimRaggedArrayUtility.getRowTotal(array,3), 0.01);
	}
	
	//Test getColumnTotal
	@Test
	void testGetColumnTotal() {
		assertEquals(2040.10, TwoDimRaggedArrayUtility.getColumnTotal(array,0), 0.01);
		assertEquals(1856.14, TwoDimRaggedArrayUtility.getColumnTotal(array,1), 0.01);
		assertEquals(2155.35, TwoDimRaggedArrayUtility.getColumnTotal(array,2), 0.01);
		assertEquals(2600.91, TwoDimRaggedArrayUtility.getColumnTotal(array,3), 0.01);
		assertEquals(1818.49, TwoDimRaggedArrayUtility.getColumnTotal(array,4), 0.01);
		assertEquals(823.91, TwoDimRaggedArrayUtility.getColumnTotal(array,5), 0.01);
	}
	
	//Test getHighestInRow
	@Test
	void testGetHighestInRow() {
		assertEquals(1172.46, TwoDimRaggedArrayUtility.getHighestInRow(array,0), 0.01);
		assertEquals(985.61, TwoDimRaggedArrayUtility.getHighestInRow(array,1), 0.01);
		assertEquals(1092.59, TwoDimRaggedArrayUtility.getHighestInRow(array,2), 0.01);
		assertEquals(1169.72, TwoDimRaggedArrayUtility.getHighestInRow(array,3), 0.01);
	}
	
	//Test getHighestInRowIndex
	@Test
	void testGetHighestInRowIndex() {
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(array,0), 0.01);
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInRowIndex(array,1), 0.01);
		assertEquals(4, TwoDimRaggedArrayUtility.getHighestInRowIndex(array,2), 0.01);
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(array,3), 0.01);
	}
	
	//Test getLowestInRow
	@Test
	void testGetLowestInRow() {
		assertEquals(2.77, TwoDimRaggedArrayUtility.getLowestInRow(array,0), 0.01);
		assertEquals(-37.37, TwoDimRaggedArrayUtility.getLowestInRow(array,1), 0.01);
		assertEquals(175.40, TwoDimRaggedArrayUtility.getLowestInRow(array,2), 0.01);
		assertEquals(-416.54, TwoDimRaggedArrayUtility.getLowestInRow(array,3), 0.01);
	}
	
	//Test getLowestInRowIndex
	@Test
	void testGetLowestInRowIndex() {
		assertEquals(5, TwoDimRaggedArrayUtility.getLowestInRowIndex(array,0), 0.01);
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(array,1), 0.01);
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(array,2), 0.01);
		assertEquals(3, TwoDimRaggedArrayUtility.getLowestInRowIndex(array,3), 0.01);
	}
	
	//Test getHighestInColumn
	@Test
	void testGetHighestInColumn() {
		assertEquals(1169.72, TwoDimRaggedArrayUtility.getHighestInColumn(array,0), 0.01);
		assertEquals(868.43, TwoDimRaggedArrayUtility.getHighestInColumn(array,1), 0.01);
		assertEquals(1172.46, TwoDimRaggedArrayUtility.getHighestInColumn(array,2), 0.01);
		assertEquals(1070.49, TwoDimRaggedArrayUtility.getHighestInColumn(array,3), 0.01);
		assertEquals(1092.59, TwoDimRaggedArrayUtility.getHighestInColumn(array,4), 0.01);
		assertEquals(821.14, TwoDimRaggedArrayUtility.getHighestInColumn(array,5), 0.01);
	}
	
	//Test getHighestInColumnIndex
	@Test
	void testGetHighestInColumnIndex() {
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInColumnIndex(array,0), 0.01);
		assertEquals(1, TwoDimRaggedArrayUtility.getHighestInColumnIndex(array,1), 0.01);
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(array,2), 0.01);
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(array,3), 0.01);
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(array,4), 0.01);
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(array,5), 0.01);
	}

	//Test getLowestInColumn
	@Test
	void testGetLowestInColumn() {
		assertEquals(-37.37, TwoDimRaggedArrayUtility.getLowestInColumn(array,0), 0.01);
		assertEquals(289.18, TwoDimRaggedArrayUtility.getLowestInColumn(array,1), 0.01);
		assertEquals(186.27, TwoDimRaggedArrayUtility.getLowestInColumn(array,2), 0.01);
		assertEquals(-416.54, TwoDimRaggedArrayUtility.getLowestInColumn(array,3), 0.01);
		assertEquals(725.90, TwoDimRaggedArrayUtility.getLowestInColumn(array,4), 0.01);
		assertEquals(2.77, TwoDimRaggedArrayUtility.getLowestInColumn(array,5), 0.01);
	}
	
	//Test getLowestInColumnIndex
	@Test
	void testGetLowestInColumnIndex() {
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumnIndex(array,0), 0.01);
		assertEquals(3, TwoDimRaggedArrayUtility.getLowestInColumnIndex(array,1), 0.01);
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumnIndex(array,2), 0.01);
		assertEquals(3, TwoDimRaggedArrayUtility.getLowestInColumnIndex(array,3), 0.01);
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(array,4), 0.01);
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(array,5), 0.01);
	}
	
	//Test getHighestInArray
	@Test
	void testGetHighestInArray() {
		assertEquals(1172.46,TwoDimRaggedArrayUtility.getHighestInArray(array), 0.01);
	}
	
	//Test getLowestInArray
	@Test
	void testGetLowestInArray() {
		assertEquals(-416.54,TwoDimRaggedArrayUtility.getLowestInArray(array), 0.01);
	}
}

