package views.conditions;

import models.FilterConditions;

public class ViewConditions {
	public static void courseFilters() {
		System.out.println("Select a filter:");
		System.out.println("1 - Course Code");
		System.out.println("2 - Course Department");
		System.out.println("3 - Course Units");
		System.out.println("4 - Course isAcademic");
		System.out.println("0 - Go back");

	}
	
	public static void studentFilters() {
		System.out.println("Select a filter:");
		System.out.println("1 - ID");
		System.out.println("2 - Degree");
		System.out.println("0 - Go back");
	}
}
