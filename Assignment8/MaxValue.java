import java.util.Random;

public class MaxValue {

    private static final Random RAND = new Random();

    private static long max = 0;

    public void generateRandomArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = RAND.nextInt(1000);
        }
    }

    public long max(int[] arr) {
        int len = arr.length;
        PartialMax partialMax1 = new PartialMax(arr, 0, len / 4);
        PartialMax partialMax2 = new PartialMax(arr, len /4, len / 2);
        PartialMax partialMax3 = new PartialMax(arr, len / 2, len - len / 4);
        PartialMax partialMax4 = new PartialMax(arr, len - len / 4, len);
        partialMax1.start();
        partialMax2.start();
        partialMax3.start();
        partialMax4.start();

        try {
            partialMax1.join();
            partialMax2.join();
            partialMax3.join();
            partialMax4.join();
        } catch (InterruptedException ie) {

        }

        return max;
    }


    public class PartialMax extends Thread {
        int[] array;
        int startIndex;
        int endIndex;
        int partialMax = Integer.MIN_VALUE;
        PartialMax(int[] array, int startIndex, int endIndex) {
            this.array = array;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        public void run() {
            for (int i = startIndex; i < endIndex; i++) {
                partialMax = Math.max(array[i], partialMax);
            }

            updateMax();
        }

        public synchronized void updateMax() {
            max = Math.max(max, partialMax);;
        }
    }

    public static void main(String[] args) {
        System.out.println("start");
        MaxValue maxValue = new MaxValue();
        int[] arr = new int[4000000];
        maxValue.generateRandomArray(arr);
        long max = maxValue.max(arr);
        System.out.println("Max: " + max);

    }
}