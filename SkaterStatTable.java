public class SkaterStatTable extends TeamFactory {
	
	/**
	 * Write out to the console the players' roster info formatted as a table
	 */
	public void listAllPlayersRoster(PlayerList p) {
		System.out.println(Skater.getFormattedRosterHeader());
		for (Player p : players) {
			System.out.println(p.getFormattedRoster());
		}
	}
	
	/**
	 * Write out to the console the players' stats formatted as a table
	 */
	public void listAllPlayersStats(PlayerList p) {
		System.out.println(Skater.getFormattedStatsHeader());
		for (Player p : players) {
			System.out.println(p.getFormattedStats());
		}
	}

}