
package binaryıoexercise;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class BinaryIOExercise {

    public static void main(String[] args) throws IOException {
        if(args.length != 2){
            System.out.println("usage: enter two elements: java .java .utf");
            System.exit(2);
        }
        
        File file = new File(args[0]);
        if(!file.exists()){
            System.out.println("file does not exist.");
            System.exit(1);
        }
        
        try(
            Scanner input = new Scanner(file);
            DataOutputStream output = 
                    new DataOutputStream(new FileOutputStream(args[1]));
            ){
            while(input.hasNext())
                output.writeUTF(input.nextLine());
            }
    }
    
}
