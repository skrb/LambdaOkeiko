package answers.chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Collect04 {

    public Collect04() {
        List<String> texts = Arrays.asList("J", "a", "v", "a");
                
        // for文で記述
        String joinedText = joinText(texts);
        System.out.println(joinedText);

        // 単純にforEachメソッドで置き換え
        joinedText = joinTextStream1(texts);
        System.out.println(joinedText);
        // collectメソッドで置き換え
        joinedText = joinTextStream2(texts);
        System.out.println(joinedText);
    }
    
    private String joinText(List<String> texts) {
        StringBuilder builder = new StringBuilder();
        
        for (String text: texts) {
            builder.append(text);
        }
        
        return builder.toString();
    }

    private String joinTextStream1(List<String> texts) {
        StringBuilder builder = new StringBuilder();
        
        texts.forEach(text -> {
            builder.append(text);
        });
        
        return builder.toString();
    }

    private String joinTextStream2(List<String> texts) {
        String joinedText = texts.stream()
                                 .collect(Collectors.joining());
        
        return joinedText;
    }

    public static void main(String... args) {
        new Collect04();
    }
}
