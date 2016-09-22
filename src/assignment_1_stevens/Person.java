package assignment_1_stevens;

/**
 * @author Zachary Stevens
 */
public class Person {

	private static final String PERSON_TYPE = "Person";
	private String name;
	private String ssn;
	private int age;
	private char gender;
	private String address;
	private String phone;

	/**
	 * Empty constructor.
	 */
	public Person() {
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
	 */
	public Person(String name, String ssn, int age, char gender, String address, String phone) {
		this.name = name;
		this.ssn = ssn;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
	}
	
	/**
	 * @return the person type
	 */
	public String getPersonType() {
		return PERSON_TYPE;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the gender
	 */
	public char getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = "Name: " + name
				+ "\nSSN: " + ssn
				+ "\nAge: " + age
				+ "\nGender: " + gender
				+ "\nAddress: " + address
				+ "\nPhone number: " + phone;
		return result;
	}

}
