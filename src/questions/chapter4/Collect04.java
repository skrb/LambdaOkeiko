package questions.chapter4;

import java.util.Arrays;
import java.util.List;

public class Collect04 {

    public Collect04() {
        List<String> texts = Arrays.asList("J", "a", "v", "a");
                
        String joinedText = joinText(texts);
        System.out.println(joinedText);
    }
    
    private String joinText(List<String> texts) {
        StringBuilder builder = new StringBuilder();
        
        for (String text: texts) {
            builder.append(text);
        }
        
        return builder.toString();
    }

    public static void main(String... args) {
        new Collect04();
    }
}
