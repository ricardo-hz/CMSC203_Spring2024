/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Tests methods found in Type.java
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

class TypeTestStudent {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

    @Test
    public void testTypeEnum() {
        assertNotNull(Type.COFFEE);
        assertNotNull(Type.ALCOHOL);
        assertNotNull(Type.SMOOTHIE);
    }

}
