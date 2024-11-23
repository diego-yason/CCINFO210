package control;
import db.queries.CourseQueries;
import db.queries.StudentQueries;
import db.Conn;
import java.util.Scanner;
import java.util.ArrayList;
import models.Course;
import models.FilterConditions;
import models.Grade;
import models.Section;
import models.Student;
import views.core_data.ViewCourses;
import views.core_data.ViewStudents;
import views.main_menu.MainMenu;
import views.ResultMessages;
import views.ViewGrades;
import views.conditions.ViewConditions;
public class CoreDataDriver {
	private CourseQueries cq = null;
	private StudentQueries sq = null;
	
	private ArrayList<Course> courses = null;
	
	public CoreDataDriver(Conn conn) {
		this.cq = new CourseQueries(conn);
		this.sq = new StudentQueries(conn);
	}
	
	public void menu(Scanner scan) {
		int choice = -1;
		try {
		MainMenu.coreDataMenu();
		while(!(choice >= 0 && choice <= 7)) {
			choice = Integer.parseInt(scan.nextLine());
			if(!(choice >= 0 && choice <= 7))
				System.out.println("Please try again");
		}
		System.out.flush();
		switch(choice) {
		case 1: {
			//read courses
			String result = getFilteredCoursesInputs(scan);
			System.out.println(result);
			break;
		}
		case 2: {
			//delete a course
			String result = deleteCourseDataInputs(scan);
			System.out.println(result);
			break;
		}
		case 3: {
			//insert a new course
			String result = insertCourseDataInputs(scan);
			System.out.println(result);

			break;
		}
		case 4: {
			//update a course
			String result = updateCourseDataInputs(scan);
			System.out.println(result);
			break;
		}
		case 5: {
			//read students with filters data
			String result = getFilteredStudentsInputs(scan);
			System.out.println(result);
			break;
		}
		case 6: {
			//read students grades
			String result = getStudentGradeInputs(scan);
			System.out.println(result);
			break;
		}
		case 7: {
			//read course sections
			String result = getCourseSectionInputs(scan);
			System.out.println(result);
			break;
		}
		}
		
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private String insertCourseDataInputs(Scanner scan) {
		try { 
		System.out.println("Input details here:");
		System.out.println("Course Code:");
		System.out.flush();
		String code = scan.nextLine();
		System.out.println("Course Name:");
		System.out.flush();
		String name = scan.nextLine();
		System.out.println("Units:");
		System.out.flush();
		float units = Float.parseFloat(scan.nextLine());
		System.out.println("Is Academic (True/False):");
		System.out.flush();
		boolean isAcademic = Boolean.parseBoolean(scan.nextLine());
		System.out.println("Department:");
		System.out.flush();
		String department = scan.nextLine();
		System.out.flush();
		if(UserInputs.confirmAction(scan)) {
			String result = cq.insertCourse(code, name, units, isAcademic ? "T":"F", department);
			
			if(result != null)
				throw new Exception(result);
			
			return ResultMessages.INSERT_SUCCESS;
		} else return ResultMessages.INSERT_ERROR;
		
		} catch(Exception e) {
			return ResultMessages.INSERT_ERROR;
		}		
	}
		
	/**
	 * Updates the course data given the user input
	 * @param scan Scanner for user input
	 * @return Result message
	 */
	private String updateCourseDataInputs(Scanner scan) {
		Course newCourse = null;
		String code,name,department;
		String academic;
		float units;
		Course currCourse = new Course("","",0,"","");
		courses = cq.getCourses("", FilterConditions.NA, "");
		//select a course
		try {
			code = selectCourse(scan);
			if(courses == null || courses.size() == 0)
				return "No courses are available";
		for(int i=0; i<courses.size(); i++) {
			if(courses.get(i).getCode().equals(code)) {
				currCourse = courses.get(i);
				break;
			}
		}
		
		
		if(currCourse == null)
			return "An error occured in retrieving a course";
		
		units = currCourse.getUnits();
		code = currCourse.getCode();
		name = currCourse.getName();
		department = currCourse.getDepartment();
		academic = currCourse.getAcademic();
		
		while(newCourse == null) {
		try {
			System.out.println("Details:");
			System.out.printf("Code: %s, Name: %s, Units: %.1f, Academic: %s, Department: %s\n", code,name,units,academic,department);
			ViewCourses.updateMenu();
			int choice = Integer.parseInt(scan.nextLine());
		
		switch(choice) {
		
		case 5: { 
			System.out.println("Course Code:");
			System.out.flush();
			code = scan.nextLine();
			break;
		}
		case 4: {
			System.out.println("Course Name:");
			System.out.flush();
			 name = scan.nextLine();
			break;
		}
		
		case 3: {
			System.out.println("Units:");
			System.out.flush();
			units = Float.parseFloat(scan.nextLine());
			break;
		}
		
		case 2: {
			System.out.println("Is Academic (True/False):");
			System.out.flush();
			academic = Boolean.parseBoolean(scan.nextLine()) ? "T" : "F";
			break;
		}
		
		case 1: {
			System.out.println("Department:");
			System.out.flush();
			department = scan.nextLine();
			break;
		}
		
		case 6: {
			if(UserInputs.confirmAction(scan)) {
				newCourse = new Course(code, name, units, academic, department);
				String result = cq.updateCourse(currCourse.getCode(), code, name, units, academic, department);
				if(result != null)
					throw new Exception(result);
				
				return ResultMessages.UPDATE_SUCCESS;
				
			}
		}
		case 0: {
			if(UserInputs.confirmAction(scan))
				return ResultMessages.UPDATE_ERROR;
		}
		}

		} catch(Exception e) {
			System.out.println("Please try again");
		}
	}
		} catch(Exception e) {
			return ResultMessages.UPDATE_ERROR;
		}
		
		return ResultMessages.UPDATE_ERROR;
	}
	
	
	private String selectCourse(Scanner scan) {
		int index = -1;
		try {
			courses = cq.getCourses("", FilterConditions.NA, "");
			if(courses.size() == 0 || courses == null)
				return "";
			ViewCourses.displayCourses(courses);
			ViewCourses.readMenu();
			
			while(!(index <= courses.size() && index >= 0)) {
				index = Integer.parseInt(scan.nextLine());
			if(!(index < courses.size() && index >= 0))
				System.out.println("Invalid index, please try again");
			}
			String code = courses.get(index).getCode();
			return code;
		} catch(Exception e) {
			return ResultMessages.RETRIEVE_ERROR;
		}
	}
	
	/**
	 * Deletes the course given the input
	 * @param scan Scanner for input
	 * @return Result message
	 */
	private String deleteCourseDataInputs(Scanner scan) {
		try {
			courses = cq.getCourses("",FilterConditions.NA,"");
			if(courses == null)
				throw new Exception("An error occured in retrieving the courses");
				ViewCourses.displayCourses(courses);
			System.out.println("Select a Course Code to delete");
			System.out.flush();
			String code = selectCourse(scan);
			if(code == null) {
				return ResultMessages.DELETE_ERROR;
			}
			
			if(UserInputs.confirmAction(scan)) {
				String result = cq.deleteCourse(code);
				
			if(result != null)
				throw new Exception(result);
			} 
			
			return ResultMessages.DELETE_SUCCESS;
			
		} catch(Exception e) {
			return ResultMessages.DELETE_ERROR;
		}
	}
	
	private String getFilteredStudentsInputs(Scanner scan) {
		int index = -1;
		ArrayList<Student> students = null;
		FilterConditions fc;
		String value, condition;
		while(!(index >=0 && index <= 2)) {
			ViewConditions.studentFilters();
			index = Integer.parseInt(scan.nextLine());
			
			if(!(index >= 0 && index <=2)) {
				System.out.println("Input is out of bounds, please try again");
			}
		}
		
		switch(index) {
		case 1: {
			fc = FilterConditions.STUDENT_ID;
			condition = "WHERE id = ? ";
			System.out.println("Insert value:");
			value = scan.nextLine();
			students = sq.getFilteredStudents(condition, fc, value);
			ViewStudents.viewStudents(students);
			return ResultMessages.RETRIEVE_SUCCESS;
		}
		case 2: {
			fc = FilterConditions.STUDENT_DEGREE;
			condition = "WHERE degreeProgram = ? ";
			System.out.println("Insert value:");
			value = scan.nextLine();
			students = sq.getFilteredStudents(condition, fc, value);
			ViewStudents.viewStudents(students);
			return ResultMessages.RETRIEVE_SUCCESS;
		}
		case 0: {
			return "\n";
		}
		
		}
		return ResultMessages.RETRIEVE_ERROR;
	}
	private String getFilteredCoursesInputs(Scanner scan) {
		
		int index = -1;
		ArrayList<Course> courses = null;
		FilterConditions fc;
		String value, condition;
		while(!(index >= 0 && index <=4)) {
		ViewConditions.courseFilters();
		index = Integer.parseInt(scan.nextLine());
		
		if(!(index >= 0 && index <=4)) {
			System.out.println("Input is out of bounds, please try again");
		}
		}
		
		switch(index) {
		case 1: {
			fc = FilterConditions.COURSE_CODE;
			condition = "WHERE code = ?";
			System.out.println("Insert a course code:");
			value = scan.nextLine();
			courses = cq.getCourses(condition, fc, value);
			ViewCourses.displayCourses(courses);
			return ResultMessages.RETRIEVE_SUCCESS;
		}
		case 2: {
			fc = FilterConditions.COURSE_DEPARTMENT;
			condition = "WHERE department = ?";
			System.out.println("Insert a department:");
			value = scan.nextLine();
			courses = cq.getCourses(condition, fc, value);
			ViewCourses.displayCourses(courses);
			return ResultMessages.RETRIEVE_SUCCESS;
		}
		case 3: {
			fc = FilterConditions.COURSE_UNITS;
			condition = "WHERE units = ?";
			System.out.println("Insert units:");
			value = scan.nextLine();
			courses = cq.getCourses(condition, fc, value);
			ViewCourses.displayCourses(courses);
			return ResultMessages.RETRIEVE_SUCCESS;
		}
		case 4: {
			fc = FilterConditions.COURSE_ACADEMIC;
			condition = "WHERE academic = ?";
			System.out.println("Insert condition (True/False):");

			value = Boolean.parseBoolean(scan.nextLine()) ? "T" : "F";
			courses = cq.getCourses(condition, fc, value);
			ViewCourses.displayCourses(courses);
			return ResultMessages.RETRIEVE_SUCCESS;
		}
		case 0: {
			return "\n";
		}
		}
		
		return ResultMessages.RETRIEVE_ERROR;
		
	}
	
	private String getStudentGradeInputs(Scanner scan) {
		try {
			System.out.println("Input a student ID:");
			String id = scan.nextLine();
			
			ArrayList<Grade> grades = sq.getStudentGrades(id);
			ViewGrades.viewStudentGrades(grades);
			return ResultMessages.RETRIEVE_SUCCESS;
			
		} catch(Exception e) {
			return ResultMessages.RETRIEVE_ERROR;
		}
	}
	
	private String getCourseSectionInputs(Scanner scan) {
		try {
			ArrayList<Section> sectionList = null;
			System.out.println("Input a course code:");
			String code = scan.nextLine();
			
			sectionList = cq.getCourseSections(code);
			ViewCourses.displaySections(sectionList);
			return ResultMessages.RETRIEVE_SUCCESS;
			
		} catch(Exception e) {
			return ResultMessages.RETRIEVE_ERROR;
		}
	}
	
	 
}
