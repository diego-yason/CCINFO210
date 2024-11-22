import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataManager {
    private static DataManager instance;
    private static Connection db = App.db;

    public static ArrayList<Faculty> faculties = new ArrayList<>();
    public static ArrayList<Section> sections = new ArrayList<>();

    private DataManager() {
        // private constructor to prevent instantiation
    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }
    // singleton implementation

    public void getAllFaculty() {
        faculties.clear();

        String query = App.readQuery("coreData/GetAllFaculty");
        try {
            Statement statement = db.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                new Faculty(
                        rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("department"),
                        true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
