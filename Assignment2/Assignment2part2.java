package edu.northeastern.Joyce;

public class Assignment2part2 {

        // Method: dynamic programming
        public int maxSubArray(int[] nums) {
            if ( nums == null || nums.length == 0){
                return 0;
            }
            int n = nums.length;
            int maxSum = nums[0];
            for(int i = 1; i < n; i++){
                if(nums[i - 1] > 0) {
                    //if nums[i-1] > 0, nums[i] + nums[i-1] > nums[i]
                    //if nums[i-1] < 0, nums[i] + nums[i-1] < nums[i] so nums[i] choose not to add the previous one
                    nums[i] += nums[i - 1];
                }
                maxSum = Math.max(nums[i], maxSum);
            }
            return maxSum;
        }

        public static void main(String[] args) {
            //edge case: array is empty
            int[] nums = new int[]{};
            //edge case: array equals to null
            int[] nums2 = null;
            //edge case: array contains all the same positive numbers;
            int[] nums3 = new int[]{1,1,1,1,1,1,1,1,};
            //edge case: array contains all the same negative numbers
            int[] nums4 = new int[]{-1,-1,-1,-1,-1,-1};
            int[] nums5 = new int[]{-2,1,-3,4,-1,2,1,-5,4};

            Assignment2part2 assignment2 = new Assignment2part2();
            int maxSum = assignment2.maxSubArray(nums);
            int maxSum2 = assignment2.maxSubArray(nums2);
            int maxSum3 = assignment2.maxSubArray(nums3);
            int maxSum4 = assignment2.maxSubArray(nums4);
            int maxSum5 = assignment2.maxSubArray(nums5);

            System.out.println(maxSum);
            System.out.println(maxSum2);
            System.out.println(maxSum3);
            System.out.println(maxSum4);
            System.out.println(maxSum5);

        }
}

