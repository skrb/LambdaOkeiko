package answers.chapter2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lambda03 {

    public Lambda03() {
        // 匿名クラスで記述
        test();

        // Lambda 式で記述
        testLambda1();
    }

    private void test() {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    Path path = Paths.get("README.md");
                    List<String> contents = Files.readAllLines(path);
                    System.out.println(contents);
                } catch (IOException ex) {
                    System.err.println("Fail Read.");
                }
            }
        };

        ExecutorService service = Executors.newFixedThreadPool(1);

        service.submit(task);
        service.shutdown();
    }

    private void testLambda1() {
        Runnable task = () -> {
            try {
                Path path = Paths.get("README.md");
                List<String> contents = Files.readAllLines(path);
                System.out.println(contents);
            } catch (IOException ex) {
                System.err.println("Fail Read.");
            }
        };

        ExecutorService service = Executors.newFixedThreadPool(1);

        service.submit(task);
        service.shutdown();
    }

    public static void main(String... args) {
        new Lambda03();
    }
}
