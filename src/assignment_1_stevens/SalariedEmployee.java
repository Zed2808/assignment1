package assignment_1_stevens;

/**
 * @author Zachary Stevens
 */
public class SalariedEmployee extends Employee {

	private static final String PERSON_TYPE = "Salaried Employee";
	private double salary;

	/**
	 * Empty constructor.
	 */
	public SalariedEmployee() {
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
	 * @param salary the employee's yearly salary
	 */
	public SalariedEmployee(String name, String ssn, int age, char gender, String address, String phone,
			String department, String title, int hireYear, double salary) {
		super(name, ssn, age, gender, address, phone, department, title, hireYear);
		this.salary = salary;
	}
	
	/**
	 * @return the person type
	 */
	public String getPersonType() {
		return PERSON_TYPE;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = super.toString()
				+ "\nSalary: " + salary;
		return result;
	}	

}
