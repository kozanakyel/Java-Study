import java.util.HashMap;
import java.util.HashSet;

public class GradeSolution {
    public static void main(String[] args) {
        Department cse = new Department("CSE", "Computer Engineering");
        Department math = new Department("MATH", "Mathematics");

        Teacher jl = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", cse, "2001 - LSU");
        Student bl = new Student("Brad Ledet", "bradledet@akdeniz.edu.tr", cse, "123456789");
        Teacher mg = new Teacher("Melih Gunay", "melih@akdeniz.edu.tr", math, "NC State");
        GradStudent aa = new GradStudent("Alperen Aksoy", "alperen@akdeniz.edu.tr", cse, "555777888", "Something awesome", jl);
        GradStudent tya = new GradStudent("Taha Yigit Alkan", "taha@akdeniz.edu.tr", cse, "888555777", "Amazing stuff", mg);


        //cse.setChair(mg); // results in exception because mg is not in correct department
        mg.setDepartment(cse);
        cse.setChair(mg); // now it is successful

        Course cse101 = new Course(cse, 101, "Computer Programming I", "Introduction to programming", jl, 6);
        Course cse102 = new Course(cse, 102, "Computer Programming II", "Second year introduction to programming", null, 6, cse101);
        jl.addCourse(cse102);
        Course cse501 = new Course(cse, 501, "Super Advanced Computer Programming", "Programming for Grad Students", mg, 6);

        //bl.addCourse(cse102); // results in exception because prerequisite not passed
        cse101.addStudent(bl);
        cse101.changeGrade(bl, 55);
        //bl.addCourse(cse102); // results in exception because prerequisite still not passed
        cse101.changeGrade(bl, 89);
        bl.addCourse(cse102); // now it can be added

        //((Teacher)jl).changeGrade(cse102, (Student)bl, 100);

        //bl.addCourse(cse501); // results in exception because bl is not a grad student
        aa.addCourse(cse501); // no problem
        cse501.addStudent(tya); // also okay

        System.out.println("GPA for " + bl.getName() + " -> " + bl.getGPA());
        System.out.println("Total AKTS for " + bl.getName() + " -> " + bl.getTotalAKTS());

        System.out.println("GPA for " + aa.getName() + " -> " + aa.getGPA()); // may result in division by 0 exception
        System.out.println("Total AKTS for " + aa.getName() + " -> " + aa.getTotalAKTS());

        ((Teacher)mg).changeGrade(cse501, tya, 100);

        System.out.println("GPA for " + tya.getName() + " -> " + tya.getGPA());
        System.out.println("Total AKTS for " + tya.getName() + " -> " + tya.getTotalAKTS());

        System.out.println(cse501.getCourseCode());
        System.out.println(cse501.studentList());

        System.out.println(bl.courseList());

    }

}

class Department{
    private String code;
    private String name;
    private Teacher chair;
    private HashSet<Teacher> teacherSet;
    private HashSet<Student> studentSet;
    private HashSet<Course> courseSet;


    public Department(String code, String name) {
        this.code = code;
        this.name = name;
        teacherSet = new HashSet<>();
        studentSet = new HashSet<>();
        courseSet = new HashSet<>();
    }

    public void addTeacher(Teacher teacher){
        teacher.setDepartment(this);
        teacherSet.add(teacher);
    }

    public void addStudent(Student student){
        student.setDepartment(this);
        studentSet.add(student);
    }

    public void addCourse(Course course){
        course.setDepartment(this);
        courseSet.add(course);
    }

    public void setCourseTeacher(Course course, Teacher teacher){
        if(teacher.getDepartment() == course.getDepartment())
            course.setTeacher(teacher);
        else
            throw new DepartmentMismatchException(teacher.getDepartment(),
                    course.getDepartment());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getChair() {
        return chair;
    }

    public void setChair(Teacher chair) {
        if(chair.getDepartment() != this)
            throw new TeacherNotFoundException(chair.getDepartment(),
                    this, null);
        this.chair = chair;
    }
}

abstract class Person{
    private String name;
    private String emailaddress;
    private Department department;
    private HashSet<Course> courseSet;

    public Person(String name, String emailaddress, Department department) {
        this.name = name;
        this.emailaddress = emailaddress;
        this.department = department;
        courseSet = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public abstract void addCourse(Course course);

    public String courseList() {
        String result = "";
        for (Course course : courseSet) {
            result += course.getCourseCode() + "\n";
        }
        return result;
    }

    public HashSet<Course> getCourseSet() {
        return courseSet;
    }
}

class Teacher extends Person{
    private String cv;

    public Teacher(String name, String emailaddress, Department department,
                   String cv) {
        super(name, emailaddress, department);
        this.cv = cv;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    @Override
    public void addCourse(Course course) {
        if(this.getDepartment() != course.getDepartment())
            throw new DepartmentMismatchException(this.getDepartment(),
                    course.getDepartment());
        course.setTeacher(this);
        HashSet<Course> courses = getCourseSet();
        courses.add(course);
    }

    public void changeGrade(Course course, Student student, double grade) {
        if(!course.getTeacher().getEmailaddress().equals(getEmailaddress()))
            throw new TeacherNotFoundException(getDepartment(), null, course);
        course.changeGrade(student, grade);
    }
}

class GradeDTO {
    private double grade;
    private double gpa;
    private String letter;
    private boolean result;

    public GradeDTO(double grade, double gpa, String letter, boolean result) {
        this.grade = grade;
        this.gpa = gpa;
        this.letter = letter;
        this.result = result;
    }

    public double getGrade() {
        return grade;
    }

    public double getGpa() {
        return gpa;
    }

    public String getLetter() {
        return letter;
    }

    public boolean getResult() {
        return result;
    }
}

class Grade {
    public static GradeDTO calculateGrade(boolean isGradStudent, double grade) {
        if (!isGradStudent) {
            if (88 <= grade && grade <= 100)
                return new GradeDTO(grade, 4.0, "AA", true);
            else if (81 <= grade && grade < 88)
                return new GradeDTO(grade, 3.5, "BA", true);
            else if (74 <= grade && grade < 81)
                return new GradeDTO(grade, 3.0, "BB", true);
            else if (67 <= grade && grade < 74)
                return new GradeDTO(grade, 2.5, "CB", true);
            else if (60 <= grade && grade < 67)
                return new GradeDTO(grade, 2.0, "CC", true);
            else if (53 <= grade && grade < 60)
                return new GradeDTO(grade, 1.5, "DC", false);
            else if (46 <= grade && grade < 53)
                return new GradeDTO(grade, 1.0, "DD", false);
            else if (35 <= grade && grade < 46)
                return new GradeDTO(grade, 0.5, "FD", false);
            else
                return new GradeDTO(grade, 0, "FF", false);
        } else {
            if (90 <= grade && grade <= 100)
                return new GradeDTO(grade, 4.0, "AA", true);
            else if (85 <= grade && grade < 90)
                return new GradeDTO(grade, 3.5, "BA", true);
            else if (80 <= grade && grade < 85)
                return new GradeDTO(grade, 3.0, "BB", true);
            else if (75 <= grade && grade < 80)
                return new GradeDTO(grade, 2.5, "CB", true);
            else if (70 <= grade && grade < 75)
                return new GradeDTO(grade, 2.0, "CC", true);
            else
                return new GradeDTO(grade, 1.5, "DC", false);
        }
    }
}

class Student extends Person{
    private String id;

    public Student(String name, String emailaddress, Department department,
                   String id) {
        super(name, emailaddress, department);
        this.id = id;
    }

    @Override
    public void addCourse(Course course) {
        HashSet<Course> courses = getCourseSet();

        if(!courses.contains(course)){
            course.addStudent(this);
            courses.add(course);
        }
    }

    public double getGPA() {
        double totalGPA = 0;
        int totalAKTS = 0;
        HashSet<Course> courses = getCourseSet();
        for (Course course : courses) {
            GradeDTO grade = course.getStudentGrade(this);
            if (grade != null) {
                totalGPA += grade.getGpa() * course.getAKTS();
                totalAKTS += course.getAKTS();
            }
        }
        if(totalAKTS != 0)
            return totalGPA / totalAKTS;
        else
            return 0;
    }

    public int getTotalAKTS(){
        HashSet<Course> courses = getCourseSet();
        int akts = 0;
        for(Course course : courses){
            //GradeDTO grade = course.getStudentGrade(this);
            //if (grade != null && grade.getResult())
                akts += course.getAKTS();
        }
        return akts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.getId() + " -> " + this.getName();
    }
}

class GradStudent extends Student{
    private String thesistitle;
    private Teacher adviser;

    public GradStudent(String name, String emailaddress, Department department,
                       String id, String thesistitle, Teacher adviser) {
        super(name, emailaddress, department, id);
        this.thesistitle = thesistitle;
        this.adviser = adviser;
    }

    public String getThesistitle() {
        return thesistitle;
    }

    public void setThesistitle(String thesistitle) {
        this.thesistitle = thesistitle;
    }

    public Teacher getAdviser() {
        return adviser;
    }

    public void setAdviser(Teacher adviser) {
        this.adviser = adviser;
    }
}

class Course{
    private Department department;
    private int number;
    private String title;
    private String description;
    private Teacher teacher;
    private int akts;
    private Course prerequisite;
    private HashMap<Student, Double> students;


    public Course(Department department, int number, String title,
                  String description, Teacher teacher, int akts,
                  Course prerequisite) {
        this.department = department;
        this.number = number;
        this.title = title;
        this.description = description;
        this.teacher = teacher;
        this.akts = akts;
        this.prerequisite = prerequisite;
        students = new HashMap<>();
    }

    public Course(Department department, int number, String title,
                  String description, Teacher teacher, int akts) {
        this.department = department;
        this.number = number;
        this.title = title;
        this.description = description;
        this.teacher = teacher;
        this.akts = akts;
        students = new HashMap<>();
    }

    public void addStudent(Student student) {
        if(!students.containsKey(student)){
            if (prerequisite != null) {
                GradeDTO grade = prerequisite.getStudentGrade(student);
                if (grade == null || !grade.getResult())
                    throw new PrerequisiteNotPassedException(student, this, prerequisite);
            }

            if (number >= 500 && !(student instanceof GradStudent))
                throw new NotGradStudentException(student, this);

            students.put(student, null);
            student.addCourse(this);
        }
    }

    public GradeDTO getStudentGrade(Student student) {

        if (students.containsKey(student)) {
            Double grade = students.get(student);
            if (grade != null)
                return Grade.calculateGrade(student instanceof GradStudent, grade);
        }
        return null;
    }

    public void changeGrade(Student student, double grade) {
        if(students.containsKey(student))
            students.put(student, grade);
        else
            throw new StudentNotEnrolledException(student, this);
    }

    public String studentList() {
        String result = "";
        for (Student student : students.keySet()) {
            result += student + "\n";
        }
        return result;
    }

    public HashMap<Student, Double> getStudents() {
        return students;
    }

    public void setStudents(HashMap<Student, Double> students) {
        this.students = students;
    }

    public String getCourseCode() {
        return department.getCode() + " " + number;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        if(teacher.getDepartment() != this.getDepartment())
            throw new DepartmentMismatchException(teacher.getDepartment(),
                    this.getDepartment());
        this.teacher = teacher;
    }

    public int getAKTS() {
        return akts;
    }

    public void setAKTS(int akts) {
        this.akts = akts;
    }

    public Course getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(Course prerequisite) {
        this.prerequisite = prerequisite;
    }
}

class DepartmentMismatchException extends RuntimeException {
    private Department teacherDept, courseDept;

    public DepartmentMismatchException(Department teacherDept, Department courseDept) {
        this.teacherDept = teacherDept;
        this.courseDept = courseDept;
    }

    public String toString() {
        return "DepartmentMismatchException: Teacher in " + teacherDept.getCode() + ", Course in " + courseDept.getCode();
    }
}

class NotGradStudentException extends RuntimeException {
    private Student student;
    private Course course;

    public NotGradStudentException(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public String toString() {
        return "NotGradStudentException: Student " + student.getId()
                + " cannot take " + course.getCourseCode();
    }
}

class PrerequisiteNotPassedException extends RuntimeException {
    private Student student;
    private Course course;
    private Course prerequsite;

    public PrerequisiteNotPassedException(Student student, Course course,
                                          Course prerequsite) {
        this.student = student;
        this.course = course;
        this.prerequsite = prerequsite;
    }

    @Override
    public String toString() {
        return "PrerequisiteNotPassedException: Student " + student.getId() + " cannot take "
                + course.getCourseCode() + " because course " + prerequsite.getCourseCode()
                + " not passed yet";
    }
}

class StudentNotEnrolledException extends RuntimeException {
    private Student student;
    private Course course;

    public StudentNotEnrolledException(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public String toString() {
        return "StudentNotEnrolledException: Student " + student.getId() + " not enrolled in " + course.getCourseCode();
    }
}

class TeacherNotFoundException extends RuntimeException {
    private Department teacherDept, chairDept;
    private Course course;

    public TeacherNotFoundException(Department teacherDept, Department chairDept, Course course) {
        this.teacherDept = teacherDept;
        this.chairDept = chairDept;
        this.course = course;
    }

    public String toString() {
        if(chairDept != null)
            return "TeacherNotFoundException: Teacher in " + teacherDept.getCode() + " cannot be chair for " + chairDept.getCode();
        else if(course != null)
            return "TeacherNotFoundException: Teacher not currently teaching course " + course.getCourseCode();
        else
            return "TeacherNotFoundException: Invalid scenario (both chair and course not given)";
    }
}


