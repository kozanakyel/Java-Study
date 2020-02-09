
package finalexamstudy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class StackQueueBasicPrinciple {

    public static void main(String[] args) throws FileNotFoundException {
        
          int count = replaceChars("example.txt", 'i', 'u');
          System.out.println("replace count is " + count);
          
          char[] bak = new char[10];
          String[] ner = new String[10];
          int[] queue = new int[10];          
          enqueue(queue, 3);
          enqueue(queue, 6);
          enqueue(queue, 4);
          System.out.println(sizeOf(queue));
          while(!isEmpty(queue)){
              System.out.println(dequeue(queue));
          }
          
          int[] stack = new int[10];          
          push(stack, 3);
          push(stack, 6);
          push(stack, 4);
          System.out.println(sizeOf(stack));
          while(!isEmpty(stack)){
              System.out.println(pop(stack));
          }

        Scanner input = new Scanner(System.in);
        System.out.print("Enter string >> ");
        String word = input.next();
        System.out.print("Enter length >> ");
        int number = input.nextInt();
        
        if(word.length() == number){
            System.out.print(word);
        }
        else if(word.length() > number){
            for(int i= 0; i < number; i++)
                System.out.print(word.charAt(i));
        }
        else{
            int counter = 0;
            while(counter < number){           
                for(int i = 0; i < word.length(); i++){
                    System.out.print(word.charAt(i));
                    counter++;
                    if(counter == number)
                        break;
                }
            }
        }
     

        
    }
    
    public static int replaceChars(String filename, char orig, char rep) 
            throws FileNotFoundException{
        File file = new File(filename);
        Scanner input = new Scanner(file);       
        
        int count = 0;      
        
        String line = input.nextLine();
        input.close();          
        
        for(int i = 0; i < line.length(); i++){
                if(line.charAt(i) == orig){
                    count++;                    
                }
        }
        
        line = line.replace(orig, rep);
        System.out.println(line);
        
        return count;    
    }
    
    public static int sizeOf(int[] queue){
        int size = 0;
        for(int i = 0; i < queue.length; i++){
            if(queue[i] != 0)
                size++;            
        }
        return size;
    }
    
    public static boolean isEmpty(int[] queue){
        int size = 0;
        for(int i = 0; i < queue.length; i++){
           if(queue[i] != 0){
               size++;
           }        
        }
        if(size == 0)
            return true;
        else
            return false;
    }
    
    public static void enqueue(int[] queue, int value){ 
        boolean redAlarm = true;
        if(isEmpty(queue))
            queue[0] = value;
        else if(queue[queue.length - 1] != 0){
            int count = 0;
            while(redAlarm){
                
                if(queue[count] == 0){
                    queue[count] = value;
                    redAlarm = false;
                }
                count++;
            }
        }
        else if(queue[queue.length - 1] == 0){
            int count = queue.length - 1;
            while(redAlarm){
                
                if(queue[count] != 0){
                    queue[count + 1] = value;
                    redAlarm = false;
                }    
                count--;
            }
        }
            
    }
    public static int dequeue(int[] queue){
        
        if(!isEmpty(queue)){
            if(queue[queue.length - 1] == 0){
                for(int i = 0; i < queue.length; i++){
                    if(queue[i] != 0){                        
                        queue[i] = 0;
                        return queue[i + 1];
                    }
                }
            }
            else if(queue[queue.length - 1] != 0){
                for(int i = queue.length - 1; i >= 0; i--){
                    if(queue[i] == 0){
                        queue[i + 1] = 0;
                        if(queue[queue.length - 1] == 0)
                            return queue[0];
                        return queue[i + 2];
                    }
                }
            }
        } 
        System.out.println("list is empty");
        return 0;       
    }
    
    public static void push(int[] stack, int value){
        
        for(int i = stack.length - 1; i >= 0; i--){
            if(stack[i] == 0){
                stack[i] = value;
                break;
            }
        }
    }
    
    public static int pop(int[] stack){
        for(int i = 0; i < stack.length; i++){
            if(stack[i] != 0){
                stack[i] = 0;
                if(stack[stack.length - 1] == 0){
                    return 0;
                }
                return stack[i + 1];
            }
        }
        return 0;    
    }
    
}
