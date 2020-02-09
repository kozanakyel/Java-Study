
public abstract class GeometricObject implements Comparable<GeometricObject>{
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;
    
    public GeometricObject(){
        dateCreated = new java.util.Date();
    }
    
    public GeometricObject(String color, boolean filled){
        this.color = color;
        this.filled = filled;
        dateCreated = new java.util.Date();
    }
    
    public String getColor(){
        return color;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    public boolean isFilled(){
        return filled;
    }
    
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    
    public java.util.Date getDateCreated(){
        return dateCreated;
    }
    
    public int compareTo(GeometricObject o){
        if(getArea() > o.getArea())
            return 1;
        else if(getArea() < o.getArea())
            return -1;
        else
            return 0;
    }
    
    public String toString(){
        return "created on " + dateCreated + "\nis filled? " + filled 
                + "\nwhich color? " + color;
    }
    
    public abstract double getArea();
    public abstract double getPerimeter();
    
    public static GeometricObject max(GeometricObject o1, GeometricObject o2){
        return o1.compareTo(o2) == 1 ? o1 : o2;
    }
}
