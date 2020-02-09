/*
 * @author : Kozanoglu
 */
package recursivelythinking;

import java.io.File;
import java.util.Scanner;

public class RecursivelyThinking {

    public static void main(String[] args) {
        System.out.println(isPalindrom("kayak"));
        
        // Prompt the user to enter a directory or a file
        System.out.print("Enter a directory or a file: ");    
        Scanner input = new Scanner(System.in);
        String directory = input.nextLine();
    
        // Display the size
        System.out.println(getSize(new File(directory)) + " bytes");
        
        //tower of hanoi examples
        System.out.print("Enter number of disks: ");
        int n = input.nextInt();
        System.out.println("The moves are: ");
        moveDisks(n, 'A', 'B', 'C');
    }
    
    //not efficient because it creates new strings for every recursive call
    public static boolean isPalindrome(String s){
        if(s.length() <= 1)
            return true;
        else if(s.charAt(0) != s.charAt(s.length() - 1))
            return false;
        else
            return isPalindrome(s.substring(1, s.length() - 1));
    }
    
    //efficient recursive palindrome method
    public static boolean isPalindrom(String s){
        return isPalindrom(s, 0, s.length() - 1);
    }
    public static boolean isPalindrom(String s, int low, int high){
        if(high <= low)
           return true;
        else if(s.charAt(low) != s.charAt(high))
            return false;
        else
            return isPalindrom(s, low + 1, high - 1);
    }
    
    //recursive sort
    public static void sort(double[] list){
        sort(list, 0, list.length - 1);
    }
    private static void sort(double[] list, int low, int high){
        if(low < high){
            int indexOfMin = low;
            double min =list[low];
            for (int i = low + 1; i <= high; i++){
                if(list[i] < min){
                    min = list[i];
                    indexOfMin = i;
                }
            }
            list[indexOfMin] = list[low];
            list[low] = min;
            
            sort(list, low +1, high);
        }
    }
    
    //recursively directory size
    public static long getSize(File file){
        long size = 0;
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(int i = 0; files != null && i < files.length; i++){
                size += getSize(files[i]);
            }
        }
        else{
            size += file.length();
        }
        return size;
    }
    
    //recursive binarysearch
    public static int recursiveBinarySearch(int[] list, int key){
        int low = 0;
        int high = list.length - 1;
        return recursiveBinarySearch(list, key, low, high);
    } 
    public static int recursiveBinarySearch(int[] list, int key, int low, 
            int high){
        if(low > high)
            return - low - 1;
        int mid = (high + low) / 2;
        if(list[mid] > key)
            return recursiveBinarySearch(list, key, low, mid - 1);
        else if(list[mid] == key)
            return mid;
        else
            return recursiveBinarySearch(list, key, mid + 1, high);
    }
    
    //tower of hanoi disk movement counts
    public static void moveDisks(int n, char fromTower, char toTower, 
            char auxTower){
        if(n == 1)
            System.out.println("Move disk " + n + " from " 
                    + fromTower + " to " + toTower);
        else {
            moveDisks(n - 1, fromTower, auxTower, toTower);
            System.out.println("Move disk " + n + " from " 
                    + fromTower + " to " + toTower);
            moveDisks(n - 1, auxTower, toTower, fromTower);
        }   
    }
}
