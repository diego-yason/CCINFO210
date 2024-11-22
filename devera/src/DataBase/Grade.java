package DataBase;

public class Grade {
    private int studentID;
    private String courseCode;
    private String sectionCode;
    private String termId;
    private float grade;

    public Grade(int studentID, String courseCode, String sectionCode, String termId, float grade) {
        this.studentID = studentID;
        this.courseCode = courseCode;
        this.sectionCode = sectionCode;
        this.termId = termId;
        this.grade = grade;
    }

    public Grade() {}

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    
    public String getSectionCode() {
    	return this.sectionCode;
    }
    
    public void setSectionCode(String sectionCode) {
    	this.sectionCode = sectionCode;
    }
    
    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}
