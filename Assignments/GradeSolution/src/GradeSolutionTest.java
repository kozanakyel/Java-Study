import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GradeSolutionTest {

    static Department cse;
    static Department phy;

    static Student ka;
    static Student ua;
    static Student fr;

    static Teacher jl;
    static Teacher dk;
    static Teacher fm;

    static GradStudent aa;
    static GradStudent tya;

    static Course cse101;
    static Course cse102;
    static Course phy201;
    static Course phy202;
    static Course cse701;

    @Before
    public void setUp() throws Exception {
        cse = new Department("CSE", "Computer Engineering");
        phy = new Department("PHY", "Physics");

        ka = new Student("Kursat Akyel","kursatakyel@gmail.com", phy,"2018165416");
        ua = new Student("Ugur Akyel", "kozanakyel@gmail.com", cse, "20190808020");
        fr = new Student("Fenomen Ronaldo","ronaldofc@gmail.com", cse,"20180987823");

        fm = new Teacher("Fernando Muslera", "muslera@hotmail.com", cse, "1999 - URU");
        jl = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", cse, "2001 - LSU");
        dk = new Teacher("Deniz Kaya", "denizkaya@akdeniz.edu.tr", phy, "1998 - ODTU");

        aa = new GradStudent("Alperen Aksoy", "alperen@akdeniz.edu.tr", cse, "555777888", "Something awesome", jl);
        tya = new GradStudent("Taha Yigit Alkan", "taha@akdeniz.edu.tr", cse, "888555777", "Amazing stuff", dk);

        cse101 = new Course(cse, 101, "Computer Programming I", "Introduction to programming", jl, 6);
        cse102 = new Course(cse, 102, "Computer Programming II", "Second year introduction to programming", null, 6, cse101);
        phy201 = new Course(phy, 201, "Physics I", "Newton Physics", dk, 5);
        phy202 = new Course(phy, 202, "Physics II", "Electricity and Magnetism", null, 4, phy201);
        cse701 = new Course(cse, 701, "Super Advanced Computer Programming", "Programming for Grad Students", dk, 7);
    }

    @Test
    public void tc_101getCode(){
        Assert.assertEquals("getCode not correctly works","CSE",cse.getCode());
        Assert.assertEquals("getCode not correctly works","PHY",phy.getCode());
    }

    @Test
    public void tc_102setCode(){
        cse.setCode("MATH");
        phy.setCode("CAL");
        Assert.assertEquals("new code definiton is failure.", "MATH",cse.getCode());
        Assert.assertEquals("new code definiton is failure","CAL",phy.getCode());
    }

    @Test
    public void tc_103getName(){
        Assert.assertEquals("getname method not correctly defined.","Computer Engineering",cse.getName());
        Assert.assertEquals("getname method not correctly defined.","Physics",phy.getName());
    }

    @Test
    public void tc_104setName(){
       cse.setName("Only Computer");
       Assert.assertEquals("new name not correctly setted", "Only Computer",cse.getName());
    }

    @Test
    public void tc_105getChair(){
        cse.setChair(jl);
        Assert.assertEquals("getChair method is failure", jl,cse.getChair());
    }

    @Test
    public void tc_106setChair() throws Exception{
        try{
            phy.setChair(fm);
        }catch (Exception e){
            assertTrue(e.getClass().getName().contains("TeacherNotFoundException"));
        }
        cse.setChair(fm);
        assertEquals("new cahir not correctly set", fm,cse.getChair());
    }

    @Test
    public void tc_107addTeacher(){
        cse.addTeacher(dk);
        phy.addTeacher(jl);
        phy.addTeacher(fm);
        assertEquals("adding teacher process is failure", cse,dk.getDepartment());
        assertEquals("adding teacher process is failure",phy,jl.getDepartment());
        assertEquals("adding teacher process is failure",phy,fm.getDepartment());
    }

    @Test
    public void tc_108addStudent(){
        cse.addStudent(ka);
        phy.addStudent(ua);
        assertEquals("adding student is not correctly works",cse,ka.getDepartment());
        assertEquals("adding student is not correctly defined",phy,ua.getDepartment());
    }

    @Test
    public void tc_109addCourse(){
        cse.addCourse(phy201);
        phy.addCourse(cse101);
        assertEquals("adding course not correctly working.", cse,phy201.getDepartment());
        assertEquals("adding course not correctly defined", phy,cse101.getDepartment());
    }

    @Test
    public void Qtc_110setCourseTeacher(){
        try{
            cse.setCourseTeacher(cse101, dk);
        }catch (Exception e){
            assertTrue(e.getClass().getName().contains("DepartmentMismatchException"));
        }
        phy.setCourseTeacher(phy201, dk);
        assertEquals("course teacher not correctly defined", dk, phy201.getTeacher());
        cse.setCourseTeacher(cse101,fm);
        cse.setCourseTeacher(cse101,jl);
        assertEquals("course teacher set not works",jl,cse101.getTeacher());
    }

    @Test
    public void tc_201getName(){
        assertEquals("getname method not correctly works", "Kursat Akyel",ka.getName());
        assertEquals("getname method not correctly defined", "Joseph Ledet",jl.getName());
    }

    @Test
    public void tc_202setName(){
        fm.setName("bakinhaleA");
        tya.setName("kozan AKYEL");
        assertEquals("set name is failure","bakinhaleA",fm.getName());
        assertEquals("set name is failure","kozan AKYEL",tya.getName());
    }

    @Test
    public void tc_203getEmailAddress(){
        assertEquals("email address not correctly works","muslera@hotmail.com",fm.getEmailaddress());
    }

    @Test
    public void tc_204setEmailAddress(){
        fm.setEmailaddress("pelezin@gmail.com");
        assertEquals("email address is failure","pelezin@gmail.com",fm.getEmailaddress());
    }

    @Test
    public void tc_205getDepartment(){
        assertEquals("get department not works.",cse,ua.getDepartment());
    }

    @Test
    public void tc_206setDepartment(){
        tya.setDepartment(phy);
        assertEquals("department not correctly set",phy,tya.getDepartment());
    }

    @Test
    public void tc_207courseList(){
        ua.addCourse(cse101);
        ua.addCourse(phy201);
        assertTrue(ua.courseList().contains("CSE"));
        assertTrue(ua.courseList().contains("PHY"));
    }

    @Test
    public void tc_301getCv(){
        assertEquals("getCV not correctly defined", "1998 - ODTU",dk.getCv());
    }

    @Test
    public void tc_302setCv(){
        jl.setCv("PARAguay takim - (leri)");
        assertEquals("new CV not correctly set", "PARAguay takim - (leri)",jl.getCv());
    }

    @Test
    public void Qtc_303addCourse(){
        jl.addCourse(cse101);
        fm.addCourse(cse102);
        assertTrue("adding course failured", jl.courseList().contains("CSE 101"));
        assertEquals("adding course failured", fm, cse102.getTeacher());
        try{
            dk.addCourse(cse101);
        }catch (Exception e){
            assertTrue(e.getClass().getName().contains("DepartmentMismatchException"));
        }
    }

    @Test
    public void Qtc_304changeGrade(){
        ua.addCourse(cse101);
        cse101.setTeacher(jl);
        jl.changeGrade(cse101,ua,89);
        assertTrue("grade changing not correctly working", 4.0 == ua.getGPA());
        tya.addCourse(cse701);
        cse701.setTeacher(jl);
        jl.changeGrade(cse701,tya,89);
        assertTrue("grade change not works for gradstudent", 3.5 == tya.getGPA());
        try{
            fm.changeGrade(cse101,ua,67);
        }catch (Exception e){
            assertTrue(e.getClass().getName().contains("TeacherNotFoundException"));
        }
        try{
            jl.changeGrade(cse101,ka,59);
        }catch (Exception e){
            assertTrue(e.getClass().getName().contains("StudentNotEnrolledException"));
        }
    }

    @Test
    public void tc_401getId(){
        assertEquals("get id method not correctly work", "2018165416",ka.getId());
    }

    @Test
    public void tc_402setId(){
        ka.setId("123456789");
        assertEquals("new ıd not correctly set","123456789",ka.getId());
    }

    @Test
    public void Qtc_403addCourse(){
        ua.addCourse(cse101);
        ua.addCourse(phy201);
        cse101.setTeacher(jl);
        jl.changeGrade(cse101,ua,59);
        assertTrue("adding course any department not working", ua.courseList().contains("CSE 101"));
        assertTrue("adding course any department not working", ua.courseList().contains("PHY 201"));
        try{
            ua.addCourse(cse701);
        }catch (Exception e){
            assertTrue(e.getClass().getName().contains("NotGradStudentException"));
        }
        try{
            ua.addCourse(cse102);
        }catch (Exception e){
            assertTrue(e.getClass().getName().contains("PrerequisiteNotPassedException"));
        }
    }

    @Test
    public void Qtc_404getGPA(){
        ua.addCourse(cse101);
        ua.addCourse(phy201);
        assertTrue(ua.getGPA() == 0);
        phy201.setTeacher(dk);
        dk.changeGrade(phy201,ua,100);
        assertTrue(ua.getGPA() == 4.0);
        dk.changeGrade(phy201,ua,81);
        assertTrue(ua.getGPA() == 3.5);
        dk.changeGrade(phy201,ua,89);
        assertTrue(ua.getGPA() == 4.0);
        dk.changeGrade(phy201,ua,74);
        assertTrue(ua.getGPA() == 3.0);
        dk.changeGrade(phy201,ua,67);
        assertTrue(ua.getGPA() == 2.5);
        dk.changeGrade(phy201,ua,53);
        assertTrue(ua.getGPA() == 1.5);
        dk.changeGrade(phy201,ua,46);
        assertTrue(ua.getGPA() == 1.0);
        dk.changeGrade(phy201,ua,23);
        assertTrue(ua.getGPA() == 0.0);

        tya.addCourse(cse701);
        cse701.setTeacher(fm);
        fm.changeGrade(cse701,tya,89);
        assertTrue(tya.getGPA() == 3.5);

        fm.changeGrade(cse701,tya,80);
        assertTrue(tya.getGPA() == 3.0);
        fm.changeGrade(cse701,tya,75);
        assertTrue(tya.getGPA() == 2.5);
        fm.changeGrade(cse701,tya,70);
        assertTrue(tya.getGPA() == 2.0);
        fm.changeGrade(cse701,tya,23);
        assertTrue(tya.getGPA() == 1.5);

        dk.changeGrade(phy201,ua,53);
        assertTrue(ua.getGPA() == 1.5);
        cse101.setTeacher(jl);
        jl.changeGrade(cse101,ua,80);
        String uaGPA = ua.getGPA() + "";
        assertTrue(uaGPA.contains("2.318"));
    }

    @Test
    public void Qtc_405getTotalAKTS(){
        ua.addCourse(cse101);
        ua.addCourse(phy201);
        assertEquals("getakts not correctly working.", 0, ua.getTotalAKTS());
        cse101.setTeacher(jl);
        jl.changeGrade(cse101,ua,65);
        ua.addCourse(cse102);
        assertEquals("getakts not correctly working.", 6,ua.getTotalAKTS());
        tya.addCourse(cse701);
        assertEquals("get akts for gradstudent not work", 7,tya.getTotalAKTS());
    }

    @Test
    public void tc_406toString(){
        System.out.println(ua.toString());
        assertEquals("tostring correctly not working.",
                "20190808020 -> Ugur Akyel",ua.toString());
    }

    @Test
    public void tc_501getThesisTitle(){
        assertEquals("get thesis not workng", "Something awesome",aa.getThesistitle());
    }

    @Test
    public void tc_502setThesisTitle(){
        aa.setThesistitle("kazanan programlar");
        assertEquals("setting thesis not workng","kazanan programlar",aa.getThesistitle());
    }

    @Test
    public void tc_503getAdviser(){
        assertEquals("get adviser not correctly working", jl,aa.getAdviser());
    }

    @Test
    public void tc_504setAdviser(){
        aa.setAdviser(fm);
        assertEquals("set adviser not working", fm,aa.getAdviser());
    }

    @Test
    public void tc_601getDepartment(){
        assertEquals("get department not works", cse,cse101.getDepartment());
    }

    @Test
    public void tc_602setDepartment(){
        cse101.setDepartment(phy);
        assertEquals("set dep. not working",phy,cse101.getDepartment());
    }

    @Test
    public void tc_603getNumber(){
        assertEquals("get number correctly not work", 201,phy201.getNumber());
    }

    @Test
    public void tc_604setNumber(){
        phy201.setNumber(452);
        assertEquals("set number not working", 452,phy201.getNumber());
    }

    @Test
    public void tc_605getTitle(){
        assertTrue(cse701.getTitle().contains("Super Advanced Computer Programming"));
    }

    @Test
    public void tc_606setTitle(){
        cse701.setTitle("MagniFICIENT P(ROG)R  LAM");
        assertTrue(cse701.getTitle().contains("IENT P(ROG)R  LA"));
    }

    @Test
    public void tc_607getDescription(){
        assertTrue(phy202.getDescription().contains("Electricity and Magnetism"));
    }

    @Test
    public void tc_608setDescription(){
        phy202.setDescription("kuantum belgeseli");
        assertTrue(phy202.getDescription().contains("kuantum belgeseli"));
    }

    @Test
    public void tc_609getTeacher(){
        assertTrue(cse101.getTeacher() == jl);
        assertTrue(cse102.getTeacher() == null);
    }

    @Test
    public void tc_610setTeacher(){
        phy202.setTeacher(dk);
        assertTrue(phy202.getTeacher() == dk);
        try{
            phy202.setTeacher(jl);
        }catch (Exception e){
            assertTrue(e.getClass().getName().contains("DepartmentMismatchException"));
        }
    }

    @Test
    public void tc_611getAKTS(){
        assertTrue(cse101.getAKTS() == 6);
    }

    @Test
    public void tc_612setAKTS(){
        phy202.setAKTS(11);
        assertTrue(phy202.getAKTS() == 11);
    }

    @Test
    public void tc_613getPrerequisite(){
        assertTrue(cse102.getPrerequisite() == cse101);
        assertTrue(cse101.getPrerequisite() == null);
    }

    @Test
    public void tc_614setPrerequisite(){
        cse701.setPrerequisite(cse101);
        assertTrue(cse701.getPrerequisite() == cse101);
    }

    @Test
    public void Qtc_615addStudent(){
        cse101.addStudent(ua);
        cse101.addStudent(ka);
        cse101.setTeacher(jl);
        jl.changeGrade(cse101,ua,78);
        cse102.addStudent(ua);
        cse701.addStudent(tya);
        phy201.addStudent(tya);
        assertTrue(tya.courseList().contains("CSE 701"));
        assertTrue(ua.courseList().contains("CSE 102"));
        assertTrue(ua.courseList().contains("CSE 101"));
        assertTrue(ka.courseList().contains("CSE 101"));
        try{
            cse102.addStudent(ka);
        }catch (Exception e){
            assertTrue(e.getClass().getName().contains("PrerequisiteNotPassedException"));
        }
        try{
            phy201.setTeacher(dk);
            phy201.addStudent(ua);
            dk.changeGrade(phy201,ua,59);
            phy202.addStudent(ua);
        }catch (Exception e){
            assertTrue(e.getClass().getName().contains("PrerequisiteNotPassedException"));
        }
        try {
            cse701.addStudent(ua);
        }catch (Exception e){
            assertTrue(e.getClass().getName().contains("NotGradStudentException"));
        }
    }

    @Test
    public void Qtc_616changeGrade(){
        cse101.addStudent(ua);
        cse101.addStudent(ka);
        cse101.changeGrade(ua,80);
        assertTrue(ua.getGPA() == 3.0);
        cse101.changeGrade(ua,59);
        assertTrue(ua.getGPA() == 1.5);
        cse701.addStudent(aa);
        cse701.changeGrade(aa,69);
        assertTrue(aa.getGPA() == 1.5);
        try{
            cse701.changeGrade(tya,45);
        }catch (Exception e){
            assertTrue(e.getClass().getName().contains("StudentNotEnrolledException"));
        }
        try{
            phy201.changeGrade(ka,45);
        }catch (Exception e){
            assertTrue(e.getClass().getName().contains("StudentNotEnrolledException"));
        }
    }

    @Test
    public void tc_617getCourseCode(){
        System.out.println(cse701.getCourseCode());
        assertTrue(cse701.getCourseCode().contains("CSE 701"));
        assertTrue(phy201.getCourseCode().contains(" 201"));
    }

    @Test
    public void tc_618studentList(){
        cse101.addStudent(ua);
        cse101.addStudent(ka);
        cse101.addStudent(tya);
        assertTrue(cse101.studentList().toLowerCase().contains("ugur "));
        assertTrue(cse101.studentList().toLowerCase().contains("20181654"));
        assertTrue(cse101.studentList().toLowerCase().contains("aha yi"));
        assertTrue(cse101.studentList().toLowerCase().contains(" -> kursat akyel"));
    }
}