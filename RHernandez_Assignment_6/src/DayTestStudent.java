/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Tests methods found in Day.java
 * Due: 04/29/2024
 * Platform/compiler: Windows 10 Eclipse IDE
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ricardo Hernandez
*/
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DayTestStudent {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

    @Test
    public void testDayEnum() {
        assertNotNull(Day.MONDAY);
        assertNotNull(Day.TUESDAY);
        assertNotNull(Day.WEDNESDAY);
        assertNotNull(Day.THURSDAY);
        assertNotNull(Day.FRIDAY);
        assertNotNull(Day.SATURDAY);
        assertNotNull(Day.SUNDAY);
    }


}
