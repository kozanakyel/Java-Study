import java.util.Scanner;


public class Solution_2 {
    public static void main(String[] args){
        final int LOW_DEGREE = 0;
        final int HIGH_DEGREE = 360;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter an Angle value; ");
        int degree = input.nextInt();

        System.out.println("Enter an Line1 length: ");
        double line1Length = input.nextDouble();

        System.out.println("Enter Line2 Length: ");
        double line2Length = input.nextDouble();

        try{
            Line line1 = new Line(line1Length);
            Line line2 = new Line(line2Length);
            Angle angle = new Angle(degree);

            double result = vectorProduct(line1, line2, angle);
            System.out.println("The vector product is: " + result);
        }
        catch (IllegalArgumentException ex){
            while(degree < LOW_DEGREE || degree > HIGH_DEGREE){
                if(degree < LOW_DEGREE)
                    degree += HIGH_DEGREE;
                else
                    degree -= HIGH_DEGREE;
            }

            System.out.println(ex);
        }
        finally {
            System.out.println("The Angle value is: " + degree);
        }
    }

    public static double vectorProduct(Line line1, Line line2, Angle angle){
        return line1.getLength() * line2.getLength() * Math.cos(angle.getDegree());
    }

}

class Angle{
    public final int LOW_DEGREE = 0;
    public final int HIGH_DEGREE = 360;
    private int degree;

    public Angle() throws IllegalArgumentException{
        this(0);
    }

    public Angle(int degree) throws IllegalArgumentException{
        setDegree(degree);
    }

    public int getDegree(){
        return degree;
    }

    public void setDegree(int degree)
            throws IllegalArgumentException{
        if(degree >= LOW_DEGREE && degree <= HIGH_DEGREE)
            this.degree = degree;
        else
            throw new IllegalArgumentException(
                    "Degree must be 0 and 360 interval!");
    }

    public String toString(){
        return "The angle value is " + degree + ".";
    }
}

class Line{
    private double length;

    public Line(){
    }

    public Line(double length) throws IllegalArgumentException{
        setlength(length);
    }

    public double getLength(){
        return length;
    }

    public void setlength(double length){
        if(length > 0)
            this.length = length;
        else
            throw new IllegalArgumentException(
                    "Length must be positive");
    }

    public String toString(){
        return "This line's Length is " + length + ".";
    }
}
