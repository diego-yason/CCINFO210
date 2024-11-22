import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Faculty extends DatabaseObject {
    public int id;
    public String firstName;
    public String lastName;
    public String department;

    public Faculty(int id, String firstName, String lastName, String department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.isInDatabase = false;

        DataManager.faculties.add(this);
    }

    public Faculty(int id, String firstName, String lastName, String department, boolean isInDatabase) {
        this(id, firstName, lastName, department);
        this.isInDatabase = isInDatabase;
    }

    public void sync() {
        if (!isInDatabase) {
            // TODO: add warning message
            return;
        }

        String query = App.readQuery("coreData/UpdateFaculty");
        try (PreparedStatement statement = App.db.prepareStatement(query)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, department);
            statement.setInt(4, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        if (!isInDatabase) {
            // TODO: add warning message
            return;
        }

        String query = App.readQuery("coreData/DeleteFaculty");
        try (PreparedStatement statement = App.db.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            this.isInDatabase = false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert() {
        if (isInDatabase) {
            // TODO: add warning message
            return;
        }

        String query = App.readQuery("coreData/CreateFaculty");
        try (PreparedStatement statement = App.db.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, department);
            statement.executeUpdate();
            this.isInDatabase = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
