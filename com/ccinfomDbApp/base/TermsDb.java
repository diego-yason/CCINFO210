package com.ccinfomDbApp.base;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TermsDb {
	private Connection connection;

    public TermsDb(Connection connection) {
        this.connection = connection;
    }

    private boolean isValidTermId(String id) {
        return Pattern.matches("\\d{3}[ABC]", id);
    }

    public void insertTerm(Terms term) throws SQLException {
    	
        if (!isValidTermId(term.getId())) {
            throw new IllegalArgumentException("Invalid term ID format. Must be like 124A, 124B, or 124C.");
        }

        String query = "INSERT INTO terms (id, termStart, termEnd) VALUES (?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, term.getId());
            stmt.setDate(2, Date.valueOf(term.getTermStart()));
            stmt.setDate(3, Date.valueOf(term.getTermEnd()));
            stmt.executeUpdate();
        }
    }

    public List<Terms> getAllTerms() throws SQLException {
    	
        List<Terms> termsList = new ArrayList<>();
        
        String query = "SELECT * FROM terms";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
        	
            while (rs.next()) {
                Terms term = new Terms(
                    rs.getString("id"),
                    rs.getDate("termStart").toLocalDate(),
                    rs.getDate("termEnd").toLocalDate()
                );
                termsList.add(term);
            }
        }
        return termsList;
    }

    public void updateTerm(Terms term) throws SQLException {
        if (!isValidTermId(term.getId())) {
            throw new IllegalArgumentException("Invalid term ID format. Must be like 124A, 124B, or 124C.");
        }

        String query = "UPDATE terms SET termStart = ?, termEnd = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDate(1, Date.valueOf(term.getTermStart()));
            stmt.setDate(2, Date.valueOf(term.getTermEnd()));
            stmt.setString(3, term.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteTerm(String id) throws SQLException {
        if (!isValidTermId(id)) {
            throw new IllegalArgumentException("Invalid term ID format. Must be like 124A, 124B, or 124C.");
        }

        String query = "DELETE FROM terms WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }
}
