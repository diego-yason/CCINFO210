package models;

public class Grade {
	private float grade;
	private String courseCode;
	private int studentId;
	private int term;
	private int year;
	private String termId;
	private String section;
	public Grade(float grade, String courseCode, int studentId, String termId, String section) {
		this.setSection(section);
		this.setGrade(grade);
		this.setCourseCode(courseCode);
		this.setStudentId(studentId);
		this.setTermId(termId);
	}
	
	
	public void processTermId(int year, int term) {
		char termAsChar = (char) (term+64);
		StringBuilder sb = new StringBuilder();
		sb.append(year);
		sb.append(termAsChar);
		this.termId = sb.toString();
	}

	/**
	 * @return the courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}
	/**
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	/**
	 * @return the grade
	 */
	public float getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(float grade) {
		this.grade = grade;
	}
	/**
	 * @return the term
	 */
	public int getTerm() {
		return term;
	}
	/**
	 * @param term the term to set
	 */
	public void setTerm(int term) {
		this.term = term;
	}

	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the termId
	 */
	public String getTermId() {
		return termId;
	}

	/**
	 * @param termId the termId to set
	 */
	public void setTermId(String termId) {
		this.termId = termId;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}


	/**
	 * @return the section
	 */
	public String getSection() {
		return section;
	}


	/**
	 * @param section the section to set
	 */
	public void setSection(String section) {
		this.section = section;
	}
}
