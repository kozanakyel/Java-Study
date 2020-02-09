
package arraystudy;

import java.util.Scanner;

/** 
 * @Uğur Akyel
 */
public class ArrayStudy {

    public static void main(String[] args) {
        
        //fibonacci with array...
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] fibon = new int[n]; 
        
        fibon[0] = 0;
        fibon[1] = 1;
        for(int i=0; i < fibon.length-2; i++){            
            fibon[i+2] = fibon[i+1] + fibon[i];
            
        }
        for(int i = 0; i < fibon.length; i++)
            System.out.print(fibon[i] + " ");
        
        
            
        
        }
    
}
