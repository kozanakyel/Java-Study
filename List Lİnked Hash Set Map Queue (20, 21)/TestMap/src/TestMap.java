
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


public class TestMap {
    public static void main(String[] args){
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("ali", 30);
        hashMap.put("veli", 31);
        hashMap.put("kalan", 29);
        hashMap.put("ziya", 29);
        System.out.println("display hashMap: ");
        System.out.println(hashMap + "\n");
        
        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("display entries in ascending ordering of key: ");
        System.out.println(treeMap);
        
        Map<String, Integer> linkedHashMap = 
                new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("ali", 30);
        linkedHashMap.put("veli", 31);
        linkedHashMap.put("kalan", 29);
        linkedHashMap.put("ziya", 29);
        
        System.out.println("\nthe age for " + "ali is " 
                + linkedHashMap.get("ali"));
        System.out.println("display entries in linkedHashMap: ");
        System.out.println(linkedHashMap);
    }
}
