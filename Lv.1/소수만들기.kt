import kotlin.math.*

class Solution {
    fun solution(nums: IntArray): Int {
        var answer = 0
        var visited = BooleanArray(nums.size)

        for (i in 0 until nums.size) {
            visited[i] = true
            for (j in i until nums.size) {
                if (!visited[j]) {
                    visited[j] = true
                    for (k in j until nums.size) {
                        if (!visited[k]) {
                            if (prime(nums[i] + nums[j] + nums[k])) answer++
                        }
                    }
                    visited[j] = false
                }
            }
            visited[i] = false

        }
        return answer
    }

    fun prime(num: Int): Boolean {
        for (i in 2..(sqrt(num.toDouble()).toInt() + 1)) {
            if (num % i == 0) return false
        }
        return true
    }
}