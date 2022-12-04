package vendingmachine.domainModel;

import vendingmachine.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.InsertedMoney;
import vendingmachine.domain.Items;

import java.util.HashMap;
import java.util.List;

public class VendingMachine {

    Coins coins;
    Items items;
    InsertedMoney insertedMoney;

    public VendingMachine(int money){
        coins = new Coins(money);
    }

    public HashMap<Coin, Integer> showAllCoins(){
        return new HashMap<>();
    }

    public void makeItems(List<List<String>> components){

    }

    public void insertMoney(int money){

    }

    public void takeProduct(String itemName){

    }

    public boolean isUnableToBuyMore(){
        return false;
    }

    public int getLeftInsertedMoney(){
        return 0;
    }

    public HashMap<Coin, Integer> showExchange(){
        return new HashMap<>();
    }
}
