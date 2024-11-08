import kotlin.collections.HashMap

class 가장많이받은선물 {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        // 각 친구들의 선물 지수를 저장하는 맵
        val giftIndex = HashMap<String, Int>()
        // 친구들 간의 선물 교환 기록을 저장하는 맵
        val giftRecord = HashMap<String, HashMap<String, Int>>()
        val nextGift = HashMap<String, Int>()

        // 각 친구의 초기 선물 지수는 0으로 설정
        for (friend in friends) {
            giftIndex[friend] = 0
            giftRecord[friend] = HashMap()
            for (other in friends) {
                if (friend != other) {
                    giftRecord[friend]!![other] = 0
                }
            }
            nextGift[friend] = 0
        }

        // 이번달 까지 선물 기록을 처리
        gifts.forEach {
            val giverReceiver = it.split(" ")
            val giver = giverReceiver[0]
            val receiver = giverReceiver[1]
            giftRecord[giver]!![receiver] = giftRecord[giver]!![receiver]!! + 1
        }

        for (friend in friends) {
            var givenTotal = 0
            var receivedTotal = 0

            // 내가 준 모든 선물
            for (receiver in friends) {
                if (friend != receiver) {
                    givenTotal += giftRecord[friend]!![receiver]!!
                }
            }

            // 받은 모든 선물
            for (giver in friends) {
                if (friend != giver) {
                    receivedTotal += giftRecord[giver]!![friend]!!
                }
            }

            // 선물 지수 계산 (준 선물 - 받은 선물)
            giftIndex[friend] = givenTotal - receivedTotal
        }

        // 다음 달 예측
        for (i in friends.indices) {
            for (j in i + 1 until friends.size) {
                if (i == j) continue

                val friend1 = friends[i]
                val friend2 = friends[j]

                when {
                    // 주고받은 선물의 수를 비교
                    giftRecord[friend1]!![friend2]!! > giftRecord[friend2]!![friend1]!! -> {
                        nextGift[friend1] = nextGift[friend1]!! + 1
                    }

                    giftRecord[friend1]!![friend2]!! < giftRecord[friend2]!![friend1]!! -> {
                        nextGift[friend2] = nextGift[friend2]!! + 1
                    }
                    // 선물 기록이 없거나 동일할 경우, 선물 지수 비교
                    else -> {
                        when {
                            giftIndex[friend1]!! < giftIndex[friend2]!! -> {
                                nextGift[friend2] = nextGift[friend2]!! + 1
                            }

                            giftIndex[friend1]!! > giftIndex[friend2]!! -> {
                                nextGift[friend1] = nextGift[friend1]!! + 1
                            }
                            // 선물 기록과 선물 지수가 모두 동일한 경우
                            else -> {}
                        }
                    }
                }
            }
        }

        // 최대 선물 지수 반환
        return nextGift.values.maxOrNull() ?: 0
    }
}
