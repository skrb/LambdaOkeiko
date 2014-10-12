package answers.chapter3;

import java.util.Arrays;
import java.util.List;

public class ForEach04 {

    public ForEach04() {
        List<String> texts = Arrays.asList("Java", "JavaScript", "Ruby", "Pearl", "PHP", "Scala", "Groovy");
                
        // for文で記述
        printList(texts);

        // 単純にforEachメソッドで置き換え
        printListStream1(texts);
        // forEachメソッドとmapメソッドで置き換え
        printListStream2(texts);
        // forEachメソッドとmapメソッドとfilterメソッドで置き換え
        printListStream3(texts);
        // メソッド参照を使用
        printListStream4(texts);
    }
    
    private void printList(List<String> texts) {
        for (String text: texts) {
            String lowerText = text.toLowerCase();
            
            if (lowerText.startsWith("j")) {
                System.out.println(lowerText);
            }
        }
    }

    private void printListStream1(List<String> texts) {
        texts.forEach(text -> {
            String lowerText = text.toLowerCase();
            
            if (lowerText.startsWith("j")) {
                System.out.println(lowerText);
            }
        });
    }

    private void printListStream2(List<String> texts) {
        texts.stream()
             .map(text -> text.toLowerCase())
             .forEach(text -> {
                 if (text.startsWith("j")) {
                     System.out.println(text);
                 }
             });
    }
    
    private void printListStream3(List<String> texts) {
        texts.stream()
             .map(text -> text.toLowerCase())
             .filter(text -> text.startsWith("j"))
             .forEach(text -> System.out.println(text));
    }

    private void printListStream4(List<String> texts) {
        texts.stream()
             .map(String::toLowerCase)
             .filter(text -> text.startsWith("j"))
             .forEach(System.out::println);
    }

    public static void main(String... args) {
        new ForEach04();
    }
}
