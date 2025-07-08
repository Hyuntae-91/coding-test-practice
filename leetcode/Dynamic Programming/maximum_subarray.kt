/**
 * LeetCode 53. Maximum Subarray (https://leetcode.com/problems/maximum-subarray)
 *   - Time Complexity : O(n)
 *   - Space Complexity : O(n)
 * 
 * Approaches:
 *   - Dynamic Programming (Bottom-up)
 *     - We use a DP array where dp[i] represents the maximum subarray sum ending at index i.
 *     - For each index i, dp[i] = max(nums[i], dp[i-1] + nums[i]).
 *     - The answer is the maximum value in the dp array.
 */

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var dp = IntArray(nums.size) { if (it == 0) nums[0] else 0 }
        for (i in 1 until nums.size) {
            dp[i] = maxOf(nums[i], dp[i - 1] + nums[i])
        }
        return dp.max()
    }
}

fun main() {
    val solution = Solution()
    assert(solution.maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)) == 6) { "Test 1 Failure" }
    assert(solution.maxSubArray(intArrayOf(1)) == 1) { "Test 2 Failure" }
    assert(solution.maxSubArray(intArrayOf(5,4,-1,7,8)) == 23) { "Test 3 Failure" }
    assert(solution.maxSubArray(intArrayOf(-2,1)) == 1) { "Test 4 Failure" }
}
