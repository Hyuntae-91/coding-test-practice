/**
 * LeetCode 62. Unique Paths (https://leetcode.com/problems/unique-paths)
 *   - Time Complexity : O(m*n)
 *   - Space Complexity : O(n)
 * 
 * Approaches:
 *   - Dynamic Programming (Bottom-up)
 *   - 1D DP Array (Space Optimized)
 *   - Iterative Solution
 */


class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = IntArray(n) { 1 }
        for (i in 1 until m) {
            for (j in 1 until n) {
                dp[j] += dp[j - 1]
            }
        }
        return dp[n - 1]
    }
}

fun main() {
    val m = 3
    val n = 7
    val solution = Solution()
    val result = solution.uniquePaths(m, n)
    println("Unique Paths($m, $n) = $result")
}
