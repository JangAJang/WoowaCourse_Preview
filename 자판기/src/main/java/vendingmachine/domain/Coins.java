package vendingmachine.domain;

import vendingmachine.Coin;

import java.util.HashMap;

public class Coins {

    HashMap<Coin, Integer> coinCounter = new HashMap<>();

    public Coins(int price){

    }

    public HashMap<Coin, Integer> showAvailableCoins(){
        return this.coinCounter;
    }

    public HashMap<Coin, Integer> giveExchange(int amount){
        return this.coinCounter;
    }
}
