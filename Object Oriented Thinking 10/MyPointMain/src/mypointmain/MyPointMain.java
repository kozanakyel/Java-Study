
package mypointmain;

public class MyPointMain {

    public static void main(String[] args) {
        MyPoint myPoint1 = new MyPoint();
        MyPoint myPoint2 = new MyPoint(10, 30.5);
        
        System.out.println(myPoint1.distance(myPoint2));
    }
    
}
