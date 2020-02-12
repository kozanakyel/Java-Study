
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;


public class PointCompare {
    public static void main(String[] args){
        Point[] points = new Point[100];
        for(int i = 0; i < points.length; i++){
            points[i] = new Point(Math.random() * 5, Math.random() * 5);
        }
        Arrays.sort(points);
        List<Point> list = Arrays.asList(points);
        //System.out.println(list);
        
        Arrays.sort(points, new CompareY());
        List<Point> list2 = Arrays.asList(points);
        //System.out.println(list2);   
        
        List<Integer> list1 = new ArrayList<>();
        for(int i = 0; i < 5000000; i++)
            list1.add(i);
        LinkedList<Integer> listLinked = new LinkedList<>(list1);
        ListIterator<Integer> iterator = list1.listIterator();
        while(iterator.hasNext()){
            iterator.next();
        }
        
        PriorityQueue<String> pr1 = new PriorityQueue<>();
        pr1.offer("muslera");
        pr1.offer("donk");
        pr1.offer("marcao");
        pr1.offer("linnes");
        pr1.offer("belhanda");
        pr1.offer("akbaba");
        
        PriorityQueue<String> pr2 = new PriorityQueue<>(
                Arrays.asList("muslera", "akbaba", "falcao"));
        
        System.out.println(intersection(pr1, pr2));
        System.out.println(difference(pr1, pr2));
        System.out.println(union(pr1, pr2));
        
    }
    
    private static <T> PriorityQueue<T> union(
                PriorityQueue<T> set1, PriorityQueue<T> set2) {
        PriorityQueue<T> union = new PriorityQueue<>(set1);
        union.addAll(set2); 
        return union;
    }
    
    private static <T> PriorityQueue<T> difference(
            PriorityQueue<T> p1, PriorityQueue<T> p2){
        PriorityQueue<T> difference = new PriorityQueue<>(p1);
        difference.removeAll(p2);
        return difference;
    }
    
    private static <T> PriorityQueue<T> intersection(
            PriorityQueue<T> p1, PriorityQueue<T> p2){
        PriorityQueue<T> intersection = new PriorityQueue<>(p1);
        intersection.retainAll(p2);
        return intersection;
    }
}
