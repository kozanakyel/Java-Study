//modified private module
package testcirclewithprivatedatafields;

public class TestCircleWithPrivateDataFields {
    private static int i = 0;
    private static int j = 0;
    public static void main(String[] args) {
        
        CircleWithPrivateDataFields myCircle = 
                new CircleWithPrivateDataFields(5.0);
        System.out.println("rad: " + myCircle.getRadius() 
                + " is " + myCircle.getArea());
        /// myCircle.radius =2;  - KULLANILAMAZ BECAUSE OF PRİVATE DATA FİELD
        myCircle.setRadius(myCircle.getRadius() * 1.1);
        System.out.println("rad: " + myCircle.getRadius() 
                + " is " + myCircle.getArea());
        System.out.println("objects number : " 
                + CircleWithPrivateDataFields.getNumberOfObjects());
        
        printCircle(myCircle);
        
        //pass a objects to a method!!!!!!
        CircleWithPrivateDataFields myCircle2 = 
                new CircleWithPrivateDataFields(1);
        int n = 5;
        
        printAreas(myCircle2, n); 
        
        
        CircleWithPrivateDataFields[] circleArray;
        circleArray = createCircleArray();
        
        printCircleArray(circleArray);
        
        int i = 2;
        int k = 3;
        {
            int j = 3;
            System.out.println("i + j is " + i + j);
        }
        k = i + j;
        System.out.println("k is " + k);
        System.out.println("j is " + j);
    } 
    
    
    public static CircleWithPrivateDataFields[] createCircleArray(){
        CircleWithPrivateDataFields[] circleArray = 
                new CircleWithPrivateDataFields[5];
        
        for(int i = 0; i < circleArray.length; i++){
            circleArray[i] = 
                    new CircleWithPrivateDataFields(Math.random() * 100);
        }
        
        return circleArray;
    }
    
    public static void printCircleArray(
            CircleWithPrivateDataFields[] circleArray){
        System.out.printf("%-30s%-15s\n", "Radius", "Area");
        for(int i = 0; i < circleArray.length; i++){
            System.out.printf("%-30s%-15s\n", circleArray[i].getRadius(), 
                    circleArray[i].getArea());
        }
        System.out.println("----------------------------------------------");
        System.out.printf("%-30s%-15s\n", "The total narea of circle is", 
                sum(circleArray));
    }
    
    public static double sum(CircleWithPrivateDataFields[] circleArray){
        double sum = 0;
        
        for(int i = 0; i < circleArray.length; i++)
            sum += circleArray[i].getArea();
        
        return sum;
    }
    
    public static void printAreas(CircleWithPrivateDataFields c, int times){
        System.out.println("RAdius \t\tArea");
        while(times >= 1){
            System.out.println(c.getRadius() + "\t\t" + c.getArea());
            c.setRadius(c.getRadius() + 1);
            times--;
        }
    }
    
    public static void printCircle(CircleWithPrivateDataFields c){
       System.out.println("rad: " + c.getRadius()+ " is " + c.getArea()); 
    }
}

