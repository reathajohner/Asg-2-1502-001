import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TeamWriter {
	
	/**
	 * Write the player data out to the given File
	 * 
	 * @param file The File to open and write player data to
	 * @throws FileNotFoundException If file doesn't exist to write to
	 */
	public boolean recordToFile(File file) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(file);
		for (Player p : players) {
			writer.println(p.getFileFormatString());
		}
		writer.close();
		return true;
	}
}
