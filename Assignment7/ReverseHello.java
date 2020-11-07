import java.util.concurrent.atomic.AtomicInteger;
public class ReverseHello extends Thread{
    private static final AtomicInteger NUM = new AtomicInteger(50);

    private int num;
    public ReverseHello(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        if (num < 50) {
            Thread childThread = new ReverseHello(num + 1);
            childThread.start();
        }

        while (NUM.get() != num) {}

        System.out.println("Hello from Thread " + num);

        NUM.decrementAndGet();
    }


    public static void main(String[] args) {
        new ReverseHello(1).start();
    }
}

