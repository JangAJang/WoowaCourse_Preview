package lotto.domain;

import lotto.enums.GameResult;

import java.util.HashMap;

public class Winning {

    HashMap<GameResult, Integer> winningStatistics;

    public Winning(HashMap<GameResult, Integer> inputStatistics){
        winningStatistics = inputStatistics;
    }

    public String calculateProfit(){
        return calculatePercent(addTotalWinning(), countLotto());
    }

    private long addTotalWinning(){
        long price = 0L;
        for(GameResult resultEach : winningStatistics.keySet()){
            price += winningStatistics.get(resultEach) * resultEach.getPrice();
        }
        return price;
    }

    private long countLotto(){
        long price = 0L;
        for(GameResult resultEach : winningStatistics.keySet()){
            price += winningStatistics.get(resultEach) * 1000;
        }
        return price;
    }

    private String calculatePercent(long price, long payment){
        return String.format("%.1f", (((double)price / (double)payment) * 100));
    }
}
