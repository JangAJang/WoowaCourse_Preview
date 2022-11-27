package lotto.view;

import java.util.List;

public class OutputView {

    private static final String STARTER = "당첨통계\n---";
    private static final String BOUGHT_COUNT = "개를 구매했습니다.";

    public void printStart(){
        System.out.println(STARTER);
    }

    public void printPlayerNumber(List<List<Integer>> playerNumbers){
        System.out.println(playerNumbers.size() + BOUGHT_COUNT);
        for(List<Integer> numbersEach : playerNumbers){
            System.out.println(numbersEach);
        }
    }

    public void printResult(){

    }

    public void printProfit(){

    }
}
