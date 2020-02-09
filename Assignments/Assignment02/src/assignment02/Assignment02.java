
package assignment02;

import java.util.Scanner;

public class Assignment02 {

    public static void store(String[] item, int[] quantity, double[] price){
        Scanner input = new Scanner(System.in);     
        System.out.print("Welcome to our store, we have the following. ");
        int[] requestTotal = new int[item.length];
        
        boolean closed = true;
        while(closed){
            System.out.println("Please enter what would you like: ");
            displayMenu(item, price);            
            
            int answer = input.nextInt();
            
            if(answer == 0){
                closed = false;                
            } 
            else if(answer != 0){
                if(answer < 0 || answer > item.length)
                   System.out.println("ERROR Invalid Request");
                else{
                    System.out.print("How many " + item[answer - 1] 
                         + " would you like? ");
                    
                    int request = input.nextInt();            
            
                    if(request > 0 && validRequest(quantity[answer - 1], request)){
                        quantity[answer - 1] -= request;
                        requestTotal[answer - 1] += request;                                                 
                    }
                    else
                        System.out.println("ERROR Invalid request.");
                }
            }            
        }
        
        System.out.println("******   Customer Total   ******");
        double[] totalDue = new double[quantity.length];
        for(int i = 0; i < quantity.length; i++){
            if(requestTotal[i] > 0){
                totalDue[i] = requestTotal[i] * price[i];
                System.out.printf("%s - %d * %.2f = %.2f\n",item[i], 
                        requestTotal[i], price[i], totalDue[i]);
            }
        }
        double total = 0;
        for(int i = 0; i < item.length; i++){
            total += totalDue[i];            
        }
        System.out.printf("\n--------------------------------------"
                + "\n Total Due - %.2f", total);
        
        double amountGiven;
        boolean catching = true;
        while(catching){
            System.out.println("\n\nPlease enter amount given");
            amountGiven = input.nextDouble();
            double moneyReturn = amountGiven - total;
            if(moneyReturn > 0){
                System.out.println("Thank you for your business. "
                   + "your change given is: ");
                cashReturned(moneyReturn);
                catching = false;
            }
            else if(moneyReturn == 0){
                System.out.println("Thank you for your business. "
                        + "Have a good day.");
                catching = false;
            }
            else
                System.out.println("Not enough payment given");
        }        
        System.out.println("\n******   Remaining Amouts   ******");
        
        for(int i = 0; i < item.length; i++){
            if(quantity[i] > 0)
                System.out.println(item[i] + " - " + quantity[i]);
        }
    }
    
    public static void displayMenu(String[] item, double[] price){
        for(int i = 0; i < item.length; i++){
            System.out.println((i+1) + " - for " + item[i] 
                    + " (" + price[i] + ")");
        }
        System.out.println("0 - to checkout");
    }
    
    public static void capitalize(String[] name){
        
        for(int i = 0; i < name.length; i++){
            name[i] = name[i].substring(0, 1).toUpperCase() 
                    + name[i].substring(1).toLowerCase();
        }
    }
    
    public static String capitalize(String name){
        name = name.toUpperCase();
        char first = name.charAt(0);
        String lower = name.substring(1).toLowerCase();
        name = first + lower;
        return name;
    }
    
    public static String[] capitalizeString(String[] name){
        String[] result = new String[name.length]; 
        for(int i = 0; i < name.length; i++){
            name[i] = name[i].substring(0, 1).toUpperCase() 
                    + name[i].substring(1).toLowerCase();
            result[i] = name[i];
        }
        name = result;
        return name;
    }
    
    public static boolean validRequest(int quantity, int request){
        if(request > 0 && quantity >= request)
            return true;        
        else{            
            return false;
        }           
    }
    
    public static void cashReturned(double cash){                    
           int m200 = (int)(cash / 200);
           if(m200 > 0)
               System.out.println(m200 + " - 200");
           cash %= 200;           
           int m100 = (int)(cash /100);
           if(m100 > 0)
               System.out.println(m100 + " - 100");
           cash %= 100;
           int m50 = (int)(cash / 50);
           if(m50 > 0)
               System.out.println(m50 + " - 50");
           cash %= 50;
           int m20 = (int)(cash / 20);
           if(m20 > 0)
               System.out.println(m20 + " - 20");
           cash %= 20;
           int m10 = (int)(cash / 10);
           if(m10 > 0)
               System.out.println(m10 + " - 10");
           cash %= 10;
           int m1 = (int)(cash / 1);
           if(m1 > 0)
               System.out.println(m1 + " - 1");
           cash %= 1;
           int m50n = (int)(cash / 0.5);
           if(m50n > 0)
               System.out.println(m50n + " - 0.5");
           cash %= 0.5;
           int m25n = (int)(cash / 0.25);
           if(m25n > 0)
               System.out.println(m25n + " - 0.25");
           cash %= 0.25;
           int m10n = (int)(cash / 0.1);
           if(m10n > 0)
               System.out.println(m10n + " - 0.1");
           cash %= 0.1;
           int m1n = (int)(cash / 0.01);
           if(m1n > 0)
               System.out.println(m1n + " - 0.01");
           cash %= 0.01;          
                 
    }
    
}
