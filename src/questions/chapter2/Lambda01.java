package questions.chapter2;

import java.util.Comparator;

public class Lambda01 {

    public Lambda01() {
        test();
    }
    
    private void test() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return Integer.compare(x, y);
            }
        };
        
        System.out.println(comparator.compare(20, 10));
        System.out.println(comparator.compare(20, 20));
        System.out.println(comparator.compare(5, 20));
    }

    public static void main(String... args) {
        new Lambda01();
    }
}
