/**
 * LeetCode 62. Unique Paths (https://leetcode.com/problems/unique-paths)
 *   - Time Complexity : O(m*n)
 *   - Space Complexity : O(m*n)
 * 
 * Approaches:
 *   - Dynamic Programming (Bottom-up)
 *   - 2D DP Array
 *   - Iterative Solution
 */


class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m) { IntArray(n) }

        for (i in 0 until m) {
            dp[i][0] = 1
        }

        for (j in 0 until n) {
            dp[0][j] = 1
        }

        for (i in 1 until m) {
            for (j in 1 until n) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            }
        }

        return dp[m - 1][n - 1]
    }
}

fun main() {
    val m = 3
    val n = 7
    val solution = Solution()
    val result = solution.uniquePaths(m, n)
    println("Unique Paths($m, $n) = $result")
}