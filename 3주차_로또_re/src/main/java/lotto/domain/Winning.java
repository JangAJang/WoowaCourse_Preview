package lotto.domain;

import lotto.enums.GameResult;

import java.util.HashMap;

public class Winning {

    HashMap<GameResult, Integer> winningStatistics;

    public Winning(HashMap<GameResult, Integer> inputStatistics){
        winningStatistics = inputStatistics;
    }

    public String calculateProfit(){
        return null;
    }

    private long addTotalWinning(){
        long price = 0L;
        for(GameResult resultEach : winningStatistics.keySet()){
            price += winningStatistics.get(resultEach) * resultEach.getPrice();
        }
        return price;
    }

    private long countLotto(){
        return 0L;
    }

    private long convertResultToPrice(){
        return 0L;
    }
}
