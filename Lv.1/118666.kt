class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        val num = IntArray(8) { 0 } // r t c f j m a n 의 점수

        fun check(c1: Int, c2: Int, count: Int) {
            if (count < 4) num[c1] += 4 - count
            else num[c2] += count - 4
        }

        for (i in survey.indices) {
            val count1: Int
            val count2: Int
            val text = survey[i]
            when (text) {
                "RT" -> { count1 = 0; count2 = 1 } // r t c f j m a n 의 점수
                "TR" -> { count1 = 1; count2 = 0 }
                "CF" -> { count1 = 2; count2 = 3 }
                "FC" -> { count1 = 3; count2 = 2 }
                "JM" -> { count1 = 4; count2 = 5 }
                "MJ" -> { count1 = 5; count2 = 4 }
                "AN" -> { count1 = 6; count2 = 7 }
                "NA" -> { count1 = 7; count2 = 6 }
                else -> continue
            }
            check(count1, count2, choices[i])
        }

        val answer = StringBuilder()
        if (num[0] < num[1]) answer.append("T") else answer.append("R")
        if (num[2] < num[3]) answer.append("F") else answer.append("C")
        if (num[4] < num[5]) answer.append("M") else answer.append("J")
        if (num[6] < num[7]) answer.append("N") else answer.append("A")

        return answer.toString()
    }
}