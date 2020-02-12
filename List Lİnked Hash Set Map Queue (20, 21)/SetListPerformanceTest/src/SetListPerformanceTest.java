
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;


public class SetListPerformanceTest {
    static final int N = 50000;
    
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++)
            list.add(i);
        Collections.shuffle(list);
        
        Collection<Integer> set1 = new HashSet<>(list);
        System.out.println("HashSet! start time: " + getTestTime(set1) 
                + " end time: " + getRemoveTime(set1));
        
        Collection<Integer> set2 = new LinkedHashSet<>(list);
        System.out.println("LinkedHashSet! start time: " + getTestTime(set2) 
                + " end time: " + getRemoveTime(set2));
        
        Collection<Integer> set3 = new TreeSet<>(list);
        System.out.println("TreeSet! start time: " + getTestTime(set3) 
                + " end time: " + getRemoveTime(set3));
        
        Collection<Integer> list1 = new ArrayList<>(list);
        System.out.println("Array! start time: " + getTestTime(list1) 
                + " end time: " + getRemoveTime(list1));
        
        Collection<Integer> list2 = new LinkedList<>(list);
        System.out.println("Linked! start time: " + getTestTime(list2) 
                + " end time: " + getRemoveTime(list2));
    }
    
    public static long getTestTime(Collection<Integer> c){
        long startTime = System.currentTimeMillis();
        
        for(int i = 0; i < N; i++)
            c.contains((int)(Math.random() * 2 * N));
        
        return System.currentTimeMillis() - startTime;
    }
    
    public static long getRemoveTime(Collection<Integer> c){
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < N; i++)
            c.remove(i);
        
        return System.currentTimeMillis() - startTime;
    }
}
