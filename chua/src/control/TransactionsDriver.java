package control;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import db.Conn;
import db.queries.TransactionQueries;
import models.Grade;
import models.Report;
import views.ResultMessages;
import views.ViewGrades;
import views.main_menu.MainMenu;
public class TransactionsDriver {
	TransactionQueries tq = null;
	
	public TransactionsDriver(Conn conn) {
		this.tq = new TransactionQueries(conn);
	}
	
	public void menu(Scanner scan) {
		MainMenu.transactionsMenu();
		int choice = -1;
		while(!(choice >= 0 && choice <= 2)) {
			choice = Integer.parseInt(scan.nextLine());
		}
		
		switch(choice) {
		case 2: {
			String result = submitFinalGradeInputs(scan);
			System.out.println(result);
			break;
		}
		case 1: {
			ViewGrades.gradesWarning();
			String result = insertFromFile(scan);
			System.out.println(result);
			break;
		}
		case 0: {
			break;
		}
		}
	}
	
	private String submitFinalGradeInputs(Scanner scan) {
		ArrayList<Grade> grades = new ArrayList<Grade>();
		try {
			System.out.println("How many grades are you submitting?");
			int lines = Integer.parseInt(scan.nextLine());
			for(int i=0; i<lines; i++) {
				System.out.printf("Record %d:\n", i);
				System.out.println("Student ID:");
				int studentId = Integer.parseInt(scan.nextLine());
				System.out.println("Course code:");
				String courseCode = scan.nextLine();
				System.out.println("Grade:");
				float grade = Float.parseFloat(scan.nextLine());
				System.out.println("Section:");
				String section = scan.nextLine();
				System.out.println("Term:");
				int term = Integer.parseInt(scan.nextLine());
				System.out.println("School Year (Ex: 124):");
				int year = Integer.parseInt(scan.nextLine());
				
				Grade gradeObj = new Grade(grade,courseCode,studentId, null, section);
				gradeObj.processTermId(year, term);
				grades.add(gradeObj);
			}
			String result = tq.insertGrade(grades);
			System.out.println(result);
			if(result != null)
				throw new Exception(result);
			return ResultMessages.INSERT_SUCCESS;
		} catch(Exception e) {
			return ResultMessages.LOADING_ERROR;
		}
		
	}
	
	private String insertFromFile(Scanner scan) {
			ArrayList<Grade> grades = new ArrayList<Grade>();
			System.out.println("Directory of file:");
			String name = scan.nextLine();
			try {
				String content = Files.readString(Path.of(name));
				System.out.println(content);
				String[] lines = content.split("\n");

			for(int i=0; i<lines.length; i++) {
				String[] parts = lines[i].split(" ");
				int id = Integer.parseInt(parts[0]);
				String courseCode = parts[1];
				float grade = Float.parseFloat(parts[2]);
				String section = parts[3];
				String termId = parts[4];
				
				grades.add(new Grade(grade,courseCode,id,termId,section));
			}
			String result = tq.insertGrade(grades);
			if(result != null)
				throw new Exception(result);
			return ResultMessages.INSERT_SUCCESS;
		} catch(Exception e) {
			return ResultMessages.LOADING_ERROR;
		}
	}
}
