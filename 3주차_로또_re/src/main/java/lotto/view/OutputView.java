package lotto.view;

import lotto.enums.GameResult;

import java.util.HashMap;
import java.util.List;

import static lotto.enums.GameResult.*;

public class OutputView {

    private static final String STARTER = "당첨통계\n---";
    private static final String BOUGHT_COUNT = "개를 구매했습니다.";
    private static final String DOG = "개";
    private static final String TOTAL_PROFIT_IS = "총 수익률을 ";
    private static final String PERCENT = "%입니다.";

    public void printStart(){
        System.out.println(STARTER);
    }

    public void printPlayerNumber(List<List<Integer>> playerNumbers){
        System.out.println(playerNumbers.size() + BOUGHT_COUNT);
        for(List<Integer> numbersEach : playerNumbers){
            System.out.println(numbersEach);
        }
    }

    public void printResult(HashMap<GameResult, Integer> statistics){
        System.out.println(THREE.getComment() + statistics.get(THREE) + DOG);
        System.out.println(FOUR.getComment() + statistics.get(FOUR) + DOG);
        System.out.println(FIVE.getComment() + statistics.get(FIVE) + DOG);
        System.out.println(FIVE_WITH_BONUS.getComment() + statistics.get(FIVE_WITH_BONUS) + DOG);
        System.out.println(SIX.getComment() + statistics.get(SIX) + DOG);
    }

    public void printProfit(String profit){
        System.out.println(TOTAL_PROFIT_IS + profit + PERCENT);
    }
}
