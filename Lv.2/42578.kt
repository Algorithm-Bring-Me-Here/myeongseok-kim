import kotlin.collections.HashMap


class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        val count = HashMap<String, Int>() // 중복이 없으므로 각 의상의 종류와 해당 수량
        clothes.forEach {
            count[it[1]] = count[it[1]]?.plus(1) ?: 2
            // (2 -> 처음엔 입는다 벗는다 총 2개가 생김)
            //있다면 1을 더해줌
            // 안입는다 1 + 각각 옷에 따라 입는다 +1
        }
        //fold는 반복적으로 수행하는 매커니즘을 가짐
        //초기값을 1로하여 count 의 각 값을 돌며 해당 값들을 곱한 수치를 return 하게 된다.
        return count.values.fold(initial = 1) { acc, i -> acc * i } - 1
        //각각의 옷종류가 1 2 이라고하면 조합할수 있는 있는 수는  2 * 3 - 1 이 됨   
    }
}