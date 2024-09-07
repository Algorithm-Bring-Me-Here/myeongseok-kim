class Solution {
    fun solution(numbers: LongArray): LongArray {
        val answer = LongArray(numbers.size)

        for (i in numbers.indices) {
            val x = numbers[i]
            answer[i] = findNextNumber(x)
        }

        return answer
    }

    private fun findNextNumber(x: Long): Long {
        return if (x % 2 == 0L) {
            // x가 짝수인 경우, 가장 오른쪽의 0을 1로 바꾸면 됨
            x + 1
        } else {
            // x가 홀수인 경우, 가장 오른쪽의 0을 1로 바꾸고 그 오른쪽 비트를 0으로 변경
            var temp = x
            var bit = 1L

            // 가장 오른쪽의 0을 찾는다.
            while ((temp and bit) != 0L) {
                bit = bit shl 1
            }
            // 해당 0을 1로 바꾸고 그 다음 비트를 0으로 변경
            (x + bit) - (bit shr 1)
        }
    }
}
