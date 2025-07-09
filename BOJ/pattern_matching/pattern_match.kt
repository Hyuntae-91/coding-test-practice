/**
 * BOJ 9996: 한국이 그리울 땐 서버에 접속하지 (https://www.acmicpc.net/problem/9996)
 *   - Time Complexity : O(n)
 *   - Space Complexity : O(n)
 *
 * Approaches:
 *   - 고민한 포인트:
 *     - 패턴의 '*'가 의미하는 범위와 역할을 명확히 이해하는 것이 중요했다.
 *     - prefix와 postfix가 파일명에서 반드시 맨 앞, 맨 뒤에 위치해야 한다는 점을 놓쳤었다.
 *   - 실수/오류:
 *     - 처음에는 '*' 앞뒤가 파일명 어디에나 있으면 된다고 착각했다.
 *     - Int 범위를 넘는 숫자를 테스트에 사용해서 컴파일 에러가 났다.
 *   - 개선/배운 점:
 *     - startsWith, endsWith 함수를 활용하면 코드가 훨씬 간결해진다.
 *     - Kotlin의 List, MutableList 사용법을 익혔다.
 *     - 문제의 예시를 꼼꼼히 분석하는 습관이 중요함을 다시 느꼈다.
 */

class Solution {
    fun patternMatch(pattern: String, files: List<String>): List<String> {
        val result = MutableList(files.size) { "NE" }
        val wildcardIndex = pattern.indexOf("*")
        val prefix = pattern.substring(0, wildcardIndex)
        val postfix = pattern.substring(wildcardIndex + 1)

        for (i in files.indices) {
            val fileName = files[i]
            if (fileName.length < prefix.length + postfix.length) continue
            if (fileName.startsWith(prefix) && fileName.endsWith(postfix)) result[i] = "DA"
        }
        return result
    }
}


fun main() {
    val solution = Solution()
    val n = readLine()!!.toInt()
    val pattern = readLine()!!
    val files = List(n) { readLine()!! }
    val results = solution.patternMatch(pattern, files)
    results.forEach { println(it) }
}
