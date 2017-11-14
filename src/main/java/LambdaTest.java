public class LambdaTest {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> System.out.println("Hello Java!");
        Thread t = new Thread(r);
        t.start();
        t.join();
    }
}
