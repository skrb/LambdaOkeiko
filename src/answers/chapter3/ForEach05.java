package answers.chapter3;

import java.util.Arrays;
import java.util.List;

public class ForEach05 {

    public ForEach05() {
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
        splitWords(texts);

        // 単純にforEachメソッドで置き換え
        splitWordsStream1(texts);
        // forEachメソッドとflatMapメソッドで置き換え
        splitWordsStream2(texts);
        // メソッド参照を使用
        splitWordsStream3(texts);
    }
    
    private void splitWords(List<String> texts) {
        for (String text: texts) {
            // 文字列から単語を切り出す
            // 正規表現を使って、単語間にあるスペースなどを使用して切り出す
            String[] words = text.split(" |\\.|\\,|\\?");
            
            for (String word: words) {
                System.out.println(word);
            }
        }
    }

    private void splitWordsStream1(List<String> texts) {
        texts.forEach(text -> {
            String[] words = text.split(" |\\.|\\,|\\?");
            
            for (String word: words) {
                System.out.println(word);
            }
        });
    }

    private void splitWordsStream2(List<String> texts) {
        texts.stream()
             .flatMap(text -> Arrays.stream(text.split(" |\\.|\\,|\\?")))
             .forEach(word -> {
                 System.out.println(word);
             });
    }

    private void splitWordsStream3(List<String> texts) {
        texts.stream()
             .flatMap(text -> Arrays.stream(text.split(" |\\.|\\,|\\?")))
             .forEach(System.out::println);
    }

    public static void main(String... args) {
        new ForEach05();
    }
}
