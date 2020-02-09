
public class Octagon extends GeometricObject 
        implements Comparable<Octagon>, Cloneable{
    
    private double side8;
    
    public Octagon(){
        this(1.0);
    }
    
    public Octagon(double side8){
        this.side8 = side8;
    }
    
    public Octagon(double side8, String color, boolean filled){
        super(color, filled);
        setSide8(side8);
    }
    
    public double getSide8(){
        return side8;
    }
    
    public void setSide8(double side8){
        this.side8 = side8;
    }
    
    public double getPerimeter(){
        return 8 * side8;
    }
    
    public double getArea(){
        return (2 + 4 / Math.sqrt(2)) * side8 * side8;
    }
    
    @Override
    public int compareTo(Octagon o){
        if(this.side8 < o.side8)
            return -1;
        else if(this.side8 > o.side8)
            return 1;
        else
            return 0;
    }
    
    public boolean equals(Object o){
        return this.compareTo((Octagon)o) == 0;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    
    public String toString(){
        return super.toString() + "\nArea: " + getArea() 
                + "\nPerimeter: " + getPerimeter();
    }
}
