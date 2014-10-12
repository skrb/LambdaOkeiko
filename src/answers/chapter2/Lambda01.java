package answers.chapter2;

import java.util.Comparator;

public class Lambda01 {

    public Lambda01() {
        // 匿名クラスで記述
        test();

        // Lambda 式で記述
        testLambda1();
        // 引数の型を省略
        testLambda2();
        // 波カッコとreturnを省略
        testLambda3();
        // メソッド参照で記述
        testLambda4();
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

    private void testLambda1() {
        Comparator<Integer> comparator = (Integer x, Integer y) -> {
            return Integer.compare(x, y);
        };

        System.out.println(comparator.compare(20, 10));
        System.out.println(comparator.compare(20, 20));
        System.out.println(comparator.compare(5, 20));
    }

    private void testLambda2() {
        Comparator<Integer> comparator = (x, y) -> {
            return Integer.compare(x, y);
        };

        System.out.println(comparator.compare(20, 10));
        System.out.println(comparator.compare(20, 20));
        System.out.println(comparator.compare(5, 20));
    }

    private void testLambda3() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);

        System.out.println(comparator.compare(20, 10));
        System.out.println(comparator.compare(20, 20));
        System.out.println(comparator.compare(5, 20));
    }

    private void testLambda4() {
        Comparator<Integer> comparator = Integer::compare;

        System.out.println(comparator.compare(20, 10));
        System.out.println(comparator.compare(20, 20));
        System.out.println(comparator.compare(5, 20));
    }

    public static void main(String... args) {
        new Lambda01();
    }
}
