package questions.chapter4;

import java.util.ArrayList;
import java.util.List;

public class Collect03 {

    public Collect03() {
        int[] numbers = {0, 1, 2, 3, 4, 5};
                
        List<Integer> evens = expressEvens(numbers);
        System.out.println(evens);
    }
    
    private List<Integer> expressEvens(int[] numbers) {
        List<Integer> evens = new ArrayList<>();
        
        for (int x: numbers) {
            if (x % 2 == 0) {
                evens.add(x);
            }
        }
        
        return evens;
    }

    public static void main(String... args) {
        new Collect03();
    }
}
