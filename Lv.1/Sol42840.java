import java.util.ArrayList;
import java.util.List;

class Sol42840 {
    public int[] solution(int[] answers) {

        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        int[] score = {0,0,0};
        int maxscore=0;

        for(int i =0; i<answers.length; i++){
            if(answers[i]==first[i%first.length] ) score[0]++;
            if(answers[i]==second[i%second.length] ) score[1]++;
            if(answers[i]==third[i%third.length] ) score[2]++;
        }
        for(int j = 0; j<score.length; j++){
            if(maxscore <= score[j]) maxscore=score[j];
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (score[i] == maxscore) {
                result.add(i + 1);
            }
        }


        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;

    }
}