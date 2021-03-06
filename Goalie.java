public class Goalie extends Player {
	
	/**
	 * Integer shots against of player (shots against >= 0)
	 */
	private int shotsAgainst = 0;
	/**
	 * Integer goals against of player (goals against >= 0)
	 */
	private int goalsAgainst = 0;
	/**
	 * Integer shutouts of player (shutouts >= 0)
	 */
	private int shutouts = 0;
	/**
	 * Integer minutes of player (minutes >= 0)
	 */
	private int minutes;

	/**
	 * Create Roster parts of a Goalie
	 * 
	 * @param name        String name of Goalie
	 * @param position    Enum Position of Goalie
	 * @param number      String number of Goalie
	 * @param dateOfBirth String date of birth of Goalie
	 * @param homeTown    String hometown of Goalie
	 * @param weight      String weight of Goalie
	 * @param height      String height of Goalie
	 */
	public Goalie(String name, Position position, String number, String dateOfBirth, String homeTown, String weight, String height) {
		super(name, position, number, dateOfBirth, homeTown, weight, height);
	}
	/**
	 * Create all parts of a Goalie
	 * 
	 * @param name             String name of goalie
	 * @param position         Enum Position of goalie
	 * @param number           String number of goalie
	 * @param dateOfBirth      String date of birth of goalie
	 * @param homeTown         String hometown of goalie
	 * @param weight           String Weight of goalie
	 * @param height           String height of goalie
	 * @param shotsAgainst	   Integer shotsAgainst of goalie (goalsAgainst >= 0)
	 * @param goalsAgainst	   Integer goalsAgainst of goalie (shotsAgainst >= 0)
	 * @param shutouts		   Integer shutouts of goalie (shutouts >= 0)
	 * @param minutes		   Integer minutes played by goalie (minutes >= 0)
	 * 
	 */
	public Goalie(String name, 
			Position position, 
			String number, 
			String dateOfBirth, 
			String homeTown, 
			String weight, 
			String height, 
			int shotsAgainst, 
			int goalsAgainst, 
			int shutouts, 
			int minutes) {
		super(name, position, number, dateOfBirth, homeTown, weight, height);
		this.shotsAgainst = shotsAgainst;
		this.goalsAgainst = goalsAgainst;
		this.shutouts = shutouts;
		this.minutes = minutes;
	}
	
	/**
	 * Copy the goalie entered
	 * 
	 * @param p Goalie to be copied
	 */
	public Goalie(Goalie p) {
		super(p.name, p.position, p.number, p.dateOfBirth, p.homeTown, p.weight, p.height);
		this.shotsAgainst = p.shotsAgainst;
		this.goalsAgainst = p.goalsAgainst;
		this.shutouts = p.shutouts;
		this.minutes = p.minutes;
	}
	
	/**
	 * Player's shots against
	 * 
	 * @return shots against
	 */
	public int getShotsAgainst() {
		return shotsAgainst;
	}
	
	/**
	 * Player's goals against
	 * 
	 * @return goals against
	 */
	public int getGoalsAgainst() {
		return goalsAgainst;
	}
	
	/**
	 * Player's shutouts
	 * 
	 * @return shutouts
	 */
	public int getShutouts() {
		return shutouts;
	}
	
	/**
	 * Player's minutes
	 * 
	 * @return minutes
	 */
	public int getMinutes() {
		return minutes;
	}
	
	/**
	 * Player's save percentage
	 * 
	 * @return save percentage (goals against * 60 minutes / minutes played)
	 */
	public double getSavePer() {
		return goalsAgainst * 60 / minutes;
	}
	
	/**
	 * Player's goals against average
	 * 
	 * @return goals against average (goals against * 60 minutes / minutes played)
	 */
	public double getGAA() {
		return 1 - (goalsAgainst / shotsAgainst);
	}
	
	/**
	 * Record a shot against
	 */
	public void recordShotAgainst() {
		this.shotsAgainst += 1;
	}
	
	/**
	 * Record a goal against
	 */
	public void recordGoalAgainst() {
		this.goalsAgainst += 1;
	}
	/**
	 * Record a goal against
	 */
	public void recordShutouts() {
		this.shutouts += 1;
	}
	
	/**
	 * Record a minutes played
	 */
	public void recordMinutes(int add) {
		this.minutes += add;
	}
	
	private static final String STATS_FORMAT = "%-20s %2s %3s, %3s, %3s, %3s ";

	/**
	 * A stats table header for all Goalie's
	 * 
	 * @return String containing headers for goalie stats table
	 */
	public static String getFormattedStatsHeader() {
		return String.format(STATS_FORMAT, "Name", "#", "SA", "GA", "SO", "MIN", "GAA", "SVP" );
	}

	/**
	 * A stats table entry for a goalie
	 * 
	 * @return String containing entries of goalie's stats formatted for table type
	 *         spacing
	 */
	public String getFormattedStats() {
		return String.format(STATS_FORMAT, name, number, shotsAgainst, goalsAgainst, shutouts, minutes, String.format("%3.2f", getGAA()), String.format("%3.2f", getSavePer()));
	}
}
