import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CoreData {
    public static void run() throws SQLException {
        while (true) {
            System.out.println("Core Data Management (Faculty)");
            System.out.println("1. Add Faculty");
            System.out.println("2. Remove Faculty");
            System.out.println("3. Update Faculty");
            System.out.println("4. View Faculty");
            System.out.println("5. Back");

            switch (App.getInput(1, 5)) {
                case 1:
                    addFaculty();
                    break;
                case 2:
                    removeFaculty();
                    break;
                case 3:
                    updateFaculty();
                    break;
                case 4:
                    viewFaculty();
                    break;
                case 5:
                    return;
            }
        }
    }

    private static void addFaculty() {
        System.out.println("=== Add Faculty ===");

        String idText = App.getTextInput("Enter ID: ");

        // id needs to be 8 digits long
        if (idText.length() != 8) {
            System.out.println("ERR: ID must be 9 digits long");
            return;
        }

        // id needs to begin with 999
        if (!idText.startsWith("999")) {
            System.out.println("ERR: ID must begin with 999");
            return;
        }
        int id = Integer.parseInt(idText);

        String firstName = App.getTextInput("Enter first name: ", true);
        String lastName = App.getTextInput("Enter last name: ", true);

        Department dept;

        try {
            dept = Paginators.getDepartment(getDepartmentNameList());
        } catch (SQLException e) {
            System.out.println("ERR: Could not fetch department list");
            e.printStackTrace();
            return;
        }

        Faculty profile = new Faculty(id, firstName, lastName, dept.name);

        try {
            String query = App.readQuery("coreData/CreateFaculty");
            PreparedStatement pStatement = App.db.prepareStatement(query);
            pStatement.setInt(1, profile.id);
            pStatement.setString(2, profile.firstName);
            pStatement.setString(3, profile.lastName);
            pStatement.setString(4, profile.department);
            pStatement.executeUpdate();
            System.out.println("Faculty added successfully");
        } catch (SQLException e) {
            System.out.println("ERR: Faculty could not be added");
            e.printStackTrace();
        }
    }

    private static void removeFaculty() {
        System.out.println("Remove Faculty");

        // get faculty names and profiles
        ArrayList<Faculty> data;
        try {
            data = getFacultyList();
        } catch (SQLException e) {
            System.out.println("ERR: Could not fetch faculty list");
            e.printStackTrace();
            return;
        }

        Faculty profile = Paginators.getFaculty(data);

        // verify if deletion is possible
        String query = App.readQuery("coreData/CheckSections");
        try (PreparedStatement pStatement = App.db.prepareStatement(query)) {
            pStatement.setInt(1, profile.id);
            ResultSet rs = pStatement.executeQuery();

            while (rs.next()) {
                if (rs.getInt("classCount") != 0) {
                    // Professor is in a class, can't remove
                    System.out.println("ERR: Cannot remove faculty with active sections");
                    return;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERR: Could not check if faculty has active sections");
            return;
        }

        System.out.println("Are you sure you want to remove this faculty?");

        if (App.getTextInput("Enter 'y' to confirm: ").equals("y")) {
            query = App.readQuery("coreData/RemoveFaculty");
            try (PreparedStatement pStatement = App.db.prepareStatement(query)) {
                pStatement.setInt(1, profile.id);
                pStatement.executeUpdate();
                System.out.println("Faculty removed successfully");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("ERR: Could not remove faculty");
            }
        }
    }

    private static void updateFaculty() {
        System.out.println("Update Faculty");

        ArrayList<Faculty> data;
        try {
            data = getFacultyList();
        } catch (SQLException e) {
            System.out.println("ERR: Could not fetch faculty list");
            e.printStackTrace();
            return;
        }

        Faculty profile = Paginators.getFaculty(data);

        System.out.println("What would you like to update?");
        System.out.println("1. First Name");
        System.out.println("2. Last Name");
        System.out.println("3. Department");
        System.out.println("4. Back/Cancel");
        int choice = App.getInput(1, 4);

        switch (choice) {
            case 1:
                profile.firstName = App.getTextInput("Enter new first name: ");
                break;
            case 2:
                profile.lastName = App.getTextInput("Enter new last name: ");
                break;
            case 3:
                Department dept;
                try {
                    dept = Paginators.getDepartment(getDepartmentNameList());
                } catch (SQLException e) {
                    System.out.println("ERR: Could not fetch department list");
                    e.printStackTrace();
                    return;
                }
                profile.department = dept.name;
                break;
            case 4:
                return;
        }

        System.out.println("Are you sure you want to update this faculty member?");
        if (App.getTextInput("Enter 'y' to confirm: ").equals("y")) {

            String query = App.readQuery("coreData/UpdateFaculty");
            try (PreparedStatement pStatement = App.db.prepareStatement(query)) {
                pStatement.setString(1, profile.firstName);
                pStatement.setString(2, profile.lastName);
                pStatement.setString(3, profile.department);
                pStatement.setInt(4, profile.id);
                pStatement.executeUpdate();
                System.out.println("Faculty updated successfully");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("ERR: Could not update faculty");
                return;
            }
        }
    }

    private static void viewFaculty() throws SQLException {
        System.out.println("View Faculty");
        ArrayList<Faculty> data = getFacultyList();

        int page = 0;
        while (true) {
            int optionCount = Math.min(5, data.size() - (5 * page));
            boolean hasNext = data.size() > (5 * (page + 1));

            System.out.println("Faculty List");
            for (int i = 0; i < optionCount; i++) {
                Faculty faculty = data.get(i + (5 * page));
                System.out.println(
                        "<" + faculty.id + "> " + faculty.lastName + ", " + faculty.firstName + " ("
                                + faculty.department
                                + ")");
            }
            if (page > 0) {
                System.out.println("0. Previous");
            }
            System.out.println("1. Return to menu");
            if (hasNext) {
                System.out.println("2. Next");
            }

            int input = App.getInput(page == 0 ? 1 : 0, hasNext ? 2 : 1);

            switch (input) {
                case 0:
                    page--;
                    continue;
                case 2:
                    page++;
                    continue;
                case 1:
                    return;
            }
        }
    }

    private static ArrayList<Faculty> getFacultyList() throws SQLException {
        ArrayList<Faculty> data = new ArrayList<>();

        String query = App.readQuery("coreData/GetFaculty");
        Statement statement = App.db.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Faculty profile = new Faculty();
            profile.id = rs.getInt("id");
            profile.firstName = rs.getString("firstName");
            profile.lastName = rs.getString("lastName");
            profile.department = rs.getString("department");
            data.add(profile);
        }

        return data;
    }

    private static ArrayList<Department> getDepartmentNameList() throws SQLException {
        ArrayList<Department> data = new ArrayList<>();

        String query = App.readQuery("coreData/GetDepartmentNames");
        Statement statement = App.db.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Department dept = new Department();
            dept.name = rs.getString("name");
            data.add(dept);
        }

        return data;
    }

}
