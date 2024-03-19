/*
 * Class: CMSC203 CRN 30339
 * Instructor: Grigoriy Grinberg
 * Description: This class tests the encryption and decryption
 * of the CryptoManager class
 * Due: 03/18/2024
 * Platform/compiler: Windows 10/Eclipse IDE
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Ricardo Hernandez
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {
	CryptoManager cryptoManager;
	
	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("YELLOW BRICK ROAD"));
		assertTrue(CryptoManager.isStringInBounds("A BUNCH OF WEIRD CHARACTERS \\/()'@#"));
		assertFalse(CryptoManager.isStringInBounds("A BACKTICK WILL CAUSE THE STRING TO BE INVALID `"));
		assertFalse(CryptoManager.isStringInBounds("AND SO WILL A TILDE ~"));
	}
	
	@Test
	public void testCaesarEncryption() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("I LIKE TILDES~~~", 3));
		assertEquals("+_ *7 *7.)X''\\[", CryptoManager.caesarEncryption("THIS IS WRAPPED", 23));
		assertEquals("VJKU\"KU\"PQV", CryptoManager.caesarEncryption("THIS IS NOT", 2));
	}
	
	@Test
	public void testCaesarDecryption() {
		assertEquals("UNWRAP ME", CryptoManager.caesarDecryption("TMVQ@O_LD", 127));
		assertEquals("LEAVE ME BE", CryptoManager.caesarDecryption("MFBWF!NF!CF", 1));
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarDecryption("The selected string is not in bounds, Try again.", 999));
	}
	@Test
	public void testBellasoEncryption() {
		assertEquals("The selected string is not in bounds, Try again.",CryptoManager.bellasoEncryption("INVALID|STRING", "BUT VALID KEY"));
		assertEquals("%MP^ 9+Q(!O/%(2TS ",CryptoManager.bellasoEncryption("REALLY LONG STRING", "SHORT KEY"));
		assertEquals("^M(2!5^Y9UM/W,4PS]XL",CryptoManager.bellasoEncryption("KEY MUST BE EXTENDED", "SHORT KEY"));
		assertEquals("U]#2+N&(3U2U]U",CryptoManager.bellasoEncryption("SHORTER STRING", "BUT WITH A LONGER KEY"));
	}
	
	@Test
	public void testBellasoDecryption() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.bellasoDecryption("The selected string is not in bounds, Try again.", "RANDOM KEY"));
		assertEquals("WRAPPED", CryptoManager.bellasoDecryption(".$B  JH", "WRAPPED"));
		assertEquals("EXTENDED KEY", CryptoManager.bellasoDecryption("P]-PS]PI9VJ2","KEY"));
		
	}

}
