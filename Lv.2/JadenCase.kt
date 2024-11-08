class Solution {
    fun solution(s: String): String {
        var answer = ""
        answer = s.split(" ").map{
            if(it.isNotEmpty()) it[0].toUpperCase() + it.slice(1..it.length-1).toLowerCase()
            else ""
        }.joinToString(" ")

        return answer
    }
}