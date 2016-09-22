package assignment_1_stevens;

/**
 * @author Zachary Stevens
 */
public class HourlyEmployee extends Employee {

	private static final String PERSON_TYPE = "Hourly Employee";
	private int hoursWorked;
	private double rate;
	
	/**
	 * Empty constructor.
	 */
	public HourlyEmployee() {
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
	 * @param hoursWorked the hours the employee works in a week
	 * @param rate the employee's hourly rate
	 */
	public HourlyEmployee(String name, String ssn, int age, char gender, String address, String phone,
			String department, String title, int hireYear, int hoursWorked, double rate) {
		super(name, ssn, age, gender, address, phone, department, title, hireYear);
		this.hoursWorked = hoursWorked;
		this.rate = rate;
	}
	
	/**
	 * @return the person type
	 */
	public String getPersonType() {
		return PERSON_TYPE;
	}

	/**
	 * @return the hoursWorked
	 */
	public int getHoursWorked() {
		return hoursWorked;
	}

	/**
	 * @param hoursWorked the hoursWorked to set
	 */
	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	/**
	 * @return the rate
	 */
	public double getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = super.toString()
				+ "\nHours worked: " + hoursWorked
				+ "\nHourly rate: " + rate;
		return result;
	}

}
