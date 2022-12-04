package vendingmachine;

public enum ItemIndexing {

    NAME(0),
    PRICE(1),
    QUANTITY(2);

    private int index;

    private ItemIndexing(int index){
        this.index = index;
    }

    public int getIndex(){
        return this.index;
    }
}
