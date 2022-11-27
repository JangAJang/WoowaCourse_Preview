package lotto.enums;

public enum GameResult {

    NOTHING(0, 0L),
    THREE(3, 5_000L),
    FOUR(4, 50_000L),
    FIVE(5, 1_500_000L) ,
    FIVE_WITH_BONUS(5, 30_000_000L),
    SIX(6, 2_000_000_000L);


    private int count;
    private long price;

    private GameResult(int count, long price){
        this.count = count;
        this.price = price;
    }

    public int getCount(){
        return this.count;
    }

    public long getPrice(){
        return this.price;
    }
}
