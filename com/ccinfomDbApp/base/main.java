package com.ccinfomDbApp.base;

import java.time.LocalDate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;

public class main {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Connection connection = null;

        try {
           
        	String url = "jdbc:mysql://localhost:3306/ccinfo210db"; 
        	String username = "root"; 
        	String password = "p@ssword!"; 

        	
            connection = DriverManager.getConnection(url, username, password);
            
            TermsDb termsDAO = new TermsDb(connection);
            ReportDb reportDAO = new ReportDb(connection);
            HolidaysDb holidaysDao = new HolidaysDb (connection);
            EquivRequestDb requestDao = new EquivRequestDb(connection);
            while (true) {
             
                System.out.println("Select:");
                System.out.println("[1] Data Core Management");
                System.out.println("[2] Request for course equivalency");
                System.out.println("[3] Reports");
                System.out.println("[4] Exit");

          
                System.out.print("Choice: ");
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1: 
                        System.out.println("Data Core Management:");
                        System.out.println("[1] Manage Terms and School Years");
                        System.out.println("[2] Manage holidays");
                        System.out.println("[3] Back");
                        System.out.print("Choice: ");
                        int dataChoice = scanner.nextInt();

                        if (dataChoice == 1) {
                            System.out.println("[1] Insert Term");
                            System.out.println("[2] Delete Term");
                            System.out.println("[3] Update Term");
                            System.out.println("[4] View All Terms");
                            System.out.println("[5] Back");

                            System.out.print("Choice: ");
                            int termChoice = scanner.nextInt();
                            scanner.nextLine(); // consume newline

                            if (termChoice == 1) {
                                System.out.print("Enter term ID (e.g., 124A, 124B, 124C): ");
                                String termId = scanner.nextLine().trim();

                                if (!termId.matches("\\d{3}[ABC]")) {
                                    System.out.println("Invalid term ID format! It must follow the format: 124A, 124B, or 124C.");
                                } else {
                                    System.out.print("Enter term start date (YYYY-MM-DD): ");
                                    String termStart = scanner.nextLine();
                                    System.out.print("Enter term end date (YYYY-MM-DD): ");
                                    String termEnd = scanner.nextLine();

                                    try {
                                        Terms newTerm = new Terms(termId, LocalDate.parse(termStart), LocalDate.parse(termEnd));
                                        termsDAO.insertTerm(newTerm);
                                        System.out.println("Term inserted successfully!");
                                    } catch (Exception e) {
                                        System.out.println("Error inserting term: " + e.getMessage());
                                    }
                                }
                            } else if (termChoice == 2) {
                                System.out.print("Enter the term ID to delete: ");
                                String termId = scanner.nextLine().trim();

                                try {
                                    termsDAO.deleteTerm(termId);
                                    System.out.println("Term deleted successfully!");
                                } catch (Exception e) {
                                    System.out.println("Error deleting term: " + e.getMessage());
                                }
                            } else if (termChoice == 3) {
                                System.out.print("Enter term ID to update (e.g., 124A, 124B, 124C): ");
                                String termId = scanner.nextLine().trim();

                                if (!termId.matches("\\d{3}[ABC]")) {
                                    System.out.println("Invalid term ID format! It must follow the format: 124A, 124B, or 124C.");
                                } else {
                                    System.out.print("Enter new term start date (YYYY-MM-DD): ");
                                    String termStart = scanner.nextLine();
                                    System.out.print("Enter new term end date (YYYY-MM-DD): ");
                                    String termEnd = scanner.nextLine();

                                    try {
                                        Terms updatedTerm = new Terms(termId, LocalDate.parse(termStart), LocalDate.parse(termEnd));
                                        termsDAO.updateTerm(updatedTerm);
                                        System.out.println("Term updated successfully!");
                                    } catch (Exception e) {
                                        System.out.println("Error updating term: " + e.getMessage());
                                    }
                                }
                            } else if (termChoice == 4) {
                                try {
                                    List<Terms> allTerms = termsDAO.getAllTerms();
                                    if (allTerms.isEmpty()) {
                                        System.out.println("No terms found.");
                                    } else {
                                    	
                                        for (Terms term : allTerms) {
                                        	System.out.println("ID: " + term.getId() + ", Start: " + term.getTermStart() + ", End: " + term.getTermEnd());

                                        }
                                    }
                                } catch (Exception e) {
                                    System.out.println("Error retrieving terms: " + e.getMessage());
                                }
                            } else if (termChoice == 5) {
                            	break;
                            } else {
                                System.out.println("Invalid choice. Please try again.");
                            }
                        } else if (dataChoice == 2) {
                        	
                        	while (true) {
                                System.out.println("Holidays Menu:");
                                System.out.println("[1] Add Holiday");
                                System.out.println("[2] View Holidays");
                                System.out.println("[3] Update Holiday");
                                System.out.println("[4] Delete Holiday");
                                System.out.println("[5] Back to Main Menu");
                                System.out.print("Choice: ");
                                int holidayChoice = scanner.nextInt();
                                scanner.nextLine(); // consume nwline

                                if (holidayChoice == 1) {

                                	System.out.print("Enter holiday name: ");
                                    String name = scanner.nextLine();
                                    System.out.print("Enter holiday date (YYYY-MM-DD): ");
                                    String date = scanner.nextLine();
                                    holidaysDao.createHoliday(name, date);
                                    
                                } else if (holidayChoice == 2) {

                                	holidaysDao.readHolidays();
                                	
                                } else if (holidayChoice == 3) {
                                	
                                    System.out.print("Enter old holiday name: ");
                                    String oldName = scanner.nextLine();
                                    System.out.print("Enter new holiday name: ");
                                    String newName = scanner.nextLine();
                                    System.out.print("Enter new holiday date (YYYY-MM-DD): ");
                                    String newDate = scanner.nextLine();
                                    holidaysDao.updateHoliday(oldName, newName, newDate);
                                    
                                } else if (holidayChoice == 4) {
                                	
                                    System.out.print("Enter holiday name to delete: ");
                                    String delName = scanner.nextLine();
                                    holidaysDao.deleteHoliday(delName);
                                    
                                } else if (holidayChoice == 5) {
                                    break;
                                    
                                } else {
                                    System.out.println("Invalid choice. Please try again.");
                                }
                            }
                           
                           
                        } else if (dataChoice == 3) {
                           
                        	
                        } else {
                            System.out.println("Invalid choice. Please try again.");
                        }
                        break;

                    case 2: {
                    	System.out.println("Course Equivalency Menu:");
                    	System.out.println("[1] Add Request");
                    	System.out.println("[2] View Requests");
                    	System.out.println("[3] Update Request");
                    	System.out.println("[4] Delete Request");
                    	System.out.println("[5] Back to Main Menu");
                        System.out.print("Choice: ");
                    	int equivalencyChoice = scanner.nextInt();
                    	scanner.nextLine(); // consume newline

                    	if (equivalencyChoice == 1) {
                    		
                    	    System.out.print("Enter student ID: ");
                    	    String studentId = scanner.nextLine();
                    	    System.out.print("Enter date (YYYY-MM-DD): ");
                    	    String date = scanner.nextLine();
                    	    System.out.print("Enter approved by: ");
                    	    String approvedBy = scanner.nextLine();
                    	    System.out.print("Enter request course code: ");
                    	    String requestCourse = scanner.nextLine();
                    	    System.out.print("Enter equivalent course code: ");
                    	    String equivalentCourse = scanner.nextLine();

                    	    requestDao.createRequest(new EquivRequest(0, studentId, date, approvedBy, requestCourse, equivalentCourse));

                    	} else if (equivalencyChoice == 2) {
                    	    // View Requests
                    	    List<EquivRequest> requests = requestDao.getAllRequests();
                    	    for (EquivRequest req : requests) {
                    	        System.out.println("Request ID: " + req.getRequestId() +
                    	                           ", Student ID: " + req.getStudentId() +
                    	                           ", Date: " + req.getDate() +
                    	                           ", Approved By: " + req.getApprovedBy() +
                    	                           ", Request Course: " + req.getRequestCourse() +
                    	                           ", Equivalent Course: " + req.getEquivalentCourse());
                    	    }

                    	} else if (equivalencyChoice == 3) {
                    	    System.out.print("Enter request ID to update: ");
                    	    int requestId = scanner.nextInt();
                    	    scanner.nextLine(); 
                    	    System.out.print("Enter new student ID: ");
                    	    String studentId = scanner.nextLine();
                    	    System.out.print("Enter new date (YYYY-MM-DD): ");
                    	    String date = scanner.nextLine();
                    	    System.out.print("Enter new approved by: ");
                    	    String approvedBy = scanner.nextLine();
                    	    System.out.print("Enter new request course code: ");
                    	    String requestCourse = scanner.nextLine();
                    	    System.out.print("Enter new equivalent course code: ");
                    	    String equivalentCourse = scanner.nextLine();

                    	  
                    	    requestDao.updateRequest(new EquivRequest(requestId, studentId, date, approvedBy, requestCourse, equivalentCourse));

                    	} else if (equivalencyChoice == 4) {
                    		
                    	    System.out.print("Enter request ID to delete: ");
                    	    int requestId = scanner.nextInt();
                    	    scanner.nextLine(); 

                    	   
                    	    requestDao.deleteRequest(requestId);

                    	} else if (equivalencyChoice == 5) {
                    	   
                    	    break;

                    	} else {
                    	    System.out.println("Invalid choice. Please try again.");
                    	}
                    }
                        break;

                    case 3: 
                        System.out.println("Reports menu");
                        System.out.println("[1] Generate Course to Teacher Distribution Report");
                        System.out.println("[2] Back");
                        System.out.print("Choice: ");
                        int reportChoice = scanner.nextInt();
                        
                        if (reportChoice == 1) {
                        	 System.out.print("Enter academic year start: ");
                             int yearStart = scanner.nextInt();
                             System.out.print("Enter academic year end: ");
                             int yearEnd = scanner.nextInt();
                            
                        	 reportDAO.generateCourseTeacherDistribution(yearStart, yearEnd);
                        }else if (reportChoice ==2) {
                        	break;
                        }
                        break;

                    case 4: 
                        System.out.println("Exiting... ");
                        scanner.close();
                        connection.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
/*
String url = "jdbc:mysql://localhost:3306/ccinfo210db"; 
String username = "root"; 
String password = "p@ssword!"; 

 	String url = "jdbc:mysql://100.103.244.13:3308/CCINFO210DB"; 
        	String username = "root"; 
        	String password = "DLSU1234!"; 
        	
        	nter student ID: 12312312
Enter date (YYYY-MM-DD): 2024-11-21
Enter approved by: 
Enter request course code: CS101
Enter equivalent course code: CS101
*/
