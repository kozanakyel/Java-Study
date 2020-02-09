// PRIMITIVE WRAPPER CLASS (Integer, Double, Float etc...)
package primitivetypeobjects;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.math.MathContext;


public class PrimitiveTypeObjects {

    public static void main(String[] args) {
        System.out.println(Float.MAX_VALUE);
        System.out.println(new Double(2.5).compareTo(new Double(12.3)));
        System.out.println(new Integer(56).doubleValue());
        
        Double doubleObject = Double.valueOf("12.4");
        
        System.out.println(Integer.parseInt("11", 2));
        System.out.println(Integer.parseInt("12", 8));
        System.out.println(Integer.parseInt("13", 10));
        System.out.println(Integer.parseInt("1A", 16));
        
        // decimal bir syaıyı HEX notation a cevirme
        System.out.println(String.format("%x", 26)); 
        
        int i = (Double.valueOf("23.4")).intValue();
        String s = (Double.valueOf("23.4")).toString();       
        Integer k = Integer.parseInt("23", 8);
        System.out.println(s + " k: " + k); // ??? output: 19 why??
        
        Integer x = new Integer(3);
        System.out.println(x.intValue());
        System.out.println(x.compareTo(new Integer(4)));
        
        Integer[] intArray = {1, 2, 3};
        Integer y = 3 + new Integer(4) + new Integer(6); 
        System.out.println(y);

        BigInteger a = new BigInteger("98460000000000003598643986988543982653");
        BigInteger b = new BigInteger("2");
        BigInteger c = a.remainder(b);  //aritmetik işlemler methodlarla yapılır. add, subtract, divide...
        System.out.println(c);

        // bölünen, virgulden sonraki deger, yuvarlama stili...	
        BigDecimal d = new BigDecimal("1.0");
        BigDecimal e = new BigDecimal("3");
        BigDecimal f = d.divide(e, 20, BigDecimal.ROUND_UP);
        System.out.println(f);

        System.out.println("50! is /n" + factorial(50));
    }
    
    //factoriel
	public static BigInteger factorial(long n){
            BigInteger result = BigInteger.ONE;   //constant => BigInteger.ONE == new BigInteger("1")
            for(int i = 1; i <= n; i++)
                result = result.multiply(new BigInteger(i + ""));

            return result;
	}
}
