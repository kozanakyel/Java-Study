
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class SetMap {
    public static void main(String[] args) throws FileNotFoundException{
        Set<String> set1 = new LinkedHashSet<>(Arrays.asList(
			"George", "Jim", "John", "Blake", "Kevin", "Michael"));
        Set<String> set2 = new LinkedHashSet<>(Arrays.asList(
			"George", "Katie", "Kevin", "Michelle", "Ryan"));
        
        Set<String> union = new LinkedHashSet<>(set1);
        union.addAll(set2);
        System.out.println(union);
        
        Set<String> difference = new LinkedHashSet<>(set1);
        difference.removeAll(set2);
        
        Set<String> intersection = new LinkedHashSet<>(set1);
        intersection.retainAll(set2);
        
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a text file name
        System.out.print("Enter a text file name: ");
        String fileName = input.next();

        // Check if file exists
        File file = new File(fileName);
        if (!file.exists()) {
                System.out.println("The file " + fileName + " does not exist.");
                System.exit(1);
        }

        // Create a set to store vowels
        Set<Character> set = new HashSet<>(
                Arrays.asList('A', 'E', 'I', 'O', 'U'));
        int vowels = 0; // Counts the number of vowels
        int consonants = 0; // Counts the number of consonants

        // Count the number of vowels and consonants in the file
        try ( // Create an input file
                Scanner inputFile = new Scanner(file);
        ) {
            while (inputFile.hasNext()) {
                String line = inputFile.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    if (set.contains(Character.toUpperCase(line.charAt(i))))
                            vowels++;
                    else if (Character.isLetter(line.charAt(i)))
                            consonants++;
                }
            }
        }

        // Display the number of vowels and consonants in the file
        System.out.println("The file " + fileName + " has " + vowels + 
                " vowels and " + consonants + " consonants.");
        
        //////////////////
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println("Enter a number of integers." 
			+ "\nInput ends when the input is 0:");
        int key;
        while((key = input.nextInt()) != 0){
            if(!map.containsKey(key)){
                map.put(key, 1);
            }
            else{
                int frequency = map.get(key);
                frequency++;
                map.put(key, frequency);
            }
        }
        int max = Collections.max(map.values());
        
        System.out.print("The most occurrences integers are: ");
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() == max){
                System.out.print(entry.getKey() + " ");
            }
        }
        System.out.println();
    }
}
