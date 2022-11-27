package lotto.enums;

public enum GameResult {

    NOTHING(0, 0L, ""),
    THREE(3, 5_000L, "3개 일치 (5,000원) - "),
    FOUR(4, 50_000L, "4개 일치 (50,000원) - "),
    FIVE(5, 1_500_000L, "5개 일치 (1,500,000원) - ") ,
    FIVE_WITH_BONUS(5, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX(6, 2_000_000_000L, "6개 일치 (2,000,000,000원) - ");


    private int count;
    private long price;
    private String comment;

    private GameResult(int count, long price, String comment){
        this.count = count;
        this.price = price;
        this.comment = comment;
    }

    public int getCount(){
        return this.count;
    }

    public long getPrice(){
        return this.price;
    }

    public String getComment(){
        return this.comment;
    }
}
