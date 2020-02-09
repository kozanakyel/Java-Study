
import java.util.Scanner;


public class ExceptionHex2Dec {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("enter a hex digit: ");
        String hex = input.nextLine();
        
        try{
            System.out.println("the decimal value for hex "
            + hex + " is " + hexToDecimal(hex.toUpperCase()));
        }
        catch(HexFormatException ex){
            System.out.println(ex.getMessage());
        }
        
        int length = 1200000000;
        try{
            byte[] array = new byte[length];
        }
        catch(OutOfMemoryError ex){
            System.out.println(ex.getMessage());
        }
        
        System.out.println("Error handled program continues... ");
    }
    
    public static int hexCharToDecimal(char c){
        if(c >= 'A' && c <= 'F')
            return 10 + c - 'A';
        else
            return c - '0';
    }
    
    public static int hexToDecimal(String hex) throws HexFormatException{
        int decimalValue = 0;
        for(int i = 0; i < hex.length(); i++){
            if(!(hex.charAt(i) >= '0' && hex.charAt(i) <= '9') ||
                    !(hex.charAt(i) >= 'A' && hex.charAt(i) <= 'F'))
                  throw new HexFormatException("String is not a hex string");
            char hexChar = hex.charAt(i);
            decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        }
        
        return decimalValue;
    }
    
    public static int binToDecimal(String bin) throws NumberFormatException{
        int decimalValue = 0;
        for(int i = 0, j = bin.length() - 1; i < bin.length(); i++, j--){
            if(bin.charAt(i) < '0' || bin.charAt(i) > '1')
                throw new NumberFormatException("the string is not binary");
            decimalValue += (Integer.parseInt(String.valueOf(bin.charAt(i)))) 
                    * Math.pow(2, j);
        }
        return decimalValue;
    }
}
