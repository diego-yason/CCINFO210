package views;

import java.util.ArrayList;

import models.Report;

public class ViewReports {
	public static void displayReports(ArrayList<Report> reports) {
		if(reports == null)
			System.out.println(ResultMessages.RETRIEVE_ERROR);
		else if(reports.size() == 0)
			System.out.println(ResultMessages.EMPTY_SET);
		else {
			System.out.printf("%-10s | %-30s | %-30s | %-10s\n","ID", "Last Name","First Name","Grade");
		for(int i=0; i<reports.size(); i++) {
			Report currRow = reports.get(i);
			System.out.printf("%-10d | %-30s | %-30s | %-10.1f\n", currRow.getId(), currRow.getLastName(), currRow.getFirstName(), currRow.getGrade());
		}
		}
	}
}
