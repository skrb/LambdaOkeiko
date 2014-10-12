package answers.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Collect01 {

    public Collect01() {
        List<String> texts = Arrays.asList("a", "b", "c", "d", "e");
                
        // for文で記述
        List<String> copiedTexts = copyList(texts);
        System.out.println(copiedTexts);

        // 単純にforEachメソッドで置き換え
        copiedTexts = copyListStream1(texts);
        System.out.println(copiedTexts);
        // collectメソッドで置き換え
        copiedTexts = copyListStream2(texts);
        System.out.println(copiedTexts);
    }
    
    private List<String> copyList(List<String> src) {
        List<String> dest = new ArrayList<>();
        
        for (String element: src) {
            dest.add(element);
        }
        
        return dest;
    }

    private List<String> copyListStream1(List<String> src) {
        List<String> dest = new ArrayList<>();
        
        src.forEach(element -> {
            dest.add(element);
        });
        
        return dest;
    }

    private List<String> copyListStream2(List<String> src) {
        List<String> dest = src.stream()
                               .collect(Collectors.toList());
        
        return dest;
    }
    public static void main(String... args) {
        new Collect01();
    }
}
