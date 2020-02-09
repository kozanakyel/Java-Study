
package randomthing;


public class RandomThing {

   
    public static void main(String[] args) {
        // display a random uppercase letter, lowercase letter, and number
      char c1 = (char)((('Z'-'A' + 1) * Math.random()) + 'A');
      System.out.print(c1);
      char c2 = (char)((('z'-'a' + 1) * Math.random()) + 'a');
      System.out.print(c2);
      char c3 = (char)((('9'-'0' + 1) * Math.random()) + '0');
      System.out.print(c3);
      
      // display a random number from 1 to 6
    }
    
}
