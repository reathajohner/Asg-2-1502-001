import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TeamReader {
/**
	 * Internal method to load a player from a file (used by constructor that takes
	 * in File)
	 * 
	 * @param file The file to open and read player data out of
	 * @throws FileNotFoundException If file doesn't exist
	 */
	public void loadPlayerList(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			Player p = new Player(scanner.nextLine());
			PlayerList.addPlayer(p);
			if (p.getPosition() == Position.G) {
				PlayerList.addGoalie(p);
			}
			else {
				PlayerList.addSkater(p);
			}
		}
		scanner.close();
	}
}