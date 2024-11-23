package db;

import java.sql.Connection;
import java.sql.DriverManager;
public class Conn{
    //Connection variable
    private Connection connection = null;


    //Wrapper function for connect
    public String connect() {
        String url = System.getenv("DATABASE_URL");
        String user = System.getenv("DATABASE_USR");
        String pw = System.getenv("DATABASE_PW");
        
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
