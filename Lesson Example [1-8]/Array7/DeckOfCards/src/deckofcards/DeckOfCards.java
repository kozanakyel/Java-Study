/*
 * author :
 * since  :
 */
package deckofcards;

import static java.lang.System.arraycopy;


public class DeckOfCards {

    public static void main(String[] args) {
        
        
        int[] binaryTest = {0, 1, 5, 78, 102, 122, 452, 587, 986};
        int j = BinarySearch.binarySearch(binaryTest, 12);
        System.out.println(j);
        //varargsdemo
        printMax(34, 3, 2, 3, 56.5);
        printMax(new double[]{1, 2, 3});        
        
        
        int[] deck = new int[52];
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10",
         "Jack", "Queen", "King"};
        
        for(int i = 0; i < deck.length; i++)
            deck[i] = i;
        
        for(int i = 0; i < deck.length; i++){
            int index = (int)(Math.random() * deck.length);
            // shuffling the cards
            int temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
        }
        
        for(int i = 0; i < 4; i++){
            int cardNumber = (int)(Math.random() * deck.length);
            String suit = suits[deck[i] / 13];
            String rank = ranks[deck[i] % 13];
            System.out.println("Card number " + deck[i] + ": " + rank + 
                    " of " + suit);
        }
        
        int[] targetArray = new int[deck.length];
        for(int i = 0; i < targetArray.length; i++)
            targetArray[i] = deck[i];
        
        
        
        //arraycopy method for copying an arrray to another with its contents.
        arraycopy(deck, 0, targetArray, 0, deck.length);
    }
    
    public static int[] reverse(int[] list){
        int[] result = new int[list.length];
        for(int i = 0, j = result.length - 1; i < list.length; i++, j--){
            result[j] = list[i];
        }
        
        return result;
    }
    
    public static void printMax(double... numbers){
        if(numbers.length == 0){
            System.out.println("no argument");
            return;
        }
        double result = numbers[0];
        
        for(int i = 1; i < numbers.length; i++)
            if(numbers [i] > result)
                result = numbers[i];
        
        System.out.println("the max value is " + result);
    }
    
    
}
