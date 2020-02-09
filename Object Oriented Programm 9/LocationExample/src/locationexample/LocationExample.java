
package locationexample;

import java.util.Scanner;

public class LocationExample {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the number of rows and columns: ");
        int rows = input.nextInt();
        int columns = input.nextInt();
        
        double[][] array = new double[rows][columns];
        System.out.println("entyer the Array: ");
        for(int i = 0; i < array.length; i++)
            for(int j = 0; j < array[i].length; j++)
                array[i][j] = input.nextDouble();
        
        Location max = locateLargest(array);
        System.out.println("The location of the largest element is " +
            max.maxValue + " at (" + max.row + ", " + max.column + ")");        
    }
    
    public static Location locateLargest(double[][] a){
        return new Location(a);
    }
}
