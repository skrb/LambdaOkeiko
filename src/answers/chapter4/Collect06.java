package answers.chapter4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collect06 {

    public Collect06() {
        List<String> words = Arrays.asList("Java", "JavaScript", "Pearl", "Ruby", "PHP");
                
        // for文で記述
        Map<String, Long> groups = groupWords(words);
        System.out.println(groups);

        // 単純にforEachメソッドで置き換え
        groups = groupWordsStream1(words);
        System.out.println(groups);
        // collectメソッドで置き換え
        groups = groupWordsStream2(words);
        System.out.println(groups);
    }
    
    private Map<String, Long> groupWords(List<String> words) {
        Map<String, Long> groups = new HashMap<>();
        
        for (String word: words) {
            String key = word.substring(0, 1);
            Long count = groups.getOrDefault(key, 0L);
            count++;
            groups.put(key, count);
        }
        
        return groups;
    }

    private Map<String, Long> groupWordsStream1(List<String> words) {
        Map<String, Long> groups = new HashMap<>();
        
        words.forEach(word -> {
            String key = word.substring(0, 1);
            Long count = groups.getOrDefault(key, 0L);
            count++;
            groups.put(key, count);
        });
        
        return groups;
    }

    private Map<String, Long> groupWordsStream2(List<String> words) {
        Map<String, Long> groups
                = words.stream()
                       .collect(Collectors.groupingBy(word -> word.substring(0, 1),
                                                      Collectors.counting()));
        
        return groups;
    }

    public static void main(String... args) {
        new Collect06();
    }
}
