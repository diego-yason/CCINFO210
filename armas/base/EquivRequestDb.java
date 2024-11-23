package com.ccinfomDbApp.base;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquivRequestDb {
    private Connection connection;

    public EquivRequestDb(Connection connection) {
        this.connection = connection;
    }

    public void createRequest(EquivRequest request) throws SQLException {
        String sql = "INSERT INTO request_course_equivalence (studentId, date, approvedBy, requestCourse, equivalentCourse) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, request.getStudentId());
            stmt.setString(2, request.getDate());
            stmt.setString(3, request.getApprovedBy() == null ? null : request.getApprovedBy()); // Nullable field
            stmt.setString(4, request.getRequestCourse());
            stmt.setString(5, request.getEquivalentCourse());
            stmt.executeUpdate();
            System.out.println("Request for course equivalence created successfully.");
        }
    }

    public List<EquivRequest> getAllRequests() throws SQLException {
        List<EquivRequest> requests = new ArrayList<>();
        String sql = "SELECT requestId, studentId, date, approvedBy, requestCourse, equivalentCourse FROM request_course_equivalence";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                EquivRequest request = new EquivRequest(
                        rs.getInt("requestId"),
                        rs.getString("studentId"),
                        rs.getString("date"),
                        rs.getString("approvedBy"),
                        rs.getString("requestCourse"),
                        rs.getString("equivalentCourse")
                );
                requests.add(request);
            }
        }
        return requests;
    }

    public void updateRequest(EquivRequest request) throws SQLException {
        String sql = "UPDATE request_course_equivalence SET studentId = ?, date = ?, approvedBy = ?, requestCourse = ?, equivalentCourse = ? WHERE requestId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, request.getStudentId());
            stmt.setString(2, request.getDate());
            stmt.setString(3, request.getApprovedBy() == null ? null : request.getApprovedBy()); // Nullable field
            stmt.setString(4, request.getRequestCourse());
            stmt.setString(5, request.getEquivalentCourse());
            stmt.setInt(6, request.getRequestId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Request updated successfully.");
            } else {
                System.out.println("Request not found.");
            }
        }
    }

    public void deleteRequest(int requestId) throws SQLException {
        String sql = "DELETE FROM request_course_equivalence WHERE requestId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, requestId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Request deleted successfully.");
            } else {
                System.out.println("Request not found.");
            }
        }
    }
}
