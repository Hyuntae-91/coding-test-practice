/**
 * Leetcode 9: Palindrome Number (https://leetcode.com/problems/palindrome-number/)
 *   - Time Complexity : O(n)
 *   - Space Complexity : O(n)
 * 
 * Approaches:
 *   - Two Pointers
 *     - We use two pointers, one starting from the beginning and one from the end.
 *     - We compare the characters at the two pointers and move the pointers towards the center.
 */

class Solution {
    fun isPalindrome(x: Int): Boolean {
        val xString = x.toString()
        val length = xString.length
        for (i in 0 until length / 2) {
            if (xString[i] != xString[length - i - 1]) return false
        }
        return true
    }
}


fun main() {
    val solution = Solution()
    assert(solution.isPalindrome(121) == true) { "Test 1 Failure" }
    assert(solution.isPalindrome(-121) == false) { "Test 2 Failure" }
    assert(solution.isPalindrome(10) == false) { "Test 3 Failure" }
    assert(solution.isPalindrome(12321) == true) { "Test 4 Failure" }
}