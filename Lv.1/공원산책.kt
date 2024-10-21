class Solution {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        var x=0
        var y=0
        //최대 길이 넣기
        var max_Height = park.size -1
        var max_Width = park[0].length -1


        //좌표값 찾아넣기
        park.forEachIndexed{ i,string->
            string.forEachIndexed{ j,c->
                if(c=='S') {
                    x=j
                    y=i
                }
            }

        }
        //명령 수행
        routes.forEach{
            var (c,dis) =it.split(" ")
            var num = dis.toInt()
            when(c){
                "E"->{
                    if(x+num <=max_Width)// 이동 후 최대값 확인
                    {var temp= true
                        for(i in x .. x+num){
                            if(park[y][i]=='X') temp=false
                        }
                        if(temp)x+=num
                    }
                }
                "S"->{
                    if(y+num<=max_Height)// 이동 후 최대값 확인
                    {
                        var temp= true
                        for(i in y .. y+num){
                            if(park[i][x]=='X') temp=false
                        }
                        if(temp) y+=num
                    }
                }
                "W"->{
                    if(x-num >=0)// 이동 후 범위
                    {
                        var temp= true
                        for(i in x-num ..x){
                            if(park[y][i]=='X') temp=false
                        }
                        if(temp) x-=num
                    }
                }
                else->{
                    //N
                    if(y-num >=0)// 이동 후 범위
                    {
                        var temp= true
                        for(i in y-num..y){
                            if(park[i][x]=='X') temp=false
                        }
                        if(temp) y-=num
                    }
                }
            }
        }
        answer +=y
        answer +=x
        return answer
    }
}