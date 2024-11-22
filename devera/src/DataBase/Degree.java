package DataBase;

public class Degree {
    private String degreeID;
    private String name;
    private String typeId;
    private String college;

    public Degree(String degreeID, String name, String typeId, String college) {
        this.degreeID = degreeID;
        this.name = name;
        this.typeId = typeId;
        this.college = college;
    }
    
    public Degree() {
    	
    }

    public String getDegreeID() {
        return degreeID;
    }
    
    public void setDegreeID(String ID) {
    	this.degreeID = ID;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }

    public String getTypeId() {
        return typeId;
    }
    
    public void setTypeId(String type) {
    	this.typeId = type;
    }

    public String getCollege() {
        return college;
    }
    
    public void setCollege(String college) {
    	this.college = college;
    }
    
}