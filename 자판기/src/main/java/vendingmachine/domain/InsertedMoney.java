package vendingmachine.domain;

public class InsertedMoney {

    private int leftMoney;

    public InsertedMoney(int money){
        this.leftMoney = money;
    }

    public void decreaseMoney(int money){
        leftMoney -= money;
    }

    public boolean isLessThanItems(int cheapestItem){
        return false;
    }

    public int getLeftMoney(){
        return this.leftMoney;
    }
}
