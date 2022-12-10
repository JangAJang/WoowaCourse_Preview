package vendingmachine.domainModel;

import vendingmachine.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.InsertedMoney;
import vendingmachine.domain.Items;

import java.util.HashMap;
import java.util.List;

public class VendingMachine {

    private final Coins coins;
    private Items items;
    private InsertedMoney insertedMoney;

    public VendingMachine(int money){
        coins = new Coins(money);
    }

    public HashMap<Coin, Integer> showAllCoins(){
        return coins.showAvailableCoins();
    }

    public void makeItems(List<List<String>> components){
        items = new Items(components);
    }

    public void insertMoney(int money){
        insertedMoney = new InsertedMoney(money);
    }

    public void takeProduct(String itemName){
        insertedMoney.decreaseMoney(items.takeSpecificItem(itemName));
    }

    public boolean isUnableToBuyMore(){
        return insertedMoney.isLessThanItems(items.getCheapestItem())
                || items.isAllSoldOut();
    }

    public int getLeftInsertedMoney(){
        return insertedMoney.getLeftMoney();
    }

    public HashMap<Coin, Integer> showExchange(){
        return coins.giveExchange(insertedMoney.getLeftMoney());
    }
}
