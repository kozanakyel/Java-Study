
package bigıntegerpuzzle;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigIntegerPuzzle {

    public static void main(String[] args) {        
        //10.16
        int count = 0;
        BigInteger n = new BigInteger("10000000000000000000000000000000000000");
        BigInteger z = new BigInteger("0");
        
        while(count < 10){
            if(z.compareTo(n.remainder(new BigInteger("2"))) == 0 ||
                    z.compareTo(n.remainder(new BigInteger("3"))) == 0){
                System.out.println(n);
                count++;
            }
            n = n.add(new BigInteger("1"));        
        }
        
        //10.17
        BigInteger i = new BigInteger(Long.MAX_VALUE + "");
        BigInteger end = i.add(new BigInteger("10"));
        
        for(i = new BigInteger(Long.MAX_VALUE + "");
                i.compareTo(end) <= 0;
                i = i.add(new BigInteger("1"))){
            System.out.println(i.multiply(i));
        }
        
        //10.18
        BigInteger k = new BigInteger(Long.MAX_VALUE + "");
        int counts = 0;
        final int END_TIME = 5;
        
        while(count <= END_TIME){            
            k = k.add(new BigInteger("1"));
            if(isPrime(k)){
                count++;
                System.out.println(k);
            }
        }
        
        System.out.println("\n The e values for i = 100 to 1000:");
        System.out.println("-----------------------------------");
        System.out.println(" i                e");
        System.out.println("-----------------------------------");
        for (BigDecimal m = new BigDecimal("100"); 
                m.compareTo(new BigDecimal("1000")) <= 0; 
                m = m.add(new BigDecimal("100"))) {
                System.out.println(m + "    " + getE(m));
        }
    }
    
    public static boolean isPrime(BigInteger n){
        for(BigInteger d = new BigInteger("2");
                d.compareTo(n.divide(new BigInteger("2"))) <= 0;
                d = d.add(new BigInteger("1"))){
            if(n.remainder(d).compareTo(new BigInteger("0")) == 0){
                return false;
            }
        }
        return true;
    }
    
    public static BigInteger mersennePrime(BigInteger n) {
        BigInteger two = new BigInteger("2");
        BigInteger x = new BigInteger("2");
        for (BigInteger i = new BigInteger("1"); i.compareTo(n) < 0; 
                i = i.add(new BigInteger("1"))) {
            x = x.multiply(two);
        }
        return x.subtract(new BigInteger("1")); 
    }
    
    public static BigDecimal getE(BigDecimal v) {
        BigDecimal one = new BigDecimal("1");
        BigDecimal e = new BigDecimal("0.0");
        for (BigDecimal i = one; i.compareTo(v) <= 0; i = i.add(one)) {
            BigDecimal denominator = i;
            for (BigDecimal k = i.subtract(one); 
                    k.compareTo(one) >= 1; 
                    k = k.subtract(one)) {
                    denominator = denominator.multiply(k);
            }
            // Use 25 digits of precision
            e = e.add(one.divide(denominator, 25, BigDecimal.ROUND_UP));  
        }
        return e;
    }
}
