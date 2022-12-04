package vendingmachine.view;

import vendingmachine.Coin;

import java.util.HashMap;

import static vendingmachine.Coin.*;

public class OutputView {

    public void printContainingMoney(){
        System.out.println("자판기가 보유한 동전");
    }

    public void printCoins(HashMap<Coin, Integer> coins){
        printStatementIfExist(coins, COIN_500);
        printStatementIfExist(coins, COIN_100);
        printStatementIfExist(coins, COIN_50);
        printStatementIfExist(coins, COIN_10);
    }

    private void printStatementIfExist(HashMap<Coin, Integer> coins, Coin coin){
        if(coins.containsKey(coin)) printEachCoinStatement(coin, coins.get(coin));
    }

    private void printEachCoinStatement(Coin coinEach, int quantity){
        System.out.println(coinEach.getLeftStatement(quantity));
    }

    public void printLeftMoney(int money){
        System.out.println("투입 금액: " + money + "원");
    }

    public void printLeftOver(){
        System.out.println("잔돈");
    }
}
