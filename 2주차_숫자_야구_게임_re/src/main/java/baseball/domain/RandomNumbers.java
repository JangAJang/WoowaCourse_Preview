package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RandomNumbers {

    private static final int MINIMUM_IN_RANGE = 1;
    private static final int MAXIMUM_IN_RANGE = 9;

    private final List<Integer> numbers = new ArrayList<>();

    public RandomNumbers(){
        while(numbers.size() < 3){
            numbers.add(Randoms.pickNumberInRange(MINIMUM_IN_RANGE, MAXIMUM_IN_RANGE));
        }
    }

    public int countStrike(List<Integer> playerNumbers){
        int count = 0;
        for(int index = 0; index < playerNumbers.size(); index++){
            count += getCountOfStrikeAtIndex(index, playerNumbers);
        }
        return count;
    }

    private int getCountOfStrikeAtIndex(int index, List<Integer> playerNumbers){
        if(playerNumbers.get(index).equals(numbers.get(index))) return 1;
        return 0;
    }

    public int countBall(List<Integer> playerNumbers){
        int count = 0;
        for(int index = 0; index < playerNumbers.size(); index++){
            count += getCountOfBallAtIndex(index, playerNumbers);
        }
        return count;
    }

    private int getCountOfBallAtIndex(int index, List<Integer> playerNumbers){
        if(!playerNumbers.get(index).equals(numbers.get(index))
            && numbers.contains(playerNumbers.get(index))) return 1;
        return 0;
    }
}
