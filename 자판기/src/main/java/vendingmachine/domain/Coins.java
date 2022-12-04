package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Coin;

import java.util.HashMap;

import static vendingmachine.Coin.*;

public class Coins {

    HashMap<Coin, Integer> coinCounter = new HashMap<>();

    public Coins(int price){
        addCoin(COIN_10, addCoin(COIN_50, addCoin(COIN_100,addCoin(COIN_500, price))));
    }

    private int addCoin(Coin coin, int price){
        coinCounter.put(coin,
                Randoms.pickNumberInRange(0, price/coin.getAmount()));
        return price - coinCounter.get(coin)*coin.getAmount();
    }

    public HashMap<Coin, Integer> showAvailableCoins(){
        return this.coinCounter;
    }

    public HashMap<Coin, Integer> giveExchange(int amount){
        return this.coinCounter;
    }

    private boolean isTotalLessThanLeftMoney(int money){
        return money > getTotal();
    }

    private HashMap<Coin, Integer> giveAll(){
        HashMap<Coin, Integer> leftCoins = new HashMap<>();
        for(Coin key : coinCounter.keySet()){
            addToLeft(leftCoins, key);
        }
        return leftCoins;
    }

    private void addToLeft(HashMap<Coin, Integer> leftCoins,Coin key){
        if(coinCounter.get(key)!=0)
            leftCoins.put(key, coinCounter.get(key));
    }

    private int getTotal(){
        int total = 0;
        for(Coin key : coinCounter.keySet()){
            total += key.getAmount() * coinCounter.get(key);
        }
        return total;
    }
}
