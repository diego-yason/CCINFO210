import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class App {
    // private static final String URL = "jdbc:mysql://localhost:3306/ccinfo210db";
    private static final String URL = "jdbc:mysql://35.229.251.147:3306/CCINFO210DB";
    private static final String USER = "root";
    private static final String PASSWORD = "DLSU1234!";

    public static Scanner scanner;
    public static Connection db;

    public static void main(String[] args) throws Exception {
        System.err.println("Connecting to database...");

        Class.forName("com.mysql.cj.jdbc.Driver");

        db = DriverManager.getConnection(URL, USER, PASSWORD);
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the CCINFO210 Database!");
            System.out.println("1. Core Data Management (Faculty)");
            System.out.println("2. Transaction Management (Creating, Closing, Dissolving classes)");
            System.out.println("3. Report Generation (Grade Distribution Report)");
            System.out.println("4. Exit");
            switch (getInput(1, 4)) {
                case 1:
                    CoreData.run();
                    break;
                case 2:
                    TransactionManagement.run();
                    break;
                case 3:
                    ReportGeneration.run();
                    break;
                case 4:
                    db.close();
                    scanner.close();
                    return;
            }
        }
    }

    public static String readQuery(String address) {
        StringBuilder query = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File("src/sql/" + address + ".sql"));
            while (scanner.hasNextLine()) {
                query.append(scanner.nextLine()).append(" ");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return query.toString();
    }

    public static int getInput(int min, int max) {
        while (true) {
            try {
                System.out.print(">>> ");
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public static String getTextInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static String getTextInput(String prompt, boolean required) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (required && input.isEmpty()) {
                System.out.println("ERR: This field is required.");
            } else {
                return input;
            }
        }
    }
}
