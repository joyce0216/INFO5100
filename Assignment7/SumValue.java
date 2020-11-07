import java.util.Random;

public class SumValue {

    private static final Random RAND = new Random();

    private static long sum = 0;

    public void generateRandomArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = RAND.nextInt(100);
        }
    }

    public long sum(int[] arr) {
        int len = arr.length;
        PartialSum partialSum1 = new PartialSum(arr, 0, len / 4);
        PartialSum partialSum2 = new PartialSum(arr, len /4, len / 2);
        PartialSum partialSum3 = new PartialSum(arr, len / 2, len - len / 4);
        PartialSum partialSum4 = new PartialSum(arr, len - len / 4, len);
        partialSum1.start();
        partialSum2.start();
        partialSum3.start();
        partialSum4.start();

        try {
            partialSum1.join();
            partialSum2.join();
            partialSum3.join();
            partialSum4.join();
        } catch (InterruptedException ie) {}

        return sum;
    }


    public class PartialSum extends Thread {
        int[] array;
        int startIndex;
        int endIndex;
        int partialSum;
        PartialSum (int[] array, int startIndex, int endIndex) {
            this.array = array;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        public void run() {
            for (int i = startIndex; i < endIndex; i++) {
                partialSum += array[i];
            }
            addToSum();
        }

        public synchronized void addToSum() {
            sum += partialSum;
        }
    }

    public static void main(String[] args) {
        System.out.println("start");
        SumValue sumValue = new SumValue();
        int[] arr = new int[4000000];
        sumValue.generateRandomArray(arr);
        long sum = sumValue.sum(arr);
        System.out.println("Sum: " + sum);

    }
}
