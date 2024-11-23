package models;

public class Course {
	private String code;
	private String name;
	private float units;
	private String academic;
	private String department;

	public Course(String code, String name, float units, String academic, String department) {
		this.code = code;
		this.name = name;
		this.units = units;
		this.academic = academic;
		this.department = department;
	}
	/**
	 * @return the departments
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param departments the departments to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the academic
	 */
	public String getAcademic() {
		return academic;
	}
	/**
	 * @param academic the academic to set
	 */
	public void setAcademic(String academic) {
		this.academic = academic;
	}
	/**
	 * @return the units
	 */
	public float getUnits() {
		return units;
	}
	/**
	 * @param units the units to set
	 */
	public void setUnits(float units) {
		this.units = units;
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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}


}
