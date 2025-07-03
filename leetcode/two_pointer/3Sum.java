/**
 * LeetCode 15. 3Sum (https://leetcode.com/problems/3sum/)
 *   - Time Complexity : O(n²)
 *   - Space Complexity : O(1)
 * 
 * Approaches:
 *   - Sorting and Two Pointers
 *   - Fix one number and use two pointers to find the other two
 *   - Skip duplicates
 */

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;

        Arrays.sort(nums);

        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1, right = n - 1; 
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++; right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = sol.threeSum(nums);
        System.out.println(result);
    }
}
