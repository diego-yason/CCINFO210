package control;

import java.util.Scanner;

public class UserInputs {

	public static boolean confirmAction(Scanner scan) {
		try {
		System.out.println("Are you sure? (True/False)");
		boolean confirm = Boolean.parseBoolean(scan.nextLine());
		System.out.flush();
		return confirm;
		}catch(Exception e) {
			System.out.println("Invalid input");
			return false;
		}
	}


	
	
}
