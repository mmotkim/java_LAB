package studentmanager;

public class Student {
    private int id;
    private String name;
    private int semester;
    private String courseName;
    private int totalCourse;

    public Student(){

    }   

    public Student(int id, String name, int semester, String courseName, int totalCourse){
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.courseName = courseName;
        this.totalCourse = totalCourse;
    }

    /**
     * @return int return the id
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
     * @return String return the name
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

    /**
     * @return int return the totalCourse
     */
    public int getTotalCourse() {
        return totalCourse;
    }

    /**
     * @param totalCourse the totalCourse to set
     */
    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

}
    
