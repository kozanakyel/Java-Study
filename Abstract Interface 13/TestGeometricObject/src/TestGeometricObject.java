
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;


public class TestGeometricObject {
    public static void main(String[] args){
        GeometricObject geoObject1 = new Circle(5);
        GeometricObject geoObject2 = new Rectangle(5, 3);
        
        System.out.println("have the same area " 
                + equalArea(geoObject1, geoObject2));
        displayGeometricObject(geoObject1);
        displayGeometricObject(geoObject2);
        
        //////////////////////
        ArrayList<Number> list = new ArrayList<>();
        list.add(45);  //automatically converted to Integer object....
        list.add(3446.54);
        list.add(new BigInteger("316854813546846548964456"));
        list.add(new BigDecimal("2.15644164794674649874684894"));
        
        System.out.println("the largest number is " + getLargestNumber(list));
        
        Number num = new Integer(3);
        Integer x = (Integer)num;
        System.out.println(num.intValue());
        System.out.println(x.compareTo(new Integer(4)));
    }
    
    public static Number getLargestNumber(ArrayList<Number> list){
        if(list == null || list.size() == 0)
            return null;
        
        Number number = list.get(0);
        for(int i = 1; i < list.size(); i++)
            if(number.doubleValue() < list.get(i).doubleValue())
                number = list.get(i);
        
        return number;
    }
    
    public static boolean equalArea(GeometricObject object1, 
            GeometricObject object2){
        return object1.getArea() == object2.getArea();
    }
    
    public static void displayGeometricObject(GeometricObject object){
        System.out.println();
        System.out.println("The area is " + object.getArea());
        System.out.println("The perimeter is " + object.getPerimeter());
    }
}
