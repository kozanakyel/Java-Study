
package swapchars;

import java.util.Scanner;


public class SwapChars {

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
      System.out.print("Enter a String >> ");
      String s = input.nextLine();
      
      System.out.print("Enter the index of a character >> ");
      int i1 = input.nextInt();

      System.out.print("Enter another index of a character >> ");
      int i2 = input.nextInt();

      System.out.println("The String with swapped characters is:" +
               s.substring(0, i1) + s.charAt(i2) + s.substring(i1+1, i2) +
               s.charAt(i1) + s.substring(i2 + 1)); 
    }
    
}
