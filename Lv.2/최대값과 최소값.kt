class `최대값과 최소값` {
    fun solution(s: String): String {
        val numbers = s.split(" ").map { it.toLong() }
        return "${numbers.minOrNull()} ${numbers.maxOrNull() }"
    }
}
