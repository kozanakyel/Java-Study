
package basicoopstudies;
import java.util.Random;

public class BasicOOPStudies {
    
    public static void main(String[] args) {
        SimpleCircle Circle1 = new SimpleCircle();
        System.out.println("Circle's 1 radius is : " + Circle1.radius 
                + " Circle's area is : " + Circle1.getArea());
        
        SimpleCircle Circle2 = new SimpleCircle(25);
        System.out.println("Circle's 2 radius is : " + Circle2.radius 
                + " Circle's area is : " + Circle2.getArea());
        
        SimpleCircle Circle3 = new SimpleCircle(125);        
        System.out.println("Circle's 3 radius is : " + Circle3.radius 
                + " Circle's area is : " + Circle3.getArea());
        
        Circle2.radius = 100;
        System.out.println("Circle's 2 radius is : " + Circle2.radius 
                + " Circle's area is : " + Circle2.getArea());
        
        TV tv1 = new TV();
        tv1.turnOn();
        tv1.setChannel(30);
        tv1.setVolume(3);
        
        TV tv2 = new TV();
        tv2.turnOn();
        tv2.channelUp();
        tv2.channelUp();
        tv2.volumeUp();
        
        System.out.println("tv1 channel is " + tv1.channel 
                + " and volume level is " + tv1.volumeLevel);
        
        System.out.println("tv2 channel is " + tv2.channel 
                + " and volume level is " + tv2.volumeLevel);
        
        //reference datafield and null value...
        //int x; or String y; doesnt work in the main class...
        //String y; common runtime error - NullPointerException
        Student student = new Student();
        System.out.println("name? " + student.name);
        System.out.println("age? " + student.age);
        System.out.println("science? " + student.isScienceMajor);
        System.out.println("gender? " + student.gender);
        
        //date class
        java.util.Date date = new java.util.Date();
        System.out.println("the elapsed time " 
                + date.getTime() + " milliseconds");
        System.out.println(date.toString());
        
        //random class
        Random random1 = new Random(2);
        System.out.print("From random1: ");
        for(int i = 0; i < 10; i++)
            System.out.print(random1.nextInt(1000) + " ");
        
        Random random2 = new Random(2);
        System.out.print("\nFrom random2: ");
        for(int i = 0; i < 10; i++)
            System.out.print(random2.nextInt(1000) + " ");
    }  

}

class Student{
        String name;
        int age;
        boolean isScienceMajor;
        char gender;
}