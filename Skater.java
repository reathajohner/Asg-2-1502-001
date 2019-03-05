public class Skater extends Player {
	
	private int goals = 0;
	/**
	 * Integer assists of player (assists >= 0)
	 */
	private int assists = 0;
	/**
	 * Integer Power play goals of player (should be subset of goals)
	 * (powerPlayGoals >= 0)
	 */
	private int powerPlayGoals = 0;
	/**
	 * Integer power play assists of player (should be subset of assists)
	 * (powerPlayAssists >= 0)
	 */
	private int powerPlayAssists = 0;
	/**
	 * Integer shots on goal of player (should be at least as large as goals) (shots
	 * >= 0)
	 */
	private int shots = 0;
	
	/**
	 * Create all parts of a Skater
	 * 
	 * @param name             String name of player
	 * @param position         Enum Position of player
	 * @param number           String number of player
	 * @param dateOfBirth      String date of birth of player
	 * @param homeTown         String hometown of player
	 * @param weight           String Weight of player
	 * @param height           String height of player
	 * @param goals            Integer goals of player (goals >= 0)
	 * @param assists          Integer assists of player (assists >= 0)
	 * @param powerPlayGoals   Integer Power play goals of player (should be subset
	 *                         of goals) (powerPlayGoals >= 0)
	 * @param powerPlayAssists Integer power play assists of player (should be
	 *                         subset of assists) (powerPlayAssists >= 0)
	 * @param shots            Integer shots on goal of player (should be at least
	 *                         as large as goals) (shots >= 0)
	 */
	public Skater(String name, 
			Position position, 
			String number, 
			String dateOfBirth, 
			String homeTown, 
			String weight, 
			String height, 
			int goals, 
			int assists, 
			int powerPlayGoals, 
			int powerPlayAssists, 
			int shots) {
		this(name, position, number, dateOfBirth, homeTown, weight, height);
		this.goals = goals;
		this.assists = assists;
		this.powerPlayGoals = powerPlayGoals;
		this.powerPlayAssists = powerPlayAssists;
		this.shots = shots;
	}
	
	/**
	 * Copy the player entered
	 * 
	 * @param p Player to be copied
	 */
	public Skater(Player p) {
		this(p.name, p.position, p.number, p.dateOfBirth, p.homeTown, p.weight, p.height, p.goals, p.assists, p.powerPlayGoals, p.powerPlayAssists, p.shots);
	}
	
	public int getGoals() {
		return goals;
	}

	/**
	 * Player's assists
	 * 
	 * @return Integer of player assists
	 */
	public int getAssists() {
		return assists;
	}

	/**
	 * Player's power play goals
	 * 
	 * @return Integer of poewr play goals
	 */
	public int getPowerPlayGoals() {
		return powerPlayGoals;
	}

	/**
	 * Player's power play assists
	 * 
	 * @return Integer of power play assists
	 */
	public int getPowerPlayAssists() {
		return powerPlayAssists;
	}

	/**
	 * Player's shots on goal
	 * 
	 * @return Integer of player shots on goal
	 */
	public int getShots() {
		return shots;
	}

	/**
	 * Return points (note this is sum of power play goals and power play assists)
	 * 
	 * @return Integer points of the player
	 */
	public int getPoints() {
		return goals + assists;
	}

	/**
	 * Return power play points (note this is sum of power play goals and power play
	 * assists)
	 * 
	 * @return Integer power play points of the player
	 */
	public int getPowerPlayPoints() {
		return powerPlayGoals + powerPlayAssists;
	}

	/**
	 * Calculate and return a shooting percentage (0-100)
	 * 
	 * @return Double of shooting percentage (0.0-100.0), 0 is returned if player
	 *         has no shots
	 */
	public double getShootingPercentage() {
		if (shots == 0) {
			return 0;
		}
		return ((double) goals) / ((double) shots) * 100;
	}
	public void recordShot() {
		this.shots += 1;
	}

	/**
	 * Record a goal (note this adds both a goal and a shot on goal)
	 */
	public void recordGoal() {
		this.goals += 1;
		this.shots += 1;
	}

	/**
	 * Record an assist
	 */
	public void recordAssist() {
		assists += 1;
	}

	/**
	 * Add a power play goal (note this adds both regular goal, power play goal, and
	 * shot on goal)
	 */
	public void recordPowerPlayGoal() {
		this.goals += 1;
		this.powerPlayGoals += 1;
		this.shots += 1;
	}

	/**
	 * Add a power play assist (note this adds both a regular assist and power play
	 * assist
	 */
	public void recordPowerPlayAssist() {
		this.assists += 1;
		this.powerPlayAssists += 1;
	}

}
