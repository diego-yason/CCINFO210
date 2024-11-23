package db.queries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import models.Report;
import db.Conn;

public class ReportQueries {
	private Conn connection = null;
	
	public ReportQueries(Conn conn) {
		this.connection = conn;
	}

	/**
	 * Gets the course grade report per term and academic year
	 * @param term term 
	 * @param year academic year
	 * @param courseCode course code
	 * @return List of rows for the report, other wise null
	 */
	public ArrayList<Report> getCourseGradeReport(int term, int year, String courseCode) {
		try {
			ArrayList<Report> reportContent = new ArrayList<Report>();
			StringBuilder sb = new StringBuilder();
			sb.append(year);
			char termChar = (char)(term+64);
			sb.append(termChar);
			String termId = sb.toString();
			String result = this.connection.connect();
			if(result != null)
				throw new Exception(result);
			
			String query = "SELECT g.grade, COUNT(g.grade) as Count "
					+ "FROM grades g "
					+ "JOIN students s ON s.id = g.studentId "
					+ "JOIN courses c ON c.code = g.courseCode "
					+ "WHERE termId = ? "
					+ "AND g.courseCode = ? "
					+ "GROUP BY g.grade ";
			
			PreparedStatement ps = this.connection.getConnection().prepareStatement(query);
			ps.setString(1, termId);
			ps.setString(2, courseCode);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				float grade = rs.getFloat(1);
				int count = rs.getInt(2);

				reportContent.add(new Report(grade,count));
			}
			return reportContent;
			
		} catch(SQLException e) {
			return null;
		} catch(Exception e) {
			return null;
		}
	}
	
	public void sortByCount(ArrayList<Report> report, boolean isAscending) {
		Collections.sort(report, (rowFirst, rowSecond) -> {
			if(isAscending)
				return (int)(rowFirst.getCount() - rowSecond.getCount());
			else
				return (int)(rowSecond.getCount()-rowFirst.getCount());
		});
		
	}
	

	
	
	

}
