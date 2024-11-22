import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Section extends DatabaseObject {
    public String courseCode;
    public String sectionCode;
    public String termId;
    public int assignedFacultyId;
    public char status;

    public Section(String courseCode, String sectionCode, String termId, int assignedFacultyId, char status) {
        this.courseCode = courseCode;
        this.sectionCode = sectionCode;
        this.termId = termId;
        this.assignedFacultyId = assignedFacultyId;
        this.status = status;
        this.isInDatabase = false;

        DataManager.sections.add(this);
    }

    public Section(String courseCode, String sectionCode, String termId, int assignedFacultyId, char status,
            boolean isInDatabase) {
        this(courseCode, sectionCode, termId, assignedFacultyId, status);
        this.isInDatabase = isInDatabase;
    }

    public void sync() {
        if (!isInDatabase) {
            // TODO: add warning message
            return;
        }

        String query = App.readQuery("coreData/UpdateSection");
        try (PreparedStatement statement = App.db.prepareStatement(query)) {
            statement.setString(3, courseCode);
            statement.setString(4, sectionCode);
            statement.setString(5, termId);
            statement.setInt(2, assignedFacultyId);
            statement.setString(1, String.valueOf(status));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert() {
        if (isInDatabase) {
            // TODO: add warning message
            return;
        }

        String query = App.readQuery("coreData/OpenSection");
        try (PreparedStatement statement = App.db.prepareStatement(query)) {
            statement.setString(1, courseCode);
            statement.setString(2, sectionCode);
            statement.setString(3, termId);
            statement.setInt(4, assignedFacultyId);
            statement.setString(5, String.valueOf(status));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
