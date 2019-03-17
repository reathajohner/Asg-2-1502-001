import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TeamFactory {
	/**
	 * Write out to the console the players' roster info formatted as a table
	 */
	public void listAllPlayersRoster(PlayerList p) {
		System.out.println(Player.getFormattedRosterHeader());
		for (Player p : players) {
			System.out.println(p.getFormattedRoster());
		}
	}

	/**
	 * Write out to the console the players' stats formatted as a table
	 */
	public void listAllPlayersStats(PlayerList p) {
		System.out.println(Player.getFormattedStatsHeader());
		for (Player p : players) {
			System.out.println(p.getFormattedStats());
		}
	}
}
