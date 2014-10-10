package questions.chapter3;

import java.util.Arrays;
import java.util.List;

public class ForEach02 {

    public ForEach02() {
        List<String> texts = Arrays.asList("a", "b", "c", "d", "e");
                
        printList(texts);
    }
    
    private void printList(List<String> texts) {
        for (String text: texts) {
            if (text.startsWith("a")) {
                System.out.println(text.toLowerCase());
            }
        }
    }

    public static void main(String... args) {
        new ForEach02();
    }
}
