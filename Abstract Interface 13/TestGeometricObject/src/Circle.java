
public class Circle  extends GeometricObject{
    private double radius;
    
    public Circle(){
    }
    
    public Circle(double radius){
        this.radius = radius;
    }
    
    public Circle(double radius, 
            String color, boolean filled){
        super(color, filled); //must be first statement
        this.radius = radius;        
    }
    
    public double getRadius(){
        return radius;
    }
    
    public void setRadius(double radius){
        this.radius = radius;
    }
    
    public double getArea(){
        return radius * radius * Math.PI;
    }
    
    public double getPerimeter(){
        return radius * 2 * Math.PI;
    }
    
    public double getDiameter(){
        return 2 * radius;
    }
    
    public void printCircle(){
        System.out.println("The circle is created " + super.getDateCreated() 
                + " and the radius is " + radius);
    }
    
    //overriding methods withb Simple GeometricObject(toString)...
    @Override
    public String toString(){
        return super.toString() + "\nradius is " + radius;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Circle)
            return radius == ((Circle)o).radius;
        else 
            return this == o;
    }
}
