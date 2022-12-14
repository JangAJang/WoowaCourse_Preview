package vendingmachine;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount(){
        return this.amount;
    }

    public String getLeftStatement(int count){
        return amount + "원 - " + count + "개";
    }
}
