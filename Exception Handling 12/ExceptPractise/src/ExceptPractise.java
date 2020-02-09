
import java.util.InputMismatchException;


public class ExceptPractise {
    public static void main(String[] args){
        
        if(args.length != 3){
            System.out.println("usage: java "
                    + "ExceptPractise number1 operand number2");
            System.exit(0);
        }
        int result = 0;
        
        try{
            switch(args[1].charAt(0)){
                case '+' : result =  Integer.parseInt(args[0]) + Integer.parseInt(args[2]);
                     break;
                case '-' : result =  Integer.parseInt(args[0]) - Integer.parseInt(args[2]);
                     break;
                case '.' : result =  Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
                    break;
                case ':' : result =  Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
                    break;
            }
        }
        //mysolution
        catch(InputMismatchException ex){
            for(int i = 0; i < args[0].length(); i++){
                if(!Character.isDigit(args[0].charAt(i))){
                    System.out.println("input mismatch enter the number.");
                }
            }
            for(int i = 0; i < args[2].length(); i++){
                if(!Character.isDigit(args[2].charAt(i))){
                    System.out.println("input mismatch enter the number.");
                }
            }
        }
//        textbook solution
//        catch (NumberFormatException ex) {
//            System.out.println("Wrong Input: " + 
//                    ex.getMessage().substring(ex.getMessage().indexOf("\"") + 1, 
//                            ex.getMessage().lastIndexOf("\"")));
//        }
        
        System.out.println(result);
        
        
    }
}
