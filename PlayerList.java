import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * <h1>W19 - COMP 1502 - Assignment 2 PlayerList Class</h1> Holds a list of
 * Player and allows for Players to be added, found by jersey number, and for
 * shots, goals, pp goals to be recorded. Also available are options to print
 * out a roster table, stats table and load/save a PlayerList from/to a file.
 * Player's are stored in an internal ArrayList of Player.
 * 
 * @author Reatha Johner
 *
 */
public class PlayerList {

	/**
	 * The Players in the list
	 */
	private ArrayList<Player> players;
	/**
	 * The Skaters in the list
	 */
	private ArrayList<Player> skaters;

	/**
	 * The Goalies in the list
	 */
	private ArrayList<Player> goalies;


	/**
	 * Construct a new empty PlayerList
	 */
	public PlayerList() {
		players = new ArrayList<>();
	}

	/**
	 * Construct a PlayerList by loading Player data from the File
	 * 
	 * @param file The File to load player data from
	 * @throws FileNotFoundException If the file is not found
	 */
	public PlayerList(File file) throws FileNotFoundException {
		this();
		TeamReader.loadPlayerList(file);
	}

	/**
	 * The list of player stored
	 * 
	 * @return The ArrayList of Players stored
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * Get a player with a given String jersey number
	 * 
	 * @param number String jersey number to search for
	 * @return The player found with jersey number, if no player found then null
	 */
	public Player getPlayerByNumber(String number) {
		for (Player p : players) {
			if (p.getNumber().equals(number)) {
				return p;
			}
		}
		return null;
	}
	
	/**
	 * Get a skater with a given String jersey number
	 * 
	 * @param number String jersey number to search for
	 * @return The skater found with jersey number, if no skater found then null
	 */
	public Player getSkaterByNumber(String number) {
		for (Player p : skaters) {
			if (p.getNumber().equals(number)) {
				return p;
			}
		}
		return null;
	}
	
	/**
	 * Get a goalie with a given String jersey number
	 * 
	 * @param number String jersey number to search for
	 * @return The goalie found with jersey number, if no goalie found then null
	 */
	public Player getGoalieByNumber(String number) {
		for (Player p : goalies) {
			if (p.getNumber().equals(number)) {
				return p;
			}
		}
		return null;
	}

	/**
	 * Add a player to the PlayerList
	 * 
	 * @param p The Player to add
	 */
	public void addPlayer(Player p) {
		players.add(p);
	}
	/**
	 * Add a Goalie to the GoalieList
	 * 
	 * @param p The Player to add
	 */
	public void addGoalie(Player p) {
		goalies.add(p);
	}
	/**
	 * Add a Skater to the SkaterList
	 * 
	 * @param p The Player to add
	 */
	public void addSkater(Player p) {
		skaters.add(p);
	}

	/**
	 * Record a shot for a player
	 * 
	 * @param number String jersey number of player who had the shot
	 */
	public void recordShot(String number, String gNumber) {
		getSkaterByNumber(number).recordShot();
		getGoalieByNumber(gNumber).recordShotsAgainst();

	}

	/**
	 * Record a goal for a given scorer
	 * 
	 * @param scorer String jersey number of player who scored (should not be null)
	 */
	public void recordGoal(String scorer, String gNumber) {
		getSkaterByNumber(scorer).recordGoal();
		getGoalieByNumber(gNumber).recordGoalAgainst();
	}

	/**
	 * Record a goal for a given scorer and optional player a1 assisting the goal
	 * 
	 * @param scorer String jersey number of player who scored (should not be null)
	 * @param a1     String jersey number of player who assisted the goal (null if
	 *               no player)
	 */
	public void recordGoal(String scorer, String a1, String gNumber) {
		getSkaterByNumber(scorer).recordGoal();
		getSkaterByNumber(a1).recordAssist();
		getGoalieByNumber(gNumber).recordGoalAgainst();
	}

	/**
	 * Record a goal for a given scorer and optional players a1/a2 assisting the
	 * goal
	 * 
	 * @param scorer String jersey number of player who scored (should not be null)
	 * @param a1     String jersey number of player who assisted the goal (null if
	 *               no player)
	 * @param a2     String jersey number of player who assisted the goal (null if
	 *               no player)
	 */
	public void recordGoal(String scorer, String a1, String a2, String gNumber) {
		getSkaterByNumber(scorer).recordGoal();
		getSkaterByNumber(a1).recordAssist();
		getSkaterByNumber(a2).recordAssist();
		getGoalieByNumber(gNumber).recordGoalAgainst();

	}

	/**
	 * Record a PP goal for a given scorer
	 * 
	 * @param scorer String jersey number of player who scored (should not be null)
	 */
	public void recordPowerPlayGoal(String scorer, String gNumber) {
		getSkaterByNumber(scorer).recordPowerPlayGoal();
		getGoalieByNumber(gNumber).recordGoalAgainst();

	}

	/**
	 * Record a PP goal for a given scorer and optional player a1 assisting the PP
	 * goal
	 * 
	 * @param scorer String jersey number of player who scored (should not be null)
	 * @param a1     String jersey number of player who assisted the goal (null if
	 *               no player)
	 */
	public void recordPowerPlayGoal(String scorer, String a1, String gNumber) {
		getSkaterByNumber(scorer).recordPowerPlayGoal();
		getSkaterByNumber(a1).recordPowerPlayAssist();
		getGoalieByNumber(gNumber).recordGoalAgainst();

	}

	/**
	 * Record a PP goal for a given scorer and optional players a1/a2 assisting the
	 * PP goal
	 * 
	 * @param scorer String jersey number of player who scored (should not be null)
	 * @param a1     String jersey number of player who assisted the goal (null if
	 *               no player)
	 * @param a2     String jersey number of player who assisted the goal (null if
	 *               no player)
	 */
	public void recordPowerPlayGoal(String scorer, String a1, String a2, String gNumber) {
		getSkaterByNumber(scorer).recordPowerPlayGoal();
		getSkaterByNumber(a1).recordPowerPlayAssist();
		getSkaterByNumber(a2).recordPowerPlayAssist();
		getGoalieByNumber(gNumber).recordGoalAgainst();

	}
	
	public void recordGoalieMinute(int min, String gNumber) {
		getGoalieByNumber(gNumber).recordMinutes(min);
	}
	
	public void recordShutout(String gNumber) {
		getGoalieByNumber(gNumber).recordShutout();
	}

}
