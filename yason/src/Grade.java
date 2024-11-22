public class Grade {
    public int studentId;
    public String sectionCode;
    public String courseCode;
    public String termId;
    public float grade;

    public Grade(int studentId, String sectionCode, String courseCode, String termId, float grade) {
        this.studentId = studentId;
        this.sectionCode = sectionCode;
        this.courseCode = courseCode;
        this.termId = termId;
        this.grade = grade;
    }
}
