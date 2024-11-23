package db.queries;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import db.Conn;
import models.Grade;
import views.ResultMessages;

public class TransactionQueries {
	private Conn connection = null;

	public TransactionQueries(Conn conn) {
		this.connection = conn;
	}
	public String insertGrade(ArrayList<Grade> grades) {
		try {
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO grades(studentId,courseCode,grade,termId,sectionCode) values ");

		for(int i=0; i<grades.size(); i++) {
			if(i==grades.size()-1)
				sb.append("(?,?,?,?,?) ");
			else
				sb.append("(?,?,?,?,?), ");
		}
		String query = sb.toString();
		String result = this.connection.connect();
		if(result != null)
			throw new Exception(result);
		
		PreparedStatement ps = this.connection.getConnection().prepareStatement(query);
		
		for(int i=0; i<grades.size(); i++) {
			Grade currGrade = grades.get(i);
			ps.setInt(1+5*i,currGrade.getStudentId());
			ps.setString(2+5*i,currGrade.getCourseCode());
			ps.setFloat(3+5*i,currGrade.getGrade());
			ps.setString(4+5*i,currGrade.getTermId());
			ps.setString(5+5*i, currGrade.getSection());
		};
		
		ps.executeUpdate();
		result = this.connection.close();
		if(result != null)
			throw new Exception(result);
		return null;
		} catch(SQLException e) {
			this.connection.close();
			return ResultMessages.INSERT_ERROR;
		} catch(Exception e) {
			return e.getMessage();
		}
	}

	/**
	 * Validates the grades because only values of multiples 0.5 until 4.0 is allowed
	 * @param grade Grade to be validated
	 * @return True if valid, otherwise false
	 */
	public boolean validateGrade(float grade) {
		//validate the grade if its in the range
		if(grade >= 1.0 && grade <= 4.0 && grade % 0.5 == 0) {
			return true;
		} else {
			return false;
		}
	}


}
