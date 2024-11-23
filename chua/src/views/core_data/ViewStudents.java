package views.core_data;

import java.util.ArrayList;
import models.Grade;
import models.Student;
import views.ResultMessages;

/**
 * Class for viewing student details
 */
public class ViewStudents {

	public static void viewStudents(ArrayList<Student> students) {
		if(students == null)
			System.out.println(ResultMessages.RETRIEVE_ERROR);
		else if(students.size() == 0) {
			System.out.println(ResultMessages.EMPTY_SET);
		} else {
		System.out.printf("%-10s | %-30s | %-30s | %-10s\n", "ID","Last Name", "First Name"," Degree Program");
		for(int i=0; i<students.size(); i++) {
			System.out.printf("%-10d |", students.get(i).getId());
			System.out.printf(" %-30s |", students.get(i).getLastName());
			System.out.printf(" %-30s |", students.get(i).getFirstName());
			System.out.printf(" %-10s", students.get(i).getDegreeProgram());
			System.out.println("");
			System.out.flush();

		}
		}
	}
	
}
