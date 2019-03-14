import static org.junit.Assert.*;

import org.junit.Test;

public class GoalieTest {

	@Test
	public void testConstructor() {
		Goalie g = new Goalie ("Name", Position.G, "num", "dob", "home", "lbs", "ft", 1, 2, 3, 4);
		assertEquals("Name", g.getName());
		assertEquals(Position.G, g.getPosition());
		assertEquals("num", g.getNumber());
		assertEquals("dob", g.getDateOfBirth());
		assertEquals("home", g.getHomeTown());
		assertEquals("lbs", g.getWeight());
		assertEquals("ft", g.getHeight());
		assertEquals(0, g.getShotsAgainst());
		assertEquals(0, g.getGoalsAgainst());
		assertEquals(0, g.getShutouts());
	}
	
	@Test
	public void testSavePer() {
		Goalie g = new Goalie ("Name", Position.G, "num", "dob", "home", "lbs", "ft", 1, 2, 3, 4);
		g.recordGoalAgainst();
		g.recordGoalAgainst();
		g.recordGoalAgainst();
		g.recordMinutes(60);
		assertEquals(3.00, g.getSavePer(), 0.1);
	}
	@Test
	public void testGAA() {
		Goalie g = new Goalie ("Name", Position.G, "num", "dob", "home", "lbs", "ft", 1, 2, 3, 4);
		g.recordGoalAgainst();
		g.recordGoalAgainst();
		g.recordGoalAgainst();
		g.recordShotAgainst();
		assertEquals(3.00, g.getSavePer(), 0.1);
	}

}
