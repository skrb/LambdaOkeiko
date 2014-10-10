package questions.chapter3;

public class ForEach06 {

    public ForEach06() {
        printEvens();
    }
    
    private void printEvens() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void main(String... args) {
        new ForEach06();
    }
}
