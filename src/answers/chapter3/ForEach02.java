package answers.chapter3;

import java.util.Arrays;
import java.util.List;

public class ForEach02 {

    public ForEach02() {
        List<String> texts = Arrays.asList("a", "b", "c", "d", "e");
                
        // for文で記述
        printList(texts);

        // 単純にforEachメソッドで置き換え
        printListStream1(texts);
        // forEachメソッドとfilterメソッドで置き換え
        printListStream2(texts);
        // メソッド参照を使用
        printListStream3(texts);
    }
    
    private void printList(List<String> texts) {
        for (String text: texts) {
            if (text.startsWith("a")) {
                System.out.println(text);
            }
        }
    }

    private void printListStream1(List<String> texts) {
        texts.forEach(text -> {
            if (text.startsWith("a")) {
                System.out.println(text);
            }
        });
    }

    private void printListStream2(List<String> texts) {
        texts.stream()
             .filter(text -> text.startsWith("a"))
             .forEach(text -> System.out.println(text));
    }
    
    private void printListStream3(List<String> texts) {
        texts.stream()
             .filter(text -> text.startsWith("a"))
             .forEach(System.out::println);
    }

    public static void main(String... args) {
        new ForEach02();
    }
}
