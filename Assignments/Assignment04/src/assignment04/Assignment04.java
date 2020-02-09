
package assignment04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Assignment04 {    
    public static void main(String[] args) throws Exception {   
        
    if (args.length != 1) {
    System.out.println("Usage: java store_20190808020 baseline");
    System.exit(0);
    }

    // inventory txt read and array are filled
    File inventory = new File(args[0] + "_Inventory.txt");
    int size = countInventory(args[0] + "_Inventory.txt");
    String[] item = new String[size];        
    int[] quantity = new int[size];
    double[] price = new double[size];
    getInventory(item, quantity, price, args[0] + "_Inventory.txt");
    item = capitalize(item);

    // customer txt read and arrays are filled
    File customer = new File(args[0] + "_Customer.txt"); 
    int sizeCust = countInventory(args[0] + "_Customer.txt");
    String[] itemCust = new String[sizeCust];        
    int[] quantityCust = new int[sizeCust];        
    getCustomer(itemCust, quantityCust, args[0] + "_Customer.txt");
    itemCust = capitalize(itemCust);        

    //receipt file, valid application, print and total calculation...
    PrintWriter receipt = new PrintWriter(args[0] + "_Receipt.txt");
    receipt.println();
    receipt.println(" *****Customer Receipt****");
    double total = 0;
    for(int i = 0; i < itemCust.length; i++){

        if(linearSearchBinary(item, itemCust[i])){
            if(quantityCust[i] > 0){                    
                    if(validRequest(quantity[linearSearchInt(item, 
                            itemCust[i])], quantityCust[i])){

                      receipt.println(itemCust[i] + " - " + quantityCust[i] 
                      + " * " + price[linearSearchInt(item, itemCust[i])] 
                      + " = " + (quantityCust[i] * 
                              price[linearSearchInt(item, itemCust[i])]));

                        quantity[linearSearchInt(item, itemCust[i])] 
                                -= quantityCust[i];

                        total += quantityCust[i] * 
                        price[linearSearchInt(item, itemCust[i])];
                    }                    
            }           
        }
    }
    receipt.println(" ----------------------------- ");
    receipt.println("Total Due - " + total);
    receipt.close();

    //remaning.txt file is filled
    writeInventory(item, quantity, price, args[0] + "_Remaining.txt");

    //log.txt file is filled
    PrintWriter log = new PrintWriter(args[0] + "_log.txt");        
    for(int i = 0; i < sizeCust; i++){
        if(!linearSearchBinary(item, itemCust[i])){
            log.println("Item " + itemCust[i] + " not found!");
        }
        else{
            if(quantityCust[i] <= 0){
            log.println("ERRORS: Invalid amounts requested. " + 
                    "(" + quantityCust[i] + ")");
            }
            else if(!validRequest(quantity[linearSearchInt(item, 
                    itemCust[i])], quantityCust[i])){

                    log.println("ERRORS: " + itemCust[i] + " - " 
                    + quantityCust[i] + " requested, only " 
                    + quantity[linearSearchInt(item, itemCust[i])] 
                    + " in stock.");
            }            
        }           
    }
    log.close(); 
    
    }
    public static int countInventory(String filename) 
            throws FileNotFoundException{
        File f = new File(filename);
        Scanner input = new Scanner(f);
        int count = 0;
        while(input.hasNext()){
            input.nextLine();
            count++;
        }
        return count;
    }
    
    public static void getInventory(String[] item, int[] quantity, 
            double[] price, String filename) throws FileNotFoundException{
        File f = new File(filename);
        Scanner input = new Scanner(f);              

        for(int i = 0; i < item.length; i++){
            item[i] = input.next();
            quantity[i] = input.nextInt();
            price[i] = input.nextDouble();
        }        
    }
    
    public static void writeInventory(String[] item, int[] quantity, 
            double[] price, String filename) throws FileNotFoundException{       
        PrintWriter output = new PrintWriter(filename);
        for(int i = 0; i < item.length; i++){
            output.print(item[i]);
            output.print(" " + quantity[i]);
            output.println(" " + price[i]);
        }
        output.close();
    }
    
    public static String[] capitalize(String[] arr){
        String[] result = new String[arr.length];
        for(int i = 0; i < arr.length; i++){
            result[i] = arr[i].substring(0, 1).toUpperCase() 
                    + arr[i].substring(1).toLowerCase();
        }
        return result;
    }
    
    public static void getCustomer(String[] item, int[] quantity, 
            String filename) throws FileNotFoundException{
        File f = new File(filename);
        Scanner input = new Scanner(f);              

        for(int i = 0; i < item.length; i++){
            item[i] = input.next();
            quantity[i] = input.nextInt();            
        }        
    } 
    
    public static boolean linearSearchBinary(String[] array, String key) {
	for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(key))
		return true;
            }
	return false;
    }
    
    public static boolean validRequest(int quantity, int request){
        if(request > 0 && quantity >= request)
            return true;        
        else{            
            return false;
        }           
    }
    
    public static int linearSearchInt(String[] array, String key) {
	for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(key))
                return i;
            }
	return -1;
    }
}
