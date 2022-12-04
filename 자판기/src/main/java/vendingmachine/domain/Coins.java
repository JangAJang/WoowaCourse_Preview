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

    private int getTotal(){
        int total = 0;
        for(Coin key : coinCounter.keySet()){
            total += key.getAmount() * coinCounter.get(key);
        }
        return total;
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

    private HashMap<Coin, Integer> makeExchange(int amount){
        HashMap<Coin, Integer> exchanges = new HashMap<>();
        exchanges.put(COIN_500, calculateCountOfCoin(COIN_500, amount));
        exchanges.put(COIN_100, calculateCountOfCoin(COIN_100, amount));
        exchanges.put(COIN_50, calculateCountOfCoin(COIN_50, amount));
        exchanges.put(COIN_10, calculateCountOfCoin(COIN_10, amount));
        return exchanges;
    }

    private int calculateCountOfCoin(Coin coin, int amount){
        if(amount >= coin.getAmount()) {
            amount = amount - coin.getAmount() * Math.min(amount / coin.getAmount(), coinCounter.get(coin));
            return Math.min(amount / coin.getAmount(), coinCounter.get(coin));
        }
        return 0;
    }
}
