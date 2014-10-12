package answers.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Collect02 {

    public Collect02() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5);
                
        // for文で記述
        List<Integer> evens = expressEvens(numbers);
        System.out.println(evens);

        // 単純にforEachメソッドで置き換え
        evens = expressEvensStream1(numbers);
        System.out.println(evens);
        // filterメソッドを追加
        evens = expressEvensStream2(numbers);
        System.out.println(evens);
        // collectメソッドで置き換え
        evens = expressEvensStream3(numbers);
        System.out.println(evens);
    }
    
    private List<Integer> expressEvens(List<Integer> numbers) {
        List<Integer> evens = new ArrayList<>();
        
        for (int x: numbers) {
            if (x % 2 == 0) {
                evens.add(x);
            }
        }
        
        return evens;
    }

    private List<Integer> expressEvensStream1(List<Integer> numbers) {
        List<Integer> evens = new ArrayList<>();
        
        numbers.forEach(x -> {
            if (x % 2 == 0) {
                evens.add(x);
            }
        });
        
        return evens;
    }

    private List<Integer> expressEvensStream2(List<Integer> numbers) {
        List<Integer> evens = new ArrayList<>();
        
        numbers.stream()
               .filter(x -> x % 2 == 0)
               .forEach(x -> evens.add(x));
        
        return evens;
    }

    private List<Integer> expressEvensStream3(List<Integer> numbers) {
        List<Integer> evens = numbers.stream()
                                     .filter(x -> x % 2 == 0)
                                     .collect(Collectors.toList());
        
        return evens;
    }

    public static void main(String... args) {
        new Collect02();
    }
}
