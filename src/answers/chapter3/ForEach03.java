package answers.chapter3;

import java.util.Arrays;
import java.util.List;

public class ForEach03 {

    public ForEach03() {
        List<String> texts = Arrays.asList("Java", "jAva", "jaVa", "JAVA", "javA");
                
        // for文で記述
        printList(texts);

        // 単純にforEachメソッドで置き換え
        printListStream1(texts);
        // forEachメソッドとmapメソッドで置き換え
        printListStream2(texts);
        // メソッド参照を使用
        printListStream3(texts);
    }
    
    private void printList(List<String> texts) {
        for (String text: texts) {
            String lowerText = text.toLowerCase();

            System.out.println(lowerText);
        }
    }

    private void printListStream1(List<String> texts) {
        texts.forEach(text -> {
            String lowerText = text.toLowerCase();

            System.out.println(lowerText);
        });
    }

    private void printListStream2(List<String> texts) {
        texts.stream()
             .map(text -> text.toLowerCase())
             .forEach(text -> System.out.println(text));
    }

    private void printListStream3(List<String> texts) {
        texts.stream()
             .map(text -> text.toLowerCase())
             .forEach(System.out::println);
    }

    public static void main(String... args) {
        new ForEach03();
    }
}
