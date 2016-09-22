package assignment_1_stevens;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Zachary Stevens
 */
public class Application {

	// Create a new scanner to get user input
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		ArrayList<Person> people = new ArrayList<Person>();
		
		// Create example people & add them to people
		people.add(new Person("Zach", "123-45-6789", 19, 'M', "486 Chandler St", "123-456-7890"));
		people.add(new Student("Person2", "264-23-0677", 20, 'M', "123 Main St", "624-555-9838", 3.2, "Computer Science", 2017));
		people.add(new Employee("Person3", "567-24-8744", 28, 'F', "836 Park Ave", "173-555-9126", "Accounting", "Accountant", 2012));
		people.add(new HourlyEmployee("Person4", "923-16-9126", 24, 'M', "93 Maple St", "923-555-2846", "Sales", "Sales Associate", 2015, 20, 10.00));
		people.add(new SalariedEmployee("Person5", "195-95-1970", 31, 'F', "184 Pine St", "234-555-2359", "Human Resources", "HR Manager", 2011, 85000.00));
		
		// Continue until the user chooses to quit
		boolean exit = false;
		while(!exit) {
			// Print overview of people in array
			System.out.println(overview(people));
			
			// Print option the user has to choose from
			System.out.print("Press 'a' to add a new person.\n"
					+ "Press 'd' to delete a person.\n"
					+ "Press 'q' to quit.\n"
					+ "> ");
			
			// Get user input
			String input = s.nextLine();
			
			// Handle user input
			switch(input) {
				// Quit
				case "q":
					s.close();
					exit = true;
					break;
				// Add new person
				case "a":
					addPerson(people);
					break;
				// Delete person
				case "d":
					deletePerson(people);
					break;
				// Number or other
				default:
					// Input is a number
					if(isNumber(input)) {
						// Number is in bounds
						if(Integer.parseInt(input) > 0 && Integer.parseInt(input) <= people.size()) {
							// Print detailed info of person chosen
							System.out.println(people.get(Integer.parseInt(input) - 1).toString() + "\n");
						} else {
							// Tell user input was out of bounds
							System.out.println("Not a valid person.\n");
						}
					// Unrecognized input
					} else {
						System.out.println("Unknown command.\n");
					}
			}
		}
	}
	
	public static String overview(ArrayList<Person> people) {
		// Return if no people in array to display
		if(people.size() == 0) {
			return "No people to display.\n";
		}
		
		// Set longest name & person type
		int longestName = 0;
		int longestType = 0;
		for(Person person : people) {
			// Longer name found
			if(person.getName().length() > longestName) {
				longestName = person.getName().length();
			}
			// Longer person type found
			if(person.getPersonType().length() > longestType) {
				longestType = person.getPersonType().length();
			}
		}
				
		// Create formatting string
		String formatString = "%3s  %-" + longestName + "s  %-" + longestType + "s\n";
		
		// Write header
		String result = String.format(formatString, "#", "Name", "Type");
		
		// Get all people information
		for(int i = 0; i < people.size(); i++) {
			result += String.format(formatString, i+1, people.get(i).getName(), people.get(i).getPersonType());
		}
		
		result += "\nEnter a number to  view more detailed information.";
		
		return result;
	}
	
	public static void addPerson(ArrayList<Person> people) {		
		// Print user options
		System.out.print("Choose the type of person to add:\n"
				+ "1. Custom person\n"
				+ "2. Placeholder person\n"
				+ "3. Placeholder student\n"
				+ "4. Placeholder employee\n"
				+ "5. Placeholder hourly employee\n"
				+ "6. Placeholder salaried employee\n"
				+ "> ");
		
		// Get user input
		int input = s.nextInt();
		// Throw away trailing EOL character
		s.nextLine();
		
		switch(input) {
			// Custom person
			case 1:
				addCustomPerson(people);
				break;
			// Placeholder person
			case 2:
				System.out.println("Adding placeholder person.\n");
				people.add(new Person("Placeholder", "123-45-6789", 25, 'M', "123 Main St", "123-555-1234"));
				break;
			// Placeholder student
			case 3:
				System.out.println("Adding placeholder student.\n");
				people.add(new Student("Placeholder", "123-45-6789", 25, 'M', "123 Main St", "123-555-1234", 3.0, "Computer Science", 2017));
				break;
			// Placeholder employee
			case 4:
				System.out.println("Adding placeholder employee.\n");
				people.add(new Employee("Placeholder", "123-45-6789", 25, 'M', "123 Main St", "123-555-1234", "IT", "Programmer", 2016));
				break;
			// Placeholder hourly employee
			case 5:
				System.out.println("Adding placeholder hourly employee.\n");
				people.add(new HourlyEmployee("Placeholder", "123-45-6789", 25, 'M', "123 Main St", "123-555-1234", "IT", "Programmer", 2016, 20, 20.0));
				break;
			// Placeholder salaried employee
			case 6:
				System.out.println("Adding placeholder salaried employee.\n");
				people.add(new SalariedEmployee("Placeholder", "123-45-6789", 25, 'M', "123 Main St", "123-555-1234", "IT", "Programmer", 2016, 75000));
				break;
			// Invalid choice
			default:
				System.out.println("Invalid selection.\n");
		}
	}
	
	public static void addCustomPerson(ArrayList<Person> people) {
		// Prompt user for person type
		System.out.print("Choose the type of person to add:\n"
				+ "1. Person\n"
				+ "2. Student\n"
				+ "3. Employee\n"
				+ "4. Hourly Employee\n"
				+ "5. Salaried Employee\n"
				+ "> ");
		
		// Get user input
		int input = s.nextInt();
		// Throw away trailing EOL character
		s.nextLine();
		
		// Make sure input is valid
		if(input >= 1 && input <= 5) {
			// Stuff that has to happen for all person types
			// Name
			System.out.print("Name: ");
			String name = s.nextLine();
			
			// SSN
			String ssn;
			boolean cont = false;
			// Continue until input is valid (9 digits)
			do {
				System.out.print("Social security number: ");
				ssn = s.nextLine();
				// Strip non-digits
				ssn = ssn.replaceAll("\\D+", "");
				// Make sure SSN is right length
				if(ssn.length() < 9) {
					System.out.println("Social security number too short.");
				} else if(ssn.length() > 9) {
					System.out.println("Social security number too long.");
				} else {
					// Add separators
					ssn = ssn.substring(0, 3) + "-" + ssn.substring(3, 5) + "-" + ssn.substring(5);
					cont = true;
				}
			} while(!cont);
			
			// Age
			int age = 0;
			cont = false;
			do {
				System.out.print("Age: ");
				try {
					age = s.nextInt();
					cont = true;
				} catch(InputMismatchException e) {
					System.out.println("Invalid age.");
					s.nextLine();
				}
			} while(!cont);
			// Throw away trailing EOL character
			s.nextLine();
			
			// Gender
			char gender;
			cont = false;
			// Continue until valid input is received ('M' or 'F')
			do {
				System.out.print("Gender (M/F): ");
				// Get first character in line (in case user enters "male"/"female") and capitalize it
				gender = s.next().charAt(0);
				gender = Character.toUpperCase(gender);
				// Throw away trailing EOL character
				s.nextLine();
				// Make sure gender is 'M' or 'F'
				if(gender == 'M' || gender == 'F') {
					cont = true;
				} else {
					System.out.println("Invalid gender.");
				}
			} while(!cont);
			
			// Address
			System.out.print("Address: ");
			String address = s.nextLine();
			
			// Phone number
			String phone;
			cont = false;
			// Continue until valid phone number is received
			do {
				System.out.print("Phone number: ");
				phone = s.nextLine();
				// Strip separators
				phone = phone.replaceAll("\\D+", "");
				// Make sure phone number is right length
				if(phone.length() < 10) {
					System.out.println("Phone number too short.");
				} else if(phone.length() > 10) {
					System.out.println("Phone number too long.");
				} else {
					// Add separators
					phone = phone.substring(0, 3) + "-" + phone.substring(3, 6) + "-" + phone.substring(6);
					cont = true;
				}
			} while(!cont);
			
			// Do person type specific stuff
			// Person
			if(input == 1) {
				Person person = new Person(name, ssn, age, gender, address, phone);
				people.add(person);
				System.out.println("Added new person.");
			// Student
			} else if(input == 2) {
				// GPA
				double gpa = 0.0;
				cont = false;
				do {
					// Make sure we're receiving a double
					boolean loop = true;
					do {
						System.out.print("GPA: ");
						try {
							gpa = s.nextDouble();
							loop = false;
						} catch(InputMismatchException e) {
							System.out.println("Invalid GPA.");
							s.nextLine();
						}
					} while(loop);
					s.nextLine();
					if(gpa < 0.0) {
						System.out.println("GPA too low.");
					} else if(gpa > 4.0) {
						System.out.println("GPA too high.");
					} else {
						cont = true;
					}
				} while(!cont);
					
				// Major
				System.out.print("Major: ");
				String major = s.nextLine();
				
				// Graduation year
				System.out.print("(Anticipated) Graduation year: ");
				int gradYear = s.nextInt();
				s.nextLine();
				
				Person student = new Student(name, ssn, age, gender, address, phone, gpa, major, gradYear);
				people.add(student);
				System.out.println("Added new student.");
			}
			// Employee
			if(input >= 3 && input <= 5) {
				// Department
				System.out.print("Department: ");
				String department = s.nextLine();
				
				// Title
				System.out.print("Title: ");
				String title = s.nextLine();
				
				// Hire Year
				int hireYear = 0;
				cont = false;
				do {
					System.out.print("Hire year: ");
					try {
						hireYear = s.nextInt();
						cont = true;
					} catch(InputMismatchException e) {
						System.out.println("Invalid hire year.");
						s.nextLine();
					}
				} while(!cont);
				// Throw away trailing EOL character
				s.nextLine();
				
				// Employee
				if(input == 3) {
					Person employee = new Employee(name, ssn, age, gender, address, phone, department, title, hireYear);
					people.add(employee);
					System.out.println("Added new employee.");
				}
				
				// If employee type is further specified
				// Hourly employee
				if(input == 4) {
					// Hours worked
					int hoursWorked = 0;
					cont = false;
					do {
						System.out.print("Hours worked: ");
						try {
							hoursWorked = s.nextInt();
							cont = true;
						} catch(InputMismatchException e) {
							System.out.println("Invalid number of hours worked.");
							s.nextLine();
						}
					} while(!cont);
					s.nextLine();
					
					// Rate
					double rate = 0.0;
					cont = false;
					do {
						System.out.print("Hourly rate: ");
						try {
							rate = s.nextDouble();
							cont = true;
						} catch(InputMismatchException e) {
							System.out.println("Invalid hourly rate.");
							s.nextLine();
						}
					} while(!cont);
					s.nextLine();
					
					Person hourlyEmployee = new HourlyEmployee(name, ssn, age, gender, address, phone, department, title, hireYear, hoursWorked, rate);
					people.add(hourlyEmployee);
					System.out.println("Added new hourly employee.");
				}
				
				// Salaried employee
				if(input == 5) {
					// Salary
					double salary = 0.0;
					cont = false;
					do {
						System.out.print("Salary: ");
						try {
							salary = s.nextDouble();
							cont = true;
						} catch(InputMismatchException e) {
							System.out.println("Invalid salary.");
							s.nextLine();
						}
					} while(!cont);
					s.nextLine();
					
					Person salariedEmployee = new SalariedEmployee(name, ssn, age, gender, address, phone, department, title, hireYear, salary);
					people.add(salariedEmployee);
					System.out.print("Added new salaried employee.");
				}
			}
		} else {
			// If input is not valid, tell user and return
			System.out.println("Invalid choice.\n");
			return;
		}
	}
	
	public static void deletePerson(ArrayList<Person> people) {
		// Prompt user to choose a person to delete
		System.out.print("Enter a number to delete that person:\n"
			+ "> ");

		// Get user input
		int input = s.nextInt();
		// Throw away trailing EOL character
		s.nextLine();

		// Remove chosen person if input within valid range
		if(input >= 1 && input <= people.size()) {
			System.out.println("Removing " + people.get(input-1).getName() + " from people.\n");
			people.remove(input-1);
		// If out of range, tell user
		} else {
			System.out.println("Invalid selection.\n");
		}
	}
	
	public static boolean isNumber(String s) {
		return s.matches("^\\d+$");
	}

}
