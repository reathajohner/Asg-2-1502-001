import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GoalieTest {

	@Test
	public void testConstructor() {
		Goalie g = new Goalie ("Name", Position.G, "num", "dob", "home", "lbs", "ft", 1, 2, 3, 4);
		AssertEquals ("Name", g.getName());
	}

}
