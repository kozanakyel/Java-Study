
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class TextForList {
    public static void main(String[] args) throws FileNotFoundException{
        if(args.length != 1){
            System.out.println("Usage: java textfile");
            System.exit(1);
        }
        File fileName = new File(args[0]);
        if(!fileName.exists()){
            System.out.println("file does not exist...");
            System.exit(2);
        }
        List<String> list = new ArrayList<>();
        try(
                Scanner input = new Scanner(fileName);){
            while(input.hasNext()){
                String[] text = input.nextLine().split(" ");
                for(int i = 0; i < text.length; i++){
                    list.add(text[i]);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list);
    }
}
