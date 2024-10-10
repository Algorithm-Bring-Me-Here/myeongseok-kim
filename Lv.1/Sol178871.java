import java.util.*;
class Sol178871 {
    public String[] solution(String[] players, String[] callings) {

        HashMap< String,Integer>  map = new HashMap<>();
        for(int i = 0; i< players.length; i++)
        {
            map.put(players[i],i);
        }
        for(String temp : callings){
            int grade = map.get(temp);
            String foreplayer = players[grade-1];
            players[grade-1]= temp;
            players[grade]=foreplayer;
            map.put(foreplayer, grade);
            map.put(temp, grade-1);

        }
        return players;
    }
}