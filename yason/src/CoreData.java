import java.sql.Connection;

public class CoreData {
    public static void run() {
        while (true) {
            System.out.println("Core Data Management (Faculty)");
            System.out.println("1. Add Faculty");
            System.out.println("2. Remove Faculty");
            System.out.println("3. Update Faculty");
            System.out.println("4. View Faculty");
        }
    }

    private static void addFaculty() {
        System.out.println("Add Faculty");
    }

    private static void removeFaculty() {
        System.out.println("Remove Faculty");
    }

    private static void updateFaculty() {
        System.out.println("Update Faculty");
    }

    private static void viewFaculty() {
        System.out.println("View Faculty");
    }

}
