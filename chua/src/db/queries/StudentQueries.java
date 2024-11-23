package db.queries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.Conn;
import models.FilterConditions;
import models.Grade;
import models.Student;

public class StudentQueries {
	public Conn connection = null;
	
	
	public StudentQueries(Conn conn) {
		this.connection = conn;
	}
	
	/**
	 * Gets the students given a condition
	 * @param extraCondition SQL condition
	 * @param condition ENUM condition
	 * @param value Value of condition
	 * @return List of students, otherwise null
	 */
	public ArrayList<Student> getFilteredStudents(String extraCondition, FilterConditions condition, String value) {
		ArrayList<Student> list = new ArrayList<>();
		String query = "SELECT id, lastName, firstName, degreeProgram "
				+ "FROM	students "
				+ extraCondition
				+ " ORDER BY lastName, firstName";
		try {
			String result = this.connection.connect();
			if(result != null) {
				throw new Exception(result);
			}
			PreparedStatement ps = this.connection.getConnection().prepareStatement(query);
			
			switch(condition) {
				case FilterConditions.STUDENT_ID: {
					ps.setInt(1, Integer.parseInt(value));
					break;
				}
				case FilterConditions.STUDENT_DEGREE: {
					ps.setString(1, value);
					break;
				}
				default: {
					break;
				}
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String lastName = rs.getString(2);
				String firstName = rs.getString(3);
				String degreeProgram = rs.getString(4);
				list.add(new Student(id, lastName, firstName, degreeProgram));
			}
			return list;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	/**
	 * Gets a students grades
	 * @param value
	 * @return List of grades of the student
	 */
	public ArrayList<Grade> getStudentGrades(String value) {
		ArrayList<Grade> list = new ArrayList<Grade>();
		String query = "SELECT	courseCode,grade,termId "
				+ "FROM 	grades "
				+ "WHERE	studentId = ? "
				+ "ORDER BY	courseCode ";
		try {
			String result = this.connection.connect();
			if(result != null) {
				throw new Exception(result);
			}
			PreparedStatement ps = this.connection.getConnection().prepareStatement(query);
			ps.setInt(1, Integer.parseInt(value));
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String courseCode = rs.getString(1);
				float grade = rs.getFloat(2);
				String termId = rs.getString(3);
				list.add(new Grade(grade, courseCode, Integer.parseInt(value), termId,null));
			}
			result = this.connection.close();
			if(result != null)
				throw new Exception(result);
			
			return list;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
