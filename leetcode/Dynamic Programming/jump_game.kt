/**
 * LeetCode 55. Jump Game (https://leetcode.com/problems/jump-game)
 *   - Time Complexity : O(n^2)
 *   - Space Complexity : O(n)
 * 
 * Approaches:
 *   - Dynamic Programming (Bottom-up)
 *     - Uses a DP array to track the minimum jumps needed to reach each index.
 *     - Iteratively updates the DP array based on reachable indices.
 *   - Greedy Algorithm (Optimal)
 *     - Time Complexity: O(n)
 *     - Space Complexity: O(1)
 *     - Maintains the farthest reachable index while iterating through the array.
 *     - If the current index exceeds the farthest reachable index, return false.
 *     - This approach is more efficient than DP for this problem.
 */

class Solution {
    fun canJump(nums: IntArray): Boolean {
        var dp = IntArray(nums.size) { if (it == 0) 0 else Int.MAX_VALUE }
        for (i in 0 until nums.size) {
            if (dp[i] == Int.MAX_VALUE) continue
            for (j in i + 1 until minOf(nums.size, i + 1 + nums[i])) {
                dp[j] = minOf(dp[j], dp[i] + 1)
            }
        }
        return dp[nums.size - 1] != Int.MAX_VALUE
    }
}

fun main() {
    val solution = Solution()
    assert(solution.canJump(intArrayOf(2,3,1,1,4)) == true) { "Test 1 Failure" }
    assert(solution.canJump(intArrayOf(3,2,1,0,4)) == false) { "Test 2 Failure" }
    assert(solution.canJump(intArrayOf(0,2,3)) == false) { "Test 3 Failure" }
    assert(solution.canJump(intArrayOf(1,0,1,0)) == false) { "Test 4 Failure" }
}
