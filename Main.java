import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * A simple Time Keeper Program for hockey
 * 
 * @author Reatha JOhner
 * @version 1.0
 *
 */
public class Main {

	/**
	 * Internal keyboard System.in scanner
	 */
	private static Scanner kb;

	/**
	 * Main of the program
	 * 
	 * @param args No arguments
	 * @throws FileNotFoundException Throws up if file not found for roster to
	 *                               load/save
	 */
	public static void main(String[] args) throws FileNotFoundException {
		kb = new Scanner(System.in);
		System.out.println("Enter Storage Filename (Blank to start new):");
		String filename = kb.nextLine();
		PlayerList list;
		if (filename.isEmpty()) {
			// Empty list if no filename
			list = new TeamReader();
			System.out.println("New list created");
		} else {
			list = new TeamReader(new File(filename));
			System.out.println("File loaded");
		}
		System.out.println("Time Keeper DB V1");
		runMenu(list);
		System.out.println("Save data to " + filename + "? (Y/N)");
		String yn = kb.nextLine();
		if (yn.equalsIgnoreCase("y")) {
			// Get filename if none was entered earlier to save to
			if (filename.isEmpty()) {
				System.out.println("Enter filename to save to:");
				filename = kb.nextLine();
			}
			if (list.recordToFile(new File(filename))) {
				System.out.println("Saved output to file " + filename);
			} else {
				System.out.println("Not able to save file.");
			}
		}
		System.out.println("Exiting");
		kb.close();
	}

	/**
	 * Menu loop
	 * 
	 * @param list The PlayerList holding a roster of players
	 */
	private static void runMenu(PlayerList list) {
		boolean keepRunning = true;
		do {
			printMenu();
			keepRunning = doMenu(kb.nextLine(), list);
		} while (keepRunning);
	}

	/**
	 * Menu printer to System.out
	 */
	private static void printMenu() {
		System.out.println("1 - List Player Roster");
		System.out.println("2 - List Player Stats");
		System.out.println("3 - List Goalie Stats");
		System.out.println("A - Add player");
		System.out.println("S # - record a shot for player" + "goalie number");
		System.out.println("G # <#> <#> - " + "record a goal for the " + "first player, " + "optionally assists for the second and third" + "goalie number");
		System.out.println("P # <#> <#> - " + "record a power play goal for " + "the first player, " + "optionally assists for the second and third" + "goalie number");
		System.out.println("SA # - record a shot against a goalie");
		System.out.println("GA # - record a goal against a goalie");
		System.out.println("GP # MIN - record a game played by a goalie with given minutes");
		System.out.println("SO # MIN - record a game played with a shutout by a goalie with given minutes);
		System.out.println();
		System.out.println("Q - quit");
	}

	/**
	 * Menu option switch
	 * 
	 * @param input The input from menu options
	 * @param list  The PlayerList of roster
	 * @return True if option was selected, False for quit
	 */
	private static boolean doMenu(String input, PlayerList list) {
		ArrayList<String> parsed = new ArrayList<>(Arrays.asList(input.split(" ")));
		switch (parsed.get(0).toUpperCase()) {
		case "1":
			listRoster(list);
			break;
		case "2":
			listStats(list);
			break;
		case "3":
			listStats(list);
			break;
		case "A":
			addPlayer(list);
			break;
		case "S":
			recordShot(list, parsed.get(1));
			break;
		case "G":
			recordGoal(list, input, false);
			break;
		case "P":
			recordGoal(list, input, true);
		case "SA":
			recordShotAgainst(list, input);
		case "GA":
			recordGoalAgainst(list, input);
			break;
		case "GP":
			recordGamePlayed(list, input);
		case "SO":
			recordShutOutGame(list, input);
		case "Q":
			return false;
		}
		return true;
	}

	/**
	 * List player roster
	 * 
	 * @param list The PlayerList of roster
	 */
	private static void listRoster(PlayerList list) {
		list.listAllPlayersRoster();
	}

	/**
	 * List player stats
	 * 
	 * @param list The PlayerList of roster
	 */
	private static void listStats(PlayerList list) {
		list.listAllPlayersStats();
	}

	/**
	 * Add a player to roster
	 * 
	 * @param list The PlayerList of roster
	 */
	private static void addPlayer(PlayerList list) {
		System.out.println("Enter Player information");
		System.out.print("Name: ");
		String name = kb.nextLine();
		System.out.print("Position: ");
		Position pos = Position.valueOf(kb.nextLine());
		System.out.print("Number: ");
		String number = kb.nextLine();
		System.out.print("Date of Birth: ");
		String dob = kb.nextLine();
		System.out.print("HomeTown: ");
		String hometown = kb.nextLine();
		System.out.print("Weight: ");
		String weight = kb.nextLine();
		System.out.print("Height: ");
		String height = kb.nextLine();
		list.addPlayer(new Player(name, pos, number, dob, hometown, weight, height));
	}

	/**
	 * Record a shot by a player
	 * 
	 * @param list         The PlayerList of roster
	 * @param playerNumber The String number of a player
	 */
	private static void recordShot(PlayerList list, String number) {
		System.out.println("Recorded shot for " + number);
		list.recordShot(number);
	}

	/**
	 * Record a goal/power play goal for a player with one or two assists
	 * 
	 * @param list      The PlayerList of roster
	 * @param input     The input list including G/P to start, ex G 1 ex. P 42 23 1
	 * @param powerplay Whether this was a power play goal or not
	 */
	private static void recordGoal(PlayerList list, String input, boolean powerplay) {
		ArrayList<String> parsed = new ArrayList<>(Arrays.asList(input.split(" ")));
		if (parsed.size() == 2) {
			String g = parsed.get(1);
			if (!powerplay) {
				System.out.println("Recorded goal for " + g);
				list.recordGoal(g);
			} else {
				System.out.println("Recorded PP goal for " + g);
				list.recordPowerPlayGoal(g);
			}
		} else if (parsed.size() == 3) {
			String g = parsed.get(1);
			String a1 = parsed.get(2);
			if (!powerplay) {
				System.out.println("Recorded assist for " + a1);
				list.recordGoal(g, a1);
			} else {
				System.out.println("Recorded PP assist for " + a1);
				list.recordPowerPlayGoal(g, a1);
			}
		} else if (parsed.size() == 4) {
			String g = parsed.get(1);
			String a1 = parsed.get(2);
			String a2 = parsed.get(3);
			if (!powerplay) {
				System.out.println("Recorded assist for " + a2);
				list.recordGoal(g, a1, a2);
			} else {
				System.out.println("Recorded PP assist for " + a2);
				list.recordPowerPlayGoal(g, a1, a2);
			}
		}
		
	}

}