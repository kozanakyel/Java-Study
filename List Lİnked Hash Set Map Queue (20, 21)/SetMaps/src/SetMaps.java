import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author:kozanakyel
 * */

// NO-Duplicate elements
// AbstractSet provide implementations equals method and hashcode method

public class SetMaps {
    public static void main(String[] args){
        Set<String> set = new HashSet<>();
        set.add("london");
        set.add("paris");
        set.add("new york");
        set.add("san fran");
        set.add("beijing");
        set.add("new york");

        System.out.println(set);

        for (String s: set){
            System.out.print(s.toUpperCase() + " ");
        }

        System.out.println();
        set.forEach(e -> System.out.print(e.toLowerCase() + " "));

        Set<String> set1 = new HashSet<>();

        // Add strings to the set
        set1.add("London");
        set1.add("Paris");
        set1.add("New York");
        set1.add("San Francisco");
        set1.add("Beijing");
        set1.add("New York");

        TreeSet<String> treeSet = new TreeSet<>(set1);
        System.out.println("Sorted tree set: " + treeSet);

        // Use the methods in SortedSet interface
        System.out.println("first(): " + treeSet.first());
        System.out.println("last(): " + treeSet.last());
        System.out.println("headSet(\"New York\"): " +
                treeSet.headSet("New York"));
        System.out.println("tailSet(\"New York\"): " +
                treeSet.tailSet("New York"));

        // Use the methods in NavigableSet interface
        System.out.println("lower(\"P\"): " + treeSet.lower("P"));
        System.out.println("higher(\"P\"): " + treeSet.higher("P"));
        System.out.println("floor(\"P\"): " + treeSet.floor("P"));
        System.out.println("ceiling(\"P\"): " + treeSet.ceiling("P"));
        System.out.println("pollFirst(): " + treeSet.pollFirst());
        System.out.println("pollLast(): " + treeSet.pollLast());
        System.out.println("New tree set: " + treeSet);
    }
}
