/**
 * 125. Valid Palindrome (https://leetcode.com/problems/valid-palindrome)
 *   - Time Complexity : O(n)
 *   - Space Complexity : O(1)
 * 
 * Approaches:
 *   - Two Pointers
 *     - We use two pointers, one starting from the beginning and one from the end.
 *     - We move the pointers towards the center until they meet.
 *     - We skip non-alphanumeric characters.
 */


class Solution {
    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1
        val lower = s.lowercase()
        while (left < right) {
            if (!lower[left].isLetterOrDigit()) {
                left++
                continue
            }
            if (!lower[right].isLetterOrDigit()) {
                right--
                continue
            }
            if (lower[left++] != lower[right--]) return false
        }
        return true
    }
}

fun main() {
    val solution = Solution()
    assert(solution.isPalindrome("A man, a plan, a canal: Panama") == true) { "Test 1 Failure" }
    assert(solution.isPalindrome("race a car") == false) { "Test 2 Failure" }
    assert(solution.isPalindrome(" ") == true) { "Test 3 Failure" }
    assert(solution.isPalindrome("0P") == false) { "Test 4 Failure" }
    assert(solution.isPalindrome("ab2a") == false) { "Test 5 Failure" }
    assert(solution.isPalindrome("abba") == true) { "Test 6 Failure" }
    assert(solution.isPalindrome("0P") == false) { "Test 7 Failure" }
    assert(solution.isPalindrome("ab2a") == false) { "Test 8 Failure" }
    assert(solution.isPalindrome("abba") == true) { "Test 9 Failure" }
    assert(solution.isPalindrome("0P") == false) { "Test 10 Failure" }
}