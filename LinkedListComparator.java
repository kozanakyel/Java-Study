import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author: Uğur Akyel
 * @since: 08/05/2020
 * */

/**
 * Solution: I created a LinkedListComparator that implements Comparator İnterface
 *      and its parameter 2 LinkedList<Integer>, then i added for each list's values
 *      So i should compare list's summation. Also I created a method it's name is max
 *      return type LinkedList<Integer> and includes two parameter, then again compare
 *      this two list with comparator interface.
 *       In the main class i create a two list and additionally one list for comprataor list.
 *       In conclusion i can compare this two list and i showed result. if the one list
 *       is null and the other has a negative value programs will show to a null list, i tried.
 * */

public class Lab08_20190808020 {
    public static void main(String[] args){
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(5);
        list1.add(25);
        list1.add(85);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(11);
        list2.add(57);
        list2.add(-74);

        LinkedList<Integer> list =
                max(list1, list2, new LinkedListComparator());
        System.out.println(list);
    }

    public static LinkedList<Integer> max(
            LinkedList<Integer> list1, LinkedList<Integer> list2,
                Comparator<LinkedList<Integer>> list) {
        if (list.compare(list1, list2) > 0)
            return list1;
        else
            return list2;
    }
}

class LinkedListComparator implements Comparator<LinkedList<Integer>>,
        java.io.Serializable{
    public int compare(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        int sum1 = 0;
        for(int i = 0; i < list1.size(); i++){
            sum1 += list1.get(i);
        }

        int sum2 = 0;
        for(int i = 0; i < list2.size(); i++){
            sum2 += list2.get(i);
        }

        if (sum1 < sum2)
            return -1;
        else if (sum1 == sum2)
            return 0;
        else
            return 1;
    }
}
