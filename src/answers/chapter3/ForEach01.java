package answers.chapter3;

import java.util.Arrays;
import java.util.List;

public class ForEach01 {

    public ForEach01() {
        List<String> texts = Arrays.asList("a", "b", "c", "d", "e");
                
        // for文で記述
        printList(texts);

        // 単純にforEachメソッドで置き換え
        printListStream1(texts);
        // forEachメソッドとメソッド参照で置き換え
        printListStream2(texts);
    }
    
    private void printList(List<String> texts) {
        for (String text: texts) {
            System.out.println(text);
        }
    }

    private void printListStream1(List<String> texts) {
        texts.forEach(text ->System.out.println(text));
    }

    private void printListStream2(List<String> texts) {
        texts.forEach(System.out::println);
    }

    public static void main(String... args) {
        new ForEach01();
    }
}
