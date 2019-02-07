package menu;

import java.util.Scanner;

import database.Database;

public class Menu {
	private Scanner scanner = new Scanner(System.in);
	private boolean exit = false;
	private Database db = new Database();


	public void runMainMenu (){
		
		db.createTable();

		do {
			String input;

			showMenu();

			input = scanner.next();
			doOperation(input);

		}while(!exit);
	}

	private void showMenu() {

		System.out.println("\n\nPlease Select The Operation You Wish To Carry Out.\n"
				+ "1: Add New User\n"
				+ "2: Edit Existing User\n"
				+ "3: Delete User\n"
				+ "4: List All Users\n"
				+ "5: Count Users\n"
				+ "H: Help\n"
				+ "E: Exit Application");
	}


	private void doOperation(String input) {
		switch(input.toUpperCase()) {
		case "1":  addUser();
			break;
		case "2":  updateUser();
			break;
		case "3":  removeUser();
			break;
		case "4":  db.getAllUsers();
			break;
		case "5":  db.countUsers();
			break;
		case "E":  exit = true;
			break;
		case "H": showHelp();
			break;
		default: System.out.println("You Made An Invalid Selection Please From The Menu");;
		}
	}
	
	private void addUser() {
		int id = -1;
		String first;
		String last;
		
		System.out.println("Enter ID");
		id = scanner.nextInt();
		
		System.out.println("Enter Firstname");
		first = scanner.next();
		
		System.out.println("Enter Lastname");
		last = scanner.next();
		
		db.addUser(id, first, last);
	}
	
	private void removeUser() {
		System.out.println("what is the ID of the user you wish to remove");
		int id = scanner.nextInt();
		db.deleteUser(id);
	}

	private void updateUser() {
		
		int id = -1;
		String first;
		String last;
		
		System.out.println("Enter ID");
		id = scanner.nextInt();
		
		System.out.println("Enter Firstname");
		first = scanner.next();
		
		System.out.println("Enter Lastname");
		last = scanner.next();
		
		db.editUser(first, last,id);
		
	}
	
	private void showHelp() {
		System.out.println("Help section is under construction");
	}
}
