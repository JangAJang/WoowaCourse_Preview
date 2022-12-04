package vendingmachine.domain;

import java.util.List;

import static vendingmachine.ItemIndexing.*;

public class Item {

    private static final String EXCEPTION_STATEMENT = "[ERROR] 해당 품목이 품절 상태입니다";
    private static final int EMPTY = 0;

    private final int price;
    private int quantity;
    private final String name;

    public Item(List<String> components) {
        this.name = components.get(NAME.getIndex());
        this.quantity = Integer.parseInt(components.get(QUANTITY.getIndex()));
        this.price = Integer.parseInt(components.get(PRICE.getIndex()));
    }

    public void decreaseQuantity(){
        if(isSoldOut()) cannotButException();
        quantity--;
    }

    public int getPrice(){
        return this.price;
    }

    public boolean isRequestedItem(String name){
        return this.name.equals(name);
    }

    public boolean isSoldOut(){
        return quantity == EMPTY;
    }

    private void cannotButException(){
        System.out.println(EXCEPTION_STATEMENT);
        throw new IllegalArgumentException();
    }
}
