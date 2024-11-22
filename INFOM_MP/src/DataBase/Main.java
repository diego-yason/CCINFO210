package DataBase;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
	public static void main (String[] args) throws SQLException {
		Connection connection = DBConnection.getConnection();
		new DatabaseController(connection);
		
		connection.close();
		System.out.println("\nConnection closed.");
		System.exit(0);
	}
}
