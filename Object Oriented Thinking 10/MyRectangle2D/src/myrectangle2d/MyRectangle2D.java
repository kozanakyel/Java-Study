
package myrectangle2d;

import java.util.Scanner;

public class MyRectangle2D {

    public static void main(String[] args) {
        MyRectangle r1 = new MyRectangle(2, 2, 5.5, 4.9);

        // Display results
        System.out.println("\nRectangle:");
        System.out.println("Area: " + r1.getArea());
        System.out.println("Perimeter: " + r1.getPerimeter());
        System.out.println((r1.contains(3, 3) ? "Contains" : "Does not contain") + 
                " the point (3, 3).");
        System.out.println(
                (r1.contains(new MyRectangle(4, 5, 10.5, 3.2)) ? "Contains" : 
                        "Does not contain") + " the rectangle with points (4, 5, 10.5, 3.2)");
        System.out.println(
                (r1.overlaps(new MyRectangle(3, 5, 2.3, 5.4)) ? "Overlaps" : 
                "Does not overlap") + " the rectangle with points (3, 5, 2.3, 5.4)");
        
        Scanner input = new Scanner(System.in);
        double[][] points = new double[5][2];
        System.out.print("\nEnter five points: ");
        for(int i = 0; i < points.length; i++){
            for(int j = 0; j < points[i].length; j++){
                points[i][j] = input.nextDouble();
            }
        }
        MyRectangle r52 = MyRectangle.getRectangle(points);
        
    }
    
}
