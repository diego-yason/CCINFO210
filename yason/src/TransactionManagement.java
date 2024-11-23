import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransactionManagement {

    public static void run() {
        System.out.println("Transaction Management (Sections)");
        System.out.println("1. Open a new Section");
        System.out.println("2. Close a Section");
        System.out.println("3. Reopen a closed Section");
        System.out.println("4. Dissolve a Section");
        System.out.println("5. Back");

        switch (App.getInput(1, 5)) {
            case 1:
                openSection();
                break;
            case 2:
                closeSection();
                break;
            case 3:
                reopenSection();
                break;
            case 4:
                dissolveSection();
                break;
            case 5:
                return;
        }
    }

    private static void openSection() {
        System.out.println("=== Open a new Section ===");

        Course course;
        try {
            course = selectCourse();
        } catch (SQLException e) {
            System.out.println("ERR: Unable to fetch courses");
            return;
        }
        String section = App.getTextInput("Enter the section name: ");
        if (section.length() > 3) {
            System.out.println("ERR: Section name must be 3 characters or less");
            return;
        }

        ArrayList<Faculty> facultyData;
        try {
            String query = App.readQuery("transactions/GetFacultyInDepartment");
            PreparedStatement statement = App.db.prepareStatement(query);
            statement.setString(1, course.code);
            ResultSet rs = statement.executeQuery();

            facultyData = new ArrayList<>();
            while (rs.next()) {
                Faculty faculty = new Faculty();
                faculty.id = rs.getInt("id");
                faculty.firstName = rs.getString("firstName");
                faculty.lastName = rs.getString("lastName");
                faculty.department = rs.getString("department");
                facultyData.add(faculty);
            }

        } catch (SQLException e) {
            System.out.println("ERR: Unable to fetch faculty");
            return;
        }

        Faculty faculty = Paginators.getFaculty(facultyData);

        try {
            String query = App.readQuery("transactions/OpenSection");
            PreparedStatement statement = App.db.prepareStatement(query);
            statement.setString(1, course.code);
            statement.setString(2, section);
            statement.setInt(3, faculty.id);
            statement.executeUpdate();

            System.out.println("Section opened successfully");
        } catch (SQLException e) {
            System.out.println("ERR: Unable to open section");
            e.printStackTrace();
            return;
        }
    }

    private static void closeSection() {
        System.out.println("=== Close a Section ===");

        Course course;
        try {
            course = selectCourse();
        } catch (SQLException e) {
            System.out.println("ERR: Unable to fetch courses");
            return;
        }

        ArrayList<Section> sectionData;
        try {
            String query = App.readQuery("transactions/GetSections");
            PreparedStatement statement = App.db.prepareStatement(query);
            statement.setString(1, course.code);
            statement.setString(2, "O");
            ResultSet rs = statement.executeQuery();

            sectionData = new ArrayList<>();
            while (rs.next()) {
                Section section = new Section();
                section.courseCode = rs.getString("courseCode");
                section.sectionCode = rs.getString("sectionCode");
                sectionData.add(section);
            }
        } catch (SQLException e) {
            System.out.println("ERR: Unable to fetch sections");
            return;
        }

        if (sectionData.size() == 0) {
            System.out.println("ERR: No open sections found");
            return;
        }
        Section section = Paginators.getSection(sectionData);

        String confirm = App.getTextInput("Are you sure you want to close this section? (y): ");
        if (!confirm.equals("y")) {
            return;
        }

        try {
            String query = App.readQuery("transactions/CloseSection");
            PreparedStatement statement = App.db.prepareStatement(query);
            statement.setString(1, section.courseCode);
            statement.setString(2, section.sectionCode);
            statement.executeUpdate();

            System.out.println("Section closed successfully");
        } catch (SQLException e) {
            System.out.println("ERR: Unable to close section");
            e.printStackTrace();
            return;
        }
    }

    private static void reopenSection() {
        System.out.println("=== Reopen a closed Section ===");

        Course course;
        try {
            course = selectCourse();
        } catch (SQLException e) {
            System.out.println("ERR: Unable to fetch courses");
            return;
        }

        ArrayList<Section> sectionData;
        try {
            String query = App.readQuery("transactions/GetSections");
            PreparedStatement statement = App.db.prepareStatement(query);
            statement.setString(1, course.code);
            statement.setString(2, "C");
            ResultSet rs = statement.executeQuery();

            sectionData = new ArrayList<>();
            while (rs.next()) {
                Section section = new Section();
                section.courseCode = rs.getString("courseCode");
                section.sectionCode = rs.getString("sectionCode");
                sectionData.add(section);
            }
        } catch (SQLException e) {
            System.out.println("ERR: Unable to fetch sections");
            return;
        }

        if (sectionData.size() == 0) {
            System.out.println("ERR: No closed sections found");
            return;
        }

        Section section = Paginators.getSection(sectionData);

        String confirm = App.getTextInput("Are you sure you want to reopen this section? (y): ");
        if (!confirm.equals("y")) {
            return;
        }

        try {
            String query = App.readQuery("transactions/UpdateSectionStatus");
            PreparedStatement statement = App.db.prepareStatement(query);
            statement.setString(1, "O");
            statement.setString(2, section.courseCode);
            statement.setString(3, section.sectionCode);
            statement.executeUpdate();

            System.out.println("Section reopened successfully");
        } catch (SQLException e) {
            System.out.println("ERR: Unable to reopen section");
            e.printStackTrace();
            return;
        }
    }

    private static void dissolveSection() {
        System.out.println("=== Dissolve a Section ===");

        Course course;
        try {
            course = selectCourse();
        } catch (SQLException e) {
            System.out.println("ERR: Unable to fetch courses");
            return;
        }

        ArrayList<Section> sectionData;
        try {
            String query = App.readQuery("transactions/GetNonDissolvedSections");
            PreparedStatement statement = App.db.prepareStatement(query);
            statement.setString(1, course.code);
            ResultSet rs = statement.executeQuery();

            sectionData = new ArrayList<>();
            while (rs.next()) {
                Section section = new Section();
                section.courseCode = rs.getString("courseCode");
                section.sectionCode = rs.getString("sectionCode");
                sectionData.add(section);
            }
        } catch (SQLException e) {
            System.out.println("ERR: Unable to fetch sections");
            return;
        }

        if (sectionData.size() == 0) {
            System.out.println("ERR: No sections found");
            return;
        }

        Section section = Paginators.getSection(sectionData);
        String confirm = App
                .getTextInput("Are you sure you want to dissolve this section? THIS IS IRREVERSIBLE! (y): ");
        if (!confirm.equals("y")) {
            return;
        }

        try {
            String query = App.readQuery("transactions/UpdateSectionStatus");
            PreparedStatement statement = App.db.prepareStatement(query);
            statement.setString(1, "D");
            statement.setString(2, section.courseCode);
            statement.setString(3, section.sectionCode);
            statement.executeUpdate();

            System.out.println("Section dissolved successfully");
        } catch (SQLException e) {
            System.out.println("ERR: Unable to dissolve section");
            e.printStackTrace();
            return;
        }
    }

    private static Course selectCourse() throws SQLException {
        ArrayList<Course> courseData;
        String query = App.readQuery("transactions/GetCourses");
        ResultSet rs = App.db.createStatement().executeQuery(query);

        courseData = new ArrayList<>();
        while (rs.next()) {
            Course course = new Course();
            course.code = rs.getString("code");
            course.name = rs.getString("name");
            course.department = rs.getString("department");
            courseData.add(course);
        }

        return Paginators.getCourse(courseData);
    }
}
