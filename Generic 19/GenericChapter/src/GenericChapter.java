
public class GenericChapter {
    public static void main(String[] args){
        Integer[] integers = {1, 2, 3, 4, 5};
        String[] strings = {"ala", "bala", "sapanca"};
        
        GenericChapter.<Integer>print(integers);
        GenericChapter.<String>print(strings);
        print(strings);
        
        Integer[] list = {new Integer("2"), new Integer("4")};
        sort(list);
        
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(-2);
        System.out.print("the max number is " + max(intStack));
    }
    
    public static double max(GenericStack<Integer> stack){
        double max = stack.pop().doubleValue();
        
        while(!stack.isEmpty()){
            double value = stack.pop().doubleValue();
            if(value > max)
                max = value;
        }
        
        return max;
    }
    
    public static <E> void print(E[] list){
        for(int i = 0; i <list.length; i++)
            System.out.println(list[i] + " ");
        System.out.println();
    }
    
    public static void printList(Object[] list){
        for(int i = 0; i < list.length; i++)
            System.out.println(list[i] + " ");
        System.out.println();
    }
    
    public static <E extends Comparable<E>> void sort(E[] list){
        E currentMin;
        int currentMinIndex;
        
        for(int i = 0; i < list.length; i++){
            currentMin = list[i];
            currentMinIndex = i;
            
            for(int j = i + 1; j < list.length; j++){
                if(currentMin.compareTo(list[j]) > 0){
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            
            if(currentMinIndex != i){
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    } 
}
