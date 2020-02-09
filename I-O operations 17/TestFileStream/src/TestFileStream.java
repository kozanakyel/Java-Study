
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class TestFileStream {
    public static void main(String[] args) throws IOException{
        try(
            FileOutputStream output = new FileOutputStream("C:/temp.dat");
            ){
            for(int i = 1; i <= 10; i++)
                output.write(i);                
            }
        try(
            FileInputStream input = new FileInputStream("C:/temp.dat");
            ){
            int value;
            while((value = input.read()) != -1)
                System.out.print(value + " ");
            }
        try(
            DataOutputStream output = 
                    new DataOutputStream(new FileOutputStream("temp.dat"));
            ){
            output.writeUTF("\nJohn");
            output.writeDouble(85.5);
            output.writeUTF("Jim");
            output.writeDouble(81.5);
            output.writeUTF("Ali");
            output.writeDouble(42);
            }
        
        try(
            DataInputStream input = 
                    new DataInputStream(new FileInputStream("temp.dat"));
            ){
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
            }
      try{  
        try(
            DataOutputStream output =
                    new DataOutputStream(new FileOutputStream("test.dat"));
            ){
            output.writeDouble(4.5);
            output.writeDouble(12.5);
            output.writeDouble(45.8);
            }
        try(
            DataInputStream input =
                    new DataInputStream(new FileInputStream("test.dat"));
            ){
            while(true)
                System.out.println(input.readDouble());
            }  
      }
      catch(EOFException ex){
          System.out.println("all data were read");
      }
      catch(IOException ex){
          ex.printStackTrace();
      }
    }
}
