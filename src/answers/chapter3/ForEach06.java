package answers.chapter3;

import java.util.stream.IntStream;

public class ForEach06 {

    public ForEach06() {
        // for文で記述
        printEvens();

        // IntStream#rangeメソッドでストリームを生成して、使用
        printEvensStream1();
        // filterメソッドを追加
        printEvensStream2();
        // メソッド参照を使用
        printEvensStream3();
    }
    
    private void printEvens() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    private void printEvensStream1() {
        IntStream.range(0, 20)
                 .forEach(i -> {
                     if (i % 2 == 0) {
                         System.out.println(i);
                     }
                 });
    }

    private void printEvensStream2() {
        IntStream.range(0, 20)
                 .filter(i -> i % 2 == 0)
                 .forEach(i -> System.out.println(i));
    }

    private void printEvensStream3() {
        IntStream.range(0, 20)
                 .filter(i -> i % 2 == 0)
                 .forEach(System.out::println);
    }

    public static void main(String... args) {
        new ForEach06();
    }
}
