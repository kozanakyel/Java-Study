
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Throwable; //the root class for all exception objects


public class ExceptionHandling {
   public static void main(String[] args){
       Scanner input = new Scanner(System.in);
       
       System.out.print("enter two integer: ");
       int number1 = input.nextInt();
       int number2 = input.nextInt();
       
       try{
           int result = quotient(number1, number2);
           System.out.println("result: " + result);
       }
       catch(ArithmeticException ex){
           System.out.println("Exception: an integer " 
                   + "cannot be divided by zero");
       }
       
       System.out.println("Execution continues... ");
       
       ////////////////////////
       boolean continueInput = true;
       
       do{
           try{
               System.out.print("ENter an integer: ");
               int number = input.nextInt();
               System.out.println("the number is entered: " + number);
               continueInput = false;
           }
           catch(InputMismatchException ex){
               System.out.println("Try Again. (" + "Incorrect "
                       + "input: an integer is required)");
               input.nextLine();
           }
       }while(continueInput);
       
       Object o = null;
       System.out.println(1 / 0);
       
       ////////12.03
       int[] array = getArray();
       
       try{
           System.out.println("the corresponding value " + 
                   array[input.nextInt()]);
       }
       catch(ArrayIndexOutOfBoundsException ex){
           System.out.println("out of bounds");
       }
       
   } 
   
   public static int[] getArray(){
       int[] array = new int[100];
       for(int i = 0; i < array.length; i++){
           array[i] = (int)(Math.random() * 100) + 1;
       }
       return array;
   }
   
   public static int quotient(int number1, int number2){
       if(number2 == 0)
           throw new ArithmeticException("Divisor cannot be zero!");
       
       return number1 / number2;
   }
}
