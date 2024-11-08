class 문자열나누기 {
    fun solution(s: String): Int {
        return sliceString(s)
    }

    fun sliceString(s: String): Int {
        if (s.isEmpty()) return 0

        var x = s[0]
        var countX = 1
        var countNotX = 0
        var num = 1

        for (i in 1..s.lastIndex) {
            if (s[i] == x) countX++ else countNotX++

            if (countX == countNotX) {
                num += sliceString(s.slice(i + 1..s.lastIndex))
                break
            }
        }

        return num
    }
}