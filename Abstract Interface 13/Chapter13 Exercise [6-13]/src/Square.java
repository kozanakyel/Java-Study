
public class Square  extends GeometricObject implements Colorable{
    private double side;
    
    public Square(){
        this(1.0);
    }
    
    public Square(double side, String color, boolean filled) {
		super(color, filled);
		setSide(side);
	}
    
    public Square(double side){
        this.side = side;
    }
    
    public double getSide(){
        return side;
    }
    
    public void setSide(double side){
        this.side = side;
    }
    
    public double getArea(){
        return Math.pow(side, 2);
    }
    
    public double getPerimeter(){
        return 4 * side;
    }
    
    public String toString(){
        return super.toString() + "\nArea: " + getArea() 
                + "\nPerimeter: " + getPerimeter();
    }
    
    public String howToColor(){
        return "Color of all sides ";
    }
}
