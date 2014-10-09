package questions.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Lambda05 {

    public Lambda05() {
        test();
    }
    
    private void test() {
        List<Integer> numbers = makeList();

        List<Integer> bigNumbers
                = filterList(numbers,
                         new Predicate<Integer>() {
                             @Override
                             public boolean test(Integer t) {
                                return t > 10;
                             }
                         }
                );
        System.out.println(bigNumbers);

        List<Integer> smallNumbers
                = filterList(numbers,
                         new Predicate<Integer>() {
                             @Override
                             public boolean test(Integer t) {
                                return t < 10;
                             }
                         }
                );
        System.out.println(smallNumbers);
    }

    private List<Integer> filterList(List<Integer> src, Predicate<Integer> predicate) {
        List<Integer> dest = new ArrayList<>();

        for (Integer x : src) {
            if (predicate.test(x)) {
                dest.add(x);
            }
        }

        return dest;
    }

    private List<Integer> makeList() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            numbers.add(i);
        }

        return numbers;
    }

    public static void main(String... args) {
        new Lambda05();
    }
}
