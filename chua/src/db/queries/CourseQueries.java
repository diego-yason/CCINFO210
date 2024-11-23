package db.queries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import db.Conn;
import models.Course;
import models.FilterConditions;
import models.Section;
import views.ResultMessages;

public class CourseQueries {
	private Conn connection = null;

	
	public CourseQueries(Conn conn) {
		this.connection = conn;
	}
	
	/**
	 * Gets the courses given a condition
	 * @param extraConditions SQL condition
	 * @param condition ENUM condition
	 * @param value Value in SQL condition
	 * @return List of courses, otherwise null
	 */
	public ArrayList<Course> getCourses(String extraConditions, FilterConditions condition, String value) {
		try {
			ArrayList<Course> courses = new ArrayList<>();
			String result = this.connection.connect();
			if(result != null) {
				throw new Exception(result);
			}

			String query = new String("SELECT	code, name, units, academic, department "
					+ "FROM	courses "+extraConditions);
			
			PreparedStatement ps = this.connection.getConnection().prepareStatement(query);
	
			switch(condition) {
				case FilterConditions.COURSE_ACADEMIC: {
					ps.setString(1, value);
					break;
				}
				case FilterConditions.COURSE_CODE: {
					ps.setString(1, value);
					break;
				}
				case FilterConditions.COURSE_UNITS: {
					ps.setFloat(1, Float.parseFloat(value));
					break;
				}
				case FilterConditions.COURSE_DEPARTMENT: {
					ps.setString(1, value);
					break;
				}
			default: {
				break;
			}
			}
			
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String code = rs.getString(1);
				String name = rs.getString(2);
				float units = rs.getFloat(3);
				String academic = rs.getString(4);
				String department = rs.getString(5);
				courses.add(new Course(code,name,units,academic,department));

			}
			result = this.connection.close();
			if(result != null) {
				throw new Exception(result);
			}
			return courses;
		} catch(SQLException e) {
			this.connection.close();
			return null;
		} catch(Exception e) {
			this.connection.close();
			return null;
		}

	}

	/**
	 * Function to insert a new course
	 * @param code course code
	 * @param name course name
	 * @param units number of units
	 * @param academic if the course is academic, true otherwise false
	 * @param department department of the course
	 * @return result message otherwise null if succeeded
	 */
	public String insertCourse(String code, String name, float units, String academic, String department) {
		String query = "INSERT INTO	"
				+ "courses(code,name,units,academic,department) "
				+ "values(?,?,?,?,?)";
		try {
			String result = this.connection.connect();
			if(result != null) {
				throw new Exception(result);
			}
			PreparedStatement ps = this.connection.getConnection().prepareStatement(query);
			ps.setString(1, code);
			ps.setString(2, name);
			ps.setFloat(3, units);
			ps.setString(4, academic);
			ps.setString(5, department);
			ps.executeUpdate();
			result = this.connection.close();
			if(result != null) {
				throw new Exception(result);
			}
			return null;
		}  catch(SQLException e) {
			this.connection.close();
			return ResultMessages.INSERT_ERROR;
		} catch(Exception e) {
			this.connection.close();
			return e.getMessage();
		}
	}

	/**
	 * Function to update the course
	 * @param currentCode Current code
	 * @param code New code
	 * @param name New name
	 * @param units New units
	 * @param academic New academic condition
	 * @param department New department
	 * @return result message, otherwise null if succeeded
	 */
	public String updateCourse(String currentCode, String code, String name, float units, String academic, String department) {
			String query = "UPDATE 	courses "
					+ "SET	code=?,name=?,units=?,academic=?,department=? "
					+ "WHERE code=?";
			try {
				String result = this.connection.connect();
				if(result != null) {
					throw new Exception(result);
				}
				PreparedStatement ps = this.connection.getConnection().prepareStatement(query);
				ps.setString(1, code);
				ps.setString(2, name);
				ps.setFloat(3, units);
				ps.setString(4, academic);
				ps.setString(5, department);
				ps.setString(6, currentCode);
				ps.executeUpdate();
				result = this.connection.close();
				if(result != null) {
					throw new Exception(result);
				}
				return null;

			}	catch(SQLException e) {
					this.connection.close();
					return ResultMessages.UPDATE_ERROR;
			}   catch(Exception e) {
					this.connection.close();
					return e.getMessage();
			}
	}

	/**
	 * Function to delete a course given the code
	 * @param code Course code
	 * @return result message otherwise null if succeeded
	 */
	public String deleteCourse(String code) {
		String query = "DELETE FROM courses WHERE code=?";
		try {
			this.connection.connect();
			PreparedStatement ps = this.connection.getConnection().prepareStatement(query);
			ps.setString(1, code);
			ps.executeUpdate();
			return null;
		} catch(SQLException e) {
			this.connection.close();
			return ResultMessages.DELETE_ERROR;
		} catch(Exception e) {
			this.connection.close();
			return e.getMessage();
		}
	}
	
	/**
	 * Gets list of sections under a course
	 * @param course Course code
	 * @return list of sections, otherwise null
	 */
	public ArrayList<Section> getCourseSections(String course) {
		try {
			ArrayList<Section> sectionList = new ArrayList<>();
			String result = this.connection.connect();
			if(result != null) {
				throw new Exception(result);
			}

			String query = new String("SELECT s.sectionCode, s.termId, s.status "
					+ "FROM	sections s "
					+ "WHERE	s.courseCode = ?");
			
			PreparedStatement ps = this.connection.getConnection().prepareStatement(query);
			ps.setString(1, course);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String section = rs.getString(1);
				String termId = rs.getString(2);
				String status = rs.getString(3);
				sectionList.add(new Section(section, termId, status));
			}
			result = this.connection.close();
			if(result != null) {
				throw new Exception(result);
			}
			return sectionList;
		} catch(SQLException e) {
			this.connection.close();
			return null;
		} catch(Exception e) {
			this.connection.close();
			return null;
		}
	}
}
