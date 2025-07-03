/**
 * LeetCode 148. Sort List (https://leetcode.com/problems/sort-list/description/?envType=problem-list-v2&envId=merge-sort)
 *   - Time Complexity : O(nlogn)
 *   - Space Complexity : O(n)
 * 
 * Approaches:
 *   - Merge Sort
 *   - Divide and Conquer
 *   - Linked List
 *   - Fast and Slow Pointer
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    private fun getMid(head: ListNode?): ListNode? {
        var slow = head
        var fast = head
        var prev: ListNode? = null

        while (fast != null && fast.next != null) {
            prev = slow
            slow = slow?.next
            fast = fast.next.next
        }
        prev?.next = null
        return slow
    }

    private fun merge(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var tail = dummy
        var p1 = l1
        var p2 = l2

        while (p1 != null && p2 != null) {
            if (p1.`val` < p2.`val`) {
                tail.next = p1
                p1 = p1.next
            } else {
                tail.next = p2
                p2 = p2.next
            }
            tail = tail.next!!
        }
        tail.next = p1 ?: p2
        return dummy.next
    }

    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val mid = getMid(head)
        val left = sortList(head)
        val right = sortList(mid)
        return merge(left, right)
    }
}

fun main() {
    val n1 = ListNode(4)
    val n2 = ListNode(2)
    val n3 = ListNode(1)
    val n4 = ListNode(3)
    n1.next = n2
    n2.next = n3
    n3.next = n4

    val solution = Solution()
    var sorted = solution.sortList(n1)

    // 정렬된 리스트 출력
    while (sorted != null) {
        print("${sorted.`val`} ")
        sorted = sorted.next
    }
    println()
}
