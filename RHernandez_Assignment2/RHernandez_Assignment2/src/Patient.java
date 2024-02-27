/*
 * Class: CMSC203 CRN 30339
 * Instructor: Grigoriy Grinberg
 * Assignment 2
 * Description: This class allows for the creation of patient objects, which are responsible for
 * holding information about a patient such as their name and address. It is also responsible for
 * formatting the given information into a readable format.
 * Due: 02/26/2026
 * Platform/compiler: Windows 10/Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ricardo Hernandez
*/
public class Patient {
	//Patient name fields
	private String firstName;
	private String middleName;
	private String lastName;
	//Patient address fields
	private String streetAddress;
	private String city;
	private String state;
	private int zipCode;
	//Patient phone number
	private String phoneNumber;
	//Emergency contact fields
	private String emergencyContactName;
	private String emergencyContactPhoneNumber;
	
	/**
	 * Gets the patient's first name
	 * @return A string containing the patient's first name
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Gets the patient's middle name
	 * @return A string containing the patient's middle name
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * Gets the patient's last name
	 * @return A string containing the patient's last name
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * Gets the patient's street address
	 * @return A string containing the patient's street address
	 */
	public String getStreetAddress() {
		return streetAddress;
	}
	/**
	 * Gets the patient's city
	 * @return A string containing the patient's city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * Gets the patient's state
	 * @return A string containing the patient's state
	 */
	public String getState() {
		return state;
	}
	/**
	 * Gets the patient's zip code
	 * @return An integer containing the patient's zip code
	 */
	public int getZipCode() {
		return zipCode;
	}
	/**
	 * Gets the patient's phone number
	 * @return A string containing the patient's phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * Gets the emergency contact's name
	 * @return A string containing the name of the emergency contact
	 */
	public String getEmergencyContactName() {
		return emergencyContactName;
	}
	/**
	 * Gets the emergency contact's phone number
	 * @return A string containing the phone number of the emergency contact
	 */
	public String getEmergencyContactPhoneNumber() {
		return emergencyContactPhoneNumber;
	}
	/**
	 * Changes the patient's first name
	 * @param first A string that should be set as the patient's first name
	 */
	public void setFirstName(String first) {
		firstName = first;
	}
	/**
	 * Changes the patient's middle name
	 * @param middle A string that should be set as the patient's middle name
	 */
	public void setMiddleName(String middle) {
		middleName = middle;
	}
	/**
	 * Changes the patient's last name
	 * @param last A string that should be set as the patient's last name
	 */
	public void setLastName(String last) {
		lastName = last;
	}
	/**
	 * Changes the patient's street address
	 * @param streetAddress A string that should be set as the patient's street address
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	/**
	 * Changes the patient's city
	 * @param city A string that should be set as the patient's city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * Changes the patient's state
	 * @param state A string that should be set as the patient's state
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * Changes the patient's zip code
	 * @param zip An integer that should be set as the patient's zip code
	 */
	public void setZipCode(int zip) {
		zipCode = zip;
	}
	/**
	 * Changes the patient's phone number
	 * @param phone A string that should be set as the patient's phone number
	 */
	public void setPhoneNumber(String phone) {
		phoneNumber = phone;
	}
	/**
	 * Changes the name of the patient's emergency contact
	 * @param ecName A string that should be set as the emergency contact's name
	 */
	public void setEmergencyContactName(String ecName) {
		emergencyContactName = ecName;
	}
	/**
	 * Changes the phone number for a patient's emergency contact
	 * @param ecPhone A string that should be set as the emergency contact's phone number
	 */
	public void setEmergencyContactPhoneNumber(String ecPhone) {
		emergencyContactPhoneNumber = ecPhone;
	}
	/**
	 * Builds a patient's full name
	 * @return The patient's first, middle, and last name broken by spaces
	 */
	public String buildFullName() {
		return (firstName + " " + middleName + " " + lastName);
	}
	/**
	 * Builds a patient's full address
	 * @return String complete with street address, city, state, and zip code all broken by spaces
	 */
	public String buildAddress() {
		return (streetAddress + " " + city + " " + state + " " + zipCode);
	}
	/**
	 * Builds a full emergency contact using the contact's name and phone number
	 * @return String complete with emergency contact name and emergency contact phone number broken by a space
	 */
	public String buildEmergencyContact() {
		return (emergencyContactName + " " + emergencyContactPhoneNumber);
	}
	
	/**
	 * Displays all information of a patient using a toString method
	 * @return A patient's full name, address, and emergency contact broken into separate lines
	 */
	public String toString() {
		String patientName = buildFullName();
		String patientAddress = buildAddress();
		String emergencyContact = buildEmergencyContact();
		return ("  Name: " + patientName + "\n" + 
				"  Phone Number: " + phoneNumber + "\n" + 
				"  Address: " + patientAddress + "\n" + 
				"  Emergency Contact: " + emergencyContact + "\n");
	}
	
	/**
	 * Creates a patient object with no initialized fields
	 */
	public Patient() {
		
	}
	/**
	 * Creates a Patient object, initializing the name fields of the patient
	 * @param first The patient's first name
	 * @param middle The patient's middle name
	 * @param last The patient's last name
	 */
	public Patient(String first, String middle, String last) {
		firstName = first;
		middleName = middle;
		lastName = last;
	}
	/**
	 * Creates a Patient object, initializing all fields of the patient
	 * @param first The patient's first name
	 * @param middle The patient's middle name
	 * @param last The patient's last name
	 * @param phone The patient's phone number
	 * @param address The patient's street address
	 * @param city The patient's city
	 * @param state The patient's state
	 * @param zip The patient's zip code
	 * @param ecName The emergency contact's name
	 * @param ecPhone the Emergency contact's phone number
	 */
	public Patient(String first, String middle, String last, String phone, String address,
			String city, String state, int zip, String ecName, String ecPhone) {
		firstName = first;
		middleName = middle;
		lastName = last;
		phoneNumber = phone;
		streetAddress = address;
		this.city = city;
		this.state = state;
		zipCode = zip;
		emergencyContactName = ecName;
		emergencyContactPhoneNumber = ecPhone;
	}
}
