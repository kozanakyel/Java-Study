import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapExercises {
    public static void main(String[] args){
        HashMap<String, ArrayList<String>> courses = new HashMap<>();
        courses.put("CSE 102", new ArrayList<String>(Arrays.asList(new String[]{"123", "456","789"})));
        courses.put("CSE 122", new ArrayList<String>(Arrays.asList(new String[]{"123", "56","4589"})));
        System.out.println(courses);
        System.out.println(switch2Map(courses));
    }

    public static HashMap<String, ArrayList<String>> switchMap(HashMap<String, ArrayList<String>> myMap){
        HashMap<String, ArrayList<String>> newMap = new HashMap<>();

        for(Map.Entry<String, ArrayList<String>> entry : myMap.entrySet()){
            ArrayList<String> keyList = new ArrayList<>();
            String key = entry.getKey();
            keyList.add(key);

            ArrayList<String> valueList = entry.getValue();
            for(int i = 0; i < valueList.size(); i++){
                String value = valueList.get(i);
                newMap.put(value, keyList);
            }
        }
        return newMap;
    }

    public static HashMap<String, ArrayList<String>> switch2Map(HashMap<String, ArrayList<String>> myMap){
        HashMap<String, ArrayList<String>> newMap = new HashMap<>();

        for(String i: myMap.keySet()){
            for(String j: myMap.get(i)){
                ArrayList<String> test = newMap.get(j);
                if(test == null || test.size() == 0){
                    newMap.put(j, new ArrayList<String>(Arrays.asList(new String[]{i})));
                } else{
                    newMap.get(j).add(i);
                }
            }
        }
        return newMap;
    }
}
