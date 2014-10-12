package answers.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Collect03 {

    public Collect03() {
        int[] numbers = {0, 1, 2, 3, 4, 5};
                
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
        // intからIntegerへ変換するためmapToObjメソッドを使用する
        evens = expressEvensStream3(numbers);
        System.out.println(evens);
        // mapToObjメソッドの代わりにboxedメソッドを使用
        evens = expressEvensStream4(numbers);
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

    private List<Integer> expressEvensStream1(int[] numbers) {
        List<Integer> evens = new ArrayList<>();
        
        Arrays.stream(numbers)
              .forEach(x -> {
                  if (x % 2 == 0) {
                      evens.add(x);
                  }
               });
        
        return evens;
    }

    private List<Integer> expressEvensStream2(int[] numbers) {
        List<Integer> evens = new ArrayList<>();
        
        Arrays.stream(numbers)
              .filter(x -> x % 2 == 0)
              .forEach(x -> evens.add(x));
        
        return evens;
    }

    private List<Integer> expressEvensStream3(int[] numbers) {
        List<Integer> evens = Arrays.stream(numbers)
                                    .filter(x -> x % 2 == 0)
                                    .mapToObj(x -> x)
                                    .collect(Collectors.toList());
        
        return evens;
    }

    private List<Integer> expressEvensStream4(int[] numbers) {
        List<Integer> evens = Arrays.stream(numbers)
                                    .filter(x -> x % 2 == 0)
                                    .boxed()
                                    .collect(Collectors.toList());
        
        return evens;
    }

    public static void main(String... args) {
        new Collect03();
    }
}
