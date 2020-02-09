
import java.math.BigInteger;

public class ComparableInterface {
    public static void main(String[] args){
        String[] cities = {"boston", "atalanta", "adana", "malama"};
        java.util.Arrays.sort(cities);
        for(String city: cities)
            System.out.print(city + " ");
        System.out.println();
        
        BigInteger[] hugeNumbers = {new BigInteger("6243657843652"), 
            new BigInteger("6546416846548946547"), 
            new BigInteger("658468416841647641647641968")};
        java.util.Arrays.sort(hugeNumbers);
        for(BigInteger hugenum: hugeNumbers)
            System.out.print(hugenum + " ");
        
        ComparableRectangle[] rectangles = {new ComparableRectangle(3.4, 5.7), 
            new ComparableRectangle(5, 9), new ComparableRectangle(4,5), 
            new ComparableRectangle(5.2, 8.1)};
        java.util.Arrays.sort(rectangles);
        for(Rectangle rectangle: rectangles){
            System.out.print(rectangle + " ");
            System.out.println();
        }
    } 
}

class ComparableRectangle extends Rectangle 
        implements Comparable<ComparableRectangle>{
    
    public ComparableRectangle(double width, double height){
        super(width, height);
    }    
    
    public int compareTo(ComparableRectangle o){
        if(getArea() > o.getArea())
            return 1;
        else if(getArea() < o.getArea())
            return -1;
        else 
            return 0;
    }
    
    public String toString(){
        return " area : " + getArea();
    }
}
