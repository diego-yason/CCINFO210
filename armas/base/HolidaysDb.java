package com.ccinfomDbApp.base;

import java.sql.*;

public class HolidaysDb {
	 private final Connection connection;

	    public HolidaysDb(Connection connection) {
	        this.connection = connection;
	    }

	    public void createHoliday(String name, String date) {
	        String sql = "INSERT INTO holidays (name, date) VALUES (?, ?)";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setString(1, name);
	            stmt.setString(2, date);
	            stmt.executeUpdate();
	            System.out.println("Holiday added successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void readHolidays() {
	        String sql = "SELECT * FROM holidays";
	        try (PreparedStatement stmt = connection.prepareStatement(sql);
	             ResultSet rs = stmt.executeQuery()) {

	            System.out.println("Holidays:");
	            while (rs.next()) {
	                String name = rs.getString("name");
	                String date = rs.getString("date");
	                System.out.println("Holiday: " + name + ", Date: " + date);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void updateHoliday(String oldName, String newName, String newDate) {
	        String sql = "UPDATE holidays SET name = ?, date = ? WHERE name = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setString(1, newName);
	            stmt.setString(2, newDate);
	            stmt.setString(3, oldName);
	            int rowsAffected = stmt.executeUpdate();
	            if (rowsAffected > 0) {
	                System.out.println("Holiday updated successfully.");
	            } else {
	                System.out.println("Holiday not found.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void deleteHoliday(String name) {
	        String sql = "DELETE FROM holidays WHERE name = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setString(1, name);
	            int rowsAffected = stmt.executeUpdate();
	            if (rowsAffected > 0) {
	                System.out.println("Holiday deleted successfully.");
	            } else {
	                System.out.println("Holiday not found.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
