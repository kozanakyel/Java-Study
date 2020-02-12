
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


public class TestHashSet {
    public static void main(String[] args){
        //a set does not allow duplicates.
        Set<String> set = new HashSet<>();
        set.add("london");
        set.add("paris");
        set.add("new york");
        set.add("san fransisco");
        set.add("beijing");
        set.add("new york");
        System.out.println(set);
        for(String s: set){
            System.out.print(s.toUpperCase() + " ");
        }
        System.out.println("\n" + set.size());
        set.remove("london");
        Set<String> set2 = new HashSet<>();
        set2.add("london");
        set2.add("sangay");
        set2.add("paris");
        System.out.println(set2.size());
        System.out.println(set2.contains("taipei"));
        set.addAll(set2);
        System.out.println(set);
        set.removeAll(set2);
        System.out.println(set);
        set.retainAll(set2);
        System.out.println(set);
        
        Set<String> set1 = new LinkedHashSet<>();
        set1.add("london");
        set1.add("paris");
        set1.add("new york");
        set1.add("san fransisco");
        set1.add("beijing");
        set1.add("new york");
        System.out.println(set1);
        for(Object element: set1)
            System.out.print(element + " ");
        
        Set<String> set3 = new HashSet<>();
        set3.add("london");
        set3.add("paris");
        set3.add("new york");
        set3.add("san fransisco");
        set3.add("beijing");
        set3.add("new york");
        
        TreeSet<String> treeSet = new TreeSet<>(set3);
        System.out.println(treeSet);
        System.out.println(treeSet.first());
        System.out.println(treeSet.last());
        System.out.println(treeSet.headSet("new york"));
        System.out.println(treeSet.tailSet("new york"));
        System.out.println(treeSet.lower("p"));
        System.out.println(treeSet.higher("p"));
        System.out.println(treeSet.floor("p"));
        System.out.println(treeSet.ceiling("p"));
        System.out.println(treeSet.pollFirst());
        System.out.println(treeSet.pollLast());
        System.out.println(treeSet);
        System.out.println();
        //.HashCode() iki nesne aynı ise false çıkar 
        //cunku listede aynı elementler olamaz
        //treeset ile comparator kullanılabvilir
        
    }
}
