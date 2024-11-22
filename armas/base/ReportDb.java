package com.ccinfomDbApp.base;

import java.sql.*;

public class ReportDb {
    private Connection connection;

    public ReportDb(Connection connection) {
        this.connection = connection;
    }

    public void generateCourseTeacherDistribution(int yearStart, int yearEnd) {
    	
        String sql = "SELECT s.courseCode, c.name AS courseName, f.firstName, f.lastName, " +
                     "t.termStart, t.termEnd, t.id AS termId " +
                     "FROM sections s " +
                     "JOIN faculty f ON s.assignedFacultyId = f.id " + 
                     "JOIN courses c ON s.courseCode = c.code " +
                     "JOIN terms t ON s.termId = t.id " +
                     "WHERE YEAR(t.termStart) = ? AND YEAR(t.termEnd) = ? " +
                     "ORDER BY t.termStart, c.name, f.lastName";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, yearStart);
            stmt.setInt(2, yearEnd);

            ResultSet rs = stmt.executeQuery();

            System.out.printf("%-10s | %-40s | %-20s | %-12s | %-12s | %-6s%n",
                    "Course Code", "Course Name", "Teacher", "Term Start", "Term End", "Term ID");
            System.out.println("-----------------------------------------------------------------------------------------------");

            while (rs.next()) {
                String courseCode = rs.getString("courseCode");
                String courseName = rs.getString("courseName");
                String teacherName = rs.getString("firstName") + " " + rs.getString("lastName");
                Date termStart = rs.getDate("termStart");
                Date termEnd = rs.getDate("termEnd");
                String termId = rs.getString("termId");

                System.out.printf("%-10s  | %-40s | %-20s | %-12s | %-12s | %-6s%n",
                        courseCode, courseName, teacherName, termStart, termEnd, termId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
