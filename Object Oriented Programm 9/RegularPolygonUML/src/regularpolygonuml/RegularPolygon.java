/*
 *UML
REGULAR POLYGON
n : int
side: double
x: double
y: double
RegularPolygon()
RegularPolygon(n: int, side: double)
RegularPolygon(n: int, side: double, x: double, y: double)
setN(newN: int)
setSide(newSide: double)
setX(newX: double)
setY(newY: double)
getN(): int
getSide(): double
getX(): double
getY(): double
getPerimeter(): double
getArea(): double
 */
package regularpolygonuml;

public class RegularPolygon {
    private int n;
    private double side;
    private double x;
    private double y;
    
    RegularPolygon(){
        n = 3;
        side = 1;
        x = y = 0;
    }
    
    RegularPolygon(int newN, double newSide){
        n = newN;
        side = newSide;
        x = y = 0;
    }
    
    RegularPolygon(int newN, double newSide, double newX, double newY){
        n = newN;
        side = newSide;
        x = newX;
        y = newY;
    }
    
    public void setN(int newN){
        n = newN;
    }
    
    public void setSide(double newSide){
        side = newSide;
    }
    
    public void setX(double newX){
        x = newX;
    }
    
    public void setY(double newY){
        y = newY;
    }
    
    public int getN(){
        return n;
    }
    
    public double getSide(){
        return side;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public double getPerimeter(){
        return n * side;
    }
    
    public double getArea(){
        return (n * Math.pow(side, 2) / (4 * Math.tan(Math.PI / n)));
    }
}
