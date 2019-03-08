import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GoalieTest {

	@Test
	public void testConstructor() {
		Player p = new Player ("Name", Position.G);
	}

}
