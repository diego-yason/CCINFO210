package DataBase;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DatabaseView {
	private Scanner scanner = new Scanner(System.in);
	
	public DatabaseView () {
	}
	
	public int printMenu() {
		int input;
		
		while (true) {
			try {
				System.out.println("\nWelcome to the Database Manager!\n\n");
				System.out.println("[1] Manage Data");
				System.out.println("[2] Transactions");
				System.out.println("[3] Generate Report");
				System.out.println("[4] Exit");
				System.out.print("\nEnter Input: ");
				
				input = scanner.nextInt();
				scanner.nextLine();
				break;
			} catch(InputMismatchException e) {
				System.err.println("Invalid Input!");
				scanner.next();
			}
		}
		return input;
	}
	
	public int printManageData() {
		int input;
		while (true) {
			try {
				System.out.println("\nData Manager!\n\n");
				System.out.println("[1] Create Degree");
				System.out.println("[2] View Degree");
				System.out.println("[3] Update Degree");
				System.out.println("[4] Delete Degree");
				System.out.println("[5] Back");
				System.out.print("\nEnter Input: ");
				
				input = scanner.nextInt();
				scanner.nextLine();
				break;
			} catch(InputMismatchException e) {
				System.err.println("Invalid Input!");
				scanner.next();
			}
		}
		return input;
	}
	
	public int printListDegree() {
		int input;
		
		while (true) {
			try {
				System.out.println("\nWhat attribute would you like to search for: \n");
				System.out.println("[1] ID\n"
								+ "[2] Name\n"
								+ "[3] Type\n"
								+ "[4] College\n");
				System.out.print("Enter Input: ");
				
				input = scanner.nextInt();
				break;
			} catch(InputMismatchException e) {
				System.err.println("Invalid Input!");
				scanner.next();
			}
		}
		return input;
	}
	
	public int printViewMenu() {
		int input;
		
		while(true) {
			try {
				System.out.println("What would you like to view: \n");
				System.out.println("[1] Single Degree"
								+ "\n[2] Filtered Degree Search"
								+ "\n[3] View Degree and List of Students"
								+ "\n[4] Back");
				System.out.print("\nEnter Input: ");
				input = scanner.nextInt();
				scanner.nextLine();
				break;
			} catch(InputMismatchException e) {
				System.err.println("Invalid Input!");
				scanner.next();
			}
		}
		return input;
	}
	
    public String getInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        return input;
    }
    
    public void displayList(List<String> list, String print) {
        System.out.println("Available " + print + ": " );
        for (String type : list) {
            System.out.println("- " + type);
        }
    }
    
    public void displayDegree(Degree degree) {
    	System.out.println("\nSelected Degree: \n");
    	System.out.println(degree.getDegreeID() + " " +
    					   degree.getName() + " " +
    					   degree.getTypeId() + " " +
    					   degree.getCollege());
    }
    
    public void displayDegrees(List<Degree> degrees) {
    	System.out.println("Related Degrees: \n");
    	for (Degree degree : degrees) {
    	System.out.println(degree.getDegreeID() + " " +
    					   degree.getName() + " " +
    					   degree.getTypeId() + " " +
    					   degree.getCollege());
    	}
    }
    
    public void displayStudents(List<Student> students) {
    	System.out.println("\nStudents: \n");
    	for (Student student : students) {
    		System.out.println(student.getId() + " " +
    						   student.getFirstName() + " " +
    						   student.getLastName() + " " +
    						   student.getDegreeProgram() + " ");
    	}
    }
    
    public void displayTranscriptRecord(List<TranscriptRecord> records, Student student, Degree degree, float CGPA) {
    	System.out.println("\n\nStudent ID: " + student.getId() + 
    					   "\nStudent Name: " + student.getLastName() + ", " + student.getFirstName() +
    					   "\nStudent Degree Program: " + degree.getTypeId() + "-" + degree.getName() +
    					   "\nStudent College: " + degree.getCollege() +
    					   "\nStudent CGPA: " + CGPA);
    	System.out.println("\n----------------------------------------------------------------------\n\n");
    	System.out.printf("%-7s| %-15s| %-50s| %-7s| %-7s\n", "Term","Course Code", "Course Name", "Grade", "Units");
    	for(int i = 0; i < 84; i++) {
    		System.out.print("-");
    	}
    	for (TranscriptRecord record : records) {
    		System.out.printf("\n%-7s| %-15s| %-50s| %-7s| %-7s",
    						  record.getTermID(),
    						  record.getCourseCode(),
    						  record.getCourseName(),
    						  record.getGrade(),
    						  record.getUnits());
    	}
    }
}
