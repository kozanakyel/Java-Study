
public class Solution_1 {
    public static void main(String[] args){

        try {
            /**
             * 1)In this point; Exception in
             * NullPointerException: String null
             * */
            final String comparison = null;
            System.out.println(comparison.equalsIgnoreCase(
                    "Compare me!"));
        }
        catch (NullPointerException ex3){
            System.out.println("Null pointer exception");
        }

        try {
            /**
             * 2)In this point; Exception in
             * IllegalArgumentException: Angle must not 370
             * */
            Angle angle1 = new Angle(370);
        }
        catch (IllegalArgumentException ex4){
            System.out.println("degree cannot be greater than 360");
        }

        try{
            /**3) In this point; Exception in
             * ArrayIndexOutOfBoundsException:
             *Index 10 out of bounds for length 10
             */
            int[] list = new int[10];
            for(int i = 0; i < list.length; i++)
                list[i] = i;
            list[10] = 2;
        }
        catch(ArrayIndexOutOfBoundsException ex1){
            System.out.println("Array index bound exception");
        }

        try {
            /**4)In this point; Exception in
             * ArithmeticException: / by zero
             */
            int first = 4;
            int second = 0;
            int result = first / second;
        }
        catch (ArithmeticException ex2){
            System.out.println("Divisor cannot be zero..");
        }
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
