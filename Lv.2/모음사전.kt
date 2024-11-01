class Solution {
    private val vowels = listOf('A', 'E', 'I', 'O', 'U')
    private var count = 0
    private var answer = 0

    fun solution(word: String): Int {
        dfs("", word)
        return answer
    }

    private fun dfs(current: String, target: String) {
        if (current.length > 5) return

        if (current == target) {
            answer = count
            return
        }

        count++

        for (vowel in vowels) {
            dfs(current + vowel, target)
        }
    }
}
