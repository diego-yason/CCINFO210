package control;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import views.main_menu.MainMenu;
import db.Conn;
public class Driver {

	public static Scanner scan = new Scanner(System.in);
	public static Conn connection = new Conn();
	public static CoreDataDriver cdd = new CoreDataDriver(connection);
	public static TransactionsDriver td = new TransactionsDriver(connection);
	public static ReportsDriver rd = new ReportsDriver(connection);
	public static void main(String[] args) {
		int choice = 1;
		while(choice != 0) {
			MainMenu.mainMenu();
			choice = Integer.parseInt(scan.nextLine());
			switch(choice) {
			case 1:  {
				cdd.menu(scan);
				break;
			}
			case 2: {
				td.menu(scan);
				break;
			}
			case 3: {
				rd.menu(scan);
			}
			}
		}
	}

}
