
package testcirclerectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TestCircleRectangle extends Employee{

    public static void main(String[] args) {
        CircleFromSimpleGeometricObject circle = new 
            CircleFromSimpleGeometricObject(1, "red", true);
        System.out.println("A circle " + circle.toString());
        System.out.println("The color is " + circle.getColor());
        System.out.println("The radius is " + circle.getRadius());
        System.out.println("The area is " + circle.getArea());
        System.out.println("The perimeter is " + circle.getPerimeter());
        System.out.println("The diameter is " + circle.getDiameter());
        
        RectangleFromSimpleGeometricObject rectangle = new 
            RectangleFromSimpleGeometricObject(2, 4);
        System.out.println("\nA rectangle " + rectangle.toString());
        System.out.println("The area is " + rectangle.getArea());
        System.out.println("The perimeter is " + rectangle.getPerimeter());
        System.out.println("toString " + rectangle.toString());
        System.out.println(rectangle);
        
        System.out.println();
        new TestCircleRectangle();
        
        //polymorphism
        System.out.println();
        displayObject(new CircleFromSimpleGeometricObject(1, "red", false));
        displayObject(new RectangleFromSimpleGeometricObject(1, 
                1, "black", true));
        
        int[] list3 = {1, 2, 3};
        //printArray(list3); // wrong implement
        
        System.out.println();
        Object o = new Person(); //implicit casting
        //b and o point to the same object...
        Person b = (Person)o; //explicit casting
        
        Object myObject = new CircleFromSimpleGeometricObject();
        // perform casting if myObject is an instance of Circle
        //instanceof java keyword
        if(myObject instanceof CircleFromSimpleGeometricObject){
            System.out.println("The circle diameter is " + 
                    ((CircleFromSimpleGeometricObject)myObject).getDiameter());
        }
        
        Object object1 = new CircleFromSimpleGeometricObject(1);
        Object object2 = new RectangleFromSimpleGeometricObject(1, 1);
        
        displayObject(object2);
        displayObject(object1);
        
        object1.equals(object2);
        
        /*
         *ARRAYLIST<E> unlimited object storing
        */
        System.out.println();
        ArrayList<String> cityList = new ArrayList<>();
        
        cityList.add("London");
        cityList.add("Denver");
        cityList.add("Paris");
        cityList.add("Adana");
        cityList.add("Bodrum");
        cityList.add("Malatya");
        //Contains[london, denver, paris, adana, bodrum, malatya]
        
        System.out.println("List size " + cityList.size());
        System.out.println("is Denver is the list " 
                + cityList.contains("Denver"));
        System.out.println("The location denver is the list " 
                + cityList.indexOf("Denver")); //if not exist return -1
        System.out.println("is the list empty? " + cityList.isEmpty());
        
        cityList.add(2, "Kozan");
        //Contains[london, denver, kozan....]
        cityList.remove("Denver");
        cityList.remove(3);
        //cityList.clear();
        cityList.remove(cityList.size() - 1);
        System.out.println(cityList.toString());
        
        for(int i = cityList.size() - 1; i >= 0; i--)
            System.out.println(cityList.get(i) + " ");
        System.out.println();
        
        ArrayList<CircleFromSimpleGeometricObject> list = new ArrayList<>();
        list.add(new CircleFromSimpleGeometricObject(2));
        list.add(new CircleFromSimpleGeometricObject(3));
        
        System.out.println("the area of the circle " + list.get(0).getArea());
        
        //DISTINCTNUMBER
        System.out.println();
        ArrayList<Integer> listInt = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ıntegers (input end with 0); ");
        int value;
        
        do{
            value = input.nextInt();
            if(!listInt.contains(value) && value != 0)
                listInt.add(value);
        }while(value != 0);
        
        for(int i = 0; i < listInt.size(); i++)
            System.out.print(listInt.get(i) + " ");
        
//        for(int number: listInt){
//            System.out.println(number);
//        }
        
        ArrayList<String> n = new ArrayList<>();
        n.add("d");
        n.add("e");
        n.add(new java.util.Date().toString());
        System.out.println(n.get(2));
        
        ArrayList<Integer> m = new ArrayList<>();
        m.add(1);
        m.add(2);
        m.add(3);
        m.remove(1);
        System.out.println(m);
        
        //array den arrayliste geçiş
        String[] array = {"red", "blue", "green"};
        ArrayList<String> listMet = new ArrayList<>(Arrays.asList(array));
        //arraylistten array oluşumu
        String[] array1 = new String[listMet.size()];
        listMet.toArray(array1);
        
        Integer[] array2 = {3, 5, 95, 4, 45, 67, 2};
        ArrayList<Integer> listInteger = new ArrayList<>(Arrays.asList(array2));
        java.util.Collections.sort(listInteger);
        System.out.println(listInteger);
        System.out.println(java.util.Collections.max(listInteger));
        System.out.println(java.util.Collections.min(listInteger));
        java.util.Collections.shuffle(listInteger);
        System.out.println(listInteger);
    }   
    
    public static void printArray(Object[] list){
        for(Object o: list)
            System.out.println(o + " ");
        System.out.println();
    }
    
    public TestCircleRectangle(){
    System.out.println("(4) Performs testcircle s tasks");
    }
    
    public static void displayObject(SimpleGeometricObject object){
        System.out.println("Created on " + object.getDateCreated() + 
            ". Color is " + object.getColor());
    }
    
    //GENERIC PROGRAMMING
    public static void displayObject(Object object){
        if(object instanceof CircleFromSimpleGeometricObject){
            System.out.println("The circle area is " + 
                    ((CircleFromSimpleGeometricObject)object).getArea());
            System.out.println("The diameter area is " + 
                    ((CircleFromSimpleGeometricObject)object).getDiameter());        
        }
        if(object instanceof RectangleFromSimpleGeometricObject){
            System.out.println("The rectangle area is " + 
                    ((RectangleFromSimpleGeometricObject)object).getArea());
            System.out.println("The rectangle perimeter is " + 
                    ((RectangleFromSimpleGeometricObject)object).getPerimeter());
        }
    }
}

class Employee extends Person{
    public Employee(){
        this("(2) Invoke Employee s overloaded constructor");
        System.out.println( "(3) Performs Employee s tasks");
    }
    
    public Employee(String s){
        System.out.println(s);
    }
}

class Person{
    public Person(){//if ther is not exist no-arg cons. the programm not compile
        System.out.println("(1) Performs Persons tasks");
    }
}
