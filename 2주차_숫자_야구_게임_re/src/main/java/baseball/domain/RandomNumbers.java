package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

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
        return 1;
    }

    public int countBall(List<Integer> playerNumbers){
        return 1;
    }
}
