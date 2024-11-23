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
			System.out.printf("%-10s | %-10s\n", "Grade", "Count");
		for(int i=0; i<reports.size(); i++) {
			Report currRow = reports.get(i);
			System.out.printf("%-10.1f | %-10d\n", currRow.getGrade(), currRow.getCount());
		}
		}
	}
}
