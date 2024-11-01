class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0
        var now=1
        section.forEach{
            if(now<=it)
            {
                now=it+m
                answer++
            }
        }
        return answer
    }
}