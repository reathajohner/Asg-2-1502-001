import java.util.ArrayList;
import java.util.Arrays;

/**
 * <h1>W19 - COMP 1502 - Assignment 1 Player Class</h1> A Player has roster
 * info. Name, position, number, date of birth, hometown, weight, height. These
 * are stored as String with only position being stored as an enum. A Player has
 * default 0 stats of goals, assists, power play goals, power play assists, and
 * shots. Power play goals and power play assists are a subset of goals and
 * assists respectively. Every goal is a shot but players generally have more
 * shots than goals. All these values should be 0 or greater. The class allows
 * for roster info to be set, a shot to be added, and for a goal and power play
 * goal to be added with the proper addition of shots at the same time. Also
 * available are methods to get Player roster or stats info as a String for
 * table output. And methods to construct a player from a String expected to
 * have been saved in a file, and a method to create a String to output to a
 * file.
 * 
 * @author Tyson Kendon, Jonathan Hudson
 * @version 1.0
 *
 */
public class Player {

	/**
	 * String name of player
	 */
	private String name;
	/**
	 * Enum Position of player
	 */
	private Position position;
	/**
	 * String number of player
	 */
	private String number;
	/**
	 * String date of birth of player
	 */
	private String dateOfBirth;
	/**
	 * String hometown of player
	 */
	private String homeTown;
	/**
	 * String Weight of player
	 */
	private String weight;
	/**
	 * String height of player
	 */
	private String height;
	/**
	 * Integer goals of player (goals >= 0)
	 */

	/**
	 * Create all parts of a player
	 * 
	 * @param name        String name of player
	 * @param position    Enum Position of player
	 * @param number      String number of player
	 * @param dateOfBirth String date of birth of player
	 * @param homeTown    String hometown of player
	 * @param weight      String weight of player
	 * @param height      String height of player
	 */
	public Player(String name, Position position, String number, String dateOfBirth, String homeTown, String weight, String height) {
		this.name = name;
		this.position = position;
		this.number = number;
		this.dateOfBirth = dateOfBirth;
		this.homeTown = homeTown;
		this.weight = weight;
		this.height = height;
	}

	/**
	 * Player's name
	 * 
	 * @return String of name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Player's position
	 * 
	 * @return Enum Position of position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * Player's jersey number
	 * 
	 * @return String of jersey number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Player's date of birth
	 * 
	 * @return String of date of birth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Player's hometown
	 * 
	 * @return String of hometown
	 */
	public String getHomeTown() {
		return homeTown;
	}

	/**
	 * Player's height
	 * 
	 * @return String of height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * Player's weight
	 * 
	 * @return String of weight
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * Return &gt;name&lt;-&gt;#&lt; String of player
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name + " - " + number;
	}

	/**
	 * Player's goals
	 * 
	 * @return Integer of goals
	 */

	/**
	 * Record a shot
	 */

	/**
	 * A roster table header for all Player's
	 * 
	 * @return String containing headers for players' roster info table
	 */
	private static final String ROSTER_FORMAT = "%-20s %2s %3s %20s %-25s %8s %8s";

	/**
	 * @return
	 */
	public static String getFormattedRosterHeader() {
		return String.format(ROSTER_FORMAT, "Name", "#", "Pos", "Birthdate", "Home Town", "Weight", "Height");
	}

	/**
	 * A roster table entry for a player
	 * 
	 * @return String containing entries of player's roster info formatted for table
	 *         type spacing
	 */
	public String getFormattedRoster() {
		return String.format(ROSTER_FORMAT, name, number, position, dateOfBirth, homeTown, weight, height);
	}

	/**
	 * Reads a csv formatted String of a Player presumably from a file to construct
	 * a Player name,pos,#,dob,home,wt,ht,G,A,PPG,PPA,SH,
	 * 
	 * @param playerFileFormatString String of player with ",' between each entry
	 */
	public Player(String playerFileFormatString) {
		ArrayList<String> data = new ArrayList<>(Arrays.asList(playerFileFormatString.split(",")));
		this.name = data.get(0);
		this.position = Position.valueOf(data.get(1));
		this.number = data.get(2);
		this.dateOfBirth = data.get(3);
		this.homeTown = data.get(4);
		this.weight = data.get(5);
		this.height = data.get(6);
		this.goals = Integer.parseInt(data.get(7));
		this.assists = Integer.parseInt(data.get(8));
		this.powerPlayGoals = Integer.parseInt(data.get(9));
		this.powerPlayAssists = Integer.parseInt(data.get(10));
		this.shots = Integer.parseInt(data.get(11));
	}

	/**
	 * Returns a csv formatted String of a Player for file storage (no new line)
	 * name,pos,#,dob,home,wt,ht,G,A,PPG,PPA,SH,
	 * 
	 * @return String for player with "," between each entry
	 */
	public String getFileFormatString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name).append(",");
		builder.append(position).append(",");
		builder.append(number).append(",");
		builder.append(dateOfBirth).append(",");
		builder.append(homeTown).append(",");
		builder.append(weight).append(",");
		builder.append(height).append(",");
		builder.append(goals).append(",");
		builder.append(assists).append(",");
		builder.append(powerPlayGoals).append(",");
		builder.append(powerPlayAssists).append(",");
		builder.append(shots).append(",");
		return builder.toString();
	}

}
