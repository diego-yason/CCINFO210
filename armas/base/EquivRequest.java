package com.ccinfomDbApp.base;

public class EquivRequest {
    private int requestId;
    private String studentId;
    private String date;
    private String approvedBy; 
    private String requestCourse;
    private String equivalentCourse;

    public EquivRequest(int requestId, String studentId, String date, String approvedBy, String requestCourse, String equivalentCourse) {
        this.requestId = requestId;
        this.studentId = studentId;
        this.date = date;
        this.approvedBy = approvedBy;
        this.requestCourse = requestCourse;
        this.equivalentCourse = equivalentCourse;
    }

    public EquivRequest(String studentId, String date, String approvedBy, String requestCourse, String equivalentCourse) { //for new requests - no request id
        this.studentId = studentId;
        this.date = date;
        this.approvedBy = approvedBy;
        this.requestCourse = requestCourse;
        this.equivalentCourse = equivalentCourse;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getRequestCourse() {
        return requestCourse;
    }

    public void setRequestCourse(String requestCourse) {
        this.requestCourse = requestCourse;
    }

    public String getEquivalentCourse() {
        return equivalentCourse;
    }

    public void setEquivalentCourse(String equivalentCourse) {
        this.equivalentCourse = equivalentCourse;
    }

   
}
