package questions.chapter3;

import java.util.Arrays;
import java.util.List;

public class ForEach04 {

    public ForEach04() {
        List<String> texts = Arrays.asList("Java", "JavaScript", "Ruby", "Pearl", "PHP", "Scala", "Groovy");
                
        printList(texts);
    }
    
    private void printList(List<String> texts) {
        for (String text: texts) {
            String lowerText = text.toLowerCase();
            
            if (lowerText.startsWith("j")) {
                System.out.println(lowerText);
            }
        }
    }

    public static void main(String... args) {
        new ForEach04();
    }
}
