package models;

public class Student {
	private int id;
	private String lastName, firstName;
	private String degreeProgram;
	public Student(int id, String lastName, String firstName, String degreeProgram) {
		this.degreeProgram = degreeProgram;
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the degreeProgram
	 */
	public String getDegreeProgram() {
		return degreeProgram;
	}

	/**
	 * @param degreeProgram the degreeProgram to set
	 */
	public void setDegreeProgram(String degreeProgram) {
		this.degreeProgram = degreeProgram;
	}

}
