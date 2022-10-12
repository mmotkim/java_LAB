package studentmanager;

public class Student {
    private int stuID;
    private String stuName;
    private int semester;
    private String courseName;

    public Student(){

    }   

    public Student(int stuID, String stuName, int semester, String courseName){
        this.stuID = stuID;
        this.stuName = stuName;
        this.semester = semester;
        this.courseName = courseName;
    }

    /**
     * @return int return the id
     */
    public int getStuID() {
        return stuID;
    }

    /**
     * @param id the id to set
     */
    public void setStuID(int stuID) {
        this.stuID = stuID;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return stuName;
    }

    /**
     * @param name the name to set
     */
    public void setName(String stuName) {
        this.stuName = stuName;
    }

    /**
     * @return int return the semester
     */
    public int getSemester() {
        return semester;
    }

    /**
     * @param semester the semester to set
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     * @return String return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}
    
