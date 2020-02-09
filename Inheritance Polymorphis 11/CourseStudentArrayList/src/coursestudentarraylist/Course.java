
package coursestudentarraylist;

import java.util.ArrayList;

public class Course {
    private String courseName;
    private ArrayList<String> students;
    
    public Course(String courseName){
        this.courseName = courseName;
        students = new ArrayList<String>();
    }
    
    public void addStudent(String student){
        students.add(student);
    }
    
    public String[] getStudents(){
        String[] a = new String[students.size()];
        return students.toArray(a);
    }
    
    public int getNumberOfStudents() {
		return students.size();
	}

    /** Return course name */
    public String getCourseName() {
            return courseName;
    }

    /** Drop a student for list */
    public void dropStudent(String student) {
            students.remove(student);
    }
}
