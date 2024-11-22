import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class App {
    private static final String local = "jdbc:mysql://localhost:3306/ccinfo210db";
    private static final String remote = "jdbc:mysql://100.103.244.13:3308/ccinfo210db";
    private static final String URL = local;
    private static final String USER = "root";
    private static final String PASSWORD = "DLSU1234!";

    private static Scanner scanner;

    public static void main(String[] args) throws Exception {
        Connection db = null;
        Class.forName("com.mysql.cj.jbdc.Driver");

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
                    CoreData.run(db);
                    break;
                case 2:
                    TransactionManagement.run(db);
                    break;
                case 3:
                    ReportGeneration.run(db);
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
            Scanner scanner = new Scanner(new File("sql/" + address));
            while (scanner.hasNextLine()) {
                query.append(scanner.nextLine()).append("\n");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return query.toString();
    }

    private static int getInput(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
