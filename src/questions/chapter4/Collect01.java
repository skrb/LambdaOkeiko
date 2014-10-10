package questions.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collect01 {

    public Collect01() {
        List<String> texts = Arrays.asList("a", "b", "c", "d", "e");
                
        List<String> copiedTexts = copyList(texts);
        System.out.println(copiedTexts);
    }
    
    private List<String> copyList(List<String> src) {
        List<String> dest = new ArrayList<>();
        
        for (String element: src) {
            dest.add(element);
        }
        
        return dest;
    }

    public static void main(String... args) {
        new Collect01();
    }
}
