class Solution {
        fun solution(babbling: Array<String>): Int {
            val ableRegex = "aya|ye|woo|ma".toRegex() //사용가능언어
            val unableRegex = "ayaaya|yeye|woowoo|mama".toRegex() //사용불가 언ㅓ
            //사용불가언어가 포함되지 않으며, 사용가능한 언어로 바꿨을시 비어 있어야함
            return babbling.count() {!it.contains(unableRegex) && it.replace(ableRegex, "").isEmpty()
        }
    }
}