import java.util.*

class Solution {
   fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val stack = Stack<Int>()//스택에 넣어 관리
        moves.forEach {
            for (i in board.indices){ 
                if (board[i][it - 1] != 0){
                    if (stack.isNotEmpty() && (stack.peek() == board[i][it - 1])){
                        //스택에 들어 있는 값이 현재와 같다면 
                        answer += 2//2추가
                        stack.pop()//현재 스택의 top 을 내보냄
                    } else {
                        stack.push(board[i][it - 1])// 스택에 해당 값을 추가
                    }
                    board[i][it - 1] = 0//추가한 값 초기화
                    break// 다음 moves 값으로 이동 
                }
            }
        }
        return answer
    }
}