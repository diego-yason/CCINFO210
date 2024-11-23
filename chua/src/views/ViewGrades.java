package views;

import java.util.ArrayList;

import models.Grade;

public class ViewGrades {
	public static void gradesWarning() {
		System.out.println("Warning! The following data in the text file should be in this format:");
		System.out.println("ID COURSE-CODE GRADE TERM");
	}
	
	public static void viewStudentGrades(ArrayList<Grade> grades) {
		if(grades == null)
			System.out.println(ResultMessages.RETRIEVE_ERROR);
		else if(grades.size() == 0)
			System.out.println(ResultMessages.EMPTY_SET);
		else {
			System.out.printf("%-10s | %-10s | %-10s\n", "Course Code", "Grade", "Term ID");
			for(int i=0; i<grades.size(); i++) {
				System.out.printf("%-10s |", grades.get(i).getCourseCode());
				System.out.printf(" %-10.1f |", grades.get(i).getGrade());
				System.out.printf(" %-10s", grades.get(i).getTermId());
				System.out.println("");
				System.out.flush();

			}
		}
	}
}
