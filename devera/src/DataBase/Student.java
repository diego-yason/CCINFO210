package DataBase;

public class Student {
    private int id;
    private String firstName;
    private String lastName; 
    private String degreeProgram; 

    public Student(int id, String firstName, String lastName, String degreeProgram) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.degreeProgram = degreeProgram;
    }
    
    public Student() {
    	
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDegreeProgram() {
        return degreeProgram;
    }

    public void setDegreeProgram(String degreeProgram) {
        this.degreeProgram = degreeProgram;
    }
    
}
