
package exercises;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Exercises {

    public static void main(String[] args) throws IOException {
//       ArrayList<Number> list = new ArrayList<>();
//       list.add(45);
//       list.add(48.2);
//       list.add(234);
//       list.add(1);
//       java.util.Collections.shuffle(list);
//       sort(list);
//       System.out.println(list.toString());
//       
//       metX(5);
///////////////////////////////////////////////
//        int[] numbers = {1, 2, 3, 4, 5};
//        java.util.Date dateCreated = new java.util.Date();
//        double var = 5.5;
//        
//        try(
//            ObjectOutputStream output = new ObjectOutputStream(
//                new FileOutputStream("Exercise_17", true));    
//            ){
//            output.writeObject(numbers);
//            output.writeObject(dateCreated);
//            output.writeDouble(var);
//            }
//////////////////////////////////////
//        try(
//            RandomAccessFile inout = 
//               new RandomAccessFile("exercise8", "rw");
//            ){
//                if(inout.length() == 0){
//                    inout.writeInt(1);
//                }
//                else{
//                    int count = inout.readInt();
//                    inout.seek(0);
//                    inout.writeInt(++count);
//                }
//            }
////////////////////////////////////////////

        
    }
    
    public static void metX(int n){
        if(n > 0){
            metX(n - 1);
            System.out.print(n + " ");
            
        }
    }   
    
    public static void sort(ArrayList<Number> list){
        for(int i = 0; i < list.size() - 1; i++){
            int minIndex = 0;
            Number min = list.get(i); 
            for(int j = i + 1; j < list.size(); j++){
                if(min.doubleValue() > list.get(j).doubleValue()){
                    min = list.get(j);
                    minIndex = j;
                }
            }
            if(minIndex != i){
                list.set(minIndex, list.get(i));
                list.set(i, min);
            }
        }
    }
}
