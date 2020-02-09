
package circle2dmain;

public class Circle2D {
    private double radius;
    private double x;
    private double y;
    
    Circle2D(){
        this(1, 0, 0);        
    }
    
    Circle2D(double radius, double x, double y){
        this.radius = radius;
        this.x = x;
        this.y = y;
    }
    
    public double getX(){
        return x; 
    }
    
    public double getY(){
        return y;
    }
    
    public double getRadius(){
        return radius;
    }
    
    public double getArea(){
        return radius * radius * Math.PI;
    }
    
    public double getPerimeter(){
        return 2 * radius * Math.PI;
    }
    
    public boolean contains(double x, double y){
        return radius >= Math.sqrt(Math.pow(this.x - x, 2) 
                + Math.pow(this.y - y, 2));
    }
    
    public boolean contains(Circle2D circle) {
        return Math.sqrt(Math.pow(circle.getX() - x, 2) + 
                Math.pow(circle.getY() - y, 2)) 
                 <= Math.abs(radius - circle.getRadius());
    }

    public boolean overlaps(Circle2D circle) {
        return Math.sqrt(Math.pow(circle.getX() - x, 2) + 
                    Math.pow(circle.getY() - y, 2)) 
                    <= radius + circle.getRadius();
    }
}
