import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

public class SortingWithGeneric {
    public static void main(String[] args){
        // Create an Integer array
        Integer[] listArray = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

        // Carate a Double array
        Double[] doubleArray = {3.4, 1.3, -22.1, 14.8, 6.0, 2.3, 12.2};

        // Create a Character array
        Character[] charArray = {'a', 'J', 'r'};

        // Create a String array
        String[] stringArray = {"Tom", "Susan", "Kim"};

        // Sort the arrays
        mergeSort(listArray);
        mergeSort(doubleArray);
        mergeSort(charArray);
        mergeSort(stringArray);

        printList(listArray);
        printList(charArray);
        printList(stringArray);
        printList(doubleArray);

        // Create an array of 10 GeometricObjects
        GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
                new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5),
                new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
                new Circle(6.5), new Rectangle(4, 5)};

        // Invoke bubble sort using GeometricObjectComparator
        bubbleSort(list, new GeometricObjectComparator());

        // Display the sorted elements
        printList(list);
    }

    public static <E> void quickSort(E[] o, Comparator<? super E> comparator){
        quickSort(o, 0, o.length - 1, comparator);
    }

    public static <E> void quickSort(E[] o, int first, int last, Comparator<? super E> comparator){
        if(last > first){
            int pivotIndex = partition(o, first, last, comparator);
            quickSort(o, first, pivotIndex - 1, comparator);
            quickSort(o, pivotIndex + 1, last, comparator);
        }
    }

    public static <E> int partition(E[] o, int first, int last, Comparator<? super E> comparator){
        E pivot = o[first];
        int low = first + 1;
        int high = last;

        while(high > low){
            while(low <= high && comparator.compare(o[low], pivot) <= 0)
                low++;

            while(low <= high && comparator.compare(o[low], pivot) > 0)
                high--;

            if(high > low){
                E temp = o[high];
                o[high] = o[low];
                o[low] = temp;
            }
        }

        while (high > low && comparator.compare(o[high],pivot) >= 0)
            high--;

        if(comparator.compare(pivot, o[high]) > 0){
            o[first] = o[high];
            o[high] = pivot;
            return high;
        }
        else{
            return first;
        }

    }

    public static <E extends Comparable<E>> void merge(E[] o1, E[] o2, E[] temp){
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;

        while(current1 < o1.length && current2 < o2.length){
            if(o1[current1].compareTo(o2[current2]) < 0)
                temp[current3++] = o1[current1++];
            else
                temp[current3++] = o2[current2++];
        }

        while(current1 < o1.length)
            temp[current3++] = o1[current1++];

        while(current2 < o2.length)
            temp[current3++] = o2[current2++];
    }

    public static <E extends Comparable<E>> void mergeSort(E[] o){
        if(o.length > 1){
            E[] firstHalf = (E[])new Comparable[o.length / 2];
            System.arraycopy(o,0,firstHalf,0,o.length / 2);
            mergeSort(firstHalf);

            int secondHalfLength = o.length - o.length / 2;
            E[] secondHalf = (E[])new Comparable[secondHalfLength];
            System.arraycopy(o,o.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            merge(firstHalf, secondHalf, o);
        }
    }

    public static <E extends Comparable<E>> void bubbleSort(E[] o){
        boolean needNextPass = true;
        for(int k = 1; k < o.length && needNextPass; k++){
            needNextPass = false;
            for(int i = 0; i < o.length - k; i++){
                if(o[i].compareTo(o[i + 1]) > 0){
                    E temp = o[i];
                    o[i] = o[i + 1];
                    o[i + 1] = temp;

                    needNextPass = true;
                }
            }
        }
    }

    public static <E> void bubbleSort(E[] o, Comparator<? super E> comparator){
        boolean needNextPass = true;
        for(int k = 1; k < o.length && needNextPass; k++){
            needNextPass = false;
            for (int i = 0; i < o.length - k; i++){
                if(comparator.compare(o[i], o[i + 1]) > 0){
                    E temp = o[i];
                    o[i + 1] = o[i];
                    o[i] = temp;

                    needNextPass = true;
                }
            }
        }
    }

    public static void printList(Object[] list) {
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
        System.out.println();
    }

    /** Print the sorted elements */
    public static void printList(GeometricObject[] list) {
        System.out.print("Sorted elements: ");
        for (GeometricObject e: list) {
            System.out.printf("%.2f ", e.getArea());
        }
        System.out.println();
    }
}

class GeometricObjectComparator implements Comparator<GeometricObject>, Serializable{

    @Override
    public int compare(GeometricObject t1, GeometricObject t2) {
        double area1 = t1.getArea();
        double area2 = t2.getArea();

        if(area1 > area2)
            return 1;
        else if(area1 == area2)
            return 0;
        else
            return -1;
    }
}

abstract class GeometricObject{
    private String color;
    private boolean filled;
    private Date dateCreated;

    protected GeometricObject(){
        dateCreated = new Date();
    }

    protected GeometricObject(String color, boolean isFilled){
        this.color = color;
        this.filled = isFilled;
        dateCreated = new Date();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String toString(){
        return "created on " + dateCreated + "\ncolor: " + color +
                " and filled: " + filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}

class Circle extends GeometricObject{
    private double radius;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean isFilled, double radius) {
        super(color, isFilled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }

    public String toString(){
        return super.toString() + ", Circle, Created: "
                + getDateCreated() + ", Radius: " + radius;
    }
}

class Rectangle extends GeometricObject{
    private double height;
    private double width;

    public Rectangle(){

    }

    public Rectangle(double height, double width){
        this.height = height;
        this.width = width;
    }

    public Rectangle(
            double width, double height, String color, boolean filled) {
        this.width = width;
        this.height = height;
        setColor(color);
        setFilled(filled);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getArea(){
        return height * width;
    }

    @Override
    public double getPerimeter(){
        return 2 * (height + width);
    }

    public String toString() {
        return super.toString() + " Rectangle, Created: "
                + getDateCreated() + ", Width: " + width +
                ", Height: " + height;
    }
}
