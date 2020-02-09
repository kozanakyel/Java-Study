


public class ComparableMaxObject {
    public static void main(String[] args){
        GeometricObject o1 = new Rectangle(5, 6);
        GeometricObject o2 = new Rectangle(2, 8);
        System.out.println(o1.compareTo(o2));
        System.out.println(o1);
        System.out.println("the bigger ob ject is " + Rectangle.max(o1, o2));
    }
}
