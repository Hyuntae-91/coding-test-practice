/**
 * LeetCode 16. 3Sum Closest (https://leetcode.com/problems/3sum-closest/)
 *   - Time Complexity : O(n²)
 *   - Space Complexity : O(1)
 * 
 * Approaches:
 *   - Sorting and Two Pointers
 *   - Fix one number and use two pointers to find the other two
 *   - Skip duplicates
 *   - It's similar to 3Sum
 */

import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n <= 3) return nums[0] + nums[1] + nums[2];
        int min = Integer.MAX_VALUE;
        
        int result = 0;
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < min) {
                    min = Math.abs(sum - target);
                    result = sum;
                }
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        List<List<Integer>> result = sol.threeSumClosest(nums, target);
        System.out.println(result);
    }
}
