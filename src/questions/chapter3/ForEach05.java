package questions.chapter3;

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
                
        splitWords(texts);
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

    public static void main(String... args) {
        new ForEach05();
    }
}
