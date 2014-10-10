package questions.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Collect06 {

    public Collect06() {
        List<String> words = Arrays.asList("Java", "JavaScript", "Pearl", "Ruby", "PHP");
                
        Map<String, Integer> groups = groupWords(words);
        System.out.println(groups);
    }
    
    private Map<String, Integer> groupWords(List<String> words) {
        Map<String, Integer> groups = new HashMap<>();
        
        for (String word: words) {
            String key = word.substring(0, 1);
            Integer count = groups.getOrDefault(key, 0);
            count++;
            groups.put(key, count);
        }
        
        return groups;
    }

    public static void main(String... args) {
        new Collect06();
    }
}
