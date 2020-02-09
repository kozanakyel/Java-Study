
package testcourse;

public class TestCourse {

    public static void main(String[] args) {
        Course course1 = new Course("Data Structures");
        Course course2 = new Course("Database Statements");
        
        course1.addStudent("peter");
        course1.addStudent("kim");
        course1.addStudent("yok");
        
        course2.addStudent("ali");
        course2.addStudent("beter");
        
        System.out.println("numbers course1 : " + course1.getNumberOfStudents());
        String[] students = course1.getStudents();
        for(int i = 0; i < course1.getNumberOfStudents(); i++)
            System.out.print(students[i] + ", ");
    }
    
}
