/*
 * Class: CMSC203 CRN 30339
 * Instructor: Grigoriy Grinberg
 * Assignment 2
 * Description: This class allows for the creation of procedire objects, which are responsible for
 * holding information about a procedure such as the procedure name and date. It is also responsible for
 * formatting the given information into a readable format.
 * Due: 02/26/2026
 * Platform/compiler: Windows 10/Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ricardo Hernandez
*/
public class Procedure {
	//Fields related to the procedure
	private String procedureName;
	private String procedureDate;
	private String procedurePractitioner;
	private double procedureCharges;
	
	/**
	 * Gets the name of the procedure
	 * @return A string containing the name of the procedure
	 */
	public String getProcedureName() {
		return procedureName;
	}
	/**
	 * Gets the date of the procedure
	 * @return A string containing the date of the procedure
	 */
	public String getProcedureDate() {
		return procedureDate;
	}
	/**
	 * Gets the name of the practitioner who performed the procedure
	 * @return A string containing the name of the practitioner who performed the procedure
	 */
	public String getProcedurePractitioner() {
		return procedurePractitioner;
	}
	/**
	 * Gets the cost/charges of the procedure
	 * @return A double containing the cost/charges of the procedure
	 */
	public double getProcedureCharges() {
		return procedureCharges;
	}
	/**
	 * Changes the name of a procedure
	 * @param name A string which should be the name of the procedure
	 */
	public void setProcedureName(String name) {
		procedureName = name;
	}
	/**
	 * Changes the date of a procedure
	 * @param name A string which should be the date of the procedure
	 */
	public void setProcedureDate(String date) {
		procedureDate = date;
	}
	/**
	 * Changes the name of the practitioner who performed the procedure
	 * @param name A string which should be the name of the practitioner who performed the procedure
	 */
	public void setProcedurePractitioner(String practitioner) {
		procedurePractitioner = practitioner;
	}
	/**
	 * Changes the charges for a procedure
	 * @param charges A double which should be the cost/charges for the procedure
	 */
	public void setProcedureCharges(double charges) {
		procedureCharges = charges;
	}
	/**
	 * Formats the information of a procedure in a readable manner
	 * @return A string containing the procedure name, date, practitioner, and charges all broken by new line characters
	 */
	public String toString() {
		return ("     Procedure: " + procedureName + "\n" +
				"     Procedure Date: " + procedureDate + "\n" + 
				"     Procedure Practitioner: " + procedurePractitioner + "\n" +
				"     Procedure Charges: $" + procedureCharges + "\n");
	}
	/**
	 * Allows for the creation of a procedure object with no initialized fields
	 */
	public Procedure() {
		
	}
	/**
	 * Allows for the creation of a procedure object with initialized name and date fields
	 * @param name A string that contains the name of the procedure
	 * @param date A string that contains the date of the procedure
	 */
	public Procedure(String name, String date) {
		procedureName = name;
		procedureDate = date;
	}
	/**
	 * Allows for the creation of a procedure object with all fields initialized
	 * @param name A string that contains the name of the procedure
	 * @param date A string that contains the date of the procedure
	 * @param practitioner A string that contains the name of the practitioner who performed the procedure
	 * @param charges A double that contains the cost/charges of the procedure
	 */
	public Procedure(String name, String date, String practitioner, double charges) {
		procedureName = name;
		procedureDate = date;
		procedurePractitioner = practitioner;
		procedureCharges = charges;
	}
}
