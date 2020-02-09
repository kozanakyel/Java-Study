
package mypointmain;

public class MyPoint {
    private double x;
    private double y;
    
    public MyPoint(){
        this(0, 0);
    }
    
    public MyPoint(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
     public double distance(MyPoint myPoint) {
   	return Math.sqrt(Math.pow(myPoint.getX() - x, 2) + 
   			 Math.pow(myPoint.getY() - y, 2));
   }

   /** Returns the distance from this point to another
 	*   point with specified x- and y-coordinates. */
 	public double distance(double x, double y) {
 		return distance(new MyPoint(x, y));  //!!!!!!  important
 	}
}
