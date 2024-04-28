class Solution77484 {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
          var countOfUnknown = 0
          var countOfMatches = 0
  
          lottos.forEach { number ->
              if (number == 0) countOfUnknown++
              if (number in win_nums) countOfMatches++
          }
  
          val highestRank = calculateRank(countOfMatches + countOfUnknown)
          val lowestRank = calculateRank(countOfMatches)
  
          return intArrayOf(highestRank, lowestRank)
      }
  
      private fun calculateRank(matches: Int): Int {
          return when (matches) {
              6 -> 1
              5 -> 2
              4 -> 3
              3 -> 4
              2 -> 5
              else -> 6
          }
      }
  }