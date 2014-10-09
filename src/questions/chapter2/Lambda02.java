package questions.chapter2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Lambda02 {

    public Lambda02() {
        test();
    }
    
    private void test() {
        Callable<List<String>> task = new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                Path path = Paths.get("README.md");
                return Files.readAllLines(path);
            }
        };
        
        ExecutorService service = Executors.newFixedThreadPool(1);
        
        Future<List<String>> future = service.submit(task);
        
        try {
            List<String> contents = future.get();
            System.out.println(contents);
        } catch (InterruptedException ex) {
        } catch (ExecutionException ex) {
            System.err.println("Fail execution!");
        }
        
        service.shutdown();
    }

    public static void main(String... args) {
        new Lambda02();
    }
}
