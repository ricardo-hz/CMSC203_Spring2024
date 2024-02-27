/*
 * Class: CMSC203 CRN 30339
 * Instructor: Grigoriy Grinberg
 * Assignment 2
 * Description: This class uses the patient and procedure classes to create objects of each type
 * and display information about the objects created
 * Due: 02/26/2026
 * Platform/compiler: Windows 10/Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ricardo Hernandez
*/
public class PatientDriverApp {

	public static void main(String[] args) {
		//Create patient object using constructor that initializes all fields
		Patient johnDoe = new Patient("John", "Mid", "Doe", "301-123-4567", "444 Address Ln", "Silver Spring", "MD", 20904, "Margaret Erickson", "301-000-0000");
		//Display patient information
		System.out.println("Patient info: ");
		displayPatient(johnDoe);
		//Create first procedure object using noarg constructor
		Procedure johnDoePhysicalExam = new Procedure();
		johnDoePhysicalExam.setProcedureName("Physical Exam");
		johnDoePhysicalExam.setProcedureDate("9/12/2015");
		johnDoePhysicalExam.setProcedurePractitioner("Dr. Gupta");
		johnDoePhysicalExam.setProcedureCharges(1200.73);
		//Create second procedure object using name/date constructor
		Procedure johnDoeXray = new Procedure("X-Ray", "9/12/2015");
		johnDoeXray.setProcedurePractitioner("Dr. Truong");
		johnDoeXray.setProcedureCharges(4084.99);
		//Create third procedure object using constructor that initializes all fields
		Procedure johnDoeBloodTest = new Procedure("Blood Test", "9/12/2015", "Dr. Hernandez", 2006.18);
		
		//Display first procedure information
		System.out.println();
		displayProcedure(johnDoePhysicalExam);
		System.out.println();
		//Display second procedure information
		displayProcedure(johnDoeXray);
		System.out.println();
		//Display third procedure information
		displayProcedure(johnDoeBloodTest);
		System.out.println();
		//Display total cost for all the procedures
		System.out.printf("Total charges: $%,.2f\n\n", calculateTotalCharges(johnDoePhysicalExam, johnDoeXray, johnDoeBloodTest));
		
		
		//Create patient object using constructor that initializes name
		Patient taraRhodes = new Patient("Tara", "J", "Rhodes");
		taraRhodes.setPhoneNumber("703-123-4567");
		taraRhodes.setStreetAddress("123 Main St");
		taraRhodes.setCity("Arlington");
		taraRhodes.setState("VA");
		taraRhodes.setZipCode(20301);
		taraRhodes.setEmergencyContactName("Christine Hurst");
		taraRhodes.setEmergencyContactPhoneNumber("703-000-0000");
		//Display patient information
		System.out.println("Patient info: ");
		displayPatient(taraRhodes);
		/*System.out.println("Patient info: ");
		System.out.println("  Name: " + taraRhodes.buildFullName());
		System.out.println("  Phone number: " + taraRhodes.getPhoneNumber());
		System.out.println("  Address: " + taraRhodes.buildAddress());
		System.out.println("  Emergency Contact: " + taraRhodes.buildEmergencyContact());*/
		//Create first procedure object using noarg constructor
		Procedure taraRhodesPhysicalExam = new Procedure();
		taraRhodesPhysicalExam.setProcedureName("Physical Exam");
		taraRhodesPhysicalExam.setProcedureDate("2/18/2017");
		taraRhodesPhysicalExam.setProcedurePractitioner("Dr. Smith");
		taraRhodesPhysicalExam.setProcedureCharges(800.66);
		//Create second procedure object using name/date constructor
		Procedure taraRhodesCancerScreening = new Procedure("Cancer Screening", "2/28/2017");
		taraRhodesCancerScreening.setProcedurePractitioner("Dr. Harry");
		taraRhodesCancerScreening.setProcedureCharges(650.99);
		//Create third procedure object using constructor that initializes all fields
		Procedure taraRhodesVaccine = new Procedure("Vaccine", "2/18/2017", "Dr. Rigolio", 169.83);
		
		//Display first procedure information
		System.out.println();
		displayProcedure(taraRhodesPhysicalExam);
		System.out.println();
		//Display second procedure information
		displayProcedure(taraRhodesCancerScreening);
		System.out.println();
		//Display third procedure information
		displayProcedure(taraRhodesVaccine);
		System.out.println();
		//Display total cost for all the procedures
		System.out.printf("Total charges: $%,.2f\n\n", calculateTotalCharges(taraRhodesPhysicalExam, taraRhodesCancerScreening, taraRhodesVaccine));
		
		
		//Create patient object using noarg constructor
		Patient iwanHeath = new Patient();
		iwanHeath.setFirstName("Iwan");
		iwanHeath.setMiddleName("Montoya");
		iwanHeath.setLastName("Heath");
		iwanHeath.setPhoneNumber("202-123-4567");
		iwanHeath.setStreetAddress("987 Fake Blvd");
		iwanHeath.setCity("Washington");
		iwanHeath.setState("DC");
		iwanHeath.setZipCode(20001);
		iwanHeath.setEmergencyContactName("Miranda Lang");
		iwanHeath.setEmergencyContactPhoneNumber("202-000-0000");
		//Display patient information
		System.out.println("Patient info: ");
		displayPatient(iwanHeath);
		//Create first procedure object using noarg constructor
		Procedure iwanHeathPhysicalExam = new Procedure();
		iwanHeathPhysicalExam.setProcedureName("Physical Exam");
		iwanHeathPhysicalExam.setProcedureDate("6/12/2019");
		iwanHeathPhysicalExam.setProcedurePractitioner("Dr. Saratoga");
		iwanHeathPhysicalExam.setProcedureCharges(980.72);
		//Create second procedure object using name/date constructor
		Procedure iwanHeathSurgery= new Procedure("Surgery", "8/10/2020");
		iwanHeathSurgery.setProcedurePractitioner("Dr. Massi");
		iwanHeathSurgery.setProcedureCharges(4003.99);
		//Create third procedure object using constructor that initializes all fields
		Procedure iwanHeathAmputation = new Procedure("Amputation", "7/10/2020", "Dr. Amphen", 6012.64);
		
		//Display first procedure information
		System.out.println();
		displayProcedure(iwanHeathPhysicalExam);
		System.out.println();
		//Display second procedure information
		displayProcedure(iwanHeathSurgery);
		System.out.println();
		//Display third procedure information
		displayProcedure(iwanHeathAmputation);
		System.out.println();
		//Display total cost for all procedures
		System.out.printf("Total charges: $%,.2f\n\n", calculateTotalCharges(iwanHeathPhysicalExam, iwanHeathSurgery, iwanHeathAmputation));
		//Closing
		System.out.print("Programmer: Ricardo Hernandez\n"
				+		 "MC#: M21131765\n"
				+		"Due Date: 02/26/2024\n");
	}
	
	/**This method given a patient object will display patient’s information.
	 * @param patient The patient whose information should be displayed
	 */
	public static void displayPatient(Patient patient) {
		System.out.print(patient.toString());
	}
	/**
	 * This method given a procedure object will display procedure’s information.
	 * @param procedure The procedure of which information should be displayed
	 */
	public static void displayProcedure(Procedure procedure) {
		System.out.print(procedure.toString());
	}
	/**
	 * This method given three procedures will calculate the total cost for all procedures
	 * @param procedure1 The first procedure from which the cost will be added to the total
	 * @param procedure2 The second procedure from which the cost will be added to the total
	 * @param procedure3 The third procedure from which the cost will be added to the total
	 * @return The total cost for all three procedures
	 */
	public static double calculateTotalCharges(Procedure procedure1, Procedure procedure2, Procedure procedure3) {
		return (procedure1.getProcedureCharges() + procedure2.getProcedureCharges() + procedure3.getProcedureCharges());
	}

}
