
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;


public class TestObjectStreamForArray {
    public static void main(String[] args) 
            throws ClassNotFoundException, IOException{
        int[] numbers = {1, 2, 3, 4, 5};
        String[] strings = {"john", "susan", "kim"};
        
        try(
            ObjectOutputStream output = 
                    new ObjectOutputStream(new 
                        FileOutputStream("array.dat", true));
            ){
            output.writeObject(numbers);
            output.writeObject(strings);
            }
        try(
            ObjectInputStream input =
                    new ObjectInputStream(new FileInputStream("array.dat"));
            ){
            int[] newNumbers = (int[])(input.readObject());
            String[] newStrings = (String[])(input.readObject());
            
            for(int i = 0; i < newNumbers.length; i++)
                System.out.print(newNumbers[i] + " ");
            System.out.println();
            
            for(int i = 0; i < newStrings.length; i++)
                System.out.print(newStrings[i] + " ");
            }
        ////////////RANDOMACCESSFILE
        try(
            RandomAccessFile inout = new RandomAccessFile("inout.dat", "rw");    
            ){
            inout.setLength(0);
            
            for(int i = 0; i < 200; i++)
                inout.writeInt(i);
            
            System.out.println("Current file length is " + inout.length());
            
            inout.seek(0);
            System.out.println("the first number is " + inout.readInt());
            
            inout.seek(1 * 4);
            System.out.println("the second number is " + inout.readInt());
            
            inout.seek(9 * 4);
            System.out.println("the tenth number is " + inout.readInt());
            
            inout.writeInt(555);
            
            inout.seek(inout.length());
            inout.writeInt(999);
            
            System.out.println("the new length is " + inout.length());
            
            inout.seek(10 * 4);
            System.out.println("the eleventh number is " + inout.readInt());
            }
    }
}
