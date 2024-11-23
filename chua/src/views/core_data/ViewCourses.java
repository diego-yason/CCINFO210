package views.core_data;

import java.util.ArrayList;

import models.Course;
import models.Section;
import views.ResultMessages;
public class ViewCourses {

		public static void displayCourses(ArrayList<Course> courses) {
			 			
			if(courses == null || courses.size() == 0)
				System.out.println(ResultMessages.EMPTY_SET);
			else {
			System.out.printf("Index | %-10s | %-50s | %-5s | %-2s | %-50s\n" ,"Code" ,"Name", "Units","isAcademic","Department\n");
			for(int i=0; i < courses.size(); i++) {
				System.out.printf("%-6d |", i);
				System.out.printf(" %-10s |", courses.get(i).getCode());
				System.out.printf(" %-50s |",courses.get(i).getName());
				System.out.printf(" %-5.1f |",courses.get(i).getUnits());
				System.out.printf(" %-2s |",courses.get(i).getAcademic());
				System.out.printf(" %-50s",courses.get(i).getDepartment());
				System.out.println("");
				System.out.flush();

			}
		}
		}
		
		public static void displaySections(ArrayList<Section> sections) {
 			
			if(sections == null || sections.size() == 0)
				System.out.println(ResultMessages.EMPTY_SET);
			else {
			System.out.printf("%-10s | %-5s | %-5s ", "Section", "Status", "Term ID\n");
			for(int i=0; i < sections.size(); i++) {
				System.out.printf("%-10s |", sections.get(i).getName());
				System.out.printf(" %-5s |",sections.get(i).getStatus());
				System.out.printf(" %-5s",sections.get(i).getTermId());

				System.out.println("");
				System.out.flush();

			}
		}
		}
		public static void updateMenu() {
				System.out.println("Choose one of the following to update:");
				System.out.println("5 - Course Code");
				System.out.println("4 - Course Name");
				System.out.println("3 - Units");
				System.out.println("2 - isAcademic");
				System.out.println("1 - Department");
				System.out.println("6 - Confirm");
				System.out.println("0 - Exit");
				System.out.println("");
				System.out.println("What would you like to update?");
				System.out.flush();

		}
			
		public static void insertMenu() {
			System.out.println("Please insert the record details:");
			System.out.flush();

		}
			

			
		public static void readMenu() {
				System.out.println("Select a Course Code by Index:");
				System.out.flush();

		}
		
}
