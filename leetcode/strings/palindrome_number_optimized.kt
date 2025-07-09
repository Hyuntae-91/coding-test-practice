/**
 * Leetcode 9: Palindrome Number (https://leetcode.com/problems/palindrome-number/)
 *   - Time Complexity : O(n)
 *   - Space Complexity : O(1)
 * 
 * Approaches:
 *   - Math
 *     - We use math to check if the number is a palindrome.
 *     - We reverse the number and compare it to the original number.
 *     - We handle the case where the number has an odd number of digits by removing the middle digit.
 */

class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false
        var num = x
        var reversed = 0
        while (num > reversed) {
            reversed = reversed * 10 + num % 10
            num /= 10
        }
        return num == reversed || num == reversed / 10
    }
}


fun main() {
    val solution = Solution()
    assert(solution.isPalindrome(121) == true) { "Test 1 Failure" }
    assert(solution.isPalindrome(-121) == false) { "Test 2 Failure" }
    assert(solution.isPalindrome(10) == false) { "Test 3 Failure" }
    assert(solution.isPalindrome(12321) == true) { "Test 4 Failure" }
}