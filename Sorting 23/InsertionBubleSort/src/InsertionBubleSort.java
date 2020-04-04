
/*
* @author: kozanakyel
* @since: 08.03.2020
* */

public class InsertionBubleSort {
    public static void main(String[] args){
        int[] a = {2, 5, 3, 15, 43, 14, 8, 10};
        InsertionBubleSort.InsertionSort(a);

        selectionSort(a);

        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }

        int[] list = {2, 4, 45, 23, 456, 7, 81};
        bubbleSort(list);
        System.out.println();
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }

    public static void InsertionSort(int[] list){
        //control variable i
        for(int i = 1; i < list.length; i++){
            int currentElement = list[i];
            int k;
            for(k = i - 1; k >= 0 && list[k] < currentElement; k--){
                list[k + 1] = list[k];
            }
            list[k + 1] = currentElement;
        }
    }

    public static void bubbleSort(int[] list){
        boolean needNextPass = true;

        for(int k = 1; k < list.length && needNextPass; k++){
            needNextPass = false;
            //her seferinde bastan sona kadar gitmemesi için...
            for(int i = 0; i < list.length - k; i++){
                if(list[i] < list[i + 1]){
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    needNextPass = true;
                }
            }
        }
    }

    public static  void  selectionSort(int[] array){
        for(int i = 0; i < array.length; i++){
            int min = array[i];
            int minIndex = i;
            for(int j = i + 1; j < array.length; j++){
                if(min < array[j]){
                    min = array[j];
                    minIndex = j;
                }
            }
            if(minIndex != i){
                array[minIndex] = array[i];
                array[i] = min;
            }
        }
    }

}
