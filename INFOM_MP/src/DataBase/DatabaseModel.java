package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseModel {
	
	public DatabaseModel() {
		
	}
	
	
	public void handleTransaction(int choice) {
		switch (choice) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		}
	}
	
	public void insertDegree(Degree degree, Connection connection) {
        String query = "INSERT INTO degrees (id, name, type, college) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

        	statement.setString(1, degree.getDegreeID());
            statement.setString(2, degree.getName());
            statement.setString(3, degree.getTypeId());
            statement.setString(4, degree.getCollege());
            
            int degreeCreated = statement.executeUpdate();
            if (degreeCreated > 0) {
                System.out.println("A new degree was inserted successfully!");
            }
        } catch (SQLException e) {
            System.err.println("SQL exception occurred while inserting degree.");
            e.printStackTrace();
        }
    }
	
	public void updateDegree(String degreeID, Degree updatedDegree, Connection connection) {
		String query = "UPDATE degrees "
				+ "SET id = ?, name = ?, type = ?, college = ? "
				+ "WHERE id LIKE ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, updatedDegree.getDegreeID());
			statement.setString(2, updatedDegree.getName());
			statement.setString(3, updatedDegree.getTypeId());
			statement.setString(4, updatedDegree.getCollege());
			statement.setString(5, degreeID);
			
			int degreeUpdated = statement.executeUpdate();
            if (degreeUpdated > 0) {
                System.out.println("A new degree was inserted successfully!");
            }
		} catch (SQLException e) {
            System.err.println("SQL exception occurred while inserting degree.");
            e.printStackTrace();
        }
	}
	
	public Degree viewDegree(String degreeID, Connection connection) {
		Degree viewedDegree = new Degree();		
		String query = "SELECT * "
				+ "FROM degrees "
				+ "WHERE id LIKE ?";
		
		try (PreparedStatement statement = connection.prepareStatement(query);) {
			statement.setString(1, degreeID);
			
			ResultSet degree = statement.executeQuery();
			
			if (degree.next()) {
	            viewedDegree.setDegreeID(degree.getString("id"));
	            viewedDegree.setName(degree.getString("name"));
	            viewedDegree.setTypeId(degree.getString("type"));
	            viewedDegree.setCollege(degree.getString("college"));
	        }	
		}	catch (SQLException e) {
            System.err.println("SQL exception occurred while inserting degree.");
            e.printStackTrace();
        }
		return viewedDegree;
	}
	
	public void deleteDegree(String degreeID, Connection connection) {
		String query = "DELETE FROM degrees WHERE id LIKE ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, degreeID);
			int degreeDeleted = statement.executeUpdate();
            if (degreeDeleted > 0) {
                System.out.println("The degree has been deleted successfully!");
            }
		} catch (SQLException e) {
            System.err.println("SQL exception occurred while inserting degree.");
            e.printStackTrace();
        }
	}
	
	public List<Degree> filterDegree(String search, String field, Connection connection) {
	    List<Degree> listOfDegrees = new ArrayList<>();
	    
	    String query = "SELECT * FROM degrees WHERE " + field + " LIKE ?";
	    try (PreparedStatement statement = connection.prepareStatement(query)) {
	        statement.setString(1, "%" + search + "%");
	        
	        ResultSet degrees = statement.executeQuery();
	        
	        while (degrees.next()) {
	            Degree viewedDegree = new Degree();
	            viewedDegree.setDegreeID(degrees.getString("id"));
	            viewedDegree.setName(degrees.getString("name"));
	            viewedDegree.setTypeId(degrees.getString("type"));
	            viewedDegree.setCollege(degrees.getString("college"));
	            
	            listOfDegrees.add(viewedDegree);
	        }
	    } catch (SQLException e) {
	        System.err.println("SQL exception occurred while retrieving degrees.");
	        e.printStackTrace();
	    }
	    return listOfDegrees;
	}
	
	public List<String> getDegreeTypes(Connection connection) {
		List<String> degreeTypes = new ArrayList<>();
		
		String query = "SELECT * FROM ref_degree_type";
		
		try(PreparedStatement statement = connection.prepareStatement(query);
		ResultSet degreeTypeList = statement.executeQuery();) {
			while (degreeTypeList.next()) {
			    degreeTypes.add(degreeTypeList.getString("type"));
			}
		} catch (SQLException e) {
			System.err.println("SQL exception occurred while retrieving degree types.");
            e.printStackTrace();
		}
		return degreeTypes;
	}
	
	public List<String> getDegreeID(Connection connection) {
		List<String> degree = new ArrayList<>();
		
		String query = "SELECT * FROM degrees";
		
		try(PreparedStatement statement = connection.prepareStatement(query);
		ResultSet degrees = statement.executeQuery();) {
			while (degrees.next()) {
				degree.add(degrees.getString("id"));
			}
		} catch (SQLException e) {
			System.err.println("SQL exception occurred while retrieving degree types.");
            e.printStackTrace();
		}
		return degree;
	}
	
	public List<Student> getStudents(String degreeID, Connection connection) {
	    List<Student> students = new ArrayList<>();
	    
	    String query = "SELECT s.* "
	                 + "FROM students s JOIN degrees d "
	                 + "ON s.degreeProgram = d.id "
	                 + "WHERE d.id LIKE \"" + degreeID + "\"";
	    
	    try (PreparedStatement statement = connection.prepareStatement(query)) {
	        
	        try (ResultSet studentList = statement.executeQuery()) {
	            while (studentList.next()) {
	                Student student = new Student();
	                student.setId(studentList.getInt("id"));
	                student.setFirstName(studentList.getString("firstName"));
	                student.setLastName(studentList.getString("lastName"));
	                student.setDegreeProgram(studentList.getString("degreeProgram"));
	                
	                students.add(student);
	            }
	        }
	    } catch (SQLException e) {
	        System.err.println("SQL exception occurred while retrieving students.");
	        e.printStackTrace();
	    }
	    return students;
	} 
	
	public Student getStudent(int studentID, Connection connection) {
		Student student = new Student();
		
		String query = "SELECT s.* "
                + "FROM students s "
				+ "WHERE s.id = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, studentID);
			
			ResultSet studentRecord = statement.executeQuery();
			
			if (studentRecord.next()) {
	            student.setId(studentRecord.getInt("id"));
	            student.setFirstName(studentRecord.getString("firstName"));
	            student.setLastName(studentRecord.getString("lastName"));
	            student.setDegreeProgram(studentRecord.getString("degreeProgram"));
	        }
		} catch (SQLException e) {
	        System.err.println("SQL exception occurred while retrieving students.");
	        e.printStackTrace();
	    }
		return student;
	}
	
	public List<TranscriptRecord> getTranscriptRecords (int studentID, Connection connection) {
		List<TranscriptRecord> records = new ArrayList<>();
		
		String query = "SELECT t.id, c.code, c.name, g.grade, c.units "
					 + "FROM students s JOIN grades g ON s.id = g.studentId "
					 + "JOIN courses c ON g.courseCode = c.code "
					 + "JOIN terms t ON g.termId = t.id "
					 + "WHERE s.id = ? "
					 + "ORDER BY t.id";	
		
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, studentID);
			
			ResultSet transcriptRecords = statement.executeQuery();
			
			while (transcriptRecords.next()) {
				TranscriptRecord record = new TranscriptRecord();
				record.setTermID(transcriptRecords.getString("t.id"));
				record.setCourseCode(transcriptRecords.getString("c.code"));
				record.setCourseName(transcriptRecords.getString("c.name"));
				record.setGrade(transcriptRecords.getFloat("g.grade"));
				record.setUnits(transcriptRecords.getFloat("c.units"));
				
				records.add(record);
			}
		} catch (SQLException e) {
	        System.err.println("SQL exception occurred while retrieving students.");
	        e.printStackTrace();
		}
		
		return records;
	}
	
	public float getCGPA (List<TranscriptRecord> records) {
		float CGPA;
		float totalGrade = 0;
		float totalUnits = 0;
			for (TranscriptRecord record : records) {
				totalUnits += record.getUnits();
				totalGrade += (record.getGrade() * record.getUnits());
			}
			CGPA = totalGrade/totalUnits;
		return CGPA;
	}
	
	public Grade getGrade(int studentID, String courseCode, String termID, Connection connection) {
		Grade grade = new Grade();
		
		String query = "SELECT grade, sectionCode "
					 + "FROM grades "
					 + "WHERE studentID = ? "
					 + "AND courseCode LIKE ? "
					 + "AND termId LIKE ?";
		
		try (PreparedStatement statement = connection.prepareStatement(query)) {
	        statement.setInt(1, studentID);
	        statement.setString(2, courseCode);
	        statement.setString(3, termID);
	        
	        ResultSet gradeRecord = statement.executeQuery();
	        	
	        if(gradeRecord.next()) {
	            grade.setStudentID(studentID);
	            grade.setCourseCode(courseCode);
	            grade.setSectionCode(gradeRecord.getString("sectionCode"));
	            grade.setTermId(termID);
	            grade.setGrade(gradeRecord.getFloat("grade"));
	            
	       	}
	        return grade;
	    } catch (SQLException e) {
	        System.err.println("SQL exception occurred while retrieving grades.");
	        e.printStackTrace();
	        
	        return null;
	    }
	}	
	
	public void updateGrade(Grade grade, Connection connection) {
		String query = "UPDATE grades "
				+ "SET grade = ? "
				+ "WHERE studentId = ? "
				+ "AND courseCode LIKE ? "
				+ "AND termId LIKE ?";
		
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setFloat(1, grade.getGrade());
			statement.setInt(2, grade.getStudentID());
			statement.setString(3, grade.getCourseCode());
			statement.setString(4, grade.getTermId());
			
			int gradeUpdated = statement.executeUpdate();
            if (gradeUpdated > 0) {
                System.out.println("Grade updated successfully!");
            }
		} catch (SQLException e) {
            System.err.println("SQL exception occurred while updating grade.");
            e.printStackTrace();
        }
	}
	
	public void insertGradeHistory(Grade grade, Connection connection) {
		String query = "INSERT INTO grade_history (grade, studentId, sectionCode, courseCode, termId) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

        	statement.setFloat(1, grade.getGrade());
            statement.setInt(2, grade.getStudentID());
            statement.setString(3, grade.getSectionCode());
            statement.setString(4, grade.getCourseCode());
            statement.setString(5, grade.getTermId());
            
            int gradeCreated = statement.executeUpdate();
            if (gradeCreated > 0) {
                System.out.println("A new grade was inserted successfully!");
            }
        } catch (SQLException e) {
            System.err.println("SQL exception occurred while inserting a grade.");
            e.printStackTrace();
        }
	}
}
