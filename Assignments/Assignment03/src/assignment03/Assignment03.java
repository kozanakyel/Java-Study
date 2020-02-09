
package assignment03;

import java.util.Scanner;

public class Assignment03 {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("******  Store Inventory Entry   ******");
                            
        //product 1 information
        System.out.print("Enter the name of product 1: ");
        String product1 = input.next();
        product1 = capitalize(product1);
        System.out.print("Enter the number of " + product1 + " we have: ");
        int product1_Amount = input.nextInt();
        if(product1_Amount < 0)
            product1_Amount = Math.abs(product1_Amount);
        System.out.print("Enter the cost of " + product1 + ": ");
        float product1_Price = input.nextFloat();
        if(product1_Price < 0)
            product1_Price = Math.abs(product1_Price);
        
        //product 2 information
        System.out.print("Enter the name of product 2: ");
        String product2 = input.next();
        product2 = capitalize(product2);
        System.out.print("Enter the number of " + product2 + " we have: ");
        int product2_Amount = input.nextInt();
        if(product2_Amount < 0)
            product2_Amount = Math.abs(product2_Amount);
        System.out.print("Enter the cost of " + product2 + ": ");
        float product2_Price = input.nextFloat();
        if(product2_Price < 0)
            product2_Price = Math.abs(product2_Price);
        
        //product 3 information
        System.out.print("Enter the name of product 3: ");
        String product3 = input.next();
        product3 = capitalize(product3);
        System.out.print("Enter the number of " + product3 + " we have: ");
        int product3_Amount = input.nextInt();
        if(product3_Amount < 0)
            product3_Amount = Math.abs(product3_Amount);
        System.out.print("Enter the cost of " + product3 + ": ");
        float product3_Price = input.nextFloat();
        if(product3_Price < 0)
            product3_Price = Math.abs(product3_Price);
        
        //product 4 information
        System.out.print("Enter the name of product 4: ");
        String product4 = input.next();
        product4 = capitalize(product4);
        System.out.print("Enter the number of " + product4 + " we have: ");
        int product4_Amount = input.nextInt();
        if(product4_Amount < 0)
            product4_Amount = Math.abs(product4_Amount);
        System.out.print("Enter the cost of " + product4 + ": ");
        float product4_Price = input.nextFloat();
        if(product4_Price < 0)
            product4_Price = Math.abs(product4_Price);
        
        System.out.println("******   Customer Entry   ******");
        
        int exist = 0;
        int requestAmount1 = 0, requestAmount2 = 0, requestAmount3 = 0,
                requestAmount4 = 0;
        System.out.print("Welcome to our store, we have the following. ");
        while(exist != 1){
            System.out.println("Please enter what would you like: \n1 - " 
                    + product1 + "\n2 - " + product2 + "\n3 - " + product3 
                    + "\n4 - " + product4 + "\n0 - to checkout");
            int answer = input.nextInt();
            
            if(answer < 0 || answer > 4)
                System.out.println("ERROR Invalid Request");
            
            int request = 0;
            switch(answer){
                case 0 : exist = 1;
                    break;
                case 1 :                     
                    System.out.print("How many " + product1 
                            + " would you like?");            
                    request = input.nextInt();
                    if(request > 0 && validRequest(product1_Amount, request)){
                        requestAmount1 = request;
                        product1_Amount -= request;
                    }
                    else
                        System.out.println("ERROR Invalid request.");
                    break;
                case 2 :                    
                    System.out.print("How many " + product2 
                            + " would you like?");            
                    request = input.nextInt();
                    if(request > 0 && validRequest(product2_Amount, request)){
                        requestAmount2 = request;
                        product2_Amount -= request;
                    }
                    else
                        System.out.println("ERROR Invalid request.");
                    break;
                case 3 :                     
                    System.out.print("How many " + product3 
                            + " would you like?");            
                    request = input.nextInt();
                    if(request > 0 && validRequest(product3_Amount, request)){
                        requestAmount3 = request;
                        product3_Amount -= request;
                    }
                    else
                        System.out.println("ERROR Invalid request.");
                    break;
                case 4 :                    
                    System.out.print("How many " + product4 
                            + " would you like?");            
                    request = input.nextInt();
                    if(request > 0 && validRequest(product4_Amount, request)){
                        requestAmount4 = request;
                        product4_Amount -= request;
                    }
                    else
                        System.out.println("ERROR Invalid request.");
                    break;
            }           
            if(exist == 1)
                break;            
        }  
        
        System.out.println("******   Customer Total   ******");
        
        float totalDue = 0, requestTotal1 = 0, requestTotal2 = 0, 
                requestTotal3 = 0, requestTotal4 = 0;
        if(requestAmount1 > 0){
            requestTotal1 = requestAmount1 * product1_Price;
            System.out.printf("\n%s - %d * %.2f = %.2f", product1, 
                    requestAmount1, product1_Price, requestTotal1);        
        } 
        if(requestAmount2 > 0){
            requestTotal2 = requestAmount2 * product2_Price;
            System.out.printf("\n%s - %d * %.2f = %.2f", product2, 
                    requestAmount2, product2_Price, requestTotal2);
        }
        if(requestAmount3 > 0){
            requestTotal3 = requestAmount3 * product3_Price;
            System.out.printf("\n%s - %d * %.2f = %.2f", product3, 
                    requestAmount3, product3_Price, requestTotal3);
        }
        if(requestAmount4 > 0){
            requestTotal4 = requestAmount4 * product4_Price;
            System.out.printf("\n%s - %d * %.2f = %.2f", product4, 
                    requestAmount4, product4_Price, requestTotal4);
        }
        totalDue = requestTotal1 + requestTotal2 + requestTotal3 
                + requestTotal4;
        
        System.out.printf("\n--------------------------------------"
                + "\n Total Due - %.2f", totalDue);
        
        float amountGiven;
        boolean catching = true;
        while(catching){
            System.out.println("\n\nPlease enter amount given");
            amountGiven = input.nextFloat();
            float moneyReturn = amountGiven - totalDue;
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
        System.out.println(product1 + " - " + product1_Amount);
        System.out.println(product2 + " - " + product2_Amount);
        System.out.println(product3 + " - " + product3_Amount);
        System.out.println(product4 + " - " + product4_Amount);
    }
     public static String capitalize(String name){
        name = name.toUpperCase();
        char first = name.charAt(0);
        String lower = name.substring(1).toLowerCase();
        name = first + lower;
        return name;
    }
    
    public static boolean validRequest(int quantity, int request){
        if(request > 0 && quantity >= request)
            return true;        
        else{            
            return false;
        }           
    }
    
    public static String cashReturned(float cash){      
           String result = "";           
           int m200 = (int)(cash / 200);
           cash %= 200;           
           int m100 = (int)(cash /100);
           cash %= 100;
           int m50 = (int)(cash / 50);
           cash %= 50;
           int m20 = (int)(cash / 20);
           cash %= 20;
           int m10 = (int)(cash / 10);
           cash %= 10;
           int m1 = (int)(cash / 1);
           cash %= 1;
           int m50n = (int)(cash / 0.5);
           cash %= 0.5;
           int m25n = (int)(cash / 0.25);
           cash %= 0.25;
           int m10n = (int)(cash / 0.1);
           cash %= 0.1;
           int m1n = (int)(cash / 0.01);
           cash %= 0.01;
           result = m200 + " - 200\n" + m100 + " - 100\n" + m50 + " - 50\n" 
                   + m20 + " - 20\n" + m10 + " - 10\n" + m1 + " - 1\n" + m50n 
                   + " - 0.50\n" + m25n + " - 0.25\n" + m10n + " - 0.10\n" 
                   + m1n + " - 0.01";
           System.out.println(result);
           return result;      
    }    
}
