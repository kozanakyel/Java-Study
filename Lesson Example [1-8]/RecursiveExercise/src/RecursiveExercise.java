
import java.math.BigInteger;


public class RecursiveExercise {
    public static void main(String[] args){
        BigInteger n = new BigInteger("-5");
        System.out.println(BigIntFact(n));
        
        System.out.println(GCD(180, 42));
        
        System.out.println(fib(4));
        System.out.println(count);
    }
    
    public static BigInteger BigIntFact(BigInteger big){
        if(big.compareTo(BigInteger.ONE) <= 0)
            return BigInteger.ONE;
        else
            return big.multiply(BigIntFact(big.subtract(BigInteger.ONE)));
    }
    
    public static int GCD(int m, int n){
        if(m % n == 0)
            return n;
        else
            return GCD(n, m % n);
    }
    
    public static double m(int i){
        if(i == 0)
            return 0;
        else if(i == 1)
            return 1;
        else
            return 1 / i + m(i - 1);
    }
    
    public static double k(int i){
        if(i == 0)
            return 0;
        else
            return i / (2 * i + 1) + k(i - 1);
    }
    
    public static double j(int i){
        if(i == 0)
            return 0;
        else
            return i / (i + 1) + j(i - 1);
    }
    
    //count a sınıf içinden erişim saglarız...
    public static int count = 0;
    public static long fib(long i){
        
        count++;
        if(i == 0)
            return 0;
        else if(i == 1)
            return 1;
        else
            return fib(i - 1) + fib(i - 2);
    }
    
    public static void reverseDisplay(int value) {
        if (value < 10) // Base case
            System.out.println(value);
        else { 
            System.out.print(value % 10);
            reverseDisplay(value / 10); // Recursive call
        }
    }
    
    public static void reverseDisplay(String value) {
        if (value.length() == 1) // Base case
            System.out.println(value);
        else {
            System.out.print(value.charAt(value.length() - 1));
            reverseDisplay(value.substring(0, value.length() - 1)); // Recursive call
        }
    }
    
    public static int count(String str, char a) {
        int index = 0;
        int count = 0;
        return count(str, a, index, count);
    }

    /** Helpler count method */
    private static int count(String str, char a, int i, int count) {
        if (i == str.length())
            return count;
        else if (str.charAt(i) == a)
            return count(str, a, ++i, ++count);
        else
            return count(str, a, ++i, count);
    }
    
    public static int sumDigits(long n) {
        return sumDigits(n, 0);
    }

    /* Helper overloaded method */
    private static int sumDigits(long n, int sum) {
        if (n == 0) // Base case
            return sum;
        else // Recursive call
            return sumDigits(n / 10, sum + (int)(n % 10));
    }
    
    public static void reverse2Display(String value) {
        reverse2Display(value, value.length() - 1 );
    }

	/** Helper method */
    private static void reverse2Display(String value, int high) {
        if (high >= 0) {
            System.out.print(value.charAt(high));
            reverse2Display(value, high - 1);
        }
    }
    
    /** Method finds the largest number in an array */ 
    public static int max(int[] list) {
        int max = list[list.length - 1]; // Largest number
        int index = list.length - 1; // List index
        return max(list, index, max);
    }

    /** Overloaded helper method */
    private static int max(int[] list, int index, int max) {
        if (index < 0) // Base case
            return max;
        else if (list[index] > max) { 
            return max(list, index - 1, list[index]); // Recursive call
        }
        else
            return max(list, index - 1, max); // Recursive call
    }
    
    /** Method counts the uppercase letters in a string */
    public static int countUppercase(String str) {
        int count = 0;
        int index = str.length() - 1;
        return countUppercase(str, index, count);
    }

    /** Helper method */
    private static int countUppercase(String str, int index, int count) {
        if (index < 0) // Base case
            return count;
        else if (Character.isUpperCase(str.charAt(index))) 
            return countUppercase(str, index - 1, count + 1); // Recursive call
        else
            return countUppercase(str, index - 1, count); // Recursive call
    }
    
    /** Method counts the number of occurrences 
      * of a specified character in a string */
    public static int counted(String str, char a) {
        return counted(str, a, str.length() - 1);
    }

    /** Helper melthod used to pass the substring high index */
    private static int counted(String str, char a, int high) {
        if (high < 0) // Base case
            return 0;
        else if (str.charAt(high) ==  a) {
            return 1 + counted(str, a, high - 1); // Recursive call
        }
        else
            return counted(str, a, high - 1); // Recursive call
    }
    
    /** Methods converts a decimal number
      * into a binary number as a string */
    public static String dec2Bin(int value) {
        String result = "";
        return dec2Bin(value, result);
    }

    /** Recursive helper method */
    public static String dec2Bin(int value, String result) {
        if (value / 2 == 0) // Base case
            return (value % 2) + result;
        else
            return dec2Bin(value / 2, (value % 2) + result); // Recursive call
    }
}
