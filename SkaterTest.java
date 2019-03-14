import static org.junit.Assert.*;

import org.junit.Test;

public class SkaterTest {

	@Test
	public void testConstructor() {
		Skater s = new Skater ("Name", Position.G, "num", "dob", "home", "lbs", "ft", 1, 2, 3, 4, 5);
		assertEquals("Name", s.getName());
		assertEquals(Position.G, s.getPosition());
		assertEquals("num", s.getNumber());
		assertEquals("dob", s.getDateOfBirth());
		assertEquals("home", s.getHomeTown());
		assertEquals("lbs", s.getWeight());
		assertEquals(1, s.getGoals());
		assertEquals(2, s.getAssists());
		assertEquals(3, s.getPowerPlayGoals());
		assertEquals(4, s.getPowerPlayAssists());
		assertEquals(5, s.getShots());
	}
	
}
