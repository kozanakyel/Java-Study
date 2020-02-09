
public class Circle  extends GeometricObject implements Comparable<Circle>{
    private double radius;
    
    public Circle(){
        this(1.0);
    }
    
    public Circle(double radius){
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
        return 2 * radius * Math.PI;
    }
    
    public String toString(){
        return super.toString() + "\nArea: " + getArea() 
                + "\nPerimeter: " + getPerimeter();
    }
    
    @Override
    public int compareTo(Circle c){
        if(this.radius < c.radius)
            return -1;
        else if(this.radius > c.radius)
            return 1;
        else
            return 0;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Circle)
            return this.radius == ((Circle)o).radius;
        else
            return this == o;
        
        // return this.compareTo((Circle)o). == 0;
    }
}
