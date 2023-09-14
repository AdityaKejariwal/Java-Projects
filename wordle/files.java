package wordle;

import java.util.Random;
import java.util.stream.Stream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class files {
	Path filePath = Paths
			.get("C:\\Users\\kejar\\OneDrive\\Documents\\My Stuff\\Programming\\Java\\src\\wordle\\words.txt");

	public String getWord() {
		String secondLine = "";
		int place = randNum();
		try (Stream<String> streamOfLines = Files.lines(filePath)) {
			secondLine = streamOfLines.skip(place - 1).findFirst().get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return secondLine;
	}

	private int randNum() {
		Random rand = new Random();
		int min = 1;
		int max = 2500;
		int randomNum = rand.nextInt((max - min) + 1) + min;
		// System.out.println("Random number between " + min + " and " + max + ": " + randomNum);
		return randomNum;
	}
	
}
