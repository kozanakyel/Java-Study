
import java.util.ArrayList;

public class GenericExercise {
    public static void main(String[] args){
        
    }
    
    public static <E extends Comparable<E>> 
            ArrayList<E> removeDuplicate(ArrayList<E> list){       
        for(int i = 0; i < list.size(); i++){
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(i).compareTo(list.get(j)) == 0)
                    list.remove(j);
            }
        }
        return list;
    }
            
    public static <E extends Comparable<E>> 
            int linearSearch(E[] list, E key){
        for(int i = 0; i < list.length; i++){            
            if(key.compareTo(list[i]) == 0)
                return i;            
        } 
        return -1;
    }
            
    public static <E extends Comparable<E>> E max(E[] list) {
        E max = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i].compareTo(max) > 0)
                max = list[i];
        }
        return max;
    }
    
    public static <E extends Comparable<E>> E max(E[][] list) {
        E max = list[0][0];
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if (list[i][j].compareTo(max) > 0)
                    max = list[i][j];
            }
        }
        return max;
    }

    public static <E extends Comparable<E>>
                int binarySearch(E[] list, E key) {
        int low = 0;
        int high = list.length - 1;

        while (high >= low) {
            int mid = (low + high / 2);
            if (key.compareTo(list[mid]) < 0)
                high = mid - 1;
            else if (key.compareTo(list[mid]) == 0)
                return mid;
            else
                low = mid + 1;
        }

        return -low - 1;
    }
                
    public static <E> void shuffle(ArrayList<E> list) {
        for (int i = 0; i < list.size(); i++) {
            int index = (int)(Math.random() * list.size());
            E temp = list.get(i);
            list.set(i, list.get(index));
            list.set(index, temp);
        }
    }
}
