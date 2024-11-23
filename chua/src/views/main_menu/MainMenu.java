package views.main_menu;
public class MainMenu {
	
	public static void transactionsMenu() {
		System.out.println("2 - Submit a Students Final Grade");
		System.out.println("1 - Upload a File to the Database");
		System.out.println("0 - Go back");
		System.out.println("");
		System.out.println("What would you like to do?");
		System.out.flush();

	}

	public static void coreDataMenu() {
		System.out.println("7 - Read a Courses Sections list");
		System.out.println("6 - Read a Students Grades list");
		System.out.println("5 - Read Students Data");
		System.out.println("4 - Update Course Details");
		System.out.println("3 - Insert a New Course");
		System.out.println("2 - Delete an Existing Course");
		System.out.println("1 - Read Courses Data");
		System.out.println("0 - Go back");
		System.out.println("");
		System.out.println("What would you like to do?");
		System.out.flush();

	}

	public static void reportsMenu() {
		System.out.println("1 - Generate Course Grade Distribution Report per Term and Academic Year");
		System.out.println("0 - Go back");
		System.out.println("");
		System.out.println("What would you like to do?");
		System.out.flush();

	}

	public static void mainMenu() {
		System.out.println("3 - Reports Menu");
		System.out.println("2 - Transactions Menu");
		System.out.println("1 - Core Data Management Menu");
		System.out.println("0 - Exit");
		System.out.println("");
		System.out.println("What would you like to do?");
		System.out.flush();
	}
	

}
