class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var i = 0
        var j = 0
        var k = 0

        while (k < goal.size) {
            if (i < cards1.size && cards1[i] == goal[k]) i++
            else if (j < cards2.size && cards2[j] == goal[k]) j++
            else return "No"
            k++
        }
        return "Yes"
    }
}
