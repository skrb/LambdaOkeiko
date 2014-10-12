package answers.chapter2;

import java.util.function.Function;

public class Lambda04 {

    public Lambda04() {
        // 匿名クラスで記述
        test();

        // Lambda 式で記述
        testLambda1();
        // 引数の型と丸カッコを省略
        testLambda2();
        // 波カッコとreturnを省略
        testLambda3();
        // メソッド参照で記述
        testLambda4();
    }

    private void test() {
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String x) {
                return Integer.valueOf(x);
            }
        };

        System.out.println(function.apply("0"));
        System.out.println(function.apply("10"));
        System.out.println(function.apply("-10"));
    }

    private void testLambda1() {
        Function<String, Integer> function = (String x) -> {
            return Integer.valueOf(x);
        };

        System.out.println(function.apply("0"));
        System.out.println(function.apply("10"));
        System.out.println(function.apply("-10"));
    }

    private void testLambda2() {
        Function<String, Integer> function = x -> {
            return Integer.valueOf(x);
        };

        System.out.println(function.apply("0"));
        System.out.println(function.apply("10"));
        System.out.println(function.apply("-10"));
    }

    private void testLambda3() {
        Function<String, Integer> function = x -> Integer.valueOf(x);

        System.out.println(function.apply("0"));
        System.out.println(function.apply("10"));
        System.out.println(function.apply("-10"));
    }

    private void testLambda4() {
        Function<String, Integer> function = Integer::valueOf;

        System.out.println(function.apply("0"));
        System.out.println(function.apply("10"));
        System.out.println(function.apply("-10"));
    }

    public static void main(String... args) {
        new Lambda04();
    }
}
