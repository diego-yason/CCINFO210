package DataBase;

public class TranscriptRecord {
	private String termId;
	private String courseCode;
	private String courseName;
	private float  grade;
	private float units;
	
	public TranscriptRecord(String termId, String courseCode, String courseName, float grade, float units) {
		this.termId = termId;
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.grade = grade;
		this.units = units;
	}
	
	public TranscriptRecord() {
		
	}
	
	public String getTermID() {
		return this.termId;
	}
	
	public void setTermID(String termId) {
		this.termId = termId;
	}
	
	public String getCourseCode() {
		return this.courseCode;
	}
	
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	public String getCourseName() {
		return this.courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public float getGrade() {
		return this.grade;
	}
	
	public void setGrade(float grade) {
		this.grade = grade;
	}
	
	public float getUnits() {
		return this.units;
	}
	
	public void setUnits(float units) {
		this.units = units;
	}
}
