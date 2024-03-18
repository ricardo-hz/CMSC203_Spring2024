/*
 * Class: CMSC203 CRN 30339
 * Instructor: Grigoriy Grinberg
 * Description: This class encrypts and decrypts text using a caesar or
 * bellaso cypher
 * Due: 03/18/2024
 * Platform/compiler: Windows 10/Eclipse IDE
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Ricardo Hernandez
*/

/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */

public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';//ASCII 32
	private static final char UPPER_RANGE = '_';//ASCII 95
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1; //64
	private static final String ERROR_MESSAGE = "The selected string is not in bounds, Try again.";
	
	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		//Return value
		boolean stringInBounds = true;
			for(int i = 0; i < plainText.length(); i++) {
				if(plainText.charAt(i) > UPPER_RANGE || plainText.charAt(i) < LOWER_RANGE) {
					stringInBounds = false;
					break;
				}
			}
			return stringInBounds;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		/*
		 * This method is called to adjust the key to be between the range of chars we want to consider
		 * If the key is already within range, it does nothing and key remains the same
		 */
		key = adjustKey(key);
		//Used to assemble final encrypted string
		StringBuilder ceaserEncrypted = new StringBuilder();
		//Used to handle wrapping of chars
		int newKey;
		//Only proceed if string is in bounds
		if(isStringInBounds(plainText) == true) {
			for (int i = 0; i < plainText.length(); i++) {
					/*
					 * If the character of plainText + key is higher than acceptable upper range,
					 * wrap to lower range and add remainder of key from there
					 */
					if(plainText.charAt(i) + key > UPPER_RANGE) {
						newKey = plainText.charAt(i) + key - UPPER_RANGE - 1;
						ceaserEncrypted.append((char)(LOWER_RANGE + newKey));
					}
					//Otherwise, just add the char at plainText + key to the encrypted string
					else {
						ceaserEncrypted.append((char)(plainText.charAt(i) + key));
					}
				}
			return (ceaserEncrypted.toString());
		//If string is out of bounds, reject
		}
		else {
			return(ERROR_MESSAGE);
		}

	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		/*
		 * This method is called to adjust the length of bellasoStr to be equivalent to the length of
		 * plainText. If bellasoStr is shorter than plainText, bellasoStr is duplicated onto itself until
		 * bellasoStr and plainText reach the same length. If bellaosStr is longer than plainText, characters
		 * are removed from bellasoStr until it reaches the same length as plainText. If bellasoStr and plainText
		 * are already equivalent in length, nothing happens and bellasoStr remains the same.
		 */
		bellasoStr = adjustKey(plainText, bellasoStr);
		StringBuilder bellasoEncrypted = new StringBuilder();
		//Add chars to stringbuilder
		int modifiedASCII;
		//Only encrypt if string is in bounds
		if(isStringInBounds(plainText)) {
			for(int i = 0; i < plainText.length(); i++) {
				//If plainText + bellasoStr is higher than upper range, subtract range
				if(plainText.charAt(i) + bellasoStr.charAt(i) > UPPER_RANGE) {
					modifiedASCII = (plainText.charAt(i) + bellasoStr.charAt(i));
					while(modifiedASCII > UPPER_RANGE) {
						modifiedASCII -= RANGE;
					}
					bellasoEncrypted.append((char)modifiedASCII);
				}
				//Otherwise, just add chars
				else {
					bellasoEncrypted.append((char)(plainText.charAt(i) + bellasoStr.charAt(i)));
				}
			}
			return (bellasoEncrypted.toString());
		}
		//If string not in bounds, reject
		else {
			return(ERROR_MESSAGE);
		}
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		/*
		 * This method is called to adjust the key to be between the range of chars we want to consider
		 * If the key is already within range, it does nothing and key remains the same
		 */
		key = adjustKey(key);
		//Used to assemble final decrypted string
		StringBuilder ceaserDecrypted = new StringBuilder();
		//Used to handle wrapping of chars
		int newKey;
		//Only decrypt if the original string was in bounds
		if(!(encryptedText.equalsIgnoreCase(ERROR_MESSAGE))) {
			for (int i = 0; i < encryptedText.length(); i++) {
				/*
				 * If the character of encrypted text - key is lower than the lower acceptable range,
				 * wrap around and subtract the remainder of key from the upper acceptable range
				 */
				if(encryptedText.charAt(i) - key < LOWER_RANGE) {
					newKey = key - (encryptedText.charAt(i) - LOWER_RANGE + 1);
					ceaserDecrypted.append((char)(UPPER_RANGE - newKey));
				}
				//Otherwise just add the character - the key to the decrypted text
				else {
					ceaserDecrypted.append((char)(encryptedText.charAt(i) - key));
				}
			}
			return (ceaserDecrypted.toString());
		}
		//If the original string was not in bounds, give an error message
		else {
			return (ERROR_MESSAGE);
		}
	}
	//}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		/*
		 * This method is called to adjust the length of bellasoStr to be equivalent to the length of
		 * encryptedText. If bellasoStr is shorter than encryptedText, bellasoStr is duplicated onto itself 
		 * until bellasoStr and encryptedText reach the same length. If bellaosStr is longer than 
		 * encryptedText, characters are removed from bellasoStr until it reaches the same length 
		 * as encryptedText. If bellasoStr and encryptedText are already equivalent in length, 
		 * nothing happens and bellasoStr remains the same.
		 */
		bellasoStr = adjustKey(encryptedText, bellasoStr);
		//Used to assemble final decrypted string
		StringBuilder bellasoDecrypted = new StringBuilder();
		//LESSON LEARNED: Java doesn't respond well to negative ascii char values, so this was changed to int
		int modifiedASCII;
		if(!(encryptedText.equalsIgnoreCase(ERROR_MESSAGE))) {
			for(int i = 0; i < encryptedText.length(); i++) {
				//If encryptedText - bellasoStr is less than lower range, wrap around
				if(encryptedText.charAt(i) - bellasoStr.charAt(i) < LOWER_RANGE) {
					modifiedASCII = (encryptedText.charAt(i) - bellasoStr.charAt(i));
					while (modifiedASCII < LOWER_RANGE) {
						modifiedASCII += RANGE;
					}
					bellasoDecrypted.append((char)modifiedASCII);
				}
				//Otherwise, just append encryptedText - bellasoStr
				else {
					bellasoDecrypted.append((char)(encryptedText.charAt(i) - bellasoStr.charAt(i)));
				}
			}
			return(bellasoDecrypted.toString());
		}
		else {
			return ERROR_MESSAGE;
		}
	}
	
	/**
	 * Adjusts a key to be within the acceptable range of characters. If a key is too high, the range (64) is
	 * subtracted from the key until it is within range (32-95). If a key is too low, the range (64) is added
	 * to the key until it is within range (32 - 95).
	 * @param key The key to be adjusted
	 * @return A key that is between 32 and 95 (inclusive)
	 */
	private static int adjustKey(int key) {
		//If key is lower than acceptable range, add to key until it reaches range
		while (key < RANGE) {
			key += RANGE;
		}
		//If key is higher than acceptable range, subtract from key until it reaches range
		while(key > RANGE) {
			key -= RANGE;
		}
		return key;
	}
	
	/**
	 * Adjusts a key to have the same amount of characters as the text that has been passed. If the key is
	 * shorter than the provided string, the key is duplicated until it reaches the same length. If the key
	 * is longer than the provided string, characters are removed from the end of the key until it reaches
	 * the same length as the string.
	 * @param str The encrypted or decrypted text of which the length of key will need to match
	 * @param key The key for encryption or decryption
	 * @return A key that is the same length as the encrypted or decrypted text passed
	 */
	private static String adjustKey(String str, String key) {
		//Used to build final key to be returned
		StringBuilder keyAdjuster = new StringBuilder();
		
		//Handle keys that are shorter than passed string
		for(int i = 0; str.length() > keyAdjuster.length(); i++) {
			if(i >= key.length()) {
				i = 0;
			}
			keyAdjuster.append(key.charAt(i));
		}
		
		//Handle keys that are longer than passed string
		for(int i = 0; str.length() < keyAdjuster.length(); i++) {
			if(i >= key.length()) {
				i = 0;
			}
			keyAdjuster.append(key.charAt(i));
		}
		
		//Return adjusted key
		return (keyAdjuster.toString());
	}
}