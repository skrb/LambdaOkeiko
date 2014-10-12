package answers.chapter4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collect07 {

    public Collect07() {
        List<String> texts = Arrays.asList(
                "Peter Piper picked",
                "a peck of pickled peppers",
                "A peck of pickled peppers",
                "Peter Piper picked.",
                "If Peter Piper picked",
                "a peck of pickled peppers,",
                "Where's the peck of pickled peppers",
                "Peter Piper picked?");
                
        // for文で記述
        Map<String, Long> wordCounters = countWord(texts);
        System.out.println(wordCounters);

        // 単純にforEachメソッドで置き換え
        wordCounters = countWordStream1(texts);
        System.out.println(wordCounters);
        // flatMapメソッドを追加
        wordCounters = countWordStream2(texts);
        System.out.println(wordCounters);
        // mapメソッドを追加
        wordCounters = countWordStream3(texts);
        System.out.println(wordCounters);
        // collectメソッドで置き換え
        wordCounters = countWordStream4(texts);
        System.out.println(wordCounters);
        // メソッド参照を使用
        wordCounters = countWordStream4(texts);
        System.out.println(wordCounters);
    }
    
    private Map<String, Long> countWord(List<String> texts) {
        Map<String, Long> wordCounters = new HashMap<>();
        
        for (String text: texts) {
            // 文字列から単語を切り出す
            // 正規表現を使って、単語間にあるスペースなどを使用して切り出す
            String[] words = text.split(" |\\.|\\,|\\?");

            for (String word: words) {
                word = word.toLowerCase();
                
                Long count = wordCounters.getOrDefault(word, 0L);
                count++;
                wordCounters.put(word, count);
            }
        }
        
        return wordCounters;
    }

    private Map<String, Long> countWordStream1(List<String> texts) {
        Map<String, Long> wordCounters = new HashMap<>();
        
        texts.forEach(text -> {
            // 文字列から単語を切り出す
            // 正規表現を使って、単語間にあるスペースなどを使用して切り出す
            String[] words = text.split(" |\\.|\\,|\\?");

            for (String word: words) {
                word = word.toLowerCase();
                
                Long count = wordCounters.getOrDefault(word, 0L);
                count++;
                wordCounters.put(word, count);
            }
        });
        
        return wordCounters;
    }

    private Map<String, Long> countWordStream2(List<String> texts) {
        Map<String, Long> wordCounters = new HashMap<>();
        
        texts.stream()
             .flatMap(text -> Arrays.stream(text.split(" |\\.|\\,|\\?")))
             .forEach(word -> {
                 word = word.toLowerCase();
                
                 Long count = wordCounters.getOrDefault(word, 0L);
                 count++;
                 wordCounters.put(word, count);
             });
        
        return wordCounters;
    }

    private Map<String, Long> countWordStream3(List<String> texts) {
        Map<String, Long> wordCounters = new HashMap<>();
        
        texts.stream()
             .flatMap(text -> Arrays.stream(text.split(" |\\.|\\,|\\?")))
             .map(word -> word.toLowerCase())
             .forEach(word -> {
                 Long count = wordCounters.getOrDefault(word, 0L);
                 count++;
                 wordCounters.put(word, count);
             });
        
        return wordCounters;
    }

    private Map<String, Long> countWordStream4(List<String> texts) {
        Map<String, Long> wordCounters 
                = texts.stream()
                       .flatMap(text -> Arrays.stream(text.split(" |\\.|\\,|\\?")))
                       .map(word -> word.toLowerCase())
                       .collect(Collectors.groupingBy(word -> word,
                                                      Collectors.counting()));
        
        return wordCounters;
    }

    private Map<String, Long> countWordStream5(List<String> texts) {
        Map<String, Long> wordCounters 
                = texts.stream()
                       .flatMap(text -> Arrays.stream(text.split(" |\\.|\\,|\\?")))
                       .map(String::toLowerCase)
                       .collect(Collectors.groupingBy(word -> word,
                                                      Collectors.counting()));
        
        return wordCounters;
    }

    public static void main(String... args) {
        new Collect07();
    }
}
