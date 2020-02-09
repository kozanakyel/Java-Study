
package myrectangle2d;

public class MyRectangle {
    private double x;
    private double y;
    private double width;
    private double height;
    
    MyRectangle(){
        this(0, 0, 1, 1);
    }
    
    MyRectangle(double x, double y, double width, double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public static MyRectangle getRectangle(double[][] points){
        final int COLUMN_X = 0;
        final int COLUMN_Y = 1;
        double[] minMaxX = minMax(points, COLUMN_X);
        double[] minMaxY = minMax(points, COLUMN_Y);
        double x = (minMaxX[1] + minMaxX[0]) / 2;
        double y = (minMaxY[1] + minMaxY[0]) / 2;
        double height = Math.sqrt(Math.pow(minMaxY[1] - minMaxY[0], 2));
        double width = Math.sqrt(Math.pow(minMaxX[1] - minMaxX[0], 2));
        return new MyRectangle(x, y, width, height);
    }
    
    public static double[] minMax(double[][] points, int col){
        double[] minMax = new double[2];
        minMax[0] = minMax[1] = points[0][col];
        for(int i = 0; i < points.length; i++){
            if(points[i][col] < minMax[0])
                minMax[0] = points[i][col];
            if(points[i][col] > minMax[1])
                minMax[0] = points[i][col];
        }
        return minMax;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public double getWidth(){
        return width;
    }
    
    public double getHeight(){
        return height;
    }
    
    public void setX(double x){
        this.x = x;
    }
    
    public void setY(double y){
        this.y = y;
    }
    
    public void setWidth(double width){
        this.width = width;
    }
    
    public void setHeight(double height){
        this.height = height;
    }
    
    public double getArea(){
        return width * height;
    }
    
    public double getPerimeter(){
        return 2 * (width + height);
    }
    
    public boolean contains(double x, double y) {
		return getDistance(this.y, y) <= height / 2 && 
				 getDistance(this.x, x) <= width / 2; 
	}

	/** Returns true if the specified 
	*   rectangle is inside this rectangle */
	public boolean contains(MyRectangle r) {
           return  getDistance(y, r.getY()) + r.getHeight() / 2 <= height / 2 && 
                getDistance(x, r.getX()) + r.getWidth() / 2 <= width / 2 &&
                height / 2 + r.getHeight() / 2 <= height &&
                width / 2 + r.getWidth() / 2 <= width;
	}

	/** Returns true if the specified rectangle 
	*   overlaps with this rectangle */
	public boolean overlaps(MyRectangle r) {
            return !contains(r) && ((x + width / 2 > r.getX() - r.getWidth()) ||
                 (y + height / 2 > r.getY() - r.getHeight())) &&
                 (getDistance(y, r.getY()) < height / 2 + r.getHeight() / 2) && 
                 (getDistance(x, r.getX()) < width / 2 + r.getWidth() / 2);
	}

	/** Return distance */
	private double getDistance(double p1, double p2) {
		return Math.sqrt(Math.pow(p2 - p1, 2));
	}
    
    
}
