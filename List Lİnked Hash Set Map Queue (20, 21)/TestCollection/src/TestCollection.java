
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class TestCollection {
    public static void main(String[] args){
        ArrayList<String> collection1 = new ArrayList<>();
        collection1.add("adana");
        collection1.add("malat");
        collection1.add("paris");
        collection1.add("kozan");
        System.out.println("a list of cities of collection1: ");
        System.out.print(collection1.toString());
        System.out.println("\nis malat in collection " 
                + collection1.contains("malat"));
        
        Collection<String> collection2 = new ArrayList<>();
        collection2.add("seattle");
        collection2.add("portlamd");
        collection2.add("bulls");
        collection2.add("atlanta");
        System.out.println("a list of cities of collection2: ");
        System.out.print(collection2);
        
        ArrayList<String> c1 = (ArrayList<String>)(collection1.clone());
        c1.addAll(collection2);
        System.out.println("a list of cities of collection1 or collection2: ");
        System.out.println(c1);
        
        c1 = (ArrayList<String>)(collection1.clone());
        c1.retainAll(collection2);
        System.out.println("a list of cities of collection1 and collection2: ");
        System.out.print(c1);
        
        /*ITERATOR USING*/
        Iterator<String> iterator = collection2.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next().toUpperCase() + " ");
        }
        System.out.println();
        
        /*ARRAY AND LINKED LIST*/
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(0, 10);
        arrayList.add(3, 30);
        System.out.println("a list of integer of arraylist: ");
        System.out.print(arrayList);
        
        LinkedList<Object> linkedList = new LinkedList<>(arrayList);
        linkedList.add(1, "red");
        linkedList.removeLast();
        linkedList.addFirst("green");
        ListIterator<Object> listIterator = linkedList.listIterator();
        while(listIterator.hasNext()){
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();
        
        listIterator = linkedList.listIterator(linkedList.size());
        while(listIterator.hasPrevious()){
            System.out.print(listIterator.previous() + " ");
        }
        
        /*STATIC METHODS FOR LIST AND COLLECTİON*/
        List<String> list = Arrays.asList("red", "green", "blue");
        Collections.sort(list);
        System.out.println("\n" + list);
        
        List<String> list1 = Arrays.asList("yellow", "red", "green", "blue");
        Collections.sort(list1, Collections.reverseOrder());
        System.out.println(list1);
        
        List<Integer> list2 = 
                Arrays.asList(2, 4, 6, 7, 13, 56, 78, 90);
        System.out.println(Collections.binarySearch(list2, 56));
        
        Collections.binarySearch(list, "bak");
        Collections.reverse(list2);
        Collections.shuffle(list2);
        Collections.copy(list, c1);
        System.out.println(list);
        
        /*static Collection<E> metodları,max,min,disjoint, fill, reverse, copy*/
    }
}
