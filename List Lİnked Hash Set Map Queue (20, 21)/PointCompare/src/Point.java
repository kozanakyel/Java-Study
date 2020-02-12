
public class Point implements Comparable<Point>{
    private double x;
    private double y;
    
    public Point(){
        
    }
    
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public void setY(double y){
        this.y = y;
    }
    
    public void setX(double x){
        this.x = x;
    }
    
    public int compareTo(Point p){
        if(x == p.getX()){
            if(y == p.getY())
                return 0;
            else if(y < p.getY())
                return -1;
            else
                return 1;            
        }
        else{
            if(x > p.getX())
                return 1;
            else
                return -1;
        }            
    }
    
    @Override
    public String toString(){
        return "x: " + getX() + " y: " + getY();
    }
}
