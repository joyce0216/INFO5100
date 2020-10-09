package info5100;

import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            System.out.println("No value");
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int num: nums) {
            pq.offer(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        System.out.println( k + "th largest number is " + pq.peek());
        return pq.peek();
    }

    public static void main(String[] args) {
        Solution solution1 = new Solution();
        int[] num1 = { };
        solution1.findKthLargest(num1, 2);

        Solution solution2 = new Solution();
        int[] num2 = null;
        solution1.findKthLargest(num2, 2);

        Solution solution3 = new Solution();
        int[] num3 = {3, 2, 1, 5, 6, 4 };
        solution1.findKthLargest(num3, 2);

        Solution solution4 = new Solution();
        int[] num4 = {3, 3, 3, 3, 3, 3, 3 };
        solution1.findKthLargest(num4, 4);

        Solution solution5 = new Solution();
        int[] num5 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        solution5.findKthLargest(num5, 4);

        Solution solution6 = new Solution();
        int[] num6 = {3, 2, 1, 5, 6, 4 };
        solution1.findKthLargest(num3, -2);


    }
}
