
package basicoopstudies;

class SimpleCircle {
    double radius;
    
    //construct a circle with radius 1 
    SimpleCircle(){
        radius = 1;
    }
    //Construct a circle with a specified radius
    SimpleCircle(double newRadius){
        radius = newRadius;
    }
    
    double getArea(){
        return radius * radius * Math.PI;
    }
    
    double getPerimeter(){
        return 2 * radius * Math.PI;
    }
    
    void setRadius(double newRadius){
        radius = newRadius;        
    }
}
