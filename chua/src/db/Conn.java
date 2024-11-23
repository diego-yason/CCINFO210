package db;

import java.sql.Connection;
import java.sql.DriverManager;
public class Conn{
    //Connection variable
    private Connection connection = null;


    //Wrapper function for connect
    public String connect() {
        String url = "jdbc:mysql://35.229.251.147:3306/CCINFO210DB";
        String user = "root";
        String pw = "DLSU1234!";
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, pw);
            return null;
        } catch(Exception e) {
        	return e.getMessage();
        }
    }

    //Wrapper function for closing the connection
    public String close() {
        try {
            if(this.connection != null) {
				this.connection.close();
			}
            	return null;
            } catch (Exception e) {
                return e.getMessage();
            }
    }

    public Connection getConnection() {
    	return this.connection;
    }


}
