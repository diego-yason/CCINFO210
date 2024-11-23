package control;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import db.Conn;
import db.queries.ReportQueries;
import models.Report;
import views.ResultMessages;
import views.ViewReports;
import views.main_menu.MainMenu;

public class ReportsDriver {
	ReportQueries rq = null;
	
	public ReportsDriver(Conn connection) {
		rq = new ReportQueries(connection);
	}
	
	public void menu(Scanner scan) {
		int index = -1;
		while(!(index >= 0 && index <= 1)) {
			MainMenu.reportsMenu();
			index = Integer.parseInt(scan.nextLine());
			if(!(index >= 0 && index <= 1)) {
				System.out.println("Please try again");
			}
		}
		
		switch(index) {
		case 1: {
			String result = getReportsInputs(scan);
			System.out.println(result);
			break;
		}
		case 0: {
			break;
		}
		}
	}
	
	private String getReportsInputs(Scanner scan) {
		try {
			ArrayList<Report> reports = null;
			System.out.println("Enter a year (Ex: 124):");
			int year = Integer.parseInt(scan.nextLine());
			System.out.println("Enter a term:");
			int term = Integer.parseInt(scan.nextLine());
			System.out.println("Enter a course code:");
			String courseCode = scan.nextLine();
			reports = rq.getCourseGradeReport(term, year, courseCode);
			if(reports == null) {
				return ResultMessages.RETRIEVE_ERROR;
			}
			else {
				int indexTwo = -1;
				while(!(indexTwo >= 0 && indexTwo <= 2)) {
					System.out.println("Would you like sort the records?");
					System.out.println("1 - By Complete Name");
					System.out.println("2 - By Grades");
					System.out.println("0 - By Student ID (Default)");
					indexTwo = Integer.parseInt(scan.nextLine());
					if(!(indexTwo >= 0 && indexTwo <= 2)) {
						System.out.println("Please try again");
					}
					
				}
				
				switch(indexTwo) {
					case 1: {
						rq.sortByStudentName(reports);
						break;
					}
					case 2: {
						rq.sortByGrade(reports);
						break;
					}
					case 0: {
						break;
					}
				}
				
				int index = -1;
				while(!(index >= 1 && index <= 2)) {
					System.out.println("Would you like to print the output to the terminal");
					System.out.println("or write to a file?");
					System.out.println("1 - Write to File");
					System.out.println("2 - Display Report on Terminal");
					index = Integer.parseInt(scan.nextLine());
					if(!(index >= 1 && index <= 2)) {
						System.out.println("Please try again");
					}
				}	
				switch(index) {
					case 1: {
						return writeToFile(scan, reports);
					}
					case 2: {
						ViewReports.displayReports(reports);
						break;
					}
					}
				return ResultMessages.RETRIEVE_SUCCESS;
			}
		} catch(Exception e) {
			return ResultMessages.RETRIEVE_ERROR;
		}
		
		
	}
	
	private String writeToFile(Scanner scan, ArrayList<Report> reports) {
		try {
			System.out.println("Please enter the output file path:");
			String outputPath = scan.nextLine();
			FileWriter fw = new FileWriter(outputPath);
			StringBuilder sb = new StringBuilder();
			fw.write(String.format("%-10s | %-30s | %-30s | %-10s\n", "ID","Last Name","First Name","Grade"));
			for(int i=0; i<reports.size(); i++) {
				sb.append(String.format("%-10d | %-30s | %-30s | %-10.1f\n",
						reports.get(i).getId(),
						reports.get(i).getLastName(),
						reports.get(i).getFirstName(),
						reports.get(i).getGrade()));
				
				fw.write(sb.toString());
				sb.setLength(0);
			}
			fw.close();
			return ResultMessages.WRITE_SUCCESS;
			
			
		} catch(Exception e) {
			return ResultMessages.WRITE_ERROR;
		}
	}
}
