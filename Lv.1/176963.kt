class Solution {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        val answer = IntArray(photo.size) // 입력받은 photo의 크기만큼의 배열이 나오기에 이에 맞게 초기화

        //map은 readonly이기에 hashmap사용하여 값을 집어넣음
        val data = HashMap<String, Int>()  // 매개변수로 받은 name 과 획득 점수(yearning)을 연결하는 Hashmap 생성

        name.forEachIndexed { index, value ->  //name과 yearing을 연결하기위해 value와 index를 통해 hashmap생성
            data[value] = yearning[index] // 각 value 를 키로 가지는 data 완성
        }

        photo.forEachIndexed {index, value ->  //answer 에 순서대로 값 추가를 위해 forEachIndexed 사용
            answer[index] = calculateNumber(data, value) // 함수를 통해 return 받은 값을 순차적으로 집어넣음
        }

        return answer
    }

    //map에 비교하여 값을 집어넣음
    private fun calculateNumber(data: Map<String, Int>, photo: Array<String>): Int {
        var result = 0
        photo.forEach {
            result += data[it] ?: 0 //data에 photo로 존재하는 값이 없을경우 0 넣음  있을경우 해당 값대로 넣음
        }
        return result //최종 결과값 반환
    }
}