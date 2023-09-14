package wordle;

import java.util.Scanner;

public class wordle {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_MAGENTA = "\u001B[95m";

	String answer;

	public wordle() {
		answer = "";
	}

	private String getAnswer() {
		files f = new files();
		return f.getWord();
	}

	private StringBuilder compareGuess(String userGuess) {
		StringBuilder sb = new StringBuilder("");
		for (int j = 0; j < userGuess.length(); j++) {
			char c = userGuess.charAt(j);
			if (answer.charAt(j) == c)
				sb.append(ANSI_GREEN + c + ANSI_RESET);
			else if (answer.contains(Character.toString(c)))
				sb.append(ANSI_YELLOW + c + ANSI_RESET);
			else
				sb.append(c);
		}
		return sb;
	}

	private boolean checkUserGuess(String userGuess) {

		return !(userGuess.length() == 5);
	}

	private String getUserGuess(int i) {
		if (i == 0)
			System.out.print("ENTER YOUR " + (i + 1) + "ST GUESS: ");
		else if (i == 1)
			System.out.print("ENTER YOUR " + (i + 1) + "ND GUESS: ");
		else if (i == 2)
			System.out.print("ENTER YOUR " + (i + 1) + "RD GUESS: ");
		else
			System.out.print("ENTER YOUR " + (i + 1) + "TH GUESS: ");
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	private void eachStep(int i) {
		String where[] = { "FIRST", "SECOND", "THIRD", "FOURTH", "FIFTH" };
		String userGuess = getUserGuess(i).toUpperCase();
		if (checkUserGuess(userGuess)) {
			System.out.print(ANSI_RED + "5 LETTERED WORDS ONLY!!!\n" + ANSI_RESET + "\n");
			i--;
		} else {
			if (userGuess.equals(answer)) {
				System.out.println(ANSI_MAGENTA + "WOW!!!\nYOU HAVE GUESSED THE CORRECT ANSWER!!" + ANSI_RESET);
				System.exit(i);
			}
			StringBuilder sb = compareGuess(userGuess);
			System.out.println("RESULT AFTER " + where[i] + " GUESS: " + sb.toString());
		}
	}

	public void working() {
		System.out.println("WELCOME TO WORDLE!!!\n");
		answer = getAnswer().toUpperCase();
		System.out.println("THE ANSWER HAS BEEN GENERATED!!\n");
		for (int i = 0; i < 5; i++) {
			eachStep(i);
		}
		System.out.println("BETTER LUCK NEXT TIME!!!\nTHE ANSWER WAS: " + answer);
		System.exit(0);
	}
}
