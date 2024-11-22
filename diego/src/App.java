import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class App {
    private static final String local = "jdbc:mysql://localhost:3306/ccinfo210db";
    private static final String remote = "jdbc:mysql://:3308/ccinfo210db";
    private static final String URL = local;
    private static final String USER = "root";
    private static final String PASSWORD = "DLSU1234!";

    public static void main(String[] args) throws Exception {
        Connection db = null;
        Class.forName("com.mysql.cj.jbdc.Driver");

        db = DriverManager.getConnection(URL, USER, PASSWORD);

        db.close();
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
}
