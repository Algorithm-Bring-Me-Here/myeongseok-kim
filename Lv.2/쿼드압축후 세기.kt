class Solution {
    var one = 0
    var zero = 0

    fun solution(arr: Array<IntArray>): IntArray {
        quadTree(arr)
        return intArrayOf(zero, one)
    }

    fun quadTree(arr: Array<IntArray>) {
        if (checkAllSame(arr)) {
            if (arr[0][0] == 1) {
                one++
            } else {
                zero++
            }
            return
        }

        val size = arr.size / 2
        quadTree(arr.sliceArray(0 until size).map { it.sliceArray(0 until size) }.toTypedArray())
        quadTree(arr.sliceArray(0 until size).map { it.sliceArray(size until arr.size) }.toTypedArray())
        quadTree(arr.sliceArray(size until arr.size).map { it.sliceArray(0 until size) }.toTypedArray())
        quadTree(arr.sliceArray(size until arr.size).map { it.sliceArray(size until arr.size) }.toTypedArray())
    }

    // 배열이 모두 같은 값인지 확인하는 함수
    fun checkAllSame(arr: Array<IntArray>): Boolean {
        val firstValue = arr[0][0]
        for (i in arr.indices) {
            for (j in arr[i].indices) {
                if (arr[i][j] != firstValue) {
                    return false
                }
            }
        }
        return true
    }
}
