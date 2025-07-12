/**
 * 3455. Shortest Matching Substring (https://leetcode.com/problems/shortest-matching-substring)
 *   - Time Complexity : O(n^2)
 *   - Space Complexity : O(n)
 *
 * My Approaches:
 *   - Pattern Matching with Three-Part Strategy:
 *     1. Split pattern into prefix, middlefix, postfix based on '*' positions
 *     2. Handle three cases:
 *        - Case 1: prefix exists (> 0 length)
 *          * Find all prefix indices in string
 *          * For each prefix match, find nearest middlefix and postfix
 *          * Calculate substring length and track minimum
 *        - Case 2: prefix is empty, middlefix exists
 *          * Find all middlefix indices in string
 *          * For each middlefix match, find nearest postfix
 *          * Calculate substring length and track minimum
 *        - Case 3: prefix and middlefix are empty
 *          * Find all postfix indices in string
 *          * Return postfix length if found
 *     3. Return minimum length found, or -1 if no match
 * 
 * 
 * Possible Improvements:
 *   - KMP algorithm for O(n+m) substring search instead of O(n*m)
 *   - Binary search for optimal length finding
 *   - Rolling hash (Rabin-Karp) for faster matching
 *   - Sliding window approach if applicable
 */

class Solution {
    fun shortestMatchingSubstring(s: String, p: String): Int {
        val indices = p.withIndex()
            .filter { it.value == '*' }
            .map { it.index }
        if (indices.size != 2) return -1

        val prefix = p.substring(0, indices[0])
        val middlefix = p.substring(indices[0] + 1, indices[1])
        val postfix = p.substring(indices[1] + 1)

        // if the length of s is less than the length of prefix + middlefix + postfix, return -1
        if (s.length < prefix.length + middlefix.length + postfix.length) return -1

        var result = Int.MAX_VALUE

        if (prefix.length > 0) {
            val prefixIndices = mutableListOf<Int>()
            var idx = s.indexOf(prefix)
            while (idx != -1) {
                prefixIndices.add(idx)
                idx = s.indexOf(prefix, idx + 1)
            }
            if (prefixIndices.isEmpty()) return -1
            for (i in prefixIndices) {
                val middleIdx = s.indexOf(middlefix, i + prefix.length)
                if (middleIdx == -1) continue
                val postIdx = s.indexOf(postfix, middleIdx + middlefix.length)
                if (postIdx == -1) continue
                result = minOf(result, postIdx - i + postfix.length)
            }
        } else if (middlefix.length > 0) {
            val middlefixIndices = mutableListOf<Int>()
            var idx = s.indexOf(middlefix)
            while (idx != -1) {
                middlefixIndices.add(idx)
                idx = s.indexOf(middlefix, idx + 1)
            }
            if (middlefixIndices.isEmpty()) return -1
            for (i in middlefixIndices) {
                val postIdx = s.indexOf(postfix, i + middlefix.length)
                if (postIdx == -1) continue
                result = minOf(result, postIdx - i + postfix.length)
            }
        } else {
            var idx = s.indexOf(postfix)
            if (idx == -1) return -1
            result = postfix.length
        }

        return if (result == Int.MAX_VALUE) -1 else result
    }
}

fun main() {
    val solution = Solution()
    println(solution.shortestMatchingSubstring("abaacbaecebce", "ba*c*ce") == 8)
    println(solution.shortestMatchingSubstring("baccbaadbc", "cc*baa*adb") == -1)
    println(solution.shortestMatchingSubstring("a", "**") == 0)
    println(solution.shortestMatchingSubstring("madlogic", "*adlogi*") == 6)
}