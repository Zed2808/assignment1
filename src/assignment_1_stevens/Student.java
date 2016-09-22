package assignment_1_stevens;

/**
 * @author Zachary Stevens
 */
public class Student extends Person {

	private static final String PERSON_TYPE = "Student";
	private double gpa;
	private String major;
	private int gradYear;
	
	/**
	 * Empty constructor.
	 */
	public Student() {
		super();
	}

	/**
	 * Full constructor.
	 * @param name the person's name
	 * @param ssn the person's social security number
	 * @param age the person's age
	 * @param gender the person's gender
	 * @param address the person's address
	 * @param phone the person's phone number
	 * @param gpa the person's grade point average
	 * @param major the person's major
	 * @param gradYear the year the person graduated (or is set to graduate)
	 */
	public Student(String name, String ssn, int age, char gender, String address, String phone, double gpa, String major, int gradYear) {
		super(name, ssn, age, gender, address, phone);
		this.gpa = gpa;
		this.major = major;
		this.gradYear = gradYear;
	}
	
	/**
	 * @return the person type
	 */
	public String getPersonType() {
		return PERSON_TYPE;
	}

	/**
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}

	/**
	 * @param gpa the gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}

	/**
	 * @return the gradYear
	 */
	public int getGradYear() {
		return gradYear;
	}

	/**
	 * @param gradYear the gradYear to set
	 */
	public void setGradYear(int gradYear) {
		this.gradYear = gradYear;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = super.toString()
				+ "\nGPA: " + gpa
				+ "\nMajor: " + major
				+ "\nYear of graduation: " + gradYear;
		return result;
	}

}
