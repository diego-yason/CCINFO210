package DataBase;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabaseController {
	private DatabaseView DBView = new DatabaseView();
	private DatabaseModel DBModel = new DatabaseModel();
	private Connection connection;
	private Scanner scanner = new Scanner(System.in);
	
	public DatabaseController(Connection connection) {
		this.connection = connection;
		printDatabaseMenu();
	}
	
	public void printDatabaseMenu () {
		int input = 0;
		while (input != 4) {
			input = DBView.printMenu();
			switch (input) {
			case 1:
				int manageInput = 0;
				while (manageInput != 5) {
					manageInput = DBView.printManageData();
					switch (manageInput) {
					case 1:
						createDegree();
						break;
					case 2:
						viewDegree();
						break;
					case 3:
						updateDegree();
						break;
					case 4:
						deleteDegree();
						break;
					case 5:
						break;
					default:
						System.err.println("Enter an input from the choices");
					}
				}
				break;
			case 2:
				transaction();
				break;
			case 3:
				report();
				break;
			case 4:
				break;
			default:
				System.err.println("Enter an input from the choices");
			}
		}
	}
	
	public void createDegree() {
		String degreeID = DBView.getInput("Enter a unique 10-character DegreeID: ");
        String name = DBView.getInput("Enter the Degree Name: ");
        List<String> degreeTypes = DBModel.getDegreeTypes(connection);
        List<String> colleges = DBModel.getColleges(connection);
        DBView.displayList(degreeTypes, "degree types");
        String typeId = DBView.getInput("Enter the Degree Type: ");
        DBView.displayList(colleges, "colleges");
        String college = DBView.getInput("Enter the College Name: ");
        Degree degree = new Degree(degreeID, name, typeId, college);
        DBModel.insertDegree(degree, connection);
	}
	
	public void viewDegree() {
		int input = 0;
		
		while (input != 4) {
			input = DBView.printViewMenu();
			switch (input) {
			case 1:
				singleDegreeView();
				break;
			case 2:
				searchDegreeView();
				break;
			case 3:
				relatedDegreeView();
				break;
			case 4:
				System.out.println("[4] Back");
				break;
			default:
				System.err.println("Enter an input from the choices");
			}
		}
	}
	
	
	public void singleDegreeView() {
		List<String> degreeIDs = DBModel.getDegreeID(connection);
		DBView.displayList(degreeIDs, "degree IDs");
		String degreeID = DBView.getInput("Enter the ID of the degree you want to view: ");
		DBView.displayDegree(DBModel.viewDegree(degreeID, connection));
		scanner.nextLine();
	}
	
	public void searchDegreeView() {
		String print = new String();
		String search = new String();
		int input = 0;
		
		while (input != 5) {
			input = DBView.printListDegree();
			List<Degree> degrees = new ArrayList<>();
			switch (input) {
			case 1:
				print = "id";
				break;
			case 2:
				print = "name";
				break;
			case 3:
				print = "type";
				break;
			case 4:
				print = "college";
				break;
			case 5:
				break;
			default:
				break;
			}
			if(input != 5) {
				System.out.println("What " + print +" would you like to search: ");
				search = scanner.nextLine();
				System.out.println(search);
				degrees = DBModel.filterDegree(search, print, connection);
				DBView.displayDegrees(degrees);
				scanner.nextLine();
			}
		}
		
	}
	
	public void relatedDegreeView() {
		List<String> degreeIDs = DBModel.getDegreeID(connection);
		List<Student> students = new ArrayList<>();
		DBView.displayList(degreeIDs, "degree IDs");
		String degreeID = DBView.getInput("Enter the ID of the degree you want to view: ");
		DBView.displayDegree(DBModel.viewDegree(degreeID, connection));
		students = DBModel.getStudents(degreeID, connection);
		DBView.displayStudents(students);
		scanner.nextLine();
	}
	
	
	public void updateDegree() {
		String degreeID = DBView.getInput("Enter the ID of the degree you would like to update: ");
		String updatedDegreeID = DBView.getInput("What is the degree's new ID: ");
		String updatedDegreeName = DBView.getInput("What is the degree's new name: ");
		String updatedDegreeType = DBView.getInput("What is the degree's new type: ");
		String updatedDegreeCollege = DBView.getInput("What is the degree's new college: ");
		
		Degree degree = new Degree(updatedDegreeID, updatedDegreeName, 
								   updatedDegreeType, updatedDegreeCollege);
		DBModel.updateDegree(degreeID, degree, connection);
	}
	
	public void deleteDegree() {
		String degreeID = DBView.getInput("Enter the ID of the degree you would like to delete: ");
		DBModel.deleteDegree(degreeID, connection);
		scanner.nextLine();
	}
	
	public void transaction() {
		Grade newGrade = new Grade();
		float inputtedGrade;
		
		String studentId = DBView.getInput("Enter the ID of the student you want to file a grade change for: ");
		String course = DBView.getInput("Enter the ID of the course you would like to change the grade of: ");
		String termId = DBView.getInput("Enter the ID of the term: ");
		
		try {
			Grade previousGrade = new Grade();
			previousGrade = DBModel.getGrade(Integer.parseInt(studentId), course, termId, connection);
			if (previousGrade != null) {
				try {
			 	    inputtedGrade = Float.parseFloat(DBView.getInput("Enter the new grade: "));
			 	    newGrade.setGrade(inputtedGrade);
			 	    newGrade.setStudentID(Integer.parseInt(studentId));
			 	    newGrade.setCourseCode(course);
			 	    newGrade.setTermId(termId);
			 	    newGrade.setSectionCode(previousGrade.getSectionCode());
			 	    
			 	    DBModel.updateGrade(newGrade, connection);
			 	    DBModel.insertGradeHistory(previousGrade, connection);
				} catch(NumberFormatException e) {
					System.out.println("Please enter a valid grade value");
				}
			}
			else {
				System.err.println("Student does not have a grade");
			}
		} catch(NumberFormatException e) {
			System.err.println("Enter a valid student ID");
		}
	}
	
	public void report() {
		List<TranscriptRecord> records = new ArrayList<>();
		Student student = new Student();
		Degree degree = new Degree();
		float CGPA;
		
		try {
		String studentID = DBView.getInput("Enter ID of the student you want to generate TOR for: ");
		records = DBModel.getTranscriptRecords(Integer.parseInt(studentID), connection);
		student = DBModel.getStudent(Integer.parseInt(studentID), connection);
		degree = DBModel.viewDegree(student.getDegreeProgram(), connection);
		CGPA = DBModel.getCGPA(records);
		DBView.displayTranscriptRecord(records, student, degree, CGPA);
		} catch (NumberFormatException e) {
			System.err.println("Enter a valid student ID");
		}
	}
}
