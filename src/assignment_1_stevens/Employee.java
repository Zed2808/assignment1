package assignment_1_stevens;

/**
 * @author Zachary Stevens
 */
public class Employee extends Person {

	private static final String PERSON_TYPE = "Employee";
	private String department;
	private String title;
	private int hireYear;

	/**
	 * Empty constructor.
	 */
	public Employee() {
		super();
	}

	/**
	 * Full constructor.
	 * @param name the employee's name
	 * @param ssn the employee's social security number
	 * @param age the employee's age
	 * @param gender the employee's gender
	 * @param address the employee's address
	 * @param phone the employee's phone number
	 * @param department the employee's department
	 * @param title the employee's job title
	 * @param hireYear the year the employee was hired
	 */
	public Employee(String name, String ssn, int age, char gender, String address, String phone, String department, String title, int hireYear) {
		super(name, ssn, age, gender, address, phone);
		this.department = department;
		this.title = title;
		this.hireYear = hireYear;
	}
	
	/**
	 * @return the person type
	 */
	public String getPersonType() {
		return PERSON_TYPE;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the hireYear
	 */
	public int getHireYear() {
		return hireYear;
	}

	/**
	 * @param hireYear the hireYear to set
	 */
	public void setHireYear(int hireYear) {
		this.hireYear = hireYear;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = super.toString()
				+ "\nDepartment: " + department
				+ "\nJob title: " + title
				+ "\nHire year: " + hireYear;
		return result;
	}
	
}
