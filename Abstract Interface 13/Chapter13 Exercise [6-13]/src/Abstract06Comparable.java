
public class Abstract06Comparable {
    public static void main(String[] args){      
        
        Square s1 = new Square(4);
        s1.howToColor();
        
        GeometricObject g1 = new Square(2);        
        System.out.println(((Square)g1).howToColor());
        
        GeometricObject[] objects = {new Circle(2), new Circle(3.8), 
            new Square(3.2), new Octagon(1.8)};
        
        System.out.println(sumArea(objects));
        System.out.println(sumBasicArea(objects));
    }
    
    public static double sumArea(GeometricObject[] o){
        
        double result = 0;
        
        for(int i = 0; i < o.length; i++){
            if(o[i] instanceof Square)
                result += ((Square)o[i]).getArea();
            else if(o[i] instanceof Circle)
                result += ((Circle)o[i]).getArea();
            else if(o[i] instanceof Octagon)
                result += ((Octagon)o[i]).getArea();
        }
        
        return result;   
    }
    
    public static double sumBasicArea(GeometricObject[] o){
        double result = 0;
        for(int i = 0; i < o.length; i++){
            result += o[i].getArea();
        }
        return result;
    }
}
