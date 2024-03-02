import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
		private GradeBook gradebook1;
		private GradeBook gradebook2;
		
	@BeforeEach
	void setUp() throws Exception {
		gradebook1 = new GradeBook(5);
		gradebook2 = new GradeBook(5);
		gradebook1.addScore(50);
		gradebook1.addScore(80);
		gradebook2.addScore(0);
		gradebook2.addScore(100);
		gradebook2.addScore(90);
		gradebook2.addScore(60);
	}

	@AfterEach
	void tearDown() throws Exception {
		gradebook1 = null;
		gradebook2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(gradebook1.toString().equals("50.0 80.0 "));
		assertTrue(gradebook2.toString().equals("0.0 100.0 90.0 60.0 "));
		assertTrue(gradebook1.getScoreSize() == 2);
		assertTrue(gradebook2.getScoreSize() == 4);
	}

	@Test
	void testSum() {
		assertEquals(130, gradebook1.sum());
		assertEquals(250.0 , gradebook2.sum());
	}

	@Test
	void testMinimum() {
		//fail("Not yet implemented");
		assertEquals(50.0, gradebook1.minimum());
		assertEquals(gradebook2.minimum(), 0);
	}

	@Test
	void testFinalScore() {
		assertEquals(130 - 50, gradebook1.finalScore());
		assertEquals(250, gradebook2.finalScore());
	}

	@Test
	void testGetScoreSize() {
		assertEquals(2, gradebook1.getScoreSize());
		assertEquals(gradebook2.getScoreSize(), 4);
	}

	@Test
	void testToString() {
		assertEquals("50.0 80.0 ", gradebook1.toString());
		assertEquals("0.0 100.0 90.0 60.0 ", gradebook2.toString());
		//assertTrue(gradebook1.toString().equals("50.0 80.0 "));
		//assertTrue(gradebook2.toString().equals("0.0 100.0 90.0 60.0 "));
	}

}
