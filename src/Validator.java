import java.util.Scanner;

public class Validator {

public static boolean getYesNo(Scanner scnr, String prompt) {
	String input;
	boolean isValid;
	do {
		System.out.println(prompt);
		input = scnr.nextLine();
		isValid = "yes".equalsIgnoreCase(input) ||
				"no".equalsIgnoreCase(input) || "y".equalsIgnoreCase(input)
				|| "n".equalsIgnoreCase(input);
		if (!isValid) {
			System.out.println("Invalid response. Enter yes or no.");
		}
	} while (!isValid);
	
	return input.toLowerCase().startsWith("y");
}
}