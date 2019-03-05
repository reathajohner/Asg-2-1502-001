public class Skater extends Player {
	
	/**
	 * Create all parts of a player
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
}
