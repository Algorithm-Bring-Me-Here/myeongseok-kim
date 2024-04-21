class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 1  //처음 마주칠때 1번으로 세니 1로 초기화

        //각각 값을 변동할 수 있게 var 로 재선언
        var a1 = a
        var b1 = b

        // 한라운드 진행 후 서로 만난다면 멈추게 반복문
        while (calNumber(a1) != calNumber(b1)) {
            answer++ //마주친 경우 +1
            a1 = calNumber(a1) // 각각 값을 연산하여 다음 값 할당
            b1 = calNumber(b1)
        }
        return answer//최종결과 반환
    }

    // 각각 라운드 진행후 자신이 속할 조에 할당
    fun calNumber(num: Int): Int {
        if (num % 2 == 0) return num / 2
        return num / 2 + 1
    }
}
